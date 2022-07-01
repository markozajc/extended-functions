package org.eu.zajc.functions.exceptionable;

import static org.eu.zajc.functions.exceptionable.Utilities.asUnchecked;

import org.eu.zajc.functions.ObjIntFunction;

/**
 * Variant of {@link ObjIntFunction} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <R>
 *            the type of the result of the function
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EObjIntFunction<T, R, E extends Throwable> extends ObjIntFunction<T, R> {

	@Override
	default R apply(T t, int i) {
		try {
			return applyChecked(t, i);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #apply(Object, int)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first function argument
	 * @param i
	 *            the second ({@code int}) function argument
	 *
	 * @return the function result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	R applyChecked(T t, int i) throws E;

}
