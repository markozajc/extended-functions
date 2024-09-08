> [!WARNING]
> **Relocation notice for 1.4.2 and above:**\
> extended-functions's artifact has relocated from `com.github.markozajc:extended-functions` to
> `org.eu.zajc:extended-functions`. Additionally, the same change has been made on the base package name. You will need
> to change extended-functions's dependency's `groupId` in your pom.xml or build.gradle (as shown in the installation
> section) and you will need to replace `com.github.markozajc.ef` with `org.eu.zajc.ef` in your imports.

# extended-functions

A small project providing extensions and additions to Java 8's built-in functions.

## Installation

Add the following to your pom.xml's dependencies:
    
```xml
<dependencies>
    ...
    <dependency>
        <groupId>org.eu.zajc</groupId>
        <artifactId>extended-functions</artifactId>
        <version>1.5</version>
    </dependency>
    ...
</dependencies>
```

or your build.gradle:

```groovy
repositories {
    ...
    mavenCentral()
    ...
}

dependencies {
    ...
    api 'org.eu.zajc:extended-functions:1.5'
    ...
}
```
    
## Usage

Some of this project's additions do not extend Java 8's built-in functions and can therefore not be used directly with Java's APIs. However, those that do (specifically certain E\* and AE\* ones) can be through casting. For example, one can use:

```java
files.forEach((EConsumer<Path, IOException>) Files::delete);
```

or with the catch-all-exceptions AE\* type:

```java
files.forEach((AEConsumer<Path>) Files::delete);
```

rather than the vanilla way of doing it:

```java
files.forEach(t -> {
    try {
        Files.delete(t);
    } catch (IOException e) {
        // the error handling logic
    }
});
```

Note, however, that checked exceptions are _not_ wrapped into RuntimeException - they are instead rethrown directly using a generics hack (see com.github.markozajc.functions.exceptionable.Utilities). This unfortunately also means that they can't be caught directly, because javac will complain that `exception XYZException is never thrown in body of corresponding try statement`. You can get around that by declaring `throws` on the method itself, or by catching `Exception` and then running your handling logic based on `instanceof`.

---

It's also possible to handle exceptions in-line with `EHandle`:

```java
files.forEach(EHandle.handle(Files::delete, (f, t) -> {
    // error handling logic
}));
```

or by rethrowing a different exception

```java
files.forEach(EHandle.handleThrowing(Files::delete, RuntimeException::new));
```
