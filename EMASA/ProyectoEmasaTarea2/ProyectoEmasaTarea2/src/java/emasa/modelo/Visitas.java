/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.Column;

/**
 *
 * @author Lupi
 */
@Entity
@Table(name = "VISITAS")
public class Visitas implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "FECHA_VISITA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVisita;
    
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @ManyToOne(optional = false)
    private Empleado idEmpleado;
    
    @JoinColumns({
        @JoinColumn(name = "ID_AVISO", referencedColumnName = "ID_AVISO"),
        @JoinColumn(name = "FECHA_ACTUALIZACION", referencedColumnName = "FECHA_ACTUALIZACION"),
        @JoinColumn(name = "SUPERVISOR", referencedColumnName = "SUPERVISOR")})
    @OneToOne(optional = false)
    private Historico historico;
    

    public Visitas() {
    }

    public Visitas(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        this.historico = historico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fechaVisita != null ? fechaVisita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitas)) {
            return false;
        }
        Visitas other = (Visitas) object;
        if ((this.fechaVisita == null && other.fechaVisita != null) || (this.fechaVisita != null && !this.fechaVisita.equals(other.fechaVisita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Visitas{" + "fechaVisita=" + fechaVisita + ", idEmpleado=" + idEmpleado + '}';
    }  
}
