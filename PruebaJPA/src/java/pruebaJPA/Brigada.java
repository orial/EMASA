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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lupi
 */
@Entity
@Table(name = "BRIGADA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Brigada.findAll", query = "SELECT b FROM Brigada b"),
    @NamedQuery(name = "Brigada.findByNumBrigada", query = "SELECT b FROM Brigada b WHERE b.numBrigada = :numBrigada"),
    @NamedQuery(name = "Brigada.findByTurno", query = "SELECT b FROM Brigada b WHERE b.turno = :turno"),
    @NamedQuery(name = "Brigada.findByContrata", query = "SELECT b FROM Brigada b WHERE b.contrata = :contrata")})
public class Brigada implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_BRIGADA")
    private BigDecimal numBrigada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TURNO")
    private BigInteger turno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTRATA")
    private Character contrata;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brigada")
    private Collection<Actuaciones> actuacionesCollection;
    @OneToMany(mappedBy = "brigadaNumBrigada")
    private Collection<Empleado> empleadoCollection;

    public Brigada() {
    }

    public Brigada(BigDecimal numBrigada) {
        this.numBrigada = numBrigada;
    }

    public Brigada(BigDecimal numBrigada, BigInteger turno, Character contrata) {
        this.numBrigada = numBrigada;
        this.turno = turno;
        this.contrata = contrata;
    }

    public BigDecimal getNumBrigada() {
        return numBrigada;
    }

    public void setNumBrigada(BigDecimal numBrigada) {
        this.numBrigada = numBrigada;
    }

    public BigInteger getTurno() {
        return turno;
    }

    public void setTurno(BigInteger turno) {
        this.turno = turno;
    }

    public Character getContrata() {
        return contrata;
    }

    public void setContrata(Character contrata) {
        this.contrata = contrata;
    }

    @XmlTransient
    public Collection<Actuaciones> getActuacionesCollection() {
        return actuacionesCollection;
    }

    public void setActuacionesCollection(Collection<Actuaciones> actuacionesCollection) {
        this.actuacionesCollection = actuacionesCollection;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numBrigada != null ? numBrigada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Brigada)) {
            return false;
        }
        Brigada other = (Brigada) object;
        if ((this.numBrigada == null && other.numBrigada != null) || (this.numBrigada != null && !this.numBrigada.equals(other.numBrigada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.Brigada[ numBrigada=" + numBrigada + " ]";
    }
    
}
