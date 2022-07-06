package com.github.markozajc.ef.consumer.execpt;

import static com.github.markozajc.ef.EFUtils.asUnchecked;

import java.util.function.LongConsumer;

/**
 * Variant of {@link LongConsumer} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface ELongConsumer<E extends Throwable> extends LongConsumer {

	@Override
	default void accept(long p) {
		try {
			acceptChecked(p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(long)}, but throws a checked exception.
	 *
	 * @param p
	 *            the input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(long p) throws E;

}
