package co.jmurillo.hilos.ejemplo;

import co.jmurillo.hilos.ejemplo.runneble.ImprimirFrases;

public class EjemploSincronizacionThread {
    public static void main(String[] args) throws InterruptedException {
        Thread h1 = new Thread(new ImprimirFrases("Hola ", "que tal!?"));
        Thread h2 =  new Thread(new ImprimirFrases("Quién eres ", "tu?"));
        Thread.sleep(100);
        Thread h3 = new Thread(new ImprimirFrases("Muchas ", "Gracias amigo!"));

        h1.start();
        h2.start();
        h3.start();
        h1.join();
        h2.join();
        h3.join();
        System.out.println(h3.getState());

    }

    public synchronized static void imprimirFrases(String frase1, String frase2) {
        System.out.print(frase1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(frase2);
    }
}
