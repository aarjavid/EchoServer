// Code implements an Echo Server that will recieve client's message, if the message is in lower case, change it to upper case and send it back to the client.
// Example- If client sends 'hi', reciver will reply 'HI'
import java.net.*;
import java.io.*;

public class EchoServer {
	public static void main(String[] args) throws IOException {
    	if (args.length != 1) {
		System.err.println("Usage: java EchoServer <port number>");
		System.exit(1);
		var portNumber = Integer.parseInt(args[0]);
		try (
			ServerSocket serverSocket =
			new ServerSocket(Integer.parseInt(args[0]));
			Socket clientSocket = serverSocket.accept();     
			PrintWriter out =
			new PrintWriter(clientSocket.getOutputStream(), true);                   
			BufferedReader in = new BufferedReader(
			new InputStreamReader(clientSocket.getInputStream()));
			) 	{
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					out.println(inputLine.toUpperCase());
					}
			} catch (IOException e) {
					System.out.println("Exception caught when trying to listen on port "
					+ portNumber + " or listening for a connection");
					System.out.println(e.getMessage());
					}
			}
		}
}
