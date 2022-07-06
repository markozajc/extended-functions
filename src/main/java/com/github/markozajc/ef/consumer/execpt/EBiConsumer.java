package com.github.markozajc.ef.consumer.execpt;

import static com.github.markozajc.ef.EFUtils.asUnchecked;

import java.util.function.BiConsumer;

/**
 * Variant of {@link BiConsumer} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 * @param <U>
 *            the type of the second argument to the operation
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EBiConsumer<T, U, E extends Throwable> extends BiConsumer<T, U> {

	@Override
	default void accept(T t, U u) {
		try {
			acceptChecked(t, u);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(Object, Object)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param u
	 *            the second input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(T t, U u) throws E;

}
