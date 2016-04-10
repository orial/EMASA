/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1_auto;

import java.io.Serializable;
import java.math.*;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.*;


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
    @NamedQuery(name = "Empleado.findByDni", query = "SELECT e FROM Empleado e WHERE e.dni = :dni"),
    @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empleado.findByApellidos", query = "SELECT e FROM Empleado e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Empleado.findByDepartamento", query = "SELECT e FROM Empleado e WHERE e.departamento = :departamento"),
    @NamedQuery(name = "Empleado.findByCargo", query = "SELECT e FROM Empleado e WHERE e.cargo = :cargo"),
    @NamedQuery(name = "Empleado.findByTurno", query = "SELECT e FROM Empleado e WHERE e.turno = :turno"),
    @NamedQuery(name = "Empleado.findByZona", query = "SELECT e FROM Empleado e WHERE e.zona = :zona"),
    @NamedQuery(name = "Empleado.findByEspecialidad", query = "SELECT e FROM Empleado e WHERE e.especialidad = :especialidad")})
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
    @Size(min = 1, max = 12)
    @Column(name = "DNI")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CARGO")
    private String cargo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TURNO")
    private BigInteger turno;
    @Size(max = 20)
    @Column(name = "ZONA")
    private String zona;
    @Size(max = 20)
    @Column(name = "ESPECIALIDAD")
    private String especialidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private Collection<Historico> historicoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private Collection<Visitas> visitasCollection;
    @JoinColumn(name = "NUM_BRIGADA", referencedColumnName = "NUM_BRIGADA")
    @ManyToOne
    private Brigada numBrigada;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<Aviso> avisoCollection;

    public Empleado() {
    }

    public Empleado(BigDecimal idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(BigDecimal idEmpleado, String dni, String nombre, String apellidos, String departamento, String cargo, BigInteger turno) {
        this.idEmpleado = idEmpleado;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.departamento = departamento;
        this.cargo = cargo;
        this.turno = turno;
    }

    public BigDecimal getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(BigDecimal idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigInteger getTurno() {
        return turno;
    }

    public void setTurno(BigInteger turno) {
        this.turno = turno;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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

    public Brigada getNumBrigada() {
        return numBrigada;
    }

    public void setNumBrigada(Brigada numBrigada) {
        this.numBrigada = numBrigada;
    }

    @XmlTransient
    public Collection<Aviso> getAvisoCollection() {
        return avisoCollection;
    }

    public void setAvisoCollection(Collection<Aviso> avisoCollection) {
        this.avisoCollection = avisoCollection;
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
