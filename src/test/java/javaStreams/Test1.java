package javaStreams;

import java.util.ArrayList;
import java.util.stream.Stream;

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

}
