package com.iii.emp.test;

import java.lang.reflect.Field;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.iii.framework.core.validation.DateDiff;

@DateDiff(start = "strartDate", end = "endDate", diff = "<1Y")
public class HelloBean {

	@Pattern(regexp = "[a-zA-Z]*")
	private String name;
	@Size(min = 1000, max = 10000)
	private Integer number;
	@Pattern(regexp = "([a-zA-Z])([0-9])(-)([0-9]){4}|([0-9]){3}(-)([0-9]){3}|([a-zA-Z]){2}(-)([0-9]){4}")
	private String plateNo;
	private Date strartDate;
	private Date endDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	public Date getStrartDate() {
		return strartDate;
	}

	public void setStrartDate(Date strartDate) {
		this.strartDate = strartDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * 測試
	 */
	public static void main(String[] args) throws Exception {

	}

}
