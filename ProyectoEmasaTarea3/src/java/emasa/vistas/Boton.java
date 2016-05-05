/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.vistas;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author malex
 */


@Named(value = "boton")
@SessionScoped
public class Boton implements Serializable {

    /**
     * Creates a new instance of Boton
     */
    public Boton() {
    }

    

    public String ot() {

        return "ordenTrabajo.xhtml";
    }

    public String asignarVisita() {

        return "asignarVisita.xhtml";
    }

    public String reasignarAviso() {

        return "reasignarAviso.xhtml";
    }

    public String avisosRelacionados() {

        return "asignarRelacion.xhtml";
    }

    public String opcionesAvisos() {

        return "aviso.xhtml";
    }
    
    public String volverBandeja()
    {
        return "bandejaAvisos.xhtml";
    }

  
    
}
