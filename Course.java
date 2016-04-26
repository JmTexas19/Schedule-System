/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Schedule;

import java.util.ArrayList;  //For use of ArrayList
import javax.swing.JOptionPane;

public class Course implements java.io.Serializable{  
    
    //Initializations
    private String name;
    private int roomNum, hour, students;
    private static int hourStudent;
    private ArrayList<Student> studentList = new ArrayList<>();    
    private static ArrayList<Course> courseList = new ArrayList<>();
    private static ArrayList<Integer> times = new ArrayList<>(24);
        
    //CONSTRUCTORS--------------------------------------------------------------
    public Course(String name, int hour, int roomNum, int students){  //Constructor
        this.name = name;
        this.students = students;
        this.roomNum = roomNum; 
        
        boolean check1 = false;
        boolean check2 = false;
        
        if(hour > 8 && hour < 16 ){  //Forces time between 9-5
            this.hour = hour;
            this.hourStudent = hour;
            check1 = true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Not a valid time slot. Must be 9-5. ");         
        }
        
        check2 = checkCourseExist(name);
        
        if(check1 == true && check2 == true){
            boolean inUse = checkTime(this.hour, this.roomNum);  //Checks if time is in use
            if(inUse == false){
                times.add(this.hour);  //Adds time to list
                boolean pass = Room.addCourse(this.roomNum, this);  //Adds course and checks if it can be added
                if(pass == true){
                    courseList.add(this);  //Adds course object to list
                }
            }
        }
    }
    
    //METHODS-------------------------------------------------------------------
    public String getName(){  //Returns name
        return name;
    }
    
    public int getHour(){
        return hour;
    }
    
    public int getRoomNum(){
        return roomNum;
    }
    
    public int getStudents(){
        return students;
    }
    
    public static void setCourseList(ArrayList<Course> cList){
        courseList = cList;
    }
    
    public static int getHour(String course){  //Returns course hour, static for use Student
        boolean exist = false;  //Determines whether course exist
        
        for(int i = 0; i < courseList.size(); i++){  //Iterates through list
            if(courseList.get(i).name.equals(course)){  //Checks if course is in list
                exist = true;
                hourStudent = courseList.get(i).hour;  //Sets course hour to student hour                
            }
        }
        
        if(exist == false){
            JOptionPane.showMessageDialog(null, "Course could not be found. ");
            return -1;  //Number for marking if hour doesn't exist
        }
        else{
            return hourStudent; 
        }
    }
    
    public static boolean checkStudent(String first, String last){  //Checks if student is enrolled in course
        boolean enrolled = false;  //Flag for enrolled
        
        for (int i = 0; i < courseList.size(); i++){  //iterates through course list              
            for(int j = 0; j < courseList.get(i).studentList.size(); j++){  //iterates through student list in course
                if(courseList.get(i).studentList.get(j).getFirstName().equals(first) &&  //Checks for name in list
                        courseList.get(i).studentList.get(j).getLastName().equals(last)){

                    JOptionPane.showMessageDialog(null, String.format(
                            "%s%s%s%s%n", first, " ", last,
                            " can't be deleted because they are currently" + " enrolled in a course. "));

                    enrolled = true;
                }                    
            }
        }
        
        return enrolled;
    }
    
    public static boolean removeStudent(String first, String last, String course){  //Removes student from course
        boolean exist = false;
        boolean found = false;
        boolean pass = false;
        int cIndex = 0;  
        
        for (int i = 0; i < courseList.size(); i++){
            if(courseList.get(i).getName().equals(course)){
                exist = true;
                cIndex = i;  //Saves course object

                for(int j = 0; j < courseList.get(i).studentList.size(); j++){  //Checks for student in list
                    if(courseList.get(i).studentList.get(j).getFirstName().equals(first) &&
                            courseList.get(i).studentList.get(j).getLastName().equals(last)){

                        courseList.get(i).studentList.remove(j);  //Removes student from course 
                        JOptionPane.showMessageDialog(null, String.format("%s%s%s%s%s%s%n", first, " ", last,
                                " removed from course \"", course, "\"."));

                        found = true;  
                        pass = true;
                    } 
                }  
            }                     
        }
        
        if(exist == false){
            JOptionPane.showMessageDialog(null, "Could not find a course with that name. ");
        }

        if(found == false){
            JOptionPane.showMessageDialog(null, "Student could not be found in that course. ");
        }
        
        return pass;
    }
    
