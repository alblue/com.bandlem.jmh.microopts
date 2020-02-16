// Copyright (c) 2020 Alex Blewitt
//
// Released under the MIT License SPDX:MIT
// See LICENSE.txt for more information

package com.bandlem.jmh.microopts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openjdk.jmh.annotations.Benchmark;

public class NameTest {

	public static void main(String args[]) {
			int limit = 10000;
			String[] strings = new String[limit];
			NameTest test = new NameTest();
			for(int i=0;i<limit;i++) {
					strings[i] = test.getNameOriginal();
			}
			System.out.println(Arrays.asList(strings).hashCode());
	}

	@Benchmark
	public String getNameOriginal() {
		String name = getClass().getName();
		int i = name.lastIndexOf(".");
		if (i != -1) {
			name = name.substring(i + 1);
		}
		return name;
	}

	@Benchmark
	public String getNameOriginalChar() {
		String name = getClass().getName();
		int i = name.lastIndexOf('.');
		if (i != -1) {
			name = name.substring(i + 1);
		}
		return name;
	}

	@Benchmark
	public String getNameString() {
		String name = getClass().getName();
		return name.substring(name.lastIndexOf(".") + 1);
	}

	@Benchmark
	public String getNameChar() {
		String name = getClass().getName();
		return name.substring(name.lastIndexOf('.') + 1);
	}

	@Benchmark
	public String getNameClassValueCache() {
		return ClassName.DEFAULT.get(getClass());
	}

	@Benchmark
	public String getNameMapCache() {
		return ClassMap.get(getClass());
	}

}

class ClassMap {
	private static final Map<Class<?>, String> map = new HashMap<Class<?>, String>();

	public static String get(Class<?> clazz) {
		return map.computeIfAbsent(clazz, ClassMap::calculateShortName);
	}

	private static String calculateShortName(Class<?> clazz) {
		String name = clazz.getName();
		return name.substring(name.lastIndexOf('.') + 1);
	}
}

class ClassName extends ClassValue<String> {
	public static final ClassValue<String> DEFAULT = new ClassName();

	@Override
	protected String computeValue(Class<?> clazz) {
		String name = clazz.getName();
		return name.substring(name.lastIndexOf('.') + 1);
	}
}
