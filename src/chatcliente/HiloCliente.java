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
<<<<<<< HEAD
        try{
        DataInputStream br = new DataInputStream(socketDatos.getInputStream());
        while (true) {
                System.out.println("Estoy Escuchando");
                String r = br.readUTF();
                System.out.println("Respuesta: " + r);
            
        }
        } catch (Exception ex) {
=======
        try {
            while (true) {
                DataInputStream br = new DataInputStream(socketDatos.getInputStream());
                String r = br.readUTF();
                System.out.println("Respuesta: " + r);
            }
        }
         catch (Exception ex) {
>>>>>>> 9d2d856ae3cc5824007e9b42effc12a73476854f
            ex.printStackTrace();
        }

    }

}
