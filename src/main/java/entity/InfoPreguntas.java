/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "info_preguntas")
@NamedQueries({
    @NamedQuery(name = "InfoPreguntas.findAll", query = "SELECT i FROM InfoPreguntas i")})
public class InfoPreguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
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
    @Size(max = 45)
    @Column(name = "FECHA_LECTURA")
    private String fechaLectura;
    @Size(max = 45)
    @Column(name = "COMENTARIOS")
    private String comentarios;
    @Lob
    @Column(name = "VALIDACION_PREGUNTAS")
    private byte[] validacionPreguntas;
    @JoinColumn(name = "EMP_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne
    private Ciudad empCiudad;
    @JoinColumn(name = "INFO_ACADEMICA", referencedColumnName = "ID_INFO_ACADEMICA")
    @ManyToOne(optional = false)
    private InfoAcademica infoAcademica;
    @JoinColumn(name = "INFO_IDIOMAS", referencedColumnName = "ID_IDIOMAS")
    @ManyToOne(optional = false)
    private InfoIdiomas infoIdiomas;
    @JoinColumn(name = "INFO_LABORAL", referencedColumnName = "ID_LABORAL")
    @ManyToOne
    private InfoLaboral infoLaboral;
    @JoinColumn(name = "SOPORTE", referencedColumnName = "ID_SOPORTE")
    @ManyToOne(optional = false)
    private Soporte soporte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "infoPreguntas")
    private Set<Persona> personaSet;

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

    public String getFechaLectura() {
        return fechaLectura;
    }

    public void setFechaLectura(String fechaLectura) {
        this.fechaLectura = fechaLectura;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public byte[] getValidacionPreguntas() {
        return validacionPreguntas;
    }

    public void setValidacionPreguntas(byte[] validacionPreguntas) {
        this.validacionPreguntas = validacionPreguntas;
    }

    public Ciudad getEmpCiudad() {
        return empCiudad;
    }

    public void setEmpCiudad(Ciudad empCiudad) {
        this.empCiudad = empCiudad;
    }

    public InfoAcademica getInfoAcademica() {
        return infoAcademica;
    }

    public void setInfoAcademica(InfoAcademica infoAcademica) {
        this.infoAcademica = infoAcademica;
    }

    public InfoIdiomas getInfoIdiomas() {
        return infoIdiomas;
    }

    public void setInfoIdiomas(InfoIdiomas infoIdiomas) {
        this.infoIdiomas = infoIdiomas;
    }

    public InfoLaboral getInfoLaboral() {
        return infoLaboral;
    }

    public void setInfoLaboral(InfoLaboral infoLaboral) {
        this.infoLaboral = infoLaboral;
    }

    public Soporte getSoporte() {
        return soporte;
    }

    public void setSoporte(Soporte soporte) {
        this.soporte = soporte;
    }

    public Set<Persona> getPersonaSet() {
        return personaSet;
    }

    public void setPersonaSet(Set<Persona> personaSet) {
        this.personaSet = personaSet;
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
