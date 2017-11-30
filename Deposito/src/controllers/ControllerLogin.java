/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import views.ViewLogin;
import models.ModelLogin;

/**
 *
 * @author mark
 */
public class ControllerLogin {
    ModelLogin modellong;
    ViewLogin viewlong;
    
public ControllerLogin(ModelLogin modellong, ViewLogin viewlong){
    this.modellong = modellong;
    this.viewlong = viewlong;
}//fin del contructor 
    
}//fin de la class
