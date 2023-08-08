package org.eu.zajc.ef.biconsumer.except.all;

import org.eu.zajc.ef.biconsumer.ObjByteConsumer;
import org.eu.zajc.ef.biconsumer.except.EObjByteConsumer;

/**
 * Variant of {@link ObjByteConsumer} capable of throwing an {@link Exception}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 */
@FunctionalInterface
public interface AEObjByteConsumer<T> extends EObjByteConsumer<T, Exception> {}
