package erp.realcoresystems.pe.model.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Entity
public class Companyowner extends Entidad{
	
	private static final long serialVersionUID = 1L;
	private String companyowner;
    private String description;
    private String englishdescription;
    private Double percentage;
    //private String company;
    private String owner;
    private Double changerate;
    private String lastuser;
    private Date lastdate;
    private CompaniaMast company;
    
    private Set<SaUnegocio> listaSaUnegocio;
    
	public Companyowner() {
		
	}
	
	public Companyowner( CompaniaMast companiaMast) {
		company = companiaMast;
	}

	@Id
    @Column(name = "COMPANYOWNER")
    public String getCompanyowner() {
        return companyowner;
    }

    public void setCompanyowner(String companyowner) {
        this.companyowner = companyowner;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "ENGLISHDESCRIPTION")
    public String getEnglishdescription() {
        return englishdescription;
    }

    public void setEnglishdescription(String englishdescription) {
        this.englishdescription = englishdescription;
    }

    @Basic
    @Column(name = "PERCENTAGE")
    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    /*@Basic
    @Column(name = "COMPANY")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }*/
    
    @ManyToOne
    @JoinColumn(name="COMPANY")
    public CompaniaMast getCompany() {
		return company;
	}

	public void setCompany(CompaniaMast company) {
		this.company = company;
	}

    @Basic
    @Column(name = "OWNER")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "CHANGERATE")
    public Double getChangerate() {
        return changerate;
    }

    public void setChangerate(Double changerate) {
        this.changerate = changerate;
    }

    @Basic
    @Column(name = "LASTUSER")
    public String getLastuser() {
        return lastuser;
    }

    public void setLastuser(String lastuser) {
        this.lastuser = lastuser;
    }

    @Basic
    @Column(name = "LASTDATE")
    public Date getLastdate() {
        return lastdate;
    }

    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Companyowner that = (Companyowner) o;

        if (companyowner != null ? !companyowner.equals(that.companyowner) : that.companyowner != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (englishdescription != null ? !englishdescription.equals(that.englishdescription) : that.englishdescription != null)
            return false;
        if (percentage != null ? !percentage.equals(that.percentage) : that.percentage != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;
        if (changerate != null ? !changerate.equals(that.changerate) : that.changerate != null) return false;
        if (lastuser != null ? !lastuser.equals(that.lastuser) : that.lastuser != null) return false;
        if (lastdate != null ? !lastdate.equals(that.lastdate) : that.lastdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = companyowner != null ? companyowner.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (englishdescription != null ? englishdescription.hashCode() : 0);
        result = 31 * result + (percentage != null ? percentage.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (changerate != null ? changerate.hashCode() : 0);
        result = 31 * result + (lastuser != null ? lastuser.hashCode() : 0);
        result = 31 * result + (lastdate != null ? lastdate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy="companyowner")
	public Set<SaUnegocio> getListaSaUnegocio() {
		return listaSaUnegocio;
	}

	public void setListaSaUnegocio(Set<SaUnegocio> listaSaUnegocio) {
		this.listaSaUnegocio = listaSaUnegocio;
	}
	
}
