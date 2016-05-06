/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author malex
 */
@Named(value = "calendarioVista")
@SessionScoped
public class CalendarioVista implements Serializable {

    /**
     * Creates a new instance of calendarioVista
     */
    private Date date1;

    public Date getFecha_actual() {
        return fecha_actual;
    }

    public void setFecha_actual(Date fecha_actual) {
        this.fecha_actual = fecha_actual;
    }
    private Date fecha_actual;

    public CalendarioVista() {

    }

    @PostConstruct

    public void init() {
        fecha_actual = new Date();
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();

        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }

}
