/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builtBudget.autentificacion.com;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author andresmalagueno
 */

@ManagedBean
@RequestScoped
public class AutentificacionBeans {

   
    private String usuario;
    private String password;
    public final static String Key_usuario="auten_usuario";
    
    public AutentificacionBeans() {
    }
    
    
    
    //Meodo que ejecuta la accion de login 
    public void autentificar(ActionEvent e) throws IOException {
    
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        String url = "";
        
        if(esAdmin(usuario,password)==true){
            
            url = extContext.encodeActionURL( context.getApplication().getViewHandler().getActionURL(context, "/principal/home"));
            extContext.getSessionMap().put(Key_usuario,"administrador");
            extContext.redirect(url);
            
        
        }
        
        
        
        
        if(esUsuario(usuario,password)==true){
            
            url = extContext.encodeActionURL( context.getApplication().getViewHandler().getActionURL(context, "/principal/home"));
            extContext.getSessionMap().put(Key_usuario,"usuario");
            extContext.redirect(url);
            
        
        }
        
        FacesContext.getCurrentInstance().addMessage("",new FacesMessage(FacesMessage.SEVERITY_INFO,"USUARIO O CLAVE INCORRECTA", ""));
    
    
    }
    
    
    public boolean esAdmin(String usuario,String password){
        
        boolean respuesta=false;
        if (usuario.equals("andres")&&password.equals("123456")){
        
            respuesta=true;
        }else{
            respuesta=false;
        
        }
        return respuesta;
    
    }
    
    public boolean esUsuario(String usuario,String password){
        
        boolean respuesta=false;
        if (usuario.equals("usuario")&&password.equals("123456")){
        
            respuesta=true;
        }else{
            respuesta=false;
        
        }
        return respuesta;
    
    }
    
    
    
    
    
    
    //get and set metodos

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pasword) {
        this.password = pasword;
    }
    
    
    
    
    
}
