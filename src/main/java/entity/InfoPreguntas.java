/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author niari
 */
@Entity
@Table(name = "info_preguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfoPreguntas.findAll", query = "SELECT i FROM InfoPreguntas i"),
    @NamedQuery(name = "InfoPreguntas.findByIdPreguntas", query = "SELECT i FROM InfoPreguntas i WHERE i.idPreguntas = :idPreguntas"),
    @NamedQuery(name = "InfoPreguntas.findByEmpresa", query = "SELECT i FROM InfoPreguntas i WHERE i.empresa = :empresa"),
    @NamedQuery(name = "InfoPreguntas.findByTipoEmpresa", query = "SELECT i FROM InfoPreguntas i WHERE i.tipoEmpresa = :tipoEmpresa"),
    @NamedQuery(name = "InfoPreguntas.findByCargo", query = "SELECT i FROM InfoPreguntas i WHERE i.cargo = :cargo"),
    @NamedQuery(name = "InfoPreguntas.findByEmpDireccion", query = "SELECT i FROM InfoPreguntas i WHERE i.empDireccion = :empDireccion"),
    @NamedQuery(name = "InfoPreguntas.findByEmpTelefono", query = "SELECT i FROM InfoPreguntas i WHERE i.empTelefono = :empTelefono"),
    @NamedQuery(name = "InfoPreguntas.findByExistenciaPrograma", query = "SELECT i FROM InfoPreguntas i WHERE i.existenciaPrograma = :existenciaPrograma"),
    @NamedQuery(name = "InfoPreguntas.findByExpeLaborFunciones", query = "SELECT i FROM InfoPreguntas i WHERE i.expeLaborFunciones = :expeLaborFunciones"),
    @NamedQuery(name = "InfoPreguntas.findByRazones", query = "SELECT i FROM InfoPreguntas i WHERE i.razones = :razones"),
    @NamedQuery(name = "InfoPreguntas.findByFinPrestamo", query = "SELECT i FROM InfoPreguntas i WHERE i.finPrestamo = :finPrestamo"),
    @NamedQuery(name = "InfoPreguntas.findByFinAuxEmpresarial", query = "SELECT i FROM InfoPreguntas i WHERE i.finAuxEmpresarial = :finAuxEmpresarial"),
    @NamedQuery(name = "InfoPreguntas.findByFinRecPropios", query = "SELECT i FROM InfoPreguntas i WHERE i.finRecPropios = :finRecPropios"),
    @NamedQuery(name = "InfoPreguntas.findByFinBeca", query = "SELECT i FROM InfoPreguntas i WHERE i.finBeca = :finBeca"),
    @NamedQuery(name = "InfoPreguntas.findByEgresadoUnillanos", query = "SELECT i FROM InfoPreguntas i WHERE i.egresadoUnillanos = :egresadoUnillanos"),
    @NamedQuery(name = "InfoPreguntas.findByFechaFormulario", query = "SELECT i FROM InfoPreguntas i WHERE i.fechaFormulario = :fechaFormulario"),
    @NamedQuery(name = "InfoPreguntas.findByFechaLectura", query = "SELECT i FROM InfoPreguntas i WHERE i.fechaLectura = :fechaLectura"),
    @NamedQuery(name = "InfoPreguntas.findByComentarios", query = "SELECT i FROM InfoPreguntas i WHERE i.comentarios = :comentarios"),
    @NamedQuery(name = "InfoPreguntas.findByValidacionPreguntas", query = "SELECT i FROM InfoPreguntas i WHERE i.validacionPreguntas = :validacionPreguntas")})
