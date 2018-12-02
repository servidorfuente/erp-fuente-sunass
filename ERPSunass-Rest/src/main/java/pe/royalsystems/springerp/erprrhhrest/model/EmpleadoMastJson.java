package erp.realcoresystems.pe.erprrhhrest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import erp.realcoresystems.pe.erprrhhrest.util.JsonViewCustom;

import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties( value = {
        /**Campos a ignorar*/
        "uri"
        ,"paginable"
})
@JsonViewCustom(JsonViewInterfaces.ViewGeneral.class)
public class EmpleadoMastJson extends EntidadJson<EmpleadoMastJson> {
    private int empleado;
    private String companiaSocio;
    private String raza;
    private String religion;
    private String tipoVisa;
    private Date visaFechaInicio;
    private Date visaFechaExpiracion;
    private Date servicioMilitarDesde;
    private Date servicioMilitarHasta;
    private String numeroArchivo;
    private String locaciondePago;
    private String codigoUsuario;
    private String tipoAsistenciaSocial;
    private String centroAsistenciaSocial;
    private String tipoCarnetAsistenciaSocial;
    private String carnetAsistenciaSocial;
    private String tipoPension;
    private Date fechaInicioPension;
    private Date fechaTerminoPension;
    private String numeroAfp;
    private String bancoCts;
    private String tipoCuentaCts;
    private String tipoMonedaCts;
    private String numeroCuentaCts;
    private String estadoEmpleado;
    private Date fechaIngreso;
    private Date fechaUltimaPlanilla;
    private Date fechaInicioContrato;
    private Date fechaFinContrato;
    private Date fechaCese;
    private String razonCese;
    private Integer contratista;
    private String deptoOrganizacion;
    private String departamentoOperacional;
    private String gradoSalario;
    private String cargo;
    private String nivelAcceso;
    private String flagIpssvida;
    private String flagAccTrabajo;
    private String correoInterno;
    private BigDecimal sueldoActualLocal;
    private BigDecimal sueldoActualDolar;
    private BigDecimal sueldoAnteriorLocal;
    private BigDecimal sueldoAnteriorDolar;
    private String monedaPago;
    private String foto;
    private Date fechaLiquidacion;
    private Date fechaReingreso;
    private String unidadReplicacion;
    private Date ultimaFechaPagoVacacion;
    private String estado;
    private String rucCentroAsistenciaSocial;
    private String tarjetadeCredito;
    private Integer plantillaConcepto;
    private String flagSmf;
    private Date fechaVacaciones;
    private String flagTrabajadorPensionista;
    private String flagSctrSalud;
    private String flagSctrPension;
    private String flagDiscapacidad;
    private String flagSujetoControl;
    private String flagSindicalizado;
    private String flagDomiciliado;
    private String nivelEducativoRtps;
    private String flagRegimenAlternativo;
    private String flagJornadaMaxima;
    private String flagHorarioNocturno;
    private String flagOtrosQuinta;
    private String flagQuintaExonerada;
    private String situacionEspecial;
    private String flagMadreResponsabilidad;
    private String flagCentroFormacion;
    private String tipoModalidadFormativa;
    private String prestadorServicio;
    private String flagAseguraPension;
    private String categoriaOcupacional;
    private String flagConvenioDobleTrib;
    private String firmaDigitalizada;
    private String flagDeConfianza;
    private Date fechaBajaEps;
    private Integer codigoUnidad;
    private String ultimoUsuario;
    private Date ultimaFechaModif;
    private String division;
    private String oficina;
    private String responsableempleado;
    private String responsablejefe;
    private String tipoComisionAfp;
    private String flagTransferido;
    private String locacionAsignada;
    private String flagEducacionIep;
    private Integer jeferesponsable;
    private String unidadoperativa;
    private String ordenOrganigrama;
    private Integer empleadorelacionado;
    private String unidadtrabajo;
    private String flagEducacionCompletaIep;
    private String tiempoServicio;
    private String tiempoContratoTotal;

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    public String getCompaniaSocio() {
        return companiaSocio;
    }

