
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Borrower_Account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BorrowerAccount.findAll", query = "SELECT b FROM BorrowerAccount b"),
    @NamedQuery(name = "BorrowerAccount.findByBorrowerId", query = "SELECT b FROM BorrowerAccount b WHERE b.borrowerId = :borrowerId"),
    @NamedQuery(name = "BorrowerAccount.findByUsername", query = "SELECT b FROM BorrowerAccount b WHERE b.username = :username"),
    @NamedQuery(name = "BorrowerAccount.findByPassword", query = "SELECT b FROM BorrowerAccount b WHERE b.password = :password")})
public class BorrowerAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "borrower_id")
    private Integer borrowerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "Contact_contact_id", referencedColumnName = "contact_id")
    @ManyToOne(optional = false)
    private Contact contactcontactid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "borrowerAccountborrowerid")
    private Collection<Transaction> transactionCollection;

    public BorrowerAccount() {
    }

    public BorrowerAccount(Integer borrowerId) {
        this.borrowerId = borrowerId;
    }

    public BorrowerAccount(Integer borrowerId, String username, String password) {
        this.borrowerId = borrowerId;
        this.username = username;
        this.password = password;
    }

    public Integer getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Integer borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Contact getContactcontactid() {
        return contactcontactid;
    }

    public void setContactcontactid(Contact contactcontactid) {
        this.contactcontactid = contactcontactid;
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
        hash += (borrowerId != null ? borrowerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BorrowerAccount)) {
            return false;
        }
        BorrowerAccount other = (BorrowerAccount) object;
        if ((this.borrowerId == null && other.borrowerId != null) || (this.borrowerId != null && !this.borrowerId.equals(other.borrowerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.BorrowerAccount[ borrowerId=" + borrowerId + " ]";
    }

}
