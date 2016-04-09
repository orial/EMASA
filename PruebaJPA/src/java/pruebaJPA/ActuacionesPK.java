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
public class ActuacionesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORD_TRABAJO_IDENTIFICADOR")
    private BigInteger ordTrabajoIdentificador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BRIGADA_NUM_BRIGADA")
    private BigInteger brigadaNumBrigada;

    public ActuacionesPK() {
    }

    public ActuacionesPK(Date fecha, BigInteger ordTrabajoIdentificador, BigInteger brigadaNumBrigada) {
        this.fecha = fecha;
        this.ordTrabajoIdentificador = ordTrabajoIdentificador;
        this.brigadaNumBrigada = brigadaNumBrigada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getOrdTrabajoIdentificador() {
        return ordTrabajoIdentificador;
    }

    public void setOrdTrabajoIdentificador(BigInteger ordTrabajoIdentificador) {
        this.ordTrabajoIdentificador = ordTrabajoIdentificador;
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
        hash += (ordTrabajoIdentificador != null ? ordTrabajoIdentificador.hashCode() : 0);
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
        if ((this.ordTrabajoIdentificador == null && other.ordTrabajoIdentificador != null) || (this.ordTrabajoIdentificador != null && !this.ordTrabajoIdentificador.equals(other.ordTrabajoIdentificador))) {
            return false;
        }
        if ((this.brigadaNumBrigada == null && other.brigadaNumBrigada != null) || (this.brigadaNumBrigada != null && !this.brigadaNumBrigada.equals(other.brigadaNumBrigada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.ActuacionesPK[ fecha=" + fecha + ", ordTrabajoIdentificador=" + ordTrabajoIdentificador + ", brigadaNumBrigada=" + brigadaNumBrigada + " ]";
    }
    
}
