/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luisperalta
 */
@Entity
@Table(name = "REMESA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Remesa.findAll", query = "SELECT r FROM Remesa r"),
    @NamedQuery(name = "Remesa.findById", query = "SELECT r FROM Remesa r WHERE r.id = :id"),
    @NamedQuery(name = "Remesa.findByUsuario", query = "SELECT r FROM Remesa r WHERE r.usuario = :usuario"),
    @NamedQuery(name = "Remesa.findByContrasena", query = "SELECT r FROM Remesa r WHERE r.contrasena = :contrasena"),
    @NamedQuery(name = "Remesa.findByNombreReceptor", query = "SELECT r FROM Remesa r WHERE r.nombreReceptor = :nombreReceptor"),
    @NamedQuery(name = "Remesa.findByCorreoReceptor", query = "SELECT r FROM Remesa r WHERE r.correoReceptor = :correoReceptor"),
    @NamedQuery(name = "Remesa.findByDpiReceptor", query = "SELECT r FROM Remesa r WHERE r.dpiReceptor = :dpiReceptor"),
    @NamedQuery(name = "Remesa.findByMontoUs", query = "SELECT r FROM Remesa r WHERE r.montoUs = :montoUs"),
    @NamedQuery(name = "Remesa.findByEstadoRemesa", query = "SELECT r FROM Remesa r WHERE r.estadoRemesa = :estadoRemesa")})
public class Remesa implements Serializable {

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
    @Column(name = "nombre_receptor")
    private String nombreReceptor;
    @Size(max = 200)
    @Column(name = "correo_receptor")
    private String correoReceptor;
    @Size(max = 200)
    @Column(name = "dpi_receptor")
    private String dpiReceptor;
    @Column(name = "monto_us")
    private Long montoUs;
    @Size(max = 10)
    @Column(name = "estado_remesa")
    private String estadoRemesa;
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente cliente;

    public Remesa() {
    }

    public Remesa(Integer id) {
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

    public String getNombreReceptor() {
        return nombreReceptor;
    }

    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }

    public String getCorreoReceptor() {
        return correoReceptor;
    }

    public void setCorreoReceptor(String correoReceptor) {
        this.correoReceptor = correoReceptor;
    }

    public String getDpiReceptor() {
        return dpiReceptor;
    }

    public void setDpiReceptor(String dpiReceptor) {
        this.dpiReceptor = dpiReceptor;
    }

    public Long getMontoUs() {
        return montoUs;
    }

    public void setMontoUs(Long montoUs) {
        this.montoUs = montoUs;
    }

    public String getEstadoRemesa() {
        return estadoRemesa;
    }

    public void setEstadoRemesa(String estadoRemesa) {
        this.estadoRemesa = estadoRemesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        if (!(object instanceof Remesa)) {
            return false;
        }
        Remesa other = (Remesa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Remesa[ id=" + id + " ]";
    }
    
}
