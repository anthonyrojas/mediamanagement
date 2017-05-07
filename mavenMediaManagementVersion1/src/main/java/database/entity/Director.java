
package database.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Director")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Director.findAll", query = "SELECT d FROM Director d"),
    @NamedQuery(name = "Director.findByDirectorId", query = "SELECT d FROM Director d WHERE d.directorId = :directorId"),
    @NamedQuery(name = "Director.findByName", query = "SELECT d FROM Director d WHERE d.name = :name")})
public class Director implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "director_id")
    private Integer directorId;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "director_description")
    private String directorDescription;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @JoinTable(name = "DiskMovie_has_Director", joinColumns = {
        @JoinColumn(name = "Director_director_id", referencedColumnName = "director_id")}, inverseJoinColumns = {
        @JoinColumn(name = "DiskMovie_UPC", referencedColumnName = "UPC")})
    @ManyToMany
    private Collection<DiskMovie> diskMovieCollection;

    public Director() {
    }

    public Director(Integer directorId) {
        this.directorId = directorId;
    }

    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    public String getDirectorDescription() {
        return directorDescription;
    }

    public void setDirectorDescription(String directorDescription) {
        this.directorDescription = directorDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        hash += (directorId != null ? directorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Director)) {
            return false;
        }
        Director other = (Director) object;
        if ((this.directorId == null && other.directorId != null) || (this.directorId != null && !this.directorId.equals(other.directorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.Director[ directorId=" + directorId + " ]";
    }

}
