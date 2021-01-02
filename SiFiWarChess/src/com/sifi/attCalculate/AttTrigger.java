package com.sifi.attCalculate;

import com.sifi.model.Unit;

public class AttTrigger {
	
	public static void attackTigger(Unit attacker, Unit target) {
		int totalDamage = totalDamage(attacker, target);
		scaleDecrease(totalDamage, target);
	}
	
	public static int totalDamage(Unit attacker, Unit target) {
		if (attacker.a_freq <= 0 || attacker.g_freq <= 0 || target.c_scale <= 0) 
			return 0;
		int singleDamage = attacker.getSingleDam(target.getBeAttackedType());
		if (singleDamage == 0) return 0;
		singleDamage -= target.armor;
		if (singleDamage <= 0) 
			return 0;
		return singleDamage * attacker.a_freq * attacker.c_scale;
	}
	
	public static void scaleDecrease(int damage, Unit target) {
		if (target.c_scale == 0) 
			return;
		int numOfDecrease = damage / target.uhp;
		if (numOfDecrease == 0) {
			if (damage >= (target.uhp / 2))
				numOfDecrease = 1;
		}
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
