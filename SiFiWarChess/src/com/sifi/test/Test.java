package com.sifi.test;

import com.sifi.attCalculate.AttTrigger;
import com.sifi.dao.UnitGet;
import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Test {
	
	public static void attackTest0() {
		Unit Storm = UnitGet.getUnitByName("Storm Chariot");
		Unit Tank = UnitGet.getUnitByName("Siege Tank");
		Tank.shield = 100;
		Tank.c_shield = 100;
		System.out.println(Storm);
		System.out.println(Tank);
		
		System.out.println("=================1=================");
		Storm.skills.get("EMP").trigger(Storm, Tank);
		System.out.println(Storm);
		System.out.println(Tank);
		
		System.out.println("=================2=================");
		Storm.myTurnStart();
		Tank.myTurnStart();
		Storm.skills.get("EMP").trigger(Storm, Tank);
		System.out.println(Storm);
		System.out.println(Tank);
		
		System.out.println("=================3=================");
		Storm.myTurnStart();
		Tank.myTurnStart();
		System.out.println(Storm);
		System.out.println(Tank);
		
		
	}
	
	public static void main(String[] args) {
		attackTest0();

	}

}
