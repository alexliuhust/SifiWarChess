package com.sifi.test;

import com.sifi.attCalculate.AttTrigger;
import com.sifi.dao.UnitGet;
import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Test {
	
	public static void attackTest0() {
		Unit marine1 = UnitGet.getUnitByName("marine");
		System.out.println(marine1);
		
		System.out.println("=================1=================");
		marine1.skills.get("Adrenaline").trigger(marine1, marine1);
		System.out.println(marine1);
		
		System.out.println("=================2=================");
		marine1.myTurnStart();
		System.out.println(marine1);
		
		System.out.println("=================3=================");
		marine1.myTurnStart();
		System.out.println(marine1);
		
		System.out.println("=================4=================");
		marine1.myTurnStart();
		System.out.println(marine1);
		
	}
	
	public static void main(String[] args) {
		attackTest0();

	}

}
