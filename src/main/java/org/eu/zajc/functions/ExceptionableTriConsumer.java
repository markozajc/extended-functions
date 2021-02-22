package org.eu.zajc.functions;

@FunctionalInterface
public interface ExceptionableTriConsumer<T, U, V, E extends Throwable> {

	void accept(T t, U u, V v) throws E;

}
