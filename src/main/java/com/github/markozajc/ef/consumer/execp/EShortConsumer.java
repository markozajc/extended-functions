package com.github.markozajc.ef.consumer.execp;

import static com.github.markozajc.ef.EFUtils.asUnchecked;

import com.github.markozajc.ef.consumer.ShortConsumer;

/**
 * Variant of {@link ShortConsumer} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EShortConsumer<E extends Throwable> extends ShortConsumer {

	@Override
	default void accept(short p) {
		try {
			acceptChecked(p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(short)}, but throws a checked exception.
	 *
	 * @param p
	 *            the input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(short p) throws E;

}
