package ciriti.dilib

import arrow.Kind
import arrow.core.Either
import arrow.core.Option
import arrow.core.Right
import arrow.core.Try
import arrow.effects.IO
import arrow.effects.fix
import arrow.effects.instances.io.monadError.monadError
import arrow.instances.`try`.functor.functor
import arrow.instances.option.functor.functor
import arrow.typeclasses.binding
import ciriti.common.printThis
import ciriti.common.threadName
import java.security.InvalidParameterException

/**
 * Created by Carmelo Iriti
 */

data class UserId(val value: String)

data class User(val userId: UserId)
data class Task(val value: String)

sealed class UserLookupError : RuntimeException() //assuming you are using exceptions
data class UserNotInLocalStorage(val user: User) : UserLookupError()
data class UserNotInRemoteStorage(val user: User) : UserLookupError()
data class UnknownError(val underlying: Throwable) : UserLookupError()

interface DataSource<F> {
  fun allTasksByUser(user: User): Kind<F, List<Task>>

}

fun main() {
  val res1: Either<UnknownError, Int> = Right(1) // Left(UnknownError(RuntimeException()))//
  val res2: Either<UnknownError, Int> = Right(2) // Left(UnknownError(RuntimeException()))//

//  res.fold(
//      { Left(UnknownError(RuntimeException("Doesn't work"))) },
//      { it }
//  ).printThis()
//  res1.getOrElse { 0 }.printThis()
//  Either.monad<UnknownError>().binding {
//    val r1 = res1.bind()
//    val r2 = res2.bind()
//    r1 + r2
//  }.printThis()

  val stringEq = String.eq()


  stringEq.run {
    "1".neqv("2")
  }.printThis()

  with(stringEq){
    "1".neqv("2")
  }.printThis()

  val optionFunctor = Option.functor()
  val tryFunctor = Try.functor()



  test(2, 2-2).printThis()

  Try { Either.left(InvalidParameterException()) }.toEither().printThis()

  IO.monadError()
      .binding {
        val a = bind {
          IO.invoke {
            threadName().printThis()
            1
          }
        }
        a + 1
      }
      .fix()
      .unsafeRunSync()
      .printThis()

  threadName().printThis()

}

fun test(a: Int, b : Int) = Try {
  a/b
  "ciao"
}.toEither()

interface Eq_<T> {
  fun T.eqv(b: T) : Boolean

  fun T.neqv(b: T) =
    !eqv(b)
}

interface StringEqInstance : Eq_<String> {
  override fun String.eqv(b: String): Boolean = this == b
}

fun String.Companion.eq() : Eq_<String> = object : StringEqInstance {}



