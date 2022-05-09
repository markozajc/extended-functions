package org.eu.zajc.functions;

/**
 * A function type that takes three generic types, and returns a generic type.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            first input type
 * @param <U>
 *            second input type
 * @param <V>
 *            third input type
 * @param <R>
 *            return type
 */
@FunctionalInterface
public interface TriFunction<T, U, V, R> {

	R apply(T t, U u, V v);

}
