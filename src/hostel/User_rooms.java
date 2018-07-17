/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel;


public class User_rooms {
    private int Student_id;
    private int Hostel_id;
    private int Room_id;
    private int Capacity;
    
    public User_rooms(int Room_id,int Hostel_id,int Student_id ,int Capacity)
    {
        this.Student_id=Student_id;
        this.Hostel_id=Hostel_id;
        this.Room_id=Room_id;
        this.Capacity=Capacity;
        
    }
    
    public int getId()
    {
        return this.Student_id;
    }
    
    public int getHid()
    {
        return this.Hostel_id;
    }
    
    public int getRoom()
    {
        return this.Room_id;
    }
    
    public int getCapacity()
    {
       return this.Capacity;
    }
}
