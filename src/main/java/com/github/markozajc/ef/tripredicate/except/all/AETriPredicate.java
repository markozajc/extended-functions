package com.github.markozajc.ef.tripredicate.except.all;

import com.github.markozajc.ef.tripredicate.TriPredicate;
import com.github.markozajc.ef.tripredicate.except.ETriPredicate;

/**
 * Variant of {@link TriPredicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the predicate
 * @param <U>
 *            the type of the second argument the predicate
 * @param <V>
 *            the type of the third argument the predicate
 */
@FunctionalInterface
public interface AETriPredicate<T, U, V> extends ETriPredicate<T, U, V, Exception> {}
