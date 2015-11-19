package Controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;
import Entidades.*;
import Patrones.AdministradorFacade;
import Patrones.AgenciaFacade;
import Patrones.PaquetesVacacionalesFacade;
import Patrones.SolicitudDeCompraFacade;
import Patrones.VendedorFacade;
import javax.ejb.EJB;

/**
 *
 * @author NORMAN VINICIO BARRERA VANEGAS
 */
@Named(value = "proyecto3Controlador")
@ManagedBean
@SessionScoped
public class Proyecto3Controlador implements Serializable {
    
        //Creacion de Vendedores
    @EJB
    private VendedorFacade vendedorFacade;
    private Vendedor v = new Vendedor();

    public Vendedor getV() {
        return v;
    }

    public void setV(Vendedor v) {
        this.v = v;
    }
    
    //Creacion de Solicitudes
    @EJB
    private SolicitudDeCompraFacade solicitudDeCompraFacade;
    private SolicitudDeCompra s = new SolicitudDeCompra();

    public SolicitudDeCompra getS() {
        return s;
    }

    public void setS(SolicitudDeCompra s) {
        this.s = s;
    }
    
    //Creacion de Paquetes
    @EJB
    private PaquetesVacacionalesFacade paquetesVacacionalesFacade;
    private PaquetesVacacionales p = new PaquetesVacacionales();

    public PaquetesVacacionales getP() {
        return p;
    }

    public void setP(PaquetesVacacionales p) {
        this.p = p;
    }
    
    //Creacion de Agencias
    @EJB
    private AgenciaFacade agenciaFacade;
    private Agencia a = new Agencia();

    public Agencia getA() {
        return a;
    }

    public void setA(Agencia a) {
        this.a = a;
    }
    
    //Creacion de Administradores
    @EJB
    private AdministradorFacade administradorFacade;
    private Administrador adm = new Administrador();

    public Administrador getAdm() {
        return adm;
    }

    public void setAdm(Administrador adm) {
        this.adm = adm;
    }

    public Proyecto3Controlador() {
    }
    
    //Todos los Buscadores
    public List<Administrador> findAdministrador()
    {
        return this.administradorFacade.findAll();
    }
    
    public List<Agencia> findAgencia()
    {
        return this.agenciaFacade.findAll();
    }
    
    public List<PaquetesVacacionales> findPaquetes()
    {
        return this.paquetesVacacionalesFacade.findAll();
    }
    
    public List<SolicitudDeCompra> findSolicitudes()
    {
        return this.solicitudDeCompraFacade.findAll();
    }
    
    public List<Vendedor> findVendedor()
    {
        return this.vendedorFacade.findAll();
    }
    
    //Metodos para agregar, modificar, eliminar administradores
    public String Administrador_Agregar()
    {
        this.administradorFacade.create(this.adm);
        this.adm = new Administrador();
        return "index";
    }
    
    public void Administrador_Eliminar(Administrador adm)
    {
        this.administradorFacade.remove(adm);
    }
    
    public String Administrador_Modificar (Administrador adm)
    {
        this.adm = adm;
        return "Administrador_Modificar";
    }
    
    public String Administrador_Modificar ()
    {
        this.administradorFacade.edit(this.adm);
        this.adm = new Administrador();
        return "index";
    }
    
    //Metodos para agregar, modificar, eliminar agencias
    public String Agencia_Agregar()
    {
        this.agenciaFacade.create(this.a);
        this.a = new Agencia();
        return "index";
    }
    
    public void Agencia_Eliminar(Agencia a)
    {
        this.agenciaFacade.remove(a);
    }
    
    public String Agencia_Modificar (Agencia a)
    {
        this.a = a;
        return "Agencia_Modificar";
    }
    
    public String Agencia_Modificar ()
    {
        this.agenciaFacade.edit(this.a);
        this.a = new Agencia();
        return "index";
    }
    
    //Metodos para agregar, modificar, eliminar vendedores
    public String Vendedor_Agregar()
    {
        this.vendedorFacade.create(this.v);
        this.v = new Vendedor();
        return "index";
    }
    
    public void Vendedor_Eliminar(Vendedor v)
    {
        this.vendedorFacade.remove(v);
    }
    
    public String Vendedor_Modificar (Vendedor v)
    {
        this.v = v;
        return "Vendedor_Modificar";
    }
    
    public String Vendedor_Modificar ()
    {
        this.vendedorFacade.edit(this.v);
        this.v = new Vendedor();
        return "index";
    }
    
    //Metodos para agregar, modificar, eliminar solicitudes
    public String Solicitud_Agregar()
    {
        this.solicitudDeCompraFacade.create(this.s);
        this.s= new SolicitudDeCompra();
        return "index";
    }
    
    public void Solicitud_Eliminar(SolicitudDeCompra s)
    {
        this.solicitudDeCompraFacade.remove(s);
    }
    
    public String Solicitud_Modificar (SolicitudDeCompra s)
    {
        this.s = s;
        return "Solicitud_Modificar";
    }
    
    public String Solicitud_Modificar ()
    {
        this.solicitudDeCompraFacade.edit(this.s);
        this.s = new SolicitudDeCompra();
        return "index";
    }
    
    //Metodos para agregar, modificar, eliminar paquetes
    public String Paquete_Agregar()
    {
        this.paquetesVacacionalesFacade.create(this.p);
        this.p = new PaquetesVacacionales();
        return "index";
    }
    
    public void Paquete_Eliminar(PaquetesVacacionales p)
    {
        this.paquetesVacacionalesFacade.remove(p);
    }
    
    public String Paquete_Modificar (PaquetesVacacionales p)
    {
        this.p = p;
        return "Paquete_Modificar";
    }
    
    public String Paquete_Modificar()
    {
        this.paquetesVacacionalesFacade.edit(this.p);
        this.p = new PaquetesVacacionales();
        return "index";
    }
    
}
