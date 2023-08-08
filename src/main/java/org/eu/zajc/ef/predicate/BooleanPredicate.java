package org.eu.zajc.ef.predicate;

import java.util.function.Predicate;

/**
 * A variant of {@link Predicate} that takes a primitive boolean.
 *
 * @author Marko Zajc
 */
public interface BooleanPredicate {

	/**
	 * Evaluates this predicate on the given argument.
	 *
	 * @param p
	 *            the input argument
	 *
	 * @return {@code true} if the input argument matches the predicate, otherwise
	 *         {@code false}
	 */
	boolean test(boolean p);

}
