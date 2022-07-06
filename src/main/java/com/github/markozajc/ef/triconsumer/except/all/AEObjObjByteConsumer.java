package com.github.markozajc.ef.triconsumer.except.all;

import com.github.markozajc.ef.triconsumer.ObjObjByteConsumer;
import com.github.markozajc.ef.triconsumer.except.EObjObjByteConsumer;

/**
 * Variant of {@link ObjObjByteConsumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 * @param <U>
 *            the type of the second argument to the operation
 */
@FunctionalInterface
public interface AEObjObjByteConsumer<T, U> extends EObjObjByteConsumer<T, U, Exception> {}
