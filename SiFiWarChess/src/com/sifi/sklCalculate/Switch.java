package com.sifi.sklCalculate;

import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Switch {

	public static void calculate(Skill skill, Unit caster) {
		if (caster.c_mana < skill.manacost || skill.cur_cold_t < skill.cold_t) return;
		caster.c_mana -= skill.manacost;
		skill.cur_cold_t = 0;
		
		
		for (int i = 0; i < skill.attributes.length; i++) {
			String attr = skill.attributes[i];
			Integer dgr = skill.degree[i];
			
			// Forward switch
			if (skill.period == -1) {
				caster.setAttribute(attr, dgr);
				skill.period = -2;
			} 
			// Backward switch
			else {
				caster.setAttribute(attr, -dgr);
				skill.period = -1;
			}
			
		}
		
		
	}
}
