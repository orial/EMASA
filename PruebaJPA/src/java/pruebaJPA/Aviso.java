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
@Table(name = "AVISO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aviso.findAll", query = "SELECT a FROM Aviso a"),
    @NamedQuery(name = "Aviso.findByIdAviso", query = "SELECT a FROM Aviso a WHERE a.idAviso = :idAviso"),
    @NamedQuery(name = "Aviso.findByFechaEntrada", query = "SELECT a FROM Aviso a WHERE a.fechaEntrada = :fechaEntrada"),
    @NamedQuery(name = "Aviso.findByOrigen", query = "SELECT a FROM Aviso a WHERE a.origen = :origen")})
public class Aviso implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_AVISO")
    private BigDecimal idAviso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ENTRADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ORIGEN")
    private String origen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aviso")
    private Collection<Historico> historicoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aviso")
    private Collection<Visitas> visitasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAviso")
    private Collection<OrdTrabajo> ordTrabajoCollection;
    @OneToMany(mappedBy = "relacionado")
    private Collection<Aviso> avisoCollection;
    @JoinColumn(name = "RELACIONADO", referencedColumnName = "ID_AVISO")
    @ManyToOne
    private Aviso relacionado;
    @JoinColumn(name = "CLIENTE_DNI", referencedColumnName = "DNI")
    @ManyToOne
    private Cliente clienteDni;
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @ManyToOne
    private Empleado idEmpleado;

    public Aviso() {
    }

    public Aviso(BigDecimal idAviso) {
        this.idAviso = idAviso;
    }

    public Aviso(BigDecimal idAviso, Date fechaEntrada, String origen) {
        this.idAviso = idAviso;
        this.fechaEntrada = fechaEntrada;
        this.origen = origen;
    }

    public BigDecimal getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(BigDecimal idAviso) {
        this.idAviso = idAviso;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @XmlTransient
    public Collection<Historico> getHistoricoCollection() {
        return historicoCollection;
    }

    public void setHistoricoCollection(Collection<Historico> historicoCollection) {
        this.historicoCollection = historicoCollection;
    }

    @XmlTransient
    public Collection<Visitas> getVisitasCollection() {
        return visitasCollection;
    }

    public void setVisitasCollection(Collection<Visitas> visitasCollection) {
        this.visitasCollection = visitasCollection;
    }

    @XmlTransient
    public Collection<OrdTrabajo> getOrdTrabajoCollection() {
        return ordTrabajoCollection;
    }

    public void setOrdTrabajoCollection(Collection<OrdTrabajo> ordTrabajoCollection) {
        this.ordTrabajoCollection = ordTrabajoCollection;
    }

    @XmlTransient
    public Collection<Aviso> getAvisoCollection() {
        return avisoCollection;
    }

    public void setAvisoCollection(Collection<Aviso> avisoCollection) {
        this.avisoCollection = avisoCollection;
    }

    public Aviso getRelacionado() {
        return relacionado;
    }

    public void setRelacionado(Aviso relacionado) {
        this.relacionado = relacionado;
    }

    public Cliente getClienteDni() {
        return clienteDni;
    }

    public void setClienteDni(Cliente clienteDni) {
        this.clienteDni = clienteDni;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAviso != null ? idAviso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aviso)) {
            return false;
        }
        Aviso other = (Aviso) object;
        if ((this.idAviso == null && other.idAviso != null) || (this.idAviso != null && !this.idAviso.equals(other.idAviso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.Aviso[ idAviso=" + idAviso + " ]";
    }
    
}
