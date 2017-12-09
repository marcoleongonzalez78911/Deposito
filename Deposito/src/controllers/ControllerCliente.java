/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.ModelCliente;
import net.proteanit.sql.DbUtils;
import views.ViewCliente;

/**
 *
 * @author mark
 */
public class ControllerCliente {
    private final  ModelCliente modelcli;
    private final  ViewCliente viewcli;
    
    
public ControllerCliente(ModelCliente modelcli, ViewCliente viewcli){
     this.modelcli = modelcli;
    this.viewcli = viewcli;
    
    this.viewcli.jbtn_primero.addActionListener(e -> jbtn_primero_click());
    this.viewcli.jbtn_siguiente.addActionListener(e -> jbtn_siguiente_click());
    this.viewcli.jbtn_anterior.addActionListener(e -> jbtn_anterior_click());
    this.viewcli.jbtn_ultimo.addActionListener(e -> jbtn_ultimo_click());
    this.viewcli.jbtn_nuevo.addActionListener(e -> jbtn_nuevo_click());
    this.viewcli.jbtn_agregar.addActionListener(e -> jbtn_agregar_click());
    this.viewcli.jbtn_eliminar.addActionListener(e -> jbtn_borrar_click());
    this.viewcli.jbtn_buscar.addActionListener(e -> jbtn_buscar_clic());

 initView();
}
 public void getValores(){
viewcli.jtf_clave_cliente.setText(modelcli.getClave_cliente());
viewcli.jtf_nombre.setText(modelcli.getNombre());
viewcli.jtf_apellido_paterno.setText(modelcli.getApellido_paterno());
viewcli.jtf_apellido_materno.setText(modelcli.getApellido_materno());
viewcli.jtf_telefono.setText(modelcli.getTelefono());

}//fin de getvalores

public void setValores(){
modelcli.setClave_cliente(viewcli.jtf_clave_cliente.getText());
modelcli.setNombre(viewcli.jtf_nombre.getText());
modelcli.setApellido_paterno(viewcli.jtf_apellido_paterno.getText());
modelcli.setApellido_materno(viewcli.jtf_apellido_materno.getText());
modelcli.setTelefono(viewcli.jtf_telefono.getText());
}//fin de setvalores

public void jbtn_nuevo_click(){
viewcli.jtf_clave_cliente.setText("");
viewcli.jtf_nombre.setText("");
viewcli.jtf_apellido_paterno.setText("");
viewcli.jtf_apellido_materno.setText("");
viewcli.jtf_telefono.setText("");
}//boton nuevo

public void jbtn_agregar_click(){
setValores();
modelcli.Insertar();
tabla();
getValores();

}//boton agragar



public void jbtn_primero_click(){
setValores();
modelcli.moverPrimero();
getValores();

}//boton moverPrimero

public void jbtn_ultimo_click(){
setValores();
modelcli.moverUltimo();
getValores();

}//boton ultimo

public void jbtn_borrar_click(){
setValores();
modelcli.borrar();
tabla();
getValores();

}//boton modificar

public void jbtn_siguiente_click(){
setValores();
modelcli.moverSiguiente();
getValores();

}//boton siguiente

public void jbtn_anterior_click(){
setValores();
modelcli.moverAnterior();
getValores();

}//boton anterior
 public void tabla(){
        
viewcli.jt_cliente.setModel(DbUtils.resultSetToTableModel(modelcli.rs));
}//tabla

public void initView(){
modelcli.Conectar();
tabla();
viewcli.setVisible(true);
modelcli.moverPrimero();
getValores();
}

private void jbtn_buscar_clic(){

   try{
         
           modelcli.rs = modelcli.st.executeQuery("select * from clientes where nombre like '%"+viewcli.jtf_buscar.getText()+"%'");
           tabla();
            
            
        
        } catch (SQLException err){
             
             JOptionPane.showMessageDialog(null,"Error "+err.getMessage());
         }

}
    
}//fin de la class
