package com.github.markozajc.ef.triconsumer.except.all;

import com.github.markozajc.ef.triconsumer.ObjObjIntConsumer;
import com.github.markozajc.ef.triconsumer.except.EObjObjIntConsumer;

/**
 * Variant of {@link ObjObjIntConsumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 * @param <U>
 *            the type of the second argument to the operation
 */
@FunctionalInterface
public interface AEObjObjIntConsumer<T, U> extends EObjObjIntConsumer<T, U, Exception> {}
