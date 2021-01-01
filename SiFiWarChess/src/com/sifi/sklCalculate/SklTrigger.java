package com.sifi.sklCalculate;

import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class SklTrigger {

	public static void skillTrigger(Skill skill, Unit caster, Unit target) {
		if (skill.type.equals("switch")) Switch.calculate(skill, caster);
	}
}
