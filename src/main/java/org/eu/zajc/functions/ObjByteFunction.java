package org.eu.zajc.functions;

/**
 * A function type that takes a generic type and a primitive byte, and returns a generic type.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            input type
 * @param <R>
 *            return type
 */
@FunctionalInterface
public interface ObjByteFunction<T, R> {

	R apply(T t, byte value);

}
