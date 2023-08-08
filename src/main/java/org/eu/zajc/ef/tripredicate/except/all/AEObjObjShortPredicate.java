package org.eu.zajc.ef.tripredicate.except.all;

import org.eu.zajc.ef.tripredicate.ObjObjShortPredicate;
import org.eu.zajc.ef.tripredicate.except.EObjObjShortPredicate;

/**
 * Variant of {@link ObjObjShortPredicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the predicate
 * @param <U>
 *            the type of the second argument the predicate
 */
@FunctionalInterface
public interface AEObjObjShortPredicate<T, U> extends EObjObjShortPredicate<T, U, Exception> {}
