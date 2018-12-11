package erp.realcoresystems.pe.controller.configuracion;

import java.util.ArrayList;
import java.util.List;

import erp.realcoresystems.pe.security.VwSeguridadautorizacione;
import erp.realcoresystems.pe.server.EntityGlobal;
import erp.realcoresystems.pe.model.util.Constant;

public class MenuPrincipalEstaticoBean {

    /**CONSTANTES***/

    public static String TIPOO_OBJETO_db = "O";
    public static String TIPOO_CARPETA_db = "C";
    public static String TIPOO_ARCHIVO_db = "A";


    /**OPCIONES-URL***/



    public static final String URL_MAST_PERFIL = "/vistas/sa/seguridad/saUsuarioPerfilBusqueda.xhtml";

    public static final String URL_MAST_USUARIO = "/vistas/sa/seguridad/saUsuariomantenimiento.xhtml";
    public static final String URL_MAST_PARAMETRO = "/vistas/sa/seguridad/saParametroMantenimiento.xhtml";

    public static final String URL_MAST_PERMISOPERFIL = "/vistas/sa/seguridad/saPermisoPerfilmantenimiento.xhtml";
    public static final String URL_MAST_PERMISOUSUARIO = "/vistas/sa/seguridad/saPermisosUsuariomantenimiento.xhtml";
    public static final String URL_SEGURIDAD_CONCEPTO= "/vistas/sa/seguridad/saSeguridadConcepto.xhtml";

    public static final String URL_PARAMETRO = "/vistas/sa/seguridad/saParametroMantenimiento.xhtml";

    public static final String URL_MAST_PERSONA = "/vistas/sa/maestro/persona/saPersonaBusqueda.xhtml";

    public static final String URL_CONTROL_PERIODO = "/vistas/sunass/gestion/controlAprobacionesLista.xhtml";
    public static final String URL_CARGAINICIAL_BASE= "/vistas/sunass/gestion/cargaInicialLista.xhtml?fuenteid=1";
    public static final String URL_CARGAINICIAL_FUENTE= "/vistas/sunass/gestion/cargaFuentesLista.xhtml?fuenteid=1";
    public static final String URL_CARGAINICIAL_ESTRUCTURA= "/vistas/sunass/gestion/cargaEstructuraLista.xhtml?fuenteid=2";
    public static final String URL_CARGAINICIAL_PLANTA= "/vistas/sunass/gestion/cargaPlantaLista.xhtml?fuenteid=3";
    public static final String URL_CARGAINICIAL_PLANTARESID= "/vistas/sunass/gestion/cargaPlantaResidualLista.xhtml?fuenteid=4";
    public static final String URL_CARGAINICIAL_INFESTGENERAL= "/vistas/sunass/gestion/cargaInfraestructuraGeneLista.xhtml?fuenteid=5";
    public static final String URL_CARGAINICIAL_CICLOFACTURA= "/vistas/sunass/gestion/cargaCicloFacturaLista.xhtml?fuenteid=6";
    public static final String URL_CARGAINICIAL_CAPTACION= "/vistas/sunass/gestion/cargaCaptacionLista.xhtml?fuenteid=7";
    public static final String URL_CARGAINICIAL_MACROMEDICION = "/vistas/sunass/gestion/cargaMacromedicionLista.xhtml?fuenteid=8";

    /**
     * Obtiene la lista de Permisos , pero del tipo de objeto 'C', que son las
     * carpetas agrupadoras
     *
     * @return
     */

