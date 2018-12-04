package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.MaMiscelaneosheader;

public interface SaMiscelaneosHeaderService {

	public List<MaMiscelaneosheader> listarElementos(MaMiscelaneosheader maMiscelaneosheader);
	
	public List<MaMiscelaneosheader> listar(MaMiscelaneosheader filtro, boolean paginable);
	public int contar(MaMiscelaneosheader filtro);
	
	public MaMiscelaneosheader obtenerPorID(MaMiscelaneosheader maMiscelaneosheader);

	public int guardar(MaMiscelaneosheader objSave);
	public int actualizar(MaMiscelaneosheader objSave);
	public int eliminar(MaMiscelaneosheader objSave);

	
}
