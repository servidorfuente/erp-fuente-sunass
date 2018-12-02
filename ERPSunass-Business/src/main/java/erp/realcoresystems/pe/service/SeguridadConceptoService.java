package erp.realcoresystems.pe.service;


import java.util.List;

import erp.realcoresystems.pe.model.domain.Seguridadautorizaciones;
import erp.realcoresystems.pe.model.domain.Seguridadconcepto;
import erp.realcoresystems.pe.model.domain.Seguridadgrupo;

public interface SeguridadConceptoService {
	
	/** SEGURIDAD CONCEPTO **/
    public List<Seguridadconcepto> SeguridadConceptoLista(Seguridadautorizaciones seguridadAutorizaciones);
    public Seguridadconcepto SeguridadConceptoBuscar(Seguridadconcepto objPersonaMast);
    
    public Seguridadconcepto obtenerPorId(Seguridadconcepto seguridadconcepto);
	public List<Seguridadconcepto> listar(Seguridadconcepto seguridadconcepto);
	public int contarTotal(Seguridadconcepto seguridadconcepto);
	public int guardar(Seguridadconcepto seguridadconcepto);
	public int eliminar(Seguridadconcepto seguridadconcepto);
	public int actualizar(Seguridadconcepto seguridadconcepto);
	
	/** SEGURIDAD GRUPO **/
	public Seguridadgrupo obtenerPorId(Seguridadgrupo pk);
	public List<Seguridadgrupo> listar(Seguridadgrupo seguridadgrupo);
	public int contarTotal(Seguridadgrupo seguridadgrupo);
	public int guardar(Seguridadgrupo seguridadgrupo);
	public int eliminar(Seguridadgrupo seguridadgrupo);
	public int actualizar(Seguridadgrupo seguridadgrupo);
	
    
}
