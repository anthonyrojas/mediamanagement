
package database.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "TrackTitle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrackTitle.findAll", query = "SELECT t FROM TrackTitle t"),
    @NamedQuery(name = "TrackTitle.findByTrackId", query = "SELECT t FROM TrackTitle t WHERE t.trackId = :trackId"),
    @NamedQuery(name = "TrackTitle.findByTrackTitle", query = "SELECT t FROM TrackTitle t WHERE t.trackTitle = :trackTitle"),
    @NamedQuery(name = "TrackTitle.findByTrackRunTime", query = "SELECT t FROM TrackTitle t WHERE t.trackRunTime = :trackRunTime")})
public class TrackTitle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "track_id")
    private Integer trackId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "track_title")
    private String trackTitle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "track_run_time")
    private int trackRunTime;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "track_background")
    private String trackBackground;
    @ManyToMany(mappedBy = "trackTitleCollection")
    private Collection<Cd> cdCollection;

    public TrackTitle() {
    }

    public TrackTitle(Integer trackId) {
        this.trackId = trackId;
    }

    public TrackTitle(Integer trackId, String trackTitle, int trackRunTime, String trackBackground) {
        this.trackId = trackId;
        this.trackTitle = trackTitle;
        this.trackRunTime = trackRunTime;
        this.trackBackground = trackBackground;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public int getTrackRunTime() {
        return trackRunTime;
    }

    public void setTrackRunTime(int trackRunTime) {
        this.trackRunTime = trackRunTime;
    }

    public String getTrackBackground() {
        return trackBackground;
    }

    public void setTrackBackground(String trackBackground) {
        this.trackBackground = trackBackground;
    }

    @XmlTransient
    public Collection<Cd> getCdCollection() {
        return cdCollection;
    }

    public void setCdCollection(Collection<Cd> cdCollection) {
        this.cdCollection = cdCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trackId != null ? trackId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrackTitle)) {
            return false;
        }
        TrackTitle other = (TrackTitle) object;
        if ((this.trackId == null && other.trackId != null) || (this.trackId != null && !this.trackId.equals(other.trackId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.TrackTitle[ trackId=" + trackId + " ]";
    }

}
