package com.github.markozajc.ef.function.except;

import static com.github.markozajc.ef.Utilities.asUnchecked;

import com.github.markozajc.ef.function.BooleanFunction;

/**
 * Variant of {@link BooleanFunction} capable of throwing a generic
 * {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <R>
 *            the type of the result of the function
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EBooleanFunction<R, E extends Throwable> extends BooleanFunction<R> {

	@Override
	default R apply(boolean p) {
		try {
			return applyChecked(p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #apply(boolean)}, but throws a checked exception.
	 *
	 * @param p
	 *            the function argument
	 *
	 * @return the function result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	R applyChecked(boolean p) throws E;

}
