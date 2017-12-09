/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import views.ViewCliente;
import views.*;
import models.ModelDeposito;

/**
 *
 * @author mark
 */
public class ControllerDeposito {
    ModelDeposito  modeldepo;
    ViewCliente viewcli;
    ViewUsuarios viewuser;
    ViewProveedores viewprove;
    ViewProducto viewprodu;
    ViewDeposito viewdepo;
    ViewLogin viewlong;
    ViewVentas viewvent;
    ControllerCliente controllercli;
    ControllerProducto controllerprodu;
    ControllerProveedores controllerprove;
    ControllerUsuarios controlleruser;
    ControllerVentas controllervent;
    
     public ControllerDeposito(ModelDeposito modeldepo,Object views[]){
    this.modeldepo = modeldepo;
    this.viewdepo = (ViewDeposito) views[6];
    this.viewcli = (ViewCliente) views[0];
    this.viewuser =(ViewUsuarios) views[1];
    this.viewprodu = (ViewProducto) views[2];
    this.viewprove = (ViewProveedores) views[3];
    this.viewlong = (ViewLogin) views[4];
    this.viewvent = (ViewVentas) views[5];
    
    
     viewdepo.jmi_cliente.addActionListener(e -> jmi_clienteActionPerformed());
     viewdepo.jmi_usuarios.addActionListener(e -> jmi_usuariosActionPerformed());
     viewdepo.jmi_producto.addActionListener(e -> jmi_productoActionPerformed());
     viewdepo.jmi_proveedor.addActionListener(e -> jmi_proveedorActionPerformed());
     viewdepo.jmi_login.addActionListener(e -> jmi_loginActionPerformed());
     viewdepo.jmi_salir.addActionListener(e -> salir_click());
     viewdepo.jmi_venta.addActionListener(e-> jmi_ventaActionPerformed());
     initView();
     }
     
      public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewdepo.jmi_cliente)
            jmi_clienteActionPerformed();
        if(e.getSource()==viewdepo.jmi_usuarios)
            jmi_usuariosActionPerformed();
        if(e.getSource()==viewdepo.jmi_proveedor)
            jmi_proveedorActionPerformed();
        if(e.getSource()==viewdepo.jmi_producto)
            jmi_productoActionPerformed();
        if(e.getSource()==viewdepo.jmi_login)
            jmi_loginActionPerformed();
        if(e.getSource()==viewdepo.jmi_venta)
            jmi_ventaActionPerformed();
      }
      public void jmi_ventaActionPerformed(){
        this.viewdepo.setContentPane(viewvent);
        this.viewdepo.revalidate();
        this.viewdepo.repaint();
       }
      public void jmi_loginActionPerformed(){
        this.viewdepo.setContentPane(viewlong);
        this.viewdepo.revalidate();
        this.viewdepo.repaint();
       }
      
       public void jmi_clienteActionPerformed(){
        this.viewdepo.setContentPane(viewcli);
        this.viewdepo.revalidate();
        this.viewdepo.repaint();
       }
       
         public void jmi_usuariosActionPerformed(){
        this.viewdepo.setContentPane(viewuser);
        this.viewdepo.revalidate();
        this.viewdepo.repaint();
       }
        public void jmi_proveedorActionPerformed(){
        this.viewdepo.setContentPane(viewprove);
        this.viewdepo.revalidate();
        this.viewdepo.repaint();
       }
        public void jmi_productoActionPerformed(){
        this.viewdepo.setContentPane(viewprodu);
        this.viewdepo.revalidate();
        this.viewdepo.repaint();
       }
       
         private void initView(){
       this.viewdepo.setLocationRelativeTo(null);
       this.viewdepo.setVisible(true);
    }
     
    private void salir_click(){
        System.exit(0);
    }
     
}// fin de la class
