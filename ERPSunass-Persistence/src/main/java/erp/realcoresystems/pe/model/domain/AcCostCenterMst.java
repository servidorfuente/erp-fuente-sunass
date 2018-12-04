package erp.realcoresystems.pe.model.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "AC_COSTCENTERMST")
public class AcCostCenterMst extends Entidad {

 
	private static final long serialVersionUID = 1L;
	private String costcenter;
	private String localname;
	private String englishname;
	private String costcenterclasification;
	private String costcentergroup;
	private String costcentersubgroup;
	private String costcenterrelation;
	private String responsible;
	private String expensefinanceflag;
	private String expenseadministrativeflag;
	private String expensesalesflag;
	private String costcenternext;
	private Integer vendor;
	private BigDecimal amountinvoices;
	private BigDecimal amountrequisitions;
	private BigDecimal amountadvances;
	private BigDecimal amounttherS01;
	private BigDecimal amounttherS02;
	private BigDecimal amounttherS03;
	private String vendorsignfile;
	private String accountx;
	private String status;
	private String lastuser;
	private Date lastdate;
	private String account;
	private String accountdestination;
	private String accountinflation;
	private String costproductionlevel;
	private String costcentertype;
	private String incomeflag;
	private String expensedirectflag;
	private String expensefixedflag;
	private String sucursal;
	private String internalnumber;
	private String address;
	private String racionperfil;
	private String racionperfilmantenimiento;
	private String cpautomaticrequflag;
	private String cpautomaticinvoflag;
	private String multicompanyflag;

