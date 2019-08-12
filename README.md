[![Build Status](https://travis-ci.com/fulldecent/aip-xxx-implementation.svg?branch=master)](https://travis-ci.com/fulldecent/aip-xxx-implementation)

# :warning: PROJECT STATUS: Technology preview :warning:

# AIP-XXX Favorite Number — Example Implementation

This project implements AIP-XXX, the Favorite Number Standard using all best practices.

 - `aipXXXGetFavoriteNumber()`
 - `aipXXXSetFavoriteNumber()`

This project also extends by adding its own features.

 - `setFavoriteNumberOnBackwardsDay()`
 - `getOwner()`
 - `setOwner()`

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

- Style, comments
  - Oracle style guide for doc comments https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html#styleguide
    - What words to capitalize (refer examples), when to use periods and full sentences
    - ["Include tags in the following order"](https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html#orderoftags)
    - Align text to columns
  - Minimal requirements from https://github.com/aionnetwork/aion/wiki/Aion-Code-Conventions
  - Not required by Aion, but adopting method naming requirements from https://google.github.io/styleguide/javaguide.html
  - Code reuse pattern for separating an interface specification, a reference implementation, usage demonstrations, testing subjects and other tools. https://github.com/0xcert/ethereum-erc721#structure
- Which version of dependencies we should support
  - Aion supports JDK version 11 https://docs.aion.network/docs/environment-variables
  - Java versions supported by vendor https://www.oracle.com/technetwork/java/java-se-support-roadmap.html
- Aion protocol design
  - Yes, `null` can be passed in the ABI https://github.com/aionnetwork/AVM/blob/master/org.aion.avm.userlib/src/org/aion/avm/userlib/abi/ABIEncoder.java#L387-L390

- Setting up a Java + Maven + JUnit + Aion project layout
  - Best practice for Java+Maven+JUnit project layout https://github.com/junit-team/junit5-samples/tree/master/junit5-jupiter-starter-maven
  - How to remove Maven initialization errors https://stackoverflow.com/questions/4123044/maven-3-warnings-about-build-plugins-plugin-version
  - pom.xml for AVM Maven projects https://github.com/satran004/avm-samples/blob/master/SumContract-spock-sample/pom.xml
- Gitignore from https://github.com/github/gitignore/blob/master/Maven.gitignore
- Editorconfig is included and some rules are referenced to Google Java Style Guide

## License

This project is assigned copyright to Aion Foundation and released under the MIT license. Thank you to Aion Foundation for sponsoring this work!
