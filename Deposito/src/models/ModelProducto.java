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
public class ModelProducto {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private String clave_producto;
    private String tipo_producto;
    private String contenido;
    private int existencias;
    private String clave_proveedor;
    private String precio_pz;
    private String paquete24;

    public String getClave_producto() {
        return clave_producto;
    }

    public void setClave_producto(String clave_producto) {
        this.clave_producto = clave_producto;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getClave_proveedor() {
        return clave_proveedor;
    }

    public void setClave_proveedor(String clave_proveedor) {
        this.clave_proveedor = clave_proveedor;
    }

    public String getPrecio_pz() {
        return precio_pz;
    }

    public void setPrecio_pz(String precio_pz) {
        this.precio_pz = precio_pz;
    }

    public String getPaquete24() {
        return paquete24;
    }

    public void setPaquete24(String paquete24) {
        this.paquete24 = paquete24;
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
        setClave_producto(rs.getString("clave_producto"));
        setTipo_producto(rs.getString("tipo_producto"));
        setContenido(rs.getString("contenido"));
        setExistencias(rs.getInt("existencias"));
        setClave_proveedor(rs.getString("clave_proveedor"));
        setPrecio_pz(rs.getString("precio_pz"));
        setPaquete24(rs.getString("paquete24"));
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
         sql = "select * from productos;";
         ps = conexion.prepareStatement(sql);
         rs = ps.executeQuery();
         moverPrimero();
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 107");
    }
   
    }//fin de mover siguiente
      
    public void Insertar(){
     try{
        sql = "insert into productos(clave_producto, tipo_producto, contenido,existencias,clave_proveedor,precio_pz,paquete24)values(?,?,?,?,?,?,?);";
        ps = conexion.prepareStatement(sql);
        ps.setString(1,getClave_producto());
        ps.setString(2,getTipo_producto());
        ps.setString(3,getContenido());
        ps.setInt(4,getExistencias());
        ps.setString(5,getClave_proveedor());
        ps.setString(6,getPrecio_pz());
        ps.setString(7,getPaquete24());
        ps.executeUpdate();
         Conectar();
         moverPrimero();
         
          
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 108" + ex.getMessage());
    }
    }//fin de insertar 
   
     public void borrar(){
     try{
        sql = "Delete from productos where clave_producto = ?;";
        ps = conexion.prepareStatement(sql);
        ps.setString(1,getClave_producto());
        ps.executeUpdate();
        Conectar();
        moverPrimero();
         } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 109");
    }
    }//fin de borrar 
     
     public void actualizar(){
     try{
        sql = "UPDATE clientes SET nombre = ?, apellido_paterno = ?, apellido_materno = ?, Telefono = ?;";
        ps = conexion.prepareStatement(sql);
        ps.setString(1,getClave_producto());
        ps.setString(2,getTipo_producto());
        ps.setString(3,getContenido());
        ps.setInt(4,getExistencias());
        ps.setString(5,getClave_proveedor());
        ps.setString(6,getPrecio_pz());
        ps.setString(7,getPaquete24());
        ps.executeUpdate();
        Conectar();
        moverPrimero();
         
          
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 110");
    }
    }//fin de actualizar
    public void buscar(){
    try{
     rs = st.executeQuery("select * from clientes where nombre like '%");
     ps = conexion.prepareStatement(sql);
        ps.setString(1,getClave_producto());
        ps.setString(2,getTipo_producto());
        ps.setString(3,getContenido());
        ps.setInt(4,getExistencias());
        ps.setString(5,getClave_proveedor());
        ps.setString(6,getPrecio_pz());
        ps.setString(7,getPaquete24());
        ps.executeUpdate();
        Conectar(); 
        moverPrimero();
    }catch (SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 100");
    }
    
    } 
}/*fin de la clase ModelProducto*/
