package LabSession6.GalvanizingLine_SimpleOERTPN;

public class Main {

	public static void main(String[] args) {
		Controller c = new Controller();
		Robot r = new Robot();
		c.r = r;
		r.c = c;
		c.start();
		r.start();
	}
}
