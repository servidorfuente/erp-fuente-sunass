package erp.realcoresystems.pe.model.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@SuppressWarnings("serial")
@Entity
public class CompaniaMast extends Entidad{
	
    private String companiacodigo;
    private String descripcioncorta;
    private String descripcionlarga;
    private String direccioncomun;
    private String direccionadicional;
    private Date fechafundacion;
    private String telefono1;
    private String telefono2;
    private String telefono3;
    private String fax1;
    private String fax2;
    private String documentofiscal;
    private String propietariopordefecto;
    private String descripcionextranjera;
    private String monedapordefecto;
    private String tipocompania;
    private String factorrvalidacion;
    private String afectoigvflag;
    private String creditofiscalfactorflag;
    private String cuentaprovisionsbsflag;
    private String logofile;
    private Integer persona;
    private String estado;
    private String ultimousuario;   
    private Date ultimafechamodif;
    private String representantelegal;
    private String paginaweb;
    private String afectoretencionigvflag;
    private String certificadoinscripcion;
    private String detraccioncuentabancaria;
    private String regimenlaboralrtps;
    private String representantelegaldocumento;
    private String codigoanterior;
    private String departamento;
    private String provincia;
    private String codigopostal;
    
    private Set<Companyowner> listCompanyowner;
    
    @Basic
    @javax.persistence.Column(name = "DESCRIPCIONCORTA")
    public String getDescripcioncorta() {
        return descripcioncorta;
    }

    public void setDescripcioncorta(String descripcioncorta) {
        this.descripcioncorta = descripcioncorta;
    }
    
    @Id
    @javax.persistence.Column(name = "COMPANIACODIGO")
    public String getCompaniacodigo() {
        return companiacodigo;
    }

    public void setCompaniacodigo(String companiacodigo) {
        this.companiacodigo = companiacodigo;
    }

    @Basic
    @javax.persistence.Column(name = "DESCRIPCIONLARGA")
    public String getDescripcionlarga() {
        return descripcionlarga;
    }

    public void setDescripcionlarga(String descripcionlarga) {
        this.descripcionlarga = descripcionlarga;
    }

    @Basic
    @javax.persistence.Column(name = "DIRECCIONCOMUN")
    public String getDireccioncomun() {
        return direccioncomun;
    }

    public void setDireccioncomun(String direccioncomun) {
        this.direccioncomun = direccioncomun;
    }

    @Basic
    @javax.persistence.Column(name = "DIRECCIONADICIONAL")
    public String getDireccionadicional() {
        return direccionadicional;
    }

    public void setDireccionadicional(String direccionadicional) {
        this.direccionadicional = direccionadicional;
    }


    @Basic
    @javax.persistence.Column(name = "FECHAFUNDACION")
    public Date getFechafundacion() {
        return fechafundacion;
    }

    public void setFechafundacion(Date fechafundacion) {
        this.fechafundacion = fechafundacion;
    }

    @Basic
    @javax.persistence.Column(name = "TELEFONO1")
    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    @Basic
    @javax.persistence.Column(name = "TELEFONO2")
    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    @Basic
    @javax.persistence.Column(name = "TELEFONO3")
    public String getTelefono3() {
        return telefono3;
    }

    public void setTelefono3(String telefono3) {
        this.telefono3 = telefono3;
    }
    
    @Basic
    @javax.persistence.Column(name = "FAX1")
    public String getFax1() {
        return fax1;
    }

    public void setFax1(String fax1) {
        this.fax1 = fax1;
    }

    @Basic
    @javax.persistence.Column(name = "FAX2")
    public String getFax2() {
        return fax2;
    }

    public void setFax2(String fax2) {
        this.fax2 = fax2;
    }

    @Basic
    @javax.persistence.Column(name = "DOCUMENTOFISCAL")
    public String getDocumentofiscal() {
        return documentofiscal;
    }

    public void setDocumentofiscal(String documentofiscal) {
        this.documentofiscal = documentofiscal;
    }

    @Basic
    @javax.persistence.Column(name = "PROPIETARIOPORDEFECTO")
    public String getPropietariopordefecto() {
        return propietariopordefecto;
    }

    public void setPropietariopordefecto(String propietariopordefecto) {
        this.propietariopordefecto = propietariopordefecto;
    }

    @Basic
    @javax.persistence.Column(name = "DESCRIPCIONEXTRANJERA")
    public String getDescripcionextranjera() {
        return descripcionextranjera;
    }

    public void setDescripcionextranjera(String descripcionextranjera) {
        this.descripcionextranjera = descripcionextranjera;
    }

