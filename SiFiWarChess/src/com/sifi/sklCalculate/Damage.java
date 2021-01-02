package com.sifi.sklCalculate;

import com.sifi.attCalculate.AttTrigger;
import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Damage implements SkillCal {

	@Override
	public void calculate(Skill skill, Unit caster, Unit target) {
		int damage = skill.degree[0];
		int totalDamage = damage * caster.c_scale;
		AttTrigger.scaleDecrease(totalDamage, target);

	}

}
