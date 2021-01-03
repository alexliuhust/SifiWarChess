package com.sifi.sklCalculate;

import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Clearup implements SkillCal {
	
	private int[] nums;

	@Override
	public void calculate(Skill skill, Unit caster, Unit target) {
		int[] nums = new int[skill.attributes.length];
		for (int i = 0; i < skill.attributes.length; i++) {
			if (skill.attributes[i].equals("scale")) {
				nums[i] = target.c_scale;
				target.c_scale = 0;
			} else if (skill.attributes[i].equals("mana")) {
				nums[i] = target.c_mana;
				target.c_mana = 0;
			} else if (skill.attributes[i].equals("shield")) {
				nums[i] = target.c_shield;
				target.c_shield = 0;
			}
		}
		this.nums = nums;
	}
	
	public int[] getNums() {
		return this.nums;
	}

}
