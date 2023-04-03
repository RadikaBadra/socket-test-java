/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tessocket;
import java.net.*;
import java.io.*;

public class Client {

public static void main(String[] args) {
    try {
        Socket s = new Socket("192.168.18.8",3000);
        System.out.println("Komunikasi terhubung");
        System.out.println("Client pada port = "+
        s.getLocalAddress().getHostAddress() + " : "+ s.getLocalPort());
        System.out.println("Server pada port = "+
        s.getInetAddress().getHostAddress() + " : "+ s.getPort());
        
        BufferedReader op = new BufferedReader(new InputStreamReader(s.getInputStream()));
        System.out.println("Menunggu pesan...");
        String output = "";
        while ((output=op.readLine())!=null) { System.out.println(output);
        }
   
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
//        BufferedReader ip = new BufferedReader(new InputStreamReader(System.in));
//        String input = "";
//
//        while(!(input=ip.readLine()).equals("")) { pw.println(input);
//        }     
        System.out.println("Selesai");
        op.close();
//        ip.close();
        pw.close();
        s.close();
    }
    
catch (Exception e)
{
    e.printStackTrace();
    }

}
}
