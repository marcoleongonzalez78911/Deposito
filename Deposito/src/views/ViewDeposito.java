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
public class ViewDeposito extends javax.swing.JFrame {

    /**
     * Creates new form ViewDeposito
     */
    public ViewDeposito() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jmb_menu = new javax.swing.JMenuBar();
        jmregistro = new javax.swing.JMenu();
        jmi_login = new javax.swing.JMenuItem();
        jmi_cliente = new javax.swing.JMenuItem();
        jmi_producto = new javax.swing.JMenuItem();
        jmi_proveedor = new javax.swing.JMenuItem();
        jmi_usuarios = new javax.swing.JMenuItem();
        jmi_salir = new javax.swing.JMenuItem();
        jmventa = new javax.swing.JMenu();
        jmi_venta = new javax.swing.JMenuItem();
        jmi_Compras = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\mark\\Pictures\\deposito\\pepsi.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 190));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\mark\\Pictures\\deposito\\coca.png")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 480, 180));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\mark\\Pictures\\deposito\\7-Up-Logo.svg.png")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 300, 250));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\mark\\Pictures\\deposito\\fantalogo.jpg")); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, 250));

        jmregistro.setText("Registros ");

        jmi_login.setText("Login");
        jmregistro.add(jmi_login);

        jmi_cliente.setText("Clientes");
        jmregistro.add(jmi_cliente);

        jmi_producto.setText("Producto");
        jmregistro.add(jmi_producto);

        jmi_proveedor.setText("Proveedor");
        jmregistro.add(jmi_proveedor);

        jmi_usuarios.setText("Usuarios");
        jmregistro.add(jmi_usuarios);

        jmi_salir.setText("Salir");
        jmregistro.add(jmi_salir);

        jmb_menu.add(jmregistro);

        jmventa.setText("Venta y compra");

        jmi_venta.setText("Ventas");
        jmventa.add(jmi_venta);

        jmi_Compras.setText("Compras");
        jmventa.add(jmi_Compras);

        jmb_menu.add(jmventa);

        setJMenuBar(jmb_menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewDeposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDeposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDeposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDeposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewDeposito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JMenuBar jmb_menu;
    public javax.swing.JMenuItem jmi_Compras;
    public javax.swing.JMenuItem jmi_cliente;
    public javax.swing.JMenuItem jmi_login;
    public javax.swing.JMenuItem jmi_producto;
    public javax.swing.JMenuItem jmi_proveedor;
    public javax.swing.JMenuItem jmi_salir;
    public javax.swing.JMenuItem jmi_usuarios;
    public javax.swing.JMenuItem jmi_venta;
    public javax.swing.JMenu jmregistro;
    public javax.swing.JMenu jmventa;
    // End of variables declaration//GEN-END:variables
}