package arrow

/**
 * Created by Carmelo Iriti
 */

interface Tipo<out F, out A>
class CarmForTry private constructor() { companion object }

typealias CTryOf<A> = Tipo<CarmForTry, A>

sealed class CarmeloTry<out A> : CTryOf<A> {

  inline operator fun<A> invoke(f: () -> A): CarmeloTry<A> {
    return try {
          Success(f())
        } catch (e: Throwable) {
          Failure(e)
        }
  }

  data class Success<A>(val value: A) : CarmeloTry<A>()
  data class Failure(val exception: Throwable) : CarmeloTry<Nothing>()
}

@Suppress("NOTHING_TO_INLINE")
inline fun<A> CTryOf<A>.fix() : CarmeloTry<A> = this as CarmeloTry<A>
