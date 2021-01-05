package com.sifi.test;

import com.sifi.dao.UnitGet;
import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Test {
	
	public static void attackTest0() {
		Unit marine1 = UnitGet.getUnitByName("marine");
		
		
		System.out.println(marine1);
		for (Skill skill :marine1.skills) {
			skill.showinfo();
		}
//		System.out.println(marine1.getBeAttackedType());
//		AttTrigger.attackTigger(marine2, marine1);
//		marine1.showInfo();
//		AttTrigger.attackTigger(marine2, marine1);
//		marine1.showInfo();
//		AttTrigger.attackTigger(marine2, marine1);
//		marine1.showInfo();
//		AttTrigger.attackTigger(marine2, marine1);
//		marine1.showInfo();
	}
	
	
	

	public static void main(String[] args) {
		attackTest0();

	}

}
