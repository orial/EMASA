/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import emasa.modelo.Aviso;
import emasa.modelo.Empleado;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author malex
 */
@Named(value = "seleccionarSupervisor")
@SessionScoped
public class SeleccionarSupervisor implements Serializable {

    public void setSupervisores(List<Empleado> supervisores) {
        this.supervisores = supervisores;
    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    public OpcionesAviso getOpciones_aviso() {
        return opciones_aviso;
    }

    public void setOpciones_aviso(OpcionesAviso opciones_aviso) {
        this.opciones_aviso = opciones_aviso;
    }

    public Integer getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(Integer idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    

    

    private Integer idSupervisor;
    

    public InicializarSupervisores getService() {
        return service;
    }
    private List<Empleado> supervisores;

    public void setService(InicializarSupervisores service) {
        this.service = service;
    }

    @Inject
    private InicializarSupervisores service;

    private Aviso aviso;
    @Inject
    private OpcionesAviso opciones_aviso;

    public SeleccionarSupervisor() {

    }

    @PostConstruct

    public void init() {
        //supervisores = service.getSupervisores();
        //supervisor_anterior = opciones_aviso.getSupervisor();

    }

    public String cambiarAsignacion() {
        aviso = opciones_aviso.getAviso();

        

        

        //supervisor = service.getSupervisores().get(id_num_supervisor);
        opciones_aviso.getHistoricoReciente().getHistoricoPK().setSupervisor(idSupervisor);

        //aviso.getIdEmpleado().setIdEmpleado(supervisor.getIdEmpleado());

        //aviso.getIdEmpleado().setNombre(supervisor.getNombre());
        //aviso.getIdEmpleado().setApellidos(supervisor.getApellidos());

        //supervisor_anterior.getAvisoCollection().remove(aviso);

        //supervisor.getAvisoCollection().add(aviso);

        return "bandejaAvisosClient.xhtml"; // tiene q ir a la de jose además tiene que hacer un remove a la lista de jose.

    }

    public List<Empleado> getSupervisores() {
        return supervisores;
    }

    public String b_cancelar() {

       
        return "avisoClient.xhtml";
    }

}
