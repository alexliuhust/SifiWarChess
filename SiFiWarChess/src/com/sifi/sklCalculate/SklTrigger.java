package com.sifi.sklCalculate;

import java.util.HashMap;
import java.util.Map;

import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class SklTrigger {
	
	private Map<String, SkillCal> map = new HashMap<>();
	
	public SklTrigger() {
		map.put("switch", new Switch());
		map.put("continuous", new Continuous());
		map.put("medical", new Medical());
		map.put("clearup", new Clearup());
		map.put("backlash", new Backlash());
		map.put("damage", new Damage());
		map.put("selfdestruct", new Selfdestruct());
		map.put("summon", new Summon());
	}

	public void skillTrigger(Skill skill, Unit caster, Unit target) {
		if (caster.c_mana < skill.manacost || skill.cur_cold_t < skill.cold_t)
			return;
		
		// Determine the target type 
		// 
		// 
		// 
		// 
		
		caster.c_mana -= skill.manacost;
		skill.cur_cold_t = 0;
		
		SkillCal skillCal = this.map.get(skill.type);
		skillCal.calculate(skill, caster, target);
	}
}



