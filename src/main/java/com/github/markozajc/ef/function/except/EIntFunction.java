package com.github.markozajc.ef.function.except;

import static com.github.markozajc.ef.EFUtils.asUnchecked;

import java.util.function.IntFunction;

/**
 * Variant of {@link IntFunction} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <R>
 *            the type of the result of the function
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EIntFunction<R, E extends Throwable> extends IntFunction<R> {

	@Override
	default R apply(int value) {
		try {
			return applyChecked(value);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #apply(int)}, but throws a checked exception.
	 *
	 * @param value
	 *            the function argument
	 *
	 * @return the function result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	R applyChecked(int value) throws E;

}
