package erp.realcoresystems.pe.model.dao;


import erp.realcoresystems.pe.model.domain.SsFormcom01A;
import erp.realcoresystems.pe.model.domain.SsFormcom01APK;

import java.util.List;

public interface SsFormcom01ADao extends AbstractDao<SsFormcom01A, SsFormcom01APK>{
	public SsFormcom01A buscar(SsFormcom01A filtro);
	public List<SsFormcom01A> listar(SsFormcom01A filtro, boolean pagina);
	public int contar(SsFormcom01A filtro);
	public int guardar(SsFormcom01A objDao);
	public int actualizar(SsFormcom01A objDao);
	public int eliminar(SsFormcom01A objDao);
}
