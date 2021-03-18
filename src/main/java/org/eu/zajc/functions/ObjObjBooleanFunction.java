package org.eu.zajc.functions;

@FunctionalInterface
public interface ObjObjBooleanFunction<T, U, R> {

	R apply(T t, U u, boolean value);

}
