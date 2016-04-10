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
public class VisitasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_VISITA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVisita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EMPLEADO")
    private BigInteger idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AVISO")
    private BigInteger idAviso;

    public VisitasPK() {
    }

    public VisitasPK(Date fechaVisita, BigInteger idEmpleado, BigInteger idAviso) {
        this.fechaVisita = fechaVisita;
        this.idEmpleado = idEmpleado;
        this.idAviso = idAviso;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public BigInteger getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(BigInteger idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public BigInteger getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(BigInteger idAviso) {
        this.idAviso = idAviso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fechaVisita != null ? fechaVisita.hashCode() : 0);
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        hash += (idAviso != null ? idAviso.hashCode() : 0);
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
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        if ((this.idAviso == null && other.idAviso != null) || (this.idAviso != null && !this.idAviso.equals(other.idAviso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.VisitasPK[ fechaVisita=" + fechaVisita + ", idEmpleado=" + idEmpleado + ", idAviso=" + idAviso + " ]";
    }
    
}
