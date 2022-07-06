package com.github.markozajc.ef.consumer.execp;

import static com.github.markozajc.ef.EFUtils.asUnchecked;

import java.util.function.IntConsumer;

/**
 * Variant of {@link IntConsumer} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EIntConsumer<E extends Throwable> extends IntConsumer {

	@Override
	default void accept(int p) {
		try {
			acceptChecked(p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(int)}, but throws a checked exception.
	 *
	 * @param p
	 *            the input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(int p) throws E;

}
