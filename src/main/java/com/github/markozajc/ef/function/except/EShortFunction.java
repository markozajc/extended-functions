package com.github.markozajc.ef.function.except;

import static com.github.markozajc.ef.Utilities.asUnchecked;

import com.github.markozajc.ef.function.ShortFunction;

/**
 * Variant of {@link ShortFunction} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <R>
 *            the type of the result of the function
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EShortFunction<R, E extends Throwable> extends ShortFunction<R> {

	@Override
	default R apply(short value) {
		try {
			return applyChecked(value);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #apply(short)}, but throws a checked exception.
	 *
	 * @param p
	 *            the function argument
	 *
	 * @return the function result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	R applyChecked(short p) throws E;

}
