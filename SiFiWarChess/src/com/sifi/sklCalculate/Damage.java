package com.sifi.sklCalculate;

import com.sifi.attCalculate.AtciveAttack;
import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Damage implements SkillCal {

	@Override
	public void calculate(Skill skill, Unit caster, Unit target) {
		int damage = skill.degree[0];
		damage -= target.armor;
		
		if (damage > target.uhp && !skill.aoe) 
			damage = target.uhp;
		
		int totalDamage = damage * caster.c_scale;
		AtciveAttack.scaleDecrease(totalDamage, target);

	}

}
