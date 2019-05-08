package ciriti.dilib.scopecontrol

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Created by Carmelo Iriti
 */

fun main(){
  val e = Example()

  val lazyValue: String by lazy {
    println("computed!")
    "Hello"
  }
}

class User {
  var name: String by Delegates.observable("<no name>") {
    prop, old, new ->
    println("$old -> $new")
  }
}

class Example {
  var p: String by Delegate()
}

class Delegate {
  operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
    return "$thisRef, thank you for delegating '${property.name}' to me!"
  }

  operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
    println("$value has been assigned to '${property.name}' in $thisRef.")
  }
}