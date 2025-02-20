# JfrUnit - A JUnit extension for asserting JDK Flight Recorder events

_Unit testing, for performance_

JfrUnit allows to assert the [JDK Flight Recorder](https://openjdk.java.net/jeps/328) (JFR) events emitted by an application.

## Why JfrUnit?

While unit testing of functional requirements is a standard practice, identifying performance regressions (e.g. increased latencies, reduced throughput) through automated tests is much harder: e.g. assertions on specific request runtimes are prone to failures in virtualized/containerized CI environments due to concurrent load of other jobs.

JfrUnit offers a fresh angle to this topic by supporting assertions not on metrics like latency/throughput themselves, but on indirect metrics which may impact those.
Based on JDK Flight Recorder events, JfrUnit allows you execute assertions e.g. against memory allocation, database IO, and number of executed SQL statements, for a defined workload.
Starting off from a defined base line, future failures of such assertions are indicators for potential performance regressions in an application, as a code change may have introduced higher GC pressure, the retrieval of unneccessary data from the database, or common SQL problems like N+1 SELECT statements.

JfrUnit provide means of identifying and analysizing such issues in a reliable, environment independent way in standard JUnit tests,
before they manifest as performance regressions in production.

### Learning More

Here are some resources which describe JfrUnit and its approach to performance regression testing:

* [Towards Continuous Performance Regression Testing](https://www.morling.dev/blog/towards-continuous-performance-regression-testing/)
* [Introducing JfrUnit 1.0.0.Alpha1](https://www.morling.dev/blog/introducing-jfrunit-1-0-0-alpha1/)
* [Asserting JDK Flight Recorder Events with JfrUnit](https://www.infoq.com/news/2021/09/jfrunit-flight-recorder-events/)
* [Continuous Performance Regression Testing with JfrUnit](https://www.p99conf.io/session/continuous-performance-regression-testing-with-jfrunit/)
* [Keep Your SQL in Check With Flight Recorder, JMC Agent and JfrUnit](https://www.javaadvent.com/2021/12/keep-your-sql-in-check-with-flight-recorder-jmc-agent-and-jfrunit.html)

## Usage

This project requires OpenJDK 16 or later at runtime.
Support for JDK 11 is on the roadmap, JfrUnit couldn't rely on JFR event stream in this case though, but would have to read JFR events from a recording persisted to disk.
A PR contributing this change would be very welcomed.

JfrUnit is available from Maven Central;
add the following dependency to your project's _pom.xml_:

```xml
...
<dependency>
  <groupId>org.moditect.jfrunit</groupId>
  <artifactId>jfrunit</artifactId>
  <version>1.0.0.Alpha1</version>
  <scope>test</scope>
</dependency>
...
```

Alternatively, you can build JfrUnit from source (see below) yourself, so to pull in changes done after the latest release.

Then you can implement tests expecting specific JFR events like so:

```java
import org.moditect.jfrunit.*;

import static org.moditect.jfrunit.JfrEventsAssert.*;
import static org.moditect.jfrunit.ExpectedEvent.*;
import org.moditect.jfrunit.events.JfrEventTypes;

@JfrEventTest
public class JfrTest {

    public JfrEvents jfrEvents = new JfrEvents();

    @Test
    @EnableEvent(GarbageCollection.EVENT_NAME)
    @EnableEvent(ThreadSleep.EVENT_NAME)
    public void shouldHaveGcAndSleepEvents() throws Exception {
        System.gc();
        Thread.sleep(1000);

        jfrEvents.awaitEvents();

        assertThat(jfrEvents).contains(JfrEventTypes.GARBAGE_COLLECTION);
        assertThat(jfrEvents).contains(
                JfrEventTypes.THREAD_SLEEP.withTime(Duration.ofMillis(50)));
    }
}
```

Note that when you're writing a test for a Quarkus application using the `@QuarkusTest` annotation, you don't need (and even should not) add the `@JfrEventTest` annotation.
Instead, the Quarkus test framework will automatically pick up the required callbacks for managing the JFR recording.

The `@EnableEvent` annotation is used to enable one or more JFR event types which should be captured.
The "*" character can be used as a wildcard character to match multiple types:

```java
@Test
@EnableEvent("jdk.GC*")
@EnableEvent("jdk.G1*")
public void someTest() throws Exception { ... }
```

This would capture events like `jdk.GCHeapSummary`, `jdk.GCPhasePause`, `jdk.G1GarbageCollection` etc.
A complete list of all built-in JFR event types can be found [here](https://bestsolution-at.github.io/jfr-doc/).

Alternatively, you can specify the name of a JFR configuration file, e.g. "default" or "profile", using the `@EnableConfiguration` annotation:

```java
@Test
@EnableConfiguration("default")
public void someTest() throws Exception { ... }
```

JFR configuration files are located in the _$JAVA_HOME/bin/jfr_ directory.

### Using Spock Framework

You can also write JfrUnit tests using the [Spock Framework](https://spockframework.org/) like this:

```groovy
import org.moditect.jfrunit.JfrEvents
import spock.lang.Specification

import java.time.Duration

class JfrSpec extends Specification {

    JfrEvents jfrEvents = new JfrEvents()

    @EnableEvent('jdk.GarbageCollection')
    @EnableEvent('jdk.ThreadSleep')
    def 'should Have GC And Sleep Events'() {
        when:
        System.gc()
        sleep(1000)

        then:
        jfrEvents['jdk.GarbageCollection']
        jfrEvents['jdk.ThreadSleep'].withTime(Duration.ofMillis(1000))
    }
}
```

As you can see you can use custom DSL when checking the expected state.
 * `JfrEvents['event.name']` or `JfrEvents.list('event.name')` gives you a list containing all the events of the requested type.
 * Beyond just list methods as usual you may further narrow it down by using `with`, `having` and `notHaving` dynamic methods
   (returning list as well). For example:
     * `withTime(Duration.ofMillis(1000))`
     * `withCause('System.gc()')`
     * `withObjectClass(byte[].class)`
     * `withEventThread(Thread.currentThread())`
     * `havingStackTrace()`
     * `notHavingStackTrace()`
     * `containStackFrame(stackTraceElement)`
     * ...
 * The `RecordedEvent` itself is extended with dynamic properties so you can just use `event.time` or `event.bytesWritten` etc.
   This might be handy when you need an aggregation like this `jfrEvents['jdk.FileWrite']*.bytesWritten.sum() == expectedBytes`

## Build

This project requires OpenJDK 16 or later for its build.
Apache Maven is used for the build.
Run the following to build the project:

```shell
mvn verify
```

Run the following to install the JARs to the local Maven repository:

```shell
mvn install
```

## License

This code base is available under the Apache License, version 2.
