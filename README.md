# Description

This bug is triggered (AFAIK) only when running surefire together with toolchains plugin.

So set it up first so that Java 25 is picked up from there:

> ~/.m2/toolchains.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<toolchains xmlns="http://maven.apache.org/TOOLCHAINS/1.1.0"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/TOOLCHAINS/1.1.0 http://maven.apache.org/xsd/toolchains-1.1.0.xsd">
  <toolchain>
    <type>jdk</type>
    <provides>
      <version>25</version>
    </provides>
    <configuration>
      <jdkHome>the path to java 25</jdkHome>
    </configuration>
  </toolchain>
</toolchains>
```

Then make sure that you're running a _different version_ of java in your terminal. In my case I used Java 21, but I don't think it matters.

> java --version  
openjdk 21.0.3 2024-04-16 LTS  
OpenJDK Runtime Environment Temurin-21.0.3+9 (build 21.0.3+9-LTS)  
OpenJDK 64-Bit Server VM Temurin-21.0.3+9 (build 21.0.3+9-LTS, mixed mode)

Finally, try to run the build:

```shell
./mvnw test
```

You'll get this error:

> [ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.5.6:test (default-test) on project module-a: Execution default-test of goal org.apache.maven.plugins:maven-surefire-plugin:3.5.6:test failed: java.lang.UnsupportedClassVersionError: com/example/a/ServiceATest has been compiled by a more recent version of the Java Runtime (class file version 69.0), this version of the Java Runtime only recognizes class file versions up to 65.0 -> [Help 1]

To fix it:

```shell
./mvnw test -Pmake-it-work
```

So it seems that when you use the fork settings of the surefire plugin, the JVM is launched with the version avaialble in the terminal as opposed to the version set by the toolchains plugin.