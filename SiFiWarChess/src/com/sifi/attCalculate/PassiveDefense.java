package com.sifi.attCalculate;

import com.sifi.model.Unit;

public class PassiveDefense {

	public static int totalDamage(Unit attacker, Unit target) {
		int singleDamage = target.getSingleDam(attacker.getBeAttackedType());
		if (singleDamage == 0) return 0;
		singleDamage -= attacker.armor;
		if (singleDamage <= 0) 
			return 0;
		
		// AOE determination
		if (singleDamage > attacker.uhp) {
			if ((attacker.ga == 'a' && !target.a_aoe) || (attacker.ga == 'g' && !target.g_aoe)) {
				singleDamage = attacker.uhp;
			}
		}
		
		System.out.println("singleDamageFromDefender:" + singleDamage);
		
		if (attacker.ga == 'a') return singleDamage * target.a_freq * target.c_scale;
		return singleDamage * target.g_freq * target.c_scale;
	}
	
	public static void scaleDecrease(int totalDamageFromDefender, Unit attacker) {
		if (attacker.c_scale == 0) 
			return;
		
		totalDamageFromDefender = (int) (totalDamageFromDefender * 0.8);
		
		// If attacker is a single unit
		if (attacker.scale == 1) {
			if (attacker.c_shield > 0) {
				attacker.c_shield -= totalDamageFromDefender / 10;
				if (attacker.c_shield < 0) 
					attacker.c_shield = 0;
				return;
			}
			attacker.c_uhp -= totalDamageFromDefender / 10;
			return;
		}
		
		int numOfDecrease = totalDamageFromDefender / attacker.uhp;
		if (numOfDecrease == 0) {
			if (totalDamageFromDefender >= (attacker.uhp / 2))
				numOfDecrease = 1;
		}
		
		// If there's shield left, decrease shield first
		if (attacker.c_shield > 0) {
			attacker.c_shield -= numOfDecrease;
			if (attacker.c_shield < 0) 
				attacker.c_shield = 0;
			return;
		}
		
		attacker.c_scale -= numOfDecrease;
		if (attacker.c_scale < 0) attacker.c_scale = 0;
	}
}
