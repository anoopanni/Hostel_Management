/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel;

/**
 *
 * @author RAJATH BHARADWAJ
 */
public class User_hostel {
    
       private int Hotel_id;
       private int No_of_rooms;
       private int No_of_Students;
       private int Annual_income;
       private String Location;
       
       
     
       public User_hostel(int Hotel_id,int No_of_rooms,int No_of_Students,int Annual_income,String Location)
       {
           this.Hotel_id=Hotel_id;
           this.No_of_rooms = No_of_rooms;
           this.No_of_Students= No_of_Students;
           this.Annual_income=Annual_income;
           this.Location = Location;
          
          
       }
       
       public int getId()
       {
           return this.Hotel_id;
       }
       
       public int getRooms()
       {
           return this.No_of_rooms;
       }
       
       public int getStudents()
       {
           return this.No_of_Students;
       }
       public int getIncome()
       {
           return this.Annual_income;
       }
       
       public String getLocation()
       {
           return this.Location;
       }
       
     
       
       
     }
 
    

