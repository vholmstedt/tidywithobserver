
public class Test {

	public static void main(String[] args) {
		new Test().test();
	}

	private void test() {
		String n = "33";
// 		String number = String.format("%04d", Integer.toHexString(n & 0xff));
		String number = ("00" + n).substring(n.length());
		
		System.out.println(number);
		
		
		
	}

}
