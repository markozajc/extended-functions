package org.eu.zajc.ef.function.except.all;

import org.eu.zajc.ef.function.ByteFunction;
import org.eu.zajc.ef.function.except.EByteFunction;

/**
 * Variant of {@link ByteFunction} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface AEByteFunction<R> extends EByteFunction<R, Exception> {}
