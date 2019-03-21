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
 * @author niari
 */
@Entity
@Table(name = "rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
    @NamedQuery(name = "Rol.findByIdTUsuario", query = "SELECT r FROM Rol r WHERE r.idTUsuario = :idTUsuario"),
    @NamedQuery(name = "Rol.findByNombreTUsuario", query = "SELECT r FROM Rol r WHERE r.nombreTUsuario = :nombreTUsuario")})
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_T_USUARIO")
    private Integer idTUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE_T_USUARIO")
    private String nombreTUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol")
    private Set<Usuarios> usuariosSet;

    public Rol() {
    }

    public Rol(Integer idTUsuario) {
        this.idTUsuario = idTUsuario;
    }

    public Rol(Integer idTUsuario, String nombreTUsuario) {
        this.idTUsuario = idTUsuario;
        this.nombreTUsuario = nombreTUsuario;
    }

    public Integer getIdTUsuario() {
        return idTUsuario;
    }

    public void setIdTUsuario(Integer idTUsuario) {
        this.idTUsuario = idTUsuario;
    }

    public String getNombreTUsuario() {
        return nombreTUsuario;
    }

    public void setNombreTUsuario(String nombreTUsuario) {
        this.nombreTUsuario = nombreTUsuario;
    }

    @XmlTransient
    public Set<Usuarios> getUsuariosSet() {
        return usuariosSet;
    }

    public void setUsuariosSet(Set<Usuarios> usuariosSet) {
        this.usuariosSet = usuariosSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTUsuario != null ? idTUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.idTUsuario == null && other.idTUsuario != null) || (this.idTUsuario != null && !this.idTUsuario.equals(other.idTUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Rol[ idTUsuario=" + idTUsuario + " ]";
    }
    
}