	@Id
	@Column(name = "COSTCENTER")
	public String getCostcenter() {
		return costcenter;
	}

	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}

	@Column(name = "LOCALNAME")
	public String getLocalname() {
		return localname;
	}

	public void setLocalname(String localname) {
		this.localname = localname;
	}

	@Column(name = "ENGLISHNAME")
	public String getEnglishname() {
		return englishname;
	}

	public void setEnglishname(String englishname) {
		this.englishname = englishname;
	}

	@Column(name = "COSTCENTERCLASIFICATION")
	public String getCostcenterclasification() {
		return costcenterclasification;
	}

	public void setCostcenterclasification(String costcenterclasification) {
		this.costcenterclasification = costcenterclasification;
	}

	@Column(name = "COSTCENTERGROUP")
	public String getCostcentergroup() {
		return costcentergroup;
	}

	public void setCostcentergroup(String costcentergroup) {
		this.costcentergroup = costcentergroup;
	}

	@Column(name = "COSTCENTERSUBGROUP")
	public String getCostcentersubgroup() {
		return costcentersubgroup;
	}

	public void setCostcentersubgroup(String costcentersubgroup) {
		this.costcentersubgroup = costcentersubgroup;
	}

	@Column(name = "COSTCENTERRELATION")
	public String getCostcenterrelation() {
		return costcenterrelation;
	}

	public void setCostcenterrelation(String costcenterrelation) {
		this.costcenterrelation = costcenterrelation;
	}

	@Column(name = "RESPONSIBLE")
	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	@Column(name = "EXPENSEFINANCEFLAG")
	public String getExpensefinanceflag() {
		return expensefinanceflag;
	}

	public void setExpensefinanceflag(String expensefinanceflag) {
		this.expensefinanceflag = expensefinanceflag;
	}

	@Column(name = "EXPENSEADMINISTRATIVEFLAG")
	public String getExpenseadministrativeflag() {
		return expenseadministrativeflag;
	}

	public void setExpenseadministrativeflag(String expenseadministrativeflag) {
		this.expenseadministrativeflag = expenseadministrativeflag;
	}

	@Column(name = "EXPENSESALESFLAG")
	public String getExpensesalesflag() {
		return expensesalesflag;
	}

	public void setExpensesalesflag(String expensesalesflag) {
		this.expensesalesflag = expensesalesflag;
	}

	@Column(name = "COSTCENTERNEXT")
	public String getCostcenternext() {
		return costcenternext;
	}

	public void setCostcenternext(String costcenternext) {
		this.costcenternext = costcenternext;
	}

	@Column(name = "VENDOR")
	public Integer getVendor() {
		return vendor;
	}

	public void setVendor(Integer vendor) {
		this.vendor = vendor;
	}

	@Column(name = "AMOUNTINVOICES")
	public BigDecimal getAmountinvoices() {
		return amountinvoices;
	}

	public void setAmountinvoices(BigDecimal amountinvoices) {
		this.amountinvoices = amountinvoices;
	}

	@Column(name = "AMOUNTREQUISITIONS")
	public BigDecimal getAmountrequisitions() {
		return amountrequisitions;
	}

	public void setAmountrequisitions(BigDecimal amountrequisitions) {
		this.amountrequisitions = amountrequisitions;
	}

	@Column(name = "AMOUNTADVANCES")
	public BigDecimal getAmountadvances() {
		return amountadvances;
	}

	public void setAmountadvances(BigDecimal amountadvances) {
		this.amountadvances = amountadvances;
	}

	@Column(name = "AMOUNTOTHERS01")
	public BigDecimal getAmounttherS01() {
		return amounttherS01;
	}

	public void setAmounttherS01(BigDecimal amounttherS01) {
		this.amounttherS01 = amounttherS01;
	}

	@Column(name = "AMOUNTOTHERS02")
	public BigDecimal getAmounttherS02() {
		return amounttherS02;
	}

	public void setAmounttherS02(BigDecimal amounttherS02) {
		this.amounttherS02 = amounttherS02;
	}

	@Column(name = "AMOUNTOTHERS03")
	public BigDecimal getAmounttherS03() {
		return amounttherS03;
	}

	public void setAmounttherS03(BigDecimal amounttherS03) {
		this.amounttherS03 = amounttherS03;
	}

	@Column(name = "VENDORSIGNFILE")
	public String getVendorsignfile() {
		return vendorsignfile;
	}

	public void setVendorsignfile(String vendorsignfile) {
		this.vendorsignfile = vendorsignfile;
	}

	@Column(name = "ACCOUNTX")
	public String getAccountx() {
		return accountx;
	}

	public void setAccountx(String accountx) {
		this.accountx = accountx;
	}

	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "LASTUSER")
	public String getLastuser() {
		return lastuser;
	}

	public void setLastuser(String lastuser) {
		this.lastuser = lastuser;
	}

	@Column(name = "LASTDATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLastdate() {
		return lastdate;
	}

	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}

	@Column(name = "ACCOUNT")
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "ACCOUNTDESTINATION")
	public String getAccountdestination() {
		return accountdestination;
	}

	public void setAccountdestination(String accountdestination) {
		this.accountdestination = accountdestination;
	}

	@Column(name = "ACCOUNTINFLATION")
	public String getAccountinflation() {
		return accountinflation;
	}

	public void setAccountinflation(String accountinflation) {
		this.accountinflation = accountinflation;
	}

	@Column(name = "COSTPRODUCTIONLEVEL")
	public String getCostproductionlevel() {
		return costproductionlevel;
	}

	public void setCostproductionlevel(String costproductionlevel) {
		this.costproductionlevel = costproductionlevel;
	}

	@Column(name = "COSTCENTERTYPE")
	public String getCostcentertype() {
		return costcentertype;
	}

	public void setCostcentertype(String costcentertype) {
		this.costcentertype = costcentertype;
	}

	@Column(name = "INCOMEFLAG")
	public String getIncomeflag() {
		return incomeflag;
	}

	public void setIncomeflag(String incomeflag) {
		this.incomeflag = incomeflag;
	}

	@Column(name = "EXPENSEDIRECTFLAG")
	public String getExpensedirectflag() {
		return expensedirectflag;
	}

	public void setExpensedirectflag(String expensedirectflag) {
		this.expensedirectflag = expensedirectflag;
	}

	@Column(name = "EXPENSEFIXEDFLAG")
	public String getExpensefixedflag() {
		return expensefixedflag;
	}

	public void setExpensefixedflag(String expensefixedflag) {
		this.expensefixedflag = expensefixedflag;
	}

	@Column(name = "SUCURSAL")
	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	@Column(name = "INTERNALNUMBER")
	public String getInternalnumber() {
		return internalnumber;
	}

	public void setInternalnumber(String internalnumber) {
		this.internalnumber = internalnumber;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "RACIONPERFIL")
	public String getRacionperfil() {
		return racionperfil;
	}

	public void setRacionperfil(String racionperfil) {
		this.racionperfil = racionperfil;
	}

	@Column(name = "RACIONPERFILMANTENIMIENTO")
	public String getRacionperfilmantenimiento() {
		return racionperfilmantenimiento;
	}

	public void setRacionperfilmantenimiento(String racionperfilmantenimiento) {
		this.racionperfilmantenimiento = racionperfilmantenimiento;
	}

	@Column(name = "CPAUTOMATICREQUFLAG")
	public String getCpautomaticrequflag() {
		return cpautomaticrequflag;
	}

	public void setCpautomaticrequflag(String cpautomaticrequflag) {
		this.cpautomaticrequflag = cpautomaticrequflag;
	}

	@Column(name = "CPAUTOMATICINVOFLAG")
	public String getCpautomaticinvoflag() {
		return cpautomaticinvoflag;
	}

	public void setCpautomaticinvoflag(String cpautomaticinvoflag) {
		this.cpautomaticinvoflag = cpautomaticinvoflag;
	}

	@Column(name = "MULTICOMPANYFLAG")
	public String getMulticompanyflag() {
		return multicompanyflag;
	}

	public void setMulticompanyflag(String multicompanyflag) {
		this.multicompanyflag = multicompanyflag;
	}

}
