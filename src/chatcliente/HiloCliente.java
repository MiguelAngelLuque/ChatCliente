/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatcliente;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author admin
 */
public class HiloCliente implements Runnable {

    Socket socketDatos;
    Chat cht;

    HiloCliente(Socket socketConectado, Chat cht) {
        socketDatos = socketConectado;
        this.cht = cht;
    }

    public void run() {
        try {
            while (true) {
                DataInputStream br = new DataInputStream(socketDatos.getInputStream());
                String r = /*"[Luque,Alvaro,David]"*/br.readUTF();
                System.out.println("Respuesta: " + r);
                String[] rs = r.split(";");
                switch(rs[0]){
                    case "1":
                    case "2":
                        String f = rs[1];
                        f = f.replace("[", "");
                        f = f.replace("]", "");
                        f = f.replace(" ", "");
                        cht.actualizarLista(f);
                        break;
                    case "3":
                        //Global
                        String f2 = rs[1] + ": " + rs[2];
                        cht.actChat(f2);
                        break;
                }
            }
        }
         catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
