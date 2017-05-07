
package database.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t"),
    @NamedQuery(name = "Transaction.findByTransactionId", query = "SELECT t FROM Transaction t WHERE t.transactionId = :transactionId")})
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "transaction_id")
    private Integer transactionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactiontransactionid")
    private Collection<RateItem> rateItemCollection;
    @JoinColumn(name = "TransactionStatus_transaction_status", referencedColumnName = "transaction_status")
    @ManyToOne(optional = false)
    private TransactionStatus transactionStatustransactionstatus;
    @JoinColumn(name = "Borrower_Account_borrower_id", referencedColumnName = "borrower_id")
    @ManyToOne(optional = false)
    private BorrowerAccount borrowerAccountborrowerid;
    @JoinColumn(name = "Media_Items_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MediaItems mediaItemsid;
    @JoinColumn(name = "TransactionType_transaction_type", referencedColumnName = "transaction_type")
    @ManyToOne(optional = false)
    private TransactionType transactionTypetransactiontype;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactiontransactionid")
    private Collection<RateBorrower> rateBorrowerCollection;

    public Transaction() {
    }

    public Transaction(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    @XmlTransient
    public Collection<RateItem> getRateItemCollection() {
        return rateItemCollection;
    }

    public void setRateItemCollection(Collection<RateItem> rateItemCollection) {
        this.rateItemCollection = rateItemCollection;
    }

    public TransactionStatus getTransactionStatustransactionstatus() {
        return transactionStatustransactionstatus;
    }

    public void setTransactionStatustransactionstatus(TransactionStatus transactionStatustransactionstatus) {
        this.transactionStatustransactionstatus = transactionStatustransactionstatus;
    }

    public BorrowerAccount getBorrowerAccountborrowerid() {
        return borrowerAccountborrowerid;
    }

    public void setBorrowerAccountborrowerid(BorrowerAccount borrowerAccountborrowerid) {
        this.borrowerAccountborrowerid = borrowerAccountborrowerid;
    }

    public MediaItems getMediaItemsid() {
        return mediaItemsid;
    }

    public void setMediaItemsid(MediaItems mediaItemsid) {
        this.mediaItemsid = mediaItemsid;
    }

    public TransactionType getTransactionTypetransactiontype() {
        return transactionTypetransactiontype;
    }

    public void setTransactionTypetransactiontype(TransactionType transactionTypetransactiontype) {
        this.transactionTypetransactiontype = transactionTypetransactiontype;
    }

    @XmlTransient
    public Collection<RateBorrower> getRateBorrowerCollection() {
        return rateBorrowerCollection;
    }

    public void setRateBorrowerCollection(Collection<RateBorrower> rateBorrowerCollection) {
        this.rateBorrowerCollection = rateBorrowerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.Transaction[ transactionId=" + transactionId + " ]";
    }

}
