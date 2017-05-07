
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
@Table(name = "EnumFormat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnumFormat.findAll", query = "SELECT e FROM EnumFormat e"),
    @NamedQuery(name = "EnumFormat.findByFormat", query = "SELECT e FROM EnumFormat e WHERE e.format = :format")})
public class EnumFormat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "format")
    private String format;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "format_description")
    private String formatDescription;
    @ManyToMany(mappedBy = "enumFormatCollection")
    private Collection<DiskMovie> diskMovieCollection;

    public EnumFormat() {
    }

    public EnumFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFormatDescription() {
        return formatDescription;
    }

    public void setFormatDescription(String formatDescription) {
        this.formatDescription = formatDescription;
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
        hash += (format != null ? format.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnumFormat)) {
            return false;
        }
        EnumFormat other = (EnumFormat) object;
        if ((this.format == null && other.format != null) || (this.format != null && !this.format.equals(other.format))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.entity.EnumFormat[ format=" + format + " ]";
    }

}
