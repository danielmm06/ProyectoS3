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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByIdDpto", query = "SELECT d FROM Departamento d WHERE d.idDpto = :idDpto"),
    @NamedQuery(name = "Departamento.findByNombreDpto", query = "SELECT d FROM Departamento d WHERE d.nombreDpto = :nombreDpto")})
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DPTO")
    private Integer idDpto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_DPTO")
    private String nombreDpto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDpto")
    private Set<Ciudad> ciudadSet;
    @JoinColumn(name = "ID_PAIS", referencedColumnName = "ID_PAIS")
    @ManyToOne(optional = false)
    private Pais idPais;

    public Departamento() {
    }

    public Departamento(Integer idDpto) {
        this.idDpto = idDpto;
    }

    public Departamento(Integer idDpto, String nombreDpto) {
        this.idDpto = idDpto;
        this.nombreDpto = nombreDpto;
    }

    public Integer getIdDpto() {
        return idDpto;
    }

    public void setIdDpto(Integer idDpto) {
        this.idDpto = idDpto;
    }

    public String getNombreDpto() {
        return nombreDpto;
    }

    public void setNombreDpto(String nombreDpto) {
        this.nombreDpto = nombreDpto;
    }

    @XmlTransient
    public Set<Ciudad> getCiudadSet() {
        return ciudadSet;
    }

    public void setCiudadSet(Set<Ciudad> ciudadSet) {
        this.ciudadSet = ciudadSet;
    }

    public Pais getIdPais() {
        return idPais;
    }

    public void setIdPais(Pais idPais) {
        this.idPais = idPais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDpto != null ? idDpto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.idDpto == null && other.idDpto != null) || (this.idDpto != null && !this.idDpto.equals(other.idDpto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Departamento[ idDpto=" + idDpto + " ]";
    }
    
}
