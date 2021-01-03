package com.sifi.sklCalculate;

import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Backlash implements SkillCal {

	@Override
	public void calculate(Skill skill, Unit caster, Unit target) {
		String fromAttr = skill.attributes[0];
		String toAttr = skill.attributes[1];
		int num = 0;
		
		if (fromAttr.equals("scale")) {
			num = target.c_scale;
			target.c_scale = 0;
		} else if (fromAttr.equals("mana")) {
			num = target.c_mana;
			target.c_mana = 0;
		} else if (fromAttr.equals("shield")) {
			num = target.c_shield;
			target.c_shield = 0;
		}
		
		if (toAttr.equals("scale")) {
			target.c_scale -= num;
			if (target.c_scale < 0) target.c_scale = 0;
		} else if (toAttr.equals("mana")) {
			target.c_mana -= num;
			if (target.c_mana < 0) target.c_mana = 0;
		} else if (toAttr.equals("shield")) {
			target.c_shield -= num;
			if (target.c_shield < 0) target.c_shield = 0;
		}

	}

}
