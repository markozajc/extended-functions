package org.eu.zajc.ef.triconsumer.except.all;

import org.eu.zajc.ef.triconsumer.ObjObjLongConsumer;
import org.eu.zajc.ef.triconsumer.except.EObjObjLongConsumer;

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
