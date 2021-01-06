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
		chngSet.add("l");
		chngSet.add("h");
		chngSet.add("g");
		chngSet.add("a");
		chngSet.add("g_lb");
		chngSet.add("g_hb");
		chngSet.add("g_lm");
		chngSet.add("g_hm");
		chngSet.add("a_lb");
		chngSet.add("a_hb");
		chngSet.add("a_lm");
		chngSet.add("a_hm");
		
		chngSet.add("freq");
		chngSet.add("g_freq");
		chngSet.add("a_freq");
		
		chngSet.add("range");
		
		attr0 = new ArrayList<>();
		attr1 = new ArrayList<>();
		dgr0 = new ArrayList<>();
		dgr1 = new ArrayList<>();
	}
	

	@Override
	public void calculate(Skill skill, Unit caster, Unit target) {
		System.out.println("Succeed");
		
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
			Buff newBuff = new Buff(0, attr0, dgr0, skill.period, target);
			target.buffs.add(newBuff);
			newBuff.triggerOrStop();
		}
		
		if (!attr1.isEmpty()) {
			Buff newBuff = new Buff(1, attr1, dgr1, skill.period, target);
			target.buffs.add(newBuff);
			newBuff.triggerOrStop();
		}

	}

}
