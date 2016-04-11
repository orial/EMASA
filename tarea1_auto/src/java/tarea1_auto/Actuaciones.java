/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package tarea1_auto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Lupi
 */
@Entity
@Table(name = "ACTUACIONES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actuaciones.findAll", query = "SELECT a FROM Actuaciones a"),
    @NamedQuery(name = "Actuaciones.findByFechaActuacion", query = "SELECT a FROM Actuaciones a WHERE a.actuacionesPK.fechaActuacion = :fechaActuacion"),
    @NamedQuery(name = "Actuaciones.findByOperRealizadas", query = "SELECT a FROM Actuaciones a WHERE a.operRealizadas = :operRealizadas"),
    @NamedQuery(name = "Actuaciones.findByObservaciones", query = "SELECT a FROM Actuaciones a WHERE a.observaciones = :observaciones"),
    @NamedQuery(name = "Actuaciones.findByIdOrden", query = "SELECT a FROM Actuaciones a WHERE a.actuacionesPK.idOrden = :idOrden"),
    @NamedQuery(name = "Actuaciones.findByNumBrigada", query = "SELECT a FROM Actuaciones a WHERE a.actuacionesPK.numBrigada = :numBrigada")})
public class Actuaciones implements Serializable {

    private static final long serialVersionUID = 1L;
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
    @JoinColumn(name = "NUM_BRIGADA", referencedColumnName = "NUM_BRIGADA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Brigada brigada;
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

    public Actuaciones(Date fechaActuacion, BigInteger idOrden, BigInteger numBrigada) {
        this.actuacionesPK = new ActuacionesPK(fechaActuacion, idOrden, numBrigada);
    }

    public ActuacionesPK getActuacionesPK() {
        return actuacionesPK;
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

    public Brigada getBrigada() {
        return brigada;
    }

    public void setBrigada(Brigada brigada) {
        this.brigada = brigada;
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
        return "pruebaJPA.Actuaciones[ actuacionesPK=" + actuacionesPK + " ]";
    }
    
}
