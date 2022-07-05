package com.github.markozajc.ef.function.except;

import static com.github.markozajc.ef.EFUtils.asUnchecked;

import com.github.markozajc.ef.function.ObjByteFunction;

/**
 * Variant of {@link ObjByteFunction} capable of throwing a generic
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
public interface EObjByteFunction<T, R, E extends Throwable> extends ObjByteFunction<T, R> {

	@Override
	default R apply(T t, byte p) {
		try {
			return applyChecked(t, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #apply(Object, byte)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first function argument
	 * @param b
	 *            the second ({@code byte}) function argument
	 *
	 * @return the function result
	 *
	 * @throws E
	 *             the defined exception type
	 */
	R applyChecked(T t, byte b) throws E;

}
