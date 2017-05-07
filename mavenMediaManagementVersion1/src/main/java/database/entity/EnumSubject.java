
package database.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "EnumSubject")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnumSubject.findAll", query = "SELECT e FROM EnumSubject e"),
    @NamedQuery(name = "EnumSubject.findBySubject", query = "SELECT e FROM EnumSubject e WHERE e.subject = :subject")})
public class EnumSubject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "subject")
    private String subject;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @JoinTable(name = "Media_has_EnumSubject", joinColumns = {
        @JoinColumn(name = "EnumSubject_subject", referencedColumnName = "subject")}, inverseJoinColumns = {
        @JoinColumn(name = "Media_UPC", referencedColumnName = "UPC")})
    @ManyToMany
    private Collection<Media> mediaCollection;

    public EnumSubject() {
    }

    public EnumSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Media> getMediaCollection() {
        return mediaCollection;
    }

    public void setMediaCollection(Collection<Media> mediaCollection) {
        this.mediaCollection = mediaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subject != null ? subject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnumSubject)) {
            return false;
        }
        EnumSubject other = (EnumSubject) object;
        if ((this.subject == null && other.subject != null) || (this.subject != null && !this.subject.equals(other.subject))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.EnumSubject[ subject=" + subject + " ]";
    }

}
