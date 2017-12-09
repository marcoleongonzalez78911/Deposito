/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.ModelVentas;
import views.ViewVentas;
/**
 *
 * @author mark
 */
public class ControllerVentas {
    ModelVentas modelvent;
    ViewVentas viewvent;
    
public ControllerVentas(ModelVentas modelvent, ViewVentas viewvent){
    this.modelvent = modelvent;
    this.viewvent = viewvent;
    

}//fin del constructor //
    
}//fin de la class
