package org.eu.zajc.functions.exceptionable;

@FunctionalInterface
public interface EObjObjIntFunction<T, U, R, E extends Throwable> {

	R apply(T t, U u, int value) throws E;

}
