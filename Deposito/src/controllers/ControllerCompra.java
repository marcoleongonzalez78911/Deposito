/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.ModelCompra;
import net.proteanit.sql.DbUtils;
import views.ViewCompra;
/**
 *
 * @author mark
 */
public final class ControllerCompra {
    
    private final ModelCompra modelcop;
   private final ViewCompra viewcop;
    
public ControllerCompra(ModelCompra modelcop, ViewCompra viewcop){
    this.modelcop = modelcop;
    this.viewcop = viewcop;
    
    this.viewcop.jbtn_nuevo.addActionListener(e -> jbtn_nuevo_click());
    this.viewcop.jbtn_agregar.addActionListener(e -> jbtn_agregar_click());
    this.viewcop.jbtn_eliminar.addActionListener(e -> jbtn_borrar_click());
    this.viewcop.jbtn_primero.addActionListener(e -> jbtn_primero_click());
    this.viewcop.jbtn_siguiente.addActionListener(e -> jbtn_siguiente_click());
    this.viewcop.jbtn_anterior.addActionListener(e -> jbtn_anterior_click());
    this.viewcop.jbtn_ultimo.addActionListener(e -> jbtn_ultimo_click());
 
    initView();
    

}//fin del constructor //

 public void getValores(){
viewcop.jtf_clave_compra.setText(modelcop.getClave_compra());
viewcop.jtf_fecha_compra.setText(modelcop.getFecha_compra());
viewcop.jtf_clave_proveedor.setText(modelcop.getClave_proveedor());
viewcop.jtf_total.setText(modelcop.getTotal_compra());



}//fin de getvalores

public void setValores(){
modelcop.setClave_compra(viewcop.jtf_clave_compra.getText());
modelcop.setFecha_compra(viewcop.jtf_fecha_compra.getText());
modelcop.setClave_proveedor(viewcop.jtf_clave_proveedor.getText());
modelcop.setTotal_compra(viewcop.jtf_total.getText());

}//fin de setvalores

public void jbtn_nuevo_click(){
viewcop.jtf_clave_compra.setText("");
viewcop.jtf_fecha_compra.setText("");
viewcop.jtf_clave_proveedor.setText("");
viewcop.jtf_total.setText("");
}//boton nuevo

public void jbtn_agregar_click(){
setValores();
modelcop.Insertar();
tabla();
getValores();

}//boton agregar



public void jbtn_primero_click(){
setValores();
modelcop.moverPrimero();
getValores();

}//boton moverPrimero

public void jbtn_ultimo_click(){
setValores();
modelcop.moverUltimo();
getValores();

}//boton ultimo

public void jbtn_borrar_click(){
setValores();
modelcop.borrar();
tabla();
getValores();

}//boton borrar

public void jbtn_siguiente_click(){
setValores();
modelcop.moverSiguiente();
getValores();

}//boton siguiente

public void jbtn_anterior_click(){
setValores();
modelcop.moverAnterior();
getValores();

}//boton anterior
 public void tabla(){
        
viewcop.jt_ventas.setModel(DbUtils.resultSetToTableModel(modelcop.rs));
}//tabla

public void initView(){
modelcop.Conectar();
tabla();
viewcop.setVisible(true);
modelcop.moverPrimero();
getValores();
}


    
}// fin del controller
