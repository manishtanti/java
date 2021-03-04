// here i am assuming that if center of camp is inside bomb radius than it will be destroyed
// if some part of camp is inside bomb radius but center of camp is outside bomb radius then it
// will not be destroyed

class test {
	static int count = 0;

	public static void print(int o, int c, String ans) {

		if (o < 0 || c < 0 || c < o) {
			return;
		}
		if (o == 0 && c == 0) {
			System.out.println(ans);
			return;
		}
		count++;
		print(o, c - 1, ans + ")");
		print(o - 1, c, ans + "(");

	}

	public static void main(String[] args) {
		int n = 8;
		print(n, n, "");
		System.out.println(count);
	}
}