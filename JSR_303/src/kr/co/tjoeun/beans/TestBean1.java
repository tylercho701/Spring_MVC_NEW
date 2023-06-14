package kr.co.tjoeun.beans;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class TestBean1 {
	
	@AssertTrue
	private boolean data1;
	
	@AssertFalse
	private boolean data2;
	
	@Max(100)
	@Min(10)
	private String data3;
	
	@DecimalMax(value="100", inclusive=false)
	@DecimalMin(value="10", inclusive=false)
	private String data4;
	
	@Null
	private String data5;
	
	@NotNull
	private String data6;
	
	@Digits(integer=3, fraction=3)
	private String data7;
	
	@Size(max=10, min=2)
	private String data8;
	
	@Pattern(regexp="[a-zA-z]*")
	private String data9;
	
	//	입력 화면에 보여질 기본값 설정
	public TestBean1() {
		this.data1 = true;
		this.data2 = false;
		this.data3 = "37";		//	실제 받는 값은 int지만 string으로 bean 설정하면 0으로 안보이게 할 수 있음
		this.data4 = "37";
		this.data5 = null;
		this.data6 = "check2";
		this.data7 = "333.333";
		this.data8 = "더조은";
	}

	public final boolean isData1() {
		return data1;
	}

	public final void setData1(boolean data1) {
		this.data1 = data1;
	}

	public final boolean isData2() {
		return data2;
	}

	public final void setData2(boolean data2) {
		this.data2 = data2;
	}

	public final String getData3() {
		return data3;
	}

	public final void setData3(String data3) {
		this.data3 = data3;
	}

	public final String getData4() {
		return data4;
	}

	public final void setData4(String data4) {
		this.data4 = data4;
	}

	public final String getData5() {
		return data5;
	}

	public final void setData5(String data5) {
		this.data5 = data5;
	}

	public final String getData6() {
		return data6;
	}

	public final void setData6(String data6) {
		this.data6 = data6;
	}

	public final String getData7() {
		return data7;
	}

	public final void setData7(String data7) {
		this.data7 = data7;
	}

	public final String getData8() {
		return data8;
	}

	public final void setData8(String data8) {
		this.data8 = data8;
	}

	public final String getData9() {
		return data9;
	}

	public final void setData9(String data9) {
		this.data9 = data9;
	}
}