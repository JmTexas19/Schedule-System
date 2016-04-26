/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Schedule;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Student implements java.io.Serializable {
    
    private String firstName, lastName, phoneNum;
    private String regex = "\\d{10}";  //Regex for validating phone number
    private String regex2 = "^[^0-9]+$";
    private boolean valid = true;
    private ArrayList<String> courseList = new ArrayList<>();
    private ArrayList<Integer> timesStudent = new ArrayList<>();
    private static ArrayList<Student> studentList = new ArrayList<>();
    
    //CONSTRUCTORS--------------------------------------------------------------
    public Student (String firstName, String lastName, String phoneNum){  //Constructor
        this.firstName = firstName;
        this.lastName = lastName;
        
        if(!phoneNum.matches(regex)){  //Checks if phone number is valid
            JOptionPane.showMessageDialog(null, "Phone number was not valid. Student was not added. ");
            this.valid = false;
        }
        else{
            this.phoneNum = phoneNum;
        }
        
        if(!firstName.matches(regex2) || !lastName.matches(regex2)){
            JOptionPane.showMessageDialog(null, "Name input not valid. Student was not added.");
            this.valid = false;
        }
        
        if(checkIfStudentExist(firstName, lastName) == true){
            this.valid = false;
            JOptionPane.showMessageDialog(null, "Student already exist");
        }
        
        if (this.valid == true){
            studentList.add(this);
            JOptionPane.showMessageDialog(null, "Student added");
        }
    }
    
    //METHODS-------------------------------------------------------------------
    public String getFirstName(){  //Gets first name
        return firstName;
    }
    
    public String getLastName(){  //Gets last name
        return lastName;
    }
    
    public static ArrayList<Student> getStudentList(){
        return studentList;
    }
    
    public static void setStudentList(ArrayList<Student> sList){
        studentList = sList;
    }
    
    public static void unEnrollStudent(String first, String last, String course){  //Unenrolls student from course
         boolean exist = false;
         boolean pass;
         int hour;
        
        for(int i = 0; i < studentList.size(); i++){  
            if(studentList.get(i).getFirstName().equals(first) && //Checks if student exist
                    studentList.get(i).getLastName().equals(last)){
                                
                exist = true;  
                pass = Course.removeStudent(first, last, course);  //Removes student from course object and 
                                                                   //returns whether it is valid for removal
                if(pass == true){
                    hour = Course.getHour(course);  //Gets hour from course
                    removeTime(hour, studentList.get(i));  //Removes time from student list                                      
                    studentList.get(i).courseList.remove(course);  //Removes student from course
                }
            }
        }     
        
        if (exist == false){
           JOptionPane.showMessageDialog(null, String.format("%s%s%s%s%s%s%n", 
                   "Student ", first, " ", last,  " ", "not found."));
        }
    }
    
    public static void enrollStudent(String first, String last, String course){  //Enrolls student into course
        boolean exist = false;
        boolean pass;
        int hour;
        
        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getFirstName().equals(first) && 
                    studentList.get(i).getLastName().equals(last)){              
                
                exist = true;
                Student s = studentList.get(i);  //Saves student object
                hour = Course.getHour(course);  
                
                if(hour != -1){
                    boolean time = checkStudentTime(hour, s);  //Checks if time is already in use
                    
                    if(time == false){
                        pass = Course.addStudent(first, last, course, s);  

                        if(pass == true){
                            studentList.get(i).courseList.add(course);     
                        }
                    }
                }
            }
        }
        
        if (exist == false){
            JOptionPane.showMessageDialog(null, String.format("%s%s%s%s%s%n", "Student ", first, " ", last, " "
                    + "Could not be found."));
        }
     
    }
    
    public static void deleteStudent(String first, String last){  //Deletes a student
        boolean exist = false;
        
        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getLastName().equals(last) && 
                    studentList.get(i).getFirstName().equals(first)){
                
                exist = true;
                
                if(Course.checkStudent(first, last) == false){
                    studentList.remove(i);     
                    JOptionPane.showMessageDialog(null, "Student removed");                    
                }
            }
        }   
        
        if(exist == false){
            JOptionPane.showMessageDialog(null, String.format("%s%s%s%s%s%n", 
                    "Student ", first, " ", last, " not found."));
        }
    }
    
    public static boolean checkStudentTime(int hour, Student s){  //Checks if time is in use
        boolean exist = false;       
        
        for(int i = 0; i < s.timesStudent.size(); i++){
            if (s.timesStudent.get(i) == hour){
                
                exist = true;               
            }
        }
        
        if (exist == false){
            s.timesStudent.add(hour);
        }
        else{
            JOptionPane.showMessageDialog(null, String.format("%s%d%n", 
                    "Student already enrolled in course at ", hour));
        }
        
        return exist;
    }
    
    public static void removeTime(int hour, Student s){  //Removes time from list
        for(int i = 0; i < s.timesStudent.size(); i++){
            if(s.timesStudent.get(i) == hour){
                s.timesStudent.remove(i);
            }
        }
    }
    
    public static String[] displayStudentCourseList(String first, String last){  //Displays all courses a student is in
        boolean empty = true;
        boolean exist = false;
        String[] list = new String[100];
        
        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getFirstName().equals(first) && 
                    studentList.get(i).getLastName().equals(last)){
                exist = true;
                
                if(!studentList.get(i).courseList.isEmpty()){
                    empty = false;
                                
                    for(int j = 0; j < studentList.get(i).courseList.size(); j++){
                        list[j] = studentList.get(i).courseList.get(j);
                    }                                  
                }
            }                        
        } 
        
        if(empty == true && exist == true){
            JOptionPane.showMessageDialog(null, "Student has no courses. ");
        }
        
        if(exist == false){
            JOptionPane.showMessageDialog(null, "Could not find student with that name. ");
        }
        
        return list;
    }
    
    public static boolean checkIfStudentExist(String first, String last){
        boolean exist = false;
        
        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getLastName().equals(last) && 
                    studentList.get(i).getFirstName().equals(first)){
                
                exist = true;
            }
        }   
        
        return exist;
    }
}
