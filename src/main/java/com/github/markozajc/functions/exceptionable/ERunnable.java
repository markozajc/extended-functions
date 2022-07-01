package com.github.markozajc.functions.exceptionable;

import static com.github.markozajc.functions.exceptionable.Utilities.asUnchecked;

/**
 * Variant of {@link Runnable} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface ERunnable<E extends Throwable> extends Runnable {

	@Override
	default void run() {
		try {
			runChecked();
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #run()}, but throws a checked exception.
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void runChecked() throws E;

}
