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
        System.out.print("Ketikan pesan : ");
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String greeting = "";
        while(!(greeting=br.readLine()).equals("")) { pw.println(greeting);
        }     
        System.out.println("Selesai");
        br.close();
        pw.close();
        s.close();
    }
    
catch (Exception e)
{
    e.printStackTrace();
    }

}
}
