/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaJPA;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lupi
 */
@Entity
@Table(name = "HISTORICO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historico.findAll", query = "SELECT h FROM Historico h"),
    @NamedQuery(name = "Historico.findByAvisoCodigo", query = "SELECT h FROM Historico h WHERE h.historicoPK.avisoCodigo = :avisoCodigo"),
    @NamedQuery(name = "Historico.findByFechaActualizacion", query = "SELECT h FROM Historico h WHERE h.historicoPK.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "Historico.findByDescripcion", query = "SELECT h FROM Historico h WHERE h.descripcion = :descripcion"),
    @NamedQuery(name = "Historico.findByDireccion", query = "SELECT h FROM Historico h WHERE h.direccion = :direccion"),
    @NamedQuery(name = "Historico.findByEstado", query = "SELECT h FROM Historico h WHERE h.estado = :estado"),
    @NamedQuery(name = "Historico.findByDuplicado", query = "SELECT h FROM Historico h WHERE h.duplicado = :duplicado"),
    @NamedQuery(name = "Historico.findByFechaCierre", query = "SELECT h FROM Historico h WHERE h.fechaCierre = :fechaCierre"),
    @NamedQuery(name = "Historico.findByTipoAviso", query = "SELECT h FROM Historico h WHERE h.tipoAviso = :tipoAviso"),
    @NamedQuery(name = "Historico.findByCausa", query = "SELECT h FROM Historico h WHERE h.causa = :causa"),
    @NamedQuery(name = "Historico.findByPeligrosidad", query = "SELECT h FROM Historico h WHERE h.peligrosidad = :peligrosidad"),
    @NamedQuery(name = "Historico.findByUbicacionGps", query = "SELECT h FROM Historico h WHERE h.ubicacionGps = :ubicacionGps"),
    @NamedQuery(name = "Historico.findByRedAgua", query = "SELECT h FROM Historico h WHERE h.redAgua = :redAgua"),
    @NamedQuery(name = "Historico.findByDocAdjunto", query = "SELECT h FROM Historico h WHERE h.docAdjunto = :docAdjunto"),
    @NamedQuery(name = "Historico.findByEmpleadoIdEmpleado", query = "SELECT h FROM Historico h WHERE h.historicoPK.empleadoIdEmpleado = :empleadoIdEmpleado")})
public class Historico implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HistoricoPK historicoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DUPLICADO")
    private BigInteger duplicado;
    @Column(name = "FECHA_CIERRE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;
    @Size(max = 15)
    @Column(name = "TIPO_AVISO")
    private String tipoAviso;
    @Size(max = 50)
    @Column(name = "CAUSA")
    private String causa;
    @Size(max = 20)
    @Column(name = "PELIGROSIDAD")
    private String peligrosidad;
    @Size(max = 20)
    @Column(name = "UBICACION_GPS")
    private String ubicacionGps;
    @Size(max = 50)
    @Column(name = "RED_AGUA")
    private String redAgua;
    @Size(max = 200)
    @Column(name = "DOC_ADJUNTO")
    private String docAdjunto;
    @JoinColumn(name = "AVISO_CODIGO", referencedColumnName = "CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aviso aviso;
    @JoinColumn(name = "EMPLEADO_ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleado empleado;

    public Historico() {
    }

    public Historico(HistoricoPK historicoPK) {
        this.historicoPK = historicoPK;
    }

    public Historico(HistoricoPK historicoPK, String descripcion, String direccion, String estado, BigInteger duplicado) {
        this.historicoPK = historicoPK;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.estado = estado;
        this.duplicado = duplicado;
    }

    public Historico(BigInteger avisoCodigo, Date fechaActualizacion, BigInteger empleadoIdEmpleado) {
        this.historicoPK = new HistoricoPK(avisoCodigo, fechaActualizacion, empleadoIdEmpleado);
    }

    public HistoricoPK getHistoricoPK() {
        return historicoPK;
    }

    public void setHistoricoPK(HistoricoPK historicoPK) {
        this.historicoPK = historicoPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigInteger getDuplicado() {
        return duplicado;
    }

    public void setDuplicado(BigInteger duplicado) {
        this.duplicado = duplicado;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getTipoAviso() {
        return tipoAviso;
    }

    public void setTipoAviso(String tipoAviso) {
        this.tipoAviso = tipoAviso;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getPeligrosidad() {
        return peligrosidad;
    }

    public void setPeligrosidad(String peligrosidad) {
        this.peligrosidad = peligrosidad;
    }

    public String getUbicacionGps() {
        return ubicacionGps;
    }

    public void setUbicacionGps(String ubicacionGps) {
        this.ubicacionGps = ubicacionGps;
    }

    public String getRedAgua() {
        return redAgua;
    }

    public void setRedAgua(String redAgua) {
        this.redAgua = redAgua;
    }

    public String getDocAdjunto() {
        return docAdjunto;
    }

    public void setDocAdjunto(String docAdjunto) {
        this.docAdjunto = docAdjunto;
    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historicoPK != null ? historicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historico)) {
            return false;
        }
        Historico other = (Historico) object;
        if ((this.historicoPK == null && other.historicoPK != null) || (this.historicoPK != null && !this.historicoPK.equals(other.historicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebaJPA.Historico[ historicoPK=" + historicoPK + " ]";
    }
    
}
