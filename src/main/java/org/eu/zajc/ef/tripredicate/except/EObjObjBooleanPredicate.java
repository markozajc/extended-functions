package org.eu.zajc.ef.tripredicate.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import org.eu.zajc.ef.tripredicate.ObjObjBooleanPredicate;

/**
 * Variant of {@link ObjObjBooleanPredicate} capable of throwing a generic
 * {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the predicate
 * @param <U>
 *            the type of the second argument the predicate
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EObjObjBooleanPredicate<T, U, E extends Throwable> extends ObjObjBooleanPredicate<T, U> {

	@Override
	default boolean test(T t, U u, boolean p) {
		try {
			return testChecked(t, u, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #test(Object, Object, boolean)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param u
	 *            the second input argument
	 * @param p
	 *            the third ({@code boolean}) input argument
	 *
	 * @return {@code true} if the input arguments match the predicate, otherwise
	 *         {@code false}
	 *
	 * @throws E
	 *             the defined exception type
	 */
	boolean testChecked(T t, U u, boolean p) throws E;

}
