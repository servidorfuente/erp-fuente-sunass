package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.MaCategoriaMiscelaneosdet;
import erp.realcoresystems.pe.model.domain.MaCategoriaMiscelaneosdetPK;

public interface MaCategoriaMiscelaneosdetService {

	public MaCategoriaMiscelaneosdet obtenerPorId(MaCategoriaMiscelaneosdetPK id);
	public List<MaCategoriaMiscelaneosdet> listarElementos(MaCategoriaMiscelaneosdet objDao, boolean paginable);
	public int contarElementos(MaCategoriaMiscelaneosdet objDao);
	
	public String getDesripcionTotal(String appCode, String codeCategTabla, Integer categSecuencia, Integer nivel);
	
	public int guardar(MaCategoriaMiscelaneosdet objDao);		
	public int actualizar(MaCategoriaMiscelaneosdet objDao);
	public int eliminar(MaCategoriaMiscelaneosdet objDao);
}
