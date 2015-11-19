package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NORMAN VINICIO BARRERA VANEGAS
 */
@Entity
@Table(name = "VENDEDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v"),
    @NamedQuery(name = "Vendedor.findByCodigoVendedor", query = "SELECT v FROM Vendedor v WHERE v.codigoVendedor = :codigoVendedor"),
    @NamedQuery(name = "Vendedor.findByNombre", query = "SELECT v FROM Vendedor v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "Vendedor.findByNit", query = "SELECT v FROM Vendedor v WHERE v.nit = :nit"),
    @NamedQuery(name = "Vendedor.findByEdad", query = "SELECT v FROM Vendedor v WHERE v.edad = :edad"),
    @NamedQuery(name = "Vendedor.findBySalario", query = "SELECT v FROM Vendedor v WHERE v.salario = :salario")})
public class Vendedor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_VENDEDOR")
    private BigDecimal codigoVendedor;
    @Size(max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "NIT")
    private BigInteger nit;
    @Column(name = "EDAD")
    private BigInteger edad;
    @Column(name = "SALARIO")
    private BigInteger salario;
    @ManyToMany(mappedBy = "vendedorCollection")
    private Collection<Agencia> agenciaCollection;
    @OneToMany(mappedBy = "codigoVendedor")
    private Collection<SolicitudDeCompra> solicitudDeCompraCollection;

    public Vendedor() {
    }

    public Vendedor(BigDecimal codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public BigDecimal getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(BigDecimal codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigInteger getNit() {
        return nit;
    }

    public void setNit(BigInteger nit) {
        this.nit = nit;
    }

    public BigInteger getEdad() {
        return edad;
    }

    public void setEdad(BigInteger edad) {
        this.edad = edad;
    }

    public BigInteger getSalario() {
        return salario;
    }

    public void setSalario(BigInteger salario) {
        this.salario = salario;
    }

    @XmlTransient
    public Collection<Agencia> getAgenciaCollection() {
        return agenciaCollection;
    }

    public void setAgenciaCollection(Collection<Agencia> agenciaCollection) {
        this.agenciaCollection = agenciaCollection;
    }

    @XmlTransient
    public Collection<SolicitudDeCompra> getSolicitudDeCompraCollection() {
        return solicitudDeCompraCollection;
    }

    public void setSolicitudDeCompraCollection(Collection<SolicitudDeCompra> solicitudDeCompraCollection) {
        this.solicitudDeCompraCollection = solicitudDeCompraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoVendedor != null ? codigoVendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.codigoVendedor == null && other.codigoVendedor != null) || (this.codigoVendedor != null && !this.codigoVendedor.equals(other.codigoVendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Vendedor[ codigoVendedor=" + codigoVendedor + " ]";
    }
    
}
