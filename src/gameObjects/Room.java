package gameObjects;

public class Room extends Thing {
	
	private int n, s, e, w;

	public Room(String aName, String aDescription, int aN, int aS, int aE, int aW) {
		super(aName, aDescription);
		this.n =aN;
		this.s = aS;
		this.e = aE;
		this.w = aW;
	}

	public int getN() {
		return n;
	}

	public void setN(int aN) {
		this.n = aN;
	}

	public int getS() {
		return s;
	}

	public void setS(int aS) {
		this.s = aS;
	}

	public int getE() {
		return e;
	}

	public void setE(int aE) {
		this.e = aE;
	}

	public int getW() {
		return w;
	}

	public void setW(int aW) {
		this.w = aW;
	}

}
