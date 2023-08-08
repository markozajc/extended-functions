package org.eu.zajc.ef.function.except.all;

import org.eu.zajc.ef.function.ShortFunction;
import org.eu.zajc.ef.function.except.EShortFunction;

/**
 * Variant of {@link ShortFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface AEShortFunction<R> extends EShortFunction<R, Exception> {}
