/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tessocket;
import java.net.*;

import java.io.*;

public class Server {

public static void main(String[] args) {

    try {
        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Menunggu Klien...");
        Socket s = ss.accept();
        System.out.println("Klien telah masuk");
        System.out.println("Server pada port = "+
        s.getLocalAddress().getHostAddress() + " : " + s.getLocalPort());
        System.out.println("Client pada port = "+
        s.getInetAddress().getHostAddress() + " : " + s.getPort()); 
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.out.println("Menunggu pesan...");
        String greetings = "";
        while ((greetings=br.readLine())!=null) { System.out.println(greetings);
        }
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        System.out.println("Selesai");
        br.close();
        pw.close();
        s.close(); ss.close();
    }

    catch (Exception e) { 
        e.printStackTrace(); 
    }
}

}

