package com.github.markozajc.ef.tripredicate.except;

import static com.github.markozajc.ef.Utilities.asUnchecked;

import com.github.markozajc.ef.tripredicate.ObjObjBytePredicate;

/**
 * Variant of {@link ObjObjBytePredicate} capable of throwing a generic
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
public interface EObjObjBytePredicate<T, U, E extends Throwable> extends ObjObjBytePredicate<T, U> {

	@Override
	default boolean test(T t, U u, byte p) {
		try {
			return testChecked(t, u, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #test(Object, Object, byte)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param u
	 *            the second input argument
	 * @param p
	 *            the third ({@code byte}) input argument
	 *
	 * @return {@code true} if the input arguments match the predicate, otherwise
	 *         {@code false}
	 *
	 * @throws E
	 *             the defined exception type
	 */
	boolean testChecked(T t, U u, byte p) throws E;

}
