    
import com.mysql.jdbc.Connection;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GL63
 */
public class PlaneWindow extends javax.swing.JFrame {
    int pos = 0;         
        public PesawatInterface pesawat;
           public PemesananInterface pemesanan;
            public PembeliInterface pembeli;
    /**
     * Creates new form PlaneWindow
     */
    public PlaneWindow(String ipaddress) {
        try {
            Integer portNum =1111;
            
            String registryURL = "rmi://" + ipaddress + ":" + portNum;
            System.out.println("Lookup completed ");
            this.pesawat = (PesawatInterface) Naming.lookup(registryURL + "/pesawat");
            this.pemesanan = (PemesananInterface) Naming.lookup(registryURL + "/pemesanan");
            this.pembeli = (PembeliInterface) Naming.lookup(registryURL + "/pembeli");
            System.out.println("ready");
            
            initComponents();
            Show_JTable();
        } catch (NotBoundException ex) {
            Logger.getLogger(PlaneWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(PlaneWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(PlaneWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_pembeli = new javax.swing.JTextField();
        txt_pesawat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_Products = new javax.swing.JTable();
        deletebutton = new javax.swing.JButton();
        insertbutton = new javax.swing.JButton();
        first = new javax.swing.JButton();
        next = new javax.swing.JButton();
        last = new javax.swing.JButton();
        prev = new javax.swing.JButton();
        txt_tgl = new com.github.lgooddatepicker.components.DatePicker();
        txt_jam = new com.github.lgooddatepicker.components.TimePicker();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tiket Pesawat");
        setName("Bangsat"); // NOI18N

        jLabel1.setText("ID:");
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel3.setText("Waktu Keberangkatan :");
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel4.setText("Nama Pesawat : ");
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                jLabel4AncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });

        jLabel5.setText("Nama Pembeli :");
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txt_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        txt_pembeli.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_pembeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pembeliActionPerformed(evt);
            }
        });

