package com.sifi.test;

import com.sifi.attCalculate.AttTrigger;
import com.sifi.dao.UnitGet;
import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Test {
	
	public static void attackTest0() {
		Unit Spores = UnitGet.getUnitByName("Toxic Spores");
		Unit Battleship = UnitGet.getUnitByName("Battleship");
		
		System.out.println(Battleship);
		System.out.println(Spores);
		
		System.out.println("=================1=================");
		Spores.cast("Charge", Spores);
		System.out.println(Battleship);
		System.out.println(Spores);
		
		System.out.println("=================2=================");
		Spores.myTurnStart();
		Battleship.myTurnStart();
		Spores.cast("Charge", Spores);
		System.out.println(Battleship);
		System.out.println(Spores);
		
		System.out.println("=================3=================");
		Spores.myTurnStart();
		Battleship.myTurnStart();
		Spores.cast("Blast", Battleship);
		System.out.println(Battleship);
		System.out.println(Spores);
		
		
	}
	
	public static void main(String[] args) {
		attackTest0();

	}

}

