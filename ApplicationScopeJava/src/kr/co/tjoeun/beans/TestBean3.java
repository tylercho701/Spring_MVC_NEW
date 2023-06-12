package kr.co.tjoeun.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

//	By Type
@Component
@ApplicationScope
public class TestBean3 {
	private String data5;
	private String data6;
	
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
}