package erp.realcoresystems.pe.model.dao;

import java.util.List;

import erp.realcoresystems.pe.model.domain.MaMiscelaneosheader;

public interface SaMiscelaneosHeaderDao extends AbstractDao<MaMiscelaneosheader, String> {

	public MaMiscelaneosheader obtenerPorID(MaMiscelaneosheader obj);
	
	public 	List<MaMiscelaneosheader> listarElementos(MaMiscelaneosheader filtro);
	public 	List<MaMiscelaneosheader> listar(MaMiscelaneosheader filtro, boolean paginable);
	public int contar(MaMiscelaneosheader filtro);

	public int guardar(MaMiscelaneosheader obj);
	public int actualizar(MaMiscelaneosheader obj);
	public int eliminar(MaMiscelaneosheader obj);


	
	
}