        txt_pesawat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_pesawat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pesawatActionPerformed(evt);
            }
        });

        JTable_Products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama Pesawat", "Nama Pembeli", "Tanggal Berangkat", "Waktu Berangkat"
            }
        ));
        JTable_Products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_ProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable_Products);

        deletebutton.setText("Delete");
        deletebutton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });

        insertbutton.setText("Insert");
        insertbutton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        insertbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbuttonActionPerformed(evt);
            }
        });

        first.setText("First");
        first.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstActionPerformed(evt);
            }
        });

        next.setText("Next");
        next.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        last.setText("Last");
        last.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastActionPerformed(evt);
            }
        });

        prev.setText("Prev");
        prev.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevActionPerformed(evt);
            }
        });

        jButton1.setText("Back");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(38, 38, 38)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_pesawat, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                .addComponent(txt_pembeli)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_jam, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(insertbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(deletebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(first, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(last, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txt_pesawat, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_pembeli, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txt_jam, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deletebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(first, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(last, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void txt_pesawatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesawatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pesawatActionPerformed

    private void insertbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbuttonActionPerformed
        String idsatu = txt_id.getText();
        String namapesawat = txt_pesawat.getText();
        String namapembeli = txt_pembeli.getText();
        
        PesawatTO pesawatsatu = new PesawatTO(34, namapesawat);
        PembeliTO pembelisatu = new PembeliTO(99, namapembeli);
        String jam = txt_jam.getText();
        String tanggal = txt_tgl.getText();
        
        PemesananTO pemesansatu = new PemesananTO(Integer.parseInt(idsatu), pesawatsatu, pembelisatu,  jam, tanggal);
        System.out.println(jam);
        try {
            this.pemesanan.add(pemesansatu);    
Show_JTable();
// TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(PlaneWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_insertbuttonActionPerformed

    private void firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstActionPerformed
       pos = 0;
        Show_Item(pos);
        

// TODO add your handling code here:
    }//GEN-LAST:event_firstActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        List<PemesananTO> pemesanans = null;
        try {
            pemesanans = this.pemesanan.getAll();
        } catch (Exception ex) {
            Logger.getLogger(PlaneWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        pos++;
        if(pos >= pemesanans.size()){
            pos = pemesanans.size()-1;
        }
        Show_Item(pos);
// TODO add your handling code here:
    }//GEN-LAST:event_nextActionPerformed

    private void lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastActionPerformed
      List<PemesananTO> pemesanans = null;
        try {
            pemesanans = this.pemesanan.getAll();
        } catch (Exception ex) {
            Logger.getLogger(PlaneWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pos = pemesanans.size()-1;
        Show_Item(pos);// TODO add your handling code here:
    }//GEN-LAST:event_lastActionPerformed

    private void prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevActionPerformed

        pos--;
        if(pos <0){
            pos=0;
        }
        Show_Item(pos);        // TODO add your handling code here:
    }//GEN-LAST:event_prevActionPerformed

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
        if(!txt_id.getText().equals("")){
            try {
                pemesanan.delete(Integer.parseInt(txt_id.getText()));
                
            } catch (Exception ex) {
                Logger.getLogger(PlaneWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
          else{
                     JOptionPane.showMessageDialog(null, "Tidak ada barang yang terpilih.");
                    }
        Show_JTable();
        
    }//GEN-LAST:event_deletebuttonActionPerformed

    private void JTable_ProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_ProductsMouseClicked
        int index = JTable_Products.getSelectedRow();
        Show_Item(index);
        // TODO add your handling code here:
    }//GEN-LAST:event_JTable_ProductsMouseClicked

    private void jLabel4AncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jLabel4AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4AncestorMoved

    private void txt_pembeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pembeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pembeliActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
  this.setVisible(false);
           Awalan aw = new Awalan();
         aw.setVisible(true);
        this.dispose();//to close the current jframe        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked
 
    /**
     * @return 
     */
   
    //Resize Image
//    String imgPath = null;
//    public ImageIcon Resize(String imagePath, byte[] pic){
//        ImageIcon myImage = null;
//        if(imagePath != null){
//            myImage = new ImageIcon(imagePath);
//        }
//        else{
//            myImage = new ImageIcon(pic);
//        }
//        Image img = myImage.getImage();
//        Image img2 = img.getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
//            ImageIcon image = new ImageIcon(img2);
//            return image;
//            
//    }
    
    
    public boolean checkInputs(){
        if(txt_id.getText() == null || txt_pesawat.getText() == null || txt_pembeli.getText() == null || txt_tgl.getText() == null ||  txt_jam.getText() == null){
            return false;
        }
        else{
          try{
               Float.parseFloat(txt_pembeli.getText());
           return true;
          }
          catch (Exception ex){
              return false;
          }
        }
    }
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
            java.util.logging.Logger.getLogger(PlaneWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaneWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaneWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaneWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaneWindow("localhost").setVisible(true);
            }
        });
    }
    //Menambahkan data ke list (Arraylist)
//    public ArrayList<Produk> getProductList(){
//              ArrayList<Produk> produklist = new ArrayList<Produk>();
//            Connection con = getConnection();
//            String query = "SELECT * FROM products";
//               Statement st;
//            ResultSet rs;
//        try {
//      
//         
//            st = con.createStatement();
//            rs = st.executeQuery(query);
//            Produk produk;
//            while(rs.next()){
//                produk = new Produk(rs.getInt("id"), rs.getString("name"),  rs.getInt("stok") ,Float.parseFloat(rs.getString("price")), rs.getString("add_date"), rs.getBytes("image"));
//                produklist.add(produk);
//            }
//        } catch (SQLException ex) {
//                            Logger.getLogger(PlaneWindow.class.getName()).log(Level.SEVERE, null, ex);
//
//        }
//        return produklist;
//
//    }
    
    public void Show_JTable()
    {
    List<PemesananTO> pemesanans = null;

    List<PesawatTO> pesawats = null;
    List<PembeliTO> pembelis = null;
    
        try {
            pemesanans = pemesanan.getAll();
          
        } catch (Exception ex) {
            Logger.getLogger(PlaneWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    DefaultTableModel model = (DefaultTableModel)JTable_Products.getModel();
    //clear
    model.setRowCount(0);
    Object[] row = new Object[5];
    for(int i= 0; i<pemesanans.size();i++){
        row[0] = pemesanans.get(i).getId();
        row[1] = pemesanans.get(i).getPesawat().getNama();
        row[2] = pemesanans.get(i).getPembeli().getNama();
        row[3] = pemesanans.get(i).getTanggal();
        row[4] = pemesanans.get(i).getJam();
//        System.out.println(row[3]);
       model.addRow(row);
    }
    }
    
    public void Show_Item(int index){
         List<PemesananTO> pemesanans = null;
  
    
        try {
            pemesanans = pemesanan.getAll();
          
        } catch (Exception ex) {
            Logger.getLogger(PlaneWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
      txt_id.setText(Integer.toString(pemesanans.get(index).getId()));
      txt_pesawat.setText(pemesanans.get(index).getPesawat().getNama());
              txt_pembeli.setText(pemesanans.get(index).getPembeli().getNama());
              
          try {
            // Declare a date format for parsing
            SimpleDateFormat dateParser = new SimpleDateFormat("h:mm a");

            // Parse the time string
           String time = pemesanans.get(index).getJam();
           time = time.replace("am"," AM");
           time = time.replace("pm"," PM");
           
            Date date = dateParser.parse(time);

            // Declare a date format for printing
            SimpleDateFormat dateFormater = new SimpleDateFormat("HH:mm");
String x = dateFormater.format(date);
int hour = Integer.parseInt(x.split(":")[0]);
int minutes = Integer.parseInt(x.split(":")[1]);

            // Print the previously parsed time
            System.out.println(dateFormater.format(date));
              txt_jam.setTime(LocalTime.of(hour,minutes));

        } catch (ParseException e) {
            System.err.println("Cannot parse this time string !");
        }
        txt_tgl.setText(pemesanans.get(index).getTanggal());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable_Products;
    private javax.swing.JButton deletebutton;
    private javax.swing.JButton first;
    private javax.swing.JButton insertbutton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton last;
    private javax.swing.JButton next;
    private javax.swing.JButton prev;
    private javax.swing.JTextField txt_id;
    private com.github.lgooddatepicker.components.TimePicker txt_jam;
    private javax.swing.JTextField txt_pembeli;
    private javax.swing.JTextField txt_pesawat;
    private com.github.lgooddatepicker.components.DatePicker txt_tgl;
    // End of variables declaration//GEN-END:variables
}
