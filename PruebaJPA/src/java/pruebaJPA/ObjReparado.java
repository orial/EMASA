/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaJPA;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lupi
 */
@Entity
@Table(name = "OBJ_REPARADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ObjReparado.findAll", query = "SELECT o FROM ObjReparado o"),
    @NamedQuery(name = "ObjReparado.findByCodigo", query = "SELECT o FROM ObjReparado o WHERE o.codigo = :codigo"),
    @NamedQuery(name = "ObjReparado.findByUbicacionTecnica", query = "SELECT o FROM ObjReparado o WHERE o.ubicacionTecnica = :ubicacionTecnica"),
    @NamedQuery(name = "ObjReparado.findByDiametro", query = "SELECT o FROM ObjReparado o WHERE o.diametro = :diametro"),
    @NamedQuery(name = "ObjReparado.findByProfundidad", query = "SELECT o FROM ObjReparado o WHERE o.profundidad = :profundidad"),
    @NamedQuery(name = "ObjReparado.findByLongitud", query = "SELECT o FROM ObjReparado o WHERE o.longitud = :longitud"),
    @NamedQuery(name = "ObjReparado.findByPresionNominal", query = "SELECT o FROM ObjReparado o WHERE o.presionNominal = :presionNominal")})
public class ObjReparado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private BigDecimal codigo;
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
        @JoinColumn(name = "ACTUACIONES_FECHA", referencedColumnName = "FECHA"),
        @JoinColumn(name = "ACTUACIONES_IDENTIFICADOR", referencedColumnName = "ORD_TRAB_ID"),
        @JoinColumn(name = "ACTUACIONES_NUM_BRIGADA", referencedColumnName = "BRIGADA_NUM_BRIGADA")})
    @ManyToOne(optional = false)
    private Actuaciones actuaciones;

    public ObjReparado() {
    }

    public ObjReparado(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public ObjReparado(BigDecimal codigo, String ubicacionTecnica) {
        this.codigo = codigo;
        this.ubicacionTecnica = ubicacionTecnica;
    }

    public BigDecimal getCodigo() {
        return codigo;
    }

    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
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
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObjReparado)) {
            return false;
        }
        ObjReparado other = (ObjReparado) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.ObjReparado[ codigo=" + codigo + " ]";
    }
    
}
