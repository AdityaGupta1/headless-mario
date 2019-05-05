package nintaco.gui.historyeditor;

import java.awt.*;
import static nintaco.util.GuiUtil.*;
import static nintaco.util.StringUtil.*;

public class HistoryBookmarkEditor extends javax.swing.JDialog {

  private final int maxFrameValue;
  
  private boolean ok;
  private String bookmarkName;
  private int bookmarkFrame;  
  
  public HistoryBookmarkEditor(final Window parent, 
      final HistoryTableModel historyTableModel) {
    super(parent);
    setModal(true);
    maxFrameValue = historyTableModel.getRowCount() - 1;
    initComponents();
    initTextFields();
    scaleFonts(this);
    pack();
    setLocationRelativeTo(parent);
  }
  
  private void initTextFields() {
    addLoseFocusListener(this, nameTextField);
    addLoseFocusListener(this, frameTextField);
    addTextFieldEditListener(nameTextField, this::textFieldsEdited);
    addTextFieldEditListener(frameTextField, this::textFieldsEdited);
  }
  
  public void setHistoryBookmark(final HistoryBookmark bookmark) {
    setHistoryBookmark(bookmark.getName(), bookmark.getFrame());
  }
  
  public void setHistoryBookmark(final String name, final int frame) {
    nameTextField.setText(name);
    frameTextField.setText(Integer.toString(frame));
    textFieldsEdited();
  }
  
  public void setMode(final boolean editing) {
    setTitle(editing ? "Edit Bookmark" : "Add Bookmark");
  }
  
  private void closeDialog() {
    dispose();
  }

  public boolean isOk() {
    return ok;
  }
  
  public HistoryBookmark getBookmark() {
    return new HistoryBookmark(bookmarkName, bookmarkFrame);
  }
  
  private boolean textFieldsEdited() {
    bookmarkName = nameTextField.getText().trim();
    bookmarkFrame = parseInt(frameTextField.getText(), false, maxFrameValue);
    final boolean enabled = !bookmarkName.isEmpty() && bookmarkFrame >= 0;
    okButton.setEnabled(enabled);
    return enabled;
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    nameLabel = new javax.swing.JLabel();
    nameTextField = new javax.swing.JTextField();
    frameLabel = new javax.swing.JLabel();
    frameTextField = new javax.swing.JTextField();
    cancelButton = new javax.swing.JButton();
    okButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setPreferredSize(null);

    nameLabel.setText("Name:");
    nameLabel.setMaximumSize(null);
    nameLabel.setMinimumSize(null);
    nameLabel.setPreferredSize(null);

    nameTextField.setColumns(32);
    nameTextField.setMaximumSize(null);
    nameTextField.setMinimumSize(null);
    nameTextField.setPreferredSize(null);

    frameLabel.setText("Frame:");
    frameLabel.setMaximumSize(null);
    frameLabel.setMinimumSize(null);
    frameLabel.setPreferredSize(null);

    frameTextField.setColumns(8);
    frameTextField.setMaximumSize(null);
    frameTextField.setMinimumSize(null);
    frameTextField.setPreferredSize(null);

    cancelButton.setMnemonic('C');
    cancelButton.setText("Cancel");
    cancelButton.setMaximumSize(null);
    cancelButton.setMinimumSize(null);
    cancelButton.setPreferredSize(null);
    cancelButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cancelButtonActionPerformed(evt);
      }
    });

    okButton.setMnemonic('O');
    okButton.setText("OK");
    okButton.setMaximumSize(null);
    okButton.setMinimumSize(null);
    okButton.setPreferredSize(null);
    okButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        okButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(15, 15, 15)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addComponent(frameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(frameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(15, 15, 15))
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(15, 15, 15)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(frameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(frameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(15, 15, 15))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
    ok = textFieldsEdited();
    closeDialog();
  }//GEN-LAST:event_okButtonActionPerformed

  private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    closeDialog();
  }//GEN-LAST:event_cancelButtonActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton cancelButton;
  private javax.swing.JLabel frameLabel;
  private javax.swing.JTextField frameTextField;
  private javax.swing.JLabel nameLabel;
  private javax.swing.JTextField nameTextField;
  private javax.swing.JButton okButton;
  // End of variables declaration//GEN-END:variables
}
