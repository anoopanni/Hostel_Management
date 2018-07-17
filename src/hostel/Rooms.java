/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author anoop
 */
public class Rooms extends javax.swing.JFrame {

    /**
     * Creates new form Rooms
     */
    public Rooms() {
        initComponents();
        Show_Users_In_JTable();
        fillCombo1();
        fillCombo2();
                setTransparent();
        jTable1.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,18));
         jLabel1.setOpaque(true);
        jLabel3.setOpaque(true);
        jLabel2.setOpaque(true);
        jLabel4.setOpaque(true);
       
   
        jLabel1.setBackground(Color.red);
        jLabel3.setBackground(Color.red);
        jLabel2.setBackground(Color.red);
        jLabel4.setBackground(Color.red);
    }

   public Connection getConnection()
    {
        try{
             Connection con = Sqlconnect.connectDB();
             return con;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
    
    public ArrayList<User_rooms> getUsersList()
    {
        ArrayList<User_rooms> usersList = new ArrayList<User_rooms>();
        Connection connection = getConnection();
        String query = "SELECT * FROM `room`";
        Statement st;
        ResultSet rs;
        
        try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            User_rooms user;
            while(rs.next())
            {
                user = new User_rooms(rs.getInt("Room_id"),rs.getInt("Hostel_id"),rs.getInt("Student_id"),rs.getInt("Capacity"));
                usersList.add(user);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
     
        }
        return usersList;
    }
    public void Show_Users_In_JTable()
    {
        ArrayList<User_rooms> list = getUsersList();
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
        Object[] row = new Object[4];
        for(int i=0;i<list.size();i++)
        {
            row[0] = list.get(i).getRoom();
            row[1] = list.get(i).getHid();
            row[2] = list.get(i).getId();
            row[3] = list.get(i).getCapacity();
            
            
            model.addRow(row);
        }
        
    }
    
    public void executeSQLQuery(String query,String message)
    {
        Connection con = getConnection();
        Statement st;
        try{
            st = con.createStatement();
            if((st.executeUpdate(query)) == 1)
            {
               DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
               model.setRowCount(0);
               Show_Users_In_JTable();
             
                JOptionPane.showMessageDialog(null, "data is "+message+" SUCCESSFULLY");
                
            }else
            {
                JOptionPane.showMessageDialog(null,"data was not  "+message);
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(),"you fool",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void fillCombo1()
    {   
        String query = "select `Student_id` from `Student`";
        Connection con = getConnection();
        PreparedStatement ps=null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                jComboBox1.addItem(rs.getString("Student_id"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    public void fillCombo2()
    {   
        String query = "select `hostel_id` from `hostel`";
        Connection con = getConnection();
        PreparedStatement ps=null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                jComboBox2.addItem(rs.getString("hostel_id"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
        void setTransparent()
    {
           jTable1.setOpaque(true);
        ((DefaultTableCellRenderer)jTable1.getDefaultRenderer(Object.class)).setOpaque(true);
        jTable1.setShowGrid(false);
        jTable1.setForeground(Color.MAGENTA);
        jTable1.setBackground(Color.DARK_GRAY);
        jTable1.setFillsViewportHeight(true);
    }  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1650, 1080));
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room Id", "Hostel Id", "Student Id", "Capacity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(730, 120, 540, 420);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Room id");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 140, 87, 29);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Student id");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 280, 107, 29);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Hostel id");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 210, 92, 29);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Capacity");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(130, 360, 89, 29);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(467, 145, 160, 30);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3);
        jTextField3.setBounds(470, 280, 165, 30);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(470, 210, 165, 30);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(465, 350, 170, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("Insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(120, 470, 105, 37);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(480, 469, 119, 37);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(310, 470, 109, 37);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4.setText("Home");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(120, 30, 103, 37);

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(310, 280, 120, 30);

        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(310, 210, 120, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/sir_tobys_hostel_prague_dorm_room_900x475-1400x700_c.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-6, -6, 1430, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String query = "UPDATE `room` SET `Room_id`='"+ jTextField1.getText()+"',`Hostel_id`='"+ jTextField2.getText()+"',`Student_id`='"+ jTextField3.getText()+"',`Capacity`='"+jTextField4.getText()+"'  WHERE `Room_id` = "+jTextField1.getText();
        executeSQLQuery(query,"UPDATED");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String query = "INSERT INTO `room`(`Room_id`,`Hostel_id`,`Student_id`,`Capacity`) VALUES ('"+ jTextField1.getText()+"','"+ jTextField2.getText()+"','"+ jTextField3.getText()+"', '"+jTextField4.getText()+"')";
        executeSQLQuery(query,"INSERTED");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String query = "DELETE FROM `room` WHERE Room_id = "+jTextField1.getText();
        executeSQLQuery(query, "DELETED");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         int i = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
       jTextField1.setText(model.getValueAt(i,0).toString());
        jTextField3.setText(model.getValueAt(i,1).toString());
        jTextField2.setText(model.getValueAt(i,2).toString());
        jTextField4.setText(model.getValueAt(i,3).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Home hm = new Home();
        hm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
      String student_id = jComboBox1.getSelectedItem().toString();
        jTextField3.setText(student_id);
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        String hostel_id = jComboBox2.getSelectedItem().toString();
        jTextField2.setText(hostel_id);
    }//GEN-LAST:event_jComboBox2ItemStateChanged

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
            java.util.logging.Logger.getLogger(Rooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rooms().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
