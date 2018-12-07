package erp.realcoresystems.pe.model.dao;

 import erp.realcoresystems.pe.model.domain.SsCargainicial;
 import erp.realcoresystems.pe.model.domain.SsCargainicialPK;
 import erp.realcoresystems.pe.model.domain.vista.VwCargainicial;

 import java.util.List;

public interface SsCargainicialDao extends AbstractDao<SsCargainicial, SsCargainicialPK>{
	public SsCargainicial buscar(SsCargainicial filtro);
	public SsCargainicial verificar(SsCargainicial filtro);
	public List<SsCargainicial> listar(SsCargainicial filtro, boolean pagina);
	public List<VwCargainicial> listarVista(VwCargainicial vista, SsCargainicial entidad, boolean pagina);
	public int contarVista(VwCargainicial filtro);
	public int contar(SsCargainicial filtro);
	public int guardar(SsCargainicial objDao);
	public int actualizar(SsCargainicial objDao);
	public int eliminar(SsCargainicial objDao);
}

