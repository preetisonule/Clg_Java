import java.io.*;
import java.net.*;
public class SumServer 
{
 private static final int PORT = 12345;
 public static void main(String[] args) 
{
 try (ServerSocket serverSocket = new ServerSocket(PORT)) {
 System.out.println("Server started. Waiting for client...");
 Socket socket = serverSocket.accept();
 System.out.println("Client connected: " + socket);
 BufferedReader in = new BufferedReader(new 
InputStreamReader(socket.getInputStream()));
 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
 String num1Str = in.readLine();
 String num2Str = in.readLine();
 int num1 = Integer.parseInt(num1Str);
 int num2 = Integer.parseInt(num2Str);
 int sum = num1 + num2;
 out.println("Sum is: " + sum);
 socket.close();
 System.out.println("Connection closed.");
 } catch (IOException e) {
 System.out.println("Server error: " + e.getMessage());
 }
 }
}