[![Build Status](https://travis-ci.com/fulldecent/aip-xxx-implementation.svg?branch=master)](https://travis-ci.com/fulldecent/aip-xxx-implementation)

# :warning: PROJECT STATUS: Technology preview :warning:

# AIP-XXX Favorite Number — Example Implementation

This project implements AIP-XXX, the Favorite Number Standard using all best practices.

 - `aipXXXGetFavoriteString()`
 - `aipXXXSetFavoriteString(String newFavoriteString)`

This project also extends by adding its own features.

 - `aipXXXGetOwner()`
 - `aipXXXSetOwner()`
 - `aipXXXAcceptOwnership()`

## Prerequisites

1. Supported operating systems are macOS, Linux and Windows
2. Install Java (version 11 or later) and Apache Maven
   - On macOS
     1. [Do not use](https://stackoverflow.com/a/28635465/300224) the official installer from Oracle, that approach is painful, nobody uses it
     2. [Install Homebrew](https://brew.sh)
     3. `brew cask install java`
     4. `brew install maven`

## Building and testing

Prepare your Maven project build state

```sh
./mvnw initialize
```

Build and test

```sh
./mvnw clean install verify
```

A build which passes all tests will be indicated by:

> [INFO] BUILD SUCCESS

at the bottom of your build.

After you have made any changes, run the build and test command above.

## Project scope

- A simple standard (interface)
- A simple implementation
- A simple dapp web front-end in vanilla JavaScript + Bootstrap CSS

## References

- Best practice for Java+Maven+JUnit project layout https://github.com/junit-team/junit5-samples/tree/master/junit5-jupiter-starter-maven

- Java versions supported by vendor https://www.oracle.com/technetwork/java/java-se-support-roadmap.html

- How to remove Maven initialization errors https://stackoverflow.com/questions/4123044/maven-3-warnings-about-build-plugins-plugin-version

- Code style shall follow [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) as specified in [Aion Code Conventions](https://github.com/aionnetwork/aion/wiki/Aion-Code-Conventions)

- Gitignore from https://github.com/github/gitignore/blob/master/Maven.gitignore

- Editorconfig is included and individual rules are referenced to Google Java Style Guide

- 1. Periodically update to the most recent version, to obtain the latest bug fixes and new features:

     ```
       mvn versions:use-latest-versions -Dincludes="org.checkerframework:*"
     ```

## License

This project is assigned copyright to Aion Foundation and released under the MIT license. Thank you to Aion Foundation for sponsoring this work!
