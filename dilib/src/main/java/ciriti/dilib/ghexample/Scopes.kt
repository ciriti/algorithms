package ciriti.dilib.ghexample

/**
 * Created by Carmelo Iriti
 */

interface Singletonable

class SingletonInjectable : Singletonable

class ScopedInjectable

class FactoryInjectable

class DependingInjectable(
  private val scopedInjectable: ScopedInjectable,
  private val singletonInjectable: Singletonable
) {

  override fun toString(): String = """${super.toString()}
    scoped: $scopedInjectable
    singleton: $singletonInjectable"""
}