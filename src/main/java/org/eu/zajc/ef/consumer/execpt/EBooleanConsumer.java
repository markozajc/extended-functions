package org.eu.zajc.ef.consumer.execpt;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import org.eu.zajc.ef.consumer.BooleanConsumer;

/**
 * Variant of {@link BooleanConsumer} capable of throwing a generic
 * {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EBooleanConsumer<E extends Throwable> extends BooleanConsumer {

	@Override
	default void accept(boolean p) {
		try {
			acceptChecked(p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(boolean)}, but throws a checked exception.
	 *
	 * @param p
	 *            the input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(boolean p) throws E;

}
