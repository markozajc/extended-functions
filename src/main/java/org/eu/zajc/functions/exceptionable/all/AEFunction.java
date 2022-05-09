package org.eu.zajc.functions.exceptionable.all;

import java.util.function.Function;

import org.eu.zajc.functions.exceptionable.EFunction;

/**
 * Variant of {@link Function} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 * @param <R>
 */
@FunctionalInterface
public interface AEFunction<T, R> extends EFunction<T, R, Exception> {}
