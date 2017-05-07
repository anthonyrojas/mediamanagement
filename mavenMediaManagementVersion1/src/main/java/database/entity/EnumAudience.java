
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
@Table(name = "EnumAudience")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnumAudience.findAll", query = "SELECT e FROM EnumAudience e"),
    @NamedQuery(name = "EnumAudience.findByTargetedAudience", query = "SELECT e FROM EnumAudience e WHERE e.targetedAudience = :targetedAudience")})
public class EnumAudience implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "targeted_audience")
    private String targetedAudience;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @JoinTable(name = "Media_has_EnumAudience", joinColumns = {
        @JoinColumn(name = "EnumAudience_targeted_audience", referencedColumnName = "targeted_audience")}, inverseJoinColumns = {
        @JoinColumn(name = "Media_UPC", referencedColumnName = "UPC")})
    @ManyToMany
    private Collection<Media> mediaCollection;

    public EnumAudience() {
    }

    public EnumAudience(String targetedAudience) {
        this.targetedAudience = targetedAudience;
    }

    public String getTargetedAudience() {
        return targetedAudience;
    }

    public void setTargetedAudience(String targetedAudience) {
        this.targetedAudience = targetedAudience;
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
        hash += (targetedAudience != null ? targetedAudience.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnumAudience)) {
            return false;
        }
        EnumAudience other = (EnumAudience) object;
        if ((this.targetedAudience == null && other.targetedAudience != null) || (this.targetedAudience != null && !this.targetedAudience.equals(other.targetedAudience))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.EnumAudience[ targetedAudience=" + targetedAudience + " ]";
    }

}
