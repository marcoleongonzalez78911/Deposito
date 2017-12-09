/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author mark
 */
public class ViewCliente extends javax.swing.JPanel {

    /**
     * Creates new form ViewCliente
     */
    public ViewCliente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_clave = new javax.swing.JLabel();
        jl_nombre = new javax.swing.JLabel();
        jl_apellido_p = new javax.swing.JLabel();
        jl_apellido_m = new javax.swing.JLabel();
        jl_telefono = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_cliente = new javax.swing.JTable();
        jl_titulo = new javax.swing.JLabel();
        jtf_clave_cliente = new javax.swing.JTextField();
        jtf_nombre = new javax.swing.JTextField();
        jtf_apellido_paterno = new javax.swing.JTextField();
        jtf_apellido_materno = new javax.swing.JTextField();
        jtf_telefono = new javax.swing.JTextField();
        jl_buscar = new javax.swing.JLabel();
        jtf_buscar = new javax.swing.JTextField();
        jbtn_buscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jbtn_siguiente = new javax.swing.JButton();
        jbtn_anterior = new javax.swing.JButton();
        jbtn_nuevo = new javax.swing.JButton();
        jbtn_agregar = new javax.swing.JButton();
        jbtn_eliminar = new javax.swing.JButton();
        jbtn_actualizar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jl_imagen2 = new javax.swing.JLabel();
        jbtn_primero = new javax.swing.JButton();
        jbtn_ultimo = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(0, 102, 102));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_clave.setText("Clave de cliente");
        add(jl_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jl_nombre.setText("Nombre ");
        add(jl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));

        jl_apellido_p.setText("Apellido paterno");
        add(jl_apellido_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, -1));

        jl_apellido_m.setText("Apellido Materno");
        add(jl_apellido_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jl_telefono.setText("Telefono");
        add(jl_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        jt_cliente.setBackground(new java.awt.Color(0, 102, 102));
        jt_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Clave", "Nombre", "Apellido Paterno", "Apellido Materno", "Telefono"
            }
        ));
        jScrollPane1.setViewportView(jt_cliente);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 600, 200));

        jl_titulo.setFont(new java.awt.Font("Microsoft JhengHei", 2, 18)); // NOI18N
        jl_titulo.setText("          Clientes");
        add(jl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 180, 30));

        jtf_clave_cliente.setBackground(new java.awt.Color(0, 102, 102));
        jtf_clave_cliente.setBorder(null);
        add(jtf_clave_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, -1));

        jtf_nombre.setBackground(new java.awt.Color(0, 102, 102));
        jtf_nombre.setBorder(null);
        add(jtf_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 140, -1));

        jtf_apellido_paterno.setBackground(new java.awt.Color(0, 102, 102));
        jtf_apellido_paterno.setBorder(null);
        add(jtf_apellido_paterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 140, -1));

        jtf_apellido_materno.setBackground(new java.awt.Color(0, 102, 102));
        jtf_apellido_materno.setBorder(null);
        add(jtf_apellido_materno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 150, -1));

        jtf_telefono.setBackground(new java.awt.Color(0, 102, 102));
        jtf_telefono.setBorder(null);
        add(jtf_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 140, -1));

        jl_buscar.setText("Buscar");
        add(jl_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 50, 20));

        jtf_buscar.setBackground(new java.awt.Color(0, 102, 102));
        jtf_buscar.setBorder(null);
        add(jtf_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 140, -1));

        jbtn_buscar.setText("Buscar");
        jbtn_buscar.setBorder(new javax.swing.border.MatteBorder(null));
        add(jbtn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 60, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/imagenes/coca negro.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, -1, -1));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jbtn_siguiente.setText("Siguiente");
        jPanel1.add(jbtn_siguiente);

        jbtn_anterior.setText("Anterior");
        jPanel1.add(jbtn_anterior);

        jbtn_nuevo.setText("Nuevo");
        jPanel1.add(jbtn_nuevo);

        jbtn_agregar.setText("Agregar");
        jPanel1.add(jbtn_agregar);

        jbtn_eliminar.setText("Eliminar");
        jPanel1.add(jbtn_eliminar);

        jbtn_actualizar.setText("Actualizar");
        jPanel1.add(jbtn_actualizar);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 260, 290));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 112, 140, 10));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 112, 140, 10));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 140, 10));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jl_imagen2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/imagenes/cocaclasic.jpg"))); // NOI18N
        jPanel2.add(jl_imagen2);

        jbtn_primero.setBackground(new java.awt.Color(153, 153, 153));
        jbtn_primero.setText("<<<");
        jPanel2.add(jbtn_primero);

        jbtn_ultimo.setText(">>>");
        jPanel2.add(jbtn_ultimo);

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 260, 220));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 182, 150, 10));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 140, 10));
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 140, 10));
    }// </editor-fold>//GEN-END:initComponents

    private void jtbn_ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbn_ultimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbn_ultimoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    public javax.swing.JButton jbtn_actualizar;
    public javax.swing.JButton jbtn_agregar;
    public javax.swing.JButton jbtn_anterior;
    public javax.swing.JButton jbtn_buscar;
    public javax.swing.JButton jbtn_eliminar;
    public javax.swing.JButton jbtn_nuevo;
    public javax.swing.JButton jbtn_primero;
    public javax.swing.JButton jbtn_siguiente;
    public javax.swing.JButton jbtn_ultimo;
    public javax.swing.JLabel jl_apellido_m;
    public javax.swing.JLabel jl_apellido_p;
    public javax.swing.JLabel jl_buscar;
    public javax.swing.JLabel jl_clave;
    private javax.swing.JLabel jl_imagen2;
    public javax.swing.JLabel jl_nombre;
    public javax.swing.JLabel jl_telefono;
    public javax.swing.JLabel jl_titulo;
    public javax.swing.JTable jt_cliente;
    public javax.swing.JTextField jtf_apellido_materno;
    public javax.swing.JTextField jtf_apellido_paterno;
    public javax.swing.JTextField jtf_buscar;
    public javax.swing.JTextField jtf_clave_cliente;
    public javax.swing.JTextField jtf_nombre;
    public javax.swing.JTextField jtf_telefono;
    // End of variables declaration//GEN-END:variables
}
