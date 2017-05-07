
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Actor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actor.findAll", query = "SELECT a FROM Actor a"),
    @NamedQuery(name = "Actor.findByActorName", query = "SELECT a FROM Actor a WHERE a.actorName = :actorName"),
    @NamedQuery(name = "Actor.findByActorId", query = "SELECT a FROM Actor a WHERE a.actorId = :actorId")})
public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "actor_name")
    private String actorName;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "actor_description")
    private String actorDescription;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "actor_id")
    private Integer actorId;
    @JoinTable(name = "DiskMovie_has_Actor", joinColumns = {
        @JoinColumn(name = "Actor_actor_id", referencedColumnName = "actor_id")}, inverseJoinColumns = {
        @JoinColumn(name = "DiskMovie_UPC", referencedColumnName = "UPC")})
    @ManyToMany
    private Collection<DiskMovie> diskMovieCollection;

    public Actor() {
    }

    public Actor(Integer actorId) {
        this.actorId = actorId;
    }

    public Actor(Integer actorId, String actorName) {
        this.actorId = actorId;
        this.actorName = actorName;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorDescription() {
        return actorDescription;
    }

    public void setActorDescription(String actorDescription) {
        this.actorDescription = actorDescription;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
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
        hash += (actorId != null ? actorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actor)) {
            return false;
        }
        Actor other = (Actor) object;
        if ((this.actorId == null && other.actorId != null) || (this.actorId != null && !this.actorId.equals(other.actorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.Actor[ actorId=" + actorId + " ]";
    }

}
