package co.jmurillo.hilos.ejemplo.thread;

public class NombreThread extends Thread{
    public NombreThread(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        System.out.println("se inicia el método run del hilo " + getName());

        for (int i = 0; i < 10; i++){
            System.out.println(this.getName());
        }

        System.out.println("Finaliza el hilo");
    }
}
