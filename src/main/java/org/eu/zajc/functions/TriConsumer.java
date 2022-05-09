package org.eu.zajc.functions;

/**
 * A consumer type that takes three generic types.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            first input type
 * @param <U>
 *            second input type
 * @param <V>
 *            third input type
 */
@FunctionalInterface
public interface TriConsumer<T, U, V> {

	void accept(T t, U u, V v);

}
