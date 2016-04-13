/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "OrdTrabajo.findByNumBrigada", query = "SELECT o FROM OrdTrabajo o WHERE o.numBrigada = :numBrigada"),
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
    @Column(name = "NUM_BRIGADA")
    private BigInteger numBrigada;
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
    @JoinColumns({
        @JoinColumn(name = "ID_AVISO", referencedColumnName = "ID_AVISO"),
        @JoinColumn(name = "FECHA_ACTUALIZACION", referencedColumnName = "FECHA_ACTUALIZACION"),
        @JoinColumn(name = "SUPERVISOR", referencedColumnName = "SUPERVISOR")})
    @ManyToOne(optional = false)
    private Historico historico;

    public OrdTrabajo() {
    }

    public OrdTrabajo(BigDecimal idOrden) {
        this.idOrden = idOrden;
    }

    public OrdTrabajo(BigDecimal idOrden, Date fechaCreacion, String trabajoARealizar, BigInteger numBrigada, String estado) {
        this.idOrden = idOrden;
        this.fechaCreacion = fechaCreacion;
        this.trabajoARealizar = trabajoARealizar;
        this.numBrigada = numBrigada;
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

    public BigInteger getNumBrigada() {
        return numBrigada;
    }

    public void setNumBrigada(BigInteger numBrigada) {
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
        return actuacionesCollection;
    }

    public void setActuacionesCollection(Collection<Actuaciones> actuacionesCollection) {
        this.actuacionesCollection = actuacionesCollection;
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
        return "emasa.OrdTrabajo[ idOrden=" + idOrden + " ]";
    }
    
}
