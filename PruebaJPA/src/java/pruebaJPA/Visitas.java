/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaJPA;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lupi
 */
@Entity
@Table(name = "VISITAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visitas.findAll", query = "SELECT v FROM Visitas v"),
    @NamedQuery(name = "Visitas.findByFechaVisita", query = "SELECT v FROM Visitas v WHERE v.visitasPK.fechaVisita = :fechaVisita"),
    @NamedQuery(name = "Visitas.findByIdOperario", query = "SELECT v FROM Visitas v WHERE v.visitasPK.idOperario = :idOperario"),
    @NamedQuery(name = "Visitas.findByAvisoCodigo", query = "SELECT v FROM Visitas v WHERE v.visitasPK.avisoCodigo = :avisoCodigo")})
public class Visitas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VisitasPK visitasPK;
    @JoinColumn(name = "AVISO_CODIGO", referencedColumnName = "CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aviso aviso;
    @JoinColumn(name = "SUPERVISOR_ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @ManyToOne(optional = false)
    private Supervisor supervisorIdEmpleado;

    public Visitas() {
    }

    public Visitas(VisitasPK visitasPK) {
        this.visitasPK = visitasPK;
    }

    public Visitas(Date fechaVisita, BigInteger idOperario, BigInteger avisoCodigo) {
        this.visitasPK = new VisitasPK(fechaVisita, idOperario, avisoCodigo);
    }

    public VisitasPK getVisitasPK() {
        return visitasPK;
    }

    public void setVisitasPK(VisitasPK visitasPK) {
        this.visitasPK = visitasPK;
    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    public Supervisor getSupervisorIdEmpleado() {
        return supervisorIdEmpleado;
    }

    public void setSupervisorIdEmpleado(Supervisor supervisorIdEmpleado) {
        this.supervisorIdEmpleado = supervisorIdEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (visitasPK != null ? visitasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitas)) {
            return false;
        }
        Visitas other = (Visitas) object;
        if ((this.visitasPK == null && other.visitasPK != null) || (this.visitasPK != null && !this.visitasPK.equals(other.visitasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.Visitas[ visitasPK=" + visitasPK + " ]";
    }
    
}
