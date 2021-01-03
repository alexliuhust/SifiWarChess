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
		attr.add("scale");
		dgr = new ArrayList<>();
	}

	@Override
	public void calculate(Skill skill, Unit caster, Unit target) {
		int degree = skill.degree[0];
		int totalHealing = degree * caster.c_scale;
		degree = totalHealing / target.uhp;
		dgr.add(degree);
		
		target.buffs.add(new Buff(0, attr, dgr, skill.period, target));
	}

}
