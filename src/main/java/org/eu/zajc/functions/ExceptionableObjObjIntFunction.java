package org.eu.zajc.functions;

@FunctionalInterface
public interface ExceptionableObjObjIntFunction<T, U, R, E extends Throwable> {

	R apply(T t, U u, int value) throws E;

}
