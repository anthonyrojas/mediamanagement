
package database.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Media")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Media.findAll", query = "SELECT m FROM Media m"),
    @NamedQuery(name = "Media.findByUpc", query = "SELECT m FROM Media m WHERE m.upc = :upc"),
    @NamedQuery(name = "Media.findByTitle", query = "SELECT m FROM Media m WHERE m.title = :title")})
public class Media implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "UPC")
    private String upc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "mediaCollection")
    private Collection<EnumSubject> enumSubjectCollection;
    @ManyToMany(mappedBy = "mediaCollection")
    private Collection<EnumLanguage> enumLanguageCollection;
    @JoinTable(name = "Media_has_Review", joinColumns = {
        @JoinColumn(name = "Media_UPC", referencedColumnName = "UPC")}, inverseJoinColumns = {
        @JoinColumn(name = "Review_review_id", referencedColumnName = "review_id")})
    @ManyToMany
    private Collection<Review> reviewCollection;
    @ManyToMany(mappedBy = "mediaCollection")
    private Collection<EnumAudience> enumAudienceCollection;
    @ManyToMany(mappedBy = "mediaCollection")
    private Collection<EnumGenre> enumGenreCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mediaUPC")
    private Collection<MediaItems> mediaItemsCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "media")
    private DiskMovie diskMovie;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "media")
    private Book book;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "media")
    private Cd cd;

    public Media() {
    }

    public Media(String upc) {
        this.upc = upc;
    }

    public Media(String upc, String title, String description) {
        this.upc = upc;
        this.title = title;
        this.description = description;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<EnumSubject> getEnumSubjectCollection() {
        return enumSubjectCollection;
    }

    public void setEnumSubjectCollection(Collection<EnumSubject> enumSubjectCollection) {
        this.enumSubjectCollection = enumSubjectCollection;
    }

    @XmlTransient
    public Collection<EnumLanguage> getEnumLanguageCollection() {
        return enumLanguageCollection;
    }

    public void setEnumLanguageCollection(Collection<EnumLanguage> enumLanguageCollection) {
        this.enumLanguageCollection = enumLanguageCollection;
    }

    @XmlTransient
    public Collection<Review> getReviewCollection() {
        return reviewCollection;
    }

    public void setReviewCollection(Collection<Review> reviewCollection) {
        this.reviewCollection = reviewCollection;
    }

    @XmlTransient
    public Collection<EnumAudience> getEnumAudienceCollection() {
        return enumAudienceCollection;
    }

    public void setEnumAudienceCollection(Collection<EnumAudience> enumAudienceCollection) {
        this.enumAudienceCollection = enumAudienceCollection;
    }

    @XmlTransient
    public Collection<EnumGenre> getEnumGenreCollection() {
        return enumGenreCollection;
    }

    public void setEnumGenreCollection(Collection<EnumGenre> enumGenreCollection) {
        this.enumGenreCollection = enumGenreCollection;
    }

    @XmlTransient
    public Collection<MediaItems> getMediaItemsCollection() {
        return mediaItemsCollection;
    }

    public void setMediaItemsCollection(Collection<MediaItems> mediaItemsCollection) {
        this.mediaItemsCollection = mediaItemsCollection;
    }

    public DiskMovie getDiskMovie() {
        return diskMovie;
    }

    public void setDiskMovie(DiskMovie diskMovie) {
        this.diskMovie = diskMovie;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Cd getCd() {
        return cd;
    }

    public void setCd(Cd cd) {
        this.cd = cd;
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
        if (!(object instanceof Media)) {
            return false;
        }
        Media other = (Media) object;
        if ((this.upc == null && other.upc != null) || (this.upc != null && !this.upc.equals(other.upc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.Media[ upc=" + upc + " ]";
    }

}
