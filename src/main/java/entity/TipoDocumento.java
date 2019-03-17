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
@Table(name = "tipo_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumento.findAll", query = "SELECT t FROM TipoDocumento t")
    , @NamedQuery(name = "TipoDocumento.findByIdDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.idDocumento = :idDocumento")
    , @NamedQuery(name = "TipoDocumento.findByNombDocumento", query = "SELECT t FROM TipoDocumento t WHERE t.nombDocumento = :nombDocumento")})
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DOCUMENTO")
    private Integer idDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMB_DOCUMENTO")
    private String nombDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipodocumento")
    private Set<Persona> personaSet;

    public TipoDocumento() {
    }

    public TipoDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public TipoDocumento(Integer idDocumento, String nombDocumento) {
        this.idDocumento = idDocumento;
        this.nombDocumento = nombDocumento;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getNombDocumento() {
        return nombDocumento;
    }

    public void setNombDocumento(String nombDocumento) {
        this.nombDocumento = nombDocumento;
    }

    @XmlTransient
    public Set<Persona> getPersonaSet() {
        return personaSet;
    }

    public void setPersonaSet(Set<Persona> personaSet) {
        this.personaSet = personaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumento != null ? idDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumento)) {
            return false;
        }
        TipoDocumento other = (TipoDocumento) object;
        if ((this.idDocumento == null && other.idDocumento != null) || (this.idDocumento != null && !this.idDocumento.equals(other.idDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TipoDocumento[ idDocumento=" + idDocumento + " ]";
    }
    
}
