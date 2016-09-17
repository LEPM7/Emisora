/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicios;

import com.entities.Cliente;
import com.entities.Remesa;
import com.utils.Utils;
import com.utils.Utils.Etiqueta;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author luisperalta
 */
@WebService(serviceName = "EmisoraService")
@Stateless()
public class EmisoraService {

    @PersistenceContext(unitName = "EmisoraPU")
    private EntityManager em;

    @WebMethod(operationName = "RegistrarCliente")
    public String RegistrarCliente(
            @WebParam(name = "usuario") String u,
            @WebParam(name = "contrasena") String c,
            @WebParam(name = "nombre_completo") String n,
            @WebParam(name = "documento_identificacion") String d,
            @WebParam(name = "correo_electronico") String co,
            @WebParam(name = "no_telefono") String nt,
            @WebParam(name = "no_cuenta") String nc,
            @WebParam(name = "tipo_cuenta") String tc) {
        try {
            Cliente cl = new Cliente();
            cl.setUsuario(u);
            cl.setContrasena(c);
            cl.setNombreCompleto(n);
            cl.setDocumentoIdentificacion(d);
            cl.setCorreoElectronico(co);
            cl.setNoTelefono(nt);
            cl.setNoCuenta(nc);
            cl.setTipoCuenta(tc);
            em.persist(cl);
            em.flush();
            return Utils.crearXML(
                    new Etiqueta("RegistrarCliente",
                            new Etiqueta("Exito", 1), new Etiqueta("IdCliente", cl.getId())));
        } catch (Exception a) {
            a.printStackTrace();
            return Utils.crearXML(
                    new Etiqueta("RegistrarCliente",
                            new Etiqueta("Exito", 0), new Etiqueta("Descripcion", "Error de coneccion a la base de datos")));
        }

    }

    @WebMethod(operationName = "RegistarRemesa")
    public String RegistarRemesa(
            @WebParam(name = "usuario") String u,
            @WebParam(name = "contrasena") String c,
            @WebParam(name = "id_cliente_envia") int i,
            @WebParam(name = "nombre_receptor") String n,
            @WebParam(name = "correo_receptor") String co,
            @WebParam(name = "dpi_receptor") String d,
            @WebParam(name = "monto") double m,
            @WebParam(name = "estado_remesa") String e) {

        Cliente cl = em.find(Cliente.class, i);
        if (cl == null) {
            return Utils.crearXML(new Etiqueta("RegistrarRemesa", new Etiqueta("Exito", 0), new Etiqueta("Descripcion", "No se encuentra al cliente")));
        }
        try {
            Remesa r = new Remesa();
            r.setUsuario(u);
            r.setContrasena(c);
            r.setCliente(cl);
            r.setNombreReceptor(n);
            r.setCorreoReceptor(co);
            r.setDpiReceptor(d);
            r.setMontoUs(m);
            r.setEstadoRemesa(r.getEstado(e));
            em.persist(r);
            em.flush();
            return Utils.crearXML(
                    new Etiqueta("RegistarRemesa",
                    new Etiqueta("Exito",1),
                    new Etiqueta("IdRemesa",r.getId()),
                    new Etiqueta("EstadoRemesa",r.getEstadoRemesa())));
        } catch (Exception b) {
            b.printStackTrace();
            return Utils.crearXML(new Etiqueta("RegistarRemesa",
                    new Etiqueta("Exito", 0), new Etiqueta("Descripcion", "Error en la base de datos")));
        }
    }

    @WebMethod(operationName = "CancelarRemesa")
    public String CancelarRemesa(@WebParam(name = "usuario") String u, @WebParam(name = "contrasena") String c,
            @WebParam(name = "id_remesa") int i) {
        return new String();
    }

    @WebMethod(operationName = "ConsultaComisionPorRemesa")
    public String ConsultaComisionPorRemesa() {
        return new String();
    }

    @WebMethod(operationName = "ConsultaCodigoSeguridadVsIdRemesa")
    public String ConsultaCodigoSeguridadVsIdRemesa(
            @WebParam(name = "usuario") String u, @WebParam(name = "contrasena") String c,
            @WebParam(name = "id_remesa") int i, @WebParam(name = "codigo_seguridad") String co) {
        return new String();
    }

    @WebMethod(operationName = "ListarRemesas")
    public String ListarRemesas(
            @WebParam(name = "usuario") String u, @WebParam(name = "contrasena") String c,
            @WebParam(name = "id_remesa") int i, @WebParam(name = "nombre_emisor") String ne,
            @WebParam(name = "nombre_receptor") String nr, @WebParam(name = "monto_q") double mq,
            @WebParam(name = "monto_us") double mu, @WebParam(name = "fecha_envio") String fenv,
            @WebParam(name = "") String fent) {
        return new String();
    }

    @WebMethod(operationName = "ConsultaDeRemesaEspecifica")
    public String ConsultaDeRemesaEspecifica(
            @WebParam(name = "usuario") String u, @WebParam(name = "contrasena") String c,
            @WebParam(name = "id_remesa") int i, @WebParam(name = "nombre_emisor") String ne,
            @WebParam(name = "nombre_receptor") String nr, @WebParam(name = "monto_q") double mq,
            @WebParam(name = "monto_us") double mu, @WebParam(name = "fecha_envio") String fenv,
            @WebParam(name = "") String fent) {
        return new String();
    }

    @WebMethod(operationName = "ObtenerRemesasListas")
    public String ObtenerRemesasListas(
            @WebParam(name = "usuario") String u,
            @WebParam(name = "contrasena") String c,
            @WebParam(name = "id_banco_receptor") int i) {
        
        
    }

//    @WebMethod(operationName = "")     
//    @WebParam(name = "")
}
