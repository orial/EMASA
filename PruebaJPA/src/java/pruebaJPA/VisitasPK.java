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
public class VisitasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_VISITA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVisita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPLEADO_ID_EMPLEADO")
    private BigInteger empleadoIdEmpleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AVISO_CODIGO")
    private BigInteger avisoCodigo;

    public VisitasPK() {
    }

    public VisitasPK(Date fechaVisita, BigInteger empleadoIdEmpleado, BigInteger avisoCodigo) {
        this.fechaVisita = fechaVisita;
        this.empleadoIdEmpleado = empleadoIdEmpleado;
        this.avisoCodigo = avisoCodigo;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public BigInteger getEmpleadoIdEmpleado() {
        return empleadoIdEmpleado;
    }

    public void setEmpleadoIdEmpleado(BigInteger empleadoIdEmpleado) {
        this.empleadoIdEmpleado = empleadoIdEmpleado;
    }

    public BigInteger getAvisoCodigo() {
        return avisoCodigo;
    }

    public void setAvisoCodigo(BigInteger avisoCodigo) {
        this.avisoCodigo = avisoCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fechaVisita != null ? fechaVisita.hashCode() : 0);
        hash += (empleadoIdEmpleado != null ? empleadoIdEmpleado.hashCode() : 0);
        hash += (avisoCodigo != null ? avisoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitasPK)) {
            return false;
        }
        VisitasPK other = (VisitasPK) object;
        if ((this.fechaVisita == null && other.fechaVisita != null) || (this.fechaVisita != null && !this.fechaVisita.equals(other.fechaVisita))) {
            return false;
        }
        if ((this.empleadoIdEmpleado == null && other.empleadoIdEmpleado != null) || (this.empleadoIdEmpleado != null && !this.empleadoIdEmpleado.equals(other.empleadoIdEmpleado))) {
            return false;
        }
        if ((this.avisoCodigo == null && other.avisoCodigo != null) || (this.avisoCodigo != null && !this.avisoCodigo.equals(other.avisoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.VisitasPK[ fechaVisita=" + fechaVisita + ", empleadoIdEmpleado=" + empleadoIdEmpleado + ", avisoCodigo=" + avisoCodigo + " ]";
    }
    
}
