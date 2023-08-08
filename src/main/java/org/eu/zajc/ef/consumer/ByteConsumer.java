package org.eu.zajc.ef.consumer;

import java.util.function.Consumer;

/**
 * A {@link Consumer} variant that takes a primitive byte type.
 *
 * @author Marko Zajc
 */
public interface ByteConsumer {

	/**
	 * Performs this operation on the given argument.
	 *
	 * @param p
	 *            the input argument
	 */
	void accept(byte p);

}