    @Basic
    @javax.persistence.Column(name = "MONEDAPORDEFECTO")
    public String getMonedapordefecto() {
        return monedapordefecto;
    }

    public void setMonedapordefecto(String monedapordefecto) {
        this.monedapordefecto = monedapordefecto;
    }

    @Basic
    @javax.persistence.Column(name = "TIPOCOMPANIA")
    public String getTipocompania() {
        return tipocompania;
    }

    public void setTipocompania(String tipocompania) {
        this.tipocompania = tipocompania;
    }

    @Basic
    @javax.persistence.Column(name = "FACTORRVALIDACION")
    public String getFactorrvalidacion() {
        return factorrvalidacion;
    }

    public void setFactorrvalidacion(String factorrvalidacion) {
        this.factorrvalidacion = factorrvalidacion;
    }
    
    @Basic
    @javax.persistence.Column(name = "AFECTOIGVFLAG")
    public String getAfectoigvflag() {
        return afectoigvflag;
    }

    public void setAfectoigvflag(String afectoigvflag) {
        this.afectoigvflag = afectoigvflag;
    }

    @Basic
    @javax.persistence.Column(name = "CREDITOFISCALFACTORFLAG")
    public String getCreditofiscalfactorflag() {
        return creditofiscalfactorflag;
    }

    public void setCreditofiscalfactorflag(String creditofiscalfactorflag) {
        this.creditofiscalfactorflag = creditofiscalfactorflag;
    }

    @Basic
    @javax.persistence.Column(name = "CUENTAPROVISIONSBSFLAG")
    public String getCuentaprovisionsbsflag() {
        return cuentaprovisionsbsflag;
    }

    public void setCuentaprovisionsbsflag(String cuentaprovisionsbsflag) {
        this.cuentaprovisionsbsflag = cuentaprovisionsbsflag;
    }

    @Basic
    @javax.persistence.Column(name = "LOGOFILE")
    public String getLogofile() {
        return logofile;
    }

    public void setLogofile(String logofile) {
        this.logofile = logofile;
    }

    @Basic
    @javax.persistence.Column(name = "PERSONA")
    public Integer getPersona() {
        return persona;
    }

    public void setPersona(Integer persona) {
        this.persona = persona;
    }

    @Basic
    @javax.persistence.Column(name = "ESTADO")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Basic
    @javax.persistence.Column(name = "ULTIMOUSUARIO")
    public String getUltimousuario() {
        return ultimousuario;
    }

    public void setUltimousuario(String ultimousuario) {
        this.ultimousuario = ultimousuario;
    }

    @Basic
    @javax.persistence.Column(name = "ULTIMAFECHAMODIF")
    public Date getUltimafechamodif() {
        return ultimafechamodif;
    }

    public void setUltimafechamodif(Date ultimafechamodif) {
        this.ultimafechamodif = ultimafechamodif;
    }

    @Basic
    @javax.persistence.Column(name = "REPRESENTANTELEGAL")
    public String getRepresentantelegal() {
        return representantelegal;
    }

    public void setRepresentantelegal(String representantelegal) {
        this.representantelegal = representantelegal;
    }

    @Basic
    @javax.persistence.Column(name = "PAGINAWEB")
    public String getPaginaweb() {
        return paginaweb;
    }

    public void setPaginaweb(String paginaweb) {
        this.paginaweb = paginaweb;
    }

    @Basic
    @javax.persistence.Column(name = "AFECTORETENCIONIGVFLAG")
    public String getAfectoretencionigvflag() {
        return afectoretencionigvflag;
    }

    public void setAfectoretencionigvflag(String afectoretencionigvflag) {
        this.afectoretencionigvflag = afectoretencionigvflag;
    }

    @Basic
    @javax.persistence.Column(name = "CERTIFICADOINSCRIPCION")
    public String getCertificadoinscripcion() {
        return certificadoinscripcion;
    }

    public void setCertificadoinscripcion(String certificadoinscripcion) {
        this.certificadoinscripcion = certificadoinscripcion;
    }

    @Basic
    @javax.persistence.Column(name = "DETRACCIONCUENTABANCARIA")
    public String getDetraccioncuentabancaria() {
        return detraccioncuentabancaria;
    }

    public void setDetraccioncuentabancaria(String detraccioncuentabancaria) {
        this.detraccioncuentabancaria = detraccioncuentabancaria;
    }

    @Basic
    @javax.persistence.Column(name = "REGIMENLABORALRTPS")
    public String getRegimenlaboralrtps() {
        return regimenlaboralrtps;
    }

