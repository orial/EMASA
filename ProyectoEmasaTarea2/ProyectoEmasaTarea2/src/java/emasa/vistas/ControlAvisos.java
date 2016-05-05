/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import emasa.modelo.Aviso;
import emasa.modelo.Datos;
import emasa.modelo.Empleado;
import emasa.modelo.Historico;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author alumno
 */

@Named(value="controlAvisos")
@SessionScoped
public class ControlAvisos implements Serializable{

    @Inject
    private LoginBean login;
    
    @Inject 
    private Datos datos;
    private List<Aviso> avisos;
    private Empleado empleado;
    private Aviso avisoSelected;
    /**
     * Creates a new instance of ControlAvisos
     */
    public ControlAvisos() {
    }
    public List<Aviso> getAvisos(){
        empleado=login.getUsr();
        avisos =datos.getAvisos();
        List<Aviso> res=new ArrayList<>();
        for(Aviso av: avisos){
            for (Historico h:av.getHistoricoCollection()){
                if(h.getHistoricoPK().getSupervisor()==empleado.getIdEmpleado() && (!res.contains(av))){
                    res.add(av);
                }
            } 
        }
        return res;
    }
    //busco el historico mas reciente
    public Historico getHistorico(Aviso aviso){
        List<Historico> historico = null;
         Historico reciente=null;
         if(aviso!=null)//primefaces al intentar ordenar usando el historico manda avisos nulos
            if(aviso.getHistoricoCollection()!=null){//siempre tiene que tener un historico
               //creo una lista de historicos para las pruebas, pero aqui siempre debe tener por lo menos un historico
                   historico = (List<Historico>) aviso.getHistoricoCollection();   
                   for(Historico h :historico){
                       if(reciente==null||h.getHistoricoPK().getFechaActualizacion().after(reciente.getHistoricoPK().getFechaActualizacion())){
                           reciente=h;
                       }
                   }
            }else{
               reciente=new Historico();
               List <Historico> lista=new ArrayList();
               lista.add(reciente);
               aviso.setHistoricoCollection(lista);
           }
        
        return reciente;
    }
    public boolean isSupervisor(){
        boolean res=false;
        empleado=login.getUsr();
        res= empleado.getCargo().equalsIgnoreCase("Supervisor");
        return res;
    }
    
    public Aviso getAvisoSelected() {
        return avisoSelected;
    }

    public void setAvisoSelected(Aviso avisoSelected) {
        this.avisoSelected = avisoSelected;
    }
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Aviso Seleccionado", String.valueOf(((Aviso) event.getObject()).getIdAviso()));  
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Aviso Deseleccionado", String.valueOf(((Aviso) event.getObject()).getIdAviso()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public String getFechaReciente(Date fecha){
       SimpleDateFormat formateador = new SimpleDateFormat("dd / MM / yyyy");
       return formateador.format(fecha);
    }
   
     

}

