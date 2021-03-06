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
public class ModelVentas {
    private Connection conexion;
    public Statement st;
    public ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    
    private  String clave_venta;
    private String fecha_venta;
    private String clave_cliente;
    private String total_venta;
    
   /* private String clave_productos;
    private String Total_productos;
    private String Precio_pz;
     String Precio_paquete24;*/

    public String getClave_venta() {
        return clave_venta;
    }

    public void setClave_venta(String clave_venta) {
        this.clave_venta = clave_venta;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getClave_cliente() {
        return clave_cliente;
    }

    public void setClave_cliente(String clave_cliente) {
        this.clave_cliente = clave_cliente;
    }

    public String getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(String total_venta) {
        this.total_venta = total_venta;
    }

    /* public String getClave_productos() {
        return clave_productos;
    }

    public void setClave_productos(String clave_productos) {
        this.clave_productos = clave_productos;
    }

    public String getTotal_productos() {
        return Total_productos;
    }

    public void setTotal_productos(String Total_productos) {
        this.Total_productos = Total_productos;
    }

    public String getPrecio_pz() {
        return Precio_pz;
    }

    public void setPrecio_pz(String Precio_pz) {
        this.Precio_pz = Precio_pz;
    }

    public String getPrecio_paquete24() {
        return Precio_paquete24;
    }

    public void setPrecio_paquete24(String Precio_paquete24) {
        this.Precio_paquete24 = Precio_paquete24;
    }
    
   public void Multiplicacion(){
    this.total_venta = this.Precio_paquete24 * this.Total_productos;
    }*/
    
    
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
        setClave_venta(rs.getString("clave_venta"));
        setFecha_venta(rs.getString("fecha_venta"));
        setClave_cliente(rs.getString("clave_cliente"));
        setTotal_venta(rs.getString("total_venta"));
        
        
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
         sql = "select * from venta;";
         ps = conexion.prepareStatement(sql);
         rs = ps.executeQuery();
         
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 107");
    }
   
    }//fin de mover siguiente
    
       public void Insertar(){
     try{
        sql = "insert into venta(clave_venta, fecha_venta, clave_cliente,total_venta)values(?,?,?,?);";
        ps = conexion.prepareStatement(sql);
        ps.setString(1,getClave_venta());
        ps.setString(2,getFecha_venta());
        ps.setString(3,getClave_cliente());
        ps.setString(4,getTotal_venta());
        ps.executeUpdate();
         Conectar();
         moverPrimero();
         
          
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 108" + ex.getMessage());
    }
    }//fin de insertar 
   
     public void borrar(){
     try{
        sql = "Delete from venta where clave_venta = ?;";
        ps = conexion.prepareStatement(sql);
        ps.setString(1,getClave_venta());
        ps.executeUpdate();
        Conectar();
        moverPrimero();
         } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 109");
    }
    }//fin de borrar 
     
     public void actualizar(){
     try{
        sql = "UPDATE venta SET clave_venta = ?, fecha_venta = ?, clave_cliente = ?, total_venta = ?;";
        ps = conexion.prepareStatement(sql);
        ps.setString(1, getClave_venta());
        ps.setString(2,getFecha_venta());
        ps.setString(3,getClave_cliente());
        ps.setString(4,getTotal_venta());
        ps.executeUpdate();
        Conectar();
        moverPrimero();
         
          
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 110");
    }
    }//fin de actualizar
}//fin de la clase
