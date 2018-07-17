/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel;

 
public class User_staff {
    private int Emp_id;
    private String Emp_name;
    private String Address;
    private int Emp_salary;
    private int Hostel_id;
    
    public User_staff(int Emp_id,String Emp_name,String Address,int Emp_salary,int Hostel_id)
    {
        this.Emp_id=Emp_id;
        this.Emp_name=Emp_name;
        this.Address=Address;
        this.Emp_salary=Emp_salary;
        this.Hostel_id=Hostel_id;
    }
    
    
    public int getId()
    {
        return this.Emp_id;
        
    }
    
    public String getName()
    {
        return this.Emp_name;
    }
    public String getAddress()
    {
        return this.Address;
    }
    
    public int getSalary()
    {
        return this.Emp_salary;
    }
    
    public int getHid()
    {
        return this.Hostel_id;
    }
}
