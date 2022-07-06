package com.github.markozajc.ef.tripredicate.except.all;

import com.github.markozajc.ef.tripredicate.ObjObjShortPredicate;
import com.github.markozajc.ef.tripredicate.except.EObjObjShortPredicate;

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
