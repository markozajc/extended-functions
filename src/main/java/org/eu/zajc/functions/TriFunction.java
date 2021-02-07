package org.eu.zajc.functions;

public interface TriFunction<T, U, V, R> {

	R apply(T t, U u, V v);

}
