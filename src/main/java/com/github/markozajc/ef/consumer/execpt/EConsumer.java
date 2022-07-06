package com.github.markozajc.ef.consumer.execpt;

import static com.github.markozajc.ef.EFUtils.asUnchecked;

import java.util.function.Consumer;

/**
 * Variant of {@link Consumer} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the input to the operation
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EConsumer<T, E extends Throwable> extends Consumer<T> {

	@Override
	default void accept(T t) {
		try {
			acceptChecked(t);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(Object)}, but throws a checked exception.
	 *
	 * @param t
	 *            the input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(T t) throws E;

}
