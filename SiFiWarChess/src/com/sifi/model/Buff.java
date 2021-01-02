package com.sifi.model;

import java.util.List;

public class Buff {

	private Integer type;
	private List<String> attrs;
	private List<Integer> dgrs;
	private Integer period;
	private Integer c_period;
	private Unit target;
	
	public Buff(Integer type, List<String> attrs, List<Integer> dgrs, Integer period, Unit target) {
		super();
		this.type = type;
		this.attrs = attrs;
		this.dgrs = dgrs;
		this.period = period;
		this.c_period = period;
		this.target = target;
	}
	
	public int triggerOrStop() {
		if (type == 0) return triggerOrStopConti();
		return triggerOrStopChange();
	}
	
	private int triggerOrStopConti() {
		if (c_period == 0) {
			return 0;
		}
		c_period--;
		for (int i = 0; i < attrs.size(); i++) {
			target.setAttribute(attrs.get(i), dgrs.get(i));
		}
		return 1;
	}
	private int triggerOrStopChange() {
		if (c_period == 0) {
			for (int i = 0; i < attrs.size(); i++) {
				target.setAttribute(attrs.get(i), -dgrs.get(i));
			}
			return 0;
		}
		
		if (c_period == period) {
			for (int i = 0; i < attrs.size(); i++) {
				target.setAttribute(attrs.get(i), dgrs.get(i));
			}
		}
		c_period--;
		return 1;
	}
}























