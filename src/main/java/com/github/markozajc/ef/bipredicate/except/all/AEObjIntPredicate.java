package com.github.markozajc.ef.bipredicate.except.all;

import com.github.markozajc.ef.bipredicate.ObjIntPredicate;
import com.github.markozajc.ef.bipredicate.except.EObjIntPredicate;

/**
 * Variant of {@link ObjIntPredicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the predicate
 */
@FunctionalInterface
public interface AEObjIntPredicate<T> extends EObjIntPredicate<T, Exception> {}
