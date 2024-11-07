package co.jmurillo.hilos.ejemplo;

public class CicloVidaThread extends Thread{
    private String estado;

    public CicloVidaThread(String nombre){
        super(nombre);
        estado = "CREADO";
    }

    public void run() {
        estado = "EJECUTANDO";
        System.out.println(getName() + " esta " + estado);

        try {
            Thread.sleep(2000); // Simula trabajo
            estado = "ESPERANDO";

            Thread.sleep(2000); // Mas Trabaja
            estado = "TERMINADO";
            System.out.println(getName() + " Esta " + estado);
        } catch (InterruptedException e){
            estado = "INTERRUMPIDO";
            System.out.println(getName() + " fue " + estado);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CicloVidaThread hilo = new CicloVidaThread("MiHilo");
        System.out.println(hilo.getName() + " está " + hilo.estado);

        hilo.start();

        try {
            hilo.join(); // Espera a que el hilo termine
            System.out.println(hilo.getName() + " ha finalizado");
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
