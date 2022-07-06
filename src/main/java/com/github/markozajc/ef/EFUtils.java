package com.github.markozajc.ef;

import java.util.function.*;

import javax.annotation.Nonnull;

import com.github.markozajc.ef.bifunction.*;
import com.github.markozajc.ef.bifunction.except.*;
import com.github.markozajc.ef.consumer.TriConsumer;
import com.github.markozajc.ef.consumer.execp.*;
import com.github.markozajc.ef.function.*;
import com.github.markozajc.ef.function.except.*;
import com.github.markozajc.ef.predicate.TriPredicate;
import com.github.markozajc.ef.predicate.except.*;
import com.github.markozajc.ef.runnable.except.ERunnable;
import com.github.markozajc.ef.supplier.except.*;
import com.github.markozajc.ef.trifunction.*;

/**
 * A class containing various helper utilities for extended-functions.
 *
 * @author Marko Zajc
 */
public class EFUtils {

	/*
	 * Consumers
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

	/*
	 * Functions
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
	 * BiFunctions
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
	 * Predicates
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

	/*
	 * Runnables
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
	 * Suppliers
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

	/**
	 * Rethrows a checked exception as unchecked using generics trickery (the exception
	 * is not changed or wrapped in a {@link RuntimeException} - it is thrown as-is).
	 *
	 * @param <X>
	 *            the exception type
	 * @param ex
	 *            the exception to throw as unchecked
	 *
	 * @return the exception itself to support {@code throws asUnchecked(e);}. Note that
	 *         it is thrown in this method and nothing is ever returned
	 *
	 * @throws X
	 *             the exception you provide. Always thrown.
	 */
	@SuppressWarnings("unchecked")
	public static <X extends Throwable> RuntimeException asUnchecked(@Nonnull Throwable ex) throws X {
		throw (X) ex;
	}

	private EFUtils() {}

}
