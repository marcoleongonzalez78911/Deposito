/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.ModelProveedores;
import views.ViewProveedores;

/**
 *
 * @author mark
 */
public class ControllerProveedores {
    ModelProveedores modelprove;
    ViewProveedores viewprove;
    
 public ControllerProveedores(ModelProveedores modelprove, ViewProveedores viewprove){
 this.modelprove = modelprove;
 this.viewprove = viewprove;
 
 }
    
}
