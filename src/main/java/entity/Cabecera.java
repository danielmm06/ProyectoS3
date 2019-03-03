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
@Table(name = "cabecera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cabecera.findAll", query = "SELECT c FROM Cabecera c")
    , @NamedQuery(name = "Cabecera.findByIdCabecera", query = "SELECT c FROM Cabecera c WHERE c.idCabecera = :idCabecera")
    , @NamedQuery(name = "Cabecera.findByPrograma", query = "SELECT c FROM Cabecera c WHERE c.programa = :programa")
    , @NamedQuery(name = "Cabecera.findByFacultad", query = "SELECT c FROM Cabecera c WHERE c.facultad = :facultad")})
public class Cabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CABECERA")
    private Integer idCabecera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PROGRAMA")
    private String programa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "FACULTAD")
    private String facultad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabecera")
    private Set<InfoPreguntas> infoPreguntasSet;
    @JoinColumn(name = "CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne(optional = false)
    private Categoria categoria;

    public Cabecera() {
    }

    public Cabecera(Integer idCabecera) {
        this.idCabecera = idCabecera;
    }

    public Cabecera(Integer idCabecera, String programa, String facultad) {
        this.idCabecera = idCabecera;
        this.programa = programa;
        this.facultad = facultad;
    }

    public Integer getIdCabecera() {
        return idCabecera;
    }

    public void setIdCabecera(Integer idCabecera) {
        this.idCabecera = idCabecera;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    @XmlTransient
    public Set<InfoPreguntas> getInfoPreguntasSet() {
        return infoPreguntasSet;
    }

    public void setInfoPreguntasSet(Set<InfoPreguntas> infoPreguntasSet) {
        this.infoPreguntasSet = infoPreguntasSet;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCabecera != null ? idCabecera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cabecera)) {
            return false;
        }
        Cabecera other = (Cabecera) object;
        if ((this.idCabecera == null && other.idCabecera != null) || (this.idCabecera != null && !this.idCabecera.equals(other.idCabecera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cabecera[ idCabecera=" + idCabecera + " ]";
    }
    
}
