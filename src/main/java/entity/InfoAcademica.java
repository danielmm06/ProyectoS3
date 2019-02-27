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
@Table(name = "info_academica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfoAcademica.findAll", query = "SELECT i FROM InfoAcademica i")
    , @NamedQuery(name = "InfoAcademica.findByIdInfoAcademica", query = "SELECT i FROM InfoAcademica i WHERE i.idInfoAcademica = :idInfoAcademica")
    , @NamedQuery(name = "InfoAcademica.findByUniversidad", query = "SELECT i FROM InfoAcademica i WHERE i.universidad = :universidad")
    , @NamedQuery(name = "InfoAcademica.findByPrograma", query = "SELECT i FROM InfoAcademica i WHERE i.programa = :programa")
    , @NamedQuery(name = "InfoAcademica.findByTituloObtenido", query = "SELECT i FROM InfoAcademica i WHERE i.tituloObtenido = :tituloObtenido")
    , @NamedQuery(name = "InfoAcademica.findByA\u00f1o", query = "SELECT i FROM InfoAcademica i WHERE i.a\u00f1o = :a\u00f1o")})
public class InfoAcademica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_INFO_ACADEMICA")
    private Integer idInfoAcademica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "UNIVERSIDAD")
    private String universidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PROGRAMA")
    private String programa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TITULO_OBTENIDO")
    private String tituloObtenido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "A\u00d1O")
    private String año;
    @JoinColumn(name = "ID_PREGUNTAS", referencedColumnName = "ID_PREGUNTAS")
    @ManyToOne(optional = false)
    private InfoPreguntas idPreguntas;

    public InfoAcademica() {
    }

    public InfoAcademica(Integer idInfoAcademica) {
        this.idInfoAcademica = idInfoAcademica;
    }

    public InfoAcademica(Integer idInfoAcademica, String universidad, String programa, String tituloObtenido, String año) {
        this.idInfoAcademica = idInfoAcademica;
        this.universidad = universidad;
        this.programa = programa;
        this.tituloObtenido = tituloObtenido;
        this.año = año;
    }

    public Integer getIdInfoAcademica() {
        return idInfoAcademica;
    }

    public void setIdInfoAcademica(Integer idInfoAcademica) {
        this.idInfoAcademica = idInfoAcademica;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getTituloObtenido() {
        return tituloObtenido;
    }

    public void setTituloObtenido(String tituloObtenido) {
        this.tituloObtenido = tituloObtenido;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
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
        hash += (idInfoAcademica != null ? idInfoAcademica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoAcademica)) {
            return false;
        }
        InfoAcademica other = (InfoAcademica) object;
        if ((this.idInfoAcademica == null && other.idInfoAcademica != null) || (this.idInfoAcademica != null && !this.idInfoAcademica.equals(other.idInfoAcademica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.InfoAcademica[ idInfoAcademica=" + idInfoAcademica + " ]";
    }
    
}
