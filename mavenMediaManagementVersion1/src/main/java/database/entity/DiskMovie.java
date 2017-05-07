
package database.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "DiskMovie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiskMovie.findAll", query = "SELECT d FROM DiskMovie d"),
    @NamedQuery(name = "DiskMovie.findByUpc", query = "SELECT d FROM DiskMovie d WHERE d.upc = :upc"),
    @NamedQuery(name = "DiskMovie.findByRunTime", query = "SELECT d FROM DiskMovie d WHERE d.runTime = :runTime"),
    @NamedQuery(name = "DiskMovie.findByReleaseDate", query = "SELECT d FROM DiskMovie d WHERE d.releaseDate = :releaseDate"),
    @NamedQuery(name = "DiskMovie.findByNumberOfDiscs", query = "SELECT d FROM DiskMovie d WHERE d.numberOfDiscs = :numberOfDiscs")})
public class DiskMovie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "UPC")
    private String upc;
    @Column(name = "run_time")
    private Integer runTime;
    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    @Column(name = "number_of_discs")
    private Integer numberOfDiscs;
    @JoinTable(name = "DiskMovie_has_EnumFormat", joinColumns = {
        @JoinColumn(name = "DiskMovie_UPC", referencedColumnName = "UPC")}, inverseJoinColumns = {
        @JoinColumn(name = "EnumFormat_format", referencedColumnName = "format")})
    @ManyToMany
    private Collection<EnumFormat> enumFormatCollection;
    @JoinTable(name = "DiskMovie_has_EnumSubtitileLanguage", joinColumns = {
        @JoinColumn(name = "DiskMovie_UPC", referencedColumnName = "UPC")}, inverseJoinColumns = {
        @JoinColumn(name = "EnumSubtitileLanguage_language", referencedColumnName = "language")})
    @ManyToMany
    private Collection<EnumSubtitileLanguage> enumSubtitileLanguageCollection;
    @ManyToMany(mappedBy = "diskMovieCollection")
    private Collection<Actor> actorCollection;
    @JoinTable(name = "DiskMovie_has_EnumDiskType", joinColumns = {
        @JoinColumn(name = "DiskMovie_UPC", referencedColumnName = "UPC")}, inverseJoinColumns = {
        @JoinColumn(name = "EnumDiskType_disk_type", referencedColumnName = "disk_type")})
    @ManyToMany
    private Collection<EnumDiskType> enumDiskTypeCollection;
    @JoinTable(name = "DiskMovie_has_Studio", joinColumns = {
        @JoinColumn(name = "DiskMovie_UPC", referencedColumnName = "UPC")}, inverseJoinColumns = {
        @JoinColumn(name = "Studio_studio", referencedColumnName = "studio")})
    @ManyToMany
    private Collection<Studio> studioCollection;
    @JoinTable(name = "DiskMovie_has_EnumAspectRatio", joinColumns = {
        @JoinColumn(name = "DiskMovie_UPC", referencedColumnName = "UPC")}, inverseJoinColumns = {
        @JoinColumn(name = "EnumAspectRatio_aspect_ratio", referencedColumnName = "aspect_ratio")})
    @ManyToMany
    private Collection<EnumAspectRatio> enumAspectRatioCollection;
    @ManyToMany(mappedBy = "diskMovieCollection")
    private Collection<Director> directorCollection;
    @JoinColumn(name = "UPC", referencedColumnName = "UPC", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Media media;

    public DiskMovie() {
    }

    public DiskMovie(String upc) {
        this.upc = upc;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public Integer getRunTime() {
        return runTime;
    }

    public void setRunTime(Integer runTime) {
        this.runTime = runTime;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getNumberOfDiscs() {
        return numberOfDiscs;
    }

    public void setNumberOfDiscs(Integer numberOfDiscs) {
        this.numberOfDiscs = numberOfDiscs;
    }

    @XmlTransient
    public Collection<EnumFormat> getEnumFormatCollection() {
        return enumFormatCollection;
    }

    public void setEnumFormatCollection(Collection<EnumFormat> enumFormatCollection) {
        this.enumFormatCollection = enumFormatCollection;
    }

    @XmlTransient
    public Collection<EnumSubtitileLanguage> getEnumSubtitileLanguageCollection() {
        return enumSubtitileLanguageCollection;
    }

    public void setEnumSubtitileLanguageCollection(Collection<EnumSubtitileLanguage> enumSubtitileLanguageCollection) {
        this.enumSubtitileLanguageCollection = enumSubtitileLanguageCollection;
    }

    @XmlTransient
    public Collection<Actor> getActorCollection() {
        return actorCollection;
    }

    public void setActorCollection(Collection<Actor> actorCollection) {
        this.actorCollection = actorCollection;
    }

    @XmlTransient
    public Collection<EnumDiskType> getEnumDiskTypeCollection() {
        return enumDiskTypeCollection;
    }

    public void setEnumDiskTypeCollection(Collection<EnumDiskType> enumDiskTypeCollection) {
        this.enumDiskTypeCollection = enumDiskTypeCollection;
    }

    @XmlTransient
    public Collection<Studio> getStudioCollection() {
        return studioCollection;
    }

    public void setStudioCollection(Collection<Studio> studioCollection) {
        this.studioCollection = studioCollection;
    }

    @XmlTransient
    public Collection<EnumAspectRatio> getEnumAspectRatioCollection() {
        return enumAspectRatioCollection;
    }

    public void setEnumAspectRatioCollection(Collection<EnumAspectRatio> enumAspectRatioCollection) {
        this.enumAspectRatioCollection = enumAspectRatioCollection;
    }

    @XmlTransient
    public Collection<Director> getDirectorCollection() {
        return directorCollection;
    }

    public void setDirectorCollection(Collection<Director> directorCollection) {
        this.directorCollection = directorCollection;
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
        if (!(object instanceof DiskMovie)) {
            return false;
        }
        DiskMovie other = (DiskMovie) object;
        if ((this.upc == null && other.upc != null) || (this.upc != null && !this.upc.equals(other.upc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.DiskMovie[ upc=" + upc + " ]";
    }

}
