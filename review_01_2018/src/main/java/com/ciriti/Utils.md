```
val array = Array<Int>(0){ 0
val array1 = arrayOf<Int>()
fun intArrayOf(vararg elements: Int): IntArray
fun <K, V> linkedMapOf(vararg pairs: Pair<K, V>): LinkedHashMap<K, V>
inline fun <K, V> linkedMapOf(): LinkedHashMap<K, V>
fun <K, V> hashMapOf(vararg pairs: Pair<K, V>): HashMap<K, V>
inline fun <K, V> hashMapOf(): HashMap<K, V>
fun <K, V> mutableMapOf(vararg pairs: Pair<K, V>): MutableMap<K, V>
inline fun <K, V> mutableMapOf(): MutableMap<K, V> = LinkedHashMap()
inline fun <T> linkedSetOf(): LinkedHashSet<T> = LinkedHashSet()
fun <T> hashSetOf(vararg elements: T): HashSet<T>
fun <T> mutableSetOf(vararg elements: T): MutableSet<T>
inline fun <T> mutableSetOf(): MutableSet<T>
inline fun <T> setOf(): Set<T>

inline fun <R> run(block: () -> R): R
inline fun <T, R> with(receiver: T, block: T.() -> R): R
* Calls the specified function [block] with `this` value as its receiver and returns `this` value.
inline fun <T> T.apply(block: T.() -> Unit): T
// Calls the specified function [block] with `this` value as its argument and returns its result.
inline fun <T, R> T.let(block: (T) -> R): R
Calls the specified function [block] and returns its result.
 ```