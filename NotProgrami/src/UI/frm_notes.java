package UI;

import BLL.customers;
import BLL.mainclass;
import static BLL.mainclass.mesaj;
import BLL.notes;
import DLL.dbhelper;
import DLL.tbl_customers;
import DLL.tbl_notes;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*java with mawen => java application mysql connect etmek için  dependencies e sağ tık add dependency .... tıkla mysql   connection ismi -8.. haricinde altına versiyon tmmde sonra çıkan dosaya sagtık en üstteki ssçe  aynı connetion dosyayı seç ok */
/*java with ant => java application Libraries sağ tık addjar/folder de C:\Program Files\MySQL\mysql-connector-java-8.0.26.jar bunu bul indirerek (mysql ana klasörüne attım ben tke halde) open de ok yada direk burda var C:\Users\hasan\.m2\repository\mysql\mysql-connector-java\8.0.25\mysql-connector-java-8.0.25.jar bunuda gösterebilirsin*/
 /*view yüklemek için viwelerin orda sağtıkla paltte manageer add from jar jarlı dosyalı seçiyoruz next de hangisi view yüklüceksen seç netx de sonra hangi klasörde durcaksa seç finish de sonra close  hata veriyosa kaldır dosyayı tekrar yükle düzeliyo saçma ama öle :D*/
public final class frm_notes extends javax.swing.JFrame {

    DefaultTableModel model, CUSTOMERMODEL;
    ArrayList<notes> mnotes;
    ArrayList<customers> customer;
    Connection connection = null;
    dbhelper dbhelper = new dbhelper();
    Statement statement = null;
    PreparedStatement pstatement = null;
    ResultSet resultSet = null;
    String sorgu = "";
    ArrayList<notes> anotes = null;/*null verdik yoksa return en sonda bu değer bos olduğu gördüğü içöin hata veriyourdu*/
    tbl_notes tbl_notes = null;
    tbl_customers tbl_customers = null;

    int selectid = 0;
    int tblcustomerid = 0;
    java.util.Date date;

    String mindate = "01.01.2000 00:00";
    String maxdate = "01.01.2050 00:00";

    mainclass mc = null;
    DateFormat dateFormat;
    tbl_customers tbl_cus = null;

    public frm_notes() throws ParseException {
        initComponents();
        frm_load();
    }

    public void frm_load() throws ParseException {
       customercmbdoldur();

    }

    public void customercmbdoldur() {
        try {
            tbl_customers = new tbl_customers();
            mc = new mainclass();
            /* DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");*/
            customer = tbl_customers.notesList();
            JCMBSCCOMPANY.removeAllItems();
            JCMBCOMPANY.removeAllItems();
            JCMBSCCOMPANY.addItem("HEPSİ");
            JCMBCOMPANY.addItem("Seçiniz");
            for (customers customer_ : customer) {
                JCMBSCCOMPANY.addItem(customer_.getCUSTOMERNAME().toString());
                JCMBCOMPANY.addItem(customer_.getCUSTOMERNAME().toString());
            }
        } catch (SQLException ex) {
            dbhelper.showErrorMessage(ex);
        } catch (ParseException ex) {
        }
    }

    public void notesList() throws ParseException {
        model = (DefaultTableModel) TBLNOTES.getModel();
        /*tablo temizleme*/
        model.setRowCount(0);
        /*tablo temizleme*/
        try {
            tbl_notes = new tbl_notes();
            tbl_cus = new tbl_customers();
            mc = new mainclass();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            mnotes = tbl_notes.notesList(TFSCID.getText(), JCMBSCNOTETYPE.getSelectedIndex(), JCMBSCCOMPANY.getSelectedIndex(), TFSCSUBJECT.getText(), TFSCDESCRIPTION.getText(), String.valueOf(df.format(JDCSCCREATEDATE1.getDate())), String.valueOf(df.format(JDCSCCREATEDATE2.getDate())), String.valueOf(df.format(JDCSCREQUESTDATE1.getDate())), String.valueOf(df.format(JDCSCREQUESTDATE2.getDate())), String.valueOf(df.format(JDCSCDELIVERTYDATE1.getDate())), String.valueOf(df.format(JDCSCDELIVERTYDATE2.getDate())), String.valueOf(df.format(JDCSCPLANDATE1.getDate())), String.valueOf(df.format(JDCSCPLANDATE2.getDate())), JCMBSCISPICTURE.getSelectedIndex(), JCMBSCISWAIT.getSelectedIndex(), JCMBSCISDO.getSelectedIndex(), JCMBSCSTATUS.getSelectedIndex(), 1);
            if (mnotes.stream().count() > 0) {
                for (notes notes_ : mnotes) {
                    /*String dizi olamazdı çünkü int de var object dizisinede alınabilir*/
                    Object[] row = {
                        notes_.getId(),
                        mc.nottype(notes_.getNoteType()),
                        tbl_cus.Customerdata(notes_.getCompanyId()),
                        notes_.getSubject(),
                        notes_.getDescription(),
                        notes_.getCreateDate(),
                        notes_.getRequestDate(),
                        notes_.getDelivertyDate(),
                        notes_.getPlanDate(),
                        mc.yesMiNoMu(notes_.getIsPicture()),
                        mc.yesMiNoMu(notes_.getIsWait()),
                        mc.yesMiNoMu(notes_.getDo_()),
                        mc.durum(notes_.getStatus()),
                        notes_.getUserId()
                    };
                    /*for (int i = 0; i < row.length; i++) {
                        System.out.println(row[i]); // Tüm değerleri tek tek yazdırıyoruz
                    }*/
                    model.addRow(row);
                }
            }
        } catch (SQLException ex) {
            dbhelper.showErrorMessage(ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBLNOTES = new javax.swing.JTable();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        JCMBSCNOTETYPE = new javax.swing.JComboBox<>();
        JCMBSCCOMPANY = new javax.swing.JComboBox<>();
        TFSCSUBJECT = new javax.swing.JTextField();
        TFSCDESCRIPTION = new javax.swing.JTextField();
        JCMBSCISPICTURE = new javax.swing.JComboBox<>();
        JCMBSCISWAIT = new javax.swing.JComboBox<>();
        JCMBSCISDO = new javax.swing.JComboBox<>();
        JCMBSCSTATUS = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        TFSCID = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jlbl_id = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        JDCSCREQUESTDATE2 = new com.toedter.calendar.JDateChooser();
        JDCSCREQUESTDATE1 = new com.toedter.calendar.JDateChooser();
        JDCSCDELIVERTYDATE1 = new com.toedter.calendar.JDateChooser();
        JDCSCPLANDATE1 = new com.toedter.calendar.JDateChooser();
        JDCSCDELIVERTYDATE2 = new com.toedter.calendar.JDateChooser();
        JDCSCCREATEDATE1 = new com.toedter.calendar.JDateChooser();
        JDCSCCREATEDATE2 = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        BTNSCCREATEDATE1MIN = new javax.swing.JButton();
        JDCSCPLANDATE2 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        BTNSCCREATEDATE1NOW = new javax.swing.JButton();
        BTNSCCREATEDATE2NOW = new javax.swing.JButton();
        BTNSCCREATEDATE2MAX = new javax.swing.JButton();
        BTNSCREQUESTDATE1MIN = new javax.swing.JButton();
        BTNSCREQUESTDATE1NOW = new javax.swing.JButton();
        BTNSCREQUESTDATE2MAX = new javax.swing.JButton();
        BTNSCREQUESTDATE2NOW = new javax.swing.JButton();
        BTNSCDELIVERTYDATE1MIN = new javax.swing.JButton();
        BTNSCDELIVERTYDATE1NOW = new javax.swing.JButton();
        BTNSCDELIVERTYDATE2MAX = new javax.swing.JButton();
        BTNSCDELIVERTYDATE2NOW = new javax.swing.JButton();
        BTNSCPLANDATE1MIN = new javax.swing.JButton();
        BTNSCPLANDATE1NOW = new javax.swing.JButton();
        BTNSCPLANDATE2MAX = new javax.swing.JButton();
        BTNSCPLANDATE2NOW = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        JCBISPUCTURE = new javax.swing.JCheckBox();
        JCBISDO = new javax.swing.JCheckBox();
        JCBISWAIT = new javax.swing.JCheckBox();
        TFID = new javax.swing.JTextField();
        JCMBNOTETYPE = new javax.swing.JComboBox<>();
        JCMBCOMPANY = new javax.swing.JComboBox<>();
        JDCCREATEDATE = new com.toedter.calendar.JDateChooser();
        JCBSTATUS = new javax.swing.JCheckBox();
        BTNDELIVERYDATENOW = new javax.swing.JButton();
        BTNDELIVERYDATEMAX = new javax.swing.JButton();
        JDCDELIVERYDATE = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        BTNREQUESTDATENOW = new javax.swing.JButton();
        BTNREQUESTDATEMAX = new javax.swing.JButton();
        JDCREQUESTDATE = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        BTNPLANDATENOW = new javax.swing.JButton();
        BTNPLANDATEMAX = new javax.swing.JButton();
        JDCPLANDATE = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTADESCRIPTION = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTASUBJECT = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BTNSEARCH = new javax.swing.JButton();
        BTNSCCLEAR = new javax.swing.JButton();
        BTNADD = new javax.swing.JButton();
        BTNUPDATE = new javax.swing.JButton();
        BTNDELETE = new javax.swing.JButton();
        BTNCLEAR = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TBLCUSTOMER = new javax.swing.JTable();
        JTFCUSTOMER = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        JTFCUSTOMERNAME = new javax.swing.JTextField();
        BTNCUSTOMERADD = new javax.swing.JButton();
        BTNCUSTOMERUPDATE = new javax.swing.JButton();
        BTNCUSTOMERDEL = new javax.swing.JButton();
        BTNCUSTOMERCLEAR = new javax.swing.JButton();
        BTNCUSTOMERLIST = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1280, 680));
        setPreferredSize(new java.awt.Dimension(1280, 680));

        jTextField1.setText("jTextField1");
        jTextField1.setUI(null);

        jTabbedPane3.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane3.setAutoscrolls(true);
        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jPanel7.setAutoscrolls(true);
        jPanel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        TBLNOTES.setAutoCreateRowSorter(true);
        TBLNOTES.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        TBLNOTES.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NotTipi", "Müşteri", "Konu", "Açıklama", "Oluş. T.", "Talep T.", "Teslim T.", "Plan. T.", "Resim?", "Bekle?", "Bitti?", "Durum?", "Kull."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBLNOTES.setShowGrid(false);
        TBLNOTES.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBLNOTESMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBLNOTES);
        if (TBLNOTES.getColumnModel().getColumnCount() > 0) {
            TBLNOTES.getColumnModel().getColumn(0).setMinWidth(30);
            TBLNOTES.getColumnModel().getColumn(0).setPreferredWidth(30);
            TBLNOTES.getColumnModel().getColumn(0).setMaxWidth(30);
            TBLNOTES.getColumnModel().getColumn(1).setMinWidth(50);
            TBLNOTES.getColumnModel().getColumn(1).setPreferredWidth(50);
            TBLNOTES.getColumnModel().getColumn(1).setMaxWidth(50);
            TBLNOTES.getColumnModel().getColumn(2).setMinWidth(80);
            TBLNOTES.getColumnModel().getColumn(2).setPreferredWidth(80);
            TBLNOTES.getColumnModel().getColumn(2).setMaxWidth(80);
            TBLNOTES.getColumnModel().getColumn(3).setMinWidth(120);
            TBLNOTES.getColumnModel().getColumn(3).setPreferredWidth(120);
            TBLNOTES.getColumnModel().getColumn(3).setMaxWidth(120);
            TBLNOTES.getColumnModel().getColumn(5).setMinWidth(70);
            TBLNOTES.getColumnModel().getColumn(5).setPreferredWidth(70);
            TBLNOTES.getColumnModel().getColumn(5).setMaxWidth(70);
            TBLNOTES.getColumnModel().getColumn(6).setMinWidth(70);
            TBLNOTES.getColumnModel().getColumn(6).setPreferredWidth(70);
            TBLNOTES.getColumnModel().getColumn(6).setMaxWidth(70);
            TBLNOTES.getColumnModel().getColumn(7).setMinWidth(70);
            TBLNOTES.getColumnModel().getColumn(7).setPreferredWidth(70);
            TBLNOTES.getColumnModel().getColumn(7).setMaxWidth(70);
            TBLNOTES.getColumnModel().getColumn(8).setMinWidth(70);
            TBLNOTES.getColumnModel().getColumn(8).setPreferredWidth(70);
            TBLNOTES.getColumnModel().getColumn(8).setMaxWidth(70);
            TBLNOTES.getColumnModel().getColumn(9).setMinWidth(55);
            TBLNOTES.getColumnModel().getColumn(9).setPreferredWidth(55);
            TBLNOTES.getColumnModel().getColumn(9).setMaxWidth(55);
            TBLNOTES.getColumnModel().getColumn(10).setMinWidth(50);
            TBLNOTES.getColumnModel().getColumn(10).setPreferredWidth(50);
            TBLNOTES.getColumnModel().getColumn(10).setMaxWidth(50);
            TBLNOTES.getColumnModel().getColumn(11).setMinWidth(40);
            TBLNOTES.getColumnModel().getColumn(11).setPreferredWidth(40);
            TBLNOTES.getColumnModel().getColumn(11).setMaxWidth(40);
            TBLNOTES.getColumnModel().getColumn(12).setMinWidth(55);
            TBLNOTES.getColumnModel().getColumn(12).setPreferredWidth(55);
            TBLNOTES.getColumnModel().getColumn(12).setMaxWidth(55);
            TBLNOTES.getColumnModel().getColumn(13).setMinWidth(40);
            TBLNOTES.getColumnModel().getColumn(13).setPreferredWidth(40);
            TBLNOTES.getColumnModel().getColumn(13).setMaxWidth(40);
        }

