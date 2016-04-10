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
    @NamedQuery(name = "Cantidad.findByIdRepuesto", query = "SELECT c FROM Cantidad c WHERE c.cantidadPK.idRepuesto = :idRepuesto"),
    @NamedQuery(name = "Cantidad.findByFechaActuacion", query = "SELECT c FROM Cantidad c WHERE c.cantidadPK.fechaActuacion = :fechaActuacion"),
    @NamedQuery(name = "Cantidad.findByIdOrden", query = "SELECT c FROM Cantidad c WHERE c.cantidadPK.idOrden = :idOrden"),
    @NamedQuery(name = "Cantidad.findByNumBrigada", query = "SELECT c FROM Cantidad c WHERE c.cantidadPK.numBrigada = :numBrigada")})
public class Cantidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CantidadPK cantidadPK;
    @JoinColumns({
        @JoinColumn(name = "FECHA_ACTUACION", referencedColumnName = "FECHA_ACTUACION", insertable = false, updatable = false),
        @JoinColumn(name = "ID_ORDEN", referencedColumnName = "ID_ORDEN", insertable = false, updatable = false),
        @JoinColumn(name = "NUM_BRIGADA", referencedColumnName = "NUM_BRIGADA", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Actuaciones actuaciones;
    @JoinColumn(name = "ID_REPUESTO", referencedColumnName = "ID_REPUESTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Repuesto repuesto;

    public Cantidad() {
    }

    public Cantidad(CantidadPK cantidadPK) {
        this.cantidadPK = cantidadPK;
    }

    public Cantidad(BigInteger cantidad, BigInteger idRepuesto, Date fechaActuacion, BigInteger idOrden, BigInteger numBrigada) {
        this.cantidadPK = new CantidadPK(cantidad, idRepuesto, fechaActuacion, idOrden, numBrigada);
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
