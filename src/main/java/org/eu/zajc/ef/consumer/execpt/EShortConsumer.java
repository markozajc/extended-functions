package org.eu.zajc.ef.consumer.execpt;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import org.eu.zajc.ef.consumer.ShortConsumer;

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