    public static boolean addStudent(String first, String last, String course, Student s){  //Adds student to course
        boolean exist = false;
        boolean inCourse = false;
        boolean pass = false;
        boolean full = false;
        int cIndex = 0;
        
        for (int i = 0; i < courseList.size(); i++){
            if(courseList.get(i).getName().equals(course)){
                if(courseList.get(i).studentList.size() < courseList.get(i).students){  //Makes sure course isn't full
                    
                    exist = true;
                    cIndex = i;  //Saves course object              
                
                    for(int j = 0; j < courseList.get(i).studentList.size(); i++){
                        if(courseList.get(i).studentList.get(j).getFirstName().equals(first) &&
                                courseList.get(i).studentList.get(j).getLastName().equals(last)){
                            inCourse = true;                                                 

                            JOptionPane.showMessageDialog(null, String.format("%s%s%s%s%n", first, " ", last, 
                                    " Already in course. "));
                        } 
                    }  
                }
                else{
                    JOptionPane.showMessageDialog(null, "Course is full, cannot add any more students. ");
                    full = true;  //Sets flag for course being full to true
                }
            }            
        }
        
        if(exist == false && full == false){
            JOptionPane.showMessageDialog(null, "Could not find course to enroll student into. ");
        }
        if (inCourse == false && exist == true){            
                courseList.get(cIndex).studentList.add(s);  //Adds student to course
                JOptionPane.showMessageDialog(null, String.format("%s%s%s%s%s%s%n", first, " ", last, 
                        " added to course \"", course, "\"."));
                pass = true;                    
        }
        return pass;
    }
    
    public static void deleteCourse(String name){  //Deletes course
        boolean pass;
        boolean inUse = false;
        
        for(int i = 0; i < courseList.size(); i++){ 
            if (courseList.get(i).getName().equals(name)){
                if(!courseList.get(i).studentList.isEmpty()){  //Checks if course is empty
                        inUse = true;  //Flag for course in use
                        JOptionPane.showMessageDialog(null, String.format("%s%s%s%n", "Cannot delete course, \"",
                                name, "\" there are currently students enrolled." ));
                }
            }
        }
        
        if(inUse == false){
            pass = Room.removeCourse(name);  //Removes course

            if(pass == true){     

                for(int i = 0; i < courseList.size(); i++){
                    if (courseList.get(i).getName().equals(name)){                   
                            times.clear();
                            courseList.remove(i);
                            JOptionPane.showMessageDialog(null, "Course Removed ");                    
                    }              
                }           
            }
        }
    }
    
    public static void deleteAllCourses(){  //Deletes all courses and all course in room object
        courseList = new ArrayList<>();  
        Room.removeAllCourses();  
        JOptionPane.showMessageDialog(null, "ALL COURSES DELETED");
    }
    
    public static boolean checkTime(int hour, int roomNum){
        boolean exist = false;
        
        for(int i = 0; i < courseList.size(); i++){
            if(courseList.get(i).hour == hour && courseList.get(i).roomNum == roomNum){
                exist = true;
                
                JOptionPane.showMessageDialog(null, "Time already in use, course could not be added. ");
            }
        }
        
        return exist;
    }   
    
    public static String[] displayCourses(){  //Displays all courses
        String[] list = new String[100];
        
        if(!courseList.isEmpty()){
            for(int i = 0; i < courseList.size(); i++){                
                list[i] = courseList.get(i).name;
            }
        }
        
        return list;
    }
    
    public static String[] displayCoursesTime(int hour){  //Displays all courses at a specific time
        String[] list = new String[100];
        
        if(times.size() > 0){
            for(int i = 0; i < courseList.size(); i++){  //Checks if time exist
                if(courseList.get(i).hour == hour){
                    list[i] = courseList.get(i).name;
                }
            }
        }
        
        return list;
    }
    
    public static ArrayList<Course> getCourseList(){
        return courseList;
    }
    
    public boolean checkCourseExist(String name){
        boolean doesNotExist = true;
        
        for(int i = 0; i < courseList.size(); i++){ 
            if (courseList.get(i).getName().equals(name)){
                doesNotExist = false;
                JOptionPane.showMessageDialog(null, "That course already exist");
            }
        }
        
        return doesNotExist;
    }
}
        
