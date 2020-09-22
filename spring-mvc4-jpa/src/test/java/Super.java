
public class Super {

	public static void main(String[] args) throws Exception {

		int x = 0;
		int y = 10;

		do {
			y--;
			++x;

		} while (x < 5);

		System.out.println(x + "" + y);

	}
}

class A {
	static final String FOO = "foo";
}

class B extends A {
	static final String FOO = "bar";
}

class C extends B {

}

class D {

	void f(A a) {
		System.out.println("A");
	}

	void f(B a) {
		System.out.println("B");
	}

	void f(C a) {
		System.out.println("C");
	}

	public static void main(String[] args) {
	}
}