package Ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServidor {

	public static void main(String[] args) throws IOException {
		String cadena="";
		String cadenaMayusculas="";
		int numeroPuerto = 6000;// Puerto
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		Socket clienteConectado = null;
		System.out.println("Esperando al cliente.....");
		clienteConectado = servidor.accept();
		
		// CREO FLUJO DE ENTRADA DEL CLIENTE
		InputStream entrada = null;
		entrada = clienteConectado.getInputStream();
		DataInputStream flujoEntrada = new DataInputStream(entrada);
		
		
		cadena=flujoEntrada.readUTF();
		System.out.println("Recibo del cliente la cadena: " + cadena);
		
		cadenaMayusculas=cadena.toUpperCase();
		
		
		// CREO FLUJO DE SALIDA AL CLIENTE
		OutputStream salida = null;
		salida = clienteConectado.getOutputStream();
		DataOutputStream flujoSalida = new DataOutputStream(salida);
		
		// ENVIO LA CADENA EN MAYUSCULAS
		flujoSalida.writeUTF("!Hola! tu cadena en mayusculas es: " + cadenaMayusculas);
		
		// CERRAR STREAMS Y SOCKETS
		entrada.close();
		flujoEntrada.close();
		salida.close();
		flujoSalida.close();
		clienteConectado.close();
		servidor.close();
		
		

	}

}
