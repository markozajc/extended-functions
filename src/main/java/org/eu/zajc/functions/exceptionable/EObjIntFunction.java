package org.eu.zajc.functions.exceptionable;

@FunctionalInterface
public interface EObjIntFunction<T, R, E extends Throwable> {

	R apply(T t, int value) throws E;

}
