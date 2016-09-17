/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.List;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luisperalta
 */
@Entity
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.id = :id"),
    @NamedQuery(name = "Cliente.findByUsuario", query = "SELECT c FROM Cliente c WHERE c.usuario = :usuario"),
    @NamedQuery(name = "Cliente.findByContrasena", query = "SELECT c FROM Cliente c WHERE c.contrasena = :contrasena"),
    @NamedQuery(name = "Cliente.findByNombreCompleto", query = "SELECT c FROM Cliente c WHERE c.nombreCompleto = :nombreCompleto"),
    @NamedQuery(name = "Cliente.findByDocumentoIdentificacion", query = "SELECT c FROM Cliente c WHERE c.documentoIdentificacion = :documentoIdentificacion"),
    @NamedQuery(name = "Cliente.findByCorreoElectronico", query = "SELECT c FROM Cliente c WHERE c.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "Cliente.findByNoTelefono", query = "SELECT c FROM Cliente c WHERE c.noTelefono = :noTelefono"),
    @NamedQuery(name = "Cliente.findByNoCuenta", query = "SELECT c FROM Cliente c WHERE c.noCuenta = :noCuenta"),
    @NamedQuery(name = "Cliente.findByTipoCuenta", query = "SELECT c FROM Cliente c WHERE c.tipoCuenta = :tipoCuenta")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 5)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 5)
    @Column(name = "contrasena")
    private String contrasena;
    @Size(max = 500)
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Size(max = 200)
    @Column(name = "documento_identificacion")
    private String documentoIdentificacion;
    @Size(max = 200)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Size(max = 200)
    @Column(name = "no_telefono")
    private String noTelefono;
    @Size(max = 200)
    @Column(name = "no_cuenta")
    private String noCuenta;
    @Size(max = 200)
    @Column(name = "tipo_cuenta")
    private String tipoCuenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Remesa> remesaList;

    public Cliente() {
    }

    public Cliente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDocumentoIdentificacion() {
        return documentoIdentificacion;
    }

    public void setDocumentoIdentificacion(String documentoIdentificacion) {
        this.documentoIdentificacion = documentoIdentificacion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNoTelefono() {
        return noTelefono;
    }

    public void setNoTelefono(String noTelefono) {
        this.noTelefono = noTelefono;
    }

    public String getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(String noCuenta) {
        this.noCuenta = noCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    @XmlTransient
    public List<Remesa> getRemesaList() {
        return remesaList;
    }

    public void setRemesaList(List<Remesa> remesaList) {
        this.remesaList = remesaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Cliente[ id=" + id + " ]";
    }
    
}
