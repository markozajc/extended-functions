package org.eu.zajc.ef.biconsumer.except.all;

import java.util.function.ObjIntConsumer;

import org.eu.zajc.ef.biconsumer.except.EObjIntConsumer;

/**
 * Variant of {@link ObjIntConsumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 */
@FunctionalInterface
public interface AEObjIntConsumer<T> extends EObjIntConsumer<T, Exception> {}
