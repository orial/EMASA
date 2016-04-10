/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1_auto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Lupi
 */
@Embeddable
public class HistoricoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AVISO")
    private BigInteger idAviso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EMPLEADO")
    private BigInteger idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUPERVISOR")
    private BigInteger supervisor;

    public HistoricoPK() {
    }

    public HistoricoPK(BigInteger idAviso, Date fechaActualizacion, BigInteger idEmpleado, BigInteger supervisor) {
        this.idAviso = idAviso;
        this.fechaActualizacion = fechaActualizacion;
        this.idEmpleado = idEmpleado;
        this.supervisor = supervisor;
    }

    public BigInteger getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(BigInteger idAviso) {
        this.idAviso = idAviso;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public BigInteger getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(BigInteger idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public BigInteger getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(BigInteger supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAviso != null ? idAviso.hashCode() : 0);
        hash += (fechaActualizacion != null ? fechaActualizacion.hashCode() : 0);
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        hash += (supervisor != null ? supervisor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoPK)) {
            return false;
        }
        HistoricoPK other = (HistoricoPK) object;
        if ((this.idAviso == null && other.idAviso != null) || (this.idAviso != null && !this.idAviso.equals(other.idAviso))) {
            return false;
        }
        if ((this.fechaActualizacion == null && other.fechaActualizacion != null) || (this.fechaActualizacion != null && !this.fechaActualizacion.equals(other.fechaActualizacion))) {
            return false;
        }
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        if ((this.supervisor == null && other.supervisor != null) || (this.supervisor != null && !this.supervisor.equals(other.supervisor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.HistoricoPK[ idAviso=" + idAviso + ", fechaActualizacion=" + fechaActualizacion + ", idEmpleado=" + idEmpleado + ", supervisor=" + supervisor + " ]";
    }
    
}
