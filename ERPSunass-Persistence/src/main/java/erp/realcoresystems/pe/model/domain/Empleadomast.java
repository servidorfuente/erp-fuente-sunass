package erp.realcoresystems.pe.model.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

import erp.realcoresystems.pe.model.util.Utiles;

import java.util.Date;

@SuppressWarnings("serial")
@Entity
public class Empleadomast  extends Entidad{
	
    private Integer empleado;/** Id de PersonamastAnter **/
    private String companiasocio;
    private String actividad;
    private String afe;
    private Integer aprobadornivelacion;
    private String asignacionfamiliar;
    private String bancocts;
    private String budgetcategory;
    private String cargo;
    private String carnetasistenciasocial;
    private String categoriaocupacional;
    private String centroasistenciasocial;
    private String centrocostos;
    private String codigoafp;
    private Integer codigocargo;
    private Integer codigounidad;
    private String codigousuario;
    private String condicionLaboral;
    private Integer contratista;
    private String correointerno;
    private String departamentooperacional;
    private String departamentoorganizacional;
    private String deptoorganizacion;
    private Integer empleadorelacionado;
    private Integer empleadorepresentante;
    private String establecimientortps;
    private String estado;
    private String estadoempleado;
    private String estadonivelacion;
    private Date fechabajaeps;
    private Date fechacese;
    private Date fechafincontrato;
    private Date fechaingreso;
    private Date fechainiciocontrato;
    private Date fechainiciopension;
    private Date fechaliquidacion;
    private Date fechareingreso;
    private Date fechaterminopension;
    private Date fechaultimaplanilla;
    private Date fechavacaciones;
    private String firmadigitalizada;
    private String flagacctrabajo;
    private String flagasegurapension;
    private String flagcentroformacion;
    private String flagcomision;
    private String flagconveniodobletrib;
    private String flagcooperativa;
    private String flagdeconfianza;
    private String flagdiscapacidad;
    private String flagdomiciliado;
    private String flaghorarionocturno;
    private String flagimpuestorenta;
    private String flagipssvida;
    private String flagjefedepartamento;
    private String flagjornadamaxima;
    private String flagmadreresponsabilidad;
    private String flagotrosquinta;
    private String flagporcentaje;
    private String flagquintaexonerada;
    private String flagregimenalternativo;
    private String flagreingresos;
    private String flagretencionjudicial;
    private String flagsctrpension;
    private String flagsctrsalud;
    private String flagsindicalizado;
    private String flagsindicato;
    private String flagsmf;
    private String flagsujetocontrol;
    private String flagtrabajadorpensionista;
    private String formato2;
    private String foto;
    private Integer gerencia;
    private String gradosalario;
    private Integer grupoocupacional;
    private Double horalectiva;
    private Integer jefedepartamento;
    private Integer jefeunidad;
    private String locacionasignada;
    private String locaciondepago;
    private String monedapago;
    private Integer motivocese;
    private String municipalidadnacimiento;
    private String nivel;
    private String nivelacceso;
    private String niveleducativortps;
    private String nivelsalario;
    private String numeroafp;
    private String numeroarchivo;
    private String numerocuentacts;
    private String ordenservicio;
    private Integer perfil;
    private String planta;
    private Integer plantillaconcepto;
    private Integer porcentaje;
    private String posicion;
    private Integer posicionorganigrama;
    private String prestadorservicio;
    private Integer proveedorintermediacion;
    private String provincia;
    private String raza;
    private String razoncese;
    private Double redondeoacuenta;
    private String religion;
    private String responsableempleado;
    private String responsablejefe;
    private String responsablesueldo;
    private Integer responsableunidad;
    private String ruccentroasistenciasocial;
    private Date serviciomilitardesde;
    private Date serviciomilitarhasta;
    private String situacionespecial;
    private Integer solicitadornivelacion;
    private Integer subgerencia;
    private String sucursal;
    private Integer sueldoactualdolar;
    private Integer sueldoactuallocal;
    private Integer sueldoanteriordolar;
    private Integer sueldoanteriorlocal;
    private String tarjetadecredito;
    private String tipoasistenciasocial;
    private String tipocarnetasistenciasocial;
    private String tipocontrato;
    private String tipocuentacts;
    private Integer tipohorario;
    private String tipomodalidadformativa;
    private String tipomonedacts;
    private String tipopago;
    private String tipoPagohora;
    private String tipopension;
    private String tipopensionjubilacion;
    private String tipoplanilla;
    private String tipoplanillaop;
    private String tiporemuneracionrtps;
    private String tipotrabajador;
    private String tipovisa;
    private Date ultimafechamodif;
    private Date ultimafechapagovacacion;
    private String ultimousuario;
    private Integer uneunegocioid;
    private String unidadnegocioasignada;
    private String unidadreplicacion;
    private Date visafechaexpiracion;
    private Date visafechainicio;
    /**Transient**/
    private SaDependencias organigrama;
    @Transient
    private boolean envioCorreo;
    
    @Id
    @Column(name = "EMPLEADO")
    public Integer getEmpleado() {
        return empleado;
    }
    
    @Basic
    @Column(name = "COMPANIASOCIO")
    public String getCompaniasocio() {
        return companiasocio;
    }
    
    @Basic
    @Column(name = "ACTIVIDAD")
    public String getActividad() {
        return actividad;
    }

    @Basic
    @Column(name = "AFE")
    public String getAfe() {
        return afe;
    }

    @Basic
    @Column(name = "APROBADORNIVELACION")
    public Integer getAprobadornivelacion() {
        return aprobadornivelacion;
    }

    @Basic
    @Column(name = "ASIGNACIONFAMILIAR")
    public String getAsignacionfamiliar() {
        return asignacionfamiliar;
    }

    @Basic
    @Column(name = "BANCOCTS")
    public String getBancocts() {
        return bancocts;
    }

    @Basic
    @Column(name = "BUDGETCATEGORY")
    public String getBudgetcategory() {
        return budgetcategory;
    }

    @Basic
    @Column(name = "CARGO")
    public String getCargo() {
        return cargo;
    }

    @Basic
    @Column(name = "CARNETASISTENCIASOCIAL")
    public String getCarnetasistenciasocial() {
        return carnetasistenciasocial;
    }

    @Basic
    @Column(name = "CATEGORIAOCUPACIONAL")
    public String getCategoriaocupacional() {
        return categoriaocupacional;
    }

    @Basic
    @Column(name = "CENTROASISTENCIASOCIAL")
    public String getCentroasistenciasocial() {
        return centroasistenciasocial;
    }

    @Basic
    @Column(name = "CENTROCOSTOS")
    public String getCentrocostos() {
        return centrocostos;
    }

    @Basic
    @Column(name = "CODIGOAFP")
    public String getCodigoafp() {
        return codigoafp;
    }

    @Basic
    @Column(name = "CODIGOCARGO")
    public Integer getCodigocargo() {
        return codigocargo;
    }

    @Basic
    @Column(name = "CODIGOUNIDAD")
    public Integer getCodigounidad() {
        return codigounidad;
    }

    @Basic
    @Column(name = "CODIGOUSUARIO")
    public String getCodigousuario() {
        return codigousuario;
    }

    @Basic
    @Column(name = "CONDICION_LABORAL")
    public String getCondicionLaboral() {
        return condicionLaboral;
    }

    @Basic
    @Column(name = "CONTRATISTA")
    public Integer getContratista() {
        return contratista;
    }

    @Basic
    @Column(name = "CORREOINTERNO")
    public String getCorreointerno() {
        return correointerno;
    }

    @Basic
    @Column(name = "DEPARTAMENTOOPERACIONAL")
    public String getDepartamentooperacional() {
        return departamentooperacional;
    }

    @Basic
    @Column(name = "DEPARTAMENTOORGANIZACIONAL")
    public String getDepartamentoorganizacional() {
        return departamentoorganizacional;
    }

    @Basic
    @Column(name = "DEPTOORGANIZACION")
    public String getDeptoorganizacion() {
        return deptoorganizacion;
    }

    @Basic
    @Column(name = "EMPLEADORELACIONADO")
    public Integer getEmpleadorelacionado() {
        return empleadorelacionado;
    }

    @Basic
    @Column(name = "EMPLEADOREPRESENTANTE")
    public Integer getEmpleadorepresentante() {
        return empleadorepresentante;
    }

    @Basic
    @Column(name = "ESTABLECIMIENTORTPS")
    public String getEstablecimientortps() {
        return establecimientortps;
    }

    @Basic
    @Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    @Basic
    @Column(name = "ESTADOEMPLEADO")
    public String getEstadoempleado() {
        return estadoempleado;
    }

    @Basic
    @Column(name = "ESTADONIVELACION")
    public String getEstadonivelacion() {
        return estadonivelacion;
    }

    @Basic
    @Column(name = "FECHABAJAEPS")
    public Date getFechabajaeps() {
        return fechabajaeps;
    }

    @Basic
    @Column(name = "FECHACESE")
    public Date getFechacese() {
        return fechacese;
    }

    @Basic
    @Column(name = "FECHAFINCONTRATO")
    public Date getFechafincontrato() {
        return fechafincontrato;
    }

    @Basic
    @Column(name = "FECHAINGRESO")
    public Date getFechaingreso() {
        return fechaingreso;
    }

    @Basic
    @Column(name = "FECHAINICIOCONTRATO")
    public Date getFechainiciocontrato() {
        return fechainiciocontrato;
    }

    @Basic
    @Column(name = "FECHAINICIOPENSION")
    public Date getFechainiciopension() {
        return fechainiciopension;
    }

    @Basic
    @Column(name = "FECHALIQUIDACION")
    public Date getFechaliquidacion() {
        return fechaliquidacion;
    }

    @Basic
    @Column(name = "FECHAREINGRESO")
    public Date getFechareingreso() {
        return fechareingreso;
    }

    @Basic
    @Column(name = "FECHATERMINOPENSION")
    public Date getFechaterminopension() {
        return fechaterminopension;
    }

    @Basic
    @Column(name = "FECHAULTIMAPLANILLA")
    public Date getFechaultimaplanilla() {
        return fechaultimaplanilla;
    }

    @Basic
    @Column(name = "FECHAVACACIONES")
    public Date getFechavacaciones() {
        return fechavacaciones;
    }

    @Basic
    @Column(name = "FIRMADIGITALIZADA")
    public String getFirmadigitalizada() {
        return firmadigitalizada;
    }

    @Basic
    @Column(name = "FLAGACCTRABAJO")
    public String getFlagacctrabajo() {
        return flagacctrabajo;
    }

    @Basic
    @Column(name = "FLAGASEGURAPENSION")
    public String getFlagasegurapension() {
        return flagasegurapension;
    }

    @Basic
    @Column(name = "FLAGCENTROFORMACION")
    public String getFlagcentroformacion() {
        return flagcentroformacion;
    }

    @Basic
    @Column(name = "FLAGCOMISION")
    public String getFlagcomision() {
        return flagcomision;
    }

    @Basic
    @Column(name = "FLAGCONVENIODOBLETRIB")
    public String getFlagconveniodobletrib() {
        return flagconveniodobletrib;
    }

    @Basic
    @Column(name = "FLAGCOOPERATIVA")
    public String getFlagcooperativa() {
        return flagcooperativa;
    }

    @Basic
    @Column(name = "FLAGDECONFIANZA")
    public String getFlagdeconfianza() {
        return flagdeconfianza;
    }

    @Basic
    @Column(name = "FLAGDISCAPACIDAD")
    public String getFlagdiscapacidad() {
        return flagdiscapacidad;
    }

    @Basic
    @Column(name = "FLAGDOMICILIADO")
    public String getFlagdomiciliado() {
        return flagdomiciliado;
    }

    @Basic
    @Column(name = "FLAGHORARIONOCTURNO")
    public String getFlaghorarionocturno() {
        return flaghorarionocturno;
    }

    @Basic
    @Column(name = "FLAGIMPUESTORENTA")
    public String getFlagimpuestorenta() {
        return flagimpuestorenta;
    }

    @Basic
    @Column(name = "FLAGIPSSVIDA")
    public String getFlagipssvida() {
        return flagipssvida;
    }

    @Basic
    @Column(name = "FLAGJEFEDEPARTAMENTO")
    public String getFlagjefedepartamento() {
        return flagjefedepartamento;
    }

    @Basic
    @Column(name = "FLAGJORNADAMAXIMA")
    public String getFlagjornadamaxima() {
        return flagjornadamaxima;
    }

    @Basic
    @Column(name = "FLAGMADRERESPONSABILIDAD")
    public String getFlagmadreresponsabilidad() {
        return flagmadreresponsabilidad;
    }

    @Basic
    @Column(name = "FLAGOTROSQUINTA")
    public String getFlagotrosquinta() {
        return flagotrosquinta;
    }

    @Basic
    @Column(name = "FLAGPORCENTAJE")
    public String getFlagporcentaje() {
        return flagporcentaje;
    }

    @Basic
    @Column(name = "FLAGQUINTAEXONERADA")
    public String getFlagquintaexonerada() {
        return flagquintaexonerada;
    }

    @Basic
    @Column(name = "FLAGREGIMENALTERNATIVO")
    public String getFlagregimenalternativo() {
        return flagregimenalternativo;
    }

    @Basic
    @Column(name = "FLAGREINGRESOS")
    public String getFlagreingresos() {
        return flagreingresos;
    }

    @Basic
    @Column(name = "FLAGRETENCIONJUDICIAL")
    public String getFlagretencionjudicial() {
        return flagretencionjudicial;
    }

    @Basic
    @Column(name = "FLAGSCTRPENSION")
    public String getFlagsctrpension() {
        return flagsctrpension;
    }

    @Basic
    @Column(name = "FLAGSCTRSALUD")
    public String getFlagsctrsalud() {
        return flagsctrsalud;
    }

    @Basic
    @Column(name = "FLAGSINDICALIZADO")
    public String getFlagsindicalizado() {
        return flagsindicalizado;
    }

    @Basic
    @Column(name = "FLAGSINDICATO")
    public String getFlagsindicato() {
        return flagsindicato;
    }

    @Basic
    @Column(name = "FLAGSMF")
    public String getFlagsmf() {
		return flagsmf;
	}

    @Basic
    @Column(name = "FLAGSUJETOCONTROL")
    public String getFlagsujetocontrol() {
        return flagsujetocontrol;
    }

    @Basic
    @Column(name = "FLAGTRABAJADORPENSIONISTA")
    public String getFlagtrabajadorpensionista() {
        return flagtrabajadorpensionista;
    }

    @Basic
    @Column(name = "FORMATO_2")
    public String getFormato2() {
        return formato2;
    }

    @Basic
    @Column(name = "FOTO")
    public String getFoto() {
        return foto;
    }

    @Basic
    @Column(name = "GERENCIA")
    public Integer getGerencia() {
        return gerencia;
    }

    @Basic
    @Column(name = "GRADOSALARIO")
    public String getGradosalario() {
        return gradosalario;
    }

    @Basic
    @Column(name = "GRUPOOCUPACIONAL")
    public Integer getGrupoocupacional() {
        return grupoocupacional;
    }

