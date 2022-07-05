package com.github.markozajc.ef.function.except.all;

import java.util.function.Function;

import com.github.markozajc.ef.function.except.EFunction;

/**
 * Variant of {@link Function} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the input to the function
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface AEFunction<T, R> extends EFunction<T, R, Exception> {}
