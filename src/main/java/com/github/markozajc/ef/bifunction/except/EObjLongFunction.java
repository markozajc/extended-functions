package com.github.markozajc.ef.bifunction.except;

import static com.github.markozajc.ef.Utilities.asUnchecked;

import com.github.markozajc.ef.bifunction.ObjLongFunction;

/**
 * Variant of {@link ObjLongFunction} capable of throwing a generic
 * {@link Throwable}.
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
public interface EObjLongFunction<T, R, E extends Throwable> extends ObjLongFunction<T, R> {

	@Override
	default R apply(T t, long p) {
		try {
			return applyChecked(t, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #apply(Object, long)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first function argument
	 * @param p
	 *            the second ({@code long}) function argument
	 *
	 * @return the function result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	R applyChecked(T t, long p) throws E;

}
