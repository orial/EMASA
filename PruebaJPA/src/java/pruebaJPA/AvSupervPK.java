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
public class AvSupervPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AVISO_CODIGO")
    private BigInteger avisoCodigo;

    public AvSupervPK() {
    }

    public AvSupervPK(Date fecha, BigInteger avisoCodigo) {
        this.fecha = fecha;
        this.avisoCodigo = avisoCodigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        hash += (fecha != null ? fecha.hashCode() : 0);
        hash += (avisoCodigo != null ? avisoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvSupervPK)) {
            return false;
        }
        AvSupervPK other = (AvSupervPK) object;
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        if ((this.avisoCodigo == null && other.avisoCodigo != null) || (this.avisoCodigo != null && !this.avisoCodigo.equals(other.avisoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.AvSupervPK[ fecha=" + fecha + ", avisoCodigo=" + avisoCodigo + " ]";
    }
    
}
