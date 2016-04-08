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
public class VisitasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_VISITA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVisita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_OPERARIO")
    private BigInteger idOperario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AVISO_CODIGO")
    private BigInteger avisoCodigo;

    public VisitasPK() {
    }

    public VisitasPK(Date fechaVisita, BigInteger idOperario, BigInteger avisoCodigo) {
        this.fechaVisita = fechaVisita;
        this.idOperario = idOperario;
        this.avisoCodigo = avisoCodigo;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public BigInteger getIdOperario() {
        return idOperario;
    }

    public void setIdOperario(BigInteger idOperario) {
        this.idOperario = idOperario;
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
        hash += (idOperario != null ? idOperario.hashCode() : 0);
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
        if ((this.idOperario == null && other.idOperario != null) || (this.idOperario != null && !this.idOperario.equals(other.idOperario))) {
            return false;
        }
        if ((this.avisoCodigo == null && other.avisoCodigo != null) || (this.avisoCodigo != null && !this.avisoCodigo.equals(other.avisoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.VisitasPK[ fechaVisita=" + fechaVisita + ", idOperario=" + idOperario + ", avisoCodigo=" + avisoCodigo + " ]";
    }
    
}
