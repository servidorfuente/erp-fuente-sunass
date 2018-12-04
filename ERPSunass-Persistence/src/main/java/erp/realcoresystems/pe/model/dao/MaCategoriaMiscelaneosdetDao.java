package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.MaCategoriaMiscelaneosdet;
import erp.realcoresystems.pe.model.domain.MaCategoriaMiscelaneosdetPK;

public interface MaCategoriaMiscelaneosdetDao  extends AbstractDao<MaCategoriaMiscelaneosdet, MaCategoriaMiscelaneosdetPK> {
	public List<MaCategoriaMiscelaneosdet> listarElementos(MaCategoriaMiscelaneosdet objDao,boolean paginable);		
	public int contarElementos(MaCategoriaMiscelaneosdet objDao);
	
	public int guardar(MaCategoriaMiscelaneosdet objDao);		
	public int actualizar(MaCategoriaMiscelaneosdet objDao);
	public int eliminar(MaCategoriaMiscelaneosdet objDao);
	
	
	public int guardarAuditoria(MaCategoriaMiscelaneosdet obj , String tipoTransaccion);
}
