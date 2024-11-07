package co.jmurillo.hilos.ejemplo;

import co.jmurillo.hilos.ejemplo.thread.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {
        Thread hilo = new NombreThread("Jeff Doe");
        hilo.start();
        Thread.sleep(10000);
        Thread hilo2 = new NombreThread("Maria");
        hilo2.start();
        System.out.println(hilo.getState());
    }
}
