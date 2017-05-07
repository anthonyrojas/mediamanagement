
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
import javax.persistence.Lob;
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
@Table(name = "Media_Items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MediaItems.findAll", query = "SELECT m FROM MediaItems m"),
    @NamedQuery(name = "MediaItems.findById", query = "SELECT m FROM MediaItems m WHERE m.id = :id")})
public class MediaItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "Media_UPC", referencedColumnName = "UPC")
    @ManyToOne(optional = false)
    private Media mediaUPC;
    @JoinColumn(name = "Status_status", referencedColumnName = "status")
    @ManyToOne(optional = false)
    private Status statusstatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mediaItemsid")
    private Collection<Transaction> transactionCollection;

    public MediaItems() {
    }

    public MediaItems(Integer id) {
        this.id = id;
    }

    public MediaItems(Integer id, String description) {
        this.id = id;
        this.description = description;
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

    public Media getMediaUPC() {
        return mediaUPC;
    }

    public void setMediaUPC(Media mediaUPC) {
        this.mediaUPC = mediaUPC;
    }

    public Status getStatusstatus() {
        return statusstatus;
    }

    public void setStatusstatus(Status statusstatus) {
        this.statusstatus = statusstatus;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MediaItems)) {
            return false;
        }
        MediaItems other = (MediaItems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.MediaItems[ id=" + id + " ]";
    }

}
