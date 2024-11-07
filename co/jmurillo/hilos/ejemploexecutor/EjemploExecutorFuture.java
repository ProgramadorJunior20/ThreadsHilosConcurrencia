package co.jmurillo.hilos.ejemploexecutor;


import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> tarea = ()-> {
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println("Nombre del thrad " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            System.out.println("Finaliza la tarea ...");

            return "Algo resultado importante de la tarea....";
        };

        Future<String> resultado = executorService.submit(tarea);
        executorService.shutdown();
        System.out.println("Continuando con la ejecución del método main");

        //System.out.println(resultado.isDone());
        while (!resultado.isDone()){
            System.out.println("Ejecutando tarea ....");
            TimeUnit.MILLISECONDS.sleep(1500);
        }
        System.out.println("Obtenemos resultado de la tarea: " + resultado.get());
        System.out.println("Finaliza la tarea: " + resultado.isDone());

    }
}
