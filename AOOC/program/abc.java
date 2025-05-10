public class abc {
    public static void main(String [] args){
        try {
            abcd ob=new abcd();
            ob.display();
        } catch (ArithmeticException e) {
            System.out.println("Divide by zero");
        }
    }
    
}
class abcd{
    void display(){
        try{
            int a=5;
            int b=0;
            System.out.println(a/b);
        }finally{
            System.out.println("Finally Block executed");

        }
    }
}
