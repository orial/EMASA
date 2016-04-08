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
@Table(name = "AVISO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aviso.findAll", query = "SELECT a FROM Aviso a"),
    @NamedQuery(name = "Aviso.findByCodigo", query = "SELECT a FROM Aviso a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Aviso.findByFechaEntrada", query = "SELECT a FROM Aviso a WHERE a.fechaEntrada = :fechaEntrada"),
    @NamedQuery(name = "Aviso.findByMedioEntrada", query = "SELECT a FROM Aviso a WHERE a.medioEntrada = :medioEntrada")})
public class Aviso implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private BigDecimal codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ENTRADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "MEDIO_ENTRADA")
    private String medioEntrada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aviso")
    private Collection<Historico> historicoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aviso")
    private Collection<Visitas> visitasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avisoCodigo")
    private Collection<OrdTrabajo> ordTrabajoCollection;
    @OneToMany(mappedBy = "avisoCodigo")
    private Collection<Aviso> avisoCollection;
    @JoinColumn(name = "AVISO_CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne
    private Aviso avisoCodigo;
    @JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cliente clienteId;
    @JoinColumn(name = "SAT_ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @ManyToOne
    private Sat satIdEmpleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aviso")
    private Collection<AvSuperv> avSupervCollection;

    public Aviso() {
    }

    public Aviso(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public Aviso(BigDecimal codigo, Date fechaEntrada, String medioEntrada) {
        this.codigo = codigo;
        this.fechaEntrada = fechaEntrada;
        this.medioEntrada = medioEntrada;
    }

    public BigDecimal getCodigo() {
        return codigo;
    }

    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getMedioEntrada() {
        return medioEntrada;
    }

    public void setMedioEntrada(String medioEntrada) {
        this.medioEntrada = medioEntrada;
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

    public Aviso getAvisoCodigo() {
        return avisoCodigo;
    }

    public void setAvisoCodigo(Aviso avisoCodigo) {
        this.avisoCodigo = avisoCodigo;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public Sat getSatIdEmpleado() {
        return satIdEmpleado;
    }

    public void setSatIdEmpleado(Sat satIdEmpleado) {
        this.satIdEmpleado = satIdEmpleado;
    }

    @XmlTransient
    public Collection<AvSuperv> getAvSupervCollection() {
        return avSupervCollection;
    }

    public void setAvSupervCollection(Collection<AvSuperv> avSupervCollection) {
        this.avSupervCollection = avSupervCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aviso)) {
            return false;
        }
        Aviso other = (Aviso) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.Aviso[ codigo=" + codigo + " ]";
    }
    
}
