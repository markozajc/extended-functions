package org.eu.zajc.ef.function.except.all;

import java.util.function.LongFunction;

import org.eu.zajc.ef.function.except.ELongFunction;

/**
 * Variant of {@link LongFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface AELongFunction<R> extends ELongFunction<R, Exception> {}
