/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import emasa.entidades.Actuaciones;
import emasa.entidades.Historico;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author malex
 */
@Named(value = "controlActuaciones")
@Dependent
public class ControlActuaciones {

    /**
     * Creates a new instance of ControlActuaciones
     */
   
    private Actuaciones actuacionSelected; 
    @Inject 
    private OrdenTrabajo  ordenTrabajo;
    
     public Actuaciones getActuacionSelected() {
        return actuacionSelected;
    }

    public void setActuacionSelected(Actuaciones actuacionSelected) {
        this.actuacionSelected = actuacionSelected;
    }
    

    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }
    
    public ControlActuaciones() {
    }
    
    public List<Actuaciones> getActuaciones(){
        List<Actuaciones> res=new ArrayList<>();
        
        res=(List<Actuaciones>)ordenTrabajo.getOrd().getActuacionesCollection();
        
        
        return res;
        
        
       
        
    }
}
