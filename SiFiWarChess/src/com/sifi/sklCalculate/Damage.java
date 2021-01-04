package com.sifi.sklCalculate;

import com.sifi.attCalculate.AtciveAttack;
import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Damage implements SkillCal {

	@Override
	public void calculate(Skill skill, Unit caster, Unit target) {
		int damage = skill.degree[0];
		damage -= target.armor;
		if (damage > 1.5 * target.uhp) 
			damage = (int) (1.5 * target.uhp);
		
		int totalDamage = damage * caster.c_scale;
		AtciveAttack.scaleDecrease(totalDamage, target);

	}

}