    public static List<VwSeguridadautorizacione> obtenerGruposPermisosMenuEstatic() {
        List<VwSeguridadautorizacione> listaGruposPermisos = new ArrayList<VwSeguridadautorizacione>();

        VwSeguridadautorizacione objPermisos001 = new VwSeguridadautorizacione();
        objPermisos001.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        objPermisos001.setTipodeObjeto(TIPOO_CARPETA_db);

        objPermisos001.setGrupo("GRUPO011");
        objPermisos001.setConcepto("CON0000");
        objPermisos001.setConceptoPadre("GRUPO011");
        objPermisos001.setDescripcionGrupo("APERTURA Y APROBACIONES");
        objPermisos001.setDescripcionSegConcepto("APERTURA Y APROBACIONES");
        objPermisos001.setObjetoWindow("icon-desktop");
        listaGruposPermisos.add(objPermisos001);

        VwSeguridadautorizacione objPermisos5 = new VwSeguridadautorizacione();
        objPermisos5.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        objPermisos5.setTipodeObjeto(TIPOO_CARPETA_db);

        objPermisos5.setGrupo("GRUPO005");
        objPermisos5.setConcepto("CON0000");
        objPermisos5.setConceptoPadre("GRUPO005");
        objPermisos5.setDescripcionGrupo("MAESTROS");
        objPermisos5.setDescripcionSegConcepto("MAESTROS");
        objPermisos5.setObjetoWindow("icon-desktop");
        listaGruposPermisos.add(objPermisos5);

        VwSeguridadautorizacione objCargaInicial1 = new VwSeguridadautorizacione();
        objCargaInicial1.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        objCargaInicial1.setTipodeObjeto(TIPOO_CARPETA_db);

        objCargaInicial1.setGrupo("GRUPO010");
        objCargaInicial1.setConcepto("CON0000");
        objCargaInicial1.setConceptoPadre("GRUPO010");
        objCargaInicial1.setDescripcionGrupo("CARGA INFORMES");
        objCargaInicial1.setDescripcionSegConcepto("CARGA INFORMES");
        objCargaInicial1.setObjetoWindow("icon-desktop");
        listaGruposPermisos.add(objCargaInicial1);


        VwSeguridadautorizacione objPermisos = new VwSeguridadautorizacione();
        objPermisos.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        objPermisos.setUsuario(EntityGlobal.getInstance().getUsuario());
        objPermisos.setEstado(Constant.ACTIVO);
        objPermisos.setTipodeObjeto(TIPOO_CARPETA_db);
        // objPermisos.setEstadoSegConcepto(Constant.ACTIVO);
        objPermisos.setVisibleFlag(Constant.SI_db);

        /** CARGAR ESTATICAMENTE **/
        objPermisos.setGrupo("GRUPO000");
        objPermisos.setConcepto("CON0000");
        objPermisos.setConceptoPadre("GRUPO000");
        objPermisos.setDescripcionGrupo("PROYECTOS");
        objPermisos.setDescripcionSegConcepto("PROYECTOS");
        objPermisos.setObjetoWindow("icon-edit");

        listaGruposPermisos.add(objPermisos);

        VwSeguridadautorizacione objPermisos6 = new VwSeguridadautorizacione();
        objPermisos6.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        objPermisos6.setTipodeObjeto(TIPOO_CARPETA_db);

        objPermisos6.setGrupo("GRUPO006");
        objPermisos6.setConcepto("CON0000");
        objPermisos6.setConceptoPadre("GRUPO006");
        objPermisos6.setDescripcionGrupo("SEGURIDAD");
        objPermisos6.setDescripcionSegConcepto("SEGURIDAD");
        objPermisos6.setObjetoWindow("icon-desktop");
        listaGruposPermisos.add(objPermisos6);


//		VwSeguridadautorizacione objPermisos4 = new VwSeguridadautorizacione();
//		objPermisos4.setAplicacionCodigo(Constant.APLICACION_CODIGO);
//		objPermisos4.setTipodeObjeto(TIPOO_CARPETA_db);
//
//		objPermisos4.setGrupo("GRUPO004");
//		objPermisos4.setConcepto("CON0000");
//		objPermisos4.setConceptoPadre("GRUPO004");
//		objPermisos4.setDescripcionGrupo("SEGURIDAD");
//		objPermisos4.setDescripcionSegConcepto("SEGURIDAD");
//		objPermisos4.setObjetoWindow("icon-desktop");
//		listaGruposPermisos.add(objPermisos4);

        return listaGruposPermisos;
    }


    /**
     * Obtiene la lista de Permisos , pero del tipo de objeto 'A', que son los
     * Archivos de opciones
     *
     * @return
     */

