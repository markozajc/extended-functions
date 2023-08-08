package org.eu.zajc.ef.biconsumer.except.all;

import org.eu.zajc.ef.biconsumer.ObjBooleanConsumer;
import org.eu.zajc.ef.biconsumer.except.EObjBooleanConsumer;

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
