package it.altran.jsf.myApp.jpa.dao.common;

public class DataException extends Exception {
	private static final long serialVersionUID = 1L;
	private int key;
	public static final int Generic = 0;
	public static final int NoResult = 1;
	public static final int IllegalArgument = 2;
	public static final int EntityExists = 3;
	public static final int NonUniqueResult = 4;

	public DataException(int key, String msg) {
		super(msg);
		setKey(key);
	}

	private void setKey(int key) {
		this.key = key;
	}

	public int getKey() {
		return key;
	}
}
