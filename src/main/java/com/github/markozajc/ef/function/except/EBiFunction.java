package com.github.markozajc.ef.function.except;

import static com.github.markozajc.ef.EFUtils.asUnchecked;

import java.util.function.BiFunction;

/**
 * Variant of {@link BiFunction} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <U>
 *            the type of the second argument to the function
 * @param <R>
 *            the type of the result of the function
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EBiFunction<T, U, R, E extends Throwable> extends BiFunction<T, U, R> {

	@Override
	default R apply(T t, U u) {
		try {
			return applyChecked(t, u);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #apply(Object, Object)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first function argument
	 * @param u
	 *            the second function argument
	 *
	 * @return the function result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	R applyChecked(T t, U u) throws E;

}
