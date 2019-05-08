package ciriti.dilib

import ciriti.dilib.ghexample.InjectModule
import ciriti.dilib.ghexample.Prototype
import ciriti.dilib.ghexample.Scoped
import ciriti.dilib.ghexample.Singleton

/**
 * Created by Carmelo Iriti
 */
@DslMarker
annotation class InjectionDsl

@InjectionDsl
inline fun module(block: InjectModule.() -> Unit) = InjectModule().apply(block)

@InjectionDsl
inline fun <reified T : Any> InjectModule.factory(noinline generator: () -> T) {
  val className = T::class.qualifiedName
      ?: throw IllegalArgumentException("A non-real class cannot be injected")
  generators[className] = Prototype(generator)
}

@InjectionDsl
inline fun <reified T : Any> InjectModule.singleton(noinline generator: () -> T) {
  val className = T::class.qualifiedName
      ?: throw IllegalArgumentException("A non-real class cannot be injected")
  generators[className] = Singleton(className, generator)
}

@InjectionDsl
inline fun <reified T : Any> InjectModule.scoped(noinline generator: () -> T) {
  val className = T::class.qualifiedName
      ?: throw IllegalArgumentException("A non-real class cannot be injected")
  generators[className] = Scoped(generator)
}

@InjectionDsl
inline fun InjectModule.dependsOn(vararg modules: InjectModule) {
  dependsOn.addAll(modules)
}