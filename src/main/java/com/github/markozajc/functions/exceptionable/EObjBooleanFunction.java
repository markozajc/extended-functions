package com.github.markozajc.functions.exceptionable;

import static com.github.markozajc.functions.exceptionable.Utilities.asUnchecked;

import com.github.markozajc.functions.ObjBooleanFunction;

/**
 * Variant of {@link ObjBooleanFunction} capable of throwing a generic
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
public interface EObjBooleanFunction<T, R, E extends Throwable> extends ObjBooleanFunction<T, R> {

	@Override
	default R apply(T t, boolean p) {
		try {
			return applyChecked(t, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #apply(Object, boolean)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first function argument
	 * @param b
	 *            the second ({@code boolean}) function argument
	 *
	 * @return the function result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	R applyChecked(T t, boolean b) throws E;

}
