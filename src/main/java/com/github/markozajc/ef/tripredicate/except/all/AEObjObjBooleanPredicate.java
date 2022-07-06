package com.github.markozajc.ef.tripredicate.except.all;

import com.github.markozajc.ef.tripredicate.ObjObjBooleanPredicate;
import com.github.markozajc.ef.tripredicate.except.EObjObjBooleanPredicate;

/**
 * Variant of {@link ObjObjBooleanPredicate} capable of throwing an
 * {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the predicate
 * @param <U>
 *            the type of the second argument the predicate
 */
@FunctionalInterface
public interface AEObjObjBooleanPredicate<T, U> extends EObjObjBooleanPredicate<T, U, Exception> {}
