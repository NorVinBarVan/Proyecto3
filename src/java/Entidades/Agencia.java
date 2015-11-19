package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "AGENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agencia.findAll", query = "SELECT a FROM Agencia a"),
    @NamedQuery(name = "Agencia.findByCodigoAgencia", query = "SELECT a FROM Agencia a WHERE a.codigoAgencia = :codigoAgencia"),
    @NamedQuery(name = "Agencia.findByNombre", query = "SELECT a FROM Agencia a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Agencia.findByDireccion", query = "SELECT a FROM Agencia a WHERE a.direccion = :direccion"),
    @NamedQuery(name = "Agencia.findByDepartamento", query = "SELECT a FROM Agencia a WHERE a.departamento = :departamento"),
    @NamedQuery(name = "Agencia.findByTelefono", query = "SELECT a FROM Agencia a WHERE a.telefono = :telefono")})
public class Agencia implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_AGENCIA")
    private BigDecimal codigoAgencia;
    @Size(max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 20)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 50)
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @Column(name = "TELEFONO")
    private BigInteger telefono;
    @JoinTable(name = "ASIGNACION", joinColumns = {
        @JoinColumn(name = "CODIGO_AGENCIA", referencedColumnName = "CODIGO_AGENCIA")}, inverseJoinColumns = {
        @JoinColumn(name = "CODIGO_ADM", referencedColumnName = "CODIGO_ADM")})
    @ManyToMany
    private Collection<Administrador> administradorCollection;
    @JoinTable(name = "CONTROL", joinColumns = {
        @JoinColumn(name = "CODIGO_AGENCIA", referencedColumnName = "CODIGO_AGENCIA")}, inverseJoinColumns = {
        @JoinColumn(name = "CODIGO_VENDEDOR", referencedColumnName = "CODIGO_VENDEDOR")})
    @ManyToMany
    private Collection<Vendedor> vendedorCollection;

    public Agencia() {
    }

    public Agencia(BigDecimal codigoAgencia) {
        this.codigoAgencia = codigoAgencia;
    }

    public BigDecimal getCodigoAgencia() {
        return codigoAgencia;
    }

    public void setCodigoAgencia(BigDecimal codigoAgencia) {
        this.codigoAgencia = codigoAgencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public Collection<Administrador> getAdministradorCollection() {
        return administradorCollection;
    }

    public void setAdministradorCollection(Collection<Administrador> administradorCollection) {
        this.administradorCollection = administradorCollection;
    }

    @XmlTransient
    public Collection<Vendedor> getVendedorCollection() {
        return vendedorCollection;
    }

    public void setVendedorCollection(Collection<Vendedor> vendedorCollection) {
        this.vendedorCollection = vendedorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAgencia != null ? codigoAgencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof Agencia)) {
            return false;
        }
        Agencia other = (Agencia) object;
        if ((this.codigoAgencia == null && other.codigoAgencia != null) || (this.codigoAgencia != null && !this.codigoAgencia.equals(other.codigoAgencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Agencia[ codigoAgencia=" + codigoAgencia + " ]";
    }
    
}
