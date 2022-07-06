package com.github.markozajc.ef.biconsumer.except.all;

import com.github.markozajc.ef.biconsumer.ObjShortConsumer;
import com.github.markozajc.ef.biconsumer.except.EObjShortConsumer;

/**
 * Variant of {@link ObjShortConsumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 */
@FunctionalInterface
public interface AEObjShortConsumer<T> extends EObjShortConsumer<T, Exception> {}
