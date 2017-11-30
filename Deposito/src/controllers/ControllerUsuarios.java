/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.ModelUsuarios;
import views.ViewUsuarios;

/**
 *
 * @author mark
 */
public class ControllerUsuarios {
    ModelUsuarios modeluser;
    ViewUsuarios viewuser;
    
public ControllerUsuarios(ModelUsuarios modeluser, ViewUsuarios viewuser){
    this.modeluser = modeluser;
    this.viewuser = viewuser;

}
}//fin de la clase 
