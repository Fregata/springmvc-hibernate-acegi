package com.business.web.vo;

import java.io.Serializable;

import com.business.persistence.vo.Clazz;
import com.business.persistence.vo.SchoolRoll;

public class ClazzInfo implements Serializable {

	private static final long serialVersionUID = 7074459858613650067L;

	private SchoolRoll clz_SchoolRoll;
	private Clazz clazz;
	
	public ClazzInfo(SchoolRoll sch, Clazz clazz) {
		this.setClz_SchoolRoll(sch);
		this.setClazz(clazz);
	}
	
	public SchoolRoll getClz_SchoolRoll() {
		return clz_SchoolRoll;
	}
	public void setClz_SchoolRoll(SchoolRoll clz_SchoolRoll) {
		this.clz_SchoolRoll = clz_SchoolRoll;
	}
	public Clazz getClazz() {
		return clazz;
	}
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
	
	
	
}