public class InfoPreguntas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PREGUNTAS")
    private Integer idPreguntas;
    @Size(max = 45)
    @Column(name = "EMPRESA")
    private String empresa;
    @Size(max = 45)
    @Column(name = "TIPO_EMPRESA")
    private String tipoEmpresa;
    @Size(max = 45)
    @Column(name = "CARGO")
    private String cargo;
    @Size(max = 45)
    @Column(name = "EMP_DIRECCION")
    private String empDireccion;
    @Size(max = 45)
    @Column(name = "EMP_TELEFONO")
    private String empTelefono;
    @Size(max = 45)
    @Column(name = "EXISTENCIA_PROGRAMA")
    private String existenciaPrograma;
    @Size(max = 300)
    @Column(name = "EXPE_LABOR_FUNCIONES")
    private String expeLaborFunciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "RAZONES")
    private String razones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "FIN_PRESTAMO")
    private String finPrestamo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "FIN_AUX_EMPRESARIAL")
    private String finAuxEmpresarial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "FIN_REC_PROPIOS")
    private String finRecPropios;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "FIN_BECA")
    private String finBeca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EGRESADO_UNILLANOS")
    private String egresadoUnillanos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_FORMULARIO")
    @Temporal(TemporalType.DATE)
    private Date fechaFormulario;
    @Column(name = "FECHA_LECTURA")
    @Temporal(TemporalType.DATE)
    private Date fechaLectura;
    @Size(max = 45)
    @Column(name = "COMENTARIOS")
    private String comentarios;
    @Column(name = "VALIDACION_PREGUNTAS")
    private Integer validacionPreguntas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPreguntas")
    private Set<InfoIdiomas> infoIdiomasSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPreguntas")
    private Set<InfoLaboral> infoLaboralSet;
    @JoinColumn(name = "EMP_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne
    private Ciudad empCiudad;
    @JoinColumn(name = "ID_PREGUNTAS", referencedColumnName = "DOCUMENTO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPreguntas")
    private Set<InfoAcademica> infoAcademicaSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPreguntas")
    private Set<Cabecera> cabeceraSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPreguntas")
    private Set<Soporte> soporteSet;

    public InfoPreguntas() {
    }

    public InfoPreguntas(Integer idPreguntas) {
        this.idPreguntas = idPreguntas;
    }

    public InfoPreguntas(Integer idPreguntas, String razones, String finPrestamo, String finAuxEmpresarial, String finRecPropios, String finBeca, String egresadoUnillanos, Date fechaFormulario) {
        this.idPreguntas = idPreguntas;
        this.razones = razones;
        this.finPrestamo = finPrestamo;
        this.finAuxEmpresarial = finAuxEmpresarial;
        this.finRecPropios = finRecPropios;
        this.finBeca = finBeca;
        this.egresadoUnillanos = egresadoUnillanos;
        this.fechaFormulario = fechaFormulario;
    }

    public Integer getIdPreguntas() {
        return idPreguntas;
    }

    public void setIdPreguntas(Integer idPreguntas) {
        this.idPreguntas = idPreguntas;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmpDireccion() {
        return empDireccion;
    }

    public void setEmpDireccion(String empDireccion) {
        this.empDireccion = empDireccion;
    }

    public String getEmpTelefono() {
        return empTelefono;
    }

    public void setEmpTelefono(String empTelefono) {
        this.empTelefono = empTelefono;
    }

    public String getExistenciaPrograma() {
        return existenciaPrograma;
    }

    public void setExistenciaPrograma(String existenciaPrograma) {
        this.existenciaPrograma = existenciaPrograma;
    }

    public String getExpeLaborFunciones() {
        return expeLaborFunciones;
    }

    public void setExpeLaborFunciones(String expeLaborFunciones) {
        this.expeLaborFunciones = expeLaborFunciones;
    }

    public String getRazones() {
        return razones;
    }

    public void setRazones(String razones) {
        this.razones = razones;
    }

    public String getFinPrestamo() {
        return finPrestamo;
    }

    public void setFinPrestamo(String finPrestamo) {
        this.finPrestamo = finPrestamo;
    }

    public String getFinAuxEmpresarial() {
        return finAuxEmpresarial;
    }

    public void setFinAuxEmpresarial(String finAuxEmpresarial) {
        this.finAuxEmpresarial = finAuxEmpresarial;
    }

    public String getFinRecPropios() {
        return finRecPropios;
    }

    public void setFinRecPropios(String finRecPropios) {
        this.finRecPropios = finRecPropios;
    }

    public String getFinBeca() {
        return finBeca;
    }

    public void setFinBeca(String finBeca) {
        this.finBeca = finBeca;
    }

    public String getEgresadoUnillanos() {
        return egresadoUnillanos;
    }

    public void setEgresadoUnillanos(String egresadoUnillanos) {
        this.egresadoUnillanos = egresadoUnillanos;
    }

    public Date getFechaFormulario() {
        return fechaFormulario;
    }

    public void setFechaFormulario(Date fechaFormulario) {
        this.fechaFormulario = fechaFormulario;
    }

    public Date getFechaLectura() {
        return fechaLectura;
    }

    public void setFechaLectura(Date fechaLectura) {
        this.fechaLectura = fechaLectura;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Integer getValidacionPreguntas() {
        return validacionPreguntas;
    }

    public void setValidacionPreguntas(Integer validacionPreguntas) {
        this.validacionPreguntas = validacionPreguntas;
    }

    @XmlTransient
    public Set<InfoIdiomas> getInfoIdiomasSet() {
        return infoIdiomasSet;
    }

    public void setInfoIdiomasSet(Set<InfoIdiomas> infoIdiomasSet) {
        this.infoIdiomasSet = infoIdiomasSet;
    }

    @XmlTransient
    public Set<InfoLaboral> getInfoLaboralSet() {
        return infoLaboralSet;
    }

    public void setInfoLaboralSet(Set<InfoLaboral> infoLaboralSet) {
        this.infoLaboralSet = infoLaboralSet;
    }

    public Ciudad getEmpCiudad() {
        return empCiudad;
    }

    public void setEmpCiudad(Ciudad empCiudad) {
        this.empCiudad = empCiudad;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @XmlTransient
    public Set<InfoAcademica> getInfoAcademicaSet() {
        return infoAcademicaSet;
    }

    public void setInfoAcademicaSet(Set<InfoAcademica> infoAcademicaSet) {
        this.infoAcademicaSet = infoAcademicaSet;
    }

    @XmlTransient
    public Set<Cabecera> getCabeceraSet() {
        return cabeceraSet;
    }

    public void setCabeceraSet(Set<Cabecera> cabeceraSet) {
        this.cabeceraSet = cabeceraSet;
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
        hash += (idPreguntas != null ? idPreguntas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoPreguntas)) {
            return false;
        }
        InfoPreguntas other = (InfoPreguntas) object;
        if ((this.idPreguntas == null && other.idPreguntas != null) || (this.idPreguntas != null && !this.idPreguntas.equals(other.idPreguntas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.InfoPreguntas[ idPreguntas=" + idPreguntas + " ]";
    }
    
}
