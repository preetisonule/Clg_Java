import java.io.*;
import java.net.*;
public class SumClient 
{
 private static final String SERVER_ADDRESS = "localhost";
 private static final int PORT = 12345;
 public static void main(String[] args) 
{
 try (
 Socket socket = new Socket(SERVER_ADDRESS, PORT);
 BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
 BufferedReader in = new BufferedReader(new 
InputStreamReader(socket.getInputStream()));
 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
 ) {
 System.out.print("Enter first number: ");
 String num1 = input.readLine();
 System.out.print("Enter second number: ");
 String num2 = input.readLine();
 
 out.println(num1);
 out.println(num2);
 String response = in.readLine();
 System.out.println("Server response: " + response);
 } catch (IOException e) {
 System.out.println("Client error: " + e.getMessage());
 }
 }
}