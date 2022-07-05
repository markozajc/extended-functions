package com.github.markozajc.functions.exceptionable.all;

import com.github.markozajc.functions.BooleanFunction;
import com.github.markozajc.functions.exceptionable.EBooleanFunction;

/**
 * Variant of {@link BooleanFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface AEBooleanFunction<R> extends EBooleanFunction<R, Exception> {}
