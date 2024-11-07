package co.jmurillo.hilos.ejemplosinc;

import co.jmurillo.hilos.ejemplosinc.runnable.Consumidor;
import co.jmurillo.hilos.ejemplosinc.runnable.Panadero;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();
        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();
    }
}
