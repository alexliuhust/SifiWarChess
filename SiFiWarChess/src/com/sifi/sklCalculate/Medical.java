package com.sifi.sklCalculate;

import java.util.ArrayList;
import java.util.List;

import com.sifi.model.Buff;
import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Medical implements SkillCal {
	
	private List<String> attr;
	private List<Integer> dgr;
	
	public Medical() {
		attr = new ArrayList<>();
		dgr = new ArrayList<>();
	}

	@Override
	public void calculate(Skill skill, Unit caster, Unit target) {
		int degree = skill.degree[0];
		int totalHealing = degree * caster.c_scale;
		
		// Healing phalanx
		if (target.scale > 1) {
			attr.add("scale");
			degree = totalHealing / target.uhp;
			dgr.add(degree);
		} 
		
		// Healing single unit
		else {
			attr.add("uhp");
			dgr.add(totalHealing);
		}
		
		target.buffs.add(new Buff(0, attr, dgr, skill.period, target));
	}

}
