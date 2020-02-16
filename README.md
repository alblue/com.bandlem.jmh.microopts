MicroOpts
=========

Demonstration of JMH and micro-optimisations that can be used on a simple
routine. but which can save a small amount of time.

For the write-up, see https://alblue.bandlem.com/2020/02/16/class-getname.html

Reproduction
------------

To run the tests, use Maven to build the `benchmarks.jar` file, and execute it
with the JMH test runner:

```sh
$ mvn package
$ java -jar target/benchmarks.jar -bm avgt -tu ns
```

Numbers in [JMH-NameTest.txt] were generated on a 2011 MacBook Pro with a 2.3 GHz Core i7 with 8Gb of memory.
