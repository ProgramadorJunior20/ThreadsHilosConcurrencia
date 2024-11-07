package co.jmurillo.hilos.ejemplo;

public class EjemploBasicoThread {
    public static void main(String[] args) {
        //Thread utilizando clase anónima
        Thread hilo1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;  i < 5; i++){
                    System.out.println("Hilo 1: Contador " + i);
                    try {
                        Thread.sleep(1000); // Pausa un segundo
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        // Thread usando lambda (forma más moderna)
        Thread hilo2 = new Thread(() -> {
            for (int i = 0; i < 5; i++){
                System.out.println("Hilo 2: Contador " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        //Iniciamos hilos
        hilo1.start();
        hilo2.start();

    }
}
