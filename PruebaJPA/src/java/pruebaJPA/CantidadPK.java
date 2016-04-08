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
public class CantidadPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REPUESTO_CODIGO")
    private BigInteger repuestoCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACT_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACT_ORD_TRAB_ID")
    private BigInteger actOrdTrabId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACT_BRIGADA_NUM_BRIGADA")
    private BigInteger actBrigadaNumBrigada;

    public CantidadPK() {
    }

    public CantidadPK(BigInteger cantidad, BigInteger repuestoCodigo, Date actFecha, BigInteger actOrdTrabId, BigInteger actBrigadaNumBrigada) {
        this.cantidad = cantidad;
        this.repuestoCodigo = repuestoCodigo;
        this.actFecha = actFecha;
        this.actOrdTrabId = actOrdTrabId;
        this.actBrigadaNumBrigada = actBrigadaNumBrigada;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getRepuestoCodigo() {
        return repuestoCodigo;
    }

    public void setRepuestoCodigo(BigInteger repuestoCodigo) {
        this.repuestoCodigo = repuestoCodigo;
    }

    public Date getActFecha() {
        return actFecha;
    }

    public void setActFecha(Date actFecha) {
        this.actFecha = actFecha;
    }

    public BigInteger getActOrdTrabId() {
        return actOrdTrabId;
    }

    public void setActOrdTrabId(BigInteger actOrdTrabId) {
        this.actOrdTrabId = actOrdTrabId;
    }

    public BigInteger getActBrigadaNumBrigada() {
        return actBrigadaNumBrigada;
    }

    public void setActBrigadaNumBrigada(BigInteger actBrigadaNumBrigada) {
        this.actBrigadaNumBrigada = actBrigadaNumBrigada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cantidad != null ? cantidad.hashCode() : 0);
        hash += (repuestoCodigo != null ? repuestoCodigo.hashCode() : 0);
        hash += (actFecha != null ? actFecha.hashCode() : 0);
        hash += (actOrdTrabId != null ? actOrdTrabId.hashCode() : 0);
        hash += (actBrigadaNumBrigada != null ? actBrigadaNumBrigada.hashCode() : 0);
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
        if ((this.repuestoCodigo == null && other.repuestoCodigo != null) || (this.repuestoCodigo != null && !this.repuestoCodigo.equals(other.repuestoCodigo))) {
            return false;
        }
        if ((this.actFecha == null && other.actFecha != null) || (this.actFecha != null && !this.actFecha.equals(other.actFecha))) {
            return false;
        }
        if ((this.actOrdTrabId == null && other.actOrdTrabId != null) || (this.actOrdTrabId != null && !this.actOrdTrabId.equals(other.actOrdTrabId))) {
            return false;
        }
        if ((this.actBrigadaNumBrigada == null && other.actBrigadaNumBrigada != null) || (this.actBrigadaNumBrigada != null && !this.actBrigadaNumBrigada.equals(other.actBrigadaNumBrigada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.CantidadPK[ cantidad=" + cantidad + ", repuestoCodigo=" + repuestoCodigo + ", actFecha=" + actFecha + ", actOrdTrabId=" + actOrdTrabId + ", actBrigadaNumBrigada=" + actBrigadaNumBrigada + " ]";
    }
    
}
