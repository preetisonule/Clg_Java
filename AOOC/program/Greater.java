import java.util.*;
class Greater{
public static void main(String args[]){
int a,b,c;
System.out.println("Enter three Numbers:");

Scanner sc=new Scanner(System.in);
a=sc.nextInt();
b=sc.nextInt();
c=sc.nextInt();

if(a>b && a>c){

System.out.println("a is greater ");


}else if(b>a && b>c){
System.out.println("b is greater");
}else{
System.out.print(c);System.out.print(" is greater");
}



}
}