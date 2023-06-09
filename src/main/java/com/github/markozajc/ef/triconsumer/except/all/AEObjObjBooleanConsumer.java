package com.github.markozajc.ef.triconsumer.except.all;

import com.github.markozajc.ef.triconsumer.ObjObjBooleanConsumer;
import com.github.markozajc.ef.triconsumer.except.EObjObjBooleanConsumer;

/**
 * Variant of {@link ObjObjBooleanConsumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 * @param <U>
 *            the type of the second argument to the operation
 */
@FunctionalInterface
public interface AEObjObjBooleanConsumer<T, U> extends EObjObjBooleanConsumer<T, U, Exception> {}
