/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaJPA;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Lupi
 */
@Embeddable
public class HistoricoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "AVISO_CODIGO")
    private BigInteger avisoCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPLEADO_ID_EMPLEADO")
    private BigInteger empleadoIdEmpleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUPERVISOR")
    private BigInteger supervisor;

    public HistoricoPK() {
    }

    public HistoricoPK(BigInteger avisoCodigo, Date fechaActualizacion, BigInteger empleadoIdEmpleado, BigInteger supervisor) {
        this.avisoCodigo = avisoCodigo;
        this.fechaActualizacion = fechaActualizacion;
        this.empleadoIdEmpleado = empleadoIdEmpleado;
        this.supervisor = supervisor;
    }

    public BigInteger getAvisoCodigo() {
        return avisoCodigo;
    }

    public void setAvisoCodigo(BigInteger avisoCodigo) {
        this.avisoCodigo = avisoCodigo;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public BigInteger getEmpleadoIdEmpleado() {
        return empleadoIdEmpleado;
    }

    public void setEmpleadoIdEmpleado(BigInteger empleadoIdEmpleado) {
        this.empleadoIdEmpleado = empleadoIdEmpleado;
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
        hash += (avisoCodigo != null ? avisoCodigo.hashCode() : 0);
        hash += (fechaActualizacion != null ? fechaActualizacion.hashCode() : 0);
        hash += (empleadoIdEmpleado != null ? empleadoIdEmpleado.hashCode() : 0);
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
        if ((this.avisoCodigo == null && other.avisoCodigo != null) || (this.avisoCodigo != null && !this.avisoCodigo.equals(other.avisoCodigo))) {
            return false;
        }
        if ((this.fechaActualizacion == null && other.fechaActualizacion != null) || (this.fechaActualizacion != null && !this.fechaActualizacion.equals(other.fechaActualizacion))) {
            return false;
        }
        if ((this.empleadoIdEmpleado == null && other.empleadoIdEmpleado != null) || (this.empleadoIdEmpleado != null && !this.empleadoIdEmpleado.equals(other.empleadoIdEmpleado))) {
            return false;
        }
        if ((this.supervisor == null && other.supervisor != null) || (this.supervisor != null && !this.supervisor.equals(other.supervisor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.HistoricoPK[ avisoCodigo=" + avisoCodigo + ", fechaActualizacion=" + fechaActualizacion + ", empleadoIdEmpleado=" + empleadoIdEmpleado + ", supervisor=" + supervisor + " ]";
    }
    
}
