package com.github.markozajc.ef.function.except;

import static com.github.markozajc.ef.Utilities.asUnchecked;

import java.util.function.LongFunction;

/**
 * Variant of {@link LongFunction} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <R>
 *            the type of the result of the function
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface ELongFunction<R, E extends Throwable> extends LongFunction<R> {

	@Override
	default R apply(long value) {
		try {
			return applyChecked(value);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #apply(long)}, but throws a checked exception.
	 *
	 * @param p
	 *            the function argument
	 *
	 * @return the function result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	R applyChecked(long p) throws E;

}
