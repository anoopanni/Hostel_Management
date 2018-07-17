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
public class Student_details extends javax.swing.JFrame {

    /**
     * Creates new form Student_details
     */
    public Student_details() {
        initComponents();
        Show_Users_In_JTable();
        fillCombo();
        setTransparent();
        jTable1.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,16));
        jLabel1.setOpaque(true);
        jLabel2.setOpaque(true);
        jLabel3.setOpaque(true);
        jLabel4.setOpaque(true);
        jLabel5.setOpaque(true);
        jLabel6.setOpaque(true);
        jLabel7.setOpaque(true);
        jLabel1.setBackground(Color.red);
        jLabel2.setBackground(Color.red);
        jLabel3.setBackground(Color.red);
        jLabel4.setBackground(Color.red);
        jLabel5.setBackground(Color.red);
        jLabel6.setBackground(Color.red);
        jLabel7.setBackground(Color.red);
       
        
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
    
    public ArrayList<Users_student> getUsersList()
    {
        ArrayList<Users_student> usersList = new ArrayList<Users_student>();
        Connection connection = getConnection();
        String query = "SELECT * FROM `student`";
        Statement st;
        ResultSet rs;
        
        try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Users_student user;
            while(rs.next())
            {
                user = new Users_student(rs.getInt("Student_id"),rs.getString("Student_name"),rs.getString("Father_name"),rs.getString("Department"),rs.getString("DOB"),rs.getInt("Hostel_id"),rs.getInt("Fee"));
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
        ArrayList<Users_student> list = getUsersList();
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        
        Object[] row = new Object[7];
        for(int i=0;i<list.size();i++)
        {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getFname();
            row[3] = list.get(i).getDepartment();
            row[4] = list.get(i).getDob();
            row[5] = list.get(i).getHid();
            row[6] = list.get(i).getFee();
            
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
        }
       }
    public void fillCombo()
    {   
        String query = "select `hostel_id` from `hostel`";
        Connection con = getConnection();
        PreparedStatement ps=null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                jComboBox1.addItem(rs.getString("hostel_id"));
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Text_id = new javax.swing.JTextField();
        Text_name = new javax.swing.JTextField();
        Text_fname = new javax.swing.JTextField();
        Text_dept = new javax.swing.JTextField();
        Text_dob = new javax.swing.JTextField();
        Text_hid = new javax.swing.JTextField();
        Text_fee = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1650, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student id", "Student name", "Father name", "Department", "DOB", "Hostel id", "Fees"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
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
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 780, 550));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Student id");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 91, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Student name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Father name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Department");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 283, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("DOB");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 346, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Hostel id");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Fee");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, -1, 26));
        getContentPane().add(Text_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 173, -1));
        getContentPane().add(Text_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 173, -1));
        getContentPane().add(Text_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 173, -1));
        getContentPane().add(Text_dept, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 173, -1));
        getContentPane().add(Text_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 173, -1));
        getContentPane().add(Text_hid, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, 173, -1));

        Text_fee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Text_feeActionPerformed(evt);
            }
        });
        getContentPane().add(Text_fee, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, 173, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("Insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 117, 48));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 560, 133, 48));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 560, 117, 48));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4.setText("Home");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 113, 31));

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 95, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/794338.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -60, 1930, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String query = "INSERT INTO `student`(`Student_id`, `Student_name`, `Father_name`, `Department`, `DOB`, `Hostel_id`, `Fee`) VALUES ('"+Text_id.getText()+"','"+Text_name.getText()+"','"+Text_fname.getText()+"','"+Text_dept.getText()+"','"+Text_dob.getText()+"','"+Text_hid.getText()+"','"+Text_fee.getText()+"')";
        executeSQLQuery(query,"INSERTED");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String query = "UPDATE `student` SET `Student_id`='"+Text_id.getText()+"',`Student_name`='"+Text_name.getText()+"',`Father_name`='"+Text_fname.getText()+"',`Department`='"+Text_dept.getText()+"',`DOB`='"+Text_dob.getText()+"',`Hostel_id`='"+Text_hid.getText()+"',`Fee`='"+Text_fee.getText()+"' WHERE `Student_id` = "+Text_id.getText();
        executeSQLQuery(query,"UPDATED");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String query = "DELETE FROM `student` WHERE Student_id = "+Text_id.getText();
        executeSQLQuery(query, "DELETED");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         int i = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        Text_id.setText(model.getValueAt(i,0).toString());
        Text_name.setText(model.getValueAt(i,1).toString());
        Text_fname.setText(model.getValueAt(i,2).toString());
        Text_dept.setText(model.getValueAt(i,3).toString());
        Text_dob.setText(model.getValueAt(i,4).toString());
        Text_hid.setText(model.getValueAt(i,5).toString());
        Text_fee.setText(model.getValueAt(i,6).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Home hm = new Home();
        hm.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        String hostel_id = jComboBox1.getSelectedItem().toString();
        Text_hid.setText(hostel_id);
        
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void Text_feeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Text_feeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Text_feeActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(Student_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student_details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Text_dept;
    private javax.swing.JTextField Text_dob;
    private javax.swing.JTextField Text_fee;
    private javax.swing.JTextField Text_fname;
    private javax.swing.JTextField Text_hid;
    private javax.swing.JTextField Text_id;
    private javax.swing.JTextField Text_name;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
