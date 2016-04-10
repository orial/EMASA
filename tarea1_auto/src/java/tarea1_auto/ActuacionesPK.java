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
public class ActuacionesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ACTUACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActuacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ORDEN")
    private BigInteger idOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_BRIGADA")
    private BigInteger numBrigada;

    public ActuacionesPK() {
    }

    public ActuacionesPK(Date fechaActuacion, BigInteger idOrden, BigInteger numBrigada) {
        this.fechaActuacion = fechaActuacion;
        this.idOrden = idOrden;
        this.numBrigada = numBrigada;
    }

    public Date getFechaActuacion() {
        return fechaActuacion;
    }

    public void setFechaActuacion(Date fechaActuacion) {
        this.fechaActuacion = fechaActuacion;
    }

    public BigInteger getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(BigInteger idOrden) {
        this.idOrden = idOrden;
    }

    public BigInteger getNumBrigada() {
        return numBrigada;
    }

    public void setNumBrigada(BigInteger numBrigada) {
        this.numBrigada = numBrigada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fechaActuacion != null ? fechaActuacion.hashCode() : 0);
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        hash += (numBrigada != null ? numBrigada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActuacionesPK)) {
            return false;
        }
        ActuacionesPK other = (ActuacionesPK) object;
        if ((this.fechaActuacion == null && other.fechaActuacion != null) || (this.fechaActuacion != null && !this.fechaActuacion.equals(other.fechaActuacion))) {
            return false;
        }
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        if ((this.numBrigada == null && other.numBrigada != null) || (this.numBrigada != null && !this.numBrigada.equals(other.numBrigada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.ActuacionesPK[ fechaActuacion=" + fechaActuacion + ", idOrden=" + idOrden + ", numBrigada=" + numBrigada + " ]";
    }
    
}
