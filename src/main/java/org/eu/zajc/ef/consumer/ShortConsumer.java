package org.eu.zajc.ef.consumer;

import java.util.function.Consumer;

/**
 * A {@link Consumer} variant that takes a primitive short type.
 *
 * @author Marko Zajc
 */
public interface ShortConsumer {

	/**
	 * Performs this operation on the given argument.
	 *
	 * @param p
	 *            the input argument
	 */
	void accept(short p);

}
