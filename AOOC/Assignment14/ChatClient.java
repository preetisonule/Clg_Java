import java.io.*;
import java.net.*;
public class ChatClient 
{
 private static final String SERVER_ADDRESS = "localhost";
 private static final int PORT = 12345;
 public static void main(String[] args) {
 try (
 Socket socket = new Socket(SERVER_ADDRESS, PORT);
 BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
 BufferedReader in = new BufferedReader(new 
InputStreamReader(socket.getInputStream()));
 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
 {
 System.out.println("Connected to chat server");
 new Thread(() -> {
 String response;
 try {
 while ((response = in.readLine()) != null) {
 System.out.println(response);
 }
 } catch (IOException e) {
 System.out.println("Disconnected from server.");
 }
 }).start();
 String userInput;
 while ((userInput = input.readLine()) != null) {
 out.println(userInput);
 }
 } catch (IOException e) {
 System.err.println("Error: " + e.getMessage());
 }
 }
}