// Copyright (c) 2020 Alex Blewitt
//
// Released under the MIT License SPDX:MIT
// See LICENSE.txt for more information

package com.bandlem.jmh.microopts;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
//import org.openjdk.jmh.annotations.CompilerControl;
//import org.openjdk.jmh.annotations.CompilerControl.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class StringBuilderBenchmark {
	private String from = "Alex";
	private String to = "Readers";
	private String subject = "Benchmarking with JMH";

	@Param({"16"})
	private int size;
	
	@Benchmark
	public String testEmptyBuffer() {
		StringBuffer buffer = new StringBuffer();
		return buffer.toString();
	}

	@Benchmark
	public String testEmptyBuilder() {
		StringBuilder builder = new StringBuilder();
		return builder.toString();
	}

	@Benchmark
	public String testEmptyLiteral() {
		return "";
	}

	@Benchmark
	public String testHelloWorldBuilder() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hello");
		builder.append("World");
		return builder.toString();
	}

	@Benchmark
	public String testHelloWorldBuffer() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Hello");
		buffer.append("World");
		return buffer.toString();
	}

	@Benchmark
	public String testEmailBuilderSimple() {
		StringBuilder builder = new StringBuilder(size);
		builder.append("From");
		builder.append(from);
		builder.append("To");
		builder.append(to);
		builder.append("Subject");
		builder.append(subject);
		return builder.toString();

	}

	@Benchmark
	public String testEmailBufferSimple() {
		StringBuffer buffer = new StringBuffer(size);
		buffer.append("From");
		buffer.append(from);
		buffer.append("To");
		buffer.append(to);
		buffer.append("Subject");
		buffer.append(subject);
		return buffer.toString();
	}

	@Benchmark
	public String testEmailBuilderConcat() {
		StringBuilder builder = new StringBuilder(size);
		builder.append("From" + from);
		builder.append("To" + to);
		builder.append("Subject" + subject);
		return builder.toString();
	}

	@Benchmark
	public String testEmailBufferConcat() {
		StringBuffer buffer = new StringBuffer(size);
		buffer.append("From" + from);
		buffer.append("To" + to);
		buffer.append("Subject" + subject);
		return buffer.toString();
	}

	@Benchmark
	public String testEmailBuilderChain() {
		return new StringBuilder(size).append("From").append(from).append("To").append(to).append("Subject")
				.append(subject).toString();
	}

	@Benchmark
	public String testEmailBufferChain() {
		return new StringBuffer(size).append("From").append(from).append("To").append(to).append("Subject")
				.append(subject).toString();
	}

	@Benchmark
	public String testEmailLiteral() {
		return "From" + from + "To" + to + "Subject" + subject;
	}

}