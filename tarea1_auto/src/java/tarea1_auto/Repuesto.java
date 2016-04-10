/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1_auto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Lupi
 */
@Entity
@Table(name = "REPUESTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Repuesto.findAll", query = "SELECT r FROM Repuesto r"),
    @NamedQuery(name = "Repuesto.findByIdRepuesto", query = "SELECT r FROM Repuesto r WHERE r.idRepuesto = :idRepuesto"),
    @NamedQuery(name = "Repuesto.findByNombre", query = "SELECT r FROM Repuesto r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Repuesto.findByDescripci\u00f3n", query = "SELECT r FROM Repuesto r WHERE r.descripci\u00f3n = :descripci\u00f3n")})
public class Repuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REPUESTO")
    private BigDecimal idRepuesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 200)
    @Column(name = "DESCRIPCI\u00d3N")
    private String descripción;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "repuesto")
    private Collection<Cantidad> cantidadCollection;

    public Repuesto() {
    }

    public Repuesto(BigDecimal idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public Repuesto(BigDecimal idRepuesto, String nombre) {
        this.idRepuesto = idRepuesto;
        this.nombre = nombre;
    }

    public BigDecimal getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(BigDecimal idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    @XmlTransient
    public Collection<Cantidad> getCantidadCollection() {
        return cantidadCollection;
    }

    public void setCantidadCollection(Collection<Cantidad> cantidadCollection) {
        this.cantidadCollection = cantidadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRepuesto != null ? idRepuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Repuesto)) {
            return false;
        }
        Repuesto other = (Repuesto) object;
        if ((this.idRepuesto == null && other.idRepuesto != null) || (this.idRepuesto != null && !this.idRepuesto.equals(other.idRepuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.Repuesto[ idRepuesto=" + idRepuesto + " ]";
    }
    
}
