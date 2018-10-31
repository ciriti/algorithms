### Collections

These are the [most important collections](https://docs.google.com/document/d/1DwLCwYmGjuIbY54IVt6RbrOgemlJ6Px6NWgQwqECOnM/edit?usp=sharing).

### SOLID
- Single Responsibility Principle
- Open/Closed Principle
- Liskov Substitution Principle
- Interface Segregation Principle
- Dependency Inversion

### ObserverOn vs subscribeOn

**SubscribeOn** specifies the Scheduler on which an Observable will execute its create method

**ObserveOn** specifies the Scheduler on which an observer will consume the items emitted by the Observable.

### RxJava Subjects Vs Processors

**PublishProcessor** is subclassed from Flowables so you can use a
BackPressure Strategy when you make use of them.

**PublishSubject**'s superclass is Observable so at very least there is
no BackPressure Strategy.

### Backpressure (2.0) - Subject and flowable

Backpressuring is simply the process of handling a fast item producer.

The **Observable** class has an **unbounded buffer size**, it means it
will buffer everything and pushes it to the subscriber,
that’s where you get the OutOfMemoryException.

In RxJava, the dedicated **Flowable** class is designated to **support
backpressure** and Observable is dedicated for the non-backpressured
operations (short sequences, GUI interactions, etc.).

The other types, Single, Maybe and Completable don't support backpressure
nor should they; there is always room to store one item temporarily.

### Difference between module and component in Dagger2

**Module**: is it the object in charge to provide the object to be injected

**Component**: it is the bridge between module and the consumer (Activity or fragment)

Inside Activity/Fragment we can get these dependencies by defining *@Inject*
annotation

### Design pattern

**Creational patterns**

1. Singleton
2. Abstract factory
3. Method factory
4. Builder

**Structural patterns**

1. Decorator
2. Facade
3. Adapter

**Behavioral patterns**

1. Command
2. Strategy
3. Template
