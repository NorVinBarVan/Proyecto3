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
@Table(name = "SOLICITUD_DE_COMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudDeCompra.findAll", query = "SELECT s FROM SolicitudDeCompra s"),
    @NamedQuery(name = "SolicitudDeCompra.findByCodigoSolicitud", query = "SELECT s FROM SolicitudDeCompra s WHERE s.codigoSolicitud = :codigoSolicitud"),
    @NamedQuery(name = "SolicitudDeCompra.findByFechaDeCreacion", query = "SELECT s FROM SolicitudDeCompra s WHERE s.fechaDeCreacion = :fechaDeCreacion"),
    @NamedQuery(name = "SolicitudDeCompra.findByPaqueteAComprar", query = "SELECT s FROM SolicitudDeCompra s WHERE s.paqueteAComprar = :paqueteAComprar"),
    @NamedQuery(name = "SolicitudDeCompra.findByPrecio", query = "SELECT s FROM SolicitudDeCompra s WHERE s.precio = :precio")})
public class SolicitudDeCompra implements Serializable {
    private static final long serialVersionUID = 1L;
     
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_SOLICITUD")
    private BigDecimal codigoSolicitud;
    @Column(name = "FECHA_DE_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDeCreacion;
    @Size(max = 50)
    @Column(name = "PAQUETE_A_COMPRAR")
    private String paqueteAComprar;
    @Column(name = "PRECIO")
    private BigInteger precio;
    @JoinColumn(name = "CODIGO_ADM", referencedColumnName = "CODIGO_ADM")
    @ManyToOne
    private Administrador codigoAdm;
    @JoinColumn(name = "CODIGO_VENDEDOR", referencedColumnName = "CODIGO_VENDEDOR")
    @ManyToOne
    private Vendedor codigoVendedor;

    public SolicitudDeCompra() {
    }

    public SolicitudDeCompra(BigDecimal codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }

    public BigDecimal getCodigoSolicitud() {
        return codigoSolicitud;
    }

    public void setCodigoSolicitud(BigDecimal codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public String getPaqueteAComprar() {
        return paqueteAComprar;
    }

    public void setPaqueteAComprar(String paqueteAComprar) {
        this.paqueteAComprar = paqueteAComprar;
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

    public Vendedor getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(Vendedor codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoSolicitud != null ? codigoSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
  
        if (!(object instanceof SolicitudDeCompra)) {
            return false;
        }
        SolicitudDeCompra other = (SolicitudDeCompra) object;
        if ((this.codigoSolicitud == null && other.codigoSolicitud != null) || (this.codigoSolicitud != null && !this.codigoSolicitud.equals(other.codigoSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.SolicitudDeCompra[ codigoSolicitud=" + codigoSolicitud + " ]";
    }
    
}
