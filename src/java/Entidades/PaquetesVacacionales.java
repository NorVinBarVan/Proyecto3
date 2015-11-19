package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NORMAN VINICIO BARRERA VANEGAS
 */
@Entity
@Table(name = "PAQUETES_VACACIONALES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaquetesVacacionales.findAll", query = "SELECT p FROM PaquetesVacacionales p"),
    @NamedQuery(name = "PaquetesVacacionales.findByCodigoPaquete", query = "SELECT p FROM PaquetesVacacionales p WHERE p.codigoPaquete = :codigoPaquete"),
    @NamedQuery(name = "PaquetesVacacionales.findByNombre", query = "SELECT p FROM PaquetesVacacionales p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PaquetesVacacionales.findByDescripcion", query = "SELECT p FROM PaquetesVacacionales p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PaquetesVacacionales.findByFechaDeEjecucion", query = "SELECT p FROM PaquetesVacacionales p WHERE p.fechaDeEjecucion = :fechaDeEjecucion"),
    @NamedQuery(name = "PaquetesVacacionales.findByPrecio", query = "SELECT p FROM PaquetesVacacionales p WHERE p.precio = :precio")})
public class PaquetesVacacionales implements Serializable {
    private static final long serialVersionUID = 1L;
   
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_PAQUETE")
    private BigDecimal codigoPaquete;
    @Size(max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "FECHA_DE_EJECUCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDeEjecucion;
    @Column(name = "PRECIO")
    private BigInteger precio;
    @JoinColumn(name = "CODIGO_ADM", referencedColumnName = "CODIGO_ADM")
    @ManyToOne
    private Administrador codigoAdm;

    public PaquetesVacacionales() {
    }

    public PaquetesVacacionales(BigDecimal codigoPaquete) {
        this.codigoPaquete = codigoPaquete;
    }

    public BigDecimal getCodigoPaquete() {
        return codigoPaquete;
    }

    public void setCodigoPaquete(BigDecimal codigoPaquete) {
        this.codigoPaquete = codigoPaquete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaDeEjecucion() {
        return fechaDeEjecucion;
    }

    public void setFechaDeEjecucion(Date fechaDeEjecucion) {
        this.fechaDeEjecucion = fechaDeEjecucion;
    }

    public BigInteger getPrecio() {
        return precio;
    }

    public void setPrecio(BigInteger precio) {
        this.precio = precio;
    }

    public Administrador getCodigoAdm() {
        return codigoAdm;
    }

    public void setCodigoAdm(Administrador codigoAdm) {
        this.codigoAdm = codigoAdm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPaquete != null ? codigoPaquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
    
        if (!(object instanceof PaquetesVacacionales)) {
            return false;
        }
        PaquetesVacacionales other = (PaquetesVacacionales) object;
        if ((this.codigoPaquete == null && other.codigoPaquete != null) || (this.codigoPaquete != null && !this.codigoPaquete.equals(other.codigoPaquete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PaquetesVacacionales[ codigoPaquete=" + codigoPaquete + " ]";
    }
    
}
