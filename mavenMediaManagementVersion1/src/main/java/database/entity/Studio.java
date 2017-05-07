
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
@Table(name = "Studio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studio.findAll", query = "SELECT s FROM Studio s"),
    @NamedQuery(name = "Studio.findByStudio", query = "SELECT s FROM Studio s WHERE s.studio = :studio")})
public class Studio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "studio")
    private String studio;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "studio_description")
    private String studioDescription;
    @ManyToMany(mappedBy = "studioCollection")
    private Collection<DiskMovie> diskMovieCollection;

    public Studio() {
    }

    public Studio(String studio) {
        this.studio = studio;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getStudioDescription() {
        return studioDescription;
    }

    public void setStudioDescription(String studioDescription) {
        this.studioDescription = studioDescription;
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
        hash += (studio != null ? studio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studio)) {
            return false;
        }
        Studio other = (Studio) object;
        if ((this.studio == null && other.studio != null) || (this.studio != null && !this.studio.equals(other.studio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.Studio[ studio=" + studio + " ]";
    }

}
