package org.eu.zajc.functions;

/**
 * A function type that takes a generic type and a primitive integer, and returns a
 * generic type.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            input type
 * @param <R>
 *            return type
 */
@FunctionalInterface
public interface ObjIntFunction<T, R> {

	R apply(T t, int value);

}
