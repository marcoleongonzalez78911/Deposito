/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.ViewProducto;
import models.ModelProducto;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author mark
 */
public class ControllerProducto {
    ModelProducto modelprodu;
    ViewProducto viewprodu;
    
public ControllerProducto(ModelProducto modelprodu, ViewProducto viewprodu){
    this.modelprodu = modelprodu;
    this.viewprodu = viewprodu;
    
       
    this.viewprodu.jbtn_primero.addActionListener(e -> jbtn_primero_click());
    this.viewprodu.jbtn_siguiente.addActionListener(e -> jbtn_siguiente_click());
    this.viewprodu.jbtn_anterior.addActionListener(e -> jbtn_anterior_click());
    this.viewprodu.jbtn_ultimo.addActionListener(e -> jbtn_ultimo_click());
    this.viewprodu.jbtn_nuevo.addActionListener(e -> jbtn_nuevo_click());
    this.viewprodu.jbtn_agregar.addActionListener(e -> jbtn_agregar_click());
    this.viewprodu.jbtn_eliminar.addActionListener(e -> jbtn_borrar_click());

 initView();
}//fin del constructor
public void getValores(){
viewprodu.jtf_clave_producto.setText(modelprodu.getClave_producto());
viewprodu.jtf_tipo_producto.setText(modelprodu.getTipo_producto());
viewprodu.jtf_contenido.setText(modelprodu.getContenido());
viewprodu.jtf_existencias.setText(""+modelprodu.getExistencias());
viewprodu.jtf_clave_proveedor.setText(modelprodu.getClave_proveedor());
viewprodu.jtf_precio_pz.setText(modelprodu.getPrecio_pz());
viewprodu.jtf_paquete24.setText(modelprodu.getPaquete24());

}//fin de getvalores

public void setValores(){
modelprodu.setClave_producto(viewprodu.jtf_clave_producto.getText());
modelprodu.setTipo_producto(viewprodu.jtf_tipo_producto.getText());
modelprodu.setContenido(viewprodu.jtf_contenido.getText());
modelprodu.setExistencias(Integer.parseInt(viewprodu.jtf_existencias.getText()));
modelprodu.setClave_proveedor(viewprodu.jtf_clave_proveedor.getText());
modelprodu.setPrecio_pz(viewprodu.jtf_precio_pz.getText());
modelprodu.setPaquete24(viewprodu.jtf_paquete24.getText());
}//fin de setvalores

public void jbtn_nuevo_click(){
viewprodu.jtf_clave_producto.setText("");
viewprodu.jtf_tipo_producto.setText("");
viewprodu.jtf_contenido.setText("");
viewprodu.jtf_existencias.setText("");
viewprodu.jtf_clave_proveedor.setText("");
viewprodu.jtf_precio_pz.setText("");
viewprodu.jtf_paquete24.setText("");
}//boton nuevo

public void jbtn_agregar_click(){
setValores();
modelprodu.Insertar();
tabla();
getValores();

}//boton agragar



public void jbtn_primero_click(){
setValores();
modelprodu.moverPrimero();
getValores();

}//boton moverPrimero

public void jbtn_ultimo_click(){
setValores();
modelprodu.moverUltimo();
getValores();

}//boton ultimo

public void jbtn_borrar_click(){
setValores();
modelprodu.borrar();
tabla();
getValores();

}//boton modificar

public void jbtn_siguiente_click(){
setValores();
modelprodu.moverSiguiente();
getValores();

}//boton siguiente

public void jbtn_anterior_click(){
setValores();
modelprodu.moverAnterior();
getValores();

}//boton anterior

 public void tabla(){
viewprodu.jt_productos.setModel(DbUtils.resultSetToTableModel(modelprodu.rs));
}//tabla


public void initView(){
modelprodu.Conectar();
tabla();
viewprodu.setVisible(true);
modelprodu.moverPrimero();
getValores();
}
}//fin de la clase 
