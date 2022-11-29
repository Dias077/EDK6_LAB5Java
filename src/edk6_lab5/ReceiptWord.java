package edk6_lab5;

import java.awt.Cursor;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hwpf.HWPFDocument;

public class ReceiptWord extends javax.swing.JFrame {

    
    
    private static final long serialVersionUID = 1L;

    class TThread extends Thread {

        public void run() {
            String dir = new File(".").getAbsoluteFile().getParentFile().getAbsolutePath()
                    + System.getProperty("file.separator");

            // Чтение из файла-шаблона в переменную doc
            HWPFDocument doc = null;
            try ( FileInputStream fis = new FileInputStream(dir + "receipt_template.doc")) {
                doc = new HWPFDocument(fis);
                fis.close();
            } catch (Exception ex) {
                System.err.println("Error template!");
            }

            
            // Замена в переменной doc данных
            try {
                doc.getRange().replaceText("$ФИОработника", jTextField_FIO.getText());
                doc.getRange().replaceText("$ВакансияРаботника", jTextField_Vacancy.getText());
                doc.getRange().replaceText("$ЗПРаботника", jTextField_Salary1.getText());
                doc.getRange().replaceText("$УровеньЗанятости", jTextField_Employment.getText());
                doc.getRange().replaceText("$Город", jTextField_Adres.getText());
                doc.getRange().replaceText("$Номер", jTextField_Number.getText());
                doc.getRange().replaceText("$Почта", jTextField_Mail.getText());
                doc.getRange().replaceText("$Гражданство", jTextField_Citizenship.getText());
                doc.getRange().replaceText("$Образование", jTextField_Education.getText());
                doc.getRange().replaceText("$ДатаРождения", jTextField_Data.getText());
                doc.getRange().replaceText("$СемПоложение", jTextField_Status.getText());
                doc.getRange().replaceText("$ГодКонца", jTextField_Year.getText());
                doc.getRange().replaceText("$МестоОбучения", jTextField_Place.getText());
                doc.getRange().replaceText("$Факультет", jTextField_Faculty.getText());
                doc.getRange().replaceText("$Специальность", jTextField_Specialization.getText());
            } catch (Exception ex) {
                System.err.println("Error replaceText!");
            }

            // Сохранение переменной doc в новый файл
            try ( FileOutputStream fos = new FileOutputStream(dir + "receipt.doc")) {
                doc.write(fos);
                fos.close();

                // Открытие файла внешней программой
                if (System.getProperty("os.name").equals("Linux")
                        && System.getProperty("java.vendor").startsWith("Red Hat")) {
                    new ProcessBuilder("xdg-open", dir + "receipt.doc").start();
                } else {
                    Desktop.getDesktop().open(new File(dir + "receipt.doc"));
                }
            } catch (Exception ex) {
                System.err.println("Error getDesktop!");
            }
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }


    public ReceiptWord() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_Save_DOC = new javax.swing.JButton();
        jTextField_Vacancy = new javax.swing.JTextField();
        jTextField_Adres = new javax.swing.JTextField();
        jTextField_FIO = new javax.swing.JTextField();
        jTextField_Number = new javax.swing.JTextField();
        jTextField_Salary1 = new javax.swing.JTextField();
        jTextField_Employment = new javax.swing.JTextField();
        jTextField_Mail = new javax.swing.JTextField();
        jTextField_Citizenship = new javax.swing.JTextField();
        jTextField_Education = new javax.swing.JTextField();
        jTextField_Data = new javax.swing.JTextField();
        jTextField_Status = new javax.swing.JTextField();
        jTextField_Year = new javax.swing.JTextField();
        jTextField_Place = new javax.swing.JTextField();
        jTextField_Faculty = new javax.swing.JTextField();
        jTextField_Specialization = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Квитанция в MS Word");
        setResizable(false);
        getContentPane().setLayout(null);

