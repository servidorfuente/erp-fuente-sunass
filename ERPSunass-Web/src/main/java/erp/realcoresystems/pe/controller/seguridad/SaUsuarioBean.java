package erp.realcoresystems.pe.controller.seguridad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import erp.realcoresystems.pe.commons.EventosBean;
import erp.realcoresystems.pe.commons.TimeCommons;
import erp.realcoresystems.pe.commons.UtilesCommons;

import erp.realcoresystems.pe.controller.AbstractGenericBean;
import erp.realcoresystems.pe.controller.InterfaceGenericBean;
import erp.realcoresystems.pe.model.domain.MaMiscelaneosdetalle;
import erp.realcoresystems.pe.model.domain.Personamast;
import erp.realcoresystems.pe.model.domain.SySeguridadautorizaciones;
import erp.realcoresystems.pe.model.domain.Usuario;
import erp.realcoresystems.pe.model.util.IntegerUtil;
import erp.realcoresystems.pe.model.util.LongUtil;
import erp.realcoresystems.pe.server.EncriptaKeyService;
import erp.realcoresystems.pe.server.EntityGlobal;

import erp.realcoresystems.pe.model.util.FacesUtil;
import erp.realcoresystems.pe.model.util.Utiles;
import erp.realcoresystems.pe.service.*;
import erp.realcoresystems.pe.model.util.Constant;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean(name = "saUsuarioBean")
@ViewScoped
public class SaUsuarioBean extends AbstractGenericBean implements InterfaceGenericBean {

	private static final long serialVersionUID = 1L;

	private final String PAR_VAL_TIPOUSER_INT = FacesUtil.getPropertyParametros("PAR_VAL_TIPOUSER_INT");
	private final String PAR_VAL_TIPOUSER_EXT = FacesUtil.getPropertyParametros("PAR_VAL_TIPOUSER_EXT");;

	private final String DIALOG_PERSONA = "dlgPersona";
	private final String FORMULARIO_ID = "FormularioUsuario";

	@ManagedProperty(value = "#{usuarioService}")
	private UsuarioService usuarioService;

	@ManagedProperty(value = "#{maMiscelaneosdetalleService}")
	private MaMiscelaneosdetalleService maMiscelaneosdetalleService;

	@ManagedProperty(value = "#{personamastService}")
	private PersonamastService personamastService;

	@ManagedProperty(value = "#{ldapUsuarioService}")
	private LdapUsuarioService ldapUsuarioService;

	@ManagedProperty(value = "#{SySeguridadAutorizacionService}")
	private SySeguridadAutorizacionService sySeguridadAutorizacionService;

	//@ManagedProperty(value="#{encriptaKeyService}")
	//private EncriptaKeyService encriptaKeyService;
	
	private LazyDataModel<Usuario> dataModel;
	private List<Usuario> listaDataModel;

	private List<MaMiscelaneosdetalle> listadoTipoUsuario;
	private List<MaMiscelaneosdetalle> listadoTipoUsuarioReg;

	private Usuario filtro = new Usuario();
	private Usuario seleccion = new Usuario();
	private Usuario registro = new Usuario();

	private boolean visibleTipoUsuarioExterno;
	private boolean visibleCaducaClave;

	private String claveRepeticion = "";
	private String dnibusqueda = "";
	private String codtipoUserInt;
	private String codtipoUserExt;

	private EncriptaKeyService encriptaKeyService;

	public void inicializar() {
		inicializarEntidad();
		inicializarLista();
		inicializarDatoInicial();
		buscarPrincipal();
		encriptaKeyService = new EncriptaKeyService();
	}

	public void inicializarEntidad() {
		filtro = new Usuario();
		seleccion = new Usuario();
		registro = new Usuario();
	}

	public void inicializarLista() {
		listadoTipoUsuario = UtilesCommons.getCleanList(listadoTipoUsuario);

	}

	public void inicializarDatoInicial() {
		filtro.setEstado(Constant.ACTIVO);
		visibleTipoUsuarioExterno = false;
		listarComboInicial();
	}

	@Override
	public void btnBuscar() {
		buscarPrincipal();

	}

	@Override
	public void btnNuevo() {
		MODO_ACTUAL = MODO_NEW;
		setAtributosWindowsRegistro(MODO_ACTUAL);
	}

