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


/**
 *
 * @author mark
 */
public class ModelCompra {
    private Connection conexion;
    public Statement st;
    public ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    
     
    private  String clave_compra;
    private String fecha_compra;
    private String clave_proveedor;
    private String total_compra;

    public String getClave_compra() {
        return clave_compra;
    }

    public void setClave_compra(String clave_compra) {
        this.clave_compra = clave_compra;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getClave_proveedor() {
        return clave_proveedor;
    }

    public void setClave_proveedor(String clave_proveedor) {
        this.clave_proveedor = clave_proveedor;
    }

    public String getTotal_compra() {
        return total_compra;
    }

    public void setTotal_compra(String total_compra) {
        this.total_compra = total_compra;
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
        setClave_compra(rs.getString("clave_compra"));
        setFecha_compra(rs.getString("fecha_compra"));
        setClave_proveedor(rs.getString("clave_proveedor"));
        setTotal_compra(rs.getString("total_compra"));
        
        
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
         sql = "select * from compra;";
         ps = conexion.prepareStatement(sql);
         rs = ps.executeQuery();
         
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 107");
    }
   
    }//fin de mover siguiente
    
       public void Insertar(){
     try{
        sql = "insert into venta(clave_compra, fecha_compra, clave_proveedor,total_compra)values(?,?,?,?);";
        ps = conexion.prepareStatement(sql);
        ps.setString(1,getClave_compra());
        ps.setString(2,getFecha_compra());
        ps.setString(3,getClave_compra());
        ps.setString(4,getTotal_compra());
        ps.executeUpdate();
         Conectar();
         moverPrimero();
         
          
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 108" + ex.getMessage());
    }
    }//fin de insertar 
   
     public void borrar(){
     try{
        sql = "Delete from compra where clave_compra = ?;";
        ps = conexion.prepareStatement(sql);
        ps.setString(1,getClave_compra());
        ps.executeUpdate();
        Conectar();
        moverPrimero();
         } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 109");
    }
    }//fin de borrar 
     
     public void actualizar(){
     try{
        sql = "UPDATE compra SET clave_compra = ?, fecha_compra = ?, clave_proveedor = ?, total_compra = ?;";
        ps = conexion.prepareStatement(sql);
        ps.setString(1, getClave_compra());
        ps.setString(2,getFecha_compra());
        ps.setString(3,getClave_proveedor());
        ps.setString(4,getTotal_compra());
        ps.executeUpdate();
        Conectar();
        moverPrimero();
         
          
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 110");
    }
    }//fin de actualizar
    
    
}//fin de la clase
