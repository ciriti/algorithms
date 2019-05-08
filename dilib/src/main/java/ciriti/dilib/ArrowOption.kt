package ciriti.dilib

import arrow.core.Either
import arrow.core.Option
import arrow.core.Try
import arrow.core.identity
import arrow.core.toOption
import ciriti.common.printThis
import java.security.InvalidParameterException

/**
 * Created by Carmelo Iriti
 */

val a: Int? = 2//null
val mayBeInt: Option<Int> = Option.fromNullable(a)
val res = mayBeInt.orNull()

val b = 10
val either_net: Either<Throwable, String> = Either.right("net")
val either_net_err: Either<Throwable, String> = Either.left(RuntimeException())
val either_db: Either<Throwable, String> = Either.right("db")
val either_db_err: Either<Throwable, String> = Either.left(InvalidParameterException())
val try_ = Try { b }
val try_error: Try<Throwable> = Try.raise(RuntimeException())

val try_net: Try<String> = Try { "net" }
val try_net_err: Try<String> = Try { throw RuntimeException() }
val try_db: Try<String> = Try { "db" }
val try_db_err: Try<String> = Try { throw InvalidParameterException() }

fun <T> Option<T>.myGetOrElse(default: () -> T): Option<T> =
  fold({ default() }, ::identity).toOption()

fun main() {
//  mayBeInt.fold(
//      { 0 },
//      { it }
//  ).toOption().printThis()

//  either.getOrElse { Right(4) }

//  mayBeInt.myGetOrElse { 4 }.printThis()

//  Option.functor().addOne(mayBeInt).fix().printThis()
//  Try.functor().addOne(Try{ 1 }).fix().printThis()

  try_db_err.fold(
      { try_net },
      { it }
  )
      .printThis()

}

//fun <F> Functor<F>.addOne(fa: Kind<F, Int>): Kind<F, Int> = fa.map { it + 1 }