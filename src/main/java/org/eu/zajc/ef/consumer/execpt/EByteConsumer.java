package org.eu.zajc.ef.consumer.execpt;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import org.eu.zajc.ef.consumer.ByteConsumer;

/**
 * Variant of {@link ByteConsumer} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EByteConsumer<E extends Throwable> extends ByteConsumer {

	@Override
	default void accept(byte p) {
		try {
			acceptChecked(p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(byte)}, but throws a checked exception.
	 *
	 * @param p
	 *            the input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(byte p) throws E;

}
