package com.sifi.model;

import com.sifi.sklCalculate.SklTrigger;

public class Skill {
    
	public String     skill         ;
	public String     type          ;
	public Integer    period        ;
	public Integer    manacost      ;
	
	public Integer    cold_t        ;
	public Integer    cur_cold_t    ;
	
	public String[]   attributes    ;
	public Integer[]  degree        ;
	
	public Skill() {}
	
	public void setAttributes(String attr) {
		this.attributes = attr.split("/");
	}
	
	public void setDegree(String de) {
		String[] dgr = de.split("/");
		this.degree = new Integer[dgr.length];
		for (int i = 0; i < dgr.length; i++) {
			this.degree[i] = Integer.parseInt(dgr[i]);
		}
	}
	
	public void trigger(Unit caster, Unit target) {
		SklTrigger trigger = new SklTrigger();
		trigger.skillTrigger(this, caster, target);
		trigger = null;
	}

}
