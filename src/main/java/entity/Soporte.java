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
 * @author niari
 */
@Entity
@Table(name = "soporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Soporte.findAll", query = "SELECT s FROM Soporte s"),
    @NamedQuery(name = "Soporte.findByIdSoporte", query = "SELECT s FROM Soporte s WHERE s.idSoporte = :idSoporte"),
    @NamedQuery(name = "Soporte.findByNombreSoporte", query = "SELECT s FROM Soporte s WHERE s.nombreSoporte = :nombreSoporte"),
    @NamedQuery(name = "Soporte.findByUrlArchivo", query = "SELECT s FROM Soporte s WHERE s.urlArchivo = :urlArchivo"),
    @NamedQuery(name = "Soporte.findByValidacion", query = "SELECT s FROM Soporte s WHERE s.validacion = :validacion")})
public class Soporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SOPORTE")
    private Integer idSoporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_SOPORTE")
    private String nombreSoporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "URL_ARCHIVO")
    private String urlArchivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALIDACION")
    private int validacion;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "DOCUMENTO")
    @ManyToOne(optional = false)
    private Persona idPersona;
    @JoinColumn(name = "ID_TIPOSOPORTE", referencedColumnName = "ID_TIPOSOPORTE")
    @ManyToOne(optional = false)
    private TipoSoporte idTiposoporte;

    public Soporte() {
    }

    public Soporte(Integer idSoporte) {
        this.idSoporte = idSoporte;
    }

    public Soporte(Integer idSoporte, String nombreSoporte, String urlArchivo, int validacion) {
        this.idSoporte = idSoporte;
        this.nombreSoporte = nombreSoporte;
        this.urlArchivo = urlArchivo;
        this.validacion = validacion;
    }

    public Integer getIdSoporte() {
        return idSoporte;
    }

    public void setIdSoporte(Integer idSoporte) {
        this.idSoporte = idSoporte;
    }

    public String getNombreSoporte() {
        return nombreSoporte;
    }

    public void setNombreSoporte(String nombreSoporte) {
        this.nombreSoporte = nombreSoporte;
    }

    public String getUrlArchivo() {
        return urlArchivo;
    }

    public void setUrlArchivo(String urlArchivo) {
        this.urlArchivo = urlArchivo;
    }

    public int getValidacion() {
        return validacion;
    }

    public void setValidacion(int validacion) {
        this.validacion = validacion;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public TipoSoporte getIdTiposoporte() {
        return idTiposoporte;
    }

    public void setIdTiposoporte(TipoSoporte idTiposoporte) {
        this.idTiposoporte = idTiposoporte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSoporte != null ? idSoporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soporte)) {
            return false;
        }
        Soporte other = (Soporte) object;
        if ((this.idSoporte == null && other.idSoporte != null) || (this.idSoporte != null && !this.idSoporte.equals(other.idSoporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Soporte[ idSoporte=" + idSoporte + " ]";
    }
    
}
