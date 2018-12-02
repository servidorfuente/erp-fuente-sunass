package erp.realcoresystems.pe.commons.model;

import org.joda.time.DateTime;

import erp.realcoresystems.pe.commons.TimeCommons;

public class HorarioModel {

	private String id;
	private String idSecundario;
	private DateTime fecha;
	private DateTime fechaInicio;
	private DateTime fechaFin;
	private DateTime horaInicio;
	private DateTime horaFin;
	private String estado;
	
	private DateTime horaInicioSup;
	private DateTime horaFinSup;
	
	public HorarioModel() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getIdSecundario() {
		return idSecundario;
	}
	
	public void setIdSecundario(String idSecundario) {
		this.idSecundario = idSecundario;
	}

	public DateTime getFecha() {
		return fecha;
	}

	public void setFecha(DateTime fecha) {
		this.fecha = fecha;
	}

	public DateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(DateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public DateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(DateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public DateTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(DateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public DateTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(DateTime horaFin) {
		this.horaFin = horaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public DateTime getHoraInicioSup() {
		return horaInicioSup;
	}

	public void setHoraInicioSup(DateTime horaInicioSup) {
		this.horaInicioSup = horaInicioSup;
	}

	public DateTime getHoraFinSup() {
		return horaFinSup;
	}

	public void setHoraFinSup(DateTime horaFinSup) {
		this.horaFinSup = horaFinSup;
	}

	@Override
	public String toString() {
		String str = "id = "+id+" cita: ["+fecha.toString(TimeCommons.PATTERN_FECHA)+" "+horaInicio.toString(TimeCommons.PATTERN_HORA)+" - "+horaFin.toString(TimeCommons.PATTERN_HORA)+"]";
		str = str + " idSecundario = "+idSecundario+" horario: ["+fecha.toString(TimeCommons.PATTERN_FECHA)+" "+horaInicioSup.toString(TimeCommons.PATTERN_HORA)+" - "+horaFinSup.toString(TimeCommons.PATTERN_HORA)+"]";
		return str;
	}
	
	
}
