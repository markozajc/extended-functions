package org.eu.zajc.ef.predicate.except.all;

import java.util.function.Predicate;

import org.eu.zajc.ef.predicate.except.EPredicate;

/**
 * Variant of {@link Predicate} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the input to the predicate
 */
@FunctionalInterface
public interface AEPredicate<T> extends EPredicate<T, Exception> {}
