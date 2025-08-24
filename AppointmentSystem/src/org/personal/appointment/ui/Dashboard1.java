package org.personal.appointment.ui;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.personal.appointment.dao.ClientsDao;
import org.personal.appointment.model.Clients;
import org.personal.appointment.dao.impl.ClientsDaoImpl;


import java.util.List;

public class Dashboard1 extends javax.swing.JFrame {

     private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Dashboard1.class.getName());
    
    private  ClientsDao clientsDao;

    private final String[] columns = new String[]{"id", "name", "age", "doctor", "date"};

    private final DefaultTableModel model = new DefaultTableModel();

    public Dashboard1(ClientsDao clientsDao) {
        
        this.clientsDao = clientsDao;
        initComponents();
        setUpTableModel();
        setUpPaddingInTextField();
        findAll();
    }
    
    public Dashboard1(){
        this.clientsDao = new ClientsDaoImpl() {};
 
        initComponents();
        setUpTableModel();
        setUpPaddingInTextField();
        findAll();
    }
    
    
    



    private void save() throws NumberFormatException, HeadlessException {
        try {
            Clients client = getValueFromTextField();
            int rowCount = clientsDao.save(client);
            if (rowCount >= 1) {
                showMessageDialog("APpointment sucessfully saved");
                resetForm();
                findAll();
            } else {
                showMessageDialog("Something went wrong");
            }
        } catch (SQLException | ClassNotFoundException | NumberFormatException ex) {
            showMessageDialog(ex.getMessage());
        }
    }

    private void update() throws NumberFormatException {
        try {
            int selectedRow = booksTable.getSelectedRow();
            int id = (int) booksTable.getValueAt(selectedRow, 0);
            Clients client = clientsDao.findOne(id);
            if (editOrUpdateButton.getText().equals("Edit")) {
                editOrUpdateButton.setText("Update");
                bookNameTextField.setText(client.getName());
                authorTextField.setText(String.valueOf(client.getAge()));
                publishedByTextField.setText(client.getDoctor());
                priceTextField.setText(String.valueOf(client.getDate()));
            } else if (editOrUpdateButton.getText().equals("Update")) {
                client.setName(bookNameTextField.getText());
                client.setAge(Integer.parseInt(authorTextField.getText()));
                client.setDoctor(publishedByTextField.getText());
                client.setDate(priceTextField.getText());
                int rowCount = clientsDao.update(client, id);

                if (rowCount >= 1) {
                    showMessageDialog("Appointment sucessfully updated");
                    resetForm();
                    findAll();
                    editOrUpdateButton.setText("Edit");
                } else {
                    showMessageDialog("Something went wrong");
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            showMessageDialog(ex.getMessage());
        }
    }

    private void remove() {
        int selectedRow = booksTable.getSelectedRow();
        int id = (int) booksTable.getValueAt(selectedRow, 0);
        try {
            Clients client = clientsDao.findOne(id);
            if (client != null) {
                int rowCount = clientsDao.remove(id);
                if (rowCount >= 1) {
                    showMessageDialog("Appointment sucessfully deleted");
                    findAll();
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            showMessageDialog(ex.getMessage());
        }
    }

    private void findAll() {
        model.setRowCount(0);
        try {
            List<Clients> books = clientsDao.findAll();
            for (Clients book : books) {
                Object[] row = {book.getId(), book.getName(), 
                    book.getAge(), book.getDoctor(), book.getDate()};
                model.addRow(row);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            showMessageDialog(ex.getMessage());
        }
    }

    private void search() {
        String query = searchTextField.getText();
        if (query.length() == 0) {
            findAll();
        } else {
            model.setRowCount(0);
            try {
                List<Clients> clients = clientsDao.search(searchTextField.getText());
                for (Clients book : clients) {
                    Object[] row = {book.getId(), book.getName(), book.getAge(), book.getDoctor(), book.getDate()};
                    model.addRow(row);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                showMessageDialog(ex.getMessage());
            }
        }
    }

    private void setUpTableModel() {
        booksTable.setModel(model);
        model.setColumnIdentifiers(columns);
    }

    private void setUpPaddingInTextField() {
        setUpBorderFactory(bookNameTextField);
        setUpBorderFactory(authorTextField);
        setUpBorderFactory(publishedByTextField);
        setUpBorderFactory(priceTextField);
        setUpBorderFactory(searchTextField);
    }

    private void setUpBorderFactory(JTextField textField) {
        textField.setBorder(BorderFactory.createCompoundBorder(
                textField.getBorder(),
                BorderFactory.createEmptyBorder(5, 10, 5, 5)));
    }

    private void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private Clients getValueFromTextField() throws NumberFormatException {
        String booksName = bookNameTextField.getText();
        String author = authorTextField.getText();
        String publication = publishedByTextField.getText();
        String price = priceTextField.getText();
        Clients client = new Clients(booksName, Integer.parseInt(author), publication, price);
        return client;
    }

    private void resetForm() {
        bookNameTextField.setText("");
        authorTextField.setText("");
        publishedByTextField.setText("");
        priceTextField.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userInputPanel = new javax.swing.JPanel();
        bookNameTextField = new javax.swing.JTextField();
        bookNameLabel = new javax.swing.JLabel();
        authorLabel = new javax.swing.JLabel();
        publishedByLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        authorTextField = new javax.swing.JTextField();
        publishedByTextField = new javax.swing.JTextField();
        priceTextField = new javax.swing.JTextField();
        buttonPanel = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editOrUpdateButton = new javax.swing.JButton();
        systemPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        booksTableScrollPane = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        searchPanel = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        searchLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(360, 360));

        userInputPanel.setBackground(new java.awt.Color(186, 235, 232));

        bookNameTextField.setBackground(new java.awt.Color(234, 255, 255));
        bookNameTextField.setForeground(new java.awt.Color(20, 20, 20));

        bookNameLabel.setForeground(new java.awt.Color(40, 40, 40));
        bookNameLabel.setText("Patient:");

        authorLabel.setForeground(new java.awt.Color(40, 40, 40));
        authorLabel.setText("Age");

        publishedByLabel.setForeground(new java.awt.Color(40, 40, 40));
        publishedByLabel.setText("Doctor");

        priceLabel.setForeground(new java.awt.Color(40, 40, 40));
        priceLabel.setText("Date");

        authorTextField.setBackground(new java.awt.Color(234, 255, 255));
        authorTextField.setForeground(new java.awt.Color(20, 20, 20));
        authorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorTextFieldActionPerformed(evt);
            }
        });

        publishedByTextField.setBackground(new java.awt.Color(234, 255, 255));
        publishedByTextField.setForeground(new java.awt.Color(20, 20, 20));
        publishedByTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publishedByTextFieldActionPerformed(evt);
            }
        });

        priceTextField.setBackground(new java.awt.Color(234, 255, 255));
        priceTextField.setForeground(new java.awt.Color(20, 20, 20));

        buttonPanel.setBackground(new java.awt.Color(186, 235, 232));

        saveButton.setBackground(new java.awt.Color(220, 252, 241));
        saveButton.setForeground(new java.awt.Color(10, 10, 10));
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(220, 252, 241));
        deleteButton.setForeground(new java.awt.Color(10, 10, 10));
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        editOrUpdateButton.setBackground(new java.awt.Color(220, 252, 241));
        editOrUpdateButton.setForeground(new java.awt.Color(10, 10, 10));
        editOrUpdateButton.setText("Edit");
        editOrUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editOrUpdateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(689, 689, 689)
                .addComponent(saveButton)
                .addGap(18, 18, 18)
                .addComponent(deleteButton)
                .addGap(18, 18, 18)
                .addComponent(editOrUpdateButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(deleteButton)
                    .addComponent(editOrUpdateButton)))
        );

        systemPanel.setBackground(new java.awt.Color(220, 235, 240));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 20, 20));
        jLabel1.setText("Narja Appointment System");

        javax.swing.GroupLayout systemPanelLayout = new javax.swing.GroupLayout(systemPanel);
        systemPanel.setLayout(systemPanelLayout);
        systemPanelLayout.setHorizontalGroup(
            systemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(systemPanelLayout.createSequentialGroup()
                .addGap(535, 535, 535)
                .addComponent(jLabel1)
                .addContainerGap(767, Short.MAX_VALUE))
        );
        systemPanelLayout.setVerticalGroup(
            systemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, systemPanelLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout userInputPanelLayout = new javax.swing.GroupLayout(userInputPanel);
        userInputPanel.setLayout(userInputPanelLayout);
        userInputPanelLayout.setHorizontalGroup(
            userInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInputPanelLayout.createSequentialGroup()
                .addGroup(userInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userInputPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(userInputPanelLayout.createSequentialGroup()
                        .addGroup(userInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(userInputPanelLayout.createSequentialGroup()
                                .addGap(266, 266, 266)
                                .addComponent(bookNameLabel)
                                .addGap(28, 28, 28)
                                .addComponent(bookNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(authorLabel)
                                .addGap(18, 18, 18)
                                .addComponent(authorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(publishedByLabel)
                                .addGap(27, 27, 27)
                                .addComponent(publishedByTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(priceLabel)
                                .addGap(18, 18, 18)
                                .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(systemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        userInputPanelLayout.setVerticalGroup(
            userInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userInputPanelLayout.createSequentialGroup()
                .addComponent(systemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(userInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookNameLabel)
                    .addComponent(bookNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(authorLabel)
                    .addComponent(authorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(publishedByLabel)
                    .addComponent(publishedByTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceLabel)
                    .addComponent(priceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        getContentPane().add(userInputPanel, java.awt.BorderLayout.PAGE_START);

        booksTable.setBackground(new java.awt.Color(250, 250, 250));
        booksTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        booksTable.setForeground(new java.awt.Color(10, 10, 10));
        booksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Patient", "Age", "Doctor", "Date", "Checked"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        booksTableScrollPane.setViewportView(booksTable);

        searchPanel.setBackground(new java.awt.Color(220, 220, 230));

        searchTextField.setBackground(new java.awt.Color(234, 255, 255));

        searchLabel.setForeground(new java.awt.Color(20, 20, 20));
        searchLabel.setText("Search :");

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(searchLabel)
                .addGap(40, 40, 40)
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 1144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchLabel))
                .addContainerGap())
        );

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(booksTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(174, Short.MAX_VALUE))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(booksTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(192, Short.MAX_VALUE))
        );

        getContentPane().add(tablePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void authorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_authorTextFieldActionPerformed

    private void publishedByTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishedByTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_publishedByTextFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        save();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
         remove();        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void editOrUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editOrUpdateButtonActionPerformed
        // TODO add your handling code here:
         update();
    }//GEN-LAST:event_editOrUpdateButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorLabel;
    private javax.swing.JTextField authorTextField;
    private javax.swing.JLabel bookNameLabel;
    private javax.swing.JTextField bookNameTextField;
    private javax.swing.JTable booksTable;
    private javax.swing.JScrollPane booksTableScrollPane;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editOrUpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceTextField;
    private javax.swing.JLabel publishedByLabel;
    private javax.swing.JTextField publishedByTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JPanel systemPanel;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JPanel userInputPanel;
    // End of variables declaration//GEN-END:variables
}
