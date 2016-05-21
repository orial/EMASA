/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import emasa.entidades.Aviso;
import emasa.entidades.OrdTrabajo;
import java.io.Serializable;
import java.util.ArrayList;
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
        FacesMessage msg = new FacesMessage("Orden de trabajo Seleccionada", String.valueOf(((Aviso) event.getObject()).getIdAviso()));  
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Orden de trabajo Seleccionada", String.valueOf(((Aviso) event.getObject()).getIdAviso()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    @PostConstruct
    
    public void init()
    {
        listOrd=new ArrayList<>();
        
      
        
    listOrd=(List<OrdTrabajo>) aviso.getHistoricoReciente().getOrdTrabajoCollection();
        
    }
    
    
}
