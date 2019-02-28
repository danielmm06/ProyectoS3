/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "info_idiomas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfoIdiomas.findAll", query = "SELECT i FROM InfoIdiomas i"),
    @NamedQuery(name = "InfoIdiomas.findByIdIdiomas", query = "SELECT i FROM InfoIdiomas i WHERE i.idIdiomas = :idIdiomas"),
    @NamedQuery(name = "InfoIdiomas.findByIdioma", query = "SELECT i FROM InfoIdiomas i WHERE i.idioma = :idioma"),
    @NamedQuery(name = "InfoIdiomas.findByComprende", query = "SELECT i FROM InfoIdiomas i WHERE i.comprende = :comprende"),
    @NamedQuery(name = "InfoIdiomas.findByHabla", query = "SELECT i FROM InfoIdiomas i WHERE i.habla = :habla"),
    @NamedQuery(name = "InfoIdiomas.findByEscribe", query = "SELECT i FROM InfoIdiomas i WHERE i.escribe = :escribe")})
public class InfoIdiomas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_IDIOMAS")
    private Integer idIdiomas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "IDIOMA")
    private String idioma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "COMPRENDE")
    private String comprende;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "HABLA")
    private String habla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ESCRIBE")
    private String escribe;
    @JoinColumn(name = "ID_PREGUNTAS", referencedColumnName = "ID_PREGUNTAS")
    @ManyToOne(optional = false)
    private InfoPreguntas idPreguntas;

    public InfoIdiomas() {
    }

    public InfoIdiomas(Integer idIdiomas) {
        this.idIdiomas = idIdiomas;
    }

    public InfoIdiomas(Integer idIdiomas, String idioma, String comprende, String habla, String escribe) {
        this.idIdiomas = idIdiomas;
        this.idioma = idioma;
        this.comprende = comprende;
        this.habla = habla;
        this.escribe = escribe;
    }

    public Integer getIdIdiomas() {
        return idIdiomas;
    }

    public void setIdIdiomas(Integer idIdiomas) {
        this.idIdiomas = idIdiomas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getComprende() {
        return comprende;
    }

    public void setComprende(String comprende) {
        this.comprende = comprende;
    }

    public String getHabla() {
        return habla;
    }

    public void setHabla(String habla) {
        this.habla = habla;
    }

    public String getEscribe() {
        return escribe;
    }

    public void setEscribe(String escribe) {
        this.escribe = escribe;
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
        hash += (idIdiomas != null ? idIdiomas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoIdiomas)) {
            return false;
        }
        InfoIdiomas other = (InfoIdiomas) object;
        if ((this.idIdiomas == null && other.idIdiomas != null) || (this.idIdiomas != null && !this.idIdiomas.equals(other.idIdiomas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.InfoIdiomas[ idIdiomas=" + idIdiomas + " ]";
    }

}
