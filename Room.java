/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Schedule;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Room implements java.io.Serializable{  //Make classes serializable
    
    private int number, numOfClasses;
    private static int numOfRooms = 1000;
    private ArrayList<Course> courseList = new ArrayList<>();
    private static ArrayList<Room> roomList = new ArrayList<>();
    
    
    //CONSTRUCTORS--------------------------------------------------------------
    public Room(int number, int numOfClasses){  //Constructor, initialize room
        this.number = number;
        this.numOfClasses = numOfClasses;
        
        boolean check1 = false;
        boolean check2 = false;
        
        if(roomList.size() < numOfRooms){  //Checks if enough rooms are available
            check1 = true;
        } 
        else{
            JOptionPane.showMessageDialog(null, "Room not added, not enough rooms available. ");
        }
        
        check2 = checkIfRoomExist(number);
        
        if(check1 == true && check2 == true){
            roomList.add(this);  //Adds room object to list
            JOptionPane.showMessageDialog(null, "Room Added");
        }
        
    }
    
    //METHODS-------------------------------------------------------------------
    public static void numOfRooms(int r){  //Allows user to set number of rooms
        numOfRooms = r;
        JOptionPane.showMessageDialog(null, "Rooms Set");
    }
    
    public int getRoomNum(){  //Gets room number
        return number;
    }
    
    public static ArrayList<Room> getRoomList(){  //Gets room list
        return roomList;
    }
    
    public static void setRoomList(ArrayList<Room> rList){
        roomList = rList;
    }
    
    public static boolean removeCourse(String name){  //Removes course from room object
        boolean exist = false;
        
        try{
            for(int j = 0; j < roomList.size(); j++){
                for(int i = 0; i < roomList.get(j).courseList.size(); i++){
                    if (roomList.get(j).courseList.get(i).getName().equals(name)){
                        roomList.get(j).courseList.remove(i);

                        exist = true;
                    }           
                }   
            }
            if(exist == false){
                JOptionPane.showMessageDialog(null, "Could not find course to delete. ");
            }
        }
        catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Could not find a room or course to delete. ");
        }
        
        return exist;
    }
    
    public static void removeAllCourses(){  //Removes all courses from a room object
        for(int i = 0; i < roomList.size(); i++){
            roomList.get(i).courseList = new ArrayList<>();
        }
    }
    
    public static String[] displayRoomCourses(int roomNum){  //Displays courses in a room;
        String[] list = new String[100];
        
        for(int i = 0; i < roomList.size(); i++){
            if(roomList.get(i).number == roomNum){                
                if(!roomList.get(i).courseList.isEmpty()){  //Checks if there are any courses in a room
                    for(int j = 0; j < roomList.get(i).courseList.size(); j++){ 
                        list[j] = roomList.get(i).courseList.get(j).getName();
                    }
                }
            }
        }
        
        return list;
    }
    
    public static void deleteRoom(int roomNum){  //Deletes room 
        boolean exist = false;
        
        for(int i = 0; i < roomList.size(); i++){
            if (roomList.get(i).getRoomNum() == roomNum){
                if(roomList.get(i).courseList.size() > 0){  //Checks if a course is in a room
                    JOptionPane.showMessageDialog(null, String.format("%s%d%s%n", "Cannot delete room ", roomNum, ", "
                        + "there is currently a course in the room. "));
                }
                else{
                    roomList.remove(i);  //Remove room
                
                    JOptionPane.showMessageDialog(null, String.format("%s%d%s%n",  "Room ", roomNum, " Deleted"));                               
                }
                exist = true;
            }            
        }
        
        if(exist == false){
            JOptionPane.showMessageDialog(null, String.format("%s%d%s%n", "Room "
                    + "", roomNum, " does not exist, could not delete."));
        }       
    }
    
    public static boolean addCourse(int roomNum, Course c){  //Add Course to room.
        boolean empty = true;
        boolean pass = false;
                
        for(int i = 0; i < roomList.size(); i++){
            if (roomList.get(i).getRoomNum() == roomNum){
                empty = false;  //Marks room as not empty
                
                if(roomList.get(i).courseList.size() < roomList.get(i).numOfClasses){  //Checks if enough course spaces are available
                    roomList.get(i).courseList.add(c);

                    JOptionPane.showMessageDialog(null, String.format("%s%s%s%d%n", "Course \"", c.getName(),
                            "\" added to room ", roomNum));
                   
                    pass = true;
                }     
                else{
                    JOptionPane.showMessageDialog(null, "Room is full, cannot add any more courses. ");
                }
            }
        }
        if (empty == true){
            JOptionPane.showMessageDialog(null, "No rooms with that room number. ");
        }
        return pass;
    }  
    
    public static boolean checkIfRoomExist(int roomNum){
        boolean doesNotExist = true;
        
        for(int i = 0; i < roomList.size(); i++){
            if (roomList.get(i).getRoomNum() == roomNum){
                doesNotExist = false;
                JOptionPane.showMessageDialog(null, "There is already a room with that number.");
            }         
        }
        
        return doesNotExist;
    }
}
            
           