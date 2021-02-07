package org.eu.zajc.functions;

@FunctionalInterface
public interface ObjByteFunction<T, R> {

	R apply(T t, byte value);

}
