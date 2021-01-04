package com.sifi.attCalculate;

import com.sifi.model.Unit;

public class AttTrigger {
	
	public static void attackTigger(Unit attacker, Unit target) {
		int totalDamageFromAttacker = AtciveAttack.totalDamage(attacker, target);
		
		boolean counterAttack = false;
		if (attacker.ga == 'g' && target.ga == 'g') {
			if (attacker.g_range <= target.g_range) counterAttack = true;
		}
		else if (attacker.ga == 'g' && target.ga == 'a') {
			if (attacker.a_range <= target.g_range) counterAttack = true;
		}
		else if (attacker.ga == 'a' && target.ga == 'g') {
			if (attacker.g_range <= target.a_range) counterAttack = true;
		}
		else if (attacker.ga == 'a' && target.ga == 'a') {
			if (attacker.a_range <= target.a_range) counterAttack = true;
		}
		
		int totalDamageFromDefender = 0;
		if (counterAttack) 
			totalDamageFromDefender = PassiveDefense.totalDamage(attacker, target);
		AtciveAttack.scaleDecrease(totalDamageFromAttacker, target);
		if (counterAttack) 
			PassiveDefense.scaleDecrease(totalDamageFromDefender, attacker);
	}
	
}
