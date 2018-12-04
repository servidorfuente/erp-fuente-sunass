package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.Empleadomast;
import erp.realcoresystems.pe.model.domain.Personamast;
import erp.realcoresystems.pe.model.domain.Proveedormast;

import erp.realcoresystems.pe.model.domain.SaHcAnamnesisAp;
import erp.realcoresystems.pe.model.domain.SaPersonaRelaciones;


import erp.realcoresystems.pe.model.domain.vista.VwPersonaGeneral;


public interface PersonamastService {
	
	public Personamast obtenerPorId(int personaId);
    public List<Personamast> PersonamastListar(Personamast objeto);
    
    public int guardar(Personamast persona);
    public int guardarProveedor(Personamast persona, Proveedormast proveedor);
    public int actualizarProveedor(Personamast persona, Proveedormast proveedor);
      public Personamast PersonaContacto(Personamast objeto);
    public int contadorTotalesPersona(Personamast objeto);
    public int actualizarEstadoPersona(Personamast _persona, String _modificador, String _ip);
    public List<Personamast> obtenerPersonaYEmpleado(Personamast objeto);
     public List<Personamast> obtenerPersonaPorDocumento(int _tipodocumento, String _documento);
    public List<Personamast> listarElementos(Personamast objPersonaMast);
  	public int eliminar(Personamast objSave);
	public List<Personamast> validate(Personamast filtro);

	public String obtenerDocumentoAutogenerado();
	
	public List<VwPersonaGeneral> listar(VwPersonaGeneral filtro, boolean paginable);
	public int contar(VwPersonaGeneral filtro);
	
}

