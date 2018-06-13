/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcliente;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author admin
 */
public class Chat extends javax.swing.JFrame {
    InetAddress dirIP_B;
    Integer puerto_B;
    String usuario;
    Socket socketDatosA;
    Thread hilo;
    //ArrayList<String> users = new ArrayList<>();
    DefaultListModel<String> users = new DefaultListModel<>();

    /**
     * Creates new form Chat
     */
    public Chat() {
        initComponents();
        users.addElement("<Global>");
        Usuarios.setModel(users);
    }
    public Chat(String usuario) {
        users.addElement("<Global>");
        this.usuario = usuario;
        initComponents();
        LabelUsuario.setText(usuario);
        try {
            dirIP_B = InetAddress.getByName("10.152.164.38");
            puerto_B = 6000;
            socketDatosA = new Socket(dirIP_B, puerto_B);
            hilo = new Thread(new HiloCliente(socketDatosA));
            hilo.start();
            String login = LOGINP(usuario);
            //System.out.println(login);
            enviarDatosAlServer(login);
                
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Usuarios.setModel(users);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelUsuario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatBox = new javax.swing.JTextArea();
        EnviarText = new javax.swing.JTextField();
        Envia = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Usuarios = new javax.swing.JList<>();
        Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LabelUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelUsuario.setText("Usuario");

        chatBox.setEditable(false);
        chatBox.setColumns(20);
        chatBox.setRows(5);
        jScrollPane1.setViewportView(chatBox);

        EnviarText.setText("Escriba su mensaje...");
        EnviarText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EnviarTextMouseClicked(evt);
            }
        });
        EnviarText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarTextActionPerformed(evt);
            }
        });

        Envia.setText("Enviar");
        Envia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviaActionPerformed(evt);
            }
        });

        Usuarios.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "<General>" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        Usuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(Usuarios);

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(EnviarText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Envia))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addComponent(LabelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelUsuario)
                    .addComponent(Salir))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EnviarText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Envia))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EnviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviaActionPerformed
        // TODO add your handling code here:
        String enviar;
        String mensaje = EnviarText.getText();
        if(!mensaje.equals("Escriba su mensaje...") && !mensaje.equals("") && !mensaje.contains(";")){
            int index = Usuarios.getSelectedIndex();
            //System.out.println(index);
            chatBox.append(usuario + ": " + mensaje+"\n");
            if(index == 0 || index == -1){
                //Chat Global
                //System.out.println("CHAT GLOBAL");
                enviar = MSGGLBP(usuario, mensaje);
                //System.out.println(enviar);
                
            } else {
                //Chat Pesonal
                //System.out.println("CHAT PERSONAL A " + Usuarios.getSelectedValue());
                enviar = MSGPRVP(usuario, Usuarios.getSelectedValue(), mensaje);
            }
            enviarDatosAlServer(enviar);
        } else {
            JOptionPane.showMessageDialog(null, "Formato incorrecto.");
        }
        EnviarText.setText("Escriba su mensaje...");
    }//GEN-LAST:event_EnviaActionPerformed

    private void EnviarTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarTextActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_EnviarTextActionPerformed

    private void EnviarTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EnviarTextMouseClicked
        // TODO add your handling code here:
        EnviarText.setText("");
    }//GEN-LAST:event_EnviarTextMouseClicked

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Hasta luego " + usuario);
        try {
            String fin = LOGOUTP(usuario);
            socketDatosA.close();
            enviarDatosAlServer(fin);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

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
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chat().setVisible(true);
            }
        });
        
        
    }
    
    public static String LOGINP(String user){
        return "1;" + user;
    }
    
    public static String LOGOUTP(String user){
        return "2;" + user;
    }
    
    public static String MSGPRVP(String user, String userR, String msg){
        StringBuilder sb = new StringBuilder();
        sb.append("3;");
        sb.append(user);
        sb.append(";");
        sb.append(userR);
        sb.append(";");
        sb.append(msg);
        return sb.toString();
    }
    
    public static String MSGGLBP(String user, String msg){
        StringBuilder sb = new StringBuilder();
        sb.append("4;");
        sb.append(user);
        sb.append(";");
        sb.append(msg);
        return sb.toString();
    }
    
    //Aviso Login/Logout
    public void actualizarLista(String usrs){
        String[] usdl = usrs.split(",");
        users.clear();
        users.addElement("<Global>");
        for(String s : usdl){
            if(!s.equals(usuario)){
                users.addElement(s);
            }
        }
    }
    
    public void actUsers(){
        Usuarios.setModel(users);
    }
    
    //Aviso Nuevo Mensaje
    public void actChat(String s){
        chatBox.append(s+"\n");
    }
    
    public void enviarDatosAlServer(String enviar){
        try {
            PrintWriter output = new PrintWriter(new OutputStreamWriter(socketDatosA.getOutputStream()));
            output.println(enviar);
            output.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Envia;
    private javax.swing.JTextField EnviarText;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JButton Salir;
    private javax.swing.JList<String> Usuarios;
    private javax.swing.JTextArea chatBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
