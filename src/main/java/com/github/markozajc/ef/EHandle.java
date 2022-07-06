package com.github.markozajc.ef;

import java.util.function.*;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;

import javax.annotation.Nonnull;

import com.github.markozajc.ef.biconsumer.*;
import com.github.markozajc.ef.biconsumer.except.*;
import com.github.markozajc.ef.bifunction.*;
import com.github.markozajc.ef.bifunction.except.*;
import com.github.markozajc.ef.bipredicate.*;
import com.github.markozajc.ef.bipredicate.except.*;
import com.github.markozajc.ef.consumer.*;
import com.github.markozajc.ef.consumer.execpt.*;
import com.github.markozajc.ef.function.*;
import com.github.markozajc.ef.function.except.*;
import com.github.markozajc.ef.predicate.*;
import com.github.markozajc.ef.predicate.except.*;
import com.github.markozajc.ef.runnable.except.ERunnable;
import com.github.markozajc.ef.supplier.except.*;
import com.github.markozajc.ef.triconsumer.*;
import com.github.markozajc.ef.trifunction.*;
import com.github.markozajc.ef.tripredicate.*;

/**
 * A class containing various helper utilities for exceptionable (E*) functions.
 *
 * @author Marko Zajc
 */
public class EHandle {

	/*
	 * ================== Consumers ==================
	 */

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, E extends Throwable> Consumer<T> handle(@Nonnull EConsumer<T, E> handled,
															  @Nonnull BiConsumer<Throwable, T> handler) {
		return t -> {
			try {
				handled.acceptChecked(t);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, t);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <E extends Throwable> BooleanConsumer handle(@Nonnull EBooleanConsumer<E> handled,
															   @Nonnull ObjBooleanConsumer<Throwable> handler) {
		return p -> {
			try {
				handled.acceptChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <E extends Throwable> ByteConsumer handle(@Nonnull EByteConsumer<E> handled,
															@Nonnull ObjByteConsumer<Throwable> handler) {
		return p -> {
			try {
				handled.acceptChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <E extends Throwable> IntConsumer handle(@Nonnull EIntConsumer<E> handled,
														   @Nonnull ObjIntConsumer<Throwable> handler) {
		return p -> {
			try {
				handled.acceptChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <E extends Throwable> LongConsumer handle(@Nonnull ELongConsumer<E> handled,
															@Nonnull ObjLongConsumer<Throwable> handler) {
		return p -> {
			try {
				handled.acceptChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <E extends Throwable> ShortConsumer handle(@Nonnull EShortConsumer<E> handled,
															 @Nonnull ObjShortConsumer<Throwable> handler) {
		return p -> {
			try {
				handled.acceptChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, p);
			}
		};
	}

	/*
	 * ================== BiConsumers ==================
	 */

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <U>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, U, E extends Throwable> BiConsumer<T, U> handle(@Nonnull EBiConsumer<T, U, E> handled,
																	  @Nonnull TriConsumer<Throwable, T, U> handler) {
		return (t, u) -> {
			try {
				handled.acceptChecked(t, u);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, t, u);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, E extends Throwable> ObjBooleanConsumer<T> handle(@Nonnull EObjBooleanConsumer<T, E> handled,
																		@Nonnull ObjObjBooleanConsumer<Throwable, T> handler) {
		return (t, p) -> {
			try {
				handled.acceptChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, t, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, E extends Throwable> ObjByteConsumer<T> handle(@Nonnull EObjByteConsumer<T, E> handled,
																	 @Nonnull ObjObjByteConsumer<Throwable, T> handler) {
		return (t, p) -> {
			try {
				handled.acceptChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, t, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, E extends Throwable> ObjIntConsumer<T> handle(@Nonnull EObjIntConsumer<T, E> handled,
																	@Nonnull ObjObjIntConsumer<Throwable, T> handler) {
		return (t, p) -> {
			try {
				handled.acceptChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, t, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, E extends Throwable> ObjLongConsumer<T> handle(@Nonnull EObjLongConsumer<T, E> handled,
																	 @Nonnull ObjObjLongConsumer<Throwable, T> handler) {
		return (t, p) -> {
			try {
				handled.acceptChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, t, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, E extends Throwable> ObjShortConsumer<T> handle(@Nonnull EObjShortConsumer<T, E> handled,
																	  @Nonnull ObjObjShortConsumer<Throwable, T> handler) {
		return (t, p) -> {
			try {
				handled.acceptChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e, t, p);
			}
		};
	}

	/*
	 * ================== Functions ==================
	 */

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, R, E extends Throwable> Function<T, R> handle(@Nonnull EFunction<T, R, E> handled,
																	@Nonnull BiFunction<Throwable, T, R> handler) {
		return t -> {
			try {
				return handled.applyChecked(t);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, t);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <R, E extends Throwable> BooleanFunction<R> handle(@Nonnull EBooleanFunction<R, E> handled,
																	 @Nonnull ObjBooleanFunction<Throwable, R> handler) {
		return p -> {
			try {
				return handled.applyChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <R, E extends Throwable> ByteFunction<R> handle(@Nonnull EByteFunction<R, E> handled,
																  @Nonnull ObjByteFunction<Throwable, R> handler) {
		return p -> {
			try {
				return handled.applyChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <R, E extends Throwable> IntFunction<R> handle(@Nonnull EIntFunction<R, E> handled,
																 @Nonnull ObjIntFunction<Throwable, R> handler) {
		return p -> {
			try {
				return handled.applyChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <R, E extends Throwable> LongFunction<R> handle(@Nonnull ELongFunction<R, E> handled,
																  @Nonnull ObjLongFunction<Throwable, R> handler) {
		return p -> {
			try {
				return handled.applyChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <R, E extends Throwable> ShortFunction<R> handle(@Nonnull EShortFunction<R, E> handled,
																   @Nonnull ObjShortFunction<Throwable, R> handler) {
		return p -> {
			try {
				return handled.applyChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, p);
			}
		};
	}

	/*
	 * ================== BiFunctions ==================
	 */

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, U, R, E extends Throwable> BiFunction<T, U, R> handle(@Nonnull EBiFunction<T, U, R, E> handled,
																			@Nonnull TriFunction<Throwable, T, U, R> handler) {
		return (t, u) -> {
			try {
				return handled.applyChecked(t, u);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, t, u);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, R, E extends Throwable> ObjBooleanFunction<T, R> handle(@Nonnull EObjBooleanFunction<T, R, E> handled,
																			  @Nonnull ObjObjBooleanFunction<Throwable, T, R> handler) {
		return (t, p) -> {
			try {
				return handled.applyChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, t, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, R, E extends Throwable> ObjByteFunction<T, R> handle(@Nonnull EObjByteFunction<T, R, E> handled,
																		   @Nonnull ObjObjByteFunction<Throwable, T, R> handler) {
		return (t, p) -> {
			try {
				return handled.applyChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, t, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, R, E extends Throwable> ObjIntFunction<T, R> handle(@Nonnull EObjIntFunction<T, R, E> handled,
																		  @Nonnull ObjObjIntFunction<Throwable, T, R> handler) {
		return (t, p) -> {
			try {
				return handled.applyChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, t, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, R, E extends Throwable> ObjLongFunction<T, R> handle(@Nonnull EObjLongFunction<T, R, E> handled,
																		   @Nonnull ObjObjLongFunction<Throwable, T, R> handler) {
		return (t, p) -> {
			try {
				return handled.applyChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, t, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, R, E extends Throwable> ObjShortFunction<T, R> handle(@Nonnull EObjShortFunction<T, R, E> handled,
																			@Nonnull ObjObjShortFunction<Throwable, T, R> handler) {
		return (t, p) -> {
			try {
				return handled.applyChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e, t, p);
			}
		};
	}

	/*
	 * ================== Predicates ==================
	 */

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, E extends Throwable> Predicate<T> handle(@Nonnull EPredicate<T, E> handled,
															   @Nonnull BiPredicate<Throwable, T> handler) {
		return t -> {
			try {
				return handled.testChecked(t);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, t);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <E extends Throwable> BooleanPredicate handle(@Nonnull EBooleanPredicate<E> handled,
																@Nonnull ObjBooleanPredicate<Throwable> handler) {
		return p -> {
			try {
				return handled.testChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <E extends Throwable> BytePredicate handle(@Nonnull EBytePredicate<E> handled,
															 @Nonnull ObjBytePredicate<Throwable> handler) {
		return p -> {
			try {
				return handled.testChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <E extends Throwable> IntPredicate handle(@Nonnull EIntPredicate<E> handled,
															@Nonnull ObjIntPredicate<Throwable> handler) {
		return p -> {
			try {
				return handled.testChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <E extends Throwable> LongPredicate handle(@Nonnull ELongPredicate<E> handled,
															 @Nonnull ObjLongPredicate<Throwable> handler) {
		return p -> {
			try {
				return handled.testChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <E extends Throwable> ShortPredicate handle(@Nonnull EShortPredicate<E> handled,
															  @Nonnull ObjShortPredicate<Throwable> handler) {
		return p -> {
			try {
				return handled.testChecked(p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, p);
			}
		};
	}

	/*
	 * ================== BiPredicates ==================
	 */

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, U, E extends Throwable> BiPredicate<T, U> handle(@Nonnull EBiPredicate<T, U, E> handled,
																	   @Nonnull TriPredicate<Throwable, T, U> handler) {
		return (t, u) -> {
			try {
				return handled.testChecked(t, u);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, t, u);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, E extends Throwable> ObjBooleanPredicate<T> handle(@Nonnull EObjBooleanPredicate<T, E> handled,
																		 @Nonnull ObjObjBooleanPredicate<Throwable, T> handler) {
		return (t, p) -> {
			try {
				return handled.testChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, t, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, E extends Throwable> ObjBytePredicate<T> handle(@Nonnull EObjBytePredicate<T, E> handled,
																	  @Nonnull ObjObjBytePredicate<Throwable, T> handler) {
		return (t, p) -> {
			try {
				return handled.testChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, t, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, E extends Throwable> ObjIntPredicate<T> handle(@Nonnull EObjIntPredicate<T, E> handled,
																	 @Nonnull ObjObjIntPredicate<Throwable, T> handler) {
		return (t, p) -> {
			try {
				return handled.testChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, t, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, E extends Throwable> ObjLongPredicate<T> handle(@Nonnull EObjLongPredicate<T, E> handled,
																	  @Nonnull ObjObjLongPredicate<Throwable, T> handler) {
		return (t, p) -> {
			try {
				return handled.testChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, t, p);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, E extends Throwable> ObjShortPredicate<T> handle(@Nonnull EObjShortPredicate<T, E> handled,
																	   @Nonnull ObjObjShortPredicate<Throwable, T> handler) {
		return (t, p) -> {
			try {
				return handled.testChecked(t, p);
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e, t, p);
			}
		};
	}

	/*
	 * ================== Runnables ==================
	 */

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <E extends Throwable> Runnable handle(@Nonnull ERunnable<E> handled,
														@Nonnull Consumer<Throwable> handler) {
		return () -> {
			try {
				handled.runChecked();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				handler.accept(e);
			}
		};
	}

	/*
	 * ================== Suppliers ==================
	 */

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <T>
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <T, E extends Throwable> Supplier<T> handle(@Nonnull ESupplier<T, E> handled,
															  @Nonnull Function<Throwable, T> handler) {
		return () -> {
			try {
				return handled.getChecked();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.apply(e);
			}
		};
	}

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <E extends Throwable> BooleanSupplier handle(@Nonnull EBooleanSupplier<E> handled,
															   @Nonnull Predicate<Throwable> handler) {
		return () -> {
			try {
				return handled.getAsBoolean();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.test(e);
			}
		};
	}

	// missing: EByteSupplier, blocked by: ToByteFunction

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <E extends Throwable> IntSupplier handle(@Nonnull EIntSupplier<E> handled,
														   @Nonnull ToIntFunction<Throwable> handler) {
		return () -> {
			try {
				return handled.getAsInt();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.applyAsInt(e);
			}
		};
	}

	// missing: EShortSupplier, blocked by: ToShortFunction

	/**
	 * Handles any exception types that may occur in the handled function with a provided
	 * handler.
	 *
	 * @param <E>
	 *            The handled function's exception type
	 * @param handled
	 *            The function that may throw an exception
	 * @param handler
	 *            The function handling exceptions
	 *
	 * @return An exception-proofed function
	 */
	@Nonnull
	public static <E extends Throwable> LongSupplier handle(@Nonnull ELongSupplier<E> handled,
															@Nonnull ToLongFunction<Throwable> handler) {
		return () -> {
			try {
				return handled.getAsLong();
			} catch (Throwable e) { // NOSONAR can't catch generic exceptions
				return handler.applyAsLong(e);
			}
		};
	}

	private EHandle() {}

}
