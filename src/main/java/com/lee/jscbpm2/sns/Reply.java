package com.lee.jscbpm2.sns;

import java.math.BigDecimal;
import java.util.Date;

public class Reply {
	
	private BigDecimal jr_no;
	private BigDecimal jr_jsno;
	private String jr_id;
	private String jr_txt;
	private Date jr_date;
	private String jm_name;
	
	
	public Reply() {
		super();
	}

	public Reply(BigDecimal jr_no, BigDecimal jr_jsno, String jr_id, String jr_txt, Date jr_date, String jm_name) {
		super();
		this.jr_no = jr_no;
		this.jr_jsno = jr_jsno;
		this.jr_id = jr_id;
		this.jr_txt = jr_txt;
		this.jr_date = jr_date;
		this.jm_name = jm_name;
	}

	public BigDecimal getJr_no() {
		return jr_no;
	}

	public void setJr_no(BigDecimal jr_no) {
		this.jr_no = jr_no;
	}

	public BigDecimal getJr_jsno() {
		return jr_jsno;
	}

	public void setJr_jsno(BigDecimal jr_jsno) {
		this.jr_jsno = jr_jsno;
	}

	public String getJr_id() {
		return jr_id;
	}

	public void setJr_id(String jr_id) {
		this.jr_id = jr_id;
	}

	public String getJr_txt() {
		return jr_txt;
	}

	public void setJr_txt(String jr_txt) {
		this.jr_txt = jr_txt;
	}

	public Date getJr_date() {
		return jr_date;
	}

	public void setJr_date(Date jr_date) {
		this.jr_date = jr_date;
	}

	public String getJm_name() {
		return jm_name;
	}

	public void setJm_name(String jm_name) {
		this.jm_name = jm_name;
	}
}
