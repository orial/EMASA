/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaJPA;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lupi
 */
@Entity
@Table(name = "CANTIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cantidad.findAll", query = "SELECT c FROM Cantidad c"),
    @NamedQuery(name = "Cantidad.findByCantidad", query = "SELECT c FROM Cantidad c WHERE c.cantidadPK.cantidad = :cantidad"),
    @NamedQuery(name = "Cantidad.findByRepuestoCodigo", query = "SELECT c FROM Cantidad c WHERE c.cantidadPK.repuestoCodigo = :repuestoCodigo"),
    @NamedQuery(name = "Cantidad.findByActFecha", query = "SELECT c FROM Cantidad c WHERE c.cantidadPK.actFecha = :actFecha"),
    @NamedQuery(name = "Cantidad.findByActOrdTrabajoIdentificador", query = "SELECT c FROM Cantidad c WHERE c.cantidadPK.actOrdTrabajoIdentificador = :actOrdTrabajoIdentificador"),
    @NamedQuery(name = "Cantidad.findByActBrigadaNumBrigada", query = "SELECT c FROM Cantidad c WHERE c.cantidadPK.actBrigadaNumBrigada = :actBrigadaNumBrigada")})
public class Cantidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CantidadPK cantidadPK;
    @JoinColumns({
        @JoinColumn(name = "ACT_FECHA", referencedColumnName = "FECHA", insertable = false, updatable = false),
        @JoinColumn(name = "ACT_ORD_TRABAJO_IDENTIFICADOR", referencedColumnName = "ORD_TRABAJO_IDENTIFICADOR", insertable = false, updatable = false),
        @JoinColumn(name = "ACT_BRIGADA_NUM_BRIGADA", referencedColumnName = "BRIGADA_NUM_BRIGADA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Actuaciones actuaciones;
    @JoinColumn(name = "REPUESTO_CODIGO", referencedColumnName = "CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Repuesto repuesto;

    public Cantidad() {
    }

    public Cantidad(CantidadPK cantidadPK) {
        this.cantidadPK = cantidadPK;
    }

    public Cantidad(BigInteger cantidad, BigInteger repuestoCodigo, Date actFecha, BigInteger actOrdTrabajoIdentificador, BigInteger actBrigadaNumBrigada) {
        this.cantidadPK = new CantidadPK(cantidad, repuestoCodigo, actFecha, actOrdTrabajoIdentificador, actBrigadaNumBrigada);
    }

    public CantidadPK getCantidadPK() {
        return cantidadPK;
    }

    public void setCantidadPK(CantidadPK cantidadPK) {
        this.cantidadPK = cantidadPK;
    }

    public Actuaciones getActuaciones() {
        return actuaciones;
    }

    public void setActuaciones(Actuaciones actuaciones) {
        this.actuaciones = actuaciones;
    }

    public Repuesto getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(Repuesto repuesto) {
        this.repuesto = repuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cantidadPK != null ? cantidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cantidad)) {
            return false;
        }
        Cantidad other = (Cantidad) object;
        if ((this.cantidadPK == null && other.cantidadPK != null) || (this.cantidadPK != null && !this.cantidadPK.equals(other.cantidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.Cantidad[ cantidadPK=" + cantidadPK + " ]";
    }
    
}
