package com.sifi.test;

import com.sifi.attCalculate.AttTrigger;
import com.sifi.dao.UnitGet;
import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Test {
	
	public static void attackTest0() {
		Unit Beetle = UnitGet.getUnitByName("Rockhead");
		Unit Beetle2 = UnitGet.getUnitByName("Firecloud");
		Unit Frigate1 = UnitGet.getUnitByName("Destroyer");
		Frigate1.shield = Frigate1.c_shield = 500;
		Unit Frigate2 = UnitGet.getUnitByName("Destroyer");
		Frigate2.shield = Frigate2.c_shield = 500;
//		System.out.println(Beetle);
//		System.out.println(Frigate1);
//		System.out.println(Frigate2);
		
		System.out.println("=================1=================");
		AttTrigger.attackTigger(Beetle, Frigate1);
		System.out.println(Beetle);
		System.out.println(Frigate1);
		
		
		System.out.println("=================2=================");
		AttTrigger.attackTigger(Beetle2, Frigate2);
		System.out.println(Beetle2);
		System.out.println(Frigate2);
		
		
	}
	
	public static void main(String[] args) {
		attackTest0();

	}

}

