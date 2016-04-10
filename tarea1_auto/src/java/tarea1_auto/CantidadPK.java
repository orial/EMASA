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
public class CantidadPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REPUESTO")
    private BigInteger idRepuesto;
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

    public CantidadPK() {
    }

    public CantidadPK(BigInteger cantidad, BigInteger idRepuesto, Date fechaActuacion, BigInteger idOrden, BigInteger numBrigada) {
        this.cantidad = cantidad;
        this.idRepuesto = idRepuesto;
        this.fechaActuacion = fechaActuacion;
        this.idOrden = idOrden;
        this.numBrigada = numBrigada;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(BigInteger idRepuesto) {
        this.idRepuesto = idRepuesto;
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
        hash += (cantidad != null ? cantidad.hashCode() : 0);
        hash += (idRepuesto != null ? idRepuesto.hashCode() : 0);
        hash += (fechaActuacion != null ? fechaActuacion.hashCode() : 0);
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        hash += (numBrigada != null ? numBrigada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CantidadPK)) {
            return false;
        }
        CantidadPK other = (CantidadPK) object;
        if ((this.cantidad == null && other.cantidad != null) || (this.cantidad != null && !this.cantidad.equals(other.cantidad))) {
            return false;
        }
        if ((this.idRepuesto == null && other.idRepuesto != null) || (this.idRepuesto != null && !this.idRepuesto.equals(other.idRepuesto))) {
            return false;
        }
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
        return "pruebaJPA.CantidadPK[ cantidad=" + cantidad + ", idRepuesto=" + idRepuesto + ", fechaActuacion=" + fechaActuacion + ", idOrden=" + idOrden + ", numBrigada=" + numBrigada + " ]";
    }
    
}
