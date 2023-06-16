package kr.co.tjoeun.beans;

public class TestBean {
	private String data1;
	private String data2;
	private String data3;
	public final String getData1() {
		return data1;
	}
	public final void setData1(String data1) {
		this.data1 = data1;
	}
	public final String getData2() {
		return data2;
	}
	public final void setData2(String data2) {
		this.data2 = data2;
	}
	public final String getData3() {
		return data3;
	}
	public final void setData3(String data3) {
		this.data3 = data3;
	}
	@Override
	public String toString() {
		return "TestBean [data1=" + data1 + ", data2=" + data2 + ", data3=" + data3 + ", getData1()=" + getData1()
				+ ", getData2()=" + getData2() + ", getData3()=" + getData3() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
