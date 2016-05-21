/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import emasa.entidades.Actuaciones;
import emasa.entidades.Brigada;
import emasa.entidades.Empleado;
import emasa.entidades.Historico;
import emasa.entidades.OrdTrabajo;
import emasa.negocio.BrigadaNegocio;
import emasa.negocio.OrdTrabajoNegocio;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author malex
 */
@Named(value = "ordenTrabajo")
@SessionScoped


public class OrdenTrabajo implements Serializable {

    @Inject
    private CalendarioVista calendario;
    @Inject
    private OpcionesAviso aviso;
    @EJB OrdTrabajoNegocio ordTrabajoNegocio;
    @EJB BrigadaNegocio brigadaNegocio;
    private Integer brigadaSelect;
    private String estado="";
    private String actuacionesRealizadas="";
    private String actuacionesObservaciones="";

    public String getActuacionesObservaciones() {
        return actuacionesObservaciones;
    }

    public void setActuacionesObservaciones(String actuacionesObservaciones) {
        this.actuacionesObservaciones = actuacionesObservaciones;
    }

    public String getActuacionesRealizadas() {
        return actuacionesRealizadas;
    }

    public void setActuacionesRealizadas(String actuacionesRealizadas) {
        this.actuacionesRealizadas = actuacionesRealizadas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getID_Orden() {
        return ID_Orden;
    }

    public void setID_Orden(int ID_Orden) {
        this.ID_Orden = ID_Orden;
    }
    private List<Integer> brigadasList;

    public List<Integer> getBrigadasList() {
        return brigadasList;
    }

    public void setBrigadasList(List<Integer> brigadasList) {
        this.brigadasList = brigadasList;
    }
    
    
    
    public Integer getBrigadaSelect() {
        return brigadaSelect;
    }

    public void setBrigadaSelect(Integer brigadaSelect) {
        this.brigadaSelect = brigadaSelect;
    }

    public CalendarioVista getCalendario() {
        return calendario;
    }

    public void setCalendario(CalendarioVista calendario) {
        this.calendario = calendario;
    }

    public OpcionesAviso getAviso() {
        return aviso;
    }

    public void setAviso(OpcionesAviso aviso) {
        this.aviso = aviso;
    }

    public String getTrabajo_realizar() {
        return trabajo_realizar;
    }

    public void setTrabajo_realizar(String trabajo_realizar) {
        this.trabajo_realizar = trabajo_realizar;
    }
    private String trabajo_realizar;

    public int getNum_Brigada() {
        return Num_Brigada;
    }

    public void setNum_Brigada(int Num_Brigada) {
        this.Num_Brigada = Num_Brigada;
    }

    private int Num_Brigada;
    
    private List<Brigada> brigadas;

    public BrigadaNegocio getBrigadaNegocio() {
        return brigadaNegocio;
    }

    public void setBrigadaNegocio(BrigadaNegocio brigadaNegocio) {
        this.brigadaNegocio = brigadaNegocio;
    }

    public Brigada getBrigada() {
        return brigada;
    }

    public void setBrigada(Brigada brigada) {
        this.brigada = brigada;
    }
    private Brigada brigada;
    public OrdTrabajoNegocio getOrdTrabajoNegocio() {
        return ordTrabajoNegocio;
    }

    public void setOrdTrabajoNegocio(OrdTrabajoNegocio ordTrabajoNegocio) {
        this.ordTrabajoNegocio = ordTrabajoNegocio;
    }

    public List<Brigada> getBrigadas() {
        return brigadas;
    }

    public void setBrigadas(List<Brigada> brigadas) {
        this.brigadas = brigadas;
    }
    
    List<OrdTrabajo> orden_trabajo;

    public List<OrdTrabajo> getOrden_trabajo() {
        return orden_trabajo;
    }

    public void setOrden_trabajo(List<OrdTrabajo> orden_trabajo) {
        this.orden_trabajo = orden_trabajo;
    }

    public OrdTrabajo getOrd() {
        return ord;
    }

    public void setOrd(OrdTrabajo ord) {
        this.ord = ord;
    }
    private OrdTrabajo ord;

    public int getID_aviso() {
        return ID_Orden;
    }

    public void setID_aviso(int ID_aviso) {
        this.ID_Orden = ID_aviso;
    }

    private int ID_Orden;

    /**
     * Creates a new instance of Orden_trabajo
     */
    public OrdenTrabajo() {

    }
    public String volver()
    {
        return "bandejaOrdenTrabajo.xhtml";
    }

    @PostConstruct

    public void init() {
        orden_trabajo = new ArrayList<>();
        brigadasList= new ArrayList<>();

        ID_Orden = (int) (Math.random() * 1000 + 1);
        
        brigadas=brigadaNegocio.buscarBrigadas();
        
        
        //orden_trabajo.add(new OrdTrabajo((integer)*10+1));
        
      for (Brigada b: brigadas)
      {
          
          brigadasList.add(b.getNumBrigada());
          
      }
        
      if (estado.equals(""))
      {
          estado="---------";
      }
      
      if(actuacionesRealizadas.equals(""))
      {
          actuacionesRealizadas="Vacio";
      }
        
        
        
    }

    public String crearOT() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            brigada=brigadaNegocio.buscarBrigada(brigadaSelect);
            
            System.out.println(brigada);
            
            ord = new OrdTrabajo(ID_Orden, sdf.parse(calendario.getFecha_actual()), trabajo_realizar, brigada, aviso.getHistoricoReciente().getEstado());
            
        } catch (ParseException ex) {
            Logger.getLogger(OrdenTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
            
      ord.setEstado("abierto");
        
 
        
        
        
        
        ord.setHistorico(aviso.getHistoricoReciente());
      
   
        ordTrabajoNegocio.anadirOrden(ord);
        
        aviso.getHistoricoReciente().getOrdTrabajoCollection().add(ord);
        

        return "ordenTrabajo.xhtml";

    }
    
     

}