    public void setRegimenlaboralrtps(String regimenlaboralrtps) {
        this.regimenlaboralrtps = regimenlaboralrtps;
    }

    @Basic
    @javax.persistence.Column(name = "REPRESENTANTELEGALDOCUMENTO")
    public String getRepresentantelegaldocumento() {
        return representantelegaldocumento;
    }

    public void setRepresentantelegaldocumento(String representantelegaldocumento) {
        this.representantelegaldocumento = representantelegaldocumento;
    }

    @Basic
    @javax.persistence.Column(name = "CODIGOANTERIOR")
    public String getCodigoanterior() {
        return codigoanterior;
    }

    public void setCodigoanterior(String codigoanterior) {
        this.codigoanterior = codigoanterior;
    }

    @Basic
    @javax.persistence.Column(name = "DEPARTAMENTO")
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Basic
    @javax.persistence.Column(name = "PROVINCIA")
    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Basic
    @javax.persistence.Column(name = "CODIGOPOSTAL")
    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }
    
    @OneToMany(mappedBy="company")
	public Set<Companyowner> getListCompanyowner() {
		return listCompanyowner;
	}

	public void setListCompanyowner(Set<Companyowner> listCompanyowner) {
		this.listCompanyowner = listCompanyowner;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompaniaMast that = (CompaniaMast) o;

        if (companiacodigo != null ? !companiacodigo.equals(that.companiacodigo) : that.companiacodigo != null)
            return false;
        if (descripcioncorta != null ? !descripcioncorta.equals(that.descripcioncorta) : that.descripcioncorta != null)
            return false;
        if (descripcionlarga != null ? !descripcionlarga.equals(that.descripcionlarga) : that.descripcionlarga != null)
            return false;
        if (direccioncomun != null ? !direccioncomun.equals(that.direccioncomun) : that.direccioncomun != null)
            return false;
        if (direccionadicional != null ? !direccionadicional.equals(that.direccionadicional) : that.direccionadicional != null)
            return false;
        if (fechafundacion != null ? !fechafundacion.equals(that.fechafundacion) : that.fechafundacion != null)
            return false;
        if (telefono1 != null ? !telefono1.equals(that.telefono1) : that.telefono1 != null) return false;
        if (telefono2 != null ? !telefono2.equals(that.telefono2) : that.telefono2 != null) return false;
        if (telefono3 != null ? !telefono3.equals(that.telefono3) : that.telefono3 != null) return false;
        if (fax1 != null ? !fax1.equals(that.fax1) : that.fax1 != null) return false;
        if (fax2 != null ? !fax2.equals(that.fax2) : that.fax2 != null) return false;
        if (documentofiscal != null ? !documentofiscal.equals(that.documentofiscal) : that.documentofiscal != null)
            return false;
        if (propietariopordefecto != null ? !propietariopordefecto.equals(that.propietariopordefecto) : that.propietariopordefecto != null)
            return false;
        if (descripcionextranjera != null ? !descripcionextranjera.equals(that.descripcionextranjera) : that.descripcionextranjera != null)
            return false;
        if (monedapordefecto != null ? !monedapordefecto.equals(that.monedapordefecto) : that.monedapordefecto != null)
            return false;
        if (tipocompania != null ? !tipocompania.equals(that.tipocompania) : that.tipocompania != null) return false;
        if (factorrvalidacion != null ? !factorrvalidacion.equals(that.factorrvalidacion) : that.factorrvalidacion != null)
            return false;
        if (afectoigvflag != null ? !afectoigvflag.equals(that.afectoigvflag) : that.afectoigvflag != null)
            return false;
        if (creditofiscalfactorflag != null ? !creditofiscalfactorflag.equals(that.creditofiscalfactorflag) : that.creditofiscalfactorflag != null)
            return false;
        if (cuentaprovisionsbsflag != null ? !cuentaprovisionsbsflag.equals(that.cuentaprovisionsbsflag) : that.cuentaprovisionsbsflag != null)
            return false;
        if (logofile != null ? !logofile.equals(that.logofile) : that.logofile != null) return false;
        if (persona != null ? !persona.equals(that.persona) : that.persona != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (ultimousuario != null ? !ultimousuario.equals(that.ultimousuario) : that.ultimousuario != null)
            return false;
        if (ultimafechamodif != null ? !ultimafechamodif.equals(that.ultimafechamodif) : that.ultimafechamodif != null)
            return false;
        if (representantelegal != null ? !representantelegal.equals(that.representantelegal) : that.representantelegal != null)
            return false;
        if (paginaweb != null ? !paginaweb.equals(that.paginaweb) : that.paginaweb != null) return false;
        if (afectoretencionigvflag != null ? !afectoretencionigvflag.equals(that.afectoretencionigvflag) : that.afectoretencionigvflag != null)
            return false;
        if (certificadoinscripcion != null ? !certificadoinscripcion.equals(that.certificadoinscripcion) : that.certificadoinscripcion != null)
            return false;
        if (detraccioncuentabancaria != null ? !detraccioncuentabancaria.equals(that.detraccioncuentabancaria) : that.detraccioncuentabancaria != null)
            return false;
        if (regimenlaboralrtps != null ? !regimenlaboralrtps.equals(that.regimenlaboralrtps) : that.regimenlaboralrtps != null)
            return false;
        if (representantelegaldocumento != null ? !representantelegaldocumento.equals(that.representantelegaldocumento) : that.representantelegaldocumento != null)
            return false;
        if (codigoanterior != null ? !codigoanterior.equals(that.codigoanterior) : that.codigoanterior != null)
            return false;
        if (departamento != null ? !departamento.equals(that.departamento) : that.departamento != null) return false;
        if (provincia != null ? !provincia.equals(that.provincia) : that.provincia != null) return false;
        if (codigopostal != null ? !codigopostal.equals(that.codigopostal) : that.codigopostal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companiacodigo != null ? companiacodigo.hashCode() : 0;
        result = 31 * result + (descripcioncorta != null ? descripcioncorta.hashCode() : 0);
        result = 31 * result + (descripcionlarga != null ? descripcionlarga.hashCode() : 0);
        result = 31 * result + (direccioncomun != null ? direccioncomun.hashCode() : 0);
        result = 31 * result + (direccionadicional != null ? direccionadicional.hashCode() : 0);
        result = 31 * result + (fechafundacion != null ? fechafundacion.hashCode() : 0);
        result = 31 * result + (telefono1 != null ? telefono1.hashCode() : 0);
        result = 31 * result + (telefono2 != null ? telefono2.hashCode() : 0);
        result = 31 * result + (telefono3 != null ? telefono3.hashCode() : 0);
        result = 31 * result + (fax1 != null ? fax1.hashCode() : 0);
        result = 31 * result + (fax2 != null ? fax2.hashCode() : 0);
        result = 31 * result + (documentofiscal != null ? documentofiscal.hashCode() : 0);
        result = 31 * result + (propietariopordefecto != null ? propietariopordefecto.hashCode() : 0);
        result = 31 * result + (descripcionextranjera != null ? descripcionextranjera.hashCode() : 0);
        result = 31 * result + (monedapordefecto != null ? monedapordefecto.hashCode() : 0);
        result = 31 * result + (tipocompania != null ? tipocompania.hashCode() : 0);
        result = 31 * result + (factorrvalidacion != null ? factorrvalidacion.hashCode() : 0);
        result = 31 * result + (afectoigvflag != null ? afectoigvflag.hashCode() : 0);
        result = 31 * result + (creditofiscalfactorflag != null ? creditofiscalfactorflag.hashCode() : 0);
        result = 31 * result + (cuentaprovisionsbsflag != null ? cuentaprovisionsbsflag.hashCode() : 0);
        result = 31 * result + (logofile != null ? logofile.hashCode() : 0);
        result = 31 * result + (persona != null ? persona.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (ultimousuario != null ? ultimousuario.hashCode() : 0);
        result = 31 * result + (ultimafechamodif != null ? ultimafechamodif.hashCode() : 0);
        result = 31 * result + (representantelegal != null ? representantelegal.hashCode() : 0);
        result = 31 * result + (paginaweb != null ? paginaweb.hashCode() : 0);
        result = 31 * result + (afectoretencionigvflag != null ? afectoretencionigvflag.hashCode() : 0);
        result = 31 * result + (certificadoinscripcion != null ? certificadoinscripcion.hashCode() : 0);
        result = 31 * result + (detraccioncuentabancaria != null ? detraccioncuentabancaria.hashCode() : 0);
        result = 31 * result + (regimenlaboralrtps != null ? regimenlaboralrtps.hashCode() : 0);
        result = 31 * result + (representantelegaldocumento != null ? representantelegaldocumento.hashCode() : 0);
        result = 31 * result + (codigoanterior != null ? codigoanterior.hashCode() : 0);
        result = 31 * result + (departamento != null ? departamento.hashCode() : 0);
        result = 31 * result + (provincia != null ? provincia.hashCode() : 0);
        result = 31 * result + (codigopostal != null ? codigopostal.hashCode() : 0);
        return result;
    }

}
