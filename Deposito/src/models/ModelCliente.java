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
import views.ViewCliente;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author mark
 */
public class ModelCliente {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    ViewCliente viewcli;
    
    private  String clave_cliente;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String telefono;
    
    
     public void setClave_cliente(String clave_cliente){
        this.clave_cliente = clave_cliente;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setApellido_paterno(String apellido_paterno){
        this.apellido_paterno = apellido_paterno;
        
    }
    public void setApellido_materno(String apellido_materno){
        this.apellido_materno = apellido_materno;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    public String getClave_cliente(){
        return clave_cliente;
    }
    public String getNombre(){
     return nombre;
    }
    public String getApellido_paterno(){
        return apellido_paterno;
    }
    public String getApellido_materno(){
        return apellido_materno;
    }
    public String getTelefono(){
        return telefono;
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
        setClave_cliente(rs.getString("clave_cliente"));
        setNombre(rs.getString("nombre"));
        setApellido_paterno(rs.getString("apellido_paterno"));
        setApellido_materno(rs.getString("apellido_materno"));
        setTelefono(rs.getString("telefono"));
        
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
         sql = "select * from clientes;";
         ps = conexion.prepareStatement(sql);
         rs = ps.executeQuery();
         moverPrimero();
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 107");
    }
   
    }//fin de mover siguiente
      
    public void Insertar(){
     try{
        sql = "insert into clientes(clave_cliente, nombre, apellido_paterno,apellido_materno,telefono)values(?,?,?,?,?);";
        ps = conexion.prepareStatement(sql);
        ps.setString(1,getClave_cliente());
        ps.setString(2,getNombre());
        ps.setString(3,getApellido_paterno());
        ps.setString(4,getApellido_materno());
         ps.setString(5,getTelefono());
        ps.executeUpdate();
         Conectar();
         moverPrimero();
         
          
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 108" + ex.getMessage());
    }
    }//fin de insertar 
   
     public void borrar(){
     try{
        sql = "Delete from clientes where clave_cliente = ?;";
        ps = conexion.prepareStatement(sql);
        ps.setString(1,getClave_cliente());
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
        ps.setString(1, getClave_cliente());
        ps.setString(2,getNombre());
        ps.setString(3,getApellido_paterno());
        ps.setString(4,getApellido_materno());
        ps.setString(5,getTelefono());
        ps.executeUpdate();
        Conectar();
        moverPrimero();
         
          
    } catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error 110");
    }
    }//fin de actualizar
    
       public void buscar(){
        try{
         
            rs = st.executeQuery("select * from clientes where nombre like '%"+this.viewcli.jtf_buscar.getText()+"%'");
            viewcli.jt_cliente.setModel(DbUtils.resultSetToTableModel(rs));
            
            rs=st.executeQuery("Select * from clientes"); 
        
        } catch (SQLException err){
             
             JOptionPane.showMessageDialog(null,"Error "+err.getMessage());
         }
    
    }
    
}///Fin de la class
