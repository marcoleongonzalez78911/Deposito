/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.ModelProveedores;
import views.ViewProveedores;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author mark
 */
public class ControllerProveedores {
   private final ModelProveedores modelprove;
   private final  ViewProveedores viewprove;
    
 public ControllerProveedores(ModelProveedores modelprove, ViewProveedores viewprove){
 this.modelprove = modelprove;
 this.viewprove = viewprove;
 
   this.viewprove.jbtn_primero.addActionListener(e -> jbtn_primero_click());
    this.viewprove.jbtn_siguiente.addActionListener(e -> jbtn_siguiente_click());
    this.viewprove.jbtn_anterior.addActionListener(e -> jbtn_anterior_click());
    this.viewprove.jbtn_ultimo.addActionListener(e -> jbtn_ultimo_click());
    this.viewprove.jbtn_nuevo.addActionListener(e -> jbtn_nuevo_click());
    this.viewprove.jbtn_agregar.addActionListener(e -> jbtn_agregar_click());
    this.viewprove.jbtn_eliminar.addActionListener(e -> jbtn_borrar_click());
    this.viewprove.jbtn_buscar.addActionListener(e -> jbtn_buscar_clic());

 initView();
 
 }
 public void getValores(){
viewprove.jtf_clave_proveedor.setText(modelprove.getClave_proveedor());
viewprove.jtf_nombre.setText(modelprove.getNombre());
viewprove.jtf_apellido.setText(modelprove.getApellido());
viewprove.jtf_telefono.setText(modelprove.getTelefono());
viewprove.jtf_compania.setText(modelprove.getCompania());

}//fin de getvalores

public void setValores(){
modelprove.setClave_proveedor(viewprove.jtf_clave_proveedor.getText());
modelprove.setNombre(viewprove.jtf_nombre.getText());
modelprove.setApellido(viewprove.jtf_apellido.getText());
modelprove.setTelefono(viewprove.jtf_telefono.getText());
modelprove.setCompania(viewprove.jtf_compania.getText());
}//fin de setvalores

public void jbtn_nuevo_click(){
viewprove.jtf_clave_proveedor.setText("");
viewprove.jtf_nombre.setText("");
viewprove.jtf_apellido.setText("");
viewprove.jtf_telefono.setText("");
viewprove.jtf_compania.setText("");
}//boton nuevo

public void jbtn_agregar_click(){
setValores();
modelprove.Insertar();
tabla();
getValores();

}//boton agragar



public void jbtn_primero_click(){
setValores();
modelprove.moverPrimero();
getValores();

}//boton moverPrimero

public void jbtn_ultimo_click(){
setValores();
modelprove.moverUltimo();
getValores();

}//boton ultimo

public void jbtn_borrar_click(){
setValores();
modelprove.borrar();
tabla();
getValores();

}//boton modificar

public void jbtn_siguiente_click(){
setValores();
modelprove.moverSiguiente();
getValores();

}//boton siguiente

public void jbtn_anterior_click(){
setValores();
modelprove.moverAnterior();
getValores();

}//boton anterior

public void tabla(){
viewprove.jt_proveedor.setModel(DbUtils.resultSetToTableModel(modelprove.rs));
}
public void initView(){
modelprove.Conectar();
tabla();
viewprove.setVisible(true);
modelprove.moverPrimero();
getValores();
}

private void jbtn_buscar_clic(){

   try{
         
           modelprove.rs = modelprove.st.executeQuery("select * from proveedores where nombre like '%"+viewprove.jtf_buscar.getText()+"%'");
           tabla();
            
            
        
        } catch (SQLException err){
             
             JOptionPane.showMessageDialog(null,"Error en buscar proveedores "+err.getMessage());
         }

}
    
}//fin de la clase
