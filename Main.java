import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

/*

sequence contains duplicates

-------------------------

5
1 2 3 2 4

1 = 1
2 = 2
3 = 1
4 = 1

= 1 * 2

-------------------------

we need multiplication to calculate it
valid sequences are only from 1 to k (continuous)

 */

public class Main {

	public static void main(String[] args) {
		Scanner fs = new Scanner(System.in);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			TreeSet<Integer> ts = new TreeSet<>();
			HashMap<Integer, Long> mp = new HashMap<>();
			for (int i = 0; i < n; i++) {
				int num = fs.nextInt();
				ts.add(num);
				mp.put(num, mp.getOrDefault(num, 0L) + 1);
			}
			int stop = -1, prev = 0;
			for (int x : ts) {
				if (x - prev > 1) {
					stop = prev;
					break;
				}
				prev = x;
			}
			if (stop == -1 && ts.first() == 1) {
				stop = ts.last();
			}
//			System.out.println(stop);
			if (stop == 0) {
				System.out.println(0);
				continue;
			}
			long sum = 0, prod = 1;
			for (int key : mp.keySet()) {
				prod = mul(prod, mp.get(key));
				sum = add(sum, prod);
				if (key == stop) {
					break;
				}
			}
			System.out.println(sum);
		}
		fs.close();
	}
	
	static final long mod = 1_000_000_007;
	static long add(long a, long b) {
		return (a + b) % mod;
	}
	
	static long mul(long a, long b) {
		return a * b % mod;
	}
}
