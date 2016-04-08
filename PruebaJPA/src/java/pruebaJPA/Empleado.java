/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaJPA;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Empleado.findByDepartamento", query = "SELECT e FROM Empleado e WHERE e.departamento = :departamento"),
    @NamedQuery(name = "Empleado.findByTurno", query = "SELECT e FROM Empleado e WHERE e.turno = :turno"),
    @NamedQuery(name = "Empleado.findByDni", query = "SELECT e FROM Empleado e WHERE e.dni = :dni")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EMPLEADO")
    private BigDecimal idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @Column(name = "TURNO")
    private BigInteger turno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "DNI")
    private String dni;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private Collection<Historico> historicoCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empleado")
    private Sat sat;
    @JoinColumn(name = "BRIGADA_NUM_BRIGADA", referencedColumnName = "NUM_BRIGADA")
    @ManyToOne
    private Brigada brigadaNumBrigada;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empleado")
    private Supervisor supervisor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empleado")
    private OpMov opMov;

    public Empleado() {
    }

    public Empleado(BigDecimal idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(BigDecimal idEmpleado, String departamento, String dni) {
        this.idEmpleado = idEmpleado;
        this.departamento = departamento;
        this.dni = dni;
    }

    public BigDecimal getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(BigDecimal idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public BigInteger getTurno() {
        return turno;
    }

    public void setTurno(BigInteger turno) {
        this.turno = turno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @XmlTransient
    public Collection<Historico> getHistoricoCollection() {
        return historicoCollection;
    }

    public void setHistoricoCollection(Collection<Historico> historicoCollection) {
        this.historicoCollection = historicoCollection;
    }

    public Sat getSat() {
        return sat;
    }

    public void setSat(Sat sat) {
        this.sat = sat;
    }

    public Brigada getBrigadaNumBrigada() {
        return brigadaNumBrigada;
    }

    public void setBrigadaNumBrigada(Brigada brigadaNumBrigada) {
        this.brigadaNumBrigada = brigadaNumBrigada;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public OpMov getOpMov() {
        return opMov;
    }

    public void setOpMov(OpMov opMov) {
        this.opMov = opMov;
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
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.Empleado[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
