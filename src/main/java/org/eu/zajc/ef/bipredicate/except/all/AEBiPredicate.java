package org.eu.zajc.ef.bipredicate.except.all;

import java.util.function.BiPredicate;

import org.eu.zajc.ef.bipredicate.except.EBiPredicate;

/**
 * Variant of {@link BiPredicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the predicate
 * @param <U>
 *            the type of the second argument the predicate
 */
@FunctionalInterface
public interface AEBiPredicate<T, U> extends EBiPredicate<T, U, Exception> {}
