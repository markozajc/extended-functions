package org.eu.zajc.functions;

import java.util.function.Function;

/**
 * An interface identical to {@link Function}, except that it allows throwing of an
 * exception.
 *
 * @author Marko Zajc
 * 
 * @param <I>
 *            input
 * @param <T>
 *            value
 * @param <E>
 *            exception
 */
@FunctionalInterface
public interface ExceptionableFunction<I, T, E extends Throwable> {

	T apply(I value) throws E;

}
