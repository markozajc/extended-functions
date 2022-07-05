package com.github.markozajc.functions.exceptionable.all;

import java.util.function.Predicate;

import com.github.markozajc.functions.exceptionable.EPredicate;

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
