package org.eu.zajc.functions;

@FunctionalInterface
public interface TriConsumer<T, U, V> {

	void accept(T t, U u, V v);

}
