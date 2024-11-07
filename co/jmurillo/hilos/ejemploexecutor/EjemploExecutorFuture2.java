package co.jmurillo.hilos.ejemploexecutor;


import java.util.concurrent.*;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);

        System.out.println("Tamaño del pool: " + executorService.getPoolSize());
        System.out.println("Cantidad de Tareas en cola: " + executorService.getQueue().size());

        Callable<String> tarea = ()-> {
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println("Nombre del thrad " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            System.out.println("Finaliza la tarea ...");

            return "Algo resultado importante de la tarea....";
        };

        Callable<Integer> tarea2 = () -> {
            System.out.println("Iniciando tarea 3 ...");
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };

        Future<String> resultado = executorService.submit(tarea);
        Future<String> resultado2 = executorService.submit(tarea);
        Future<Integer> resultado3 = executorService.submit(tarea2);

        System.out.println("Tamaño del pool: " + executorService.getPoolSize());
        System.out.println("Cantidad de Tareas en cola: " + executorService.getQueue().size());

        executorService.shutdown();
        System.out.println("Continuando con la ejecución del método main");

        //System.out.println(resultado.isDone());
        while (!(resultado.isDone() && resultado2.isDone() && resultado3.isDone())){
            System.out.println(String.format("resultado1: %s - resultado2: %s - resultado3: %s",
                    resultado.isDone()? "finalizo" : "en proceso",
                    resultado2.isDone()? "finalizo" : "en proceso",
                    resultado3.isDone()? "finalizo" : "en proceso"
                    ));
            TimeUnit.MILLISECONDS.sleep(1000);
        }
        System.out.println("Obtenemos resultado1 de la tarea: " + resultado.get());
        System.out.println("Finaliza la tarea: " + resultado.isDone());

        System.out.println("Obtenemos resultado2 de la tarea: " + resultado2.get());
        System.out.println("Finaliza la tarea: " + resultado2.isDone());

        System.out.println("Obtenemos resultado3 de la tarea: " + resultado3.get());
        System.out.println("Finaliza la tarea: " + resultado3.isDone());

    }
}
