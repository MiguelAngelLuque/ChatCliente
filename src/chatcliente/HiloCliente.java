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

    HiloCliente(Socket socketConectado) {
        socketDatos = socketConectado;
    }

    public void run() {
        try {
            while (true) {
                DataInputStream br = new DataInputStream(socketDatos.getInputStream());
                String r = br.readUTF();
                System.out.println("Respuesta: " + r);
            }
        }
         catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
