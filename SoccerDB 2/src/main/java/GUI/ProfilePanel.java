/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataStructures.SoccerPlayer;
import StaticClasses.InfoTableModel;

/**
 *
 * @author jward
 */
public class ProfilePanel extends javax.swing.JPanel {
    SoccerPlayer mvp;
    /**
     * Creates new form MVPPanel
     * @param mvp
     */
    public ProfilePanel(SoccerPlayer mvp){
        this.mvp = mvp;
        initComponents();
        if(mvp != null)
        {
            nameLabel.setText(mvp.getFirstName() + " " + mvp.getLastName());
            totalGoalsLabel.setText("Total Goals: " + (int)mvp.getTotalGoals());
            drawGoalPanel();
        }
    }

    private void drawGoalPanel() {
        // Get Roster Header
        String[] goalsHeader = new String[2];
        goalsHeader[0] = "Game";
        goalsHeader[1] = "Goals";


        // Get data for table
        String[][] goalsData = new String[mvp.getGoals().size()][goalsHeader.length];
        // Populate table with data
        for (int x = 0; x < goalsData.length; x++) {
            // Athlete Info
            goalsData[x][0] = "Game" + (x+1);
            goalsData[x][1] = "" + mvp.getGoals(x);
        }

        // Create JTable with all our data
        mvpGoalsTable.setModel(new InfoTableModel(goalsData, goalsHeader));

        mvpGoalsTable.getColumnModel().getColumn(0).setMinWidth(100);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        mvpGoalsTable = new javax.swing.JTable();
        totalGoalsLabel = new javax.swing.JLabel();

        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("First Last");

        mvpGoalsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Game", "Goals"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mvpGoalsTable.setMinimumSize(new java.awt.Dimension(30, 30));
        jScrollPane1.setViewportView(mvpGoalsTable);

        totalGoalsLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalGoalsLabel.setText("Total Goals: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalGoalsLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalGoalsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mvpGoalsTable;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel totalGoalsLabel;
    // End of variables declaration//GEN-END:variables
}