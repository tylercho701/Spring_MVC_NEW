package kr.co.tjoeun.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component(value="applicationBean4")
@ApplicationScope
public class TestBean4 {
	private String data7;
	private String data8;
	
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
}