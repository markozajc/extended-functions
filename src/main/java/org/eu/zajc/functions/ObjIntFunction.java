package org.eu.zajc.functions;

@FunctionalInterface
public interface ObjIntFunction<T, R> {

	R apply(T t, int value);

}