	@Override
	public void btnGuardar() {
		if (validarFormulario(registro)) {
			if (validarExistencia(registro)) {
				int result = 0;
				Usuario objSave = transformarEntidad(registro);

				if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_NEW)) {
					result = usuarioService.guardarUsuario(objSave);
					if (result > 0) {
						agregarPermisoDefecto(objSave.getUsuario());
					}
				} 
				else if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_UPDATE)) {
					result = usuarioService.actualizar(objSave);
				} 
				else if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_INACTIVAR)) {
					result = usuarioService.actualizar(objSave);
				} 
				else if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_DELETE)) {
					result = usuarioService.eliminarUsuario(objSave);
				}

				if (result > 0) {
					btnAceptar();
					buscarPrincipal();
					FacesUtil.adicionarMensajeInfo(FacesUtil.getMSJProperty("MSJ_INFO_saveCorrecto"));
				} else {
					FacesUtil.adicionarMensajeError(FacesUtil.getMSJProperty("MSJ_ERROR_noSaveCorrecto"));
				}
			}
		}
	}

	@Override
	public void btnModificar() {
		if (UtilesCommons.noEsNulo(seleccion)) {
			MODO_ACTUAL = MODO_UPDATE;
			setAtributosWindowsRegistro(MODO_ACTUAL);
		} else {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
		}
	}

	@Override
	public void btnVer() {
		if (UtilesCommons.noEsNulo(seleccion)) {
			MODO_ACTUAL = MODO_VIEW;
			setAtributosWindowsRegistro(MODO_ACTUAL);
		} else {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
		}
	}

	@Override
	public void btnEliminar() {
		if (UtilesCommons.noEsNulo(seleccion)) {
			MODO_ACTUAL = MODO_DELETE;
			setAtributosWindowsRegistro(MODO_ACTUAL);
		} else {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
		}
	}

	public void btnInactivar() {
		if (UtilesCommons.noEsNulo(seleccion)) {
			if (UtilesCommons.cadenaEnListIgnoreCase(seleccion.getEstado(), Constant.ELIMINADO, Constant.INACTIVO)) {
				FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_alreadyDisabled"));
				return;
			}
			MODO_ACTUAL = MODO_INACTIVAR;
			setAtributosWindowsRegistro(MODO_ACTUAL);
		} else {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_elementoNoSelecc"));
		}
	}

	@Override
	public void btnAceptar() {
		registro = new Usuario();
		seleccion = new Usuario();
		visibleRegistro = false;

	}

	@Override
	public void btnCancelar() {
		registro = new Usuario();
		seleccion = new Usuario();
		visibleRegistro = false;
	}

	@Override
	public void abrirRegistro() {

	}

	@Override
	public void cargarObjetoFiltros(int first, int pageSize, int counter) {
		filtro = UtilesCommons.esNulo(filtro) ? new Usuario() : filtro;
		filtro.setFlagConsultaEntGlobal("EXCEPTO");
		filtro.setUsuarioperfil(Constant.USUARIO);
		filtro.setDescripcion01(Constant.USUARIO_ADMINSYS);
		filtro.setInicio(first);
		filtro.setNumeroFilas(pageSize);
	}

	public void setAtributosWindowsRegistro(String modo) {
		super.setAtributosWindowsRegistro(modo);

		if (UtilesCommons.sonCadenasIguales(modo, MODO_NEW)) {
			dnibusqueda = null;
			claveRepeticion = null;

			registro = new Usuario();
			registro.setTipousuario(UtilesCommons.noEsVacio(PAR_VAL_TIPOUSER_EXT) ? Integer.valueOf(PAR_VAL_TIPOUSER_EXT) : Integer.valueOf(0));
			registro.setUsuarioperfil(Constant.USUARIO);
			registro.setSqllogin(Constant.ACTIVO);
			registro.setUsuariored(getUSUARIO_ACTUAL());
			registro.setAcessos(true);

			visibleTipoUsuarioExterno = (UtilesCommons.sonCadenasIguales((registro.getTipousuario() + ""), PAR_VAL_TIPOUSER_INT)) ? false : true;
			visibleCaducaClave = false;
		} else {
			dnibusqueda = null;
			claveRepeticion = null;
			registro = seleccion;

			String keyClaveDescifrada = encriptaKeyService.getDescifrado(registro.getClave());
			registro.setClave(keyClaveDescifrada);

			if (UtilesCommons.sonCadenasIguales((registro.getTipousuario() + ""), PAR_VAL_TIPOUSER_INT)) {
				visibleTipoUsuarioExterno = false;
			} else {
				visibleTipoUsuarioExterno = true;
			}

			if (!UtilesCommons.sonCadenasIguales(registro.getSqllogin(), Constant.BLOQUEADO)) {
				registro.setSqllogin(Constant.ACTIVO);
			}

			claveRepeticion = keyClaveDescifrada;
			visibleCaducaClave = UtilesCommons.obtenerValorBooleanoSiNo(registro.getExpirarpasswordflag());
			registro.setVisibled(visibleCaducaClave);
		}	

		listarComboRegistro();
	}

	public LazyDataModel<Usuario> buscarPrincipal() {
		dataModel = new LazyDataModel<Usuario>() {
			private static final long serialVersionUID = 1L;

			@Override
			public List<Usuario> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

				cargarObjetoFiltros(first, pageSize, 0);
				listaDataModel = usuarioService.UsuarioPerfilListar(filtro);
				setRowCount(usuarioService.contadorTotalesUsuario(filtro));
				setPageSize(pageSize);
				setRowIndex(first);
				return listaDataModel;
			}

			@Override
			public Usuario getRowData(String rowKey) {
				for (Usuario event : listaDataModel) {
					if (("" + event.getUsuario()).equals("" + rowKey)) {
						seleccion = (Usuario) event;
						return seleccion;
					}
				}
				return null;
			}

			@Override
			public Object getRowKey(Usuario event) {
				return event.getUsuario();
			}
		};

		return dataModel;
	}

	/** METODO PARA VALIDAR **/
	public boolean validarFormulario(Usuario objSave) {
		boolean valida = true;
		if(UtilesCommons.cadenaEnListIgnoreCase(MODO_ACTUAL, MODO_DELETE, MODO_INACTIVAR)){
			//...
		}
		else{
			
			if(UtilesCommons.esVacio(objSave.getPersona()) && 
				UtilesCommons.sonCadenasIguales(objSave.getUsuarioperfil(), Constant.USUARIO)){
				valida=false;
				FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_noSeleccPersona"));
			}
			if(! UtilesCommons.sonCadenasIguales(objSave.getClave(), claveRepeticion)){
				valida=false;
				FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_noCoincidenClaveNueva"));		
			}
			
			//Validación fecha de expiración
			if(UtilesCommons.noEsVacio(objSave.getFechaexpiracion())){
				String fechaExp = TimeCommons.imprimirDateTime(objSave.getFechaexpiracion(), TimeCommons.PATTERN_ANIO_MES_DIA);
				String fechahoy = TimeCommons.imprimirAhora(TimeCommons.PATTERN_ANIO_MES_DIA);
				
				if(UtilesCommons.noEsVacio(fechaExp)  && UtilesCommons.noEsVacio(fechahoy) ){
					Long fechaExpLong = Long.valueOf(fechaExp);
					Long fechaHoyLong = Long.valueOf(fechahoy);
					
					if(LongUtil.compareLong(fechaExpLong, fechaHoyLong) == -1 ){
						valida=false;
						FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_invalidafechaExpira"));
					}
				}
			}
 
			//Validación longitud mínima de contraseña
			if(UtilesCommons.sonCadenasIguales(PAR_VAL_TIPOUSER_EXT, (objSave.getTipousuario()+""))){
				String paramMinLongClave = getParametroMinimoLongClaves();
				int minimoLong = Integer.parseInt(paramMinLongClave);
				if(minimoLong>0){				
					if(( objSave.getClave()+"").trim().length()< minimoLong){
						valida=false;						
						FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_longMinimaClave") + "("+minimoLong+")");
					}
				}	
			}									
		}
		return valida;
	}

	public boolean validarExistencia(Usuario objSave) {
		boolean valida = true;
		Usuario filtro = new Usuario();
		filtro.setUsuario(objSave.getUsuario());
		filtro.setPersona(objSave.getPersona());
		filtro.setFlagConsultaEntGlobal("CONSULTA_VALIDAR");		
		List<Usuario> busqUsuario= usuarioService.UsuarioListar(filtro);
		if(UtilesCommons.noEsVacio(busqUsuario)){
			/** SI EL NUEVO **/
			if(UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_NEW)){
				for (Usuario usuario : busqUsuario) {
					/** VERIFICAMOS SI LOS CODIGO SON DE USUARIO **/
					if(UtilesCommons.sonCadenasIguales(objSave.getUsuarioperfil(), usuario.getUsuarioperfil())){
						if(objSave.getUsuarioperfil().equals(Utiles.CODIGO_USUARIO)){
							FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_codUsuarioRepetido"));	
						}else{							 
							FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_codPerfilRepetido"));
						}
						valida=false;
						break;
					}
					
					/** VERIFICAMOS SI LAS PERSONA **/
					if(UtilesCommons.sonCadenasIguales((usuario.getPersona()+""), (objSave.getPersona()+""))){
						if(!UtilesCommons.cadenaEnListIgnoreCase(usuario.getEstado(), Constant.ELIMINADO, Constant.INACTIVO) && 
						   !UtilesCommons.cadenaEnListIgnoreCase(objSave.getEstado(), Constant.ELIMINADO, Constant.INACTIVO)){
							valida=false;
							FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_personaRepetida"));
							break; 
						}
					}
				}
			}			
			else { 
				
				/** SI ES MODIFICAR **/
				if(UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_UPDATE)){
					for (Usuario result : busqUsuario) {
						if(!UtilesCommons.cadenaEnListIgnoreCase(result.getEstado(), Constant.ELIMINADO, Constant.INACTIVO) && 
						   !UtilesCommons.cadenaEnListIgnoreCase(objSave.getEstado(), Constant.ELIMINADO, Constant.INACTIVO)){
							if( UtilesCommons.sonCadenasIguales((result.getPersona()+""),(""+objSave.getPersona())) && 
								!UtilesCommons.sonCadenasIguales(result.getUsuario(), objSave.getUsuario())){
								valida=false;
								FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_personaRepetida"));
								break;
							}							
						}
					}
				}
			}
			
		}
		return valida;
	}

	/** METODO PARA BUSCADORES **/
	public void btnBuscarPersona() {
		try {
			/** (1:)Param. BEAN DEL SELECCIONADOR Y ATRIBUTOS A LIMPIAR */
			Personamast obj1 = (Personamast) getGenericObjectBean("dataSeleccionadorPersonaBean",
					"personaEntidadSeleccionFiltro", Personamast.class);
			obj1.setNombrecompleto(null);
			obj1.setDescripcion01("Formulario");// AUX PARA EL PADRE FORM
			/********** SET FILTROS *******/
			obj1.setEscliente(false);
			obj1.setEsempleado(false);
			obj1.setTipopersona(Constant.PERSONA_NATURAL);
			obj1.setEstado(Constant.ACTIVO);
			obj1.setDescripcion02("User en general");

			/************************************************/

			/** (2:)Param. BEAN DEL SELECCIONADOR Y ATRIBUTO EVENTO */
			EventosBean obj = getGenericEventoBean("dataSeleccionadorPersonaBean", "eventoSeleccion");
			obj.setEventoSeleccionPersonamast(new EventosBean.EventoSeleccionPersonamast() {
				@Override
				public void retornoSeleccion(Personamast personamast, String mensaje) {
					if (UtilesCommons.noEsNulo(personamast)) {
						eventoSeleccionPersona(personamast);
						FacesUtil.update("FormularioUsuario:opSeccionReg");
						FacesUtil.executeSecure("PF('" + DIALOG_PERSONA + "').hide();");
					} else {
						FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_noSeleccPersona"));
					}
				}
			});

			FacesUtil.executeSecure("inicializarBPersona(); PF('" + DIALOG_PERSONA + "').show();");

		} catch (Exception ex) {
			ex.printStackTrace();
			FacesUtil.mensajeErrorAbrirBuscador();
		}
	}

	public void btnBuscarDNI() {
		// SOLO PARA USUARIO INTERNO
		if (UtilesCommons.noEsVacio(dnibusqueda)) {
			registro.setPersona(null);
			registro.setNombre(null);
			List<Personamast> busqPersonamast = personamastService.obtenerPersonaPorDocumento(0, dnibusqueda);// OBS//

			if (UtilesCommons.noEsVacio(busqPersonamast)) {
				if (UtilesCommons.esUnicoValor(busqPersonamast)) {
					Personamast personamast = UtilesCommons.obtenerPrimerElementoLista(busqPersonamast);
					if (UtilesCommons.sonCadenasIguales(Constant.ACTIVO, personamast.getEstado())) {
						eventoSeleccionPersona(personamast);
					} else {
						FacesUtil.adicionarMensajeWarning(
								FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_noExistePersonaActiva"));
					}
				} else if (busqPersonamast.size() > 1) {
					FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_existeMasPersonaDNI"));
					registro.setVisibled(false);
					visibleCaducaClave = false;
				} else if (busqPersonamast.size() == 0) {
					FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_noExistePersonaDNI"));
					registro.setVisibled(false);
					visibleCaducaClave = false;
				}
			} else {
				FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_noExistePersonaDNI"));
			}
		} else {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("REQUIRED_USUARIO_DNI"));
		}
	}

	/**
	 * Evento que perm0ite validar el usuario ingresado con el Directorio activo
	 */
	public void btnBuscarLDAP() {
		// SOLO PARA USUARIO INTERNO
		if (UtilesCommons.noEsVacio(registro.getUsuario())) {
			if (UtilesCommons.sonCadenasIguales((registro.getTipousuario() + ""), PAR_VAL_TIPOUSER_INT)) {
				// BUSCAR CONFIG DE LDAP
				try {
					MaMiscelaneosdetalle obj = new MaMiscelaneosdetalle();
					obj.setAplicacioncodigo(Constant.APLICACION_CODIGO);
					obj.setCompania(Constant.COMPANIA_999999);
					obj.setCodigotabla(Constant.MISCELANEO_DETALLE_USUARIO_LDAP);
					obj.setEstado(Constant.ACTIVO);
					List<MaMiscelaneosdetalle> listadoLDAP = maMiscelaneosdetalleService.listarElementos(obj);
					if (UtilesCommons.noEsVacio(listadoLDAP)) {
						if (listadoLDAP.size() > 0) {
							// UTILIZAR PRIMER POR DEFECTO
							MaMiscelaneosdetalle ldap = UtilesCommons.obtenerPrimerElementoLista(listadoLDAP);

							if (UtilesCommons.noEsVacio(ldap.getValorcodigo3())) {// SERVER
																					// :LDAP
																					// URL
								if (UtilesCommons.noEsVacio(ldap.getValorcodigo4())) {// BASE
																						// BUSQUEDA
																						// ORGANIZACION
																						// UNIT
									if (UtilesCommons.noEsVacio(ldap.getValorcodigo1())) {
										String vector[] = null;
										// if(ldap.getValorcodigo1()!=null){
										vector = ldap.getValorcodigo1().split("@");
										// }
										if (vector != null) {
											if (vector.length == 2) {
												// REALIZAR VALIDACIÓN LDAP
												Usuario usuarioFiltroLDAP = new Usuario();
												usuarioFiltroLDAP.setLdapUrl(ldap.getValorcodigo3());
												usuarioFiltroLDAP.setPrinciple(ldap.getValorcodigo1());
												usuarioFiltroLDAP.setPassword(ldap.getValorcodigo2());
												usuarioFiltroLDAP.setOrganizationalUnit(ldap.getValorcodigo4());
												usuarioFiltroLDAP.setUsuario(registro.getUsuario());
												usuarioFiltroLDAP = ldapUsuarioService
														.UsuarioBuscarLdap(usuarioFiltroLDAP);
												if (usuarioFiltroLDAP != null) {
													FacesUtil.adicionarMensajeInfo(FacesUtil
															.getMSJProperty("MSJ_INFO_USAURIO_SiExisteActiveDir"));
													// Buscar persona en BD
													Personamast objBusqu = new Personamast();
													// BUSCAR POR CORREO
													// INSTITUCIONAL
													String correo = (vector[1] + "").trim();
													correo = (registro.getUsuario() + "").trim() + "@" + correo;
													// String correo =
													// usuarioFiltroLDAP.getEmail();
													// //PODRÍA FALLAR
													objBusqu.setEsempleado(true);
													objBusqu.setCorreoinstitucional(correo);
													List<Personamast> listaPersona = personamastService
															.listarElementos(objBusqu);

													if (UtilesCommons.noEsVacio(listaPersona)) {
														if (UtilesCommons.esUnicoValor(listaPersona)) {
															/**
															 * Obtenemos el
															 * primer elemento
															 * de persona
															 **/
															Personamast personamast = UtilesCommons
																	.obtenerPrimerElementoLista(listaPersona);

															if (UtilesCommons.sonCadenasIguales(Constant.ACTIVO,
																	personamast.getEstado())) {
																registro.setPersona(personamast.getPersona());
																registro.setNombre(personamast.getNombrecompleto());
																// FacesUtil.adicionarMensajeInfo(FacesUtil.getMSJProperty("MSJ_INFO_USAURIO_SiExisteActiveDir"));
															} else {
																// FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_noExistePersonaActiva"));
															}
														} else if (listaPersona.size() == 0) {
															// FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_noExistePersonaCorreo"));
														} else if (listaPersona.size() > 1) {
															// FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_existeMasPersonasCorreo"));
														}
													} else {
														// FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_noExistePersonaCorreo"));
													}
												} else {
													FacesUtil.adicionarMensajeWarning(FacesUtil
															.getMSJProperty("MSJ_WARN_USAURIO_noExisteActiveDir"));
												}
											} else {
												FacesUtil.adicionarMensajeWarning(FacesUtil
														.getMSJProperty("MSJ_WARN_login_LDAP_NoValidoCorreoAdmin"));
											}
										} else {
											FacesUtil.adicionarMensajeWarning(FacesUtil
													.getMSJProperty("MSJ_WARN_login_LDAP_NoExisteCorreoAdmin"));
										}
									} else {
										FacesUtil.adicionarMensajeWarning(
												FacesUtil.getMSJProperty("MSJ_WARN_login_LDAP_NoExisteCorreoAdmin"));
									}
								} else {
									FacesUtil.adicionarMensajeWarning(
											FacesUtil.getMSJProperty("MSJ_WARN_login_LDAP_NoExisteServerConfig"));
								}
							} else {
								FacesUtil.adicionarMensajeWarning(
										FacesUtil.getMSJProperty("MSJ_WARN_login_LDAP_NoExisteDominioConfig"));
							}
						} else {
							FacesUtil.adicionarMensajeWarning(
									FacesUtil.getMSJProperty("MSJ_WARN_login_LDAP_NoExisteConfiguracion"));
						}
					} else {
						FacesUtil.adicionarMensajeWarning(
								FacesUtil.getMSJProperty("MSJ_WARN_login_LDAP_NoExisteConfiguracion"));
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					FacesUtil.adicionarMensajeError(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_LDAP_NoObtencionUser"));
				}
			}
		} else {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_login_LDAP_INGRESA_USAURIO"));
		}
	}

	/** METODO PARA SELECCIONAR **/
	public void seleccionarTipoUsuario() {
		if (UtilesCommons.sonCadenasIguales((registro.getTipousuario() + ""), PAR_VAL_TIPOUSER_INT)) {
			visibleTipoUsuarioExterno = false;
			if (UtilesCommons.cadenaEnListIgnoreCase(MODO_ACTUAL, MODO_NEW, MODO_UPDATE)) {
				registro.setExpirarpasswordflag(null);
				registro.setFechaexpiracion(null);
				registro.setVisibled(false);
				registro.setClave(null);
				claveRepeticion = null;
				visibleCaducaClave = false;
			}
			if (UtilesCommons.noEsVacio(registro.getUsuario())) {
				btnBuscarLDAP();
			}
		} else {
			visibleTipoUsuarioExterno = true;
		}
	}

	public void seleccionarCheckExpiraClave() {
		if (registro.isVisibled()) {
			visibleCaducaClave = true;
		} else {
			registro.setFechaexpiracion(null);
			visibleCaducaClave = false;
		}
	}

	/** METODO PARA LISTAR **/
	public void listarComboInicial() {
		listadoTipoUsuario = listarMiscelaneosDetalle(null, Constant.MISCELANEO_DETALLE_USUARIO_TIPO_USUARIO);
	}

	public void listarComboRegistro() {
		listadoTipoUsuarioReg = listarMiscelaneosDetalle(null, Constant.MISCELANEO_DETALLE_USUARIO_TIPO_USUARIO);
	}

	public List<MaMiscelaneosdetalle> listarMiscelaneosDetalle(String valorcodigo1, String codigotabla) {
		MaMiscelaneosdetalle filtro = new MaMiscelaneosdetalle();
		filtro.setAplicacioncodigo(Constant.APLICACION_CODIGO);
		filtro.setCompania(Constant.COMPANIA_999999);
		filtro.setEstado(Constant.ACTIVO);
		filtro.setValorcodigo1(valorcodigo1);
		filtro.setCodigotabla(codigotabla);
		return maMiscelaneosdetalleService.listarElementos(filtro);
	}

	/** METODO SECUNDARIO **/
	public Usuario transformarEntidad(Usuario registro) {

		if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_INACTIVAR)) {
			registro.setExpirarpasswordflag(UtilesCommons.obtenerValorStringSiNo(registro.isVisibled()));
			registro.setClave(encriptaKeyService.getCifrado(registro.getClave()));
			registro.setEstado(Constant.INACTIVO);
			registro.setUltimousuario(getUSUARIO_ACTUAL());
			registro.setUltimafechamodif(new Date());
		} else {
			/** SETEAMOS VALORES POR DEFECTO **/
			registro.setUsuarioperfil(Constant.USUARIO);
			registro.setSqlpassword(Constant.ACTIVO);
			registro.setExpirarpasswordflag(UtilesCommons.obtenerValorStringSiNo(registro.isVisibled()));
			registro.setTipousuario(IntegerUtil.getInteger(registro.getTipousuario()));
			registro.setClave(encriptaKeyService.getCifrado(registro.getClave()));
			registro.setUsuario(UtilesCommons.noEsVacio(registro.getUsuario()) ? registro.getUsuario().toUpperCase()
					: registro.getUsuario());

			/** EN CASO EL SQL LOGIN NO ESTE BLOQUEADO **/
			if (!UtilesCommons.sonCadenasIguales(Constant.BLOQUEADO, registro.getSqllogin())) {
				registro.setNumerologinsusados(Integer.valueOf(0));
				registro.setSqllogin(Constant.ACTIVO);
			}

			if (UtilesCommons.sonCadenasIguales(MODO_ACTUAL, MODO_NEW)) {
				if (UtilesCommons.sonCadenasIguales(PAR_VAL_TIPOUSER_EXT, (registro.getTipousuario() + ""))) {
					registro.setSqlpassword(Constant.EST_CAMBIAR_CLAVE_db);
				}
				registro.setUsuariored(getUSUARIO_ACTUAL());
				registro.setSidOracleFecha(new Date());
			} else {
				registro.setUltimousuario(getUSUARIO_ACTUAL());
				registro.setUltimafechamodif(new Date());
			}
		}

		return registro;
	}

	/** Agregar PERMISOS POR DEFECTO al usuario NUEVO */
	public boolean agregarPermisoDefecto(String usuarioActual) {
		boolean result = false;
		try {
			// PERMISOS DE COMPAÑÍA
			String codSucursal = EntityGlobal.getInstance().getCodigoSucursal();
			String codCompania = EntityGlobal.getInstance().getCodigoCompanyowner();
			List<SySeguridadautorizaciones> listaAutorizaCompa = new ArrayList<SySeguridadautorizaciones>();
			SySeguridadautorizaciones objAutorizaCompa = new SySeguridadautorizaciones();
			objAutorizaCompa.setAplicacioncodigo(Constant.APLICACION_CODIGO);
			objAutorizaCompa.setGrupo(Constant.SUCURSAL);
			objAutorizaCompa.setConcepto(codSucursal);
			objAutorizaCompa.setConceptoMaster(codCompania);
			objAutorizaCompa.setEstado(Constant.ACTIVO);
			objAutorizaCompa.setUsuario(usuarioActual);
			objAutorizaCompa.setUltimousuario(getUSUARIO_ACTUAL());
			objAutorizaCompa.setUltimafechamodif(Utiles.getFechaHoy());
			listaAutorizaCompa.add(objAutorizaCompa);
			int res = sySeguridadAutorizacionService.guardarSeguridadAutorizaciones(listaAutorizaCompa,
					new SySeguridadautorizaciones());
			if (res > 0) {
				result = true;
			} else {
				FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_noAddPermisosDefault"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public void eventoSeleccionPersona(Personamast seleccion) {
		if (UtilesCommons.noEsVacio(seleccion.getDocumento())) {
			registro.setPersona(seleccion.getPersona());
			registro.setNombre(seleccion.getNombrecompleto());
			// SÓLO PARA USUARIOS EXTERNOS
			if (UtilesCommons.sonCadenasIguales((PAR_VAL_TIPOUSER_EXT + ""), ("" + registro.getTipousuario()))) {
				String claveGenerada = encriptaKeyService.getKeyGenerado_Cifrado(false);
				registro.setUsuario(seleccion.getDocumento());
				registro.setClave(claveGenerada);
				claveRepeticion = claveGenerada;
				Date fechaCaduca = generarFechaVigenciaUsuario();
				visibleCaducaClave = true;
				registro.setExpirarpasswordflag(Constant.SI_db);
				if (UtilesCommons.noEsNulo(fechaCaduca )) {
					registro.setFechaexpiracion(fechaCaduca);
				} else {
					registro.setFechaexpiracion(Utiles.fechaMasNumeroDias(Utiles.getFechaHoy(), 5));
					FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_noSeleccPersonaConVigencia"));
				}
				registro.setVisibled(true);
			} else {
				registro.setVisibled(false);
				visibleCaducaClave = false;
			}
		} else {
			FacesUtil.adicionarMensajeWarning(FacesUtil.getMSJProperty("MSJ_WARN_USAURIO_noSeleccPersonaConDocum"));
		}

	}

	public Date generarFechaVigenciaUsuario() {
		Date fechaCaduca = null;
		// OBTENER LA FECHA DE VIGENCIA DE LOS REGISTROS DE ALGÚN CURSO O
		// PROGRAMA
		return fechaCaduca;
	}

	public void updateForm(String... componenteIds) {
		if (UtilesCommons.esVacio(componenteIds)) {
			FacesUtil.update(FORMULARIO_ID);
		} else {
			int index = -1;
			String[] array = new String[componenteIds.length];
			for (String string : componenteIds) {
				index++;
				array[index] = UtilesCommons.noEsVacio(string) ? FORMULARIO_ID + ":" + string : string;
			}
			FacesUtil.update(array);
		}
	}

	/** GET - SET **/
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public Usuario getFiltro() {
		return filtro;
	}

	public void setFiltro(Usuario filtro) {
		this.filtro = filtro;
	}

	public Usuario getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(Usuario seleccion) {
		this.seleccion = seleccion;
	}

	public Usuario getRegistro() {
		return registro;
	}

	public void setRegistro(Usuario registro) {
		this.registro = registro;
	}

	public LazyDataModel<Usuario> getDataModel() {
		return dataModel;
	}

	public void setDataModel(LazyDataModel<Usuario> dataModel) {
		this.dataModel = dataModel;
	}

	public List<Usuario> getListaDataModel() {
		return listaDataModel;
	}

	public void setListaDataModel(List<Usuario> listaDataModel) {
		this.listaDataModel = listaDataModel;
	}

	public MaMiscelaneosdetalleService getMaMiscelaneosdetalleService() {
		return maMiscelaneosdetalleService;
	}

	public void setMaMiscelaneosdetalleService(MaMiscelaneosdetalleService maMiscelaneosdetalleService) {
		this.maMiscelaneosdetalleService = maMiscelaneosdetalleService;
	}

	public List<MaMiscelaneosdetalle> getListadoTipoUsuario() {
		return listadoTipoUsuario;
	}

	public void setListadoTipoUsuario(List<MaMiscelaneosdetalle> listadoTipoUsuario) {
		this.listadoTipoUsuario = listadoTipoUsuario;
	}

	public List<MaMiscelaneosdetalle> getListadoTipoUsuarioReg() {
		return listadoTipoUsuarioReg;
	}

	public void setListadoTipoUsuarioReg(List<MaMiscelaneosdetalle> listadoTipoUsuarioReg) {
		this.listadoTipoUsuarioReg = listadoTipoUsuarioReg;
	}

	public String getClaveRepeticion() {
		return claveRepeticion;
	}

	public void setClaveRepeticion(String claveRepeticion) {
		this.claveRepeticion = claveRepeticion;
	}

	public boolean isVisibleTipoUsuarioExterno() {
		return visibleTipoUsuarioExterno;
	}

	public void setVisibleTipoUsuarioExterno(boolean visibleTipoUsuarioExterno) {
		this.visibleTipoUsuarioExterno = visibleTipoUsuarioExterno;
	}

	public PersonamastService getPersonamastService() {
		return personamastService;
	}

	public void setPersonamastService(PersonamastService personamastService) {
		this.personamastService = personamastService;
	}

	public String getDnibusqueda() {
		return dnibusqueda;
	}

	public void setDnibusqueda(String dnibusqueda) {
		this.dnibusqueda = dnibusqueda;
	}

	public boolean isVisibleCaducaClave() {
		return visibleCaducaClave;
	}

	public void setVisibleCaducaClave(boolean visibleCaducaClave) {
		this.visibleCaducaClave = visibleCaducaClave;
	}

	public LdapUsuarioService getLdapUsuarioService() {
		return ldapUsuarioService;
	}

	public void setLdapUsuarioService(LdapUsuarioService ldapUsuarioService) {
		this.ldapUsuarioService = ldapUsuarioService;
	}

	public String getPAR_VAL_TIPOUSER_INT() {
		return PAR_VAL_TIPOUSER_INT;
	}

	public String getPAR_VAL_TIPOUSER_EXT() {
		return PAR_VAL_TIPOUSER_EXT;
	}

	public String getCodtipoUserInt() {
		codtipoUserInt = FacesUtil.getPropertyParametros("PAR_VAL_TIPOUSER_INT");
		return codtipoUserInt;
	}

	public void setCodtipoUserInt(String codtipoUserInt) {
		this.codtipoUserInt = codtipoUserInt;
	}

	public String getCodtipoUserExt() {
		codtipoUserExt = FacesUtil.getPropertyParametros("PAR_VAL_TIPOUSER_EXT");
		return codtipoUserExt;
	}

	public void setCodtipoUserExt(String codtipoUserExt) {
		this.codtipoUserExt = codtipoUserExt;
	}

	public SySeguridadAutorizacionService getSySeguridadAutorizacionService() {
		return sySeguridadAutorizacionService;
	}

	public void setSySeguridadAutorizacionService(SySeguridadAutorizacionService sySeguridadAutorizacionService) {
		this.sySeguridadAutorizacionService = sySeguridadAutorizacionService;
	}

	public EncriptaKeyService getEncriptaKeyService() {
		return encriptaKeyService;
	}

	public void setEncriptaKeyService(EncriptaKeyService encriptaKeyService) {
		this.encriptaKeyService = encriptaKeyService;
	}

	
	
}



