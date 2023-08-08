package org.eu.zajc.ef.bipredicate.except.all;

import org.eu.zajc.ef.bipredicate.ObjBytePredicate;
import org.eu.zajc.ef.bipredicate.except.EObjBytePredicate;

/**
 * Variant of {@link ObjBytePredicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the predicate
 */
@FunctionalInterface
public interface AEObjBytePredicate<T> extends EObjBytePredicate<T, Exception> {}