        jButton_Save_DOC.setText("в DOC");
        jButton_Save_DOC.setToolTipText("");
        jButton_Save_DOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Save_DOCActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Save_DOC);
        jButton_Save_DOC.setBounds(520, 460, 80, 22);

        jTextField_Vacancy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_Vacancy);
        jTextField_Vacancy.setBounds(220, 80, 180, 24);

        jTextField_Adres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_Adres);
        jTextField_Adres.setBounds(250, 160, 140, 30);

        jTextField_FIO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_FIO);
        jTextField_FIO.setBounds(220, 50, 180, 24);

        jTextField_Number.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_Number);
        jTextField_Number.setBounds(40, 170, 110, 20);

        jTextField_Salary1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_Salary1);
        jTextField_Salary1.setBounds(300, 120, 70, 20);

        jTextField_Employment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_Employment);
        jTextField_Employment.setBounds(260, 140, 110, 20);

        jTextField_Mail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_Mail);
        jTextField_Mail.setBounds(490, 170, 110, 20);

        jTextField_Citizenship.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_Citizenship);
        jTextField_Citizenship.setBounds(460, 290, 140, 20);

        jTextField_Education.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_Education);
        jTextField_Education.setBounds(460, 310, 140, 20);

        jTextField_Data.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_Data);
        jTextField_Data.setBounds(460, 340, 140, 20);

        jTextField_Status.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_Status);
        jTextField_Status.setBounds(460, 360, 140, 20);

        jTextField_Year.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField_Year.setToolTipText("");
        getContentPane().add(jTextField_Year);
        jTextField_Year.setBounds(30, 430, 60, 20);
        jTextField_Year.getAccessibleContext().setAccessibleName("");

        jTextField_Place.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_Place);
        jTextField_Place.setBounds(50, 460, 150, 20);

        jTextField_Faculty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_Faculty);
        jTextField_Faculty.setBounds(60, 480, 150, 20);

        jTextField_Specialization.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField_Specialization);
        jTextField_Specialization.setBounds(60, 500, 150, 20);

        jLabel2.setText("FIO");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 50, 60, 20);

        jLabel3.setText("Должность");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 80, 70, 20);

        jLabel4.setText("Уровень занятости");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(150, 140, 110, 16);

        jLabel5.setText("Город (Адрес)");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(280, 190, 77, 16);

        jLabel6.setText("Номер");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 190, 50, 16);

        jLabel7.setText("Почта");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(530, 190, 40, 16);

        jLabel8.setText("Год окончания");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 410, 82, 16);

        jLabel9.setText("ВУЗ");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(210, 460, 21, 16);

        jLabel10.setText("Факультет");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(220, 480, 56, 16);

        jLabel11.setText("Специальность");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(220, 500, 85, 16);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\diamo\\Documents\\NetBeansProjects\\EDK6_LAB5_DOC\\receipt.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 630, 540);

        setSize(new java.awt.Dimension(649, 574));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Save_DOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Save_DOCActionPerformed
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        new TThread().start();
    }//GEN-LAST:event_jButton_Save_DOCActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReceiptWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceiptWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceiptWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceiptWord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceiptWord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Save_DOC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField_Adres;
    private javax.swing.JTextField jTextField_Citizenship;
    private javax.swing.JTextField jTextField_Data;
    private javax.swing.JTextField jTextField_Education;
    private javax.swing.JTextField jTextField_Employment;
    private javax.swing.JTextField jTextField_FIO;
    private javax.swing.JTextField jTextField_Faculty;
    private javax.swing.JTextField jTextField_Mail;
    private javax.swing.JTextField jTextField_Number;
    private javax.swing.JTextField jTextField_Place;
    private javax.swing.JTextField jTextField_Salary1;
    private javax.swing.JTextField jTextField_Specialization;
    private javax.swing.JTextField jTextField_Status;
    private javax.swing.JTextField jTextField_Vacancy;
    private javax.swing.JTextField jTextField_Year;
    // End of variables declaration//GEN-END:variables
}
