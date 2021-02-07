package org.eu.zajc.functions;

import java.util.function.Supplier;

/**
 * An interface identical to {@link Supplier}, except that it allows throwing of an
 * exception.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            value
 * @param <E>
 *            exception
 */
@FunctionalInterface
public interface ExceptionableSupplier<T, E extends Throwable> {

	T get() throws E;

}
