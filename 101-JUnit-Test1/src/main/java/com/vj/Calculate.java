package com.vj;

public class Calculate {

	public int add(int x, int y) {
		return x+y;
	}

	public int substract(int x, int y) {
		if(x>y || x==y)
			return x-y;
		else
			return -(y-x);
	}
	
	public int divide(int a, int b) {
		return a/b;
	}

}
