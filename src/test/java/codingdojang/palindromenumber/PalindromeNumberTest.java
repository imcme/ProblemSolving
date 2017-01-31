package codingdojang.palindromenumber;

/**
 * @author MinCheol Lim <lim.mincheol@nhn.com>
 * @since 2017. 01. 23.
 */
public class PalindromeNumberTest {
	public static void main(String[] args) {
		System.out.println(new PalindromeNumber().run(1));// 0
		System.out.println(new PalindromeNumber().run(5));// 4
		System.out.println(new PalindromeNumber().run(14));// 44
		System.out.println(new PalindromeNumber().run(24));// 141
		System.out.println(new PalindromeNumber().run(32));// 222
		System.out.println(new PalindromeNumber().run(39));// 292
		System.out.println(new PalindromeNumber().run(122));// 2222
		System.out.println(new PalindromeNumber().run(1958));// 958859
		System.out.println(new PalindromeNumber().run(30000));// 200000002
		System.out.println(new PalindromeNumber().run(1000000));// 90000000009
	}
}
