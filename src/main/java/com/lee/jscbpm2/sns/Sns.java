package com.lee.jscbpm2.sns;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Sns {
	
	private BigDecimal js_no;
	private String js_id;
	private String js_txt;
	private Date js_date;
	private String jm_name;
	private String jm_photo;
	private List<Reply> js_repls;
	
	public Sns() {super();}

	public Sns(BigDecimal js_no, String js_id, String js_txt, Date js_date, String jm_name, String jm_photo,
			List<Reply> js_repls) {
		super();
		this.js_no = js_no;
		this.js_id = js_id;
		this.js_txt = js_txt;
		this.js_date = js_date;
		this.jm_name = jm_name;
		this.jm_photo = jm_photo;
		this.js_repls = js_repls;
	}

	public BigDecimal getJs_no() {
		return js_no;
	}

	public void setJs_no(BigDecimal js_no) {
		this.js_no = js_no;
	}

	public String getJs_id() {
		return js_id;
	}

	public void setJs_id(String js_id) {
		this.js_id = js_id;
	}

	public String getJs_txt() {
		return js_txt;
	}

	public void setJs_txt(String js_txt) {
		this.js_txt = js_txt;
	}

	public Date getJs_date() {
		return js_date;
	}

	public void setJs_date(Date js_date) {
		this.js_date = js_date;
	}

	public String getJm_name() {
		return jm_name;
	}

	public void setJm_name(String jm_name) {
		this.jm_name = jm_name;
	}

	public String getJm_photo() {
		return jm_photo;
	}

	public void setJm_photo(String jm_photo) {
		this.jm_photo = jm_photo;
	}

	public List<Reply> getJs_repls() {
		return js_repls;
	}

	public void setJs_repls(List<Reply> js_repls) {
		this.js_repls = js_repls;
	}
	
}
