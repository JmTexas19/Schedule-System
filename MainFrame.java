/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Schedule;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author JCM5814
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form mainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        importFileChooser = new javax.swing.JFileChooser();
        saveFileChooser = new javax.swing.JFileChooser();
        addRoom = new javax.swing.JButton();
        deleteRoom = new javax.swing.JButton();
        addCourse = new javax.swing.JButton();
        deleteCourse = new javax.swing.JButton();
        deleteAllCourses = new javax.swing.JButton();
        addStudentButton = new javax.swing.JButton();
        deleteStudent = new javax.swing.JButton();
        enrollStudent = new javax.swing.JButton();
        displayCoursesButton = new javax.swing.JButton();
        displayRoomCoursesButton = new javax.swing.JButton();
        displayCoursesTime = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        displayList = new javax.swing.JList();
        unenrollStudent = new javax.swing.JButton();
        roomNum = new javax.swing.JFormattedTextField();
        hour = new javax.swing.JFormattedTextField();
        displayCoursesStudent = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        Import = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);

        addRoom.setText("Add Room");
        addRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomActionPerformed(evt);
            }
        });

        deleteRoom.setText("Delete Room");
        deleteRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRoomActionPerformed(evt);
            }
        });

        addCourse.setText("Add Course");
        addCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseActionPerformed(evt);
            }
        });

        deleteCourse.setText("Delete Course");
        deleteCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCourseActionPerformed(evt);
            }
        });

        deleteAllCourses.setText("Delete All Courses");
        deleteAllCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAllCoursesActionPerformed(evt);
            }
        });

        addStudentButton.setText("Add Student");
        addStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentButtonActionPerformed(evt);
            }
        });

        deleteStudent.setText("Delete Student");
        deleteStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStudentActionPerformed(evt);
            }
        });

        enrollStudent.setText("Enroll Student");
        enrollStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enrollStudentActionPerformed(evt);
            }
        });

        displayCoursesButton.setText("Display all courses ");
        displayCoursesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayCoursesButtonActionPerformed(evt);
            }
        });

        displayRoomCoursesButton.setText("Display all courses in a certain room");
        displayRoomCoursesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayRoomCoursesButtonActionPerformed(evt);
            }
        });

        displayCoursesTime.setText("Display all courses at a certain time");
        displayCoursesTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayCoursesTimeActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Schedule System");

        displayList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(displayList);

        unenrollStudent.setText("Unenroll Student");
        unenrollStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unenrollStudentActionPerformed(evt);
            }
        });

        displayCoursesStudent.setText("Display all courses being attended by student");
        displayCoursesStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayCoursesStudentActionPerformed(evt);
            }
        });

        File.setText("File");
        File.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                FileComponentAdded(evt);
            }
        });
        File.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileActionPerformed(evt);
            }
        });

        Import.setText("Import");
        Import.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportActionPerformed(evt);
            }
        });
        File.add(Import);

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        File.add(Save);

        jMenuBar1.add(File);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(enrollStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteStudent, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(addRoom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addCourse, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteCourse, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteAllCourses, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addStudentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(unenrollStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(displayCoursesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(40, 40, 40))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(displayRoomCoursesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(displayCoursesTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(roomNum)
                                .addComponent(hour))))
                    .addComponent(displayCoursesStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addRoom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteRoom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(addCourse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteCourse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteAllCourses))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addStudentButton)
                    .addComponent(displayCoursesButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(displayRoomCoursesButton)
                        .addComponent(roomNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(enrollStudent))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteStudent)
                            .addComponent(displayCoursesStudent))
                        .addGap(29, 29, 29)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unenrollStudent)
                    .addComponent(displayCoursesTime)
                    .addComponent(hour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deleteAllCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAllCoursesActionPerformed
        int choice = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete all courses?",
                null, 0);
        
        if(choice == 0){
            Course.deleteAllCourses();
        }
    }//GEN-LAST:event_deleteAllCoursesActionPerformed

    private void addRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomActionPerformed
        AddRoomFrame room = new AddRoomFrame();  //Creates room object
        room.setVisible(true);  //Opens new JFrame
    }//GEN-LAST:event_addRoomActionPerformed

    private void deleteStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStudentActionPerformed
        DeleteStudentFrame student = new DeleteStudentFrame();
        student.setVisible(true);
    }//GEN-LAST:event_deleteStudentActionPerformed

    private void deleteRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRoomActionPerformed
        DeleteRoomFrame room = new DeleteRoomFrame();
        room.setVisible(true);      
    }//GEN-LAST:event_deleteRoomActionPerformed

    private void displayCoursesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayCoursesButtonActionPerformed
        displayList.setModel(new javax.swing.AbstractListModel() {           
            String[] strings = Course.displayCourses();  //Adds string to list
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
});
    }//GEN-LAST:event_displayCoursesButtonActionPerformed

    private void addCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseActionPerformed
        AddCourseFrame room = new AddCourseFrame();
        room.setVisible(true);
    }//GEN-LAST:event_addCourseActionPerformed

    private void deleteCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCourseActionPerformed
        DeleteCourseFrame course = new DeleteCourseFrame();
        course.setVisible(true);
    }//GEN-LAST:event_deleteCourseActionPerformed

    private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentButtonActionPerformed
        AddStudentFrame student = new AddStudentFrame();
        student.setVisible(true);
    }//GEN-LAST:event_addStudentButtonActionPerformed

    private void enrollStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enrollStudentActionPerformed
        EnrollStudentForm student = new EnrollStudentForm();
        student.setVisible(true);
    }//GEN-LAST:event_enrollStudentActionPerformed

    private void unenrollStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unenrollStudentActionPerformed
        UnenrollStudentForm student = new UnenrollStudentForm();
        student.setVisible(true);
    }//GEN-LAST:event_unenrollStudentActionPerformed

    private void displayRoomCoursesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayRoomCoursesButtonActionPerformed
        try{
            int room = Integer.parseInt(roomNum.getText());  //Converts to int
        
            displayList.setModel(new javax.swing.AbstractListModel() {           
                String[] strings = Room.displayRoomCourses(room);
                public int getSize() { return strings.length; }
                public Object getElementAt(int i) { return strings[i]; }
            });
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Not a valid input");
        }
    }//GEN-LAST:event_displayRoomCoursesButtonActionPerformed

    private void displayCoursesTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayCoursesTimeActionPerformed
       try{
            int h = Integer.parseInt(hour.getText());
        
            displayList.setModel(new javax.swing.AbstractListModel() {           
                String[] strings = Course.displayCoursesTime(h);
                public int getSize() { return strings.length; }
                public Object getElementAt(int i) { return strings[i]; }
            });
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Not a valid input");
        }
    }//GEN-LAST:event_displayCoursesTimeActionPerformed

    private void displayCoursesStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayCoursesStudentActionPerformed
        String first = JOptionPane.showInputDialog("First Name");
        String last = JOptionPane.showInputDialog("Last Name");
        
        displayList.setModel(new javax.swing.AbstractListModel() {  //Adds names to list     
            String[] strings = Student.displayStudentCourseList(first, last);
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
    }//GEN-LAST:event_displayCoursesStudentActionPerformed

    private void ImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportActionPerformed
        importFileChooser.setDialogTitle("Specify a file to import");  //Sets import title
        int userChoice = importFileChooser.showOpenDialog(this);  //Opens file chooser and returns choice
        
        if(userChoice == JFileChooser.APPROVE_OPTION){  //If choice is open
            try{
                File fileToImport = importFileChooser.getSelectedFile();  //Creates file object chosen
                String path = fileToImport.getAbsolutePath();  //Gets path
                FileInputStream fileIn = new FileInputStream(path);  //Creates input stream with path
                ObjectInputStream in = new ObjectInputStream(fileIn);  //Creates input stream with file
                
                //Reads each Array List in
                ArrayList<Room> roomList = (ArrayList<Room>) in.readObject();
                Room.setRoomList(roomList);
                ArrayList<Course> courseList = (ArrayList<Course>) in.readObject();
                Course.setCourseList(courseList);   
                ArrayList<Student> studentList = (ArrayList<Student>) in.readObject();
                Student.setStudentList(studentList);
                
                in.close();  //Closes stream
                fileIn.close(); //Closes File

                JOptionPane.showMessageDialog(null, "Import Successful");
            }
            catch(IOException | ClassNotFoundException e){
                JOptionPane.showMessageDialog(null, "An error occured");
            }
        }
    }//GEN-LAST:event_ImportActionPerformed

    private void FileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FileActionPerformed

    private void FileComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_FileComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_FileComponentAdded

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        saveFileChooser.setDialogTitle("Specify a file to save");  //Sets save title
        int userChoice = saveFileChooser.showSaveDialog(this);  //Opens Save File Chooser and returns choice
        
        if(userChoice == JFileChooser.APPROVE_OPTION){  //If choice is save
            try{
                File fileToSave = saveFileChooser.getSelectedFile();  //Creates fileToSave object
                String path = fileToSave.getAbsolutePath();  //Gets file path
                FileOutputStream fileOut = new FileOutputStream(path);  //Creates fileoutputstream using file path
                ObjectOutputStream out = new ObjectOutputStream(fileOut);  //Creates object output stream using fileOut
                
                //Writes ArrayList to stream
                out.writeObject(Room.getRoomList());
                out.writeObject(Course.getCourseList());               
                out.writeObject(Student.getStudentList());
                out.close();

                JOptionPane.showMessageDialog(null, "Saved to: " + fileToSave.getAbsolutePath());  //Displays Path
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(null, "An error occured");
            }
        }
    }//GEN-LAST:event_SaveActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu File;
    private javax.swing.JMenuItem Import;
    private javax.swing.JMenuItem Save;
    private javax.swing.JButton addCourse;
    private javax.swing.JButton addRoom;
    private javax.swing.JButton addStudentButton;
    private javax.swing.JButton deleteAllCourses;
    private javax.swing.JButton deleteCourse;
    private javax.swing.JButton deleteRoom;
    private javax.swing.JButton deleteStudent;
    private javax.swing.JButton displayCoursesButton;
    private javax.swing.JButton displayCoursesStudent;
    private javax.swing.JButton displayCoursesTime;
    private javax.swing.JList displayList;
    private javax.swing.JButton displayRoomCoursesButton;
    private javax.swing.JButton enrollStudent;
    private javax.swing.JFormattedTextField hour;
    private javax.swing.JFileChooser importFileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFormattedTextField roomNum;
    private javax.swing.JFileChooser saveFileChooser;
    private javax.swing.JButton unenrollStudent;
    // End of variables declaration//GEN-END:variables
}