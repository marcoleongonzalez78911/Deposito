/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.ModelVentas;
import net.proteanit.sql.DbUtils;
import views.ViewVentas;
/**
 *
 * @author mark
 */
public class ControllerVentas {
    private final ModelVentas modelvent;
   private final ViewVentas viewvent;
    
public ControllerVentas(ModelVentas modelvent, ViewVentas viewvent){
    this.modelvent = modelvent;
    this.viewvent = viewvent;
    
    this.viewvent.jbtn_nuevo.addActionListener(e -> jbtn_nuevo_click());
    this.viewvent.jbtn_agregar.addActionListener(e -> jbtn_agregar_click());
    this.viewvent.jbtn_eliminar.addActionListener(e -> jbtn_borrar_click());
    this.viewvent.jbtn_primero.addActionListener(e -> jbtn_primero_click());
    this.viewvent.jbtn_siguiente.addActionListener(e -> jbtn_siguiente_click());
    this.viewvent.jbtn_anterior.addActionListener(e -> jbtn_anterior_click());
    this.viewvent.jbtn_ultimo.addActionListener(e -> jbtn_ultimo_click());
 
 initView();   

}//fin del constructor //

 public void getValores(){
viewvent.jtf_clave_venta.setText(modelvent.getClave_venta());
viewvent.jtf_fecha_venta.setText(modelvent.getFecha_venta());
viewvent.jtf_clave_cliente.setText(modelvent.getClave_cliente());
viewvent.jtf_total.setText(modelvent.getTotal_venta());


}//fin de getvalores

public void setValores(){
modelvent.setClave_venta(viewvent.jtf_clave_venta.getText());
modelvent.setFecha_venta(viewvent.jtf_fecha_venta.getText());
modelvent.setClave_cliente(viewvent.jtf_clave_cliente.getText());
modelvent.setTotal_venta(viewvent.jtf_total.getText());

}//fin de setvalores

public void jbtn_nuevo_click(){
viewvent.jtf_clave_venta.setText("");
viewvent.jtf_fecha_venta.setText("");
viewvent.jtf_clave_cliente.setText("");
viewvent.jtf_total.setText("");
}//boton nuevo

public void jbtn_agregar_click(){
setValores();
modelvent.Insertar();
tabla();
getValores();

}//boton agregar



public void jbtn_primero_click(){
setValores();
modelvent.moverPrimero();
getValores();

}//boton moverPrimero

public void jbtn_ultimo_click(){
setValores();
modelvent.moverUltimo();
getValores();

}//boton ultimo

public void jbtn_borrar_click(){
setValores();
modelvent.borrar();
tabla();
getValores();

}//boton borrar

public void jbtn_siguiente_click(){
setValores();
modelvent.moverSiguiente();
getValores();

}//boton siguiente

public void jbtn_anterior_click(){
setValores();
modelvent.moverAnterior();
getValores();

}//boton anterior
 public void tabla(){
        
viewvent.jt_ventas.setModel(DbUtils.resultSetToTableModel(modelvent.rs));
}//tabla

public void initView(){
modelvent.Conectar();
tabla();
viewvent.setVisible(true);
modelvent.moverPrimero();
getValores();
}



    
}//fin de la class
