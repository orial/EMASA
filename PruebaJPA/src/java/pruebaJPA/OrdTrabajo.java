/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaJPA;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
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
    @NamedQuery(name = "OrdTrabajo.findByIdentificador", query = "SELECT o FROM OrdTrabajo o WHERE o.identificador = :identificador"),
    @NamedQuery(name = "OrdTrabajo.findByFechaCreacion", query = "SELECT o FROM OrdTrabajo o WHERE o.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "OrdTrabajo.findByTrabajoARealizar", query = "SELECT o FROM OrdTrabajo o WHERE o.trabajoARealizar = :trabajoARealizar"),
    @NamedQuery(name = "OrdTrabajo.findByFechaFinalizacion", query = "SELECT o FROM OrdTrabajo o WHERE o.fechaFinalizacion = :fechaFinalizacion"),
    @NamedQuery(name = "OrdTrabajo.findByEstado", query = "SELECT o FROM OrdTrabajo o WHERE o.estado = :estado")})
public class OrdTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDENTIFICADOR")
    private BigDecimal identificador;
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
    @Column(name = "FECHA_FINALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinalizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordTrabajo")
    private Collection<Actuaciones> actuacionesCollection;
    @JoinColumn(name = "AVISO_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Aviso avisoCodigo;
    @JoinColumn(name = "SUPERVISOR_ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @ManyToOne(optional = false)
    private Supervisor supervisorIdEmpleado;

    public OrdTrabajo() {
    }

    public OrdTrabajo(BigDecimal identificador) {
        this.identificador = identificador;
    }

    public OrdTrabajo(BigDecimal identificador, Date fechaCreacion, String trabajoARealizar, String estado) {
        this.identificador = identificador;
        this.fechaCreacion = fechaCreacion;
        this.trabajoARealizar = trabajoARealizar;
        this.estado = estado;
    }

    public BigDecimal getIdentificador() {
        return identificador;
    }

    public void setIdentificador(BigDecimal identificador) {
        this.identificador = identificador;
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

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Actuaciones> getActuacionesCollection() {
        return actuacionesCollection;
    }

    public void setActuacionesCollection(Collection<Actuaciones> actuacionesCollection) {
        this.actuacionesCollection = actuacionesCollection;
    }

    public Aviso getAvisoCodigo() {
        return avisoCodigo;
    }

    public void setAvisoCodigo(Aviso avisoCodigo) {
        this.avisoCodigo = avisoCodigo;
    }

    public Supervisor getSupervisorIdEmpleado() {
        return supervisorIdEmpleado;
    }

    public void setSupervisorIdEmpleado(Supervisor supervisorIdEmpleado) {
        this.supervisorIdEmpleado = supervisorIdEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificador != null ? identificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdTrabajo)) {
            return false;
        }
        OrdTrabajo other = (OrdTrabajo) object;
        if ((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.OrdTrabajo[ identificador=" + identificador + " ]";
    }
    
}
