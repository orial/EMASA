/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1_auto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lupi
 */
@Entity
@Table(name = "REPARACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reparacion.findAll", query = "SELECT r FROM Reparacion r"),
    @NamedQuery(name = "Reparacion.findByIdReparacion", query = "SELECT r FROM Reparacion r WHERE r.idReparacion = :idReparacion"),
    @NamedQuery(name = "Reparacion.findByUbicacionTecnica", query = "SELECT r FROM Reparacion r WHERE r.ubicacionTecnica = :ubicacionTecnica"),
    @NamedQuery(name = "Reparacion.findByDiametro", query = "SELECT r FROM Reparacion r WHERE r.diametro = :diametro"),
    @NamedQuery(name = "Reparacion.findByProfundidad", query = "SELECT r FROM Reparacion r WHERE r.profundidad = :profundidad"),
    @NamedQuery(name = "Reparacion.findByLongitud", query = "SELECT r FROM Reparacion r WHERE r.longitud = :longitud"),
    @NamedQuery(name = "Reparacion.findByPresionNominal", query = "SELECT r FROM Reparacion r WHERE r.presionNominal = :presionNominal")})
public class Reparacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REPARACION")
    private BigDecimal idReparacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "UBICACION_TECNICA")
    private String ubicacionTecnica;
    @Column(name = "DIAMETRO")
    private BigInteger diametro;
    @Column(name = "PROFUNDIDAD")
    private BigInteger profundidad;
    @Column(name = "LONGITUD")
    private BigInteger longitud;
    @Column(name = "PRESION_NOMINAL")
    private BigInteger presionNominal;
    @JoinColumns({
        @JoinColumn(name = "FECHA_ACTUACION", referencedColumnName = "FECHA_ACTUACION"),
        @JoinColumn(name = "ID_ORDEN", referencedColumnName = "ID_ORDEN")})
    @ManyToOne(optional = false)
    private Actuaciones actuaciones;

    public Reparacion() {
    }

    public Reparacion(BigDecimal idReparacion) {
        this.idReparacion = idReparacion;
    }

    public Reparacion(BigDecimal idReparacion, String ubicacionTecnica) {
        this.idReparacion = idReparacion;
        this.ubicacionTecnica = ubicacionTecnica;
    }

    public BigDecimal getIdReparacion() {
        return idReparacion;
    }

    public void setIdReparacion(BigDecimal idReparacion) {
        this.idReparacion = idReparacion;
    }

    public String getUbicacionTecnica() {
        return ubicacionTecnica;
    }

    public void setUbicacionTecnica(String ubicacionTecnica) {
        this.ubicacionTecnica = ubicacionTecnica;
    }

    public BigInteger getDiametro() {
        return diametro;
    }

    public void setDiametro(BigInteger diametro) {
        this.diametro = diametro;
    }

    public BigInteger getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(BigInteger profundidad) {
        this.profundidad = profundidad;
    }

    public BigInteger getLongitud() {
        return longitud;
    }

    public void setLongitud(BigInteger longitud) {
        this.longitud = longitud;
    }

    public BigInteger getPresionNominal() {
        return presionNominal;
    }

    public void setPresionNominal(BigInteger presionNominal) {
        this.presionNominal = presionNominal;
    }

    public Actuaciones getActuaciones() {
        return actuaciones;
    }

    public void setActuaciones(Actuaciones actuaciones) {
        this.actuaciones = actuaciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReparacion != null ? idReparacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reparacion)) {
            return false;
        }
        Reparacion other = (Reparacion) object;
        if ((this.idReparacion == null && other.idReparacion != null) || (this.idReparacion != null && !this.idReparacion.equals(other.idReparacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tarea1_auto.Reparacion[ idReparacion=" + idReparacion + " ]";
    }
    
}
