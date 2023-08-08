package org.eu.zajc.ef.bipredicate.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import org.eu.zajc.ef.bipredicate.ObjShortPredicate;

/**
 * Variant of {@link ObjShortPredicate} capable of throwing a generic
 * {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the predicate
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EObjShortPredicate<T, E extends Throwable> extends ObjShortPredicate<T> {

	@Override
	default boolean test(T t, short p) {
		try {
			return testChecked(t, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #test(Object, short)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param p
	 *            the second {@code short} input argument
	 *
	 * @return {@code true} if the input arguments match the predicate, otherwise
	 *         {@code false}
	 *
	 * @throws E
	 *             the defined exception type
	 */
	boolean testChecked(T t, short p) throws E;

}
