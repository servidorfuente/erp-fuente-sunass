package erp.realcoresystems.pe.model.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the MA_CATEGORIA_MISCALENEOSDET database table.
 * 
 */
@Entity
@Table(name="MA_CATEGORIA_MISCELANEOSDET")
public class MaCategoriaMiscelaneosdet extends Entidad {
	private static final long serialVersionUID = 1L;
	private MaCategoriaMiscelaneosdetPK id;
	private String atributoColor;
	private String atributoImage;
	private String categCodigo;
	private Integer categSecuenciaPadre;
	private Date categValorDate1;
	private BigDecimal categValorNum1;
	private String categValorTxt1;
	private String descripcionlocal;
	private String estado;
	private String nombre;
	private Integer orden;
	private String tipoNivel;
	private Date ultimafechamodif;
	private String ultimousuario;
	
	private Integer nivel;
	
	
	private String nombreFullPadre;
	
	private Integer uneunegocioid;
	private Integer moemestudioid;
	
	public MaCategoriaMiscelaneosdet() {
		id = new MaCategoriaMiscelaneosdetPK();
	}


	@EmbeddedId
	public MaCategoriaMiscelaneosdetPK getId() {
		return this.id;
	}

	public void setId(MaCategoriaMiscelaneosdetPK id) {
		this.id = id;
	}


	@Column(name="ATRIBUTO_COLOR")
	public String getAtributoColor() {
		return this.atributoColor;
	}

	public void setAtributoColor(String atributoColor) {
		this.atributoColor = atributoColor;
	}


	@Column(name="ATRIBUTO_IMAGE")
	public String getAtributoImage() {
		return this.atributoImage;
	}

	public void setAtributoImage(String atributoImage) {
		this.atributoImage = atributoImage;
	}


	@Column(name="CATEG_CODIGO")
	public String getCategCodigo() {
		return this.categCodigo;
	}

	public void setCategCodigo(String categCodigo) {
		this.categCodigo = categCodigo;
	}


	@Column(name="CATEG_SECUENCIA_PADRE")
	public Integer getCategSecuenciaPadre() {
		return this.categSecuenciaPadre;
	}

	public void setCategSecuenciaPadre(Integer categSecuenciaPadre) {
		this.categSecuenciaPadre = categSecuenciaPadre;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="CATEG_VALOR_DATE1")
	public Date getCategValorDate1() {
		return this.categValorDate1;
	}

	public void setCategValorDate1(Date categValorDate1) {
		this.categValorDate1 = categValorDate1;
	}


	@Column(name="CATEG_VALOR_NUM1")
	public BigDecimal getCategValorNum1() {
		return this.categValorNum1;
	}

	public void setCategValorNum1(BigDecimal categValorNum1) {
		this.categValorNum1 = categValorNum1;
	}


	@Column(name="CATEG_VALOR_TXT1")
	public String getCategValorTxt1() {
		return this.categValorTxt1;
	}

	public void setCategValorTxt1(String categValorTxt1) {
		this.categValorTxt1 = categValorTxt1;
	}


	public String getDescripcionlocal() {
		return this.descripcionlocal;
	}

	public void setDescripcionlocal(String descripcionlocal) {
		this.descripcionlocal = descripcionlocal;
	}


	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}


	@Column(name="TIPO_NIVEL")
	public String getTipoNivel() {
		return this.tipoNivel;
	}

	public void setTipoNivel(String tipoNivel) {
		this.tipoNivel = tipoNivel;
	}


	@Temporal(TemporalType.DATE)
	public Date getUltimafechamodif() {
		return this.ultimafechamodif;
	}

	public void setUltimafechamodif(Date ultimafechamodif) {
		this.ultimafechamodif = ultimafechamodif;
	}


	public String getUltimousuario() {
		return this.ultimousuario;
	}

	public void setUltimousuario(String ultimousuario) {
		this.ultimousuario = ultimousuario;
	}

	@Column(name="NIVEL")
	public Integer getNivel() {
		return nivel;
	}


	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	@Transient
	public String getNombreFullPadre() {
		return nombreFullPadre;
	}


	public void setNombreFullPadre(String nombreFullPadre) {
		this.nombreFullPadre = nombreFullPadre;
	}


	public Integer getUneunegocioid() {
		return uneunegocioid;
	}


	public void setUneunegocioid(Integer uneunegocioid) {
		this.uneunegocioid = uneunegocioid;
	}


	public Integer getMoemestudioid() {
		return moemestudioid;
	}


	public void setMoemestudioid(Integer moemestudioid) {
		this.moemestudioid = moemestudioid;
	}

}