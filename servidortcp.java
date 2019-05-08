package chat;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class servidortcp {
	public static void main(String argv[]) {
		ServerSocket socketEscolta;
		List<Socket> users = new ArrayList<>();
		try {
			socketEscolta = new ServerSocket(7000);
			while (true) {
				Socket socketClient = socketEscolta.accept();
				System.out.println("new user" + socketClient.toString());
				users.add(socketClient);
				EchoThread thread = new EchoThread(socketClient, users);
				thread.start();
				
			}
				
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static class EchoThread extends Thread {
		protected Socket socket;
		List<Socket> users;

	    public EchoThread(Socket clientSocket, List<Socket> users) {
	        this.socket = clientSocket;
	        this.users = users;
	    }
	    
	    public void run() {
	    	try {
	    		
    			Boolean fi = false;
	    		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
	    		ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
	    		while (!fi) {
		    		Mensaje missatgeRebut = (Mensaje) in.readObject();
		    		System.out.println(missatgeRebut);
		    		//out.writeObject(new Mensaje(missatgeRebut.nombre, missatgeRebut.mensaje));
     
	    			out.writeObject(new Mensaje(missatgeRebut.nombre, missatgeRebut.mensaje));
			    		
	    			fi = false;
	    		}
	    			    		
	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	}
	
}
