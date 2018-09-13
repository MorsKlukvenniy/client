package client;
/**
 * @author yura
 *
 */

import java.util.BitSet;  //Библа для генерации простых чисел.

public class Keys {
	
	private int e; //Открытая экспонента
	private int n; //Модуль
	private int d; //Секретная экспонента
	private int p; //Простое число 1
	private int q; //Простое число 2
	private int a; //Начало диапазона генерации простых чисел. Задаётся в main.
	private int b; //Ширина диапазона генерации простых чисел. Задаётся в main. (Диапазон = от a до a + b)
	private int fi; //Значение функции Эйлера
	private int limit; //Предел генерации ряда простых числе. Задаётся в main, Надо ставить больше предпологаемого значения Fi
    
    Keys(int a1, int b1, int limit1) {

    	e = 0;
    	n = 0;
    	d = 0;
    	p = 0;
    	q = 0;
    	a = a1;
        b = b1;
        fi = 0;
        limit = limit1;
        CreatePairOfPrimesFiAndE();
		AdvancedEuclid(fi, e);
    }
    
    int GetFi() {
    	return fi;
    }
    
    int GetE() {
    	return e;
    }
    
    long [] GetPublicKey () {
    	long [] publicKey = new long[2];
    	publicKey[0] = (long) e;
    	publicKey[1] = (long) n;
    	return publicKey;
    }
    
    long [] GetPrivateKey () {
    	long [] privateKey = new long[2];
    	privateKey [0] = (long) d;
    	privateKey [1] = (long) n;
    	return privateKey;
    }
	
    //С помощью расширенного алгоритма Эвклида находит значение d.
	void AdvancedEuclid (int fi1, int e1) {

	d = 0;
    int v = 0;
    
    if (e1 == 0) 
    	d = 1;
    
    int x2 = 1;
    int x1 = 0;
    int y2 = 0;
    int y1 = 1;
    int q = 0;
    int r = 0;
    while (e1 > 0) {
    	q = fi1 / e1;
    	r = fi1 - q * e1;
    	v = x2 - q * x1;
    	d = y2 - q * y1;
    	fi1 = e1;
    	e1 = r;
    	x2 = x1;
    	x1 = v;
    	y2 = y1;
    	y1 = d;    	
    }
    d = y2;
    if (d < 0)
    	d = fi + d;
    //System.out.format("d = %d ", d);
	}
	//Алгоритм Эвклида (use для проверки, взаимопростые ли числа)
	int gcd(int a1, int b1) {
        while (b1 !=0) {
            int tmp = a1%b1;
            a1 = b1;
            b1 = tmp;
        }
        return a1;
    }
	
	//Генерациия простых чисел, fi и e
	void CreatePairOfPrimesFiAndE () {

	    BitSet primes = AtkinSieve.getPrimesUpTo(limit);
	    int random_number1;
	    int random_number2;
	        
	    while ((p == 0) || (q == 0)) {
	      random_number1 = a + (int) (Math.random() * b);
	      random_number2 = a + (int) (Math.random() * b);
	       	if (primes.get(random_number1))
	       		p = random_number1;
	        if (primes.get(random_number2))
	        	q = random_number2;
	    }
	    //p = 3557;
	    //q = 2579;
	    //System.out.format("p = %d ", p);
	    //System.out.format("q = %d ", q);
	    
	    n = p * q;
	    //System.out.format("n = %d ", n);
		fi = (p - 1) * (q - 1);
		//System.out.format("fi = %d ", fi);
        a = 2;
        b = fi - 1;
        while ((e == 0) && (gcd(fi, e) != 1)) {
        	random_number1 = a + (int) (Math.random() * b);
        	if (primes.get(random_number1))
        		e = random_number1;
        }
        //e = 3;
        //System.out.format("e = %d ", e);
	}

}
