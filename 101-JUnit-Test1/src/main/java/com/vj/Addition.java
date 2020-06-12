package com.vj;

public class Addition {

	public int add(int x, int y) {
		return x+y;
	}

	public int substract(int x, int y) {
		if(x>y || x==y)
			return x-y;
		else
			return -(y-x);
	}
}
