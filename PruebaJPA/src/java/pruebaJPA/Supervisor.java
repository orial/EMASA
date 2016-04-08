/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaJPA;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
@Table(name = "SUPERVISOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supervisor.findAll", query = "SELECT s FROM Supervisor s"),
    @NamedQuery(name = "Supervisor.findByIdEmpleado", query = "SELECT s FROM Supervisor s WHERE s.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Supervisor.findByEspecialidad", query = "SELECT s FROM Supervisor s WHERE s.especialidad = :especialidad"),
    @NamedQuery(name = "Supervisor.findByZona", query = "SELECT s FROM Supervisor s WHERE s.zona = :zona")})
public class Supervisor implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EMPLEADO")
    private BigDecimal idEmpleado;
    @Size(max = 40)
    @Column(name = "ESPECIALIDAD")
    private String especialidad;
    @Size(max = 20)
    @Column(name = "ZONA")
    private String zona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supervisorIdEmpleado")
    private Collection<Visitas> visitasCollection;
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Empleado empleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supervisorIdEmpleado")
    private Collection<OrdTrabajo> ordTrabajoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supervisorIdEmpleado")
    private Collection<AvSuperv> avSupervCollection;

    public Supervisor() {
    }

    public Supervisor(BigDecimal idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public BigDecimal getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(BigDecimal idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @XmlTransient
    public Collection<Visitas> getVisitasCollection() {
        return visitasCollection;
    }

    public void setVisitasCollection(Collection<Visitas> visitasCollection) {
        this.visitasCollection = visitasCollection;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @XmlTransient
    public Collection<OrdTrabajo> getOrdTrabajoCollection() {
        return ordTrabajoCollection;
    }

    public void setOrdTrabajoCollection(Collection<OrdTrabajo> ordTrabajoCollection) {
        this.ordTrabajoCollection = ordTrabajoCollection;
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
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supervisor)) {
            return false;
        }
        Supervisor other = (Supervisor) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.Supervisor[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
