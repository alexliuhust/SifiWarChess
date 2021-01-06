package com.sifi.test;

import com.sifi.attCalculate.AttTrigger;
import com.sifi.dao.UnitGet;
import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Test {
	
	public static void attackTest0() {
		Unit marine1 = UnitGet.getUnitByName("marine");
		Unit medican = UnitGet.getUnitByName("Medican");
		marine1.c_scale -= 40;
		System.out.println(marine1);
		System.out.println(medican);
		
		System.out.println("=================1=================");
		medican.skills.get("Medical nanoworm").trigger(medican, marine1);
		System.out.println(marine1);
		System.out.println(medican);
		
		System.out.println("=================2=================");
		marine1.myTurnStart();
		medican.myTurnStart();
		medican.skills.get("Medical nanoworm").trigger(medican, marine1);
		System.out.println(marine1);
		System.out.println(medican);
		
		System.out.println("=================3=================");
		marine1.myTurnStart();
		medican.myTurnStart();
		System.out.println(marine1);
		System.out.println(medican);
		System.out.println("====Emergency====");
		medican.skills.get("Emergency").trigger(medican, marine1);
		System.out.println(marine1);
		System.out.println(medican);
		
	}
	
	public static void main(String[] args) {
		attackTest0();

	}

}
