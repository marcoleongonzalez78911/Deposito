/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.ModelUsuarios;
import net.proteanit.sql.DbUtils;
import views.ViewUsuarios;

/**
 *
 * @author mark
 */
public class ControllerUsuarios {
    ModelUsuarios modeluser;
    ViewUsuarios viewuser;
    
public ControllerUsuarios(ModelUsuarios modeluser, ViewUsuarios viewuser){
    this.modeluser = modeluser;
    this.viewuser = viewuser;

     this.viewuser.jbtn_primero.addActionListener(e -> jbtn_primero_click());
    this.viewuser.jbtn_siguiente.addActionListener(e -> jbtn_siguiente_click());
    this.viewuser.jbtn_anterior.addActionListener(e -> jbtn_anterior_click());
    this.viewuser.jbtn_ultimo.addActionListener(e -> jbtn_ultimo_click());
    this.viewuser.jbtn_nuevo.addActionListener(e -> jbtn_nuevo_click());
    this.viewuser.jbtn_agregar.addActionListener(e -> jbtn_agregar_click());
    this.viewuser.jbtn_eliminar.addActionListener(e -> jbtn_borrar_click());
    this.viewuser.jbtn_buscar.addActionListener(e -> jbtn_buscar_clic());

 initView();
}

public void getValores(){
viewuser.jtf_id_usuario.setText(""+modeluser.getId_usuario());
viewuser.jtf_nombre.setText(modeluser.getNombre());
viewuser.jtf_tipo_usuario.setText(modeluser.getTipo_usuario());
viewuser.jtf_password.setText(modeluser.getPassword());
viewuser.jtf_fecha.setText(modeluser.getFecha());

}//fin de getvalores

public void setValores(){
modeluser.setId_usuario(Integer.parseInt(viewuser.jtf_id_usuario.getText()));
modeluser.setNombre(viewuser.jtf_nombre.getText());
modeluser.setTipo_usuario(viewuser.jtf_tipo_usuario.getText());
modeluser.setPassword(viewuser.jtf_password.getText());
modeluser.setFecha(viewuser.jtf_fecha.getText());

}//fin de setvalores

public void jbtn_nuevo_click(){
viewuser.jtf_id_usuario.setText("");
viewuser.jtf_nombre.setText("");
viewuser.jtf_tipo_usuario.setText("");
viewuser.jtf_password.setText("");
viewuser.jtf_fecha.setText("");

}//boton nuevo

public void jbtn_agregar_click(){
setValores();
modeluser.Insertar();
tabla();
getValores();

}//boton agragar



public void jbtn_primero_click(){
setValores();
modeluser.moverPrimero();
getValores();

}//boton moverPrimero

public void jbtn_ultimo_click(){
setValores();
modeluser.moverUltimo();
getValores();

}//boton ultimo

public void jbtn_borrar_click(){
setValores();
modeluser.borrar();
tabla();
getValores();

}//boton modificar

public void jbtn_siguiente_click(){
setValores();
modeluser.moverSiguiente();
getValores();

}//boton siguiente

public void jbtn_anterior_click(){
setValores();
modeluser.moverAnterior();
getValores();

}//boton anterior

public void tabla(){
viewuser.jt_usuario.setModel(DbUtils.resultSetToTableModel(modeluser.rs));
}

private void jbtn_buscar_clic(){

   try{
         
           modeluser.rs = modeluser.st.executeQuery("select * from clientes where nombre like '%"+viewuser.jtf_buscar.getText()+"%'");
           tabla();
            
            
        
        } catch (SQLException err){
             
             JOptionPane.showMessageDialog(null,"Error "+err.getMessage());
         }

}


public void initView(){
modeluser.Conectar();
tabla();
viewuser.setVisible(true);
modeluser.moverPrimero();
getValores();
}
}//fin de la clase 
