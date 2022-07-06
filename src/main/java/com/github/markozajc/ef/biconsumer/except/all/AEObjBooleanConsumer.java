package com.github.markozajc.ef.biconsumer.except.all;

import com.github.markozajc.ef.biconsumer.ObjBooleanConsumer;
import com.github.markozajc.ef.biconsumer.except.EObjBooleanConsumer;

/**
 * Variant of {@link ObjBooleanConsumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 */
@FunctionalInterface
public interface AEObjBooleanConsumer<T> extends EObjBooleanConsumer<T, Exception> {}
