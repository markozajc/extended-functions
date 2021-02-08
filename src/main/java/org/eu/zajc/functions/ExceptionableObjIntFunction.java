package org.eu.zajc.functions;

@FunctionalInterface
public interface ExceptionableObjIntFunction<T, R, E extends Throwable> {

	R apply(T t, int value) throws E;

}
