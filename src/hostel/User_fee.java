/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel;


public class User_fee {
       private int Student_id;
       private String Fee_status;
       private String Fee_month;
       public User_fee(int Student_id,String Fee_status,String Fee_month){
           this.Student_id = Student_id;
           this.Fee_month=Fee_month;
           this.Fee_status=Fee_status;
           
           
           
       }
       public int getId()
           {
               return this.Student_id;
           }
           
           public String getFee_s()
           {
               return this.Fee_status;
           }
           
           public String getFee_m(){
               return this.Fee_month;
           }
}
