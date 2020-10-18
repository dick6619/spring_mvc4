package myapp;

import java.util.Date;

public class DateTool {

	public static void main(String[] args) {
		if (args.length > 1 || !args[0].matches("[0-9*]")) {
			System.out.println("invalid param");
		}
		System.out.println(new Date(Long.valueOf(args[0])));
	}
}
