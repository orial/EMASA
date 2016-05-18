/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import emasa.entidades.Datos;
import emasa.entidades.Empleado;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Lupi
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String usuario;
    private String clave;
    private String cargoUsuario;
    private boolean logeado = false;
    private Empleado usr;
    @Inject
    private Datos employee;
    private List<Empleado> empleados;

    public LoginBean() {
    }
    @PostConstruct
    public void init(){
        empleados = employee.getEmpleados();
    }

    public Empleado getUsr() {
        return usr;
    }

    public void setUsr(Empleado usr) {
        this.usr = usr;
    }

    public boolean estaLogeado() {
        return logeado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCargoUsuario() {
        return cargoUsuario;
    }

    public void setCargoUsuario(String cargoUsuario) {
        this.cargoUsuario = cargoUsuario;
    }
    
    public void login(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        
        if(usuario != null && clave != null){
            for(Empleado e : empleados){
                if(usuario.equals(e.getEMail()) && clave.equals(e.getPassword())){
                    logeado = true;
                    cargoUsuario = e.getCargo();
                    usr = e;
                    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", usuario);
                }
            }
            if(!logeado){
                logeado = false;
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error","Credenciales no válidas");
            }
        }
        else {
            logeado = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error","Credenciales no válidas");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("estaLogeado", logeado);
        if (logeado && cargoUsuario.equals("SAT")) {
            QuienEntra.sat();
            context.addCallbackParam("view", "crearAvisosClient.xhtml");
        }
        else if (logeado && cargoUsuario.equals("OPmov")){
            context.addCallbackParam("view", "bandejaVisitasClient.xhtml");
        }
        else if (logeado && cargoUsuario.equals("Supervisor")){
            context.addCallbackParam("view", "bandejaAvisosClient.xhtml");
        }
    }

    public void logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        logeado = false;
    }

}
