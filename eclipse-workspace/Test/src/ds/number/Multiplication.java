package number;

public class Multiplication {
	//By adding a, b times
		public static int mul(int a, int b)
		{
			if (b == 1) {
				return a;
			}
			return a + mul(a, b - 1);
		}

		public static int multiply(int a, int b)
		{
			if (a == 0 || b == 0) {
				return 0;
			}
			else if (a == 1) {
				return b;
			}
			int m = mul(a, Math.abs(b));
			return (b < 0) ? -m : m;
		}

		public static void main(String[] args)
		{
			System.out.print(multiply(3, 4) + " " + multiply(-3, -4) + " "
							+ multiply(-3, 4) + " " + multiply(3, -4));
			System.out.println();
			System.out.print(multiply2(3, 4) + " " + multiply2(-3, -4) + " "
					+ multiply2(-3, 4) + " " + multiply2(3, -4));
		}
		
		public static int multiply2(int a, int b)
		{
				// flag to store if result is positive or negative
				boolean isNegative = false;

				// if both numbers are negative, make both numbers
				// positive as result will be positive anyway
				if (a < 0 && b < 0) {
					a = -a;
					b = -b;
				}

				// if only a is negative, make it positive
				// and mark result as negative
				if (a < 0) {
					a = -a;
					isNegative = true;
				}

				// if only b is negative, make it positive
				// and mark result as negative
				if (b < 0) {
					b = -b;
					isNegative = true;
				}

				// initialize result by 0
				int result = 0;

				// run till b becomes 0
				while (b != 0)
				{
					// if b is odd, add a to the result
					if ((b & 1) == 1) {
						result += a;
					}

					a = a << 1;			// multiply a by 2
					b = b >> 1;			// divide b by 2
				}

				return (isNegative) ? -result : result;
			}
	}
