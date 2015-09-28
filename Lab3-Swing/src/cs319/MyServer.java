package cs319;

// GOALS
//
// 1. to show sample Server code
// Note that the server is running on LOCALHOST (which is THIS computer) and the 
// port number associated with this server program is 4444.
// The accept() method just WAITS until some client program tries to access this server
//
// 2. to show how a thread is created to handle client request
//

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
	
	/*
	 * The Datamodel that will hold our list. Makes life easier instead of having to copy and paste stuff to make it work here.
	 */
	private static DataModel list;
	
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;
		int clientNum = 0; // keeps track of how many clients were created
		list = new DataModel();			
		// 1. CREATE A NEW SERVERSOCKET
		try {
			serverSocket = new ServerSocket(12345); // provide MYSERVICE at port
													// 4444
			System.out.println(serverSocket);
		} catch (IOException e) {
			System.out.println("Could not listen on port: 4444");
			System.exit(-1);
		}

		// 2. LOOP FOREVER - SERVER IS ALWAYS WAITING TO PROVIDE SERVICE!
		while (true) {
			Socket clientSocket = null;
			try {

				// 2.1 WAIT FOR CLIENT TO TRY TO CONNECT TO SERVER
				System.out.println("Waiting for client " + (clientNum + 1)
						+ " to connect!");
				clientSocket = serverSocket.accept();

				// 2.2 SPAWN A THREAD TO HANDLE CLIENT REQUEST
				System.out.println("Server got connected to a client"
						+ ++clientNum);
				Thread t = new Thread(new ClientHandler(clientSocket, clientNum, list));
				t.start();

			} catch (IOException e) {
				System.out.println("Accept failed: 4444");
				System.exit(-1);
			}

			// 2.3 GO BACK TO WAITING FOR OTHER CLIENTS
			// (While the thread that was created handles the connected client's
			// request)

		} // end while loop

	} // end of main method

} // end of class MyServer

class ClientHandler implements Runnable {
	Socket s; // this is socket on the server side that connects to the CLIENT
	int num; // keeps track of its number just for identifying purposes
	DataModel list;
	
	ClientHandler(Socket s, int n, DataModel list) {
		this.s = s;
		num = n;
		this.list = list;
	}

	// This is the client handling code
	public void run() {
		// printSocketInfo(s); // just print some information at the server side about the connection
		Scanner in;
		
		try {
			System.out.println("Starting to work with Client");
			// 1. USE THE SOCKET TO READ WHAT THE CLIENT IS SENDING
			in = new Scanner(s.getInputStream()); 
			String clientMessage = in.nextLine();
			System.out.println("Message: "+clientMessage);
			String command = clientMessage.substring(0, clientMessage.indexOf("^"));
			String rest = clientMessage.substring(clientMessage.indexOf("^")+1);
			// 2. Time to figure out 
			switch (command)
			{
			case "list":
				sendList();
				break;
			case "add": 
				list.addCompany(rest);
				break;
			case "remove":
				list.remove(Integer.parseInt(rest));
				break;
			default:
				System.out.println("Default. Split didn't work");
				return;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// This handling code dies after doing all the printing
	} // end of method run()

	void printSocketInfo(Socket s) {
		//System.out.print("Socket on Server " + Thread.currentThread() + " ");
		//System.out.print("Server socket Local Address: " + s.getLocalAddress()
	//			+ ":" + s.getLocalPort());
		//System.out.println("  Server socket Remote Address: "
			//	+ s.getRemoteSocketAddress());
	} // end of printSocketInfo
	
	private void sendList() throws IOException{
		System.out.println("Sending List");
		PrintWriter writer = new PrintWriter(s.getOutputStream());
		for(String s : list.x){
			writer.println(s);
		}
		writer.println("endTransmission");
		writer.flush();
		writer.close();
	}
	
} // end of class ClientHandler
