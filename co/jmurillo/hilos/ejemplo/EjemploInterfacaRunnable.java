package co.jmurillo.hilos.ejemplo;

import co.jmurillo.hilos.ejemplo.runneble.ViajeTarea;

public class EjemploInterfacaRunnable {
    public static void main(String[] args) {
        new Thread(new ViajeTarea("Hisla De Pascua")).start();
        new Thread(new ViajeTarea("Hisla De Nuqui")).start();
        new Thread(new ViajeTarea("Hisla Del Pacifoco")).start();
        new Thread(new ViajeTarea("Hisla De Threead")).start();
        new Thread(new ViajeTarea("Hisla De Lago Mind")).start();

    }
}