        jTabbedPane4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow));
        jTabbedPane4.setAutoscrolls(true);
        jTabbedPane4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jPanel2.setAutoscrolls(true);

        JCMBSCNOTETYPE.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JCMBSCNOTETYPE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HEPSİ", "Not", "Yap", "Hatırla", "Rutin" }));
        JCMBSCNOTETYPE.setAutoscrolls(true);

        JCMBSCCOMPANY.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JCMBSCCOMPANY.setAutoscrolls(true);

        TFSCSUBJECT.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        TFSCDESCRIPTION.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        JCMBSCISPICTURE.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JCMBSCISPICTURE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hepsi", "Evet", "Hayır" }));

        JCMBSCISWAIT.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JCMBSCISWAIT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hepsi", "Evet", "Hayır" }));

        JCMBSCISDO.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JCMBSCISDO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hepsi", "Evet", "Hayır" }));

        JCMBSCSTATUS.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JCMBSCSTATUS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hepsi", "Aktif", "Pasif" }));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel19.setText("Resim Var mı?");

        TFSCID.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        TFSCID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        TFSCID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFSCIDKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel20.setText("Beklesin mi?");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel21.setText("Bitti mi?");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel22.setText("Durum");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Açıklama");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Konu");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Firma");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("NotTipi");

        jlbl_id.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jlbl_id.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbl_id.setText("ID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jlbl_id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCMBSCISDO, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JCMBSCSTATUS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JCMBSCISWAIT, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JCMBSCISPICTURE, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(TFSCSUBJECT, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TFSCDESCRIPTION)
                    .addComponent(TFSCID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCMBSCNOTETYPE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JCMBSCCOMPANY, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(67, 67, 67))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFSCID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbl_id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCMBSCNOTETYPE, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCMBSCCOMPANY, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFSCSUBJECT, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFSCDESCRIPTION, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(JCMBSCISPICTURE, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCMBSCISWAIT, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCMBSCISDO, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCMBSCSTATUS, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Arama", jPanel2);

        jPanel1.setAutoscrolls(true);

        JDCSCREQUESTDATE2.setDate(new java.util.Date(2524597200000L));
        JDCSCREQUESTDATE2.setDateFormatString("dd.MM.yyyy HH:mm");
        JDCSCREQUESTDATE2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JDCSCREQUESTDATE2.setMaxSelectableDate(new java.util.Date(32503669200000L));
        JDCSCREQUESTDATE2.setMinSelectableDate(new java.util.Date(946677600000L));

        JDCSCREQUESTDATE1.setDate(new java.util.Date(946677600000L));
        JDCSCREQUESTDATE1.setDateFormatString("dd.MM.yyyy HH:mm");
        JDCSCREQUESTDATE1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JDCSCREQUESTDATE1.setMaxSelectableDate(new java.util.Date(32503669200000L));
        JDCSCREQUESTDATE1.setMinSelectableDate(new java.util.Date(946677600000L));

        JDCSCDELIVERTYDATE1.setToolTipText("");
        JDCSCDELIVERTYDATE1.setDate(new java.util.Date(946677600000L));
        JDCSCDELIVERTYDATE1.setDateFormatString("dd.MM.yyyy HH:mm");
        JDCSCDELIVERTYDATE1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JDCSCDELIVERTYDATE1.setMaxSelectableDate(new java.util.Date(32503669200000L));
        JDCSCDELIVERTYDATE1.setMinSelectableDate(new java.util.Date(946677600000L));

        JDCSCPLANDATE1.setDate(new java.util.Date(946677600000L));
        JDCSCPLANDATE1.setDateFormatString("dd.MM.yyyy HH:mm");
        JDCSCPLANDATE1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JDCSCPLANDATE1.setMaxSelectableDate(new java.util.Date(32503669200000L));
        JDCSCPLANDATE1.setMinSelectableDate(new java.util.Date(946677600000L));

        JDCSCDELIVERTYDATE2.setDate(new java.util.Date(2524597200000L));
        JDCSCDELIVERTYDATE2.setDateFormatString("dd.MM.yyyy HH:mm");
        JDCSCDELIVERTYDATE2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JDCSCDELIVERTYDATE2.setMaxSelectableDate(new java.util.Date(32503669200000L));
        JDCSCDELIVERTYDATE2.setMinSelectableDate(new java.util.Date(946677600000L));

        JDCSCCREATEDATE1.setDate(new java.util.Date(946677600000L));
        JDCSCCREATEDATE1.setDateFormatString("dd.MM.yyyy HH:mm");
        JDCSCCREATEDATE1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JDCSCCREATEDATE1.setMaxSelectableDate(new java.util.Date(32503669200000L));
        JDCSCCREATEDATE1.setMinSelectableDate(new java.util.Date(946677600000L));

        JDCSCCREATEDATE2.setDate(new java.util.Date(2524597200000L));
        JDCSCCREATEDATE2.setDateFormatString("dd.MM.yyyy HH:mm");
        JDCSCCREATEDATE2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JDCSCCREATEDATE2.setMaxSelectableDate(new java.util.Date(32503669200000L));
        JDCSCCREATEDATE2.setMinSelectableDate(new java.util.Date(946677600000L));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Oluşturma Tarihi");

        BTNSCCREATEDATE1MIN.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNSCCREATEDATE1MIN.setText("L");
        BTNSCCREATEDATE1MIN.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNSCCREATEDATE1MIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSCCREATEDATE1MINActionPerformed(evt);
            }
        });

        JDCSCPLANDATE2.setDate(new java.util.Date(2524597200000L));
        JDCSCPLANDATE2.setDateFormatString("dd.MM.yyyy HH:mm");
        JDCSCPLANDATE2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JDCSCPLANDATE2.setMaxSelectableDate(new java.util.Date(32503669200000L));
        JDCSCPLANDATE2.setMinSelectableDate(new java.util.Date(946677600000L));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Plan Tarihi");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Talep Tarihi");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Teslim Tarihi");

        BTNSCCREATEDATE1NOW.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNSCCREATEDATE1NOW.setText("T");
        BTNSCCREATEDATE1NOW.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNSCCREATEDATE1NOW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSCCREATEDATE1NOWActionPerformed(evt);
            }
        });

        BTNSCCREATEDATE2NOW.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNSCCREATEDATE2NOW.setText("T");
        BTNSCCREATEDATE2NOW.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNSCCREATEDATE2NOW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSCCREATEDATE2NOWActionPerformed(evt);
            }
        });

        BTNSCCREATEDATE2MAX.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNSCCREATEDATE2MAX.setText("H");
        BTNSCCREATEDATE2MAX.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNSCCREATEDATE2MAX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSCCREATEDATE2MAXActionPerformed(evt);
            }
        });

        BTNSCREQUESTDATE1MIN.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNSCREQUESTDATE1MIN.setText("L");
        BTNSCREQUESTDATE1MIN.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNSCREQUESTDATE1MIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSCREQUESTDATE1MINActionPerformed(evt);
            }
        });

        BTNSCREQUESTDATE1NOW.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNSCREQUESTDATE1NOW.setText("T");
        BTNSCREQUESTDATE1NOW.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNSCREQUESTDATE1NOW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSCREQUESTDATE1NOWActionPerformed(evt);
            }
        });

        BTNSCREQUESTDATE2MAX.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNSCREQUESTDATE2MAX.setText("H");
        BTNSCREQUESTDATE2MAX.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNSCREQUESTDATE2MAX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSCREQUESTDATE2MAXActionPerformed(evt);
            }
        });

        BTNSCREQUESTDATE2NOW.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNSCREQUESTDATE2NOW.setText("T");
        BTNSCREQUESTDATE2NOW.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNSCREQUESTDATE2NOW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSCREQUESTDATE2NOWActionPerformed(evt);
            }
        });

        BTNSCDELIVERTYDATE1MIN.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNSCDELIVERTYDATE1MIN.setText("L");
        BTNSCDELIVERTYDATE1MIN.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNSCDELIVERTYDATE1MIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSCDELIVERTYDATE1MINActionPerformed(evt);
            }
        });

        BTNSCDELIVERTYDATE1NOW.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNSCDELIVERTYDATE1NOW.setText("T");
        BTNSCDELIVERTYDATE1NOW.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNSCDELIVERTYDATE1NOW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSCDELIVERTYDATE1NOWActionPerformed(evt);
            }
        });

        BTNSCDELIVERTYDATE2MAX.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNSCDELIVERTYDATE2MAX.setText("H");
        BTNSCDELIVERTYDATE2MAX.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNSCDELIVERTYDATE2MAX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSCDELIVERTYDATE2MAXActionPerformed(evt);
            }
        });

        BTNSCDELIVERTYDATE2NOW.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNSCDELIVERTYDATE2NOW.setText("T");
        BTNSCDELIVERTYDATE2NOW.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNSCDELIVERTYDATE2NOW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSCDELIVERTYDATE2NOWActionPerformed(evt);
            }
        });

        BTNSCPLANDATE1MIN.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNSCPLANDATE1MIN.setText("L");
        BTNSCPLANDATE1MIN.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNSCPLANDATE1MIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSCPLANDATE1MINActionPerformed(evt);
            }
        });

        BTNSCPLANDATE1NOW.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNSCPLANDATE1NOW.setText("T");
        BTNSCPLANDATE1NOW.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNSCPLANDATE1NOW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSCPLANDATE1NOWActionPerformed(evt);
            }
        });

        BTNSCPLANDATE2MAX.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNSCPLANDATE2MAX.setText("H");
        BTNSCPLANDATE2MAX.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNSCPLANDATE2MAX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSCPLANDATE2MAXActionPerformed(evt);
            }
        });

        BTNSCPLANDATE2NOW.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNSCPLANDATE2NOW.setText("T");
        BTNSCPLANDATE2NOW.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNSCPLANDATE2NOW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSCPLANDATE2NOWActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(31, 31, 31)))
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JDCSCCREATEDATE2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(JDCSCREQUESTDATE1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JDCSCREQUESTDATE2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JDCSCDELIVERTYDATE1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JDCSCDELIVERTYDATE2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JDCSCPLANDATE1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JDCSCPLANDATE2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JDCSCCREATEDATE1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTNSCCREATEDATE1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNSCCREATEDATE1NOW, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTNSCCREATEDATE2MAX, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNSCCREATEDATE2NOW, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTNSCREQUESTDATE1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNSCREQUESTDATE1NOW, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTNSCREQUESTDATE2MAX, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNSCREQUESTDATE2NOW, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTNSCDELIVERTYDATE1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNSCDELIVERTYDATE1NOW, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTNSCDELIVERTYDATE2MAX, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNSCDELIVERTYDATE2NOW, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTNSCPLANDATE1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNSCPLANDATE1NOW, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BTNSCPLANDATE2MAX, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNSCPLANDATE2NOW, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(JDCSCCREATEDATE1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(BTNSCCREATEDATE1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(BTNSCCREATEDATE1NOW, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JDCSCCREATEDATE2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BTNSCCREATEDATE2MAX, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BTNSCCREATEDATE2NOW, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JDCSCREQUESTDATE1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(BTNSCREQUESTDATE1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BTNSCREQUESTDATE1NOW, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JDCSCREQUESTDATE2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BTNSCREQUESTDATE2MAX, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BTNSCREQUESTDATE2NOW, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JDCSCDELIVERTYDATE1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BTNSCDELIVERTYDATE1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BTNSCDELIVERTYDATE1NOW, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JDCSCDELIVERTYDATE2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTNSCDELIVERTYDATE2MAX, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTNSCDELIVERTYDATE2NOW, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JDCSCPLANDATE1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BTNSCPLANDATE1MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BTNSCPLANDATE1NOW, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JDCSCPLANDATE2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BTNSCPLANDATE2MAX, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BTNSCPLANDATE2NOW, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
        );

        jTabbedPane4.addTab("Arama2", jPanel1);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow));
        jTabbedPane1.setAutoscrolls(true);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jPanel4.setAutoscrolls(true);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel7.setText("NotTipi");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setText("Firma");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel17.setText("ID");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel18.setText("Oluşt. Tarihi");

        JCBISPUCTURE.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JCBISPUCTURE.setText("Resim?");

        JCBISDO.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JCBISDO.setText("Bitti?");
        JCBISDO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBISDOActionPerformed(evt);
            }
        });

        JCBISWAIT.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JCBISWAIT.setText("Bekle?");

        TFID.setEditable(false);
        TFID.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        TFID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        JCMBNOTETYPE.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JCMBNOTETYPE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz", "Not", "Yap", "Hatırla", "Rutin" }));

        JCMBCOMPANY.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        JDCCREATEDATE.setDateFormatString("dd.MM.yyyy HH:mm");
        JDCCREATEDATE.setEnabled(false);
        JDCCREATEDATE.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JDCCREATEDATE.setMaxSelectableDate(new java.util.Date(32503669200000L));
        JDCCREATEDATE.setMinSelectableDate(new java.util.Date(946677600000L));

        JCBSTATUS.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JCBSTATUS.setSelected(true);
        JCBSTATUS.setText("Durum");

        BTNDELIVERYDATENOW.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNDELIVERYDATENOW.setText("T");
        BTNDELIVERYDATENOW.setAutoscrolls(true);
        BTNDELIVERYDATENOW.setEnabled(false);
        BTNDELIVERYDATENOW.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNDELIVERYDATENOW.setMaximumSize(new java.awt.Dimension(35, 21));
        BTNDELIVERYDATENOW.setMinimumSize(new java.awt.Dimension(35, 21));
        BTNDELIVERYDATENOW.setPreferredSize(new java.awt.Dimension(35, 21));
        BTNDELIVERYDATENOW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNDELIVERYDATENOWActionPerformed(evt);
            }
        });

        BTNDELIVERYDATEMAX.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNDELIVERYDATEMAX.setText("H");
        BTNDELIVERYDATEMAX.setAutoscrolls(true);
        BTNDELIVERYDATEMAX.setEnabled(false);
        BTNDELIVERYDATEMAX.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNDELIVERYDATEMAX.setMaximumSize(new java.awt.Dimension(21, 35));
        BTNDELIVERYDATEMAX.setMinimumSize(new java.awt.Dimension(21, 35));
        BTNDELIVERYDATEMAX.setPreferredSize(new java.awt.Dimension(21, 35));
        BTNDELIVERYDATEMAX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNDELIVERYDATEMAXActionPerformed(evt);
            }
        });

        JDCDELIVERYDATE.setDate(new java.util.Date(2524597200000L));
        JDCDELIVERYDATE.setDateFormatString("dd.MM.yyyy HH:mm");
        JDCDELIVERYDATE.setEnabled(false);
        JDCDELIVERYDATE.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JDCDELIVERYDATE.setMaxSelectableDate(new java.util.Date(32503669200000L));
        JDCDELIVERYDATE.setMinSelectableDate(new java.util.Date(946677600000L));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setText("Teslim Tarihi");

        BTNREQUESTDATENOW.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNREQUESTDATENOW.setText("T");
        BTNREQUESTDATENOW.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNREQUESTDATENOW.setMaximumSize(new java.awt.Dimension(7, 17));
        BTNREQUESTDATENOW.setMinimumSize(new java.awt.Dimension(7, 17));
        BTNREQUESTDATENOW.setPreferredSize(new java.awt.Dimension(7, 17));
        BTNREQUESTDATENOW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNREQUESTDATENOWActionPerformed(evt);
            }
        });

        BTNREQUESTDATEMAX.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNREQUESTDATEMAX.setText("H");
        BTNREQUESTDATEMAX.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNREQUESTDATEMAX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNREQUESTDATEMAXActionPerformed(evt);
            }
        });

        JDCREQUESTDATE.setDate(new java.util.Date(2524597200000L));
        JDCREQUESTDATE.setDateFormatString("dd.MM.yyyy HH:mm");
        JDCREQUESTDATE.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JDCREQUESTDATE.setMaxSelectableDate(new java.util.Date(32503669200000L));
        JDCREQUESTDATE.setMinSelectableDate(new java.util.Date(946677600000L));
        JDCREQUESTDATE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JDCREQUESTDATEKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("Talep Tarihi");

        BTNPLANDATENOW.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNPLANDATENOW.setText("T");
        BTNPLANDATENOW.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNPLANDATENOW.setPreferredSize(new java.awt.Dimension(7, 17));
        BTNPLANDATENOW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNPLANDATENOWActionPerformed(evt);
            }
        });

        BTNPLANDATEMAX.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNPLANDATEMAX.setText("H");
        BTNPLANDATEMAX.setMargin(new java.awt.Insets(2, 0, 2, 0));
        BTNPLANDATEMAX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNPLANDATEMAXActionPerformed(evt);
            }
        });

        JDCPLANDATE.setDate(new java.util.Date(2524597200000L));
        JDCPLANDATE.setDateFormatString("dd.MM.yyyy HH:mm");
        JDCPLANDATE.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JDCPLANDATE.setMaxSelectableDate(new java.util.Date(32503669200000L));
        JDCPLANDATE.setMinSelectableDate(new java.util.Date(946677600000L));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel8.setText("Plan Tarihi");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFID)
                            .addComponent(JCMBNOTETYPE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JDCCREATEDATE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JCMBCOMPANY, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JDCDELIVERYDATE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNDELIVERYDATEMAX, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNDELIVERYDATENOW, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JDCREQUESTDATE, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNREQUESTDATEMAX, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNREQUESTDATENOW, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCBISPUCTURE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(JCBISWAIT, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(JCBSTATUS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JCBISDO)
                                .addContainerGap())
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(JDCPLANDATE, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTNPLANDATEMAX, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BTNPLANDATENOW, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(TFID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(JCMBNOTETYPE, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(JCMBCOMPANY, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(JDCCREATEDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(BTNDELIVERYDATENOW, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNDELIVERYDATEMAX, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JDCDELIVERYDATE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(JDCREQUESTDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNREQUESTDATENOW, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNREQUESTDATEMAX, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JDCPLANDATE, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BTNPLANDATEMAX, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BTNPLANDATENOW, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCBISPUCTURE)
                    .addComponent(JCBISWAIT)
                    .addComponent(JCBSTATUS)
                    .addComponent(JCBISDO))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Detay", jPanel4);

        jPanel5.setAutoscrolls(true);

        JTADESCRIPTION.setColumns(20);
        JTADESCRIPTION.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        JTADESCRIPTION.setLineWrap(true);
        JTADESCRIPTION.setRows(5);
        JTADESCRIPTION.setToolTipText("");
        JTADESCRIPTION.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        JTADESCRIPTION.setFocusCycleRoot(true);
        JTADESCRIPTION.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTADESCRIPTIONKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(JTADESCRIPTION);

        JTASUBJECT.setColumns(20);
        JTASUBJECT.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        JTASUBJECT.setLineWrap(true);
        JTASUBJECT.setRows(3);
        JTASUBJECT.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        JTASUBJECT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTASUBJECTKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(JTASUBJECT);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setText("Konu");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("Açıklama");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Detay2", jPanel5);

        BTNSEARCH.setText("Ara");
        BTNSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSEARCHActionPerformed(evt);
            }
        });

        BTNSCCLEAR.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNSCCLEAR.setLabel("Temizle");
        BTNSCCLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSCCLEARActionPerformed(evt);
            }
        });

        BTNADD.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNADD.setText("Ekle");
        BTNADD.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BTNADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNADDActionPerformed(evt);
            }
        });

        BTNUPDATE.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNUPDATE.setText("Güncelle");
        BTNUPDATE.setEnabled(false);
        BTNUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNUPDATEActionPerformed(evt);
            }
        });

        BTNDELETE.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNDELETE.setText("Sil");
        BTNDELETE.setEnabled(false);
        BTNDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNDELETEActionPerformed(evt);
            }
        });

        BTNCLEAR.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BTNCLEAR.setText("Temizle");
        BTNCLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNCLEARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(BTNADD, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNUPDATE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNDELETE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNCLEAR))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(BTNSEARCH, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNSCCLEAR))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNSCCLEAR, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNSEARCH, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNADD)
                    .addComponent(BTNUPDATE)
                    .addComponent(BTNDELETE)
                    .addComponent(BTNCLEAR)))
        );

        jTabbedPane3.addTab("Notlar", jPanel7);

        jPanel8.setAutoscrolls(true);

        TBLCUSTOMER.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MüşteriID", "Müşteri"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TBLCUSTOMER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBLCUSTOMERMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TBLCUSTOMER);

        JTFCUSTOMER.setEnabled(false);

        jLabel23.setText("Müşteri ID");

        jLabel24.setText("Müşteri");

        JTFCUSTOMERNAME.setToolTipText("");
        JTFCUSTOMERNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTFCUSTOMERNAMEKeyTyped(evt);
            }
        });

        BTNCUSTOMERADD.setText("Ekle");
        BTNCUSTOMERADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNCUSTOMERADDActionPerformed(evt);
            }
        });

        BTNCUSTOMERUPDATE.setText("Güncelle");
        BTNCUSTOMERUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNCUSTOMERUPDATEActionPerformed(evt);
            }
        });

        BTNCUSTOMERDEL.setText("Sil");
        BTNCUSTOMERDEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNCUSTOMERDELActionPerformed(evt);
            }
        });

        BTNCUSTOMERCLEAR.setText("Temizle");
        BTNCUSTOMERCLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNCUSTOMERCLEARActionPerformed(evt);
            }
        });

        BTNCUSTOMERLIST.setText("Listele");
        BTNCUSTOMERLIST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNCUSTOMERLISTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTNCUSTOMERCLEAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTNCUSTOMERDEL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTNCUSTOMERADD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTFCUSTOMER)
                            .addComponent(JTFCUSTOMERNAME)))
                    .addComponent(BTNCUSTOMERUPDATE, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(BTNCUSTOMERLIST, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JTFCUSTOMER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(JTFCUSTOMERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNCUSTOMERLIST)
                        .addGap(4, 4, 4)
                        .addComponent(BTNCUSTOMERADD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNCUSTOMERUPDATE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNCUSTOMERDEL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNCUSTOMERCLEAR)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(852, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Destek Tabloları", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addComponent(jLabel4)
                    .addContainerGap(1231, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jTabbedPane3)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(75, 75, 75)
                    .addComponent(jLabel4)
                    .addContainerGap(583, Short.MAX_VALUE)))
        );

        jTabbedPane3.getAccessibleContext().setAccessibleName("Notlar");

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BTNADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNADDActionPerformed
        /*DATELER NULSA 2000 DEĞER ATANICAK TARİHLE*/

        if (JCMBNOTETYPE.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Lütfen Not Tipi Seçiniz");
            return;
        }

        if (JCMBCOMPANY.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Lütfen Firma Seçiniz");
            return;
        }

        if (JDCDELIVERYDATE.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Lütfen Teslim Tarihini Tam Giriniz");
            return;
        }

        if (JDCREQUESTDATE.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Lütfen Talep Tarihini Tam Giriniz");
            return;
        }

        if (JDCPLANDATE.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Lütfen Planlama Tarihini Tam Giriniz");
            return;
        }

        if (JTASUBJECT.getText().length() >= 100) {
            JOptionPane.showMessageDialog(null, "Lütfen Konu Alanını 100 karakteri geçmeyiniz");
            return;
        }

        if (!mainclass.isEB(JTADESCRIPTION.getText())) {

            System.out.println("boş");
            JOptionPane.showMessageDialog(null, "Lütfen Açıklama giriniz");
            return;
        }

        if (JTADESCRIPTION.getText().length() >= 5000) {

            JOptionPane.showMessageDialog(null, "Lütfen Açıklama Alanını 5000 karakteri geçmeyiniz");
            return;
        }

        int mesaj = JOptionPane.showConfirmDialog(null, "Ekleme Yapılsın mı?", "Ekleme Penceresi", JOptionPane.YES_NO_OPTION);
        if (mesaj == JOptionPane.YES_OPTION) {
            connection = null;
            pstatement = null;

            try {
                connection = dbhelper.getConnection();
                dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                sorgu = "INSERT INTO TBL_NOTES (NOTETYPE,COMPANYID,SUBJECT,DESCRIPTION,REQUESTDATE,DELIVERYDATE,PLANDATE,ISPICTURE,ISWAIT,ISDO,STATUS,USERID) values (?,?,?,?,?,?,?,?,?,?,?,?)";
                pstatement = connection.prepareStatement(sorgu);
                pstatement.setInt(1, JCMBNOTETYPE.getSelectedIndex());
                pstatement.setInt(2, JCMBCOMPANY.getSelectedIndex());
                pstatement.setString(3, JTASUBJECT.getText());
                pstatement.setString(4, JTADESCRIPTION.getText());
                pstatement.setString(5, dateFormat.format(JDCREQUESTDATE.getDate()));
                pstatement.setString(6, dateFormat.format(JDCDELIVERYDATE.getDate()));
                pstatement.setString(7, dateFormat.format(JDCPLANDATE.getDate()));
                pstatement.setBoolean(8, JCBISPUCTURE.isSelected());
                pstatement.setBoolean(9, JCBISWAIT.isSelected());
                pstatement.setBoolean(10, JCBISDO.isSelected());
                pstatement.setBoolean(11, JCBSTATUS.isSelected());
                pstatement.setInt(12, 1);/*güncellencek*/
                int res = pstatement.executeUpdate();
                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "Ekleme Başarılı");
                    btnclear();
                    notesList();
                } else {
                    JOptionPane.showMessageDialog(null, "Ekleme Başarısız");
                }

            } catch (SQLException e) {
                dbhelper.showErrorMessage(e);
            } catch (ParseException ex) {
                dbhelper.showErrorMessage(ex);
            } catch (NullPointerException ex1) {
                dbhelper.showErrorMessage(ex1);
            } finally {
                try {
                    pstatement.close();
                    pstatement.close();
                } catch (SQLException ex) {
                    dbhelper.showErrorMessage(ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ekleme İptal Edildi");
        }
    }

    public String tarihVer(DateFormat d) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(d);
        /*   return dateFormat;*/
    }//GEN-LAST:event_BTNADDActionPerformed

    public void update() throws SQLException, ParseException {
        if (JCMBNOTETYPE.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Lütfen Not Tipi Seçiniz");
            return;
        }

        if (JCMBCOMPANY.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Lütfen Firma Seçiniz");
            return;
        }

        if (JDCDELIVERYDATE.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Lütfen Teslim Tarihini Tam Giriniz");
            return;
        }

        if (JDCREQUESTDATE.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Lütfen Talep Tarihini Tam Giriniz");
            return;
        }

        if (JDCPLANDATE.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Lütfen Planlama Tarihini Tam Giriniz");
            return;
        }

        if (JTASUBJECT.getText().length() >= 100) {
            JOptionPane.showMessageDialog(null, "Lütfen Konu Alanını 100 karakteri geçmeyiniz");
            return;
        }

        if (!mainclass.isEB(JTADESCRIPTION.getText())) {

            System.out.println("boş");
            JOptionPane.showMessageDialog(null, "Lütfen Açıklama giriniz");
            return;
        }

        if (JTADESCRIPTION.getText().length() >= 5000) {

            JOptionPane.showMessageDialog(null, "Lütfen Açıklama Alanını 5000 karakteri geçmeyiniz");
            return;
        }

        int mesaj = JOptionPane.showConfirmDialog(null, "Güncelleme Yapılsın mı?", "Güncelleme Penceresi", JOptionPane.YES_NO_OPTION);
        if (mesaj == JOptionPane.YES_OPTION) {
            connection = null;
            pstatement = null;
            try {
                connection = dbhelper.getConnection();
                dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

                sorgu = "UPDATE  TBL_NOTES SET NOTETYPE=" + String.valueOf(JCMBNOTETYPE.getSelectedIndex()) + ",COMPANYID=" + String.valueOf(JCMBCOMPANY.getSelectedIndex()) + ",SUBJECT='" + JTASUBJECT.getText() + "', DESCRIPTION='" + JTADESCRIPTION.getText() + "',CREATEDATE='" + dateFormat.format(JDCCREATEDATE.getDate()) + "',REQUESTDATE='" + dateFormat.format(JDCREQUESTDATE.getDate()) + "',DELİVERYDATE='" + dateFormat.format(JDCDELIVERYDATE.getDate()) + "',PLANDATE='" + dateFormat.format(JDCPLANDATE.getDate()) + "',ISPICTURE=" + JCBISPUCTURE.isSelected() + ", ISWAIT =" + JCBISWAIT.isSelected() + ", ISDO =" + JCBISDO.isSelected() + ", STATUS=" + JCBSTATUS.isSelected() + ",USERID=1  WHERE ID=" + selectid;

                pstatement = connection.prepareStatement(sorgu);
                int res = pstatement.executeUpdate();
                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "Güncelleme Başarılı");
                    btnclear();
                    notesList();
                } else {
                    JOptionPane.showMessageDialog(null, "Güncelleme Başarısız");
                }
            } catch (SQLException e) {
                dbhelper.showErrorMessage(e);
            } finally {
                pstatement.close();
                pstatement.close();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Güncelleme İptal Edildi");
        }
    }


    private void BTNUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNUPDATEActionPerformed
        try {
            update();
        } catch (SQLException | ParseException ex) {
            dbhelper.showErrorMessage((ParseException) ex);
            dbhelper.showErrorMessage((SQLException) ex);
        }
    }//GEN-LAST:event_BTNUPDATEActionPerformed

    private void BTNSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSEARCHActionPerformed
        try {
            notesList();
            btnclear();
        } catch (ParseException ex) {
            dbhelper.showErrorMessage(ex);
        }
    }//GEN-LAST:event_BTNSEARCHActionPerformed

    private void TBLNOTESMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBLNOTESMouseClicked
        BTNADD.setEnabled(false);
        BTNUPDATE.setEnabled(true);
        BTNDELETE.setEnabled(true);

        selectid = (Integer) (TBLNOTES.getValueAt(TBLNOTES.getSelectedRow(), 0));
        connection = null;
        pstatement = null;
        mc = new mainclass();
        try {
            connection = dbhelper.getConnection();
            sorgu = "Select *from tbl_notes where id=?";
            pstatement = connection.prepareStatement(sorgu);
            pstatement.setInt(1, selectid);
            resultSet = pstatement.executeQuery();
            while (resultSet.next()) {
                TFID.setText(resultSet.getString("id"));
                JCMBNOTETYPE.setSelectedIndex((resultSet.getInt("notetype")));
                JCMBCOMPANY.setSelectedIndex((resultSet.getInt("companyid")));
                JTASUBJECT.setText(resultSet.getString("subject"));
                JTADESCRIPTION.setText(resultSet.getString("description"));
                date = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(resultSet.getString("createdate"));
                JDCCREATEDATE.setDate((date));
                date = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(resultSet.getString("requestdate"));
                JDCREQUESTDATE.setDate((date));
                date = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(resultSet.getString("deliverydate"));
                JDCDELIVERYDATE.setDate((date));
                date = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(resultSet.getString("plandate"));
                JDCPLANDATE.setDate((date));

                JCBISPUCTURE.setSelected(mc.dogrumu(Byte.valueOf(resultSet.getString("ispicture"))));
                JCBISWAIT.setSelected(mc.dogrumu(Byte.valueOf(resultSet.getString("iswait"))));
                JCBISDO.setSelected(mc.dogrumu(Byte.valueOf(resultSet.getString("isdo"))));
                JCBSTATUS.setSelected(mc.dogrumu(Byte.valueOf(resultSet.getString("status"))));
            }

        } catch (SQLException e) {
            dbhelper.showErrorMessage(e);

        } catch (ParseException ex) {
            Logger.getLogger(frm_notes.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pstatement.close();
                pstatement.close();
            } catch (SQLException ex) {
                dbhelper.showErrorMessage(ex);
            }
        }
    }//GEN-LAST:event_TBLNOTESMouseClicked

    private void BTNSCCLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSCCLEARActionPerformed
        TFSCID.setText("");
        JCMBSCNOTETYPE.setSelectedIndex(0);
        JCMBSCCOMPANY.setSelectedIndex(0);
        TFSCSUBJECT.setText("");
        TFSCDESCRIPTION.setText("");

        try {
            date = new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(mindate);
        } catch (ParseException ex) {
        }
        JDCSCCREATEDATE1.setDate(date);
        JDCSCREQUESTDATE1.setDate(date);
        JDCSCDELIVERTYDATE1.setDate(date);
        JDCSCPLANDATE1.setDate(date);

        try {
            date = new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(maxdate);
        } catch (ParseException ex) {
        }
        JDCSCCREATEDATE2.setDate(date);
        JDCSCREQUESTDATE2.setDate(date);
        JDCSCDELIVERTYDATE2.setDate(date);
        JDCSCPLANDATE2.setDate(date);

        JCMBSCISPICTURE.setSelectedIndex(0);
        JCMBSCISWAIT.setSelectedIndex(0);
        JCMBSCISDO.setSelectedIndex(0);
        JCMBSCSTATUS.setSelectedIndex(0);

        DefaultTableModel tableModel = (DefaultTableModel) TBLNOTES.getModel();
        tableModel.setRowCount(0);

        btnclear();
    }//GEN-LAST:event_BTNSCCLEARActionPerformed

    public void btnclear() {
        BTNADD.setEnabled(true);
        BTNUPDATE.setEnabled(false);
        BTNDELETE.setEnabled(false);

        TFID.setText("");
        JCMBNOTETYPE.setSelectedIndex(0);
        JCMBCOMPANY.setSelectedIndex(0);

        JTASUBJECT.setText("");
        JTADESCRIPTION.setText("");
        JCBISPUCTURE.setSelected(false);
        JCBISWAIT.setSelected(false);
        JCBISDO.setSelected(false);
        JCBSTATUS.setSelected(true);

        JDCCREATEDATE.setDate(null);
        jdbisdoclick();
        try {
            date = new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(maxdate);
        } catch (ParseException ex) {
        }
        JDCDELIVERYDATE.setDate(date);

        JDCREQUESTDATE.setDate(date);
        JDCPLANDATE.setDate(date);
    }

    public void delete() {
        int mesaj = JOptionPane.showConfirmDialog(null, "Seçili Kayıt Silinsin Mi?", "Silme Penceresi", JOptionPane.YES_NO_OPTION);
        if (mesaj == JOptionPane.YES_OPTION) {
            connection = null;
            pstatement = null;
            try {
                connection = dbhelper.getConnection();
                dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                sorgu = "DELETE FROM TBL_NOTES WHERE ID=?";
                pstatement = connection.prepareStatement(sorgu);
                pstatement.setInt(1, selectid);
                int res = pstatement.executeUpdate();
                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "Silme Başarılı");
                    btnclear();
                    notesList();
                } else {
                    JOptionPane.showMessageDialog(null, "Silme Başarısız");
                }
            } catch (SQLException e) {
                dbhelper.showErrorMessage(e);
            } catch (ParseException ex) {
                dbhelper.showErrorMessage(ex);
            } finally {
                try {
                    pstatement.close();
                    pstatement.close();
                } catch (SQLException ex) {
                    dbhelper.showErrorMessage(ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Silme İptal Edildi");
        }
    }

    private void BTNCLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCLEARActionPerformed
        btnclear();
        /**/
 /* JOptionPane.showConfirmDialog(null, "Are you want to continue the process?", "", JOptionPane.YES_NO_CANCEL_OPTION);*/
 /*kontrol*/
 /*  if JOptionPane.YES_OPTION*/
 /*kontrol*/
 /*seçenek biz yazdırdık*/
 /* JFrame frame = new JFrame();
String[] options = new String[2];
options[0] = new String("Agree");
options[1] = new String("Disagree");
JOptionPane.showOptionDialog(frame.getContentPane(),"Message!","Title", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);*/
 /*seçenek biz yazdırdık*/
    }//GEN-LAST:event_BTNCLEARActionPerformed

    private void BTNDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNDELETEActionPerformed
        delete();
    }//GEN-LAST:event_BTNDELETEActionPerformed

    private void BTNCUSTOMERUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCUSTOMERUPDATEActionPerformed
        try {
            customerupdate();

        } catch (ParseException | SQLException ex) {

        }

    }//GEN-LAST:event_BTNCUSTOMERUPDATEActionPerformed

    public void customerupdate() throws SQLException, ParseException {
        if (!mainclass.isEB(JTFCUSTOMERNAME.getText())) {
            JOptionPane.showMessageDialog(null, "Lütfen Müşteri Giriniz! ");
            return;
        }

        int mesaj = JOptionPane.showConfirmDialog(null, "Güncelleme Yapılsın mı?", "Güncelleme Penceresi", JOptionPane.YES_NO_OPTION);
        if (mesaj == JOptionPane.YES_OPTION) {
            connection = null;
            pstatement = null;
            try {
                connection = dbhelper.getConnection();
                dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

                sorgu = "UPDATE  TBL_customers SET CUSTOMERNAME='" + JTFCUSTOMERNAME.getText() + "'  WHERE CUSTOMER=" + tblcustomerid;
                System.out.println(sorgu);
                pstatement = connection.prepareStatement(sorgu);
                int res = pstatement.executeUpdate();
                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "Güncelleme Başarılı");
                    BTNCUSTOMERCLEAR();
                    CUSTOMERLIST();
                    customercmbdoldur();
                    notesList();
                    btnclear();
                } else {
                    JOptionPane.showMessageDialog(null, "Güncelleme Başarısız");
                }
            } catch (SQLException e) {
                dbhelper.showErrorMessage(e);
            } finally {
                pstatement.close();
                pstatement.close();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Güncelleme İptal Edildi");
        }

    }

    private void BTNCUSTOMERDELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCUSTOMERDELActionPerformed
        btncustomerdel();        // TODO add your handling code here:

    }//GEN-LAST:event_BTNCUSTOMERDELActionPerformed

    public void btncustomerdel() {
        int mesaj = JOptionPane.showConfirmDialog(null, "Seçili Firma  Silinsin Mi?", "Silme Penceresi", JOptionPane.YES_NO_OPTION);
        if (mesaj == JOptionPane.YES_OPTION) {
            connection = null;
            pstatement = null;
            try {
                connection = dbhelper.getConnection();
                statement = connection.createStatement();
                sorgu = "SELECT *FROM TBL_NOTES  WHERE companyid=" + tblcustomerid;
                resultSet = statement.executeQuery(sorgu);
                while (resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "Bu Müşteri Kullanılıyor Silinemez");
                    return;
                };
                connection = dbhelper.getConnection();
                sorgu = "DELETE FROM tbl_customers WHERE customer=?";
                pstatement = connection.prepareStatement(sorgu);
                pstatement.setInt(1, tblcustomerid);
                int res = pstatement.executeUpdate();
                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "Silme Başarılı");
                    BTNCUSTOMERCLEAR();
                    CUSTOMERLIST();
                    customercmbdoldur();
                } else {
                    JOptionPane.showMessageDialog(null, "Silme Başarısız");
                }
            } catch (SQLException e) {
                dbhelper.showErrorMessage(e);
            } finally {
                try {
                    pstatement.close();
                    pstatement.close();
                } catch (SQLException ex) {
                    dbhelper.showErrorMessage(ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Silme İptal Edildi");
        }
    }

    private void BTNCUSTOMERLISTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCUSTOMERLISTActionPerformed
        CUSTOMERLIST();
    }//GEN-LAST:event_BTNCUSTOMERLISTActionPerformed

    private void TBLCUSTOMERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBLCUSTOMERMouseClicked
        BTNCUSTOMERADD.setEnabled(false);
        BTNCUSTOMERUPDATE.setEnabled(true);
        BTNCUSTOMERDEL.setEnabled(true);

        tblcustomerid = (Integer) (TBLCUSTOMER.getValueAt(TBLCUSTOMER.getSelectedRow(), 0));
        connection = null;
        pstatement = null;
        mc = new mainclass();
        try {
            connection = dbhelper.getConnection();
            sorgu = "Select *from tbl_customerS where customer=?";
            pstatement = connection.prepareStatement(sorgu);
            pstatement.setInt(1, tblcustomerid);
            resultSet = pstatement.executeQuery();
            while (resultSet.next()) {
                JTFCUSTOMER.setText(resultSet.getString("CUSTOMER"));
                JTFCUSTOMERNAME.setText(resultSet.getString("CUSTOMERNAME"));
            }
        } catch (SQLException e) {
            dbhelper.showErrorMessage(e);

        } finally {
            try {
                pstatement.close();
                pstatement.close();
            } catch (SQLException ex) {
                dbhelper.showErrorMessage(ex);
            }
        }
    }//GEN-LAST:event_TBLCUSTOMERMouseClicked

    private void BTNCUSTOMERADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCUSTOMERADDActionPerformed
        if (!mainclass.isEB(JTFCUSTOMERNAME.getText())) {
            JOptionPane.showMessageDialog(null, "Lütfen Müşteri Giriniz! ");
            return;
        }
        int mesaj = JOptionPane.showConfirmDialog(null, "Ekleme Yapılsın mı?", "Ekleme Penceresi", JOptionPane.YES_NO_OPTION);
        if (mesaj == JOptionPane.YES_OPTION) {
            connection = null;
            pstatement = null;
            try {
                connection = dbhelper.getConnection();
                sorgu = "SELECT max(customer) as customer FROM TBL_CUSTOMERS";
                pstatement = connection.prepareStatement(sorgu);
                resultSet = pstatement.executeQuery();
                int customermax = 0;
                while (resultSet.next()) {
                    customermax = resultSet.getInt("CUSTOMER") + 1;
                    break;
                }
                connection = dbhelper.getConnection();
                dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                sorgu = "INSERT INTO TBL_CUSTOMERS (CUSTOMER,CUSTOMERNAME) values (?,?)";
                pstatement = connection.prepareStatement(sorgu);
                pstatement.setInt(1, customermax);

                pstatement.setString(2, JTFCUSTOMERNAME.getText());

                int res = pstatement.executeUpdate();
                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "Ekleme Başarılı");
                    BTNCUSTOMERCLEAR();
                    CUSTOMERLIST();
                    customercmbdoldur();
                } else {
                    JOptionPane.showMessageDialog(null, "Ekleme Başarısız");
                }

            } catch (SQLException e) {
                dbhelper.showErrorMessage(e);
            } finally {
                try {
                    pstatement.close();
                    pstatement.close();
                } catch (SQLException ex) {
                    dbhelper.showErrorMessage(ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ekleme İptal Edildi");
        }
    }//GEN-LAST:event_BTNCUSTOMERADDActionPerformed

    private void BTNCUSTOMERCLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCUSTOMERCLEARActionPerformed
        BTNCUSTOMERCLEAR();
    }//GEN-LAST:event_BTNCUSTOMERCLEARActionPerformed

    private void JTFCUSTOMERNAMEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTFCUSTOMERNAMEKeyTyped
        /* JTextField JTFCUSTOMERNAME = new JTextField();*/
        JTFCUSTOMERNAME.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (JTFCUSTOMERNAME.getText().length() >= 25) // limit textfield to 25 characters
                {
                    e.consume();
                }
            }
        });        // TODO add your handling code here:
    }//GEN-LAST:event_JTFCUSTOMERNAMEKeyTyped

    private void BTNREQUESTDATEMAXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNREQUESTDATEMAXActionPerformed
        maxdate();
        JDCREQUESTDATE.setDate(date);

    }//GEN-LAST:event_BTNREQUESTDATEMAXActionPerformed

    private void BTNREQUESTDATENOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNREQUESTDATENOWActionPerformed
        date = new Date();
        JDCREQUESTDATE.setDate(date);
    }//GEN-LAST:event_BTNREQUESTDATENOWActionPerformed

    private void BTNDELIVERYDATEMAXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNDELIVERYDATEMAXActionPerformed
        maxdate();
        JDCDELIVERYDATE.setDate(date);
    }//GEN-LAST:event_BTNDELIVERYDATEMAXActionPerformed

    private void BTNDELIVERYDATENOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNDELIVERYDATENOWActionPerformed
        date = new Date();
        JDCDELIVERYDATE.setDate(date);
    }//GEN-LAST:event_BTNDELIVERYDATENOWActionPerformed

    private void BTNPLANDATEMAXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNPLANDATEMAXActionPerformed
        maxdate();
        JDCPLANDATE.setDate(date);
    }//GEN-LAST:event_BTNPLANDATEMAXActionPerformed

    private void BTNPLANDATENOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNPLANDATENOWActionPerformed
        // TODO add your handling code here:
        date = new Date();
        JDCPLANDATE.setDate(date);
    }//GEN-LAST:event_BTNPLANDATENOWActionPerformed

    private void JDCREQUESTDATEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JDCREQUESTDATEKeyTyped
        JDCREQUESTDATE.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                JOptionPane.showMessageDialog(null, "Ekleme İptal Edildi");
                if (JDCREQUESTDATE.getDateFormatString().length() > 16) // limit textfield to 25 characters
                {
                    e.consume();
                }
            }
        });
    }//GEN-LAST:event_JDCREQUESTDATEKeyTyped

    private void JCBISDOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBISDOActionPerformed
        jdbisdoclick();
    }//GEN-LAST:event_JCBISDOActionPerformed

    private void JTASUBJECTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTASUBJECTKeyTyped
        // TODO add your handling code here:
        /* JTextField JTFCUSTOMERNAME = new JTextField();*/
        JTASUBJECT.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (JTASUBJECT.getText().length() >= 100) // limit textfield to 25 characters
                {
                    e.consume();
                }
            }
        });
    }//GEN-LAST:event_JTASUBJECTKeyTyped

    private void JTADESCRIPTIONKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTADESCRIPTIONKeyTyped
        JTADESCRIPTION.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (JTADESCRIPTION.getText().length() >= 5000) // limit textfield to 25 characters
                {
                    e.consume();
                }
            }
        });
    }//GEN-LAST:event_JTADESCRIPTIONKeyTyped

    private void TFSCIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFSCIDKeyTyped

        TFSCID.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (TFSCID.getText().length() >= 8) // limit textfield to 25 characters
                {
                    e.consume();
                }
            }
        });
        char caracter = evt.getKeyChar();//hangi tusa basildigini okuyoruz
        if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {// bu if sart kontrolünde sadece 0 ile 9 arasinda rakamlarin girilebilecegini belirtiyoruz

            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_TFSCIDKeyTyped

    private void BTNSCCREATEDATE1MINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSCCREATEDATE1MINActionPerformed

        mindate();
        JDCSCCREATEDATE1.setDate(date);
    }//GEN-LAST:event_BTNSCCREATEDATE1MINActionPerformed

    private void BTNSCCREATEDATE1NOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSCCREATEDATE1NOWActionPerformed
        _nowdate00();
        JDCSCCREATEDATE1.setDate(date);
    }//GEN-LAST:event_BTNSCCREATEDATE1NOWActionPerformed

    private void BTNSCCREATEDATE2NOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSCCREATEDATE2NOWActionPerformed
        _nowdate23();
        JDCSCCREATEDATE2.setDate(date);
    }//GEN-LAST:event_BTNSCCREATEDATE2NOWActionPerformed

    public void _nowdate00() {
        date = new Date();
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        DateFormat shortdate = new SimpleDateFormat("dd.MM.yyyy");
        try {
            date = format.parse(String.valueOf(shortdate.format(date)) + " 00:00");

        } catch (ParseException ex) {
        }
    }

    public void _nowdate23() {
        date = new Date();
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        DateFormat shortdate = new SimpleDateFormat("dd.MM.yyyy");
        try {
            date = format.parse(String.valueOf(shortdate.format(date)) + " 23:59");

        } catch (ParseException ex) {
        }
    }

    private void BTNSCCREATEDATE2MAXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSCCREATEDATE2MAXActionPerformed
        maxdate();
        JDCSCCREATEDATE2.setDate(date);        // TODO add your handling code here:
    }//GEN-LAST:event_BTNSCCREATEDATE2MAXActionPerformed

    private void BTNSCREQUESTDATE1MINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSCREQUESTDATE1MINActionPerformed
        mindate();
        JDCSCREQUESTDATE1.setDate(date);
    }//GEN-LAST:event_BTNSCREQUESTDATE1MINActionPerformed

    private void BTNSCREQUESTDATE1NOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSCREQUESTDATE1NOWActionPerformed
        _nowdate00();
        JDCSCREQUESTDATE1.setDate(date);
    }//GEN-LAST:event_BTNSCREQUESTDATE1NOWActionPerformed

    private void BTNSCREQUESTDATE2MAXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSCREQUESTDATE2MAXActionPerformed
        maxdate();
        JDCSCREQUESTDATE2.setDate(date);
    }//GEN-LAST:event_BTNSCREQUESTDATE2MAXActionPerformed

    private void BTNSCREQUESTDATE2NOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSCREQUESTDATE2NOWActionPerformed
        _nowdate23();
        JDCSCREQUESTDATE2.setDate(date);
    }//GEN-LAST:event_BTNSCREQUESTDATE2NOWActionPerformed

    private void BTNSCDELIVERTYDATE1MINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSCDELIVERTYDATE1MINActionPerformed
        mindate();
        JDCSCDELIVERTYDATE1.setDate(date);
    }//GEN-LAST:event_BTNSCDELIVERTYDATE1MINActionPerformed

    private void BTNSCDELIVERTYDATE1NOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSCDELIVERTYDATE1NOWActionPerformed
        _nowdate00();
        JDCSCDELIVERTYDATE1.setDate(date);
    }//GEN-LAST:event_BTNSCDELIVERTYDATE1NOWActionPerformed

    private void BTNSCDELIVERTYDATE2MAXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSCDELIVERTYDATE2MAXActionPerformed

        maxdate();
        JDCSCDELIVERTYDATE2.setDate(date);


    }//GEN-LAST:event_BTNSCDELIVERTYDATE2MAXActionPerformed

    private void BTNSCDELIVERTYDATE2NOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSCDELIVERTYDATE2NOWActionPerformed
        _nowdate23();
        JDCSCDELIVERTYDATE2.setDate(date);
    }//GEN-LAST:event_BTNSCDELIVERTYDATE2NOWActionPerformed

    private void BTNSCPLANDATE1MINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSCPLANDATE1MINActionPerformed
        mindate();
        JDCSCPLANDATE1.setDate(date);
    }//GEN-LAST:event_BTNSCPLANDATE1MINActionPerformed

    private void BTNSCPLANDATE1NOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSCPLANDATE1NOWActionPerformed
        _nowdate00();
        JDCSCPLANDATE1.setDate(date);
    }//GEN-LAST:event_BTNSCPLANDATE1NOWActionPerformed

    private void BTNSCPLANDATE2MAXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSCPLANDATE2MAXActionPerformed
        maxdate();
        JDCSCPLANDATE2.setDate(date);

        // TODO add your handling code here:
    }//GEN-LAST:event_BTNSCPLANDATE2MAXActionPerformed

    private void BTNSCPLANDATE2NOWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSCPLANDATE2NOWActionPerformed
        _nowdate23();
        JDCSCPLANDATE2.setDate(date);
    }//GEN-LAST:event_BTNSCPLANDATE2NOWActionPerformed

    public void jdbisdoclick() {

        if (JCBISDO.isSelected()) {
            JDCDELIVERYDATE.setEnabled(true);
            BTNDELIVERYDATEMAX.setEnabled(true);
            BTNDELIVERYDATENOW.setEnabled(true);
        } else {
            try {
                date = new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(mindate);
            } catch (ParseException ex) {
            }

            JDCDELIVERYDATE.setDate(date);
            JDCDELIVERYDATE.setEnabled(false);
            BTNDELIVERYDATEMAX.setEnabled(false);
            BTNDELIVERYDATENOW.setEnabled(false);

        }
    }

    public void mindate() {
        try {
            date = new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(mindate);
        } catch (ParseException ex) {
        }
    }

    public void maxdate() {
        try {
            date = new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(maxdate);
        } catch (ParseException ex) {
        }
    }

    private void BTNCUSTOMERCLEAR() {
        JTFCUSTOMER.setText("");
        JTFCUSTOMERNAME.setText("");
        BTNCUSTOMERADD.setEnabled(true);
        BTNCUSTOMERDEL.setEnabled(false);
        BTNCUSTOMERUPDATE.setEnabled(false);

    }

    private void CUSTOMERLIST() {
        CUSTOMERMODEL = (DefaultTableModel) TBLCUSTOMER.getModel();
        /*tablo temizleme*/
        CUSTOMERMODEL.setRowCount(0);
        /*tablo temizleme*/
        try {
            tbl_customers = new tbl_customers();
            mc = new mainclass();
            /* DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");*/
            customer = tbl_customers.notesList();
            if (customer.stream().count() > 0) {

                for (customers customer_ : customer) {

                    Object[] row = {
                        customer_.getCUSTOMER(),
                        customer_.getCUSTOMERNAME()

                    };
                    CUSTOMERMODEL.addRow(row);
                }
            }

        } catch (SQLException ex) {
            dbhelper.showErrorMessage(ex);
        } catch (ParseException ex) {
        }
    }

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
            java.util.logging.Logger.getLogger(frm_notes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_notes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_notes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_notes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frm_notes().setVisible(true);

                } catch (ParseException ex) {
                    Logger.getLogger(frm_notes.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNADD;
    private javax.swing.JButton BTNCLEAR;
    private javax.swing.JButton BTNCUSTOMERADD;
    private javax.swing.JButton BTNCUSTOMERCLEAR;
    private javax.swing.JButton BTNCUSTOMERDEL;
    private javax.swing.JButton BTNCUSTOMERLIST;
    private javax.swing.JButton BTNCUSTOMERUPDATE;
    private javax.swing.JButton BTNDELETE;
    private javax.swing.JButton BTNDELIVERYDATEMAX;
    private javax.swing.JButton BTNDELIVERYDATENOW;
    private javax.swing.JButton BTNPLANDATEMAX;
    private javax.swing.JButton BTNPLANDATENOW;
    private javax.swing.JButton BTNREQUESTDATEMAX;
    private javax.swing.JButton BTNREQUESTDATENOW;
    private javax.swing.JButton BTNSCCLEAR;
    private javax.swing.JButton BTNSCCREATEDATE1MIN;
    private javax.swing.JButton BTNSCCREATEDATE1NOW;
    private javax.swing.JButton BTNSCCREATEDATE2MAX;
    private javax.swing.JButton BTNSCCREATEDATE2NOW;
    private javax.swing.JButton BTNSCDELIVERTYDATE1MIN;
    private javax.swing.JButton BTNSCDELIVERTYDATE1NOW;
    private javax.swing.JButton BTNSCDELIVERTYDATE2MAX;
    private javax.swing.JButton BTNSCDELIVERTYDATE2NOW;
    private javax.swing.JButton BTNSCPLANDATE1MIN;
    private javax.swing.JButton BTNSCPLANDATE1NOW;
    private javax.swing.JButton BTNSCPLANDATE2MAX;
    private javax.swing.JButton BTNSCPLANDATE2NOW;
    private javax.swing.JButton BTNSCREQUESTDATE1MIN;
    private javax.swing.JButton BTNSCREQUESTDATE1NOW;
    private javax.swing.JButton BTNSCREQUESTDATE2MAX;
    private javax.swing.JButton BTNSCREQUESTDATE2NOW;
    private javax.swing.JButton BTNSEARCH;
    private javax.swing.JButton BTNUPDATE;
    private javax.swing.JCheckBox JCBISDO;
    private javax.swing.JCheckBox JCBISPUCTURE;
    private javax.swing.JCheckBox JCBISWAIT;
    private javax.swing.JCheckBox JCBSTATUS;
    private javax.swing.JComboBox<String> JCMBCOMPANY;
    private javax.swing.JComboBox<String> JCMBNOTETYPE;
    private javax.swing.JComboBox<String> JCMBSCCOMPANY;
    private javax.swing.JComboBox<String> JCMBSCISDO;
    private javax.swing.JComboBox<String> JCMBSCISPICTURE;
    private javax.swing.JComboBox<String> JCMBSCISWAIT;
    private javax.swing.JComboBox<String> JCMBSCNOTETYPE;
    private javax.swing.JComboBox<String> JCMBSCSTATUS;
    private javax.swing.JTextArea JTADESCRIPTION;
    private javax.swing.JTextArea JTASUBJECT;
    private javax.swing.JTextField JTFCUSTOMER;
    private javax.swing.JTextField JTFCUSTOMERNAME;
    private javax.swing.JTable TBLCUSTOMER;
    private javax.swing.JTable TBLNOTES;
    private javax.swing.JTextField TFID;
    private javax.swing.JTextField TFSCDESCRIPTION;
    private javax.swing.JTextField TFSCID;
    private javax.swing.JTextField TFSCSUBJECT;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jlbl_id;
    // End of variables declaration//GEN-END:variables

}
