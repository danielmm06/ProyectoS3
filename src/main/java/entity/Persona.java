/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByNombre1", query = "SELECT p FROM Persona p WHERE p.nombre1 = :nombre1"),
    @NamedQuery(name = "Persona.findByNombre2", query = "SELECT p FROM Persona p WHERE p.nombre2 = :nombre2"),
    @NamedQuery(name = "Persona.findByApellido1", query = "SELECT p FROM Persona p WHERE p.apellido1 = :apellido1"),
    @NamedQuery(name = "Persona.findByApellido2", query = "SELECT p FROM Persona p WHERE p.apellido2 = :apellido2"),
    @NamedQuery(name = "Persona.findByDocumento", query = "SELECT p FROM Persona p WHERE p.documento = :documento"),
    @NamedQuery(name = "Persona.findByDireccion", query = "SELECT p FROM Persona p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Persona.findByBarrio", query = "SELECT p FROM Persona p WHERE p.barrio = :barrio"),
    @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Persona.findByEmail", query = "SELECT p FROM Persona p WHERE p.email = :email"),
    @NamedQuery(name = "Persona.findByDireccionOfic", query = "SELECT p FROM Persona p WHERE p.direccionOfic = :direccionOfic"),
    @NamedQuery(name = "Persona.findByTelefonoOfic", query = "SELECT p FROM Persona p WHERE p.telefonoOfic = :telefonoOfic"),
    @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Persona.findBySexo", query = "SELECT p FROM Persona p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Persona.findByEstrato", query = "SELECT p FROM Persona p WHERE p.estrato = :estrato")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE1")
    private String nombre1;
    @Size(max = 45)
    @Column(name = "NOMBRE2")
    private String nombre2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "APELLIDO1")
    private String apellido1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "APELLIDO2")
    private String apellido2;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOCUMENTO")
    private Integer documento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "BARRIO")
    private String barrio;
    @Size(max = 45)
    @Column(name = "TELEFONO")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 45)
    @Column(name = "DIRECCION_OFIC")
    private String direccionOfic;
    @Size(max = 45)
    @Column(name = "TELEFONO_OFIC")
    private String telefonoOfic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "SEXO")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ESTRATO")
    private String estrato;
    @JoinColumn(name = "DOCUMENTO", referencedColumnName = "ID_USUARIO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuarios usuarios;
    @JoinColumn(name = "ESTADO_CIVIL", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EstadoCivil estadoCivil;
    @JoinColumn(name = "EXP_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad expCiudad;
    @JoinColumn(name = "INFO_PREGUNTAS", referencedColumnName = "ID_PREGUNTAS")
    @ManyToOne(optional = false)
    private InfoPreguntas infoPreguntas;
    @JoinColumn(name = "CIUDAD_NACIMIENTO", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad ciudadNacimiento;
    @JoinColumn(name = "OFIC_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne
    private Ciudad oficCiudad;
    @JoinColumn(name = "RES_CIUDAD", referencedColumnName = "ID_CIUDAD")
    @ManyToOne(optional = false)
    private Ciudad resCiudad;
    @JoinColumn(name = "TIPODOCUMENTO", referencedColumnName = "ID_DOCUMENTO")
    @ManyToOne(optional = false)
    private TipoDocumento tipodocumento;

    public Persona() {
    }

    public Persona(Integer documento) {
        this.documento = documento;
    }

    public Persona(Integer documento, String nombre1, String apellido1, String apellido2, String direccion, String barrio, String email, Date fechaNacimiento, String sexo, String estrato) {
        this.documento = documento;
        this.nombre1 = nombre1;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.barrio = barrio;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.estrato = estrato;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccionOfic() {
        return direccionOfic;
    }

    public void setDireccionOfic(String direccionOfic) {
        this.direccionOfic = direccionOfic;
    }

    public String getTelefonoOfic() {
        return telefonoOfic;
    }

    public void setTelefonoOfic(String telefonoOfic) {
        this.telefonoOfic = telefonoOfic;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Ciudad getExpCiudad() {
        return expCiudad;
    }

    public void setExpCiudad(Ciudad expCiudad) {
        this.expCiudad = expCiudad;
    }

    public InfoPreguntas getInfoPreguntas() {
        return infoPreguntas;
    }

    public void setInfoPreguntas(InfoPreguntas infoPreguntas) {
        this.infoPreguntas = infoPreguntas;
    }

    public Ciudad getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public void setCiudadNacimiento(Ciudad ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public Ciudad getOficCiudad() {
        return oficCiudad;
    }

    public void setOficCiudad(Ciudad oficCiudad) {
        this.oficCiudad = oficCiudad;
    }

    public Ciudad getResCiudad() {
        return resCiudad;
    }

    public void setResCiudad(Ciudad resCiudad) {
        this.resCiudad = resCiudad;
    }

    public TipoDocumento getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(TipoDocumento tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documento != null ? documento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.documento == null && other.documento != null) || (this.documento != null && !this.documento.equals(other.documento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Persona[ documento=" + documento + " ]";
    }

}
