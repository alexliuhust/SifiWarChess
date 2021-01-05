package com.sifi.test;

import com.sifi.attCalculate.AttTrigger;
import com.sifi.dao.UnitGet;
import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Test {
	
	public static void attackTest0() {
		Unit marine1 = UnitGet.getUnitByName("marine");
		Unit Rockhead = UnitGet.getUnitByName("Rockhead");
		
		System.out.println(marine1);
		System.out.println(Rockhead);
		System.out.println("==================================");
		
		AttTrigger.attackTigger(marine1, Rockhead);
		System.out.println(marine1);
		System.out.println(Rockhead);
		System.out.println("==================================");
		AttTrigger.attackTigger(marine1, Rockhead);
		System.out.println(marine1);
		System.out.println(Rockhead);
		System.out.println("==================================");
		
		//marine1.skills.get("Adrenaline").trigger(marine1, marine1);
	}
	
	public static void attackTest1() {
		Unit marine1 = UnitGet.getUnitByName("marine");
		Unit Rockhead = UnitGet.getUnitByName("Rockhead");
		
		System.out.println(marine1);
		System.out.println(Rockhead);
		System.out.println("==================================");
		
		marine1.skills.get("Shield Defense").trigger(marine1, marine1);
		marine1.myTurnStart();
		System.out.println(marine1);
		AttTrigger.attackTigger(marine1, Rockhead);
		System.out.println(marine1);
		System.out.println(Rockhead);
		System.out.println("==================================");
		marine1.myTurnStart();
		System.out.println(marine1);
		AttTrigger.attackTigger(marine1, Rockhead);
		System.out.println(marine1);
		System.out.println(Rockhead);
		System.out.println("==================================");
		
		
	}
	
	
	

	public static void main(String[] args) {
		//attackTest0();
		System.out.println("==================================");
		System.out.println("==================================");
		attackTest1();

	}

}
