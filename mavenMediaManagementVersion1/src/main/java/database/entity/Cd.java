
package database.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "CD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cd.findAll", query = "SELECT c FROM Cd c"),
    @NamedQuery(name = "Cd.findByUpc", query = "SELECT c FROM Cd c WHERE c.upc = :upc")})
public class Cd implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "UPC")
    private String upc;
    @JoinTable(name = "CD_has_TrackTitle", joinColumns = {
        @JoinColumn(name = "CD_UPC", referencedColumnName = "UPC")}, inverseJoinColumns = {
        @JoinColumn(name = "TrackTitle_track_id", referencedColumnName = "track_id")})
    @ManyToMany
    private Collection<TrackTitle> trackTitleCollection;
    @JoinTable(name = "CD_has_EnumArtist", joinColumns = {
        @JoinColumn(name = "CD_UPC", referencedColumnName = "UPC")}, inverseJoinColumns = {
        @JoinColumn(name = "Artist_artist_id", referencedColumnName = "artist_id")})
    @ManyToMany
    private Collection<Artist> artistCollection;
    @JoinColumn(name = "UPC", referencedColumnName = "UPC", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Media media;

    public Cd() {
    }

    public Cd(String upc) {
        this.upc = upc;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    @XmlTransient
    public Collection<TrackTitle> getTrackTitleCollection() {
        return trackTitleCollection;
    }

    public void setTrackTitleCollection(Collection<TrackTitle> trackTitleCollection) {
        this.trackTitleCollection = trackTitleCollection;
    }

    @XmlTransient
    public Collection<Artist> getArtistCollection() {
        return artistCollection;
    }

    public void setArtistCollection(Collection<Artist> artistCollection) {
        this.artistCollection = artistCollection;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (upc != null ? upc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cd)) {
            return false;
        }
        Cd other = (Cd) object;
        if ((this.upc == null && other.upc != null) || (this.upc != null && !this.upc.equals(other.upc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.Cd[ upc=" + upc + " ]";
    }

}
