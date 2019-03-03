/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "tipo_soporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoSoporte.findAll", query = "SELECT t FROM TipoSoporte t")
    , @NamedQuery(name = "TipoSoporte.findByIdTiposoporte", query = "SELECT t FROM TipoSoporte t WHERE t.idTiposoporte = :idTiposoporte")
    , @NamedQuery(name = "TipoSoporte.findByNombre", query = "SELECT t FROM TipoSoporte t WHERE t.nombre = :nombre")})
public class TipoSoporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPOSOPORTE")
    private Integer idTiposoporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTiposoporte")
    private Set<Soporte> soporteSet;

    public TipoSoporte() {
    }

    public TipoSoporte(Integer idTiposoporte) {
        this.idTiposoporte = idTiposoporte;
    }

    public TipoSoporte(Integer idTiposoporte, String nombre) {
        this.idTiposoporte = idTiposoporte;
        this.nombre = nombre;
    }

    public Integer getIdTiposoporte() {
        return idTiposoporte;
    }

    public void setIdTiposoporte(Integer idTiposoporte) {
        this.idTiposoporte = idTiposoporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Set<Soporte> getSoporteSet() {
        return soporteSet;
    }

    public void setSoporteSet(Set<Soporte> soporteSet) {
        this.soporteSet = soporteSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTiposoporte != null ? idTiposoporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSoporte)) {
            return false;
        }
        TipoSoporte other = (TipoSoporte) object;
        if ((this.idTiposoporte == null && other.idTiposoporte != null) || (this.idTiposoporte != null && !this.idTiposoporte.equals(other.idTiposoporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TipoSoporte[ idTiposoporte=" + idTiposoporte + " ]";
    }
    
}
