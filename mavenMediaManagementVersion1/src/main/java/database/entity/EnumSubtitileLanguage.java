
package database.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "EnumSubtitileLanguage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnumSubtitileLanguage.findAll", query = "SELECT e FROM EnumSubtitileLanguage e"),
    @NamedQuery(name = "EnumSubtitileLanguage.findByLanguage", query = "SELECT e FROM EnumSubtitileLanguage e WHERE e.language = :language")})
public class EnumSubtitileLanguage implements Serializable {

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
    @ManyToMany(mappedBy = "enumSubtitileLanguageCollection")
    private Collection<DiskMovie> diskMovieCollection;

    public EnumSubtitileLanguage() {
    }

    public EnumSubtitileLanguage(String language) {
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
    public Collection<DiskMovie> getDiskMovieCollection() {
        return diskMovieCollection;
    }

    public void setDiskMovieCollection(Collection<DiskMovie> diskMovieCollection) {
        this.diskMovieCollection = diskMovieCollection;
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
        if (!(object instanceof EnumSubtitileLanguage)) {
            return false;
        }
        EnumSubtitileLanguage other = (EnumSubtitileLanguage) object;
        if ((this.language == null && other.language != null) || (this.language != null && !this.language.equals(other.language))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.EnumSubtitileLanguage[ language=" + language + " ]";
    }

}
