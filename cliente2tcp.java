package chat;
import java.net.*;
import java.io.*;

public class cliente2tcp {

   public static void main(String argv[]) {
      
      BufferedReader teclat = new BufferedReader(new InputStreamReader(System.in));

      Socket socket;
      InetAddress address;
      String missatge="";
      String nombre = "Cliente Dos";

      try {
    	  
         address=InetAddress.getByName("localhost");
         socket = new Socket(address,7000);
         ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
         ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
         out.writeObject(new Mensaje("Client Dos", "HELLO"));
        
         do {
            Mensaje missatgeServidor = (Mensaje) in.readObject();
            System.out.println(missatgeServidor.nombre + ": " + missatgeServidor.mensaje);
        	 
            missatge = teclat.readLine();
            Mensaje payload = new Mensaje(nombre, missatge);
           	out.writeObject(payload);
        	
        } while (!missatge.startsWith("fi"));

	
        in.close();
        out.close();
        socket.close();
      } 
      catch (Exception e) {
         System.err.println(e.getMessage());
         System.exit(1);
      }
   }
}
