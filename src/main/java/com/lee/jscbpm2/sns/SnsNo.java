package com.lee.jscbpm2.sns;

import java.math.BigDecimal;

public class SnsNo {

	private BigDecimal start;
	private BigDecimal end;
	
	public SnsNo() {
		super();
	}
	
	public SnsNo(BigDecimal start, BigDecimal end) {
		super();
		this.start = start;
		this.end = end;
	}
	public BigDecimal getStart() {
		return start;
	}
	public void setStart(BigDecimal start) {
		this.start = start;
	}
	public BigDecimal getEnd() {
		return end;
	}
	public void setEnd(BigDecimal end) {
		this.end = end;
	}
	
}
