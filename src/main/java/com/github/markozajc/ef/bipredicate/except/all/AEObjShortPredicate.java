package com.github.markozajc.ef.bipredicate.except.all;

import com.github.markozajc.ef.bipredicate.ObjShortPredicate;
import com.github.markozajc.ef.bipredicate.except.EObjShortPredicate;

/**
 * Variant of {@link ObjShortPredicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the predicate
 */
@FunctionalInterface
public interface AEObjShortPredicate<T> extends EObjShortPredicate<T, Exception> {}
