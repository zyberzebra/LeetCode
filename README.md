## LeetCode Challenges

This repository contains solutions for LeetCode challenges along with unit tests.

### Dependencies

**Note**: This project requires Java 21 and includes support for Kotlin.

The project uses Maven to manage dependencies. The following table lists the key dependencies:

| Library                                           | Version | Purpose                                      |
|---------------------------------------------------|---------|----------------------------------------------|
| org.projectlombok:lombok                          | 1.18.34 | Simplifying Java classes                     |
| org.junit.jupiter:junit-jupiter                   | 5.11.0  | Unit testing for Java and Kotlin             |
| org.assertj:assertj-core                          | 3.26.3  | Fluent assertions for better test cases      |
| org.apache.maven.plugins:maven-compiler-plugin    | 3.13.0  | Compiling Java source code                   |
| org.apache.maven.plugins:maven-surefire-plugin    | 3.4.0   | Running unit tests                           |
| org.jetbrains.kotlin:kotlin-stdlib-jdk8           | 2.0.10  | Kotlin standard library for JDK 8            |
| org.jetbrains.kotlin:kotlin-test                  | 2.0.10  | Kotlin test library for writing unit tests   |

### Building and Running Tests

To compile the project, including both Java and Kotlin code, use the following Maven command:

```bash
mvn compile
```

To execute the unit tests, you can use the following Maven command:

```bash
mvn compile
```