    public  static List<VwSeguridadautorizacione> obtenerOpcionesPermisosMenuEstatic(String filtroNombre, String grupo,
                                                                                     String conceptoPadre) {
        List<VwSeguridadautorizacione> listaOpcPermisos = new ArrayList<VwSeguridadautorizacione>();
        VwSeguridadautorizacione objPermisos = new VwSeguridadautorizacione();
        objPermisos.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        objPermisos.setUsuario(EntityGlobal.getInstance().getUsuario());
        objPermisos.setEstado(Constant.ACTIVO);
        objPermisos.setTipodeObjeto(TIPOO_ARCHIVO_db);
        objPermisos.setGrupo(grupo);
        objPermisos.setConceptoPadre(conceptoPadre);
        objPermisos.setDescripcionSegConcepto(filtroNombre);
        // objPermisos.setEstadoSegConcepto(Constant.ACTIVO);
        objPermisos.setVisibleFlag(Constant.SI_db);
        /**
         * CARGAR DESDE DB listaOpcPermisos =
         * seguridadAutorizacioneService.listarPermisosUsuario(objPermisos);
         */
        /** CARGAR ESTATICAMENTE **/

        // objPermisos.setGrupo("GRUPO000");
        // objPermisos.setConcepto("CON0001");
        // objPermisos.setConceptoPadre("CON0000");
        // objPermisos.setDescripcionSegConcepto("Introducción General");
        // objPermisos.setUrl(""+URL_INTRODUCCION);
        // objPermisos.setObjetoWindow("fa fa-circle-o");
        // listaOpcPermisos.add(objPermisos);


        VwSeguridadautorizacione objPermisos01 = new VwSeguridadautorizacione();
        objPermisos01.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        objPermisos01.setUsuario(EntityGlobal.getInstance().getUsuario());
        objPermisos01.setEstado(Constant.ACTIVO);
        objPermisos01.setTipodeObjeto(TIPOO_ARCHIVO_db);

        objPermisos01.setGrupo("GRUPO011");
        objPermisos01.setConcepto("CON0001");
        objPermisos01.setConceptoPadre("CON0000");
        objPermisos01.setDescripcionSegConcepto("Apertura y Aprobaciones");
        objPermisos01.setUrl("" + URL_CONTROL_PERIODO);
        objPermisos01.setObjetoWindow("fa fa-circle-o");
        listaOpcPermisos.add(objPermisos01);



        VwSeguridadautorizacione fuente = new VwSeguridadautorizacione();
        fuente.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        fuente.setUsuario(EntityGlobal.getInstance().getUsuario());
        fuente.setEstado(Constant.ACTIVO);
        fuente.setTipodeObjeto(TIPOO_ARCHIVO_db);

        fuente.setGrupo("GRUPO010");
        fuente.setConcepto("CON0001");
        fuente.setConceptoPadre("CON0000");
        fuente.setDescripcionSegConcepto("Fuentes de Agua");
        fuente.setUrl("" + URL_CARGAINICIAL_FUENTE);
        fuente.setObjetoWindow("fa fa-circle-o");
        listaOpcPermisos.add(fuente);

        VwSeguridadautorizacione planta = new VwSeguridadautorizacione();
        planta.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        planta.setUsuario(EntityGlobal.getInstance().getUsuario());
        planta.setEstado(Constant.ACTIVO);
        planta.setTipodeObjeto(TIPOO_ARCHIVO_db);

        planta.setGrupo("GRUPO010");
        planta.setConcepto("CON0002");
        planta.setConceptoPadre("CON0000");
        planta.setDescripcionSegConcepto("Planta Tratamiento");
        planta.setUrl("" + URL_CARGAINICIAL_PLANTA);
        planta.setObjetoWindow("fa fa-circle-o");
        listaOpcPermisos.add(planta);

        VwSeguridadautorizacione plantaRes = new VwSeguridadautorizacione();
        plantaRes.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        plantaRes.setUsuario(EntityGlobal.getInstance().getUsuario());
        plantaRes.setEstado(Constant.ACTIVO);
        plantaRes.setTipodeObjeto(TIPOO_ARCHIVO_db);

        plantaRes.setGrupo("GRUPO010");
        plantaRes.setConcepto("CON0013");
        plantaRes.setConceptoPadre("CON0000");
        plantaRes.setDescripcionSegConcepto("Planta Residual");
        plantaRes.setUrl("" + URL_CARGAINICIAL_PLANTARESID);
        plantaRes.setObjetoWindow("fa fa-circle-o");
        listaOpcPermisos.add(plantaRes);



        
        VwSeguridadautorizacione captacion = new VwSeguridadautorizacione();
        captacion.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        captacion.setUsuario(EntityGlobal.getInstance().getUsuario());
        captacion.setEstado(Constant.ACTIVO);
        captacion.setTipodeObjeto(TIPOO_ARCHIVO_db);
        
        captacion.setGrupo("GRUPO010");
        captacion.setConcepto("CON0007");
        captacion.setConceptoPadre("CON0000");
        captacion.setDescripcionSegConcepto("Captación de Agua");
        captacion.setUrl("" + URL_CARGAINICIAL_CAPTACION);
        captacion.setObjetoWindow("fa fa-circle-o");
        listaOpcPermisos.add(captacion);
        
        VwSeguridadautorizacione macromedicion = new VwSeguridadautorizacione();
        macromedicion.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        macromedicion.setUsuario(EntityGlobal.getInstance().getUsuario());
        macromedicion.setEstado(Constant.ACTIVO);
        macromedicion.setTipodeObjeto(TIPOO_ARCHIVO_db);
        
        macromedicion.setGrupo("GRUPO010");
        macromedicion.setConcepto("CON0007");
        macromedicion.setConceptoPadre("CON0000");
        macromedicion.setDescripcionSegConcepto("Macromedición");
        macromedicion.setUrl("" + URL_CARGAINICIAL_MACROMEDICION);
        macromedicion.setObjetoWindow("fa fa-circle-o");
        listaOpcPermisos.add(macromedicion);

        VwSeguridadautorizacione estructura = new VwSeguridadautorizacione();
        estructura.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        estructura.setUsuario(EntityGlobal.getInstance().getUsuario());
        estructura.setEstado(Constant.ACTIVO);
        estructura.setTipodeObjeto(TIPOO_ARCHIVO_db);
        estructura.setGrupo("GRUPO010");
        estructura.setConcepto("CON0020");
        estructura.setConceptoPadre("CON0000");
        estructura.setDescripcionSegConcepto("Estruc. Almacenamiento");
        estructura.setUrl("" + URL_CARGAINICIAL_ESTRUCTURA);
        estructura.setObjetoWindow("fa fa-circle-o");
        listaOpcPermisos.add(estructura);

      VwSeguridadautorizacione infraGeneral = new VwSeguridadautorizacione();
        infraGeneral.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        infraGeneral.setUsuario(EntityGlobal.getInstance().getUsuario());
        infraGeneral.setEstado(Constant.ACTIVO);
        infraGeneral.setTipodeObjeto(TIPOO_ARCHIVO_db);
        infraGeneral.setGrupo("GRUPO010");
        infraGeneral.setConcepto("CON0021");
        infraGeneral.setConceptoPadre("CON0000");
        infraGeneral.setDescripcionSegConcepto("Infraestructura General");
        infraGeneral.setUrl("" + URL_CARGAINICIAL_INFESTGENERAL);
        infraGeneral.setObjetoWindow("fa fa-circle-o");
        listaOpcPermisos.add(infraGeneral);

        VwSeguridadautorizacione cicloFactura = new VwSeguridadautorizacione();
        cicloFactura.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        cicloFactura.setUsuario(EntityGlobal.getInstance().getUsuario());
        cicloFactura.setEstado(Constant.ACTIVO);
        cicloFactura.setTipodeObjeto(TIPOO_ARCHIVO_db);
        cicloFactura.setGrupo("GRUPO010");
        cicloFactura.setConcepto("CON0003");
        cicloFactura.setConceptoPadre("CON0000");
        cicloFactura.setDescripcionSegConcepto("Estruc. Almacenamiento");
        cicloFactura.setUrl("" + URL_CARGAINICIAL_CICLOFACTURA);
        cicloFactura.setObjetoWindow("fa fa-circle-o");
        listaOpcPermisos.add(cicloFactura);

        VwSeguridadautorizacione objPermisos011 = new VwSeguridadautorizacione();
        objPermisos011.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        objPermisos011.setUsuario(EntityGlobal.getInstance().getUsuario());
        objPermisos011.setEstado(Constant.ACTIVO);
        objPermisos011.setTipodeObjeto(TIPOO_ARCHIVO_db);

        objPermisos011.setGrupo("GRUPO000");
        objPermisos011.setConcepto("CON00011");
        objPermisos011.setConceptoPadre("CON0000");
        objPermisos011.setDescripcionSegConcepto("Aprobar Vouchers");
        ///objPermisos011.setUrl("" + URL_VOUCHER_APROBAR);
        objPermisos011.setObjetoWindow("fa fa-circle-o");
        //listaOpcPermisos.add(objPermisos011);

        VwSeguridadautorizacione objPermisos51 = new VwSeguridadautorizacione();
        objPermisos51.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        objPermisos51.setUsuario(EntityGlobal.getInstance().getUsuario());
        objPermisos51.setEstado(Constant.ACTIVO);
        objPermisos51.setTipodeObjeto(TIPOO_ARCHIVO_db);

        objPermisos51.setGrupo("GRUPO005");
        objPermisos51.setConcepto("CON0001");
        objPermisos51.setConceptoPadre("CON0000");
        objPermisos51.setDescripcionSegConcepto("Empleados");
        //objPermisos51.setUrl("" + URL_EMPLEADO_REGISTRO);
        objPermisos51.setObjetoWindow("fa fa-circle-o");
        //listaOpcPermisos.add(objPermisos51);

        VwSeguridadautorizacione objPermisos30 = new VwSeguridadautorizacione();
        objPermisos30.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        objPermisos30.setUsuario(EntityGlobal.getInstance().getUsuario());
        objPermisos30.setEstado(Constant.ACTIVO);
        objPermisos30.setTipodeObjeto(TIPOO_ARCHIVO_db);

        objPermisos30.setGrupo("GRUPO005");
        objPermisos30.setConcepto("CON0002");
        objPermisos30.setConceptoPadre("CON0000");
        objPermisos30.setDescripcionSegConcepto("Persona");
        objPermisos30.setUrl("" + URL_MAST_PERSONA);
        objPermisos30.setObjetoWindow("fa fa-circle-o");
        listaOpcPermisos.add(objPermisos30);

        VwSeguridadautorizacione objPermisos31 = new VwSeguridadautorizacione();
        objPermisos31.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        objPermisos31.setUsuario(EntityGlobal.getInstance().getUsuario());
        objPermisos31.setEstado(Constant.ACTIVO);
        objPermisos31.setTipodeObjeto(TIPOO_ARCHIVO_db);

        objPermisos31.setGrupo("GRUPO005");
        objPermisos31.setConcepto("CON0002");
        objPermisos31.setConceptoPadre("CON0000");
        objPermisos31.setDescripcionSegConcepto("EPS");
        objPermisos31.setUrl("" + URL_MAST_PERSONA);
        objPermisos31.setObjetoWindow("fa fa-circle-o");
        listaOpcPermisos.add(objPermisos31);

        VwSeguridadautorizacione objPermisos32 = new VwSeguridadautorizacione();
        objPermisos32.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        objPermisos32.setUsuario(EntityGlobal.getInstance().getUsuario());
        objPermisos32.setEstado(Constant.ACTIVO);
        objPermisos32.setTipodeObjeto(TIPOO_ARCHIVO_db);

        objPermisos32.setGrupo("GRUPO005");
        objPermisos32.setConcepto("CON0002");
        objPermisos32.setConceptoPadre("CON0000");
        objPermisos32.setDescripcionSegConcepto("Formularios");
        objPermisos32.setUrl("" + URL_MAST_PERSONA);
        objPermisos32.setObjetoWindow("fa fa-circle-o");
        listaOpcPermisos.add(objPermisos32);



        VwSeguridadautorizacione objPermisos61 = new VwSeguridadautorizacione();
        objPermisos61.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        objPermisos61.setUsuario(EntityGlobal.getInstance().getUsuario());
        objPermisos61.setEstado(Constant.ACTIVO);
        objPermisos61.setTipodeObjeto(TIPOO_ARCHIVO_db);

        objPermisos61.setGrupo("GRUPO006");
        objPermisos61.setConcepto("CON0001");
        objPermisos61.setConceptoPadre("CON0000");
        objPermisos61.setDescripcionSegConcepto("Usuarios");
        objPermisos61.setUrl("" + URL_MAST_USUARIO);
        objPermisos61.setObjetoWindow("fa fa-circle-o");
        listaOpcPermisos.add(objPermisos61);

        VwSeguridadautorizacione objPermisos62 = new VwSeguridadautorizacione();
        objPermisos62.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        objPermisos61.setUsuario(EntityGlobal.getInstance().getUsuario());
        objPermisos62.setEstado(Constant.ACTIVO);
        objPermisos62.setTipodeObjeto(TIPOO_ARCHIVO_db);

        objPermisos62.setGrupo("GRUPO006");
        objPermisos62.setConcepto("CON0002");
        objPermisos62.setConceptoPadre("CON0000");
        objPermisos62.setDescripcionSegConcepto("Perfiles");
        objPermisos62.setUrl("" + URL_MAST_PERFIL);
        objPermisos62.setObjetoWindow("fa fa-circle-o");
        listaOpcPermisos.add(objPermisos62);

        VwSeguridadautorizacione objPermisos63 = new VwSeguridadautorizacione();
        objPermisos63.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        objPermisos61.setUsuario(EntityGlobal.getInstance().getUsuario());
        objPermisos63.setEstado(Constant.ACTIVO);
        objPermisos63.setTipodeObjeto(TIPOO_ARCHIVO_db);

        objPermisos63.setGrupo("GRUPO006");
        objPermisos63.setConcepto("CON0003");
        objPermisos63.setConceptoPadre("CON0000");
        objPermisos63.setDescripcionSegConcepto("Parámetros");
        objPermisos63.setUrl("" + URL_MAST_PARAMETRO);
        objPermisos63.setObjetoWindow("fa fa-circle-o");
        listaOpcPermisos.add(objPermisos63);

        VwSeguridadautorizacione objPermisos64 = new VwSeguridadautorizacione();
        objPermisos64.setAplicacionCodigo(Constant.APLICACION_CODIGO);
        objPermisos64.setUsuario(EntityGlobal.getInstance().getUsuario());
        objPermisos64.setEstado(Constant.ACTIVO);
        objPermisos64.setTipodeObjeto(TIPOO_ARCHIVO_db);

        objPermisos64.setGrupo("GRUPO006");
        objPermisos64.setConcepto("CON0004");
        objPermisos64.setConceptoPadre("CON0000");
        objPermisos64.setDescripcionSegConcepto("Asignar permiso");
        objPermisos64.setUrl("" + URL_MAST_PERMISOPERFIL);
        objPermisos64.setObjetoWindow("fa fa-circle-o");
        listaOpcPermisos.add(objPermisos64);



//		VwSeguridadautorizacione objPermisos02 = new VwSeguridadautorizacione();
//		objPermisos02.setAplicacionCodigo(Constant.APLICACION_CODIGO);
//		objPermisos02.setUsuario(EntityGlobal.getInstance().getUsuario());
//		objPermisos02.setEstado(Constant.ACTIVO);
//		objPermisos02.setTipodeObjeto(TIPOO_ARCHIVO_db);
//
//		objPermisos02.setGrupo("GRUPO000");
//		objPermisos02.setConcepto("CON0002");
//		objPermisos02.setConceptoPadre("CON0000");
//		objPermisos02.setDescripcionSegConcepto("Currícula");
//		objPermisos02.setUrl("" + URL_CURRICULA);
//		objPermisos02.setObjetoWindow("fa fa-circle-o");
//		listaOpcPermisos.add(objPermisos02);

//
//		VwSeguridadautorizacione objPermisos23 = new VwSeguridadautorizacione();
//		objPermisos23.setAplicacionCodigo(Constant.APLICACION_CODIGO);
//		objPermisos23.setUsuario(EntityGlobal.getInstance().getUsuario());
//		objPermisos23.setEstado(Constant.ACTIVO);
//		objPermisos23.setTipodeObjeto(TIPOO_ARCHIVO_db);
//
//		objPermisos23.setGrupo("GRUPO002");
//		objPermisos23.setConcepto("CON0003");
//		objPermisos23.setConceptoPadre("CON0000");
//		objPermisos23.setDescripcionSegConcepto("Matricula Por Sección");
//		objPermisos23.setUrl("" + URL_MATRICULA_POR_SECCION);
//		objPermisos23.setObjetoWindow("fa fa-circle-o");
//		listaOpcPermisos.add(objPermisos23);




        return listaOpcPermisos;

    }


}