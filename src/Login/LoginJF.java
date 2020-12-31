package Login;

import SQLHome.SQLHome;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class LoginJF extends javax.swing.JFrame {
    private Connection myconn;
    private Statement mystam;
    private String account;
    private String password;
    private String url;
    private static final long serialVersionUID = -1570645570118871214L;
    
    public void LoginSwing()
    {
        showLogin();
        initComponents();
    }

    //主介面設定
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb2 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        lb3 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        tf2 = new javax.swing.JPasswordField();
        tf3 = new javax.swing.JTextField();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        timeble = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(98, 124, 179));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 380));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb2.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        lb2.setText("   密 碼 :");
        lb2.setMaximumSize(new java.awt.Dimension(60, 30));
        lb2.setMinimumSize(new java.awt.Dimension(60, 30));
        lb2.setPreferredSize(new java.awt.Dimension(60, 30));
        jPanel1.add(lb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 105, -1, -1));

        lb1.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        lb1.setText("   帳號 :");
        lb1.setMaximumSize(new java.awt.Dimension(60, 30));
        lb1.setMinimumSize(new java.awt.Dimension(60, 30));
        lb1.setPreferredSize(new java.awt.Dimension(60, 30));
        jPanel1.add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 46, -1, -1));

        lb3.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        lb3.setText("   URL :");
        lb3.setMaximumSize(new java.awt.Dimension(60, 30));
        lb3.setMinimumSize(new java.awt.Dimension(60, 30));
        lb3.setPreferredSize(new java.awt.Dimension(60, 30));
        jPanel1.add(lb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 164, -1, -1));

        tf1.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        tf1.setMinimumSize(new java.awt.Dimension(200, 30));
        tf1.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel1.add(tf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 48, 276, -1));

        tf2.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        tf2.setMinimumSize(new java.awt.Dimension(200, 30));
        tf2.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel1.add(tf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 108, 276, -1));

        tf3.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        tf3.setMinimumSize(new java.awt.Dimension(210, 30));
        tf3.setPreferredSize(new java.awt.Dimension(210, 30));
        jPanel1.add(tf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 168, 425, -1));

        btn1.setFont(new java.awt.Font("微軟正黑體", 0, 24)); // NOI18N
        btn1.setText("登  入");
        btn1.setMaximumSize(new java.awt.Dimension(95, 80));
        btn1.setMinimumSize(new java.awt.Dimension(95, 80));
        btn1.setPreferredSize(new java.awt.Dimension(95, 80));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, -1));

        btn2.setFont(new java.awt.Font("微軟正黑體", 0, 24)); // NOI18N
        btn2.setText("退  出");
        btn2.setMaximumSize(new java.awt.Dimension(95, 80));
        btn2.setMinimumSize(new java.awt.Dimension(95, 80));
        btn2.setPreferredSize(new java.awt.Dimension(95, 80));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, -1, -1));

        btn3.setFont(new java.awt.Font("微軟正黑體", 0, 24)); // NOI18N
        btn3.setText("清  除");
        btn3.setMaximumSize(new java.awt.Dimension(95, 80));
        btn3.setMinimumSize(new java.awt.Dimension(95, 80));
        btn3.setPreferredSize(new java.awt.Dimension(95, 80));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel1.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        timeble.setFont(new java.awt.Font("微軟正黑體", 1, 20)); // NOI18N
        timeble.setForeground(new java.awt.Color(51, 255, 51));
        jPanel1.add(timeble, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 200, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //按鈕動作設定
    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        if(evt.getSource()==btn1) {
            try
                {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    System.out.println("驅動安裝成功");
                    //獲取登入資料
                    account = tf1.getText();
                    password = tf2.getText();
                    url = tf3.getText();
                    myconn = DriverManager.getConnection(url, account, password);  //連結
                    mystam = myconn.createStatement();  //啟動
                    JOptionPane.showMessageDialog(null, "登入成功");
                    System.out.println("登入成功");
                }
            catch(SQLException ex)
            {
                    JOptionPane.showMessageDialog(null, "請確認登入資訊及網路連線");
            }
            catch (ClassNotFoundException ex)
            {
                System.out.println("驅動安裝失敗");
                System.out.println(ex.getMessage());
            }
            //送出帳號密碼------------------------------------------------------
            SQLHome callsql= new SQLHome();
            callsql.sqlaccount = account;
            callsql.sqlpassword = password;
            callsql.sqlurl = url;
            //開啟連動視窗
            callsql.SQLHomeM();
            //設定對方JLable值
            callsql.reac.setText("使用者 : " + account);
            callsql.reurl.setText("URL : " + url);
            callsql.list_1.setText("一般會員表");
            callsql.list_2.setText("VIP會員表");
            //暫時關閉登入頁面
            dispose();
            //------------------------------------------------------------------
        }
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        if(evt.getSource()==btn2)
            {
                dispose();
                System.exit(0);
            }
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        if(evt.getSource()==btn3)
            {
                tf1.setText("u586968401_user01");    //將文字框重設
                tf2.setText("Money780406");    //將文字框重設
                tf3.setText("jdbc:mysql://151.106.116.1:3306/u586968401_test01");    //將文字框重設
                btn3.setEnabled(true); // 啟用 btn3 按鈕
            }
    }//GEN-LAST:event_btn3ActionPerformed
    
    /**
    * 顯示出視窗設定
    */
    public void showLogin()
    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        //</editor-fold>
        
        /* Create and display the form */
        //視窗設定
        setVisible(true); //顯示視窗
        setTitle("SQL後臺管理系統"); //標題設定
        setIconImage(Toolkit.getDefaultToolkit().getImage(LoginJF.class.getResource("/images/logicon.jpg"))); //圖示ICON設定
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //預設關閉方法
        setLocation(650,380); //預設位置
        setResizable(false); //禁止調整大小 true 則可以
        
        //時間設定
        Timer timer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                timeble.setText("現在時間:  " + LocalTime.now().toString());
            }
        });
        timer.setRepeats(true);
        timer.start();
    }
    
    //按鈕命名
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JTextField tf1;
    private javax.swing.JPasswordField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JLabel timeble;
    // End of variables declaration//GEN-END:variables
}
