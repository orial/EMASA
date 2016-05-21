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
@Named(value = "modificarOrdTrabajo")
@SessionScoped

public class ModificarOrdTrabajo implements Serializable {

    @Inject
    private ControlOrdenTrabajo ord;
    
    @EJB
    OrdTrabajoNegocio ordTrabajoNegocio;
    @EJB
    BrigadaNegocio brigadaNegocio;
    private Integer brigadaSelect;
    private String estado = "";
    private String actuacionesRealizadas = "";
    private String actuacionesObservaciones = "";
    private int Num_Brigada;

    public ControlOrdenTrabajo getOrd() {
        return ord;
    }

    public void setOrd(ControlOrdenTrabajo ord) {
        this.ord = ord;
    }

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

    public Integer getBrigadaSelect() {
        return brigadaSelect;
    }

    public void setBrigadaSelect(Integer brigadaSelect) {
        this.brigadaSelect = brigadaSelect;
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

   

    
   

    // private OrdTrabajo ord;
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
    public ModificarOrdTrabajo() {

    }

    @PostConstruct

    public void init() {
        

        

       

        //orden_trabajo.add(new OrdTrabajo((integer)*10+1));
        if (estado.equals("")) {
            estado = "---------";
        }

        if (actuacionesRealizadas.equals("")) {
            actuacionesRealizadas = "Vacio";
        }

    }
    

    public String modificarActuacion() {
        //id_aviso,fecha_entrada,supervisor_asignado,descripcion,direccion,estado,duplicado,fechacierre,tipodeaviso,urgencia,ubicacion_gps,red_agua

        Actuaciones actuacion = new Actuaciones();

        actuacion.setOperRealizadas(actuacionesRealizadas);
        actuacion.setObservaciones(actuacionesObservaciones);

        actuacion.getActuacionesPK().setFechaActuacion(new Date());

        ord.getOrdSelected().getActuacionesCollection().add(actuacion);

        ordTrabajoNegocio.actualizarOrden(ord.getOrdSelected());

        return "ordenTrabajoClient.xhtml";

    }

    public String historicoOT() {
        return "historicoOTClient.xhtml";
    }

    public String cerrarOT() {

        if (estado.equals("abierto")) {
            ord.getOrdSelected().setEstado("cerrado");

            ordTrabajoNegocio.actualizarOrden(ord.getOrdSelected());
            return "avisoClient.xhtml";
        }

        return null;

    }

}
