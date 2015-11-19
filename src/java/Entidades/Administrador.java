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
@Table(name = "ADMINISTRADOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findByCodigoAdm", query = "SELECT a FROM Administrador a WHERE a.codigoAdm = :codigoAdm"),
    @NamedQuery(name = "Administrador.findByNombre", query = "SELECT a FROM Administrador a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Administrador.findByNit", query = "SELECT a FROM Administrador a WHERE a.nit = :nit"),
    @NamedQuery(name = "Administrador.findByEdad", query = "SELECT a FROM Administrador a WHERE a.edad = :edad"),
    @NamedQuery(name = "Administrador.findBySalario", query = "SELECT a FROM Administrador a WHERE a.salario = :salario")})
public class Administrador implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_ADM")
    private BigDecimal codigoAdm;
    @Size(max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "NIT")
    private BigInteger nit;
    @Column(name = "EDAD")
    private BigInteger edad;
    @Column(name = "SALARIO")
    private BigInteger salario;
    @ManyToMany(mappedBy = "administradorCollection")
    private Collection<Agencia> agenciaCollection;
    @OneToMany(mappedBy = "codigoAdm")
    private Collection<PaquetesVacacionales> paquetesVacacionalesCollection;
    @OneToMany(mappedBy = "codigoAdm")
    private Collection<SolicitudDeCompra> solicitudDeCompraCollection;

    public Administrador() {
    }

    public Administrador(BigDecimal codigoAdm) {
        this.codigoAdm = codigoAdm;
    }

    public BigDecimal getCodigoAdm() {
        return codigoAdm;
    }

    public void setCodigoAdm(BigDecimal codigoAdm) {
        this.codigoAdm = codigoAdm;
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
    public Collection<PaquetesVacacionales> getPaquetesVacacionalesCollection() {
        return paquetesVacacionalesCollection;
    }

    public void setPaquetesVacacionalesCollection(Collection<PaquetesVacacionales> paquetesVacacionalesCollection) {
        this.paquetesVacacionalesCollection = paquetesVacacionalesCollection;
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
        hash += (codigoAdm != null ? codigoAdm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.codigoAdm == null && other.codigoAdm != null) || (this.codigoAdm != null && !this.codigoAdm.equals(other.codigoAdm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Administrador[ codigoAdm=" + codigoAdm + " ]";
    }
    
}
