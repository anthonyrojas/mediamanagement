
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
@Table(name = "EnumGenre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnumGenre.findAll", query = "SELECT e FROM EnumGenre e"),
    @NamedQuery(name = "EnumGenre.findByGenre", query = "SELECT e FROM EnumGenre e WHERE e.genre = :genre")})
public class EnumGenre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "genre")
    private String genre;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @JoinTable(name = "Media_has_EnumGenre", joinColumns = {
        @JoinColumn(name = "EnumGenre_genre", referencedColumnName = "genre")}, inverseJoinColumns = {
        @JoinColumn(name = "Media_UPC", referencedColumnName = "UPC")})
    @ManyToMany
    private Collection<Media> mediaCollection;

    public EnumGenre() {
    }

    public EnumGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
        hash += (genre != null ? genre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnumGenre)) {
            return false;
        }
        EnumGenre other = (EnumGenre) object;
        if ((this.genre == null && other.genre != null) || (this.genre != null && !this.genre.equals(other.genre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.EnumGenre[ genre=" + genre + " ]";
    }

}
