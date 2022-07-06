package com.github.markozajc.ef.function.except;

import static com.github.markozajc.ef.Utilities.asUnchecked;

import com.github.markozajc.ef.function.ByteFunction;

/**
 * Variant of {@link ByteFunction} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <R>
 *            the type of the result of the function
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EByteFunction<R, E extends Throwable> extends ByteFunction<R> {

	@Override
	default R apply(byte p) {
		try {
			return applyChecked(p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #apply(byte)}, but throws a checked exception.
	 *
	 * @param p
	 *            the function argument
	 *
	 * @return the function result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	R applyChecked(byte p) throws E;

}
