/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lupi
 */
@Entity
@Table(name = "ORD_TRABAJO")
public class OrdTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ORDEN")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idOrden;
    
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
    @Basic(optional = false)
    @Column(name = "TRABAJO_A_REALIZAR")
    private String trabajoARealizar;
    
    @Basic(optional = false)
    @Column(name = "NUM_BRIGADA")
    private Integer numBrigada;
    
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    
    @Column(name = "FECHA_FINALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinalizacion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordTrabajo")
    private Collection<Actuaciones> actuaciones;
    
    @JoinColumns({
        @JoinColumn(name = "ID_AVISO", referencedColumnName = "ID_AVISO"),
        @JoinColumn(name = "FECHA_ACTUALIZACION", referencedColumnName = "FECHA_ACTUALIZACION"),
        @JoinColumn(name = "SUPERVISOR", referencedColumnName = "SUPERVISOR")})
    @ManyToOne(optional = false)
    private Historico historico;

    public OrdTrabajo() {
    }

    public OrdTrabajo(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public OrdTrabajo(Integer idOrden, Date fechaCreacion, String trabajoARealizar, Integer numBrigada, String estado) {
        this.idOrden = idOrden;
        this.fechaCreacion = fechaCreacion;
        this.trabajoARealizar = trabajoARealizar;
        this.numBrigada = numBrigada;
        this.estado = estado;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
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

    public Integer getNumBrigada() {
        return numBrigada;
    }

    public void setNumBrigada(Integer numBrigada) {
        this.numBrigada = numBrigada;
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
        return actuaciones;
    }

    public void setActuacionesCollection(Collection<Actuaciones> actuacionesCollection) {
        this.actuaciones = actuacionesCollection;
    }

    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        this.historico = historico;
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
        return "OrdTrabajo{" + "idOrden=" + idOrden + ", fechaCreacion=" + fechaCreacion + ", trabajoARealizar=" + trabajoARealizar + ", numBrigada=" + numBrigada + ", estado=" + estado + ", fechaFinalizacion=" + fechaFinalizacion + '}';
    }  
}
