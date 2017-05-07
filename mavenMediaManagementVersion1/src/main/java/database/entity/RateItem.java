
package database.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "RateItem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RateItem.findAll", query = "SELECT r FROM RateItem r"),
    @NamedQuery(name = "RateItem.findById", query = "SELECT r FROM RateItem r WHERE r.id = :id"),
    @NamedQuery(name = "RateItem.findByStars", query = "SELECT r FROM RateItem r WHERE r.stars = :stars")})
public class RateItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stars")
    private int stars;
    @JoinColumn(name = "Transaction_transaction_id", referencedColumnName = "transaction_id")
    @ManyToOne(optional = false)
    private Transaction transactiontransactionid;

    public RateItem() {
    }

    public RateItem(Integer id) {
        this.id = id;
    }

    public RateItem(Integer id, int stars) {
        this.id = id;
        this.stars = stars;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Transaction getTransactiontransactionid() {
        return transactiontransactionid;
    }

    public void setTransactiontransactionid(Transaction transactiontransactionid) {
        this.transactiontransactionid = transactiontransactionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RateItem)) {
            return false;
        }
        RateItem other = (RateItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.RateItem[ id=" + id + " ]";
    }

}
