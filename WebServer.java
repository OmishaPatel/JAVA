import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

/**
 * The main() program in this class is designed to read requests from
 * a Web browser and display the requests on standard output.  The
 * program sets up a listener on port 5000.  It can be contacted
 * by a Web browser running on the same machine using a URL of the
 * form  http://localhost:50505/path/to/resource.html  This method
 * does not return any data to the web browser.  It simply reads the
 * request, writes it to standard output, and then closes the connection.
 * The program continues to run, and the server continues to listen
 * for new connections, until the program is terminated (by clicking the
 * red "stop" square in Eclipse or by Control-C on the command line).
 */
public class WebServer {
	
	/**
	 * The server listens on this port.  Note that the port number must
	 * be greater than 1024 and lest than 65535.
	 */
	private final static int LISTENING_PORT = 5002;
	private static Socket client;
	private static PrintStream outStream;
	static String requestFile;
	
	/**
	 * Main program opens a server socket and listens for connection
	 * requests.  It calls the handleConnection() method to respond
	 * to connection requests.  The program runs in an infinite loop,
	 * unless an error occurs.
	 * @param args ignored
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(LISTENING_PORT);
		}
		catch (Exception e) {
			System.out.println("Failed to create listening socket."+ e);
			return;
		}
		System.out.println("Listening on port " + LISTENING_PORT);
		try {
			while (true) {
				Socket connection = serverSocket.accept();
				System.out.println("\nConnection from " 
						+ connection.getRemoteSocketAddress());
				ConnectionThread thread = new ConnectionThread(connection);
				thread.start();
			}
		}
		catch (Exception e) {
			System.out.println("Server socket shut down unexpectedly!");
			System.out.println("Error: " + e);
			System.out.println("Exiting.");
		}
	}

	/**
	 * Handle communication with one client connection.  This method reads
	 * lines of text from the client and prints them to standard output.
	 * It continues to read until the client closes the connection or
	 * until an error occurs or until a blank line is read.  In a connection
	 * from a Web browser, the first blank line marks the end of the request.
	 * This method can run indefinitely,  waiting for the client to send a
	 * blank line.
	 * NOTE:  This method does not throw any exceptions.  Exceptions are
	 * caught and handled in the method, so that they will not shut down
	 * the server.
	 * @param connection the connected socket that will be used to
	 *    communicate with the client.
	 */
	
	
	
	
	private static void handleConnection(Socket connection) {
		String rootDirectory = "/Documents/";
		client = connection;
		// input and output stream for communication with client
		try {
			
			BufferedReader inStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
			outStream = new PrintStream(client.getOutputStream());
			
			String line = null;
			String request = null;
			
			// HTTP form GET <filename> HTTP/1.1
			
			request = inStream.readLine();
			// looping through line
			line = request;
			while (line.length() > 0) {
				line = inStream.readLine();
			}
			
			// create new token for the line
			StringTokenizer str = new StringTokenizer(request);
			
			if(!str.nextToken().equals("GET")) {
				/// send error message
				sendErrorResponse(501);
				return;
				
			}
			
			requestFile = str.nextToken();
			
			File f = new File(rootDirectory + requestFile);
			if(!f.canRead()) {
				sendErrorResponse(404);
				return;
			}
			if(!f.exists()) {
				sendErrorResponse(404);
				return;
			}
					
			sendResponseHeader(getMimeType(requestFile), (int)f.length());
			sendFile(f, client.getOutputStream());
			
			
			
;			
		}catch (Exception e){
			System.out.println("Error while communicating with client: " + e);
			
		}
		
		finally {  // make SURE connection is closed before returning!
			try {
				connection.close();
			}
			catch (Exception e) {
			}
			System.out.println("Connection closed.");
		}
	}
	
	/*
	 * This method sends the response header
	 */
	private static void sendResponseHeader(String type, int length) {
		outStream.println("HTTP/1.1 200 OK");
		outStream.println("Content-type: " + type);
		outStream.println("Content-Length: "+ length);
		outStream.println("Connection: close "+ "\r\n");
	}
	
	/*
	 * Method to send error messages and response
	 * 
	 */
	private static void sendErrorResponse(int error) {
		switch(error) {
		case 404:
			outStream.println("HTTP/1.1 404 Not Found");
			outStream.println("Connection: close");
			outStream.println("Content-type: text/plain "+ "\r\n");
			outStream.println("<html><head><title>Error</title></head><body><h3>Error: 404 Not Found</h3><p>The reource that you requested does not exist on this server.</p></body></html>");
			break;
		case 501:
			outStream.println("HTTP/1.1 501 Not implemented");
			outStream.println("Connection: close");
			outStream.println("Content-type: text/plain "+ "\r\n");
			break;
			
	}
		
	}
	
	/*
	 * Method to get mime type of file
	 */
	private static String getMimeType(String fileName) {
        int pos = fileName.lastIndexOf('.');
        if (pos < 0)  // no file extension in name
            return "x-application/x-unknown";
        String ext = fileName.substring(pos+1).toLowerCase();
        if (ext.equals("txt")) return "text/plain";
        else if (ext.equals("html")) return "text/html";
        else if (ext.equals("htm")) return "text/html";
        else if (ext.equals("css")) return "text/css";
        else if (ext.equals("js")) return "text/javascript";
        else if (ext.equals("java")) return "text/x-java";
        else if (ext.equals("jpeg")) return "image/jpeg";
        else if (ext.equals("jpg")) return "image/jpeg";
        else if (ext.equals("png")) return "image/png";
        else if (ext.equals("gif")) return "image/gif";
        else if (ext.equals("ico")) return "image/x-icon";
        else if (ext.equals("class")) return "application/java-vm";
        else if (ext.equals("jar")) return "application/java-archive";
        else if (ext.equals("zip")) return "application/zip";
        else if (ext.equals("xml")) return "application/xml";
        else if (ext.equals("xhtml")) return"application/xhtml+xml";
        else return "x-application/x-unknown";
           // Note:  x-application/x-unknown  is something made up;
           // it will probably make the browser offer to save the file.
     }
	
	/*
	 * method to send file to output socket
	 */
	private static void sendFile(File file, OutputStream socketOut) throws
	  IOException {
	    @SuppressWarnings("resource")
		InputStream inputfile = new BufferedInputStream(new FileInputStream(file));
	    OutputStream outputfile = new BufferedOutputStream(socketOut);
	    while (true) {
	      int x = inputfile.read(); // read one byte from file
	      if (x < 0)
	         break; // end of file reached
	      outputfile.write(x);  // write the byte to the socket
	   }
	   outputfile.flush();
	}
	
	/*
	 * method to create thread
	 */
	 private static class ConnectionThread extends Thread {
         Socket connection;
         ConnectionThread(Socket connection) {
            this.connection = connection;
         }
         public void run() {
            handleConnection(connection);
         }
      }

}// end of main
