/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "info_laboral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfoLaboral.findAll", query = "SELECT i FROM InfoLaboral i")
    , @NamedQuery(name = "InfoLaboral.findByIdLaboral", query = "SELECT i FROM InfoLaboral i WHERE i.idLaboral = :idLaboral")
    , @NamedQuery(name = "InfoLaboral.findByEmpresa", query = "SELECT i FROM InfoLaboral i WHERE i.empresa = :empresa")
    , @NamedQuery(name = "InfoLaboral.findByCargo", query = "SELECT i FROM InfoLaboral i WHERE i.cargo = :cargo")
    , @NamedQuery(name = "InfoLaboral.findByFechaInicio", query = "SELECT i FROM InfoLaboral i WHERE i.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "InfoLaboral.findByFechaFin", query = "SELECT i FROM InfoLaboral i WHERE i.fechaFin = :fechaFin")})
public class InfoLaboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_LABORAL")
    private Integer idLaboral;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EMPRESA")
    private String empresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CARGO")
    private String cargo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @JoinColumn(name = "ID_PREGUNTAS", referencedColumnName = "ID_PREGUNTAS")
    @ManyToOne(optional = false)
    private InfoPreguntas idPreguntas;

    public InfoLaboral() {
    }

    public InfoLaboral(Integer idLaboral) {
        this.idLaboral = idLaboral;
    }

    public InfoLaboral(Integer idLaboral, String empresa, String cargo, Date fechaInicio, Date fechaFin) {
        this.idLaboral = idLaboral;
        this.empresa = empresa;
        this.cargo = cargo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdLaboral() {
        return idLaboral;
    }

    public void setIdLaboral(Integer idLaboral) {
        this.idLaboral = idLaboral;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public InfoPreguntas getIdPreguntas() {
        return idPreguntas;
    }

    public void setIdPreguntas(InfoPreguntas idPreguntas) {
        this.idPreguntas = idPreguntas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLaboral != null ? idLaboral.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoLaboral)) {
            return false;
        }
        InfoLaboral other = (InfoLaboral) object;
        if ((this.idLaboral == null && other.idLaboral != null) || (this.idLaboral != null && !this.idLaboral.equals(other.idLaboral))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.InfoLaboral[ idLaboral=" + idLaboral + " ]";
    }
    
}
