
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
@Table(name = "EnumAspectRatio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnumAspectRatio.findAll", query = "SELECT e FROM EnumAspectRatio e"),
    @NamedQuery(name = "EnumAspectRatio.findByAspectRatio", query = "SELECT e FROM EnumAspectRatio e WHERE e.aspectRatio = :aspectRatio")})
public class EnumAspectRatio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "aspect_ratio")
    private String aspectRatio;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "aspect_ratio_description")
    private String aspectRatioDescription;
    @ManyToMany(mappedBy = "enumAspectRatioCollection")
    private Collection<DiskMovie> diskMovieCollection;

    public EnumAspectRatio() {
    }

    public EnumAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public String getAspectRatioDescription() {
        return aspectRatioDescription;
    }

    public void setAspectRatioDescription(String aspectRatioDescription) {
        this.aspectRatioDescription = aspectRatioDescription;
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
        hash += (aspectRatio != null ? aspectRatio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnumAspectRatio)) {
            return false;
        }
        EnumAspectRatio other = (EnumAspectRatio) object;
        if ((this.aspectRatio == null && other.aspectRatio != null) || (this.aspectRatio != null && !this.aspectRatio.equals(other.aspectRatio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.EnumAspectRatio[ aspectRatio=" + aspectRatio + " ]";
    }

}
