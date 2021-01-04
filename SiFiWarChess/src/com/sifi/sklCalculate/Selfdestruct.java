package com.sifi.sklCalculate;

import com.sifi.attCalculate.AtciveAttack;
import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Selfdestruct implements SkillCal {

	@Override
	public void calculate(Skill skill, Unit caster, Unit target) {
		int damage = skill.degree[0];
		int totalDamage = damage * caster.c_scale;
		AtciveAttack.scaleDecrease(totalDamage, target);
		caster.c_scale = 0;
	}

}
