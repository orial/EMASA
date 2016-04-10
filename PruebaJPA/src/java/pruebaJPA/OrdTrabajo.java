/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaJPA;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Lupi
 */
@Entity
@Table(name = "ORD_TRABAJO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdTrabajo.findAll", query = "SELECT o FROM OrdTrabajo o"),
    @NamedQuery(name = "OrdTrabajo.findByIdOrden", query = "SELECT o FROM OrdTrabajo o WHERE o.idOrden = :idOrden"),
    @NamedQuery(name = "OrdTrabajo.findByFechaCreacion", query = "SELECT o FROM OrdTrabajo o WHERE o.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "OrdTrabajo.findByTrabajoARealizar", query = "SELECT o FROM OrdTrabajo o WHERE o.trabajoARealizar = :trabajoARealizar"),
    @NamedQuery(name = "OrdTrabajo.findByEstado", query = "SELECT o FROM OrdTrabajo o WHERE o.estado = :estado"),
    @NamedQuery(name = "OrdTrabajo.findByFechaFinalizacion", query = "SELECT o FROM OrdTrabajo o WHERE o.fechaFinalizacion = :fechaFinalizacion")})
public class OrdTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ORDEN")
    private BigDecimal idOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "TRABAJO_A_REALIZAR")
    private String trabajoARealizar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "FECHA_FINALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinalizacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordTrabajo")
    private Collection<Actuaciones> actuacionesCollection;
    @JoinColumn(name = "ID_AVISO", referencedColumnName = "ID_AVISO")
    @ManyToOne(optional = false)
    private Aviso idAviso;

    public OrdTrabajo() {
    }

    public OrdTrabajo(BigDecimal idOrden) {
        this.idOrden = idOrden;
    }

    public OrdTrabajo(BigDecimal idOrden, Date fechaCreacion, String trabajoARealizar, String estado) {
        this.idOrden = idOrden;
        this.fechaCreacion = fechaCreacion;
        this.trabajoARealizar = trabajoARealizar;
        this.estado = estado;
    }

    public BigDecimal getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(BigDecimal idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTrabajoARealizar() {
        return trabajoARealizar;
    }

    public void setTrabajoARealizar(String trabajoARealizar) {
        this.trabajoARealizar = trabajoARealizar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    @XmlTransient
    public Collection<Actuaciones> getActuacionesCollection() {
        return actuacionesCollection;
    }

    public void setActuacionesCollection(Collection<Actuaciones> actuacionesCollection) {
        this.actuacionesCollection = actuacionesCollection;
    }

    public Aviso getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(Aviso idAviso) {
        this.idAviso = idAviso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdTrabajo)) {
            return false;
        }
        OrdTrabajo other = (OrdTrabajo) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.OrdTrabajo[ idOrden=" + idOrden + " ]";
    }
    
}
