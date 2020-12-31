package SQLHome;

import Login.LoginJF;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author enelm
 */
public class SQLHome extends javax.swing.JFrame 
{
    public String sqlaccount;
    public String sqlpassword;
    public String sqlurl;
    
    public void SQLHomeM()
    {
        initComponents();
        showSQL();
        show_user();
        jPanelVIP.setVisible(false);
        jPanelBV.setVisible(false);
    }
    
    //獲取表單做成 User ArrayList
    @SuppressWarnings("NonPublicExported")
    protected ArrayList<User> userList()
    {
        ArrayList<User> usersList = new ArrayList<>();
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(sqlurl, sqlaccount, sqlpassword);
            //表單獲取
            String quer1 = "SELECT * FROM employees";
            Statement myStmt = myConn.createStatement();
            ResultSet myrs = myStmt.executeQuery(quer1);
            User user;
            while(myrs.next()){
                user = new User(myrs.getInt("id"), myrs.getString("first_name"), myrs.getString("last_name"), myrs.getString("email"), myrs.getString("gender"));
                usersList.add(user);
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usersList;
    }
    
    //獲取表單做成 VIP ArrayList 
    @SuppressWarnings("NonPublicExported")
    protected ArrayList<VIP> vipList()
    {
        ArrayList<VIP> vipsList = new ArrayList<>();
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(sqlurl, sqlaccount, sqlpassword);
            //表單獲取
            String quer1 = "SELECT * FROM VIP";
            Statement myStmt = myConn.createStatement();
            ResultSet myrs = myStmt.executeQuery(quer1);
            VIP vip;
            while(myrs.next()){
                vip = new VIP(myrs.getInt("vip_id"), myrs.getString("vip_first_name"), myrs.getString("vip_last_name"), myrs.getString("vip_email"), myrs.getString("vip_gender"));
                vipsList.add(vip);
            }
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vipsList;
    }
    
    //將獲取到的表單資料放入 User JTable
    public void show_user()
    {
        ArrayList<User> list = userList();
        DefaultTableModel model = (DefaultTableModel) jTable_Display_User.getModel();
        Object[] row = new Object[5];
        for(int i=0; i<list.size(); i++)
        {
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getfirst_name();
            row[2] = list.get(i).getlast_name();
            row[3] = list.get(i).getemail();
            row[4] = list.get(i).getgender();
            model.addRow(row);
        }
    }
    
    //將獲取到的表單資料放入VIP JTable
    public void show_vip()
    {
        ArrayList<VIP> list2 = vipList();
        DefaultTableModel model2 = (DefaultTableModel) JTable_Display_VIP.getModel();
        Object[] row2 = new Object[5];
        for(int i=0; i<list2.size(); i++)
        {
            row2[0] = list2.get(i).getvip_id();
            row2[1] = list2.get(i).getvip_first_name();
            row2[2] = list2.get(i).getvip_last_name();
            row2[3] = list2.get(i).getvip_email();
            row2[4] = list2.get(i).getvip_gender();
            model2.addRow(row2);
        }
    }

    //主介面設定
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        exit = new javax.swing.JButton();
        singout = new javax.swing.JButton();
        jPanelEmpioyees = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_User = new javax.swing.JTable();
        jPanelVIP = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTable_Display_VIP = new javax.swing.JTable();
        jPanelBE = new javax.swing.JPanel();
        update = new javax.swing.JButton();
        save = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        first_name = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        last_name = new javax.swing.JTextField();
        gender = new javax.swing.JComboBox<>();
        jPanelBV = new javax.swing.JPanel();
        updateVIP = new javax.swing.JButton();
        saveVIP = new javax.swing.JButton();
        resetVIP = new javax.swing.JButton();
        deleteVIP = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        first_name1 = new javax.swing.JTextField();
        last_name1 = new javax.swing.JTextField();
        email1 = new javax.swing.JTextField();
        gender1 = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        flie = new javax.swing.JMenu();
        jMenu_ingout = new javax.swing.JMenuItem();
        jMenu_exit = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenu();
        JMenu_dblist = new javax.swing.JMenu();
        list_1 = new javax.swing.JMenuItem();
        list_2 = new javax.swing.JMenuItem();
        jMenu_REFLASH = new javax.swing.JMenuItem();
        about = new javax.swing.JMenu();
        reac = new javax.swing.JMenuItem();
        reurl = new javax.swing.JMenuItem();
        jMenuex = new javax.swing.JMenuItem();
        aboutme = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setMinimumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit.setText("離開");
        exit.setMaximumSize(new java.awt.Dimension(60, 50));
        exit.setMinimumSize(new java.awt.Dimension(60, 50));
        exit.setPreferredSize(new java.awt.Dimension(60, 50));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1116, 624, 72, -1));

        singout.setText("登出");
        singout.setMaximumSize(new java.awt.Dimension(85, 50));
        singout.setMinimumSize(new java.awt.Dimension(85, 50));
        singout.setPreferredSize(new java.awt.Dimension(85, 50));
        singout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singoutActionPerformed(evt);
            }
        });
        jPanel1.add(singout, new org.netbeans.lib.awtextra.AbsoluteConstraints(996, 624, -1, -1));

        jTable_Display_User.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        jTable_Display_User.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "編號", "名字", "姓氏", "電子郵件", "性別"
            }
        ));
        jTable_Display_User.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Display_UserMouseClicked(evt);
            }
        });
        jTable_Display_User.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable_Display_UserKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Display_User);

        javax.swing.GroupLayout jPanelEmpioyeesLayout = new javax.swing.GroupLayout(jPanelEmpioyees);
        jPanelEmpioyees.setLayout(jPanelEmpioyeesLayout);
        jPanelEmpioyeesLayout.setHorizontalGroup(
            jPanelEmpioyeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1277, Short.MAX_VALUE)
        );
        jPanelEmpioyeesLayout.setVerticalGroup(
            jPanelEmpioyeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmpioyeesLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanelEmpioyees, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        JTable_Display_VIP.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        JTable_Display_VIP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "編號", "名字", "姓氏", "電子郵件", "性別"
            }
        ));
        JTable_Display_VIP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_Display_VIPMouseClicked(evt);
            }
        });
        JTable_Display_VIP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTable_Display_VIPKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(JTable_Display_VIP);

        javax.swing.GroupLayout jPanelVIPLayout = new javax.swing.GroupLayout(jPanelVIP);
        jPanelVIP.setLayout(jPanelVIPLayout);
        jPanelVIPLayout.setHorizontalGroup(
            jPanelVIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1277, Short.MAX_VALUE)
        );
        jPanelVIPLayout.setVerticalGroup(
            jPanelVIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVIPLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanelVIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        update.setText("更新");
        update.setMaximumSize(new java.awt.Dimension(70, 25));
        update.setMinimumSize(new java.awt.Dimension(70, 25));
        update.setPreferredSize(new java.awt.Dimension(70, 25));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        save.setText("新增");
        save.setMaximumSize(new java.awt.Dimension(70, 25));
        save.setMinimumSize(new java.awt.Dimension(70, 25));
        save.setPreferredSize(new java.awt.Dimension(70, 25));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        reset.setText("清空");
        reset.setMaximumSize(new java.awt.Dimension(70, 25));
        reset.setMinimumSize(new java.awt.Dimension(70, 25));
        reset.setPreferredSize(new java.awt.Dimension(70, 25));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        delete.setText("刪除");
        delete.setMaximumSize(new java.awt.Dimension(70, 25));
        delete.setMinimumSize(new java.awt.Dimension(70, 25));
        delete.setPreferredSize(new java.awt.Dimension(70, 25));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        jLabel1.setText("    名字 :");
        jLabel1.setMaximumSize(new java.awt.Dimension(70, 30));
        jLabel1.setMinimumSize(new java.awt.Dimension(70, 30));
        jLabel1.setPreferredSize(new java.awt.Dimension(80, 30));

        jLabel2.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        jLabel2.setText("    姓氏  :");
        jLabel2.setMaximumSize(new java.awt.Dimension(70, 30));
        jLabel2.setMinimumSize(new java.awt.Dimension(70, 30));
        jLabel2.setPreferredSize(new java.awt.Dimension(80, 30));

        jLabel3.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        jLabel3.setText("電子郵件 :");
        jLabel3.setMaximumSize(new java.awt.Dimension(50, 30));
        jLabel3.setMinimumSize(new java.awt.Dimension(50, 30));
        jLabel3.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel4.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        jLabel4.setText("性別  :");
        jLabel4.setMaximumSize(new java.awt.Dimension(50, 30));
        jLabel4.setMinimumSize(new java.awt.Dimension(50, 30));
        jLabel4.setName(""); // NOI18N
        jLabel4.setPreferredSize(new java.awt.Dimension(60, 30));

        first_name.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        first_name.setText("實名");
        first_name.setPreferredSize(new java.awt.Dimension(110, 30));

        email.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        email.setText("電子郵件");
        email.setPreferredSize(new java.awt.Dimension(150, 30));

        last_name.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        last_name.setText("實姓");
        last_name.setPreferredSize(new java.awt.Dimension(110, 30));

        gender.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BOY 男", "GIRL 女" }));
        gender.setMinimumSize(new java.awt.Dimension(80, 30));
        gender.setPreferredSize(new java.awt.Dimension(85, 30));

        javax.swing.GroupLayout jPanelBELayout = new javax.swing.GroupLayout(jPanelBE);
        jPanelBE.setLayout(jPanelBELayout);
        jPanelBELayout.setHorizontalGroup(
            jPanelBELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBELayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelBELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(first_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelBELayout.createSequentialGroup()
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanelBELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBELayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelBELayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(last_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
            .addGroup(jPanelBELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBELayout.createSequentialGroup()
                    .addGap(0, 2, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(140, 140, 140)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(130, 130, 130)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(184, 184, 184)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 95, Short.MAX_VALUE)))
        );
        jPanelBELayout.setVerticalGroup(
            jPanelBELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBELayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(first_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(last_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
            .addGroup(jPanelBELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBELayout.createSequentialGroup()
                    .addGap(0, 13, Short.MAX_VALUE)
                    .addGroup(jPanelBELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 64, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanelBE, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 612, 840, 100));

        updateVIP.setText("更新");
        updateVIP.setMaximumSize(new java.awt.Dimension(70, 25));
        updateVIP.setMinimumSize(new java.awt.Dimension(70, 25));
        updateVIP.setPreferredSize(new java.awt.Dimension(70, 25));
        updateVIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateVIPActionPerformed(evt);
            }
        });

        saveVIP.setText("新增");
        saveVIP.setMaximumSize(new java.awt.Dimension(70, 25));
        saveVIP.setMinimumSize(new java.awt.Dimension(70, 25));
        saveVIP.setPreferredSize(new java.awt.Dimension(70, 25));
        saveVIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveVIPActionPerformed(evt);
            }
        });

        resetVIP.setText("清空");
        resetVIP.setMaximumSize(new java.awt.Dimension(70, 25));
        resetVIP.setMinimumSize(new java.awt.Dimension(70, 25));
        resetVIP.setPreferredSize(new java.awt.Dimension(70, 25));
        resetVIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetVIPActionPerformed(evt);
            }
        });

        deleteVIP.setText("刪除");
        deleteVIP.setMaximumSize(new java.awt.Dimension(70, 25));
        deleteVIP.setMinimumSize(new java.awt.Dimension(70, 25));
        deleteVIP.setPreferredSize(new java.awt.Dimension(70, 25));
        deleteVIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteVIPActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        jLabel5.setText("    名字 :");
        jLabel5.setMaximumSize(new java.awt.Dimension(70, 30));
        jLabel5.setMinimumSize(new java.awt.Dimension(70, 30));
        jLabel5.setPreferredSize(new java.awt.Dimension(80, 30));

        jLabel6.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        jLabel6.setText("    姓氏  :");
        jLabel6.setMaximumSize(new java.awt.Dimension(70, 30));
        jLabel6.setMinimumSize(new java.awt.Dimension(70, 30));
        jLabel6.setPreferredSize(new java.awt.Dimension(80, 30));

        jLabel7.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        jLabel7.setText("電子郵件 :");
        jLabel7.setMaximumSize(new java.awt.Dimension(50, 30));
        jLabel7.setMinimumSize(new java.awt.Dimension(50, 30));
        jLabel7.setPreferredSize(new java.awt.Dimension(60, 30));

        jLabel8.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        jLabel8.setText("性別  :");
        jLabel8.setMaximumSize(new java.awt.Dimension(50, 30));
        jLabel8.setMinimumSize(new java.awt.Dimension(50, 30));
        jLabel8.setName(""); // NOI18N
        jLabel8.setPreferredSize(new java.awt.Dimension(60, 30));

        first_name1.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        first_name1.setText("實名");
        first_name1.setPreferredSize(new java.awt.Dimension(110, 30));

        last_name1.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        last_name1.setText("實姓");
        last_name1.setPreferredSize(new java.awt.Dimension(110, 30));

        email1.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        email1.setText("電子郵件");
        email1.setPreferredSize(new java.awt.Dimension(150, 30));

        gender1.setFont(new java.awt.Font("微軟正黑體", 0, 14)); // NOI18N
        gender1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BOY 男", "GIRL 女" }));
        gender1.setMinimumSize(new java.awt.Dimension(80, 30));
        gender1.setPreferredSize(new java.awt.Dimension(85, 30));

        javax.swing.GroupLayout jPanelBVLayout = new javax.swing.GroupLayout(jPanelBV);
        jPanelBV.setLayout(jPanelBVLayout);
        jPanelBVLayout.setHorizontalGroup(
            jPanelBVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBVLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelBVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(first_name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelBVLayout.createSequentialGroup()
                        .addComponent(resetVIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(saveVIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanelBVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBVLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(updateVIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteVIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelBVLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(last_name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(email1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(gender1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
            .addGroup(jPanelBVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBVLayout.createSequentialGroup()
                    .addGap(0, 2, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(140, 140, 140)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(130, 130, 130)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(184, 184, 184)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 95, Short.MAX_VALUE)))
        );
        jPanelBVLayout.setVerticalGroup(
            jPanelBVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBVLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelBVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(first_name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(last_name1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gender1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetVIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveVIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateVIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteVIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
            .addGroup(jPanelBVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelBVLayout.createSequentialGroup()
                    .addGap(0, 13, Short.MAX_VALUE)
                    .addGroup(jPanelBVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 64, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanelBV, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 612, 840, 100));

        flie.setText("功能");
        flie.setPreferredSize(new java.awt.Dimension(35, 20));

        jMenu_ingout.setText("登出");
        jMenu_ingout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_ingoutActionPerformed(evt);
            }
        });
        flie.add(jMenu_ingout);

        jMenu_exit.setText("離開");
        jMenu_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_exitActionPerformed(evt);
            }
        });
        flie.add(jMenu_exit);

        jMenuBar1.add(flie);

        edit.setText("編輯");
        edit.setPreferredSize(new java.awt.Dimension(35, 20));

        JMenu_dblist.setText("資料庫");

        list_1.setText("list1");
        list_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list_1ActionPerformed(evt);
            }
        });
        JMenu_dblist.add(list_1);

        list_2.setText("list2");
        list_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list_2ActionPerformed(evt);
            }
        });
        JMenu_dblist.add(list_2);

        edit.add(JMenu_dblist);

        jMenu_REFLASH.setText("重新整理");
        jMenu_REFLASH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_REFLASHActionPerformed(evt);
            }
        });
        edit.add(jMenu_REFLASH);

        jMenuBar1.add(edit);

        about.setText("關於");
        about.setPreferredSize(new java.awt.Dimension(35, 20));

        reac.setText("Username");
        about.add(reac);

        reurl.setText("URL");
        about.add(reurl);

        jMenuex.setText("使用說明");
        jMenuex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuexActionPerformed(evt);
            }
        });
        about.add(jMenuex);

        aboutme.setText("關於我");
        aboutme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutmeActionPerformed(evt);
            }
        });
        about.add(aboutme);

        jMenuBar1.add(about);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //各項按鈕動作設定
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        //離開按鈕的設定    
        if(evt.getSource()==exit)
            {
                dispose();
                System.exit(0);
            }
    }//GEN-LAST:event_exitActionPerformed

    private void singoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singoutActionPerformed
        //登出按鈕的設定
        if(evt.getSource()==singout)
            {
                dispose();
                LoginJF back = new LoginJF();
                back.LoginSwing();
            }
    }//GEN-LAST:event_singoutActionPerformed

    private void jMenu_REFLASHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_REFLASHActionPerformed
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(sqlurl, sqlaccount, sqlpassword);
            DefaultTableModel model = (DefaultTableModel)jTable_Display_User.getModel();
            model.setRowCount(0);
            show_user();
            DefaultTableModel model2 = (DefaultTableModel)JTable_Display_VIP.getModel();
            model2.setRowCount(0);
            show_vip();
            JOptionPane.showMessageDialog(null, "已重新整理 !");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu_REFLASHActionPerformed

    private void jMenu_ingoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_ingoutActionPerformed
        // TODO add your handling code here:
        //登出按鈕的設定
        if(evt.getSource()==jMenu_ingout)
            {
                dispose();
                LoginJF back = new LoginJF();
                back.LoginSwing();
            }
    }//GEN-LAST:event_jMenu_ingoutActionPerformed

    private void jMenu_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_exitActionPerformed
        // TODO add your handling code here:
        //離開按鈕的設定    
        if(evt.getSource()==jMenu_exit)
            {
                dispose();
                System.exit(0);
            }
    }//GEN-LAST:event_jMenu_exitActionPerformed

    private void list_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable_Display_User.getModel();
        model.setRowCount(0);
        show_user();
        jPanelEmpioyees.setVisible(true);
        jPanelBE.setVisible(true);
        jPanelVIP.setVisible(false);
        jPanelBV.setVisible(false);
        JOptionPane.showMessageDialog(null, "已進入一般會員表單 !");
        
    }//GEN-LAST:event_list_1ActionPerformed

    private void list_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_2ActionPerformed
        DefaultTableModel model = (DefaultTableModel)JTable_Display_VIP.getModel();
        model.setRowCount(0);
        show_vip();
        jPanelEmpioyees.setVisible(false);
        jPanelBE.setVisible(false);
        jPanelVIP.setVisible(true);
        jPanelBV.setVisible(true);
        JOptionPane.showMessageDialog(null, "已進入VIP會員表單 !");
    }//GEN-LAST:event_list_2ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // 更新按鈕
        try{
            //登入資料獲取
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(sqlurl, sqlaccount, sqlpassword);
            // 更新資料的設定
            int row = jTable_Display_User.getSelectedRow();
            String value = (jTable_Display_User.getModel().getValueAt(row, 0).toString());
            String query ="UPDATE employees SET first_name=?, last_name=?, email=?, gender=? where id="+value;
            PreparedStatement pst = myConn.prepareStatement(query);
            pst.setString(1, first_name.getText());
            pst.setString(2, last_name.getText());
            pst.setString(3, email.getText());
            String Cgender;
            Cgender = gender.getSelectedItem().toString();
            pst.setString(4, Cgender);
            pst.executeUpdate();
            //重新整理
            DefaultTableModel model = (DefaultTableModel)jTable_Display_User.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null, "更新完成! ");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        //新增按鈕
        try{
            //登入資料獲取
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(sqlurl, sqlaccount, sqlpassword);
            //新增資料設定
            String query = "insert into employees(first_name, last_name, email, gender)values(?, ?, ?, ?)";
            PreparedStatement pst = myConn.prepareStatement(query);
            pst.setString(1, first_name.getText());
            pst.setString(2, last_name.getText());
            pst.setString(3, email.getText());
            String Cgender;
            Cgender = gender.getSelectedItem().toString();
            pst.setString(4, Cgender);
            pst.executeUpdate();
            //自動重新整理
            DefaultTableModel model = (DefaultTableModel)jTable_Display_User.getModel();
            model.setRowCount(0);
            show_user();
            //跳窗
            JOptionPane.showMessageDialog(null, "新增完成! ");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        //清空輸入欄的設定
        first_name.setText("");
        last_name.setText("");
        email.setText("");
    }//GEN-LAST:event_resetActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // 刪除按鈕
        try{
            //登入資料獲取
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(sqlurl, sqlaccount, sqlpassword);
            //刪除動作的設定
            int row = jTable_Display_User.getSelectedRow();
            String value = (jTable_Display_User.getModel().getValueAt(row, 0).toString());
            String query = "DELETE FROM employees where id="+value;
            PreparedStatement pst = myConn.prepareStatement(query);
            pst.executeUpdate();
            //重新整理
            DefaultTableModel model = (DefaultTableModel)jTable_Display_User.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null, "已刪除 !");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void aboutmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutmeActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "關於我 : "
                                            + "\n聯絡方式 : enelmoney@gmail.com"
                                            + "\nFB : https://www.facebook.com/aellnchien");
    }//GEN-LAST:event_aboutmeActionPerformed

    private void jMenuexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuexActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "使用說明: \n1. 在下方欄位輸入資料後按 '新增' 即可新增資料. \n2. 如需修改資料先點擊中間資料表欄位再按 '修改' 即可完成修改. "
                                                    + "\n3. 如需刪除資料先點擊中間資料表欄位再按 '刪除' 即可完成刪除.");
    }//GEN-LAST:event_jMenuexActionPerformed

    private void jTable_Display_UserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable_Display_UserKeyPressed
        //使用上下鍵自動輸入
        if(evt.getKeyCode() == KeyEvent.VK_DOWN) {
            int i = jTable_Display_User.getSelectedRow();
            TableModel model = jTable_Display_User.getModel();
            first_name.setText(model.getValueAt((i+1), 1).toString());
            last_name.setText(model.getValueAt((i+1), 2).toString());
            email.setText(model.getValueAt((i+1), 3).toString());
            String bgender = model.getValueAt((i+1), 4).toString();
            switch(bgender)
            {
                case "BOY 男":
                gender.setSelectedIndex(0);
                break;
                case "GIRL 女":
                gender.setSelectedIndex(1);
                break;
            }
        }
        else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            int i = jTable_Display_User.getSelectedRow();
            TableModel model = jTable_Display_User.getModel();
            first_name.setText(model.getValueAt((i-1), 1).toString());
            last_name.setText(model.getValueAt((i-1), 2).toString());
            email.setText(model.getValueAt((i-1), 3).toString());
            String bgender = model.getValueAt((i-1), 4).toString();
            switch(bgender)
            {
                case "BOY 男":
                gender.setSelectedIndex(0);
                break;
                case "GIRL 女":
                gender.setSelectedIndex(1);
                break;
            }
        }
        else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int i = jTable_Display_User.getSelectedRow();
            TableModel model = jTable_Display_User.getModel();
            first_name.setText(model.getValueAt((i+1), 1).toString());
            last_name.setText(model.getValueAt((i+1), 2).toString());
            email.setText(model.getValueAt((i+1), 3).toString());
            String bgender = model.getValueAt((i+1), 4).toString();
            switch(bgender)
            {
                case "BOY 男":
                gender.setSelectedIndex(0);
                break;
                case "GIRL 女":
                gender.setSelectedIndex(1);
                break;
            }
        }
        else {
            System.out.print(evt.getKeyCode());
        }
    }//GEN-LAST:event_jTable_Display_UserKeyPressed

    private void jTable_Display_UserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_UserMouseClicked
        // 點擊資料並SET到下方輸入欄
        int i = jTable_Display_User.getSelectedRow();
        TableModel model = jTable_Display_User.getModel();
        first_name.setText(model.getValueAt(i, 1).toString());
        last_name.setText(model.getValueAt(i, 2).toString());
        email.setText(model.getValueAt(i, 3).toString());
        String bgender = model.getValueAt(i, 4).toString();
        switch(bgender)
        {
            case "BOY 男":
            gender.setSelectedIndex(0);
            break;
            case "GIRL 女":
            gender.setSelectedIndex(1);
            break;
        }
    }//GEN-LAST:event_jTable_Display_UserMouseClicked

    private void JTable_Display_VIPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_Display_VIPMouseClicked
        // 點擊資料並SET到下方輸入欄
        int i = JTable_Display_VIP.getSelectedRow();
        TableModel model = JTable_Display_VIP.getModel();
        first_name1.setText(model.getValueAt(i, 1).toString());
        last_name1.setText(model.getValueAt(i, 2).toString());
        email1.setText(model.getValueAt(i, 3).toString());
        String bgender = model.getValueAt(i, 4).toString();
        switch(bgender)
        {
            case "BOY 男":
            gender1.setSelectedIndex(0);
            break;
            case "GIRL 女":
            gender1.setSelectedIndex(1);
            break;
        }
    }//GEN-LAST:event_JTable_Display_VIPMouseClicked

    private void JTable_Display_VIPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTable_Display_VIPKeyPressed
        //使用上下鍵自動輸入
        if(evt.getKeyCode() == KeyEvent.VK_DOWN) {
            int i = JTable_Display_VIP.getSelectedRow();
            TableModel model = JTable_Display_VIP.getModel();
            first_name1.setText(model.getValueAt((i+1), 1).toString());
            last_name1.setText(model.getValueAt((i+1), 2).toString());
            email1.setText(model.getValueAt((i+1), 3).toString());
            String bgender = model.getValueAt((i+1), 4).toString();
            switch(bgender)
            {
                case "BOY 男":
                gender1.setSelectedIndex(0);
                break;
                case "GIRL 女":
                gender1.setSelectedIndex(1);
                break;
            }
        }
        else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            int i = JTable_Display_VIP.getSelectedRow();
            TableModel model = JTable_Display_VIP.getModel();
            first_name1.setText(model.getValueAt((i-1), 1).toString());
            last_name1.setText(model.getValueAt((i-1), 2).toString());
            email1.setText(model.getValueAt((i-1), 3).toString());
            String bgender = model.getValueAt((i-1), 4).toString();
            switch(bgender)
            {
                case "BOY 男":
                gender1.setSelectedIndex(0);
                break;
                case "GIRL 女":
                gender1.setSelectedIndex(1);
                break;
            }
        }
        else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int i = JTable_Display_VIP.getSelectedRow();
            TableModel model = JTable_Display_VIP.getModel();
            first_name1.setText(model.getValueAt((i+1), 1).toString());
            last_name1.setText(model.getValueAt((i+1), 2).toString());
            email1.setText(model.getValueAt((i+1), 3).toString());
            String bgender = model.getValueAt((i+1), 4).toString();
            switch(bgender)
            {
                case "BOY 男":
                gender1.setSelectedIndex(0);
                break;
                case "GIRL 女":
                gender1.setSelectedIndex(1);
                break;
            }
        }
        else {
            System.out.print(evt.getKeyCode());
        }
    }//GEN-LAST:event_JTable_Display_VIPKeyPressed

    private void updateVIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateVIPActionPerformed
        // 更新按鈕
        try{
            //登入資料獲取
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(sqlurl, sqlaccount, sqlpassword);
            // 更新資料的設定
            int row = JTable_Display_VIP.getSelectedRow();
            String value = (JTable_Display_VIP.getModel().getValueAt(row, 0).toString());
            String query ="UPDATE VIP SET VIP_first_name=?, VIP_last_name=?, VIP_email=?, VIP_gender=? where VIP_id="+value;
            PreparedStatement pst = myConn.prepareStatement(query);
            pst.setString(1, first_name1.getText());
            pst.setString(2, last_name1.getText());
            pst.setString(3, email1.getText());
            String Cgender;
            Cgender = gender1.getSelectedItem().toString();
            pst.setString(4, Cgender);
            pst.executeUpdate();
            //重新整理
            DefaultTableModel model = (DefaultTableModel)JTable_Display_VIP.getModel();
            model.setRowCount(0);
            show_vip();
            JOptionPane.showMessageDialog(null, "更新完成! ");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateVIPActionPerformed

    private void saveVIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveVIPActionPerformed
        //新增按鈕
        try{
            //登入資料獲取
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(sqlurl, sqlaccount, sqlpassword);
            //新增資料設定
            String query = "insert into VIP(VIP_first_name, VIP_last_name, VIP_email, VIP_gender)values(?, ?, ?, ?)";
            PreparedStatement pst = myConn.prepareStatement(query);
            pst.setString(1, first_name1.getText());
            pst.setString(2, last_name1.getText());
            pst.setString(3, email1.getText());
            String Cgender;
            Cgender = gender1.getSelectedItem().toString();
            pst.setString(4, Cgender);
            pst.executeUpdate();
            //自動重新整理
            DefaultTableModel model = (DefaultTableModel)JTable_Display_VIP.getModel();
            model.setRowCount(0);
            show_vip();
            //跳窗
            JOptionPane.showMessageDialog(null, "新增完成! ");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveVIPActionPerformed

    private void resetVIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetVIPActionPerformed
        //清空輸入欄的設定
        first_name1.setText("");
        last_name1.setText("");
        email1.setText("");
    }//GEN-LAST:event_resetVIPActionPerformed

    private void deleteVIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteVIPActionPerformed
        // 刪除按鈕
        try{
            //登入資料獲取
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection myConn = DriverManager.getConnection(sqlurl, sqlaccount, sqlpassword);
            //刪除動作的設定
            int row = JTable_Display_VIP.getSelectedRow();
            String value = (JTable_Display_VIP.getModel().getValueAt(row, 0).toString());
            String query = "DELETE FROM VIP where VIP_id="+value;
            PreparedStatement pst = myConn.prepareStatement(query);
            pst.executeUpdate();
            //重新整理
            DefaultTableModel model = (DefaultTableModel)JTable_Display_VIP.getModel();
            model.setRowCount(0);
            show_vip();
            JOptionPane.showMessageDialog(null, "已刪除 !");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQLHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteVIPActionPerformed

    
    /**
     * 顯示出視窗設定
     */
    public void showSQL()
    {   
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SQLHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
         /* Create and display the form */
        setVisible(true); //顯示視窗
        setTitle("SQL後臺管理系統"); //標題設定
        setIconImage(Toolkit.getDefaultToolkit().getImage(SQLHome.class.getResource("/images/logicon.jpg"))); //圖示ICON設定
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //預設關閉方法
        setLocation(450,180); //開啟的預設位置
        setResizable(false); //禁止調整大小
        JOptionPane.showMessageDialog(null, "使用說明: \n1. 在下方欄位輸入資料後按 '新增' 即可新增資料. \n2. 如需修改資料先點擊中間資料表欄位再按 '修改' 即可完成修改. "
                                                    + "\n3. 如需刪除資料先點擊中間資料表欄位再按 '刪除' 即可完成刪除.");
    }

    //按鈕命名
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu JMenu_dblist;
    private javax.swing.JTable JTable_Display_VIP;
    private javax.swing.JMenu about;
    private javax.swing.JMenuItem aboutme;
    private javax.swing.JButton delete;
    private javax.swing.JButton deleteVIP;
    private javax.swing.JMenu edit;
    private javax.swing.JTextField email;
    private javax.swing.JTextField email1;
    private javax.swing.JButton exit;
    private javax.swing.JTextField first_name;
    private javax.swing.JTextField first_name1;
    private javax.swing.JMenu flie;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JComboBox<String> gender1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenu_REFLASH;
    private javax.swing.JMenuItem jMenu_exit;
    private javax.swing.JMenuItem jMenu_ingout;
    private javax.swing.JMenuItem jMenuex;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBE;
    private javax.swing.JPanel jPanelBV;
    private javax.swing.JPanel jPanelEmpioyees;
    private javax.swing.JPanel jPanelVIP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Display_User;
    private javax.swing.JTextField last_name;
    private javax.swing.JTextField last_name1;
    public javax.swing.JMenuItem list_1;
    public javax.swing.JMenuItem list_2;
    public javax.swing.JMenuItem reac;
    private javax.swing.JButton reset;
    private javax.swing.JButton resetVIP;
    public javax.swing.JMenuItem reurl;
    private javax.swing.JButton save;
    private javax.swing.JButton saveVIP;
    private javax.swing.JButton singout;
    private javax.swing.JButton update;
    private javax.swing.JButton updateVIP;
    // End of variables declaration//GEN-END:variables
}
