package org.eu.zajc.functions;

/**
 * A function type that takes two generic types and a primitive boolean, and returns
 * a generic type.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            first input type
 * @param <U>
 *            second input type
 * @param <R>
 *            return type
 */
@FunctionalInterface
public interface ObjObjBooleanFunction<T, U, R> {

	R apply(T t, U u, boolean value);

}
