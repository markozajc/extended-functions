package org.eu.zajc.functions;

public interface ObjObjIntFunction<T, U, R> {

	R apply(T t, U u, int value);

}
