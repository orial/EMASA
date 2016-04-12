/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author malex
 */
@Entity
@Table(name = "ACTUACIONES")

public class Actuaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EmbeddedId
    protected ActuacionesPK actuacionesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "OPER_REALIZADAS")
    private String operRealizadas;
    @Size(max = 200)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @JoinColumn(name = "ID_ORDEN", referencedColumnName = "ID_ORDEN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OrdTrabajo ordTrabajo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actuaciones")
    private Collection<Reparacion> reparacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actuaciones")
    private Collection<Cantidad> cantidadCollection;
    
    public Actuaciones() {
    }

    public Actuaciones(ActuacionesPK actuacionesPK) {
        this.actuacionesPK = actuacionesPK;
    }

    public Actuaciones(ActuacionesPK actuacionesPK, String operRealizadas) {
        this.actuacionesPK = actuacionesPK;
        this.operRealizadas = operRealizadas;
    }

    public Actuaciones(Date fechaActuacion, BigInteger idOrden) {
        this.actuacionesPK = new ActuacionesPK(fechaActuacion, idOrden);
    }
    public void setActuacionesPK(ActuacionesPK actuacionesPK) {
        this.actuacionesPK = actuacionesPK;
    }

    public String getOperRealizadas() {
        return operRealizadas;
    }

    public void setOperRealizadas(String operRealizadas) {
        this.operRealizadas = operRealizadas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public OrdTrabajo getOrdTrabajo() {
        return ordTrabajo;
    }

    public void setOrdTrabajo(OrdTrabajo ordTrabajo) {
        this.ordTrabajo = ordTrabajo;
    }

    @XmlTransient
    public Collection<Reparacion> getReparacionCollection() {
        return reparacionCollection;
    }

    public void setReparacionCollection(Collection<Reparacion> reparacionCollection) {
        this.reparacionCollection = reparacionCollection;
    }

    @XmlTransient
    public Collection<Cantidad> getCantidadCollection() {
        return cantidadCollection;
    }

    public void setCantidadCollection(Collection<Cantidad> cantidadCollection) {
        this.cantidadCollection = cantidadCollection;
    }


   
    @Override
     
    public int hashCode() {
        int hash = 0;
        hash += (actuacionesPK != null ? actuacionesPK.hashCode() : 0);
        return hash;
    }

     @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actuaciones)) {
            return false;
        }
        Actuaciones other = (Actuaciones) object;
        if ((this.actuacionesPK == null && other.actuacionesPK != null) || (this.actuacionesPK != null && !this.actuacionesPK.equals(other.actuacionesPK))) {
            return false;
        }
        return true;
    }
    
     @Override
    public String toString() {
        return "tarea1_auto.Actuaciones[ actuacionesPK=" + actuacionesPK + " ]";
    }
    
}
