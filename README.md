MicroOpts
=========

Demonstration of JMH and micro-optimisations that can be used on a simple
routine. but which can save a small amount of time.

For the write-up, see http://alblue.bandlem.com/2020/02/class-getname.html

There is an older write-up at
https://alblue.bandlem.com/2016/04/jmh-stringbuffer-stringbuilder.html which
was written prior to the indification of `StringBuilder`, and the performance may
differ from the original write-up. Results are included below.

Reproduction
------------

To run the tests, use Maven to build the `benchmarks.jar` file, and execute it
with the JMH test runner:

```sh
$ mvn package
$ java -jar target/benchmarks.jar -bm avgt -tu ns -prof gc
```

Numbers in [JMH-NameTest](JMH-NameTest.txt) and [JMH-StringBuilderBenchmark](JMH-StringBuilderBenchmarktxt) were generated on a 2011 MacBook Pro with a 2.3 GHz Core i7 with 8Gb of memory.

