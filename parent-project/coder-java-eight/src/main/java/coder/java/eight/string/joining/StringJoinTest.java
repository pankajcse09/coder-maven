package coder.java.eight.string.joining;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringJoinTest {

	/** Example 1 - joining String by comma */
	public static void joinString() {
		StringJoiner joiner = new StringJoiner(", ");
		joiner.add("Sony");
		joiner.add("Apple");
		joiner.add("Google");
		String joined = joiner.toString();
		System.out.println("Joining String Elements: " + joined);
	}

	/** Example 2 - joining Array by comma */
	public static void joinArrayString() {
		String[] typesOfFee = { "admin fee", "processing fee", "monthly fee" };
		String fees = String.join(";", typesOfFee);
		System.out.println("Joining Array Elements: " + fees);
	}

	/** Example 3 - joining List by comma */
	public static void joinListString() {
		List<String> typesOfLoan = Arrays.asList("home loan", "personal loan", "car loan", "balance transfer");
		String loans = String.join(",", typesOfLoan);
		System.out.println("Joining List Elements: " + loans);
	}

	/** Example 4 - joining List Collectors by comma */
	public static void joiningCollector() {
		List<String> list = Arrays.asList("life insurance", "health insurance", "car insurance");
		String fromStream = list.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
		System.out.println("Joining List Elements using Joining Collector: " + fromStream);
	}

	/** Example 5 - joining String create Unix path */
	public static void createUnixPath() {
		String pathInLinux = String.join("/", "", "usr", "local", "bin");
		System.out.println("Path in Linux : " + pathInLinux);
	}

	/** Example 5 - joining String create Unix path */
	public static void createWindowsPath() {
		String pathInWindows = String.join("\\", "C:", "Program Files", "Java");
		System.out.println("path in Windows : " + pathInWindows);

	}

}
