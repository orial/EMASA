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
@Table(name = "AV_SUPERV")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AvSuperv.findAll", query = "SELECT a FROM AvSuperv a"),
    @NamedQuery(name = "AvSuperv.findByFecha", query = "SELECT a FROM AvSuperv a WHERE a.avSupervPK.fecha = :fecha"),
    @NamedQuery(name = "AvSuperv.findByAvisoCodigo", query = "SELECT a FROM AvSuperv a WHERE a.avSupervPK.avisoCodigo = :avisoCodigo")})
public class AvSuperv implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AvSupervPK avSupervPK;
    @JoinColumn(name = "AVISO_CODIGO", referencedColumnName = "CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aviso aviso;
    @JoinColumn(name = "SUPERVISOR_ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @ManyToOne(optional = false)
    private Supervisor supervisorIdEmpleado;

    public AvSuperv() {
    }

    public AvSuperv(AvSupervPK avSupervPK) {
        this.avSupervPK = avSupervPK;
    }

    public AvSuperv(Date fecha, BigInteger avisoCodigo) {
        this.avSupervPK = new AvSupervPK(fecha, avisoCodigo);
    }

    public AvSupervPK getAvSupervPK() {
        return avSupervPK;
    }

    public void setAvSupervPK(AvSupervPK avSupervPK) {
        this.avSupervPK = avSupervPK;
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
        hash += (avSupervPK != null ? avSupervPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvSuperv)) {
            return false;
        }
        AvSuperv other = (AvSuperv) object;
        if ((this.avSupervPK == null && other.avSupervPK != null) || (this.avSupervPK != null && !this.avSupervPK.equals(other.avSupervPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.AvSuperv[ avSupervPK=" + avSupervPK + " ]";
    }
    
}
