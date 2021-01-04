package com.sifi.attCalculate;

import com.sifi.model.Unit;

public class PassiveDefense {

	public static int totalDamage(Unit attacker, Unit target) {
		if (target.a_freq <= 0 || target.g_freq <= 0) 
			return 0;
		
		int singleDamage = target.getSingleDam(attacker.getBeAttackedType());
		if (singleDamage == 0) return 0;
		singleDamage -= attacker.armor;
		if (singleDamage <= 0) 
			return 0;
		
		// --------Change this into AOE determination in the future--------
		if (singleDamage > attacker.uhp && singleDamage < 2 * attacker.uhp) 
			singleDamage = attacker.uhp;
		// ----------------------------------------------------------------
		
		if (attacker.ga == 'a') return singleDamage * target.a_freq * target.c_scale;
		return singleDamage * target.g_freq * target.c_scale;
	}
	
	public static void scaleDecrease(int totalDamageFromDefender, Unit attacker) {
		if (attacker.c_scale == 0) 
			return;
		
		totalDamageFromDefender = (int) (totalDamageFromDefender * 0.8);
		
		int numOfDecrease = totalDamageFromDefender / attacker.uhp;
		if (numOfDecrease == 0) {
			if (totalDamageFromDefender >= (attacker.uhp / 2))
				numOfDecrease = 1;
		}
		
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