    @Basic
    @Column(name = "HORALECTIVA")
    public Double getHoralectiva() {
        return horalectiva;
    }

    @Basic
    @Column(name = "JEFEDEPARTAMENTO")
    public Integer getJefedepartamento() {
        return jefedepartamento;
    }

    @Basic
    @Column(name = "JEFEUNIDAD")
    public Integer getJefeunidad() {
        return jefeunidad;
    }

    @Basic
    @Column(name = "LOCACIONASIGNADA")
    public String getLocacionasignada() {
        return locacionasignada;
    }

    @Basic
    @Column(name = "LOCACIONDEPAGO")
    public String getLocaciondepago() {
        return locaciondepago;
    }

    @Basic
    @Column(name = "MONEDAPAGO")
    public String getMonedapago() {
        return monedapago;
    }

    @Basic
    @Column(name = "MOTIVOCESE")
    public Integer getMotivocese() {
        return motivocese;
    }

    @Basic
    @Column(name = "MUNICIPALIDADNACIMIENTO")
    public String getMunicipalidadnacimiento() {
        return municipalidadnacimiento;
    }

    @Basic
    @Column(name = "NIVEL")
    public String getNivel() {
        return nivel;
    }

    @Basic
    @Column(name = "NIVELACCESO")
    public String getNivelacceso() {
        return nivelacceso;
    }

    @Basic
    @Column(name = "NIVELEDUCATIVORTPS")
    public String getNiveleducativortps() {
        return niveleducativortps;
    }

    @Basic
    @Column(name = "NIVELSALARIO")
    public String getNivelsalario() {
        return nivelsalario;
    }

    @Basic
    @Column(name = "NUMEROAFP")
    public String getNumeroafp() {
        return numeroafp;
    }

    @Basic
    @Column(name = "NUMEROARCHIVO")
    public String getNumeroarchivo() {
        return numeroarchivo;
    }

    @Basic
    @Column(name = "NUMEROCUENTACTS")
    public String getNumerocuentacts() {
        return numerocuentacts;
    }

    @Basic
    @Column(name = "ORDENSERVICIO")
    public String getOrdenservicio() {
        return ordenservicio;
    }

    @Basic
    @Column(name = "PERFIL")
    public Integer getPerfil() {
        return perfil;
    }

    @Basic
    @Column(name = "PLANTA")
    public String getPlanta() {
        return planta;
    }

    @Basic
    @Column(name = "PLANTILLACONCEPTO")
    public Integer getPlantillaconcepto() {
        return plantillaconcepto;
    }

    @Basic
    @Column(name = "PORCENTAJE")
    public Integer getPorcentaje() {
        return porcentaje;
    }

    @Basic
    @Column(name = "POSICION")
    public String getPosicion() {
        return posicion;
    }

    @Basic
    @Column(name = "POSICIONORGANIGRAMA")
    public Integer getPosicionorganigrama() {
        return posicionorganigrama;
    }

    @Basic
    @Column(name = "PRESTADORSERVICIO")
    public String getPrestadorservicio() {
        return prestadorservicio;
    }

    @Basic
    @Column(name = "PROVEEDORINTERMEDIACION")
    public Integer getProveedorintermediacion() {
        return proveedorintermediacion;
    }

    @Basic
    @Column(name = "PROVINCIA")
    public String getProvincia() {
        return provincia;
    }

    @Basic
    @Column(name = "RAZA")
    public String getRaza() {
        return raza;
    }

    @Basic
    @Column(name = "RAZONCESE")
    public String getRazoncese() {
        return razoncese;
    }

    @Basic
    @Column(name = "REDONDEOACUENTA")
    public Double getRedondeoacuenta() {
        return redondeoacuenta;
    }

    @Basic
    @Column(name = "RELIGION")
    public String getReligion() {
        return religion;
    }

    @Basic
    @Column(name = "RESPONSABLEEMPLEADO")
    public String getResponsableempleado() {
        return responsableempleado;
    }

    @Basic
    @Column(name = "RESPONSABLEJEFE")
    public String getResponsablejefe() {
        return responsablejefe;
    }

    @Basic
    @Column(name = "RESPONSABLESUELDO")
    public String getResponsablesueldo() {
        return responsablesueldo;
    }

    @Basic
    @Column(name = "RESPONSABLEUNIDAD")
    public Integer getResponsableunidad() {
        return responsableunidad;
    }

    @Basic
    @Column(name = "RUCCENTROASISTENCIASOCIAL")
    public String getRuccentroasistenciasocial() {
        return ruccentroasistenciasocial;
    }

    @Basic
    @Column(name = "SERVICIOMILITARDESDE")
    public Date getServiciomilitardesde() {
        return serviciomilitardesde;
    }

    @Basic
    @Column(name = "SERVICIOMILITARHASTA")
    public Date getServiciomilitarhasta() {
        return serviciomilitarhasta;
    }

    @Basic
    @Column(name = "SITUACIONESPECIAL")
    public String getSituacionespecial() {
        return situacionespecial;
    }

    @Basic
    @Column(name = "SOLICITADORNIVELACION")
    public Integer getSolicitadornivelacion() {
        return solicitadornivelacion;
    }

