package erp.realcoresystems.pe.commons.model;


import java.util.List;

import erp.realcoresystems.pe.commons.UtilesCommons;

public class PaginaModel <T>{
	
	public static final boolean PAGINABLE = Boolean.TRUE;
	public static final boolean NO_PAGINABLE = Boolean.FALSE;
	public static final int NO_PAGINABLE_ELEMENTOS = -1;
	public static final int MIN_POSICION_INICIAL = 0;

	private List<T> listaElementos;
	private int nroTotalElementos;
	private boolean paginable;
	private int nroPagina;
	private int posicionInicial;
	private int dimensionPagina;
	private int posicionFinal;
	
	private PaginaModel(List<T> listaElementos, int nroTotalElementos, boolean paginable) {
		this.listaElementos = listaElementos;
		this.nroTotalElementos = nroTotalElementos;
		this.paginable = paginable;
	}
	
	private PaginaModel(List<T> listaElementos, int nroTotalElementos, int posicionInicial, int dimensionPagina, boolean paginable) {
		this.listaElementos = listaElementos;
		this.nroTotalElementos = nroTotalElementos;
		this.paginable = paginable;
		this.posicionInicial = posicionInicial;
		this.dimensionPagina = dimensionPagina;
	}
	
	private PaginaModel(List<T> listaElementos, int nroTotalElementos, int posicionInicial, int dimensionPagina, int nroPagina, int posicionFinal, boolean paginable) {
		this.listaElementos = listaElementos;
		this.nroTotalElementos = nroTotalElementos;
		this.paginable = paginable;
		this.posicionInicial = posicionInicial;
		this.dimensionPagina = dimensionPagina;
		this.nroPagina = nroPagina;
		this.posicionFinal = posicionFinal;
	}

	public static <T> PaginaModel<T> crearPagina(List<T> listaElementos, int nroTotalElementos){
		return new PaginaModel<T>(listaElementos, nroTotalElementos, PAGINABLE);
	}
	
	public static <T> PaginaModel<T> crearPagina(List<T> listaElementos, int nroTotalElementos, int posicionInicial, int dimensionPagina){
		int posicionFinal = (posicionInicial+dimensionPagina) - 1;
		int nroPagina = (posicionFinal - posicionInicial + 1)/dimensionPagina;
		return new PaginaModel<T>(listaElementos, nroTotalElementos, posicionInicial, dimensionPagina, posicionFinal, nroPagina, PAGINABLE);
	}
	
	public static <T> PaginaModel<T> crearPaginaVacia(){
		List<T> listaElementos = UtilesCommons.getNewList();
		return new PaginaModel<T>(listaElementos, 0, PAGINABLE);
	}
	
	public static <T> PaginaModel<T> crearSinPaginacion(List<T> listaElementos){
		return new PaginaModel<T>(listaElementos, NO_PAGINABLE_ELEMENTOS, NO_PAGINABLE);
	}
	
	public static <T> PaginaModel<T> crearSinPaginacion(){
		List<T> listaElementos = UtilesCommons.getNewList();
		return new PaginaModel<T>(listaElementos, NO_PAGINABLE_ELEMENTOS, NO_PAGINABLE);
	}

	public List<T> getListaElementos() {
		return listaElementos;
	}

	public void setListaElementos(List<T> listaElementos) {
		this.listaElementos = listaElementos;
	}

	public int getNroTotalElementos() {
		return nroTotalElementos;
	}

	public void setNroTotalElementos(int nroTotalElementos) {
		this.nroTotalElementos = nroTotalElementos;
	}

	public boolean isPaginable() {
		return paginable;
	}

	public void setPaginable(boolean paginable) {
		this.paginable = paginable;
	}

	public int getNroPagina() {
		return nroPagina;
	}

	public void setNroPagina(int nroPagina) {
		this.nroPagina = nroPagina;
	}

	public int getPosicionInicial() {
		return posicionInicial;
	}

	public void setPosicionInicial(int posicionInicial) {
		this.posicionInicial = posicionInicial;
	}

	public int getDimensionPagina() {
		return dimensionPagina;
	}

	public void setDimensionPagina(int dimensionPagina) {
		this.dimensionPagina = dimensionPagina;
	}

	public int getPosicionFinal() {
		return posicionFinal;
	}

	public void setPosicionFinal(int posicionFinal) {
		this.posicionFinal = posicionFinal;
	}
}
