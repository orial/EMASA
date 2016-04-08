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
import javax.validation.constraints.NotNull;

/**
 *
 * @author Lupi
 */
@Embeddable
public class ActuacionesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORD_TRAB_ID")
    private BigInteger ordTrabId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BRIGADA_NUM_BRIGADA")
    private BigInteger brigadaNumBrigada;

    public ActuacionesPK() {
    }

    public ActuacionesPK(Date fecha, BigInteger ordTrabId, BigInteger brigadaNumBrigada) {
        this.fecha = fecha;
        this.ordTrabId = ordTrabId;
        this.brigadaNumBrigada = brigadaNumBrigada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getOrdTrabId() {
        return ordTrabId;
    }

    public void setOrdTrabId(BigInteger ordTrabId) {
        this.ordTrabId = ordTrabId;
    }

    public BigInteger getBrigadaNumBrigada() {
        return brigadaNumBrigada;
    }

    public void setBrigadaNumBrigada(BigInteger brigadaNumBrigada) {
        this.brigadaNumBrigada = brigadaNumBrigada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (ordTrabId != null ? ordTrabId.hashCode() : 0);
        hash += (brigadaNumBrigada != null ? brigadaNumBrigada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActuacionesPK)) {
            return false;
        }
        ActuacionesPK other = (ActuacionesPK) object;
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if ((this.ordTrabId == null && other.ordTrabId != null) || (this.ordTrabId != null && !this.ordTrabId.equals(other.ordTrabId))) {
            return false;
        }
        if ((this.brigadaNumBrigada == null && other.brigadaNumBrigada != null) || (this.brigadaNumBrigada != null && !this.brigadaNumBrigada.equals(other.brigadaNumBrigada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.ActuacionesPK[ fecha=" + fecha + ", ordTrabId=" + ordTrabId + ", brigadaNumBrigada=" + brigadaNumBrigada + " ]";
    }
    
}
