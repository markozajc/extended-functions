package com.github.markozajc.ef.function.except;

import static com.github.markozajc.ef.Utilities.asUnchecked;

import java.util.function.Function;

/**
 * Variant of {@link Function} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the input to the function
 * @param <R>
 *            the type of the result of the function
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EFunction<T, R, E extends Throwable> extends Function<T, R> {

	@Override
	default R apply(T t) {
		try {
			return applyChecked(t);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #apply(Object)}, but throws a checked exception.
	 *
	 * @param t
	 *            the function argument
	 *
	 * @return the function result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	R applyChecked(T t) throws E;

}
