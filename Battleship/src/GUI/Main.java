/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Backend.Player;
import Backend.Randomizer;
import Backend.Ship;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author jward
 */
public class Main extends javax.swing.JFrame {
    Player human;
    Player computer;
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
                
        // Set grids and button to not allow for moves
        shipTable.setEnabled(false);
        guessTable.setEnabled(false);
        computerMoveButton.setEnabled(false);
        
        // Create new players
        human = new Player();
        computer = new Player();

        // refresh GUI
        refreshGrid(guessTable, computer.getGrid().getGridStatus());        
        refreshGrid(shipTable, human.getGrid().getGridShips());
    }

 
    /**
     * This method will randomly choose ship locations for the Player who is
     * passed in.
     * 
     * @param current The player who needs random ship locations chosen
     */
    public void randomShipLocations(Player current)
    {
        int numShipsAdded = 0;
        /*
        while(numShipsAdded < Player.SHIP_LENGTHS.length)
        {
            int row = Randomizer.nextInt(10);
            int col = Randomizer.nextInt(10);
            int dir = Randomizer.nextInt(2);
            boolean shipAdded = current.addShip(row, col, dir);
            if(shipAdded)
            {
                numShipsAdded++;
            }
        }              
        */
        current.initializeShipsRandomly();
        refreshGrid(guessTable, computer.getGrid().getGridStatus());        
        refreshGrid(shipTable, human.getGrid().getGridShips());
    }

    /**
     * This method will show a dialog box to allow the user to 
     * chose a direction for their ship.
     * 
     * @return An integer for direction (0: horz and 1: vert)
     */
    private int getDirection()
    {
        Object options[] = {"Horizontal","Vertical"};
        int choice = getIntOptionPane("Select a direction",
                "Direction Choice", options);
        return choice;
    }

    
    // Method for bringing up a diolog box for getting input
    private int getIntOptionPane(String question, String title, Object[] options)
    {
        //Custom button text
        int n = JOptionPane.showOptionDialog(this, question, title,
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);
        return n;
    }
    
    // Method for bringing up a diolog box for getting input
    private String getStringOptionPane(String question, String title, Object[] options)
    {
        //Custom button text
        String s = (String)JOptionPane.showInputDialog(this, question,title,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]);
        return s;
    }
    
    // Method to redraw the grids which hold the Battleship board
    private void refreshGrid(JTable table, String[][] gridData)
    {
        // Get Roster Header
        String[] gridHeader = {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
        };

        // Create JTable with all our data
        table.setModel(new InfoTableModel(gridHeader, gridData));

        //userGrid.getColumnModel().getColumn(0).setMinWidth(100);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        yourShipsLabel = new javax.swing.JLabel();
        shipPane = new javax.swing.JScrollPane();
        shipTable = new javax.swing.JTable();
        yourGuessesLabel = new javax.swing.JLabel();
        guessPane = new javax.swing.JScrollPane();
        guessTable = new javax.swing.JTable();
        infoPanel = new javax.swing.JPanel();
        newGameLabel = new javax.swing.JLabel();
        newGameComboBox = new javax.swing.JComboBox<>();
        directionsLabel = new javax.swing.JLabel();
        directionsScrollPane = new javax.swing.JScrollPane();
        directionsTextArea = new javax.swing.JTextArea();
        computerMoveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        yourShipsLabel.setText("Your Ships");

        shipTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        shipTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                shipTableMouseClicked(evt);
            }
        });
        shipPane.setViewportView(shipTable);

        yourGuessesLabel.setText("Your Guesses");

        guessTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        guessTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guessTableMouseClicked(evt);
            }
        });
        guessPane.setViewportView(guessTable);

        newGameLabel.setText("New Game");

        newGameComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ship Selection...", "User Selected Ships", "Random Ship Selection" }));
        newGameComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameComboBoxActionPerformed(evt);
            }
        });

        directionsLabel.setText("Information:");

        directionsTextArea.setColumns(20);
        directionsTextArea.setLineWrap(true);
        directionsTextArea.setRows(5);
        directionsTextArea.setText("Select a new game choice from combo box above.");
        directionsTextArea.setAutoscrolls(false);
        directionsScrollPane.setViewportView(directionsTextArea);

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(directionsLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(directionsScrollPane))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newGameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newGameLabel)))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newGameLabel)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(directionsLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newGameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(directionsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        computerMoveButton.setText("Computer Move");
        computerMoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computerMoveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(shipPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(guessPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(computerMoveButton)
                .addGap(98, 284, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(yourShipsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(yourGuessesLabel)
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yourShipsLabel)
                            .addComponent(yourGuessesLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(shipPane, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(guessPane, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(computerMoveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newGameComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameComboBoxActionPerformed
        int choice = newGameComboBox.getSelectedIndex();
        if(choice == 1 || choice == 2)
        {
            human = new Player();
            computer = new Player();

            refreshGrid(guessTable, computer.getGrid().getGridStatus());        
            refreshGrid(shipTable, human.getGrid().getGridShips());

            if(choice == 1)
            {
                directionsTextArea.setText("Click in your grid above to place your ship.\n"
                        + "You are setting a ship of length " + human.getShipLength());
                shipTable.setEnabled(true);
            }
            if(choice == 2)
            {
                randomShipLocations(human);
                randomShipLocations(computer);
                
                computer.setOpponentGrid(human.getGrid());
                human.setOpponentGrid(computer.getGrid());
                
                shipTable.setEnabled(false);
                directionsTextArea.setText("Done adding ships.\n"
                    + "Click on the user guess grid to start playing!");
                guessTable.setEnabled(true);                

            }
        }

    }//GEN-LAST:event_newGameComboBoxActionPerformed

    private void shipTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_shipTableMouseClicked
        int col = shipTable.getSelectedColumn() - 1;
        int row = shipTable.getSelectedRow();
        int dir = getDirection();
        
        boolean shipAdded = human.chooseShipLocation(human.myShips[human.getNumShipsAdded()], row, col, dir);
        if(shipAdded)
        {
            if(human.getNumShipsAdded() == 5)
            {
                computer.setOpponentGrid(human.getGrid());
                randomShipLocations(computer);
                human.setOpponentGrid(computer.getGrid());
                shipTable.setEnabled(false);
                directionsTextArea.setText("Done adding ships.\n"
                    + "Click on the user guess grid to start playing!");
                guessTable.setEnabled(true);                
            }
            else
            {
                directionsTextArea.setText("Click in your grid above to place your ship.\n"
                    + "You are setting a ship of length " + human.getShipLength());
            }
        }
        else
        {
            directionsTextArea.setText("Ship could not be added there.\n"
                    + "Click in your grid above to place your ship.\n"
                + "You are setting a ship of length " + human.getShipLength());
        }
        
        refreshGrid(shipTable, human.getGrid().getGridShips());
    }//GEN-LAST:event_shipTableMouseClicked

    private void guessTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guessTableMouseClicked
        int col = guessTable.getSelectedColumn() - 1;
        int row = guessTable.getSelectedRow();
        
        if(row > 9 || row < 0 || col > 9 || col < 0)
        {
            return;
        }
        
        if(human.makeGuess(row, col, computer))
        {
            directionsTextArea.setText("Your guesses: " + (char)(row+65) + "" + 
                    (col + 1) + ": Hit!");  
        }
        else
        {
            directionsTextArea.setText("Your guesses: " + (char)(row+65) + "" + 
                    (col + 1) + ": Miss");              
        }
        
        if(human.opponentHitsRemaining() == 0)
        {
            directionsTextArea.setText("Game over.\n"
                    + "You Win!");
            computerMoveButton.setEnabled(false);
            guessTable.setEnabled(false);            
        }
        else
        {
            guessTable.setEnabled(false);
            computerMoveButton.setEnabled(true);
        }
        
        refreshGrid(guessTable, computer.getGrid().getGridStatus());        
    }//GEN-LAST:event_guessTableMouseClicked

    private void computerMoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computerMoveButtonActionPerformed
        int row = Randomizer.nextInt(10);
        int col = Randomizer.nextInt(10);
        while(computer.alreadyGuessed(row, col))
        {
            row = Randomizer.nextInt(10);
            col = Randomizer.nextInt(10);
        }
        if(computer.makeGuess(row, col, human))
        {
            directionsTextArea.setText("Computer guesses: " + (char)(row+65) + "" + 
                    (col + 1) + ": Hit!");  
        }
        else
        {
            directionsTextArea.setText("Computer guesses: " + (char)(row+65) + "" + 
                    (col + 1) + ": Miss");  
        }
        
        if(computer.opponentHitsRemaining() == 0)
        {
            directionsTextArea.setText("Game over.\n"
                    + "Computer Wins:-(");
            computerMoveButton.setEnabled(false);
            guessTable.setEnabled(false);            
            refreshGrid(guessTable, computer.getGrid().getGridShips());        
        }
        else
        {
            computerMoveButton.setEnabled(false);
            guessTable.setEnabled(true);
        }
        
        refreshGrid(shipTable, human.getGrid().getGridShips());
    }//GEN-LAST:event_computerMoveButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton computerMoveButton;
    private javax.swing.JLabel directionsLabel;
    private javax.swing.JScrollPane directionsScrollPane;
    private javax.swing.JTextArea directionsTextArea;
    private javax.swing.JScrollPane guessPane;
    private javax.swing.JTable guessTable;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JComboBox<String> newGameComboBox;
    private javax.swing.JLabel newGameLabel;
    private javax.swing.JScrollPane shipPane;
    private javax.swing.JTable shipTable;
    private javax.swing.JLabel yourGuessesLabel;
    private javax.swing.JLabel yourShipsLabel;
    // End of variables declaration//GEN-END:variables
}