    @Basic
    @Column(name = "SUBGERENCIA")
    public Integer getSubgerencia() {
        return subgerencia;
    }

    @Basic
    @Column(name = "SUCURSAL")
    public String getSucursal() {
        return sucursal;
    }

    @Basic
    @Column(name = "SUELDOACTUALDOLAR")
    public Integer getSueldoactualdolar() {
        return sueldoactualdolar;
    }

    @Basic
    @Column(name = "SUELDOACTUALLOCAL")
    public Integer getSueldoactuallocal() {
        return sueldoactuallocal;
    }

    @Basic
    @Column(name = "SUELDOANTERIORDOLAR")
    public Integer getSueldoanteriordolar() {
        return sueldoanteriordolar;
    }

    @Basic
    @Column(name = "SUELDOANTERIORLOCAL")
    public Integer getSueldoanteriorlocal() {
        return sueldoanteriorlocal;
    }

    @Basic
    @Column(name = "TARJETADECREDITO")
    public String getTarjetadecredito() {
        return tarjetadecredito;
    }

    @Basic
    @Column(name = "TIPOASISTENCIASOCIAL")
    public String getTipoasistenciasocial() {
        return tipoasistenciasocial;
    }

    @Basic
    @Column(name = "TIPOCARNETASISTENCIASOCIAL")
    public String getTipocarnetasistenciasocial() {
        return tipocarnetasistenciasocial;
    }

    @Basic
    @Column(name = "TIPOCONTRATO")
    public String getTipocontrato() {
        return tipocontrato;
    }

    @Basic
    @Column(name = "TIPOCUENTACTS")
    public String getTipocuentacts() {
        return tipocuentacts;
    }

    @Basic
    @Column(name = "TIPOHORARIO")
    public Integer getTipohorario() {
        return tipohorario;
    }

    @Basic
    @Column(name = "TIPOMODALIDADFORMATIVA")
    public String getTipomodalidadformativa() {
        return tipomodalidadformativa;
    }

    @Basic
    @Column(name = "TIPOMONEDACTS")
    public String getTipomonedacts() {
        return tipomonedacts;
    }

    @Basic
    @Column(name = "TIPOPAGO")
    public String getTipopago() {
        return tipopago;
    }

    @Basic
    @Column(name = "TIPO_PAGOHORA")
    public String getTipoPagohora() {
        return tipoPagohora;
    }

    @Basic
    @Column(name = "TIPOPENSION")
    public String getTipopension() {
        return tipopension;
    }

    @Basic
    @Column(name = "TIPOPENSIONJUBILACION")
    public String getTipopensionjubilacion() {
        return tipopensionjubilacion;
    }

    @Basic
    @Column(name = "TIPOPLANILLA")
    public String getTipoplanilla() {
        return tipoplanilla;
    }

    @Basic
    @Column(name = "TIPOPLANILLAOP")
    public String getTipoplanillaop() {
        return tipoplanillaop;
    }

    @Basic
    @Column(name = "TIPOREMUNERACIONRTPS")
    public String getTiporemuneracionrtps() {
        return tiporemuneracionrtps;
    }

    @Basic
    @Column(name = "TIPOTRABAJADOR")
    public String getTipotrabajador() {
        return tipotrabajador;
    }

    @Basic
    @Column(name = "TIPOVISA")
    public String getTipovisa() {
        return tipovisa;
    }

    @Basic
    @Column(name = "ULTIMAFECHAMODIF")
    public Date getUltimafechamodif() {
        return ultimafechamodif;
    }

    @Basic
    @Column(name = "ULTIMAFECHAPAGOVACACION")
    public Date getUltimafechapagovacacion() {
        return ultimafechapagovacacion;
    }

    @Basic
    @Column(name = "ULTIMOUSUARIO")
    public String getUltimousuario() {
        return ultimousuario;
    }

    @Basic
    @Column(name = "UNEUNEGOCIOID")
    public Integer getUneunegocioid() {
        return uneunegocioid;
    }

    @Basic
    @Column(name = "UNIDADNEGOCIOASIGNADA")
    public String getUnidadnegocioasignada() {
        return unidadnegocioasignada;
    }

    @Basic
    @Column(name = "UNIDADREPLICACION")
    public String getUnidadreplicacion() {
        return unidadreplicacion;
    }

    @Basic
    @Column(name = "VISAFECHAEXPIRACION")
    public Date getVisafechaexpiracion() {
        return visafechaexpiracion;
    }

    @Basic
    @Column(name = "VISAFECHAINICIO")
    public Date getVisafechainicio() {
        return visafechainicio;
    }
    
    public void setEmpleado(Integer empleado) {
        this.empleado = empleado;
    }

    public void setCompaniasocio(String companiasocio) {
        this.companiasocio = companiasocio;
    }
    
    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public void setAfe(String afe) {
        this.afe = afe;
    }

    public void setAprobadornivelacion(Integer aprobadornivelacion) {
        this.aprobadornivelacion = aprobadornivelacion;
    }

    public void setAsignacionfamiliar(String asignacionfamiliar) {
        this.asignacionfamiliar = asignacionfamiliar;
    }

    public void setBancocts(String bancocts) {
        this.bancocts = bancocts;
    }