    public void setCompaniaSocio(String companiaSocio) {
        this.companiaSocio = companiaSocio;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getTipoVisa() {
        return tipoVisa;
    }

    public void setTipoVisa(String tipoVisa) {
        this.tipoVisa = tipoVisa;
    }

    public Date getVisaFechaInicio() {
        return visaFechaInicio;
    }

    public void setVisaFechaInicio(Date visaFechaInicio) {
        this.visaFechaInicio = visaFechaInicio;
    }

    public Date getVisaFechaExpiracion() {
        return visaFechaExpiracion;
    }

    public void setVisaFechaExpiracion(Date visaFechaExpiracion) {
        this.visaFechaExpiracion = visaFechaExpiracion;
    }

    public Date getServicioMilitarDesde() {
        return servicioMilitarDesde;
    }

    public void setServicioMilitarDesde(Date servicioMilitarDesde) {
        this.servicioMilitarDesde = servicioMilitarDesde;
    }

    public Date getServicioMilitarHasta() {
        return servicioMilitarHasta;
    }

    public void setServicioMilitarHasta(Date servicioMilitarHasta) {
        this.servicioMilitarHasta = servicioMilitarHasta;
    }

    public String getNumeroArchivo() {
        return numeroArchivo;
    }

    public void setNumeroArchivo(String numeroArchivo) {
        this.numeroArchivo = numeroArchivo;
    }

    public String getLocaciondePago() {
        return locaciondePago;
    }

    public void setLocaciondePago(String locaciondePago) {
        this.locaciondePago = locaciondePago;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getTipoAsistenciaSocial() {
        return tipoAsistenciaSocial;
    }

    public void setTipoAsistenciaSocial(String tipoAsistenciaSocial) {
        this.tipoAsistenciaSocial = tipoAsistenciaSocial;
    }

    public String getCentroAsistenciaSocial() {
        return centroAsistenciaSocial;
    }

    public void setCentroAsistenciaSocial(String centroAsistenciaSocial) {
        this.centroAsistenciaSocial = centroAsistenciaSocial;
    }

    public String getTipoCarnetAsistenciaSocial() {
        return tipoCarnetAsistenciaSocial;
    }

    public void setTipoCarnetAsistenciaSocial(String tipoCarnetAsistenciaSocial) {
        this.tipoCarnetAsistenciaSocial = tipoCarnetAsistenciaSocial;
    }

    public String getCarnetAsistenciaSocial() {
        return carnetAsistenciaSocial;
    }

    public void setCarnetAsistenciaSocial(String carnetAsistenciaSocial) {
        this.carnetAsistenciaSocial = carnetAsistenciaSocial;
    }

    public String getTipoPension() {
        return tipoPension;
    }

    public void setTipoPension(String tipoPension) {
        this.tipoPension = tipoPension;
    }

    public Date getFechaInicioPension() {
        return fechaInicioPension;
    }

    public void setFechaInicioPension(Date fechaInicioPension) {
        this.fechaInicioPension = fechaInicioPension;
    }

    public Date getFechaTerminoPension() {
        return fechaTerminoPension;
    }

    public void setFechaTerminoPension(Date fechaTerminoPension) {
        this.fechaTerminoPension = fechaTerminoPension;
    }

    public String getNumeroAfp() {
        return numeroAfp;
    }

    public void setNumeroAfp(String numeroAfp) {
        this.numeroAfp = numeroAfp;
    }

    public String getBancoCts() {
        return bancoCts;
    }

    public void setBancoCts(String bancoCts) {
        this.bancoCts = bancoCts;
    }

    public String getTipoCuentaCts() {
        return tipoCuentaCts;
    }

    public void setTipoCuentaCts(String tipoCuentaCts) {
        this.tipoCuentaCts = tipoCuentaCts;
    }

    public String getTipoMonedaCts() {
        return tipoMonedaCts;
    }

    public void setTipoMonedaCts(String tipoMonedaCts) {
        this.tipoMonedaCts = tipoMonedaCts;
    }

    public String getNumeroCuentaCts() {
        return numeroCuentaCts;
    }

    public void setNumeroCuentaCts(String numeroCuentaCts) {
        this.numeroCuentaCts = numeroCuentaCts;
    }

    public String getEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(String estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaUltimaPlanilla() {
        return fechaUltimaPlanilla;
    }

    public void setFechaUltimaPlanilla(Date fechaUltimaPlanilla) {
        this.fechaUltimaPlanilla = fechaUltimaPlanilla;
    }

    public Date getFechaInicioContrato() {
        return fechaInicioContrato;
    }

    public void setFechaInicioContrato(Date fechaInicioContrato) {
        this.fechaInicioContrato = fechaInicioContrato;
    }

    public Date getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(Date fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }

    public Date getFechaCese() {
        return fechaCese;
    }

    public void setFechaCese(Date fechaCese) {
        this.fechaCese = fechaCese;
    }

    public String getRazonCese() {
        return razonCese;
    }

    public void setRazonCese(String razonCese) {
        this.razonCese = razonCese;
    }

    public Integer getContratista() {
        return contratista;
    }

    public void setContratista(Integer contratista) {
        this.contratista = contratista;
    }

    public String getDeptoOrganizacion() {
        return deptoOrganizacion;
    }

    public void setDeptoOrganizacion(String deptoOrganizacion) {
        this.deptoOrganizacion = deptoOrganizacion;
    }

    public String getDepartamentoOperacional() {
        return departamentoOperacional;
    }

    public void setDepartamentoOperacional(String departamentoOperacional) {
        this.departamentoOperacional = departamentoOperacional;
    }

    public String getGradoSalario() {
        return gradoSalario;
    }

    public void setGradoSalario(String gradoSalario) {
        this.gradoSalario = gradoSalario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(String nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    public String getFlagIpssvida() {
        return flagIpssvida;
    }

    public void setFlagIpssvida(String flagIpssvida) {
        this.flagIpssvida = flagIpssvida;
    }

    public String getFlagAccTrabajo() {
        return flagAccTrabajo;
    }

    public void setFlagAccTrabajo(String flagAccTrabajo) {
        this.flagAccTrabajo = flagAccTrabajo;
    }

    public String getCorreoInterno() {
        return correoInterno;
    }

    public void setCorreoInterno(String correoInterno) {
        this.correoInterno = correoInterno;
    }

    public BigDecimal getSueldoActualLocal() {
        return sueldoActualLocal;
    }

    public void setSueldoActualLocal(BigDecimal sueldoActualLocal) {
        this.sueldoActualLocal = sueldoActualLocal;
    }

    public BigDecimal getSueldoActualDolar() {
        return sueldoActualDolar;
    }

    public void setSueldoActualDolar(BigDecimal sueldoActualDolar) {
        this.sueldoActualDolar = sueldoActualDolar;
    }

    public BigDecimal getSueldoAnteriorLocal() {
        return sueldoAnteriorLocal;
    }

    public void setSueldoAnteriorLocal(BigDecimal sueldoAnteriorLocal) {
        this.sueldoAnteriorLocal = sueldoAnteriorLocal;
    }

    public BigDecimal getSueldoAnteriorDolar() {
        return sueldoAnteriorDolar;
    }

    public void setSueldoAnteriorDolar(BigDecimal sueldoAnteriorDolar) {
        this.sueldoAnteriorDolar = sueldoAnteriorDolar;
    }

    public String getMonedaPago() {
        return monedaPago;
    }

    public void setMonedaPago(String monedaPago) {
        this.monedaPago = monedaPago;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getFechaLiquidacion() {
        return fechaLiquidacion;
    }

    public void setFechaLiquidacion(Date fechaLiquidacion) {
        this.fechaLiquidacion = fechaLiquidacion;
    }

    public Date getFechaReingreso() {
        return fechaReingreso;
    }

    public void setFechaReingreso(Date fechaReingreso) {
        this.fechaReingreso = fechaReingreso;
    }

    public String getUnidadReplicacion() {
        return unidadReplicacion;
    }

    public void setUnidadReplicacion(String unidadReplicacion) {
        this.unidadReplicacion = unidadReplicacion;
    }

    public Date getUltimaFechaPagoVacacion() {
        return ultimaFechaPagoVacacion;
    }

    public void setUltimaFechaPagoVacacion(Date ultimaFechaPagoVacacion) {
        this.ultimaFechaPagoVacacion = ultimaFechaPagoVacacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRucCentroAsistenciaSocial() {
        return rucCentroAsistenciaSocial;
    }

    public void setRucCentroAsistenciaSocial(String rucCentroAsistenciaSocial) {
        this.rucCentroAsistenciaSocial = rucCentroAsistenciaSocial;
    }

    public String getTarjetadeCredito() {
        return tarjetadeCredito;
    }

    public void setTarjetadeCredito(String tarjetadeCredito) {
        this.tarjetadeCredito = tarjetadeCredito;
    }

    public Integer getPlantillaConcepto() {
        return plantillaConcepto;
    }

    public void setPlantillaConcepto(Integer plantillaConcepto) {
        this.plantillaConcepto = plantillaConcepto;
    }

    public String getFlagSmf() {
        return flagSmf;
    }

    public void setFlagSmf(String flagSmf) {
        this.flagSmf = flagSmf;
    }

    public Date getFechaVacaciones() {
        return fechaVacaciones;
    }

    public void setFechaVacaciones(Date fechaVacaciones) {
        this.fechaVacaciones = fechaVacaciones;
    }

    public String getFlagTrabajadorPensionista() {
        return flagTrabajadorPensionista;
    }

    public void setFlagTrabajadorPensionista(String flagTrabajadorPensionista) {
        this.flagTrabajadorPensionista = flagTrabajadorPensionista;
    }

    public String getFlagSctrSalud() {
        return flagSctrSalud;
    }

    public void setFlagSctrSalud(String flagSctrSalud) {
        this.flagSctrSalud = flagSctrSalud;
    }

    public String getFlagSctrPension() {
        return flagSctrPension;
    }

    public void setFlagSctrPension(String flagSctrPension) {
        this.flagSctrPension = flagSctrPension;
    }

    public String getFlagDiscapacidad() {
        return flagDiscapacidad;
    }

    public void setFlagDiscapacidad(String flagDiscapacidad) {
        this.flagDiscapacidad = flagDiscapacidad;
    }

    public String getFlagSujetoControl() {
        return flagSujetoControl;
    }

    public void setFlagSujetoControl(String flagSujetoControl) {
        this.flagSujetoControl = flagSujetoControl;
    }

    public String getFlagSindicalizado() {
        return flagSindicalizado;
    }

    public void setFlagSindicalizado(String flagSindicalizado) {
        this.flagSindicalizado = flagSindicalizado;
    }

    public String getFlagDomiciliado() {
        return flagDomiciliado;
    }

    public void setFlagDomiciliado(String flagDomiciliado) {
        this.flagDomiciliado = flagDomiciliado;
    }

    public String getNivelEducativoRtps() {
        return nivelEducativoRtps;
    }

    public void setNivelEducativoRtps(String nivelEducativoRtps) {
        this.nivelEducativoRtps = nivelEducativoRtps;
    }

    public String getFlagRegimenAlternativo() {
        return flagRegimenAlternativo;
    }

    public void setFlagRegimenAlternativo(String flagRegimenAlternativo) {
        this.flagRegimenAlternativo = flagRegimenAlternativo;
    }

    public String getFlagJornadaMaxima() {
        return flagJornadaMaxima;
    }

    public void setFlagJornadaMaxima(String flagJornadaMaxima) {
        this.flagJornadaMaxima = flagJornadaMaxima;
    }

    public String getFlagHorarioNocturno() {
        return flagHorarioNocturno;
    }

    public void setFlagHorarioNocturno(String flagHorarioNocturno) {
        this.flagHorarioNocturno = flagHorarioNocturno;
    }

    public String getFlagOtrosQuinta() {
        return flagOtrosQuinta;
    }

    public void setFlagOtrosQuinta(String flagOtrosQuinta) {
        this.flagOtrosQuinta = flagOtrosQuinta;
    }

    public String getFlagQuintaExonerada() {
        return flagQuintaExonerada;
    }

    public void setFlagQuintaExonerada(String flagQuintaExonerada) {
        this.flagQuintaExonerada = flagQuintaExonerada;
    }

    public String getSituacionEspecial() {
        return situacionEspecial;
    }

    public void setSituacionEspecial(String situacionEspecial) {
        this.situacionEspecial = situacionEspecial;
    }

    public String getFlagMadreResponsabilidad() {
        return flagMadreResponsabilidad;
    }

    public void setFlagMadreResponsabilidad(String flagMadreResponsabilidad) {
        this.flagMadreResponsabilidad = flagMadreResponsabilidad;
    }

    public String getFlagCentroFormacion() {
        return flagCentroFormacion;
    }

    public void setFlagCentroFormacion(String flagCentroFormacion) {
        this.flagCentroFormacion = flagCentroFormacion;
    }

    public String getTipoModalidadFormativa() {
        return tipoModalidadFormativa;
    }

    public void setTipoModalidadFormativa(String tipoModalidadFormativa) {
        this.tipoModalidadFormativa = tipoModalidadFormativa;
    }

    public String getPrestadorServicio() {
        return prestadorServicio;
    }

    public void setPrestadorServicio(String prestadorServicio) {
        this.prestadorServicio = prestadorServicio;
    }

    public String getFlagAseguraPension() {
        return flagAseguraPension;
    }

    public void setFlagAseguraPension(String flagAseguraPension) {
        this.flagAseguraPension = flagAseguraPension;
    }

    public String getCategoriaOcupacional() {
        return categoriaOcupacional;
    }

    public void setCategoriaOcupacional(String categoriaOcupacional) {
        this.categoriaOcupacional = categoriaOcupacional;
    }

    public String getFlagConvenioDobleTrib() {
        return flagConvenioDobleTrib;
    }

    public void setFlagConvenioDobleTrib(String flagConvenioDobleTrib) {
        this.flagConvenioDobleTrib = flagConvenioDobleTrib;
    }

    public String getFirmaDigitalizada() {
        return firmaDigitalizada;
    }

    public void setFirmaDigitalizada(String firmaDigitalizada) {
        this.firmaDigitalizada = firmaDigitalizada;
    }

    public String getFlagDeConfianza() {
        return flagDeConfianza;
    }

    public void setFlagDeConfianza(String flagDeConfianza) {
        this.flagDeConfianza = flagDeConfianza;
    }

    public Date getFechaBajaEps() {
        return fechaBajaEps;
    }

    public void setFechaBajaEps(Date fechaBajaEps) {
        this.fechaBajaEps = fechaBajaEps;
    }

    public Integer getCodigoUnidad() {
        return codigoUnidad;
    }

    public void setCodigoUnidad(Integer codigoUnidad) {
        this.codigoUnidad = codigoUnidad;
    }

    public String getUltimoUsuario() {
        return ultimoUsuario;
    }

    public void setUltimoUsuario(String ultimoUsuario) {
        this.ultimoUsuario = ultimoUsuario;
    }

    public Date getUltimaFechaModif() {
        return ultimaFechaModif;
    }

    public void setUltimaFechaModif(Date ultimaFechaModif) {
        this.ultimaFechaModif = ultimaFechaModif;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getResponsableempleado() {
        return responsableempleado;
    }

    public void setResponsableempleado(String responsableempleado) {
        this.responsableempleado = responsableempleado;
    }

    public String getResponsablejefe() {
        return responsablejefe;
    }

    public void setResponsablejefe(String responsablejefe) {
        this.responsablejefe = responsablejefe;
    }

    public String getTipoComisionAfp() {
        return tipoComisionAfp;
    }

    public void setTipoComisionAfp(String tipoComisionAfp) {
        this.tipoComisionAfp = tipoComisionAfp;
    }

    public String getFlagTransferido() {
        return flagTransferido;
    }

    public void setFlagTransferido(String flagTransferido) {
        this.flagTransferido = flagTransferido;
    }

    public String getLocacionAsignada() {
        return locacionAsignada;
    }

    public void setLocacionAsignada(String locacionAsignada) {
        this.locacionAsignada = locacionAsignada;
    }

    public String getFlagEducacionIep() {
        return flagEducacionIep;
    }

    public void setFlagEducacionIep(String flagEducacionIep) {
        this.flagEducacionIep = flagEducacionIep;
    }

    public Integer getJeferesponsable() {
        return jeferesponsable;
    }

    public void setJeferesponsable(Integer jeferesponsable) {
        this.jeferesponsable = jeferesponsable;
    }

    public String getUnidadoperativa() {
        return unidadoperativa;
    }

    public void setUnidadoperativa(String unidadoperativa) {
        this.unidadoperativa = unidadoperativa;
    }

    public String getOrdenOrganigrama() {
        return ordenOrganigrama;
    }

    public void setOrdenOrganigrama(String ordenOrganigrama) {
        this.ordenOrganigrama = ordenOrganigrama;
    }

    public Integer getEmpleadorelacionado() {
        return empleadorelacionado;
    }

    public void setEmpleadorelacionado(Integer empleadorelacionado) {
        this.empleadorelacionado = empleadorelacionado;
    }

    public String getUnidadtrabajo() {
        return unidadtrabajo;
    }

    public void setUnidadtrabajo(String unidadtrabajo) {
        this.unidadtrabajo = unidadtrabajo;
    }

    public String getFlagEducacionCompletaIep() {
        return flagEducacionCompletaIep;
    }

    public void setFlagEducacionCompletaIep(String flagEducacionCompletaIep) {
        this.flagEducacionCompletaIep = flagEducacionCompletaIep;
    }

    public String getTiempoServicio() {
        return tiempoServicio;
    }

    public void setTiempoServicio(String tiempoServicio) {
        this.tiempoServicio = tiempoServicio;
    }

    public String getTiempoContratoTotal() {
        return tiempoContratoTotal;
    }

    public void setTiempoContratoTotal(String tiempoContratoTotal) {
        this.tiempoContratoTotal = tiempoContratoTotal;
    }
}
