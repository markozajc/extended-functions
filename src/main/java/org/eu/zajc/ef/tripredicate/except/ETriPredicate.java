package org.eu.zajc.ef.tripredicate.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import org.eu.zajc.ef.tripredicate.TriPredicate;

/**
 * Variant of {@link TriPredicate} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the predicate
 * @param <U>
 *            the type of the second argument the predicate
 * @param <V>
 *            the type of the third argument the predicate
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface ETriPredicate<T, U, V, E extends Throwable> extends TriPredicate<T, U, V> {

	@Override
	default boolean test(T t, U u, V v) {
		try {
			return testChecked(t, u, v);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #test(Object, Object, Object)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param u
	 *            the second input argument
	 * @param v
	 *            the third input argument
	 *
	 * @return {@code true} if the input arguments match the predicate, otherwise
	 *         {@code false}
	 *
	 * @throws E
	 *             the defined exception type
	 */
	boolean testChecked(T t, U u, V v) throws E;

}
