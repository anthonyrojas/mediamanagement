
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
@Table(name = "TransactionType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionType.findAll", query = "SELECT t FROM TransactionType t"),
    @NamedQuery(name = "TransactionType.findByTransactionType", query = "SELECT t FROM TransactionType t WHERE t.transactionType = :transactionType")})
public class TransactionType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "transaction_type")
    private String transactionType;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionTypetransactiontype")
    private Collection<Transaction> transactionCollection;

    public TransactionType() {
    }

    public TransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public TransactionType(String transactionType, String description) {
        this.transactionType = transactionType;
        this.description = description;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
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
        hash += (transactionType != null ? transactionType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionType)) {
            return false;
        }
        TransactionType other = (TransactionType) object;
        if ((this.transactionType == null && other.transactionType != null) || (this.transactionType != null && !this.transactionType.equals(other.transactionType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.TransactionType[ transactionType=" + transactionType + " ]";
    }

}
