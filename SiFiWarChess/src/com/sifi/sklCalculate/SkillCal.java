package com.sifi.sklCalculate;

import com.sifi.model.Skill;
import com.sifi.model.Unit;

public interface SkillCal {
	
	public void calculate(Skill skill, Unit caster, Unit target);

}
