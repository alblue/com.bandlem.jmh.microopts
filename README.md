MicroOpts
=========

Demonstration of JMH and micro-optimisations that can be used on a simple
routine. but which can save a small amount of time.

Reproduction
------------

To run the tests, use Maven to build the `benchmarks.jar` file, and execute it
with the JMH test runner:

```sh
$ mvn package
$ java -jar target/benchmarks.jar -bm avgt -tu ns
```

