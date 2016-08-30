/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servicios;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author luisperalta
 */
@WebService(serviceName = "EmisoraService")
@Stateless()
public class EmisoraService {

   
    @WebMethod(operationName = "RegistrarCliente")     
    public String RegistrarCliente(
      @WebParam(name = "usuario")String u , @WebParam(name = "contrasena")String c, 
             @WebParam(name = "nombre_completo")String n,  @WebParam(name = "documento_identificacion")String d, 
              @WebParam(name = "correo_electronico")String co,  @WebParam(name = "no_telefono")String nt, 
               @WebParam(name = "no_cuenta")String nc ,  @WebParam(name = "tipo_cuenta")String tc){
        return new String();
    }
    
    @WebMethod(operationName = "RegistarRemesa")
    public String RegistarRemesa
        (@WebParam(name = "usuario")String u, 
                @WebParam(name = "contrasena")String c, @WebParam(name = "id_cliente_envia")int i, 
                @WebParam(name = "nombre_receptor")String n, @WebParam(name = "correo_receptor")String co, 
                @WebParam(name = "dpi_receptor")String d, @WebParam(name = "monto")double m, 
                @WebParam(name = "tipo_remesa")String t, @WebParam(name = "estado_remesa")String e) {
            
        return new String();
    }
        
    
    @WebMethod(operationName = "CancelarRemesa")
    public String CancelarRemesa
        ( @WebParam(name = "usuario")String u,  @WebParam(name = "contrasena")String c, 
                 @WebParam(name = "id_remesa")int i){        
        return new String();
    }
        
    @WebMethod(operationName = "ConsultaComisionPorRemesa")
    public String ConsultaComisionPorRemesa(){
        return new String();
    }
    
    @WebMethod(operationName = "ConsultaCodigoSeguridadVsIdRemesa")
    public String ConsultaCodigoSeguridadVsIdRemesa(
    @WebParam(name = "usuario")String u, @WebParam(name = "contrasena")String c, 
            @WebParam(name = "id_remesa")int i, @WebParam(name = "codigo_seguridad")String co){
        return new String();
    }
    
    @WebMethod(operationName = "ListarRemesas")
    public String ListarRemesas(
    @WebParam(name = "usuario")String u, @WebParam(name = "contrasena")String c, 
            @WebParam(name = "id_remesa")int i, @WebParam(name = "nombre_emisor")String ne, 
            @WebParam(name = "nombre_receptor")String nr, @WebParam(name = "monto_q")double mq, 
            @WebParam(name = "monto_us")double mu, @WebParam(name = "fecha_envio")String fenv, 
            @WebParam(name = "")String fent){
        return new String();
    }
   
    @WebMethod(operationName = "ConsultaDeRemesaEspecifica")
    public String ConsultaDeRemesaEspecifica(
    @WebParam(name = "usuario")String u, @WebParam(name = "contrasena")String c, 
            @WebParam(name = "id_remesa")int i, @WebParam(name = "nombre_emisor")String ne, 
            @WebParam(name = "nombre_receptor")String nr, @WebParam(name = "monto_q")double mq, 
            @WebParam(name = "monto_us")double mu, @WebParam(name = "fecha_envio")String fenv, 
            @WebParam(name = "")String fent){
        return new String();
    }
    
    @WebMethod(operationName = "ObtenerRemesasListas")
    public String ObtenerRemesasListas(
    @WebParam(name = "usuario")String u, @WebParam(name = "contrasena")String c,
            @WebParam(name = "id_banco_receptor")int i){
        return new String();
    }
    
    
//    @WebMethod(operationName = "")     
//    @WebParam(name = "")
    
    
    
            
}
