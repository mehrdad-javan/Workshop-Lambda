# Functional Interfaces Cheat Sheet
Functional interfaces are a fundamental concept in Java's functional programming paradigm.  
They have a single abstract method and can be used as the basis for lambda expressions and method references.
Functional interfaces are commonly used with lambda expressions to create concise and readable code.  

## Definition
A functional interface is an interface with a single abstract method (SAM).  
It's annotated with the `@FunctionalInterface` annotation, which is optional but recommended for clarity.  

Example:
```java
@FunctionalInterface
interface MyFunctionalInterface {
    void myMethod();
}
```

# Common Functional Interfaces
- **Consumer<T>**
  - Purpose: Consumes an input of type T and performs an action without returning a result.
  - Use Case: Iterating and performing actions on elements of a collection.

- **Function<T, R>**
  - Purpose: Transforms an input of type T into an output of type R.
  - Use Case: Mapping or transforming elements of a collection.

- **Predicate<T>**
  - Purpose: Tests a condition on an input of type T and returns a boolean.
  - Use Case: Filtering elements based on a condition.

- **Supplier<T>**
  - Purpose: Supplies or generates a value of type T.
  - Use Case: Lazy initialization and generation of values.

- **BiConsumer<T, U>**
  - Purpose: Consumes two inputs of types T and U and performs an action without returning a result.
  - Use Case: Working with pairs of elements or key-value pairs.

- **BiFunction<T, U, R>**
  - Purpose: Transforms two inputs of types T and U into an output of type R.
  - Use Case: Combining or merging two values into a result.

- UnaryOperator<T>
  - Purpose: Represents an operation on a single input of type T that produces a result of type T.
  - Use Case: When you want to apply an operation to an input of the same type.

- **BinaryOperator<T>**
  - Purpose: Represents an operation on two inputs of type T that produces a result of type T.
  - Use Case: When you want to apply an operation to two inputs of the same type.

> ###### Why to use Functional Interfaces and lambda
> - Using pre-made functional interfaces and lambda expressions in Java offers several benefits, making your code more concise, expressive, and maintainable.
>
>1. Code Conciseness  
>2. Improved Readability  
>3. Code Re-usability  
>4. Functional-Style Programming  
>5. Improved Testing  
>6. Better Error Handling  
>7. Declarative Code  
>...