package com.sifi.sklCalculate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sifi.model.Buff;
import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Continuous implements SkillCal {
	
	private Set<String> contSet;
	private Set<String> chngSet;
	private List<String> attr0;
	private List<String> attr1;
	private List<Integer> dgr0;
	private List<Integer> dgr1;
	
	public Continuous() {
		contSet = new HashSet<>();
		contSet.add("scale");
		contSet.add("shield");
		contSet.add("mana");
		
		chngSet = new HashSet<>();
		chngSet.add("uhp");
		chngSet.add("speed");
		chngSet.add("armor");
		chngSet.add("damage");
		chngSet.add("freq");
		chngSet.add("range");
		
		attr0 = new ArrayList<>();
		attr1 = new ArrayList<>();
		dgr0 = new ArrayList<>();
		dgr1 = new ArrayList<>();
	}
	

	@Override
	public void calculate(Skill skill, Unit caster, Unit target) {
		if (caster.c_mana < skill.manacost || skill.cur_cold_t < skill.cold_t)
			return;
		caster.c_mana -= skill.manacost;
		skill.cur_cold_t = 0;
		
		for (int i = 0; i < skill.attributes.length; i++) {
			String attr = skill.attributes[i];
			Integer dgr = skill.degree[i];
			
			if (contSet.contains(attr)) {
				attr0.add(attr);
				dgr0.add(dgr);
			} else if (chngSet.contains(attr)) {
				attr1.add(attr);
				dgr1.add(dgr);
			}
		}
		
		if (!attr0.isEmpty()) {
			target.buffs.add(new Buff(0, attr0, dgr0, skill.period, target));
		}
		
		if (!attr1.isEmpty()) {
			
			target.buffs.add(new Buff(1, attr1, dgr1, skill.period, target));
		}

	}

}
