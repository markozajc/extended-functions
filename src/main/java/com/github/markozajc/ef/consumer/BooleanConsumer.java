package com.github.markozajc.ef.consumer;

import java.util.function.Consumer;

/**
 * A {@link Consumer} variant that takes a primitive boolean type.
 *
 * @author Marko Zajc
 */
public interface BooleanConsumer {

	/**
	 * Performs this operation on the given argument.
	 *
	 * @param p
	 *            the input argument
	 */
	void accept(boolean p);

}
