/**
 * 
 */
package client;

/**
 * @author yura
 *
 */
public class features {
	//Обычная Pow, но для int
	static long Pow(long a, long b) {
		long result = a;
		for (int i = 1; i < b; i++)
			result *= a;
		return result;
	}
	//Функция возведения message в степень d в кольце n (поле n)
	static long FieldPow(long message, long d, long n) {
		long result = 1;
		int j = 1;
		while (j <= d) {
			result = message * result % n;
			j++;
		}
		return result;
	}
}
