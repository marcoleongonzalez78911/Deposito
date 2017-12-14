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
import net.proteanit.sql.DbUtils;

/**
 *
 * @author mark
 */
public class ModelProveedores {
    private Connection conexion;
    public Statement st;
    public ResultSet rs;
    private PreparedStatement ps;
    private String sql;
   
    
    private  String clave_proveedor;
    private String nombre;
    private String apellido;
    private String telefono;
    private String compania;

    public String getClave_proveedor() {
        return clave_proveedor;
    }

    public void setClave_proveedor(String clave_proveedor) {
        this.clave_proveedor = clave_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
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
        setClave_proveedor(rs.getString("clave_proveedor"));
        setNombre(rs.getString("nombre"));
        setApellido(rs.getString("apellido"));
        setTelefono(rs.getString("telefono"));
        setCompania(rs.getString("Compañia"));
        
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
         sql = "select * from proveedores;";
         ps = conexion.prepareStatement(sql);
         rs = ps.executeQuery();
        
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 107");
    }
   
    }//fin de mover siguiente
      
    public void Insertar(){
     try{
        sql = "insert into proveedores(clave_proveedor, nombre, apellido,telefono,Compañia)values(?,?,?,?,?);";
        ps = conexion.prepareStatement(sql);
        ps.setString(1,getClave_proveedor());
        ps.setString(2,getNombre());
        ps.setString(3,getApellido());
        ps.setString(4,getTelefono());
         ps.setString(5,getCompania());
        ps.executeUpdate();
         Conectar();
         moverPrimero();
         
          
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 108" + ex.getMessage());
    }
    }//fin de insertar 
   
     public void borrar(){
     try{
        sql = "Delete from proveedores where clave_proveedor = ?;";
        ps = conexion.prepareStatement(sql);
        ps.setString(1,getClave_proveedor());
        ps.executeUpdate();
        Conectar();
        moverPrimero();
         } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 109");
    }
    }//fin de borrar 
     
     public void actualizar(){
     try{
        sql = "UPDATE proveedores SET Clave_proveedor = ? ,nombre = ?, apellido = ?, Telefono = ?, compañia = ?;";
        ps = conexion.prepareStatement(sql);
        ps.setString(1, getClave_proveedor());
        ps.setString(2,getNombre());
        ps.setString(3,getApellido());
        ps.setString(4,getTelefono());
        ps.setString(5,getCompania());
        ps.executeUpdate();
        Conectar();
        moverPrimero();
         
          
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 110");
    }
    }//fin de actualizar
    
    /*  public void buscar(){
        try{
         
            rs = st.executeQuery("select * from proeveedores where nombre like '%"+this.viewprove.jtf_buscar.getText()+"%'");
            viewprove.jt_proveedor.setModel(DbUtils.resultSetToTableModel(rs));
            
            rs=st.executeQuery("Select * from proveedores"); 
        
        } catch (SQLException err){
             
             JOptionPane.showMessageDialog(null,"Error "+err.getMessage());
         }
    
    }*/
    


    
    
    
    
}//FIn de la clase ModelProveedores
