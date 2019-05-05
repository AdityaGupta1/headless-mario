package nintaco.gui;

import java.awt.*;
import javax.swing.*;
import static nintaco.gui.FourButtonDialog.IconType.*;
import static nintaco.util.GuiUtil.*;

public class FourButtonDialog extends javax.swing.JDialog {

  public static enum IconType {
    QUESTION, INFORMATION, ERROR, WARNING,
  }  
  
  private int selection;
  
  public FourButtonDialog(final Window parent, final String message, 
      final String title) {
    this(parent, message, title, QUESTION);
  }
  
  public FourButtonDialog(final Window parent, final String message, 
      final String title, final IconType iconType) {
    super(parent);
    setModal(true);    
    initComponents();
    getRootPane().setDefaultButton(button0);    
    setMessage(message, title, iconType);    
    scaleFonts(this);
  }
  
  public void setButtonText(final int index, final String name, 
      final int mnemonic) {
    JButton button = null;
    switch(index) {
      case 0:
        button = button0;
        break;
      case 1:
        button = button1;
        break;
      case 2:
        button = button2;
        break;
      case 3:
        button = button3;
        break;
    }
    if (button != null) {
      button.setText(name);
      button.setMnemonic(mnemonic);
    }
  }
  
  @Override
  public void setVisible(final boolean visible) {
    if (visible) {
      pack();
      setLocationRelativeTo(getParent());
    }
    super.setVisible(visible);
  }
  
  public final void setMessage(final String message, final String title) {
    setMessage(message, title, QUESTION);
  }
  
  public final void setMessage(String message, final String title, 
      final IconType iconType) {
    if (!message.toLowerCase().trim().startsWith("<html>")) {
      message = "<html>" + message + "</html>";
    }
    setTitle(title);
    messageLabel.setText(message);
    if (iconType == null) {
      messageLabel.setIcon(null);
    } else {
      final String iconName;
      switch(iconType) {
        case ERROR:
          iconName = "OptionPane.errorIcon";
          break;
        case WARNING:
          iconName = "OptionPane.warningIcon";
          break;      
        case INFORMATION:
          iconName = "OptionPane.informationIcon";
          break;
        default:
          iconName = "OptionPane.questionIcon";
          break;        
      }
      messageLabel.setIcon(UIManager.getIcon(iconName));
    }
  }  
  
  public int getSelection() {
    return selection;
  }
  
  private void closeDialog() {
    dispose();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    messageLabel = new javax.swing.JLabel();
    button1 = new javax.swing.JButton();
    button0 = new javax.swing.JButton();
    button2 = new javax.swing.JButton();
    button3 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    setPreferredSize(null);
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent evt) {
        formWindowClosing(evt);
      }
    });

    messageLabel.setText(" ");
    messageLabel.setIconTextGap(16);

    button1.setMnemonic('1');
    button1.setText("Button 1");
    button1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button1ActionPerformed(evt);
      }
    });

    button0.setMnemonic('0');
    button0.setText("Button 0");
    button0.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button0ActionPerformed(evt);
      }
    });

    button2.setMnemonic('2');
    button2.setText("Button 2");
    button2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button2ActionPerformed(evt);
      }
    });

    button3.setMnemonic('3');
    button3.setText("Button 3");
    button3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button3ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(15, 15, 15)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(button0)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(button1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(button2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(button3)))
        .addGap(15, 15, 15))
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {button0, button1, button2, button3});

    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(15, 15, 15)
        .addComponent(messageLabel)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(button1)
          .addComponent(button0)
          .addComponent(button2)
          .addComponent(button3))
        .addContainerGap(15, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void button0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button0ActionPerformed
    selection = 0;
    closeDialog();
  }//GEN-LAST:event_button0ActionPerformed

  private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
    selection = 1;
    closeDialog();
  }//GEN-LAST:event_button1ActionPerformed

  private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    selection = -1;
    closeDialog();
  }//GEN-LAST:event_formWindowClosing

  private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
    selection = 2;
    closeDialog();
  }//GEN-LAST:event_button2ActionPerformed

  private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
    selection = 3;
    closeDialog();
  }//GEN-LAST:event_button3ActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton button0;
  private javax.swing.JButton button1;
  private javax.swing.JButton button2;
  private javax.swing.JButton button3;
  private javax.swing.JLabel messageLabel;
  // End of variables declaration//GEN-END:variables
}
