/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import models.*;
import views.*;
import controllers.*;

/**
 *
 * @author mark
 */
public class Main {
    public static void main(String mar[]){
         ModelCliente modelcli = new ModelCliente();
         ViewCliente   viewcli = new ViewCliente();
         ControllerCliente controller_cli = new ControllerCliente(modelcli, viewcli);
         
          ModelUsuarios modeluser = new ModelUsuarios();
         ViewUsuarios   viewuser = new ViewUsuarios();
         ControllerUsuarios controlleruser = new ControllerUsuarios(modeluser, viewuser);
         
         ModelProducto modelprodu = new ModelProducto();
         ViewProducto   viewprodu = new ViewProducto();
         ControllerProducto controllerprodu = new ControllerProducto(modelprodu, viewprodu);
         
         ModelProveedores modelprove = new ModelProveedores();
         ViewProveedores   viewprove = new ViewProveedores();
         ControllerProveedores controllerprove = new ControllerProveedores(modelprove, viewprove);
         
         ModelLogin modellong = new ModelLogin();
         ViewLogin   viewlong = new ViewLogin();
         ControllerLogin controllerlong = new ControllerLogin(modellong, viewlong);
         
         ModelVentas modelvent = new ModelVentas();
         ViewVentas   viewvent = new ViewVentas();
         ControllerVentas controllervent = new ControllerVentas(modelvent, viewvent);
         
         ModelCompra modelcop = new ModelCompra();
         ViewCompra   viewcop = new ViewCompra();
         ControllerCompra controllercop = new ControllerCompra(modelcop, viewcop);
         
         ModelDeposito modeldepo = new ModelDeposito();
         ViewDeposito viewdepo = new  ViewDeposito();
         Object views[] = new Object[8];
         views[0] = viewcli;
         views[1] = viewuser;
         views[2] = viewprodu;
         views[3] = viewprove;
         views[4] = viewlong;
         views[5] = viewvent;
         views[6] = viewcop;
         views[7] = viewdepo;
         ControllerDeposito controllerdepo = new ControllerDeposito(modeldepo, views);
    }
    
}//fin del main
