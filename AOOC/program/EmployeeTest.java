import java.util.Scanner;

 class Employee {
    String first_name;
    String last_name;
    double salary;
    Employee(){
        first_name="abc";
        last_name="xyz";
        salary=0;
    }
    void getinfo(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter First name:");
        first_name=sc.nextLine();
        System.out.println("Enter last name:");
        last_name=sc.nextLine();
        System.out.println("Enter Monthly salary:");
        salary=sc.nextInt();

    }
    void setinfo(){
        System.out.println("First name:" + first_name);
        System.out.println("Last name:" + last_name);
        if(salary<0)
        salary=0;
        System.out.println("salary:" + salary);
    }
    void yearly_salary(){
        System.out.println("Yearly salary of" +first_name+" " +last_name+ "is"+12*salary);
    }
    void real_salary(){
        System.out.println("Salary with 10% increament:" + (salary*12+10%(salary*12)));
    }
}
class EmployeeTest{
    public static void main(String []args){
        Employee e=new Employee();
        
        e.getinfo();
        e.setinfo();
        e.yearly_salary();
        e.real_salary();

     Employee e1=new Employee();
        e1.getinfo();
        e1.setinfo();
        e1.yearly_salary();
        e1.real_salary();

    
       
    
        

    }
}
