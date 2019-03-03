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
 * @author Daniel
 */
@Entity
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.findByIdCiudad", query = "SELECT c FROM Ciudad c WHERE c.idCiudad = :idCiudad")
    , @NamedQuery(name = "Ciudad.findByNombreCiudad", query = "SELECT c FROM Ciudad c WHERE c.nombreCiudad = :nombreCiudad")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CIUDAD")
    private Integer idCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE_CIUDAD")
    private String nombreCiudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expCiudad")
    private Set<Persona> personaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudadNacimiento")
    private Set<Persona> personaSet1;
    @OneToMany(mappedBy = "oficCiudad")
    private Set<Persona> personaSet2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resCiudad")
    private Set<Persona> personaSet3;
    @OneToMany(mappedBy = "empCiudad")
    private Set<InfoPreguntas> infoPreguntasSet;
    @JoinColumn(name = "ID_DPTO", referencedColumnName = "ID_DPTO")
    @ManyToOne(optional = false)
    private Departamento idDpto;

    public Ciudad() {
    }

    public Ciudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Ciudad(Integer idCiudad, String nombreCiudad) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    @XmlTransient
    public Set<Persona> getPersonaSet() {
        return personaSet;
    }

    public void setPersonaSet(Set<Persona> personaSet) {
        this.personaSet = personaSet;
    }

    @XmlTransient
    public Set<Persona> getPersonaSet1() {
        return personaSet1;
    }

    public void setPersonaSet1(Set<Persona> personaSet1) {
        this.personaSet1 = personaSet1;
    }

    @XmlTransient
    public Set<Persona> getPersonaSet2() {
        return personaSet2;
    }

    public void setPersonaSet2(Set<Persona> personaSet2) {
        this.personaSet2 = personaSet2;
    }

    @XmlTransient
    public Set<Persona> getPersonaSet3() {
        return personaSet3;
    }

    public void setPersonaSet3(Set<Persona> personaSet3) {
        this.personaSet3 = personaSet3;
    }

    @XmlTransient
    public Set<InfoPreguntas> getInfoPreguntasSet() {
        return infoPreguntasSet;
    }

    public void setInfoPreguntasSet(Set<InfoPreguntas> infoPreguntasSet) {
        this.infoPreguntasSet = infoPreguntasSet;
    }

    public Departamento getIdDpto() {
        return idDpto;
    }

    public void setIdDpto(Departamento idDpto) {
        this.idDpto = idDpto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiudad != null ? idCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.idCiudad == null && other.idCiudad != null) || (this.idCiudad != null && !this.idCiudad.equals(other.idCiudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ciudad[ idCiudad=" + idCiudad + " ]";
    }
    
}
