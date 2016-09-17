/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import com.entities.enums.RemesaEstado;
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
import javax.persistence.Transient;
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
    private Integer id;
    @Size(max = 5)
    private String usuario;
    @Size(max = 5)
    private String contrasena;
    @Size(max = 500)
    private String nombreReceptor;
    @Size(max = 200)
    private String correoReceptor;
    @Size(max = 200)
    private String dpiReceptor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Double montoUs;
    @Size(max = 10)
    private String estadoRemesa;
    private Cliente cliente;

    public Remesa() {
    }

    public Remesa(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Column(name = "contrasena")
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Column(name = "nombre_receptor")
    public String getNombreReceptor() {
        return nombreReceptor;
    }

    public void setNombreReceptor(String nombreReceptor) {
        this.nombreReceptor = nombreReceptor;
    }

    @Column(name = "correo_receptor")
    public String getCorreoReceptor() {
        return correoReceptor;
    }

    public void setCorreoReceptor(String correoReceptor) {
        this.correoReceptor = correoReceptor;
    }

    @Column(name = "dpi_receptor")
    public String getDpiReceptor() {
        return dpiReceptor;
    }

    public void setDpiReceptor(String dpiReceptor) {
        this.dpiReceptor = dpiReceptor;
    }

    @Column(name = "monto_us")
    public Double getMontoUs() {
        return montoUs;
    }

    public void setMontoUs(Double montoUs) {
        this.montoUs = montoUs;
    }

    @Column(name = "estado_remesa")
    public String getEstadoRemesa() {
        return estadoRemesa;
    }

    public void setEstadoRemesa(String estadoRemesa) {
        this.estadoRemesa = estadoRemesa;
    }

    @JoinColumn(name = "cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
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

    /**
     *
     * @param estado
     * @return
     */
    public String getEstado(String estado) {
        if (estado.toLowerCase().contains("enviada")) {
            return RemesaEstado.ENVIADA.toString();
        }
        if (estado.toLowerCase().contains("recibida")) {
            return RemesaEstado.RECIBIDA.toString();
        }
        if (estado.toLowerCase().contains("cobrada")) {
            return RemesaEstado.COBRADA.toString();
        }
        return RemesaEstado.EN_PROCESO.toString();
    }

    @Override
    public String toString() {
        return "com.entities.Remesa[ id=" + id + " ]";
    }

}
