package com.empresa.proyecto.functionalprogramming;

public class HigherOrderFunctions {
    public static void main(String[] args) {
        IFactory<Integer> createFactory = createFactory(() -> Math.random() * 100, r -> r.intValue());
        Integer product = createFactory.create();
        System.out.println(product);
    }

    static <T, R> IFactory<R> createFactory(IProducer<T> producer,
                                            IConfigurator<T, R> configurator) {
        return () -> {
            T product = producer.produce();
            return configurator.configure(product);
        };
    }
}

interface IProducer<T> {
    T produce();
}

interface IConfigurator<T, R> {
    R configure(T t);
}

interface IFactory<T> {
    T create();
}