package com.sifi.test;

import com.sifi.attCalculate.AttTrigger;
import com.sifi.dao.UnitGet;
import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Test {
	
	public static void attackTest0() {
		Unit Beetle = UnitGet.getUnitByName("Fire Beetle");
		Unit Frigate1 = UnitGet.getUnitByName("Battleship");
		Unit Frigate2 = UnitGet.getUnitByName("Battleship");
		
		System.out.println(Beetle);
		System.out.println(Frigate1);
		System.out.println(Frigate2);
		
		System.out.println("=================1=================");
		Beetle.cast("Magma jet", Frigate1);
		Beetle.cast("Magma jet", Frigate2);
		System.out.println(Beetle);
		System.out.println(Frigate1);
		System.out.println(Frigate2);
		
		System.out.println("=================2=================");
		Beetle.myTurnStart();
		Beetle.cast("Magma jet", Frigate2);
		Beetle.cast("Magma jet", Frigate1);
		System.out.println(Beetle);
		System.out.println(Frigate1);
		System.out.println(Frigate2);
		
		
	}
	
	public static void main(String[] args) {
		attackTest0();

	}

}

