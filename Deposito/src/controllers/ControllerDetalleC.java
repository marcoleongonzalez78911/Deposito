/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.ViewDetalleC;
import models.ModelCompraC;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author mark
 */
public class ControllerDetalleC {
    ViewDetalleC viewdc;
    ModelCompraC modeldc;
    
public ControllerDetalleC(ModelCompraC modeldc, ViewDetalleC viewdc){
    this.modeldc = modeldc;
    this.viewdc = viewdc;
    
    this.viewdc.jbtn_nuevo.addActionListener(e -> jbtn_nuevo_click());
    this.viewdc.jbtn_agregar.addActionListener(e -> jbtn_agregar_click());
    this.viewdc.jbtn_eliminar.addActionListener(e -> jbtn_borrar_click());
    this.viewdc.jbtn_primero.addActionListener(e -> jbtn_primero_click());
    this.viewdc.jbtn_siguiente.addActionListener(e -> jbtn_siguiente_click());
    this.viewdc.jbtn_anterior.addActionListener(e -> jbtn_anterior_click());
    this.viewdc.jbtn_ultimo.addActionListener(e -> jbtn_ultimo_click());
 
 initView();   

}//fin del constructor //

 public void getValores(){
viewdc.jtf_id_detalle.setText(""+modeldc.getDetalle_compra());
viewdc.jtf_clave_compra.setText(modeldc.getClave_compra());
viewdc.jtf_clave_producto.setText(modeldc.getClave_producto());
viewdc.jtf_cantidad.setText(modeldc.getCantidad());
viewdc.jtf_total_producto.setText(modeldc.getTotal_producto());


}//fin de getvalores

public void setValores(){
modeldc.setDetalle_compra(Integer.parseInt(viewdc.jtf_id_detalle.getText()));
modeldc.setClave_compra(viewdc.jtf_clave_compra.getText());
modeldc.setClave_producto(viewdc.jtf_clave_producto.getText());
modeldc.setCantidad(viewdc.jtf_cantidad.getText());
modeldc.setTotal_producto(viewdc.jtf_total_producto.getText());

}//fin de setvalores

public void jbtn_nuevo_click(){
viewdc.jtf_id_detalle.setText("");
viewdc.jtf_clave_compra.setText("");
viewdc.jtf_clave_producto.setText("");
viewdc.jtf_cantidad.setText("");
viewdc.jtf_total_producto.setText("");
}//boton nuevo

public void jbtn_agregar_click(){
setValores();
modeldc.Insertar();
tabla();
getValores();

}//boton agregar



public void jbtn_primero_click(){
setValores();
modeldc.moverPrimero();
getValores();

}//boton moverPrimero

public void jbtn_ultimo_click(){
setValores();
modeldc.moverUltimo();
getValores();

}//boton ultimo

public void jbtn_borrar_click(){
setValores();
modeldc.borrar();
tabla();
getValores();

}//boton borrar

public void jbtn_siguiente_click(){
setValores();
modeldc.moverSiguiente();
getValores();

}//boton siguiente

public void jbtn_anterior_click(){
setValores();
modeldc.moverAnterior();
getValores();

}//boton anterior
 public void tabla(){
        
viewdc.jt_compra.setModel(DbUtils.resultSetToTableModel(modeldc.rs));
}//tabla

public void initView(){
modeldc.Conectar();
tabla();
viewdc.setVisible(true);
modeldc.moverPrimero();
getValores();
}
}//fin de la clase
