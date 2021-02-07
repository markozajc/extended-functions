package org.eu.zajc.functions;

import java.util.function.Function;

/**
 * An interface identical to {@link Function}, except that it allows throwing of an
 * exception.
 *
 * @author Marko Zajc
 */
@FunctionalInterface
public interface ExceptionableFunction<T, R, E extends Throwable> {

	R apply(T value) throws E;

}
