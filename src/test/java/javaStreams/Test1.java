package javaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {

	int count = 0;

	@Test
	public void regular() {
		ArrayList<String> arrayList = new ArrayList<>();

		arrayList.add("mohamed");
		arrayList.add("hamdy");
		arrayList.add("eissa");
		arrayList.add("hrrrrr");
		arrayList.add("hwwwwww");

		for (int i = 0; i < arrayList.size(); ++i) {

			String name = arrayList.get(i);
			if (name.startsWith("h")) {
				++count;
			}
		}

		System.out.println(count);
	}

	@Test
	public void streamFilter() {

		ArrayList<String> arrayList = new ArrayList<>();

		arrayList.add("mohamed");
		arrayList.add("hamdy");
		arrayList.add("eissa");
		arrayList.add("hr");
		arrayList.add("hww");

		long c = arrayList.stream().filter(s -> s.startsWith("h")).count();
		System.out.println(c);

		long d = Stream.of("mohamed", "hamdy", "eissa", "hrr", "hww").filter(s -> s.startsWith("h")).count();

		System.out.println(d);

		arrayList.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		arrayList.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));

	}

	@Test
	public void streamMap() {

		ArrayList<String> arrayList = new ArrayList<>();

		arrayList.add("main");
		arrayList.add("hr");
		arrayList.add("hww");
		Stream.of("mohamed", "hamdy", "eissa", "hrr", "hww", "Rama").filter(s -> s.endsWith("a"))
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

		List<String> names = Arrays.asList("mohamed", "hamdy", "eissa", "arr", "aaw", "Rama");
		names.stream().filter(s -> s.startsWith("a")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		Stream<String> newStream = Stream.concat(arrayList.stream(), names.stream());
		// newStream.sorted().forEach(s -> System.out.println(s));

		boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("eissa"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}

	@Test
	public void streamCollect() {
		List<String> ls = Stream.of("mohamed", "hamdy", "eissa", "hra", "hwa", "aama").filter(s -> s.endsWith("a"))
				.map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));

		List<Integer> numbers = Arrays.asList(9, 2, 2, 1, 10, 2, 3, 4, 5, 5, 7);

		numbers.stream().distinct().sorted().forEach(s -> System.out.println(s));

		List<Integer> li = numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(4));
	}

}