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
public class ModelCompraC {
    private Connection conexion;
    public Statement st;
    public ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private  int  detalle_compra;
    private String clave_compra;
    private String clave_producto;
    private String cantidad;
    private String total_producto;

    public int getDetalle_compra() {
        return detalle_compra;
    }

    public void setDetalle_compra(int detalle_compra) {
        this.detalle_compra = detalle_compra;
    }

    public String getClave_compra() {
        return clave_compra;
    }

    public void setClave_compra(String clave_compra) {
        this.clave_compra = clave_compra;
    }

    public String getClave_producto() {
        return clave_producto;
    }

    public void setClave_producto(String clave_producto) {
        this.clave_producto = clave_producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getTotal_producto() {
        return total_producto;
    }

    public void setTotal_producto(String total_producto) {
        this.total_producto = total_producto;
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
        setDetalle_compra(rs.getInt("detalle_compra"));
        setClave_compra(rs.getString("clave_compra"));
        setClave_producto(rs.getString("clave_producto"));
        setCantidad(rs.getString("cantidad"));
        setTotal_producto(rs.getString("total_producto"));
        
        
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
         sql = "select * from detalle_compra;";
         ps = conexion.prepareStatement(sql);
         rs = ps.executeQuery();
         
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 107");
    }
   
    }//fin de mover siguiente
    
       public void Insertar(){
     try{
        sql = "insert into venta( clave_compra, clave_producto,cantidad,total_producto)values(?,?,?,?);";
        ps = conexion.prepareStatement(sql);
        ps.setInt(1,getDetalle_compra());
        ps.setString(2,getClave_producto());
        ps.setString(3,getCantidad());
        ps.setString(4,getTotal_producto());
        ps.executeUpdate();
         Conectar();
         moverPrimero();
         
          
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 108" + ex.getMessage());
    }
    }//fin de insertar 
   
     public void borrar(){
     try{
        sql = "Delete from detalle where detalle_compra = ?;";
        ps = conexion.prepareStatement(sql);
        ps.setInt(1,getDetalle_compra());
        ps.executeUpdate();
        Conectar();
        moverPrimero();
         } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 109");
    }
    }//fin de borrar 
     
     public void actualizar(){
     try{
        sql = "UPDATE detalle_compra SET detalle_compra = ?, clave_compra = ?, clave_producto = ?, cantidad = ?,  total_producto = ?;";
        ps = conexion.prepareStatement(sql);
        ps.setInt(1, getDetalle_compra());
        ps.setString(2,getClave_compra());
        ps.setString(3,getClave_producto());
        ps.setString(4,getClave_producto());
        ps.setString(5,getTotal_producto());
        ps.executeUpdate();
        Conectar();
        moverPrimero();
         
          
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 110");
    }
    }//fin de actualizar
    
}//fin de la class
