package co.jmurillo.hilos.ejemplo;

import co.jmurillo.hilos.ejemplo.runneble.ViajeTarea;

public class EjemploInterfacaRunnableJava8 {
    public static void main(String[] args) throws InterruptedException {

        Thread main = Thread.currentThread();
        Runnable viaje = () -> {
                for (int i = 0; i < 10; i++){
                    System.out.println(i + " - " + Thread.currentThread().getName());
                    try {
                        Thread.sleep((long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Finalmente me voy de viaje A: " + Thread.currentThread().getName());
                System.out.println(main.getState());
            };

        Thread v1 = new Thread(viaje, "Hisla De Pascua");
        Thread v2 = new Thread(viaje, "Hisla De Nuqui");
        Thread v3 = new Thread(viaje, "Hisla Del Pacifoco");
        Thread v4 = new Thread(viaje, "Hisla De Threead");


        v1.start();
        v2.start();
        v3.start();
        v4.start();
        v1.join();
        v2.join();
        v3.join();
        v4.join();
        //Thread.sleep(100000);
        System.out.println("Continuando con la ejecución del médoto main");

    }
}
