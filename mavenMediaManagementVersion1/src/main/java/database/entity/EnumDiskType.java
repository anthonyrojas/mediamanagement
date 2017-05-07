
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
@Table(name = "EnumDiskType")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnumDiskType.findAll", query = "SELECT e FROM EnumDiskType e"),
    @NamedQuery(name = "EnumDiskType.findByDiskType", query = "SELECT e FROM EnumDiskType e WHERE e.diskType = :diskType")})
public class EnumDiskType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "disk_type")
    private String diskType;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "deskt_type_description")
    private String desktTypeDescription;
    @ManyToMany(mappedBy = "enumDiskTypeCollection")
    private Collection<DiskMovie> diskMovieCollection;

    public EnumDiskType() {
    }

    public EnumDiskType(String diskType) {
        this.diskType = diskType;
    }

    public String getDiskType() {
        return diskType;
    }

    public void setDiskType(String diskType) {
        this.diskType = diskType;
    }

    public String getDesktTypeDescription() {
        return desktTypeDescription;
    }

    public void setDesktTypeDescription(String desktTypeDescription) {
        this.desktTypeDescription = desktTypeDescription;
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
        hash += (diskType != null ? diskType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnumDiskType)) {
            return false;
        }
        EnumDiskType other = (EnumDiskType) object;
        if ((this.diskType == null && other.diskType != null) || (this.diskType != null && !this.diskType.equals(other.diskType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.EnumDiskType[ diskType=" + diskType + " ]";
    }

}
