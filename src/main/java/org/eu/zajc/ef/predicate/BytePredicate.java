package org.eu.zajc.ef.predicate;

import java.util.function.Predicate;

/**
 * A variant of {@link Predicate} that takes a primitive byte.
 *
 * @author Marko Zajc
 */
public interface BytePredicate {

	/**
	 * Evaluates this predicate on the given argument.
	 *
	 * @param p
	 *            the input argument
	 *
	 * @return {@code true} if the input argument matches the predicate, otherwise
	 *         {@code false}
	 */
	boolean test(byte p);

}
