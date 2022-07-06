package com.github.markozajc.ef.triconsumer.except.all;

import com.github.markozajc.ef.triconsumer.ObjObjLongConsumer;
import com.github.markozajc.ef.triconsumer.except.EObjObjLongConsumer;

/**
 * Variant of {@link ObjObjLongConsumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 * @param <U>
 *            the type of the second argument to the operation
 */
@FunctionalInterface
public interface AEObjObjLongConsumer<T, U> extends EObjObjLongConsumer<T, U, Exception> {}
