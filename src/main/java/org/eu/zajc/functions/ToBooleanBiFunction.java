package org.eu.zajc.functions;

/**
 * A function type that takes two generic types, and returns a primitive boolean.
 *
 * @author Marko Zajc
 *
 * @param <T>
 * @param <U>
 */
@FunctionalInterface
public interface ToBooleanBiFunction<T, U> {

	boolean apply(T t, U u);

}
