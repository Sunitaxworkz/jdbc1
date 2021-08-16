package com.xworkz.customer.dto;

import com.xworkz.customer.constants.EducationType;

public class CustomerDTO {
	private int id;
	private String name;
	private String from;
	private String to;
	private String address;
	private boolean married;
	private String passPortNo;
	private EducationType educationType;

	public CustomerDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", name=" + name + ", from=" + from + ", to=" + to + ", address=" + address
				+ ", married=" + married + ", passPortNo=" + passPortNo + ", educationType=" + educationType + "]";
	}

	public CustomerDTO(String name, String from, String to, String address, boolean married, String passPortNo,
			EducationType educationType) {
		super();
		this.name = name;
		this.from = from;
		this.to = to;
		this.address = address;
		this.married = married;
		this.passPortNo = passPortNo;
		this.educationType = educationType;
	}

	@Override
	public int hashCode() {
		return 100;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public String getPassPortNo() {
		return passPortNo;
	}

	public void setPassPortNo(String passPortNo) {
		this.passPortNo = passPortNo;
	}

	public EducationType getEducationType() {
		return educationType;
	}

	public void setEducationType(EducationType educationType) {
		this.educationType = educationType;
	}

}
