
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
@Table(name = "EnumLanguage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnumLanguage.findAll", query = "SELECT e FROM EnumLanguage e"),
    @NamedQuery(name = "EnumLanguage.findByLanguage", query = "SELECT e FROM EnumLanguage e WHERE e.language = :language")})
public class EnumLanguage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "language")
    private String language;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @JoinTable(name = "Media_has_EnumLanguage", joinColumns = {
        @JoinColumn(name = "EnumLanguage_language", referencedColumnName = "language")}, inverseJoinColumns = {
        @JoinColumn(name = "Media_UPC", referencedColumnName = "UPC")})
    @ManyToMany
    private Collection<Media> mediaCollection;

    public EnumLanguage() {
    }

    public EnumLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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
        hash += (language != null ? language.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnumLanguage)) {
            return false;
        }
        EnumLanguage other = (EnumLanguage) object;
        if ((this.language == null && other.language != null) || (this.language != null && !this.language.equals(other.language))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.EnumLanguage[ language=" + language + " ]";
    }

}
