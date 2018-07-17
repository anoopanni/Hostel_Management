/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel;

public class Users_student {
    
       private int Student_id;
       private String Student_name;
       private String Father_name;
       private String Department;
       private String Dob;
       private int Fee;
       private int Hostel_id;
       
       public Users_student(int Student_id,String Student_name,String Father_name,String Department,String Dob,int Hostel_id,int Fee)
       {
           this.Student_id=Student_id;
           this.Student_name = Student_name;
           this.Fee=Fee;
           this.Department=Department;
           this.Father_name = Father_name;
           this.Dob = Dob;
           this.Hostel_id = Hostel_id;
       }
       
       public int getId()
       {
           return this.Student_id;
       }
       
       public String getName()
       {
           return this.Student_name;
       }
       
       public String getFname()
       {
           return this.Father_name;
       }
       public String getDepartment()
       {
           return this.Department;
       }
       
       public String getDob()
       {
           return this.Dob;
       }
       
       public int getHid()
          {
           return this.Hostel_id;
          }
       
       public int getFee()
       {
           return this.Fee;
       }
       
}
