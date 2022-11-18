package Ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServidor {

	public static void main(String[] args) throws IOException {
		
		int numero;
		int cuadrado;
		String cadena="";
		String cadenaMayusculas="";
		int numeroPuerto = 6000;// Puerto
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		Socket clienteConectado1 = null;
		Socket clienteConectado2=null;
		System.out.println("Esperando a los clientes.....");
		clienteConectado1 = servidor.accept();
		clienteConectado2=servidor.accept();
	
		
		// CREO FLUJO DE ENTRADA DEL CLIENTE 1
		InputStream entrada1 = null;
		entrada1 = clienteConectado1.getInputStream();
		DataInputStream flujoEntrada1 = new DataInputStream(entrada1);
		
		// CREO FLUJO DE ENTRADA DEL CLIENTE 2
		InputStream entrada2 = null;
		entrada2 = clienteConectado2.getInputStream();
		DataInputStream flujoEntrada2 = new DataInputStream(entrada2);		
		
		
		cadena=flujoEntrada1.readUTF();
		System.out.println("Recibo del CLIENTE 1 la cadena: " + cadena);
		
		cadenaMayusculas=cadena.toUpperCase();
		
		numero=flujoEntrada2.readInt();
		System.out.println("Recibo del CLIENTE 2 el numero: " + numero);
		
		cuadrado=numero*numero;
		
		
		// CREO FLUJO DE SALIDA AL CLIENTE 1
		OutputStream salida1 = null;
		salida1 = clienteConectado1.getOutputStream();
		DataOutputStream flujoSalida1 = new DataOutputStream(salida1);
		
		
		// CREO FLUJO DE SALIDA AL CLIENTE 2
		OutputStream salida2 = null;
		salida2 = clienteConectado2.getOutputStream();
		DataOutputStream flujoSalida2 = new DataOutputStream(salida2);
		
		
		// ENVIO LA CADENA EN MAYUSCULAS
		flujoSalida1.writeUTF("Hola, la cadena en mayusculas de " + cadena + " es: "  + cadenaMayusculas);
		
		// ENVIO EL CUADRADO DEL NUMERO
		flujoSalida2.writeUTF("Hola, el cuadrado del numero " + numero + " es: "  + cuadrado);
		
		// CERRAR STREAMS Y SOCKETS
		entrada1.close();
		entrada2.close();
		flujoEntrada1.close();
		flujoEntrada2.close();
		salida1.close();
		salida2.close();
		flujoSalida1.close();
		flujoSalida2.close();
		clienteConectado1.close();
		clienteConectado2.close();
		servidor.close();
		
		

	}

}
