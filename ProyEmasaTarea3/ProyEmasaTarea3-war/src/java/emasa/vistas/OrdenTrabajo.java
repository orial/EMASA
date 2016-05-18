/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import emasa.modelo.OrdTrabajo;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author malex
 */
@Named(value = "ordenTrabajo")
@SessionScoped
@EJB OrdTrabajoNegocio ordTrabajoNegocio;

public class OrdenTrabajo implements Serializable {

    @Inject
    private CalendarioVista calendario;
    @Inject
    private OpcionesAviso aviso;

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
        return ID_aviso;
    }

    public void setID_aviso(int ID_aviso) {
        this.ID_aviso = ID_aviso;
    }

    private int ID_aviso;

    /**
     * Creates a new instance of Orden_trabajo
     */
    public OrdenTrabajo() {

    }

    @PostConstruct

    public void init() {
        orden_trabajo = new ArrayList<>();

        ID_aviso = (int) (Math.random() * 10 + 1);

        //orden_trabajo.add(new OrdTrabajo((integer)*10+1));
    }

    public String crearOT() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            ord = new OrdTrabajo(ID_aviso, sdf.parse(calendario.getFecha_actual()), trabajo_realizar, Num_Brigada, aviso.getHistoricoReciente().getEstado());
        } catch (ParseException ex) {
            Logger.getLogger(OrdenTrabajo.class.getName()).log(Level.SEVERE, null, ex);
        }

        ord.setFechaCreacion(calendario.getDate1());
        
        ordTrabajoNegocio.anadirOrden(ord);
        

        return "ordenTrabajo.xhtml";

    }

}