    public void setBudgetcategory(String budgetcategory) {
        this.budgetcategory = budgetcategory;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setCarnetasistenciasocial(String carnetasistenciasocial) {
        this.carnetasistenciasocial = carnetasistenciasocial;
    }

    public void setCategoriaocupacional(String categoriaocupacional) {
        this.categoriaocupacional = categoriaocupacional;
    }

    public void setCentroasistenciasocial(String centroasistenciasocial) {
        this.centroasistenciasocial = centroasistenciasocial;
    }

    public void setCentrocostos(String centrocostos) {
        this.centrocostos = centrocostos;
    }

    public void setCodigoafp(String codigoafp) {
        this.codigoafp = codigoafp;
    }

    public void setCodigocargo(Integer codigocargo) {
        this.codigocargo = codigocargo;
    }

    public void setCodigounidad(Integer codigounidad) {
        this.codigounidad = codigounidad;
    }

    public void setCodigousuario(String codigousuario) {
        this.codigousuario = codigousuario;
    }

    public void setCondicionLaboral(String condicionLaboral) {
        this.condicionLaboral = condicionLaboral;
    }

    public void setContratista(Integer contratista) {
        this.contratista = contratista;
    }

    public void setCorreointerno(String correointerno) {
        this.correointerno = correointerno;
    }

    public void setDepartamentooperacional(String departamentooperacional) {
        this.departamentooperacional = departamentooperacional;
    }

    public void setDepartamentoorganizacional(String departamentoorganizacional) {
        this.departamentoorganizacional = departamentoorganizacional;
    }

    public void setDeptoorganizacion(String deptoorganizacion) {
        this.deptoorganizacion = deptoorganizacion;
    }

    public void setEmpleadorelacionado(Integer empleadorelacionado) {
        this.empleadorelacionado = empleadorelacionado;
    }

    public void setEmpleadorepresentante(Integer empleadorepresentante) {
        this.empleadorepresentante = empleadorepresentante;
    }

    public void setEstablecimientortps(String establecimientortps) {
        this.establecimientortps = establecimientortps;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setEstadoempleado(String estadoempleado) {
        this.estadoempleado = estadoempleado;
    }

    public void setEstadonivelacion(String estadonivelacion) {
        this.estadonivelacion = estadonivelacion;
    }

    public void setFechabajaeps(Date fechabajaeps) {
        this.fechabajaeps = fechabajaeps;
    }

    public void setFechacese(Date fechacese) {
        this.fechacese = fechacese;
    }

    public void setFechafincontrato(Date fechafincontrato) {
        this.fechafincontrato = fechafincontrato;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public void setFechainiciocontrato(Date fechainiciocontrato) {
        this.fechainiciocontrato = fechainiciocontrato;
    }

    public void setFechainiciopension(Date fechainiciopension) {
        this.fechainiciopension = fechainiciopension;
    }

    public void setFechaliquidacion(Date fechaliquidacion) {
        this.fechaliquidacion = fechaliquidacion;
    }

    public void setFechareingreso(Date fechareingreso) {
        this.fechareingreso = fechareingreso;
    }

    public void setFechaterminopension(Date fechaterminopension) {
        this.fechaterminopension = fechaterminopension;
    }

    public void setFechaultimaplanilla(Date fechaultimaplanilla) {
        this.fechaultimaplanilla = fechaultimaplanilla;
    }

    public void setFechavacaciones(Date fechavacaciones) {
        this.fechavacaciones = fechavacaciones;
    }

    public void setFirmadigitalizada(String firmadigitalizada) {
        this.firmadigitalizada = firmadigitalizada;
    }

    public void setFlagacctrabajo(String flagacctrabajo) {
        this.flagacctrabajo = flagacctrabajo;
    }

    public void setFlagasegurapension(String flagasegurapension) {
        this.flagasegurapension = flagasegurapension;
    }

    public void setFlagcentroformacion(String flagcentroformacion) {
        this.flagcentroformacion = flagcentroformacion;
    }

    public void setFlagcomision(String flagcomision) {
        this.flagcomision = flagcomision;
    }

    public void setFlagconveniodobletrib(String flagconveniodobletrib) {
        this.flagconveniodobletrib = flagconveniodobletrib;
    }

    public void setFlagcooperativa(String flagcooperativa) {
        this.flagcooperativa = flagcooperativa;
    }

    public void setFlagdeconfianza(String flagdeconfianza) {
        this.flagdeconfianza = flagdeconfianza;
    }

    public void setFlagdiscapacidad(String flagdiscapacidad) {
        this.flagdiscapacidad = flagdiscapacidad;
    }

    public void setFlagdomiciliado(String flagdomiciliado) {
        this.flagdomiciliado = flagdomiciliado;
    }

    public void setFlaghorarionocturno(String flaghorarionocturno) {
        this.flaghorarionocturno = flaghorarionocturno;
    }

    public void setFlagimpuestorenta(String flagimpuestorenta) {
        this.flagimpuestorenta = flagimpuestorenta;
    }

    public void setFlagipssvida(String flagipssvida) {
        this.flagipssvida = flagipssvida;
    }

    public void setFlagjefedepartamento(String flagjefedepartamento) {
        this.flagjefedepartamento = flagjefedepartamento;
    }

    public void setFlagjornadamaxima(String flagjornadamaxima) {
        this.flagjornadamaxima = flagjornadamaxima;
    }

    public void setFlagmadreresponsabilidad(String flagmadreresponsabilidad) {
        this.flagmadreresponsabilidad = flagmadreresponsabilidad;
    }

    public void setFlagotrosquinta(String flagotrosquinta) {
        this.flagotrosquinta = flagotrosquinta;
    }

    public void setFlagporcentaje(String flagporcentaje) {
        this.flagporcentaje = flagporcentaje;
    }

    public void setFlagquintaexonerada(String flagquintaexonerada) {
        this.flagquintaexonerada = flagquintaexonerada;
    }

    public void setFlagregimenalternativo(String flagregimenalternativo) {
        this.flagregimenalternativo = flagregimenalternativo;
    }

    public void setFlagreingresos(String flagreingresos) {
        this.flagreingresos = flagreingresos;
    }

    public void setFlagretencionjudicial(String flagretencionjudicial) {
        this.flagretencionjudicial = flagretencionjudicial;
    }

    public void setFlagsctrpension(String flagsctrpension) {
        this.flagsctrpension = flagsctrpension;
    }

    public void setFlagsctrsalud(String flagsctrsalud) {
        this.flagsctrsalud = flagsctrsalud;
    }

    public void setFlagsindicalizado(String flagsindicalizado) {
        this.flagsindicalizado = flagsindicalizado;
    }

    public void setFlagsindicato(String flagsindicato) {
        this.flagsindicato = flagsindicato;
    }

    public void setFlagsmf(String flagsmf) {
		this.flagsmf = flagsmf;
	}

    public void setFlagsujetocontrol(String flagsujetocontrol) {
        this.flagsujetocontrol = flagsujetocontrol;
    }

    public void setFlagtrabajadorpensionista(String flagtrabajadorpensionista) {
        this.flagtrabajadorpensionista = flagtrabajadorpensionista;
    }

    public void setFormato2(String formato2) {
        this.formato2 = formato2;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setGerencia(Integer gerencia) {
        this.gerencia = gerencia;
    }

    public void setGradosalario(String gradosalario) {
        this.gradosalario = gradosalario;
    }

    public void setGrupoocupacional(Integer grupoocupacional) {
        this.grupoocupacional = grupoocupacional;
    }

    public void setHoralectiva(Double horalectiva) {
        this.horalectiva = horalectiva;
    }

    public void setJefedepartamento(Integer jefedepartamento) {
        this.jefedepartamento = jefedepartamento;
    }

    public void setJefeunidad(Integer jefeunidad) {
        this.jefeunidad = jefeunidad;
    }

    public void setLocacionasignada(String locacionasignada) {
        this.locacionasignada = locacionasignada;
    }

    public void setLocaciondepago(String locaciondepago) {
        this.locaciondepago = locaciondepago;
    }

    public void setMonedapago(String monedapago) {
        this.monedapago = monedapago;
    }

    public void setMotivocese(Integer motivocese) {
        this.motivocese = motivocese;
    }

    public void setMunicipalidadnacimiento(String municipalidadnacimiento) {
        this.municipalidadnacimiento = municipalidadnacimiento;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setNivelacceso(String nivelacceso) {
        this.nivelacceso = nivelacceso;
    }

    public void setNiveleducativortps(String niveleducativortps) {
        this.niveleducativortps = niveleducativortps;
    }

    public void setNivelsalario(String nivelsalario) {
        this.nivelsalario = nivelsalario;
    }

    public void setNumeroafp(String numeroafp) {
        this.numeroafp = numeroafp;
    }

    public void setNumeroarchivo(String numeroarchivo) {
        this.numeroarchivo = numeroarchivo;
    }

    public void setNumerocuentacts(String numerocuentacts) {
        this.numerocuentacts = numerocuentacts;
    }

    public void setOrdenservicio(String ordenservicio) {
        this.ordenservicio = ordenservicio;
    }

    public void setPerfil(Integer perfil) {
        this.perfil = perfil;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public void setPlantillaconcepto(Integer plantillaconcepto) {
        this.plantillaconcepto = plantillaconcepto;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void setPosicionorganigrama(Integer posicionorganigrama) {
        this.posicionorganigrama = posicionorganigrama;
    }

    public void setPrestadorservicio(String prestadorservicio) {
        this.prestadorservicio = prestadorservicio;
    }

    public void setProveedorintermediacion(Integer proveedorintermediacion) {
        this.proveedorintermediacion = proveedorintermediacion;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setRazoncese(String razoncese) {
        this.razoncese = razoncese;
    }

    public void setRedondeoacuenta(Double redondeoacuenta) {
        this.redondeoacuenta = redondeoacuenta;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public void setResponsableempleado(String responsableempleado) {
        this.responsableempleado = responsableempleado;
    }

    public void setResponsablejefe(String responsablejefe) {
        this.responsablejefe = responsablejefe;
    }

    public void setResponsablesueldo(String responsablesueldo) {
        this.responsablesueldo = responsablesueldo;
    }

    public void setResponsableunidad(Integer responsableunidad) {
        this.responsableunidad = responsableunidad;
    }

    public void setRuccentroasistenciasocial(String ruccentroasistenciasocial) {
        this.ruccentroasistenciasocial = ruccentroasistenciasocial;
    }

    public void setServiciomilitardesde(Date serviciomilitardesde) {
        this.serviciomilitardesde = serviciomilitardesde;
    }

    public void setServiciomilitarhasta(Date serviciomilitarhasta) {
        this.serviciomilitarhasta = serviciomilitarhasta;
    }

    public void setSituacionespecial(String situacionespecial) {
        this.situacionespecial = situacionespecial;
    }

    public void setSolicitadornivelacion(Integer solicitadornivelacion) {
        this.solicitadornivelacion = solicitadornivelacion;
    }

    public void setSubgerencia(Integer subgerencia) {
        this.subgerencia = subgerencia;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public void setSueldoactualdolar(Integer sueldoactualdolar) {
        this.sueldoactualdolar = sueldoactualdolar;
    }

    public void setSueldoactuallocal(Integer sueldoactuallocal) {
        this.sueldoactuallocal = sueldoactuallocal;
    }

    public void setSueldoanteriordolar(Integer sueldoanteriordolar) {
        this.sueldoanteriordolar = sueldoanteriordolar;
    }

    public void setSueldoanteriorlocal(Integer sueldoanteriorlocal) {
        this.sueldoanteriorlocal = sueldoanteriorlocal;
    }

    public void setTarjetadecredito(String tarjetadecredito) {
        this.tarjetadecredito = tarjetadecredito;
    }

    public void setTipoasistenciasocial(String tipoasistenciasocial) {
        this.tipoasistenciasocial = tipoasistenciasocial;
    }

    public void setTipocarnetasistenciasocial(String tipocarnetasistenciasocial) {
        this.tipocarnetasistenciasocial = tipocarnetasistenciasocial;
    }

    public void setTipocontrato(String tipocontrato) {
        this.tipocontrato = tipocontrato;
    }

    public void setTipocuentacts(String tipocuentacts) {
        this.tipocuentacts = tipocuentacts;
    }

    public void setTipohorario(Integer tipohorario) {
        this.tipohorario = tipohorario;
    }

    public void setTipomodalidadformativa(String tipomodalidadformativa) {
        this.tipomodalidadformativa = tipomodalidadformativa;
    }

    public void setTipomonedacts(String tipomonedacts) {
        this.tipomonedacts = tipomonedacts;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

    public void setTipoPagohora(String tipoPagohora) {
        this.tipoPagohora = tipoPagohora;
    }

    public void setTipopension(String tipopension) {
        this.tipopension = tipopension;
    }

    public void setTipopensionjubilacion(String tipopensionjubilacion) {
        this.tipopensionjubilacion = tipopensionjubilacion;
    }

    public void setTipoplanilla(String tipoplanilla) {
        this.tipoplanilla = tipoplanilla;
    }

    public void setTipoplanillaop(String tipoplanillaop) {
        this.tipoplanillaop = tipoplanillaop;
    }

    public void setTiporemuneracionrtps(String tiporemuneracionrtps) {
        this.tiporemuneracionrtps = tiporemuneracionrtps;
    }

    public void setTipotrabajador(String tipotrabajador) {
        this.tipotrabajador = tipotrabajador;
    }

    public void setTipovisa(String tipovisa) {
        this.tipovisa = tipovisa;
    }

    public void setUltimafechamodif(Date ultimafechamodif) {
        this.ultimafechamodif = ultimafechamodif;
    }

    public void setUltimafechapagovacacion(Date ultimafechapagovacacion) {
        this.ultimafechapagovacacion = ultimafechapagovacacion;
    }

    public void setUltimousuario(String ultimousuario) {
        this.ultimousuario = ultimousuario;
    }

    public void setUneunegocioid(Integer uneunegocioid) {
        this.uneunegocioid = uneunegocioid;
    }

    public void setUnidadnegocioasignada(String unidadnegocioasignada) {
        this.unidadnegocioasignada = unidadnegocioasignada;
    }

    public void setUnidadreplicacion(String unidadreplicacion) {
        this.unidadreplicacion = unidadreplicacion;
    }

    public void setVisafechaexpiracion(Date visafechaexpiracion) {
        this.visafechaexpiracion = visafechaexpiracion;
    }

    public void setVisafechainicio(Date visafechainicio) {
        this.visafechainicio = visafechainicio;
    }

    @Transient
	public SaDependencias getOrganigrama() {
		return organigrama;
	}

	public void setOrganigrama(SaDependencias organigrama) {
		this.organigrama = organigrama;
	}   
	
	
	@Transient
	public boolean isEnvioCorreo() {
		if(Utiles.vacio(flagsmf) || flagsmf.equals(Utiles.NO_db)){
			envioCorreo = false;
		}else{
			envioCorreo = true;
		}
		return envioCorreo;
	}
	
	public void setEnvioCorreo(boolean envioCorreo) {
		this.envioCorreo = envioCorreo;
	}
}
