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
        try {
            //while (true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(socketDatos.getInputStream()));
                String r = br.readLine();
                System.out.println("Respuesta: " + r);
            //}
=======
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(socketDatos.getInputStream()));
        //while (true) {
                System.out.println("Estoy Escuchando");
                String r = br.readLine();
                System.out.println("Respuesta: " + r);
            
        //}
>>>>>>> 96a0ef3f250f4709ff76887bb4a95234ed813b19
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
