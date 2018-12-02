package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.SaHcAnamnesisAp;
import erp.realcoresystems.pe.model.domain.SaHcAnamnesisApPK;

public interface SaHcAnamnesisApDao {
		
	public SaHcAnamnesisAp obtenerPorID(SaHcAnamnesisApPK id);		
	public List<SaHcAnamnesisAp> listarElementos(SaHcAnamnesisAp objDao, boolean paginable);
	public int contarElementos(SaHcAnamnesisAp objDao);
		
	public int guardar(SaHcAnamnesisAp objDao);	
	public int eliminar(SaHcAnamnesisAp objDao);
	public int actualizar(SaHcAnamnesisAp objDao);
}
