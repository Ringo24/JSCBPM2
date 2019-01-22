package com.lee.jscbpm2.data;

import java.math.BigDecimal;
import java.util.Date;

public class Data {
	private BigDecimal jd_no;
	private String jd_id;
	private String jd_title;
	private String jd_file;
	private Date jd_date;
	private String jm_name;
	private String jm_photo;
	
	public Data() {super();}

	public Data(BigDecimal jd_no, String jd_id, String jd_title, String jd_file, Date jd_date, String jm_name,
			String jm_photo) {
		super();
		this.jd_no = jd_no;
		this.jd_id = jd_id;
		this.jd_title = jd_title;
		this.jd_file = jd_file;
		this.jd_date = jd_date;
		this.jm_name = jm_name;
		this.jm_photo = jm_photo;
	}

	public BigDecimal getJd_no() {
		return jd_no;
	}

	public void setJd_no(BigDecimal jd_no) {
		this.jd_no = jd_no;
	}

	public String getJd_id() {
		return jd_id;
	}

	public void setJd_id(String jd_id) {
		this.jd_id = jd_id;
	}

	public String getJd_title() {
		return jd_title;
	}

	public void setJd_title(String jd_title) {
		this.jd_title = jd_title;
	}

	public String getJd_file() {
		return jd_file;
	}

	public void setJd_file(String jd_file) {
		this.jd_file = jd_file;
	}

	public Date getJd_date() {
		return jd_date;
	}

	public void setJd_date(Date jd_date) {
		this.jd_date = jd_date;
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
	
}
