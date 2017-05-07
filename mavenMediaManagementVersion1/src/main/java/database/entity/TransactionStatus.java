
package database.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "TransactionStatus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionStatus.findAll", query = "SELECT t FROM TransactionStatus t"),
    @NamedQuery(name = "TransactionStatus.findByTransactionStatus", query = "SELECT t FROM TransactionStatus t WHERE t.transactionStatus = :transactionStatus")})
public class TransactionStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "transaction_status")
    private String transactionStatus;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionStatustransactionstatus")
    private Collection<Transaction> transactionCollection;

    public TransactionStatus() {
    }

    public TransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public TransactionStatus(String transactionStatus, String description) {
        this.transactionStatus = transactionStatus;
        this.description = description;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Transaction> getTransactionCollection() {
        return transactionCollection;
    }

    public void setTransactionCollection(Collection<Transaction> transactionCollection) {
        this.transactionCollection = transactionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionStatus != null ? transactionStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionStatus)) {
            return false;
        }
        TransactionStatus other = (TransactionStatus) object;
        if ((this.transactionStatus == null && other.transactionStatus != null) || (this.transactionStatus != null && !this.transactionStatus.equals(other.transactionStatus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.TransactionStatus[ transactionStatus=" + transactionStatus + " ]";
    }

}
