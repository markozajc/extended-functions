package org.eu.zajc.ef.function.except.all;

import org.eu.zajc.ef.function.BooleanFunction;
import org.eu.zajc.ef.function.except.EBooleanFunction;

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
