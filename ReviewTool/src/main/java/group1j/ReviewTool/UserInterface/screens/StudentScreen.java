/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group1j.ReviewTool.UserInterface.screens;

import group1j.ReviewTool.BusinessLogic.*;
import group1j.ReviewTool.UserInterface.*;
import group1j.ReviewTool.UserInterface.factories.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.Timer;

/**
 *
 * @author anilt
 */
public class StudentScreen extends javax.swing.JFrame implements Refreshable{

    /**
     * Creates new form StudentScreen
     */
    public StudentScreen() {
        initComponents();
    }
    
    public void refreshUI(){
        this.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emp = new javax.swing.JPanel();
        avatarIcon = new java.awt.Label();
        memberName = new javax.swing.JLabel();
        rankLabel = new javax.swing.JLabel();
        reviewButton = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        leftPanel = new javax.swing.JPanel();
        myGroupButton = new javax.swing.JToggleButton();
        myGroupButton.setFocusPainted(false);
        assignmentsButton = new javax.swing.JToggleButton();
        assignmentsButton.setFocusPainted(false);
        prsButton = new javax.swing.JToggleButton();
        assignmentsButton.setFocusPainted(false);
        topPanel = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        showTime();
        middlePanel = new javax.swing.JPanel();
        myGroupPanel = new javax.swing.JPanel();
        myGroupSP = new javax.swing.JScrollPane();
        myGroupInternalPanel = new javax.swing.JPanel();
        showMembers();

        emp.setBackground(new java.awt.Color(255, 255, 255));
        emp.setPreferredSize(new java.awt.Dimension(1140, 120));

        memberName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        memberName.setText("jLabel2");

        rankLabel.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        rankLabel.setText("jLabel1");

        reviewButton.setBackground(new java.awt.Color(255, 255, 255));
        reviewButton.setForeground(new java.awt.Color(255, 255, 255));
        reviewButton.setBorder(null);
        reviewButton.setFocusPainted(false);

        javax.swing.GroupLayout empLayout = new javax.swing.GroupLayout(emp);
        emp.setLayout(empLayout);
        empLayout.setHorizontalGroup(
            empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(empLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(avatarIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(memberName, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(empLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(rankLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 647, Short.MAX_VALUE)
                .addComponent(reviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        empLayout.setVerticalGroup(
            empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(empLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(empLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(empLayout.createSequentialGroup()
                        .addComponent(memberName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rankLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(avatarIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, empLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ReviewTool");
        setMinimumSize(new java.awt.Dimension(1300, 640));
        setPreferredSize(new java.awt.Dimension(1300, 640));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        leftPanel.setBackground(new java.awt.Color(23, 35, 51));
        leftPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myGroupButton.setBackground(new java.awt.Color(23, 35, 51));
        buttonGroup1.add(myGroupButton);
        myGroupButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        myGroupButton.setForeground(new java.awt.Color(255, 255, 255));
        myGroupButton.setSelected(true);
        myGroupButton.setText("My Group");
        myGroupButton.setBorder(null);
        myGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myGroupButtonActionPerformed(evt);
            }
        });
        leftPanel.add(myGroupButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 80));

        assignmentsButton.setBackground(new java.awt.Color(23, 35, 51));
        buttonGroup1.add(assignmentsButton);
        assignmentsButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        assignmentsButton.setForeground(new java.awt.Color(255, 255, 255));
        assignmentsButton.setText("Peer Reviews");
        assignmentsButton.setBorder(null);
        assignmentsButton.setFocusPainted(false);
        assignmentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignmentsButtonActionPerformed(evt);
            }
        });
        leftPanel.add(assignmentsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 160, 90));

        prsButton.setBackground(new java.awt.Color(23, 35, 51));
        buttonGroup1.add(prsButton);
        prsButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        prsButton.setForeground(new java.awt.Color(255, 255, 255));
        prsButton.setText("Assignments");
        prsButton.setBorder(null);
        prsButton.setFocusPainted(false);
        prsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prsButtonActionPerformed(evt);
            }
        });
        leftPanel.add(prsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 160, 90));

        getContentPane().add(leftPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 640));

        topPanel.setBackground(new java.awt.Color(71, 120, 199));

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setText("   UserName");
        usernameLabel.setText("User: " + UIController.getCurrentUser().getName());

        timeLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 614, Short.MAX_VALUE)
                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(topPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 1140, 80));

        middlePanel.setBackground(new java.awt.Color(255, 255, 255));
        middlePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myGroupPanel.setBackground(new java.awt.Color(255, 255, 255));
        myGroupPanel.setMinimumSize(new java.awt.Dimension(1140, 560));
        myGroupPanel.setPreferredSize(new java.awt.Dimension(1140, 560));
        myGroupPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myGroupSP.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        myGroupInternalPanel.setBackground(new java.awt.Color(255, 255, 255));
        myGroupInternalPanel.setLayout(new javax.swing.BoxLayout(myGroupInternalPanel, javax.swing.BoxLayout.Y_AXIS));
        myGroupSP.setViewportView(myGroupInternalPanel);

        myGroupPanel.add(myGroupSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 560));

        middlePanel.add(myGroupPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 560));

        getContentPane().add(middlePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 1140, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void myGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myGroupButtonActionPerformed
        //switchPanel("myGroup");
    }//GEN-LAST:event_myGroupButtonActionPerformed

    private void assignmentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignmentsButtonActionPerformed
        //switchPanel("assignments");
    }//GEN-LAST:event_assignmentsButtonActionPerformed

    private void prsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prsButtonActionPerformed
        //switchPanel("prs");
    }//GEN-LAST:event_prsButtonActionPerformed
    
    public void reviewButtonActionPerformed(){}
    
    private void showTime() {
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                timeLabel.setText(new SimpleDateFormat("H:mm:ss").format(new Date()));
                timeLabel.repaint();
            }
        });
        timeLabel.setText(new SimpleDateFormat("H:mm:ss").format(new Date()));
        timer.start();
        
    }
    
    private void showMembers(){
        myGroupSP.getVerticalScrollBar().setUnitIncrement(16);
        Group selectedGroup = UIController.getGlobalGroupList().get(0);
        
        for(User u: selectedGroup.getMembers()){
            UIPanel memberPanel = PanelFactory.createPanel("stMember");
            
            memberPanel.setLabel(u.getName());
            
            memberPanel.setLabel2(u.getClass().getSimpleName());
            
            JButton bt = memberPanel.getReviewButton();
            
            if(u.getClass().getSimpleName().equalsIgnoreCase("Student")){
                bt.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            reviewButtonActionPerformed();
                        }
                    });
            }
            
            else{
                bt.setVisible(false);
            }
            
            myGroupInternalPanel.add(memberPanel);
            myGroupInternalPanel.add(javax.swing.Box.createVerticalGlue());
        }
        
        myGroupInternalPanel.add(Box.createRigidArea(new Dimension(15, 15)));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton assignmentsButton;
    private java.awt.Label avatarIcon;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel emp;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel memberName;
    private javax.swing.JPanel middlePanel;
    private javax.swing.JToggleButton myGroupButton;
    private javax.swing.JPanel myGroupInternalPanel;
    private javax.swing.JPanel myGroupPanel;
    private javax.swing.JScrollPane myGroupSP;
    private javax.swing.JToggleButton prsButton;
    private javax.swing.JLabel rankLabel;
    private javax.swing.JButton reviewButton;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
