package erp.realcoresystems.pe.model.dao;

import java.util.List;
import erp.realcoresystems.pe.model.domain.Companyowner;

public interface CompaniaOwnerDao extends AbstractDao<Companyowner, String>{

	public List<Companyowner> listarCompanias(Companyowner companyowner) throws Exception;
	public List<Companyowner> listar(Companyowner filtro);
	public List<Companyowner> listados(Companyowner filtro, boolean pagina);

	public int guardar(Companyowner objDao);
	public int actualizar(Companyowner objDao);
	public int eliminar(Companyowner objDao);

	public int contar(Companyowner filtro);

}
