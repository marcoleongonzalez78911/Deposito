/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
//import net.proteanit.sql.DbUtils;


/**
 *
 * @author mark
 */
public class ModelUsuarios {
    private Connection conexion;
    public Statement st;
    public ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private  int  id_usuario;
    private String nombre;
    private String tipo_usuario;
    private String password;
    private String fecha;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    public void Conectar(){
    try{
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/depost","root","marko");
        st = conexion.createStatement();
        SeleccionarTodo();
            
        
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 101");
    }
    }//conectar
    
     public void llenarValores(){
    try{
        setId_usuario(rs.getInt("id_usuario"));
        setNombre(rs.getString("nombre"));
        setTipo_usuario(rs.getString("tipo_usuario"));
        setPassword(rs.getString("password"));
        setFecha(rs.getString("fecha"));
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 102");
    }
    }//fin del llenarvalores
    
   public void moverPrimero(){
     try{
       rs.first();
       llenarValores();
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 103");
    }
   
    }//fin de mover primero
    
     public void moverUltimo(){
     try{
       rs.last();  
       llenarValores();
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 104");
    }
   
    }//fin de mover ultimo
     
      public void moverSiguiente(){
     try{
         if(rs.isLast()==false){
             rs.next();
             llenarValores();
         } 
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 105");
    }
   
    }//fin de mover siguiente
    
     public void moverAnterior(){
     try{
         if(rs.isFirst()==false){
             rs.previous();
             llenarValores();
         } 
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 106");
    }
   
    }//fin de mover anterior
     
      public void SeleccionarTodo(){
     try{
         sql = "select * from usuario;";
         ps = conexion.prepareStatement(sql);
         rs = ps.executeQuery();
         moverPrimero();
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 107");
    }
   
    }//fin de mover siguiente
      
    public void Insertar(){
     try{
        sql = "insert into usuario(id_usuario, nombre, tipo_usuario,pasword,fecha)values(?,?,?,?,?);";
        ps = conexion.prepareStatement(sql);
        ps.setInt(1,getId_usuario());
        ps.setString(2,getNombre());
        ps.setString(3,getTipo_usuario());
        ps.setString(4,getPassword());
        ps.setString(5,getFecha());
        ps.executeUpdate();
         Conectar();
         moverPrimero();
         
          
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 108" + ex.getMessage());
    }
    }//fin de insertar 
   
     public void borrar(){
     try{
        sql = "Delete from usuario where id_usuario = ?;";
        ps = conexion.prepareStatement(sql);
        ps.setInt(1,getId_usuario());
        ps.executeUpdate();
        Conectar();
        moverPrimero();
         } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 109");
    }
    }//fin de borrar 
     
     public void actualizar(){
     try{
        sql = "UPDATE usuario SET nombre = ?, tipo_usuario = ?, password = ?, fecha = ?;";
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, getId_usuario());
        ps.setString(2,getNombre());
        ps.setString(3,getTipo_usuario());
        ps.setString(4,getPassword());
        ps.setString(5,getFecha());
        ps.executeUpdate();
        Conectar();
        moverPrimero();
         
          
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 110");
    }
    }//fin de actualizar

   
}///fin del clase de usuarios///
