/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import emasa.entidades.Aviso;
import emasa.entidades.Brigada;
import emasa.entidades.OrdTrabajo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;

import javax.faces.application.FacesMessage;
import javax.enterprise.context.RequestScoped;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author malex
 */
@Named(value = "controlOrdenTrabajo")
@RequestScoped
public class ControlOrdenTrabajo implements Serializable{

    /**
     * Creates a new instance of ControlOrdenTrabajo
     */
    
    
    private List<OrdTrabajo> listOrd;
    private OrdTrabajo ordSelected;
    private OrdTrabajo ordHelper;
    private Integer idAviso;
    private List<Integer> idOrd;
    private List<Integer> idSup;
    private List<String> estado;
    private List<Brigada> brig;
  

    
    public void setIdAviso(Integer idAviso) {
        this.idAviso = idAviso;
    }

    public void setIdOrd(List<Integer> idOrd) {
        this.idOrd = idOrd;
    }

    public void setIdSup(List<Integer> idSup) {
        this.idSup = idSup;
    }

    public void setEstado(List<String> estado) {
        this.estado = estado;
    }

    public void setBrig(List<Brigada> brig) {
        this.brig = brig;
    }

    public List<Integer> getIdOrd() {
        return idOrd;
    }

   

    public List<Integer> getIdSup() {
        return idSup;
    }

    

    public List<String> getEstado() {
        return estado;
    }

   

    public List<Brigada> getBrig() {
        return brig;
    }

    
   

    public OrdTrabajo getOrdHelper() {
        return ordHelper;
    }

    public void setOrdHelper(OrdTrabajo ordHelper) {
        this.ordHelper = ordHelper;
    }

    public Integer getIdAviso() {
        return idAviso;
    }

    
    @Inject
    private OpcionesAviso aviso;

    public OrdTrabajo getOrdSelected() {
        
        return ordSelected;
    }

    public void setOrdSelected(OrdTrabajo ordSelected) {
        
        this.ordSelected = ordSelected;
    }

  
    public ControlOrdenTrabajo() {
    }
    
    

    public List<OrdTrabajo> getListOrd() {
        return listOrd;
    }

    public void setListOrd(List<OrdTrabajo> listOrd) {
        this.listOrd = listOrd;
    }
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Orden de trabajo Seleccionada", String.valueOf(((OrdTrabajo) event.getObject()).getIdOrden()));  
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Orden de trabajo Seleccionada", String.valueOf(((OrdTrabajo) event.getObject()).getIdOrden()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    @PostConstruct
    public void init()
    {
        idOrd=new ArrayList<>();
        listOrd=new ArrayList<>();
        if(aviso.getHistoricoReciente().getOrdTrabajoCollection().isEmpty()){
        ordHelper = new OrdTrabajo();
        ordHelper.setEstado("Abierta");
        Date sys =new Date();
        ordHelper.setFechaCreacion(sys);
        ordHelper.setIdOrden(1);
        
        ordHelper.setNumBrigada(new Brigada(2));
        aviso.getHistoricoReciente().getOrdTrabajoCollection().add(ordHelper);
        
        
        
        ordHelper = new OrdTrabajo();
        ordHelper.setEstado("Trabajando");
       
        ordHelper.setFechaCreacion(sys);
        ordHelper.setIdOrden(2);
        
        ordHelper.setNumBrigada(new Brigada(3));
        aviso.getHistoricoReciente().getOrdTrabajoCollection().add(ordHelper);
        
        }
        
        listOrd=(List<OrdTrabajo>) aviso.getHistoricoReciente().getOrdTrabajoCollection();
        setIdAviso(aviso.getAviso().getIdAviso());
       
                   
        
        
        
        
        
        
        
        
        
        
    }
    
    
}
