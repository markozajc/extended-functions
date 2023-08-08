package org.eu.zajc.ef.bipredicate.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import org.eu.zajc.ef.bipredicate.ObjBooleanPredicate;

/**
 * Variant of {@link ObjBooleanPredicate} capable of throwing a generic
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
public interface EObjBooleanPredicate<T, E extends Throwable> extends ObjBooleanPredicate<T> {

	@Override
	default boolean test(T t, boolean p) {
		try {
			return testChecked(t, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #test(Object, boolean)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param p
	 *            the second {@code boolean} input argument
	 *
	 * @return {@code true} if the input arguments match the predicate, otherwise
	 *         {@code false}
	 *
	 * @throws E
	 *             the defined exception type
	 */
	boolean testChecked(T t, boolean p) throws E;

}
