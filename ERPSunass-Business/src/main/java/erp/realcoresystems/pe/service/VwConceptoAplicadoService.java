package erp.realcoresystems.pe.service;

import java.util.List;

import erp.realcoresystems.pe.model.domain.vista.VwConceptoAplicado;

public interface VwConceptoAplicadoService {

	public List<VwConceptoAplicado> listarElementos(VwConceptoAplicado objDao, boolean paginable);
	public List<VwConceptoAplicado> validate(VwConceptoAplicado filtro);
	public int contador(VwConceptoAplicado filtro);
	public VwConceptoAplicado obtenerPorId(VwConceptoAplicado filtro);
}
