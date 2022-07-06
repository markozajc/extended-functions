package com.github.markozajc.ef.bipredicate.except.all;

import com.github.markozajc.ef.bipredicate.ObjBytePredicate;
import com.github.markozajc.ef.bipredicate.except.EObjBytePredicate;

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
