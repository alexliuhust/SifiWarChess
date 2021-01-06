package com.sifi.attCalculate;

import com.sifi.model.Unit;

public class AtciveAttack {

	public static int totalDamage(Unit attacker, Unit target) {
		if (target.c_scale <= 0) return 0;
		
		int singleDamage = attacker.getSingleDam(target.getBeAttackedType());
		if (singleDamage == 0) return 0;
		singleDamage -= target.armor;
		if (singleDamage <= 0) 
			return 0;
		
		// AOE determination
		if (singleDamage > target.uhp) {
			if ((target.ga == 'a' && !attacker.a_aoe) || (target.ga == 'g' && !attacker.g_aoe)) {
				singleDamage = target.uhp;
			}
		}
		System.out.println("singleDamageFromAttacker:" + singleDamage);
		
		if (target.ga == 'a') return singleDamage * attacker.a_freq * attacker.c_scale;
		return singleDamage * attacker.g_freq * attacker.c_scale;
	}
	
	public static void scaleDecrease(int totalDamageFromAttacker, Unit target) {
		if (target.c_scale == 0) 
			return;
		
		// If target is a single unit
		if (target.scale == 1) {
			target.c_uhp -= totalDamageFromAttacker / 10;
			return;
		}
		
		int numOfDecrease = totalDamageFromAttacker / target.uhp;
		if (numOfDecrease == 0) {
			if (totalDamageFromAttacker >= (target.uhp / 2))
				numOfDecrease = 1;
		}
		
		// If there's shield left, decrease shield first
		if (target.c_shield > 0) {
			target.c_shield -= numOfDecrease;
			if (target.c_shield < 0) 
				target.c_shield = 0;
			return;
		}
		
		target.c_scale -= numOfDecrease;
		if (target.c_scale < 0) target.c_scale = 0;
	}
}
