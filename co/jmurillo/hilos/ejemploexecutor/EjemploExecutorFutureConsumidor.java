  package co.jmurillo.hilos.ejemploexecutor;


import co.jmurillo.hilos.ejemplosinc.Panaderia;
import co.jmurillo.hilos.ejemplosinc.runnable.Consumidor;
import co.jmurillo.hilos.ejemplosinc.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorFutureConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);

        System.out.println("Tamaño del pool: " + executorService.getPoolSize());
        System.out.println("Cantidad de Tareas en cola: " + executorService.getQueue().size());

        Panaderia p = new Panaderia();
        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);
        Future<?> futuro1 = executorService.submit(productor);
        Future<?> futuro2 = executorService.submit(consumidor);


        System.out.println("Tamaño del pool: " + executorService.getPoolSize());
        System.out.println("Cantidad de Tareas en cola: " + executorService.getQueue().size());

        executorService.shutdown();
        System.out.println("Continuando con la ejecución del método main");

    }
}
