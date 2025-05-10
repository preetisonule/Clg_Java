class A{
    A(){
       System.out.println("Constructor of A get called.");
    }
}
class B extends A{
    B(){
        System.out.println("Constructor of B get called");
    }
}
class C extends B{
    C(){
        System.out.println("Constructor of C get called");
    }
}
public class constructor {
    public static void main(String[]args){
        C c=new C();
    }
    
}
