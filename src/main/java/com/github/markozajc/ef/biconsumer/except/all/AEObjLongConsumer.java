package com.github.markozajc.ef.biconsumer.except.all;

import java.util.function.ObjLongConsumer;

import com.github.markozajc.ef.biconsumer.except.EObjLongConsumer;

/**
 * Variant of {@link ObjLongConsumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 */
@FunctionalInterface
public interface AEObjLongConsumer<T> extends EObjLongConsumer<T, Exception> {}
