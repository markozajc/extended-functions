package com.github.markozajc.ef.triconsumer.except.all;

import com.github.markozajc.ef.triconsumer.ObjObjShortConsumer;
import com.github.markozajc.ef.triconsumer.except.EObjObjShortConsumer;

/**
 * Variant of {@link ObjObjShortConsumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 * @param <U>
 *            the type of the second argument to the operation
 */
@FunctionalInterface
public interface AEObjObjShortConsumer<T, U> extends EObjObjShortConsumer<T, U, Exception> {}
