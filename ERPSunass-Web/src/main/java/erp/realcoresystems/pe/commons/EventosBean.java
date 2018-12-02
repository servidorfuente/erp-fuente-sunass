package erp.realcoresystems.pe.commons;

import java.io.InputStream;
import java.util.List;

import erp.realcoresystems.pe.model.domain.AcCostCenterMst;
import erp.realcoresystems.pe.model.domain.Personamast;
import org.primefaces.model.UploadedFile;




//import erp.realcoresystems.pe.service.ws.curso.SaCurso;

public class EventosBean {

	/************ DECLARACIONES INTERFACES *******************/



	public EventoSeleccionPersonamast eventoSeleccionPersonamast;

	public EventoSeleccionPersonamast getEventoSeleccionPersonamast() {
		return eventoSeleccionPersonamast;
	}

	public void setEventoSeleccionPersonamast(EventoSeleccionPersonamast eventoSeleccionPersonamast) {
		this.eventoSeleccionPersonamast = eventoSeleccionPersonamast;
	}

	public EventoSeleccionUploadFile eventoSeleccionUploadFile;

	public EventoSeleccionUploadFile getEventoSeleccionUploadFile() {
		return eventoSeleccionUploadFile;
	}

	public void setEventoSeleccionUploadFile(EventoSeleccionUploadFile eventoSeleccionUploadFile) {
		this.eventoSeleccionUploadFile = eventoSeleccionUploadFile;
	}

	public EventoGeneracionReportesGen EventoGeneracionReportesGen;

	public EventoGeneracionReportesGen getEventoGeneracionReportesGen() {
		return EventoGeneracionReportesGen;
	}

	public void setEventoGeneracionReportesGen(EventoGeneracionReportesGen eventoGeneracionReportesGen) {
		EventoGeneracionReportesGen = eventoGeneracionReportesGen;
	}

	// Evento seleccion de Mensajes

	private EventoSeleccionMensajes eventoSeleccionMensajes;

	public EventoSeleccionMensajes getEventoSeleccionMensajes() {
		return eventoSeleccionMensajes;
	}

	// Evento de Reportes Generico
	private EventoGenericReporte eventoGenericReporte;

	public EventoGenericReporte getEventoGenericReporte() {
		return eventoGenericReporte;
	}

	public void setEventoGenericReporte(EventoGenericReporte eventoGenericReporte) {
		this.eventoGenericReporte = eventoGenericReporte;
	}

	// Evento seleccion de motivos de nota de credito

	private EventoGeneralRegistro eventoGeneralRegistro;

	public EventoGeneralRegistro getEventoGeneralRegistro() {
		return eventoGeneralRegistro;
	}

	public void setEventoGeneralRegistro(EventoGeneralRegistro eventoGeneralRegistro) {
		this.eventoGeneralRegistro = eventoGeneralRegistro;
	}



	
	// Evento seleccion - AcCostCenterMst

	private EventoSeleccionAcCostCenterMst eventoSeleccionAcCostCenterMst;

	public EventoSeleccionAcCostCenterMst getEventoSeleccionAcCostCenterMst() {
		return eventoSeleccionAcCostCenterMst;
	}

	public void setEventoSeleccionAcCostCenterMst(EventoSeleccionAcCostCenterMst eventoSeleccionAcCostCenterMst) {
		this.eventoSeleccionAcCostCenterMst = eventoSeleccionAcCostCenterMst;
	}
	

	/*****************************************/
	/********** CREACION INTERFACES **************/

	public interface EventoSeleccionPersonamast {
		public void retornoSeleccion(Personamast personamast, String mensaje);

	}

	public interface EventoSeleccionUploadFile {
		public void retornoObjectInputStreamFile(InputStream objInputStream, String nombreFile, Integer flagExito);

		public void retornoObjectFileBytes(Object objSeleccion, String nombreFile, Integer flagExito);

		public void retornoObjectFileUpload(UploadedFile fileUpload, Integer flagExito);
	}

	public interface EventoGeneracionReportesGen {
		public void retornoGeneracionAceptar(String mensaje);
	}

	public interface EventoSeleccionMensajes {
		public void btnAceptar();

		public void btnCancelar();
	}

	public interface EventoGenericReporte {
		public void eventoAceptar(Integer indica, String mensaje);

		public void eventoValidacion(Integer indica, String mensaje);
	}

	public interface EventoGeneralRegistro {
		public void retornoAceptar(Integer indica, String mensaje);

		public void retornoCancelar(Integer indica, String mensaje);

		public void retornoOperacion(String indicaTipo, Object objeto, String mensaje);

	}




	// Zona Postal
	public interface EventoSeleccionVwCwZonaPostal {

	}
	public EventoSeleccionVwCwZonaPostal eventoSeleccionVwCwZonaPostal;

	public EventoSeleccionVwCwZonaPostal getEventoSeleccionVwCwZonaPostal() {
		return eventoSeleccionVwCwZonaPostal;
	}

	public void setEventoSeleccionVwCwZonaPostal(EventoSeleccionVwCwZonaPostal eventoSeleccionVwCwZonaPostal) {
		this.eventoSeleccionVwCwZonaPostal = eventoSeleccionVwCwZonaPostal;
	}

	public interface EventoSeleccionAcCostCenterMst {
		public void retornoAcCostCenterMst(AcCostCenterMst coscentermst, String mensaje);
	}

}