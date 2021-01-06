package com.sifi.test;

import com.sifi.attCalculate.AttTrigger;
import com.sifi.dao.UnitGet;
import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Test {
	
	public static void attackTest0() {
		Unit Storm = UnitGet.getUnitByName("Storm Chariot");
		Unit Battleship = UnitGet.getUnitByName("Battleship");
		Battleship.shield = 200;
		Battleship.c_shield = 200;
		
		System.out.println(Battleship);
		System.out.println(Storm);
		
		System.out.println("=================1=================");
		Storm.cast("EMP", Battleship);
		System.out.println(Battleship);
		System.out.println(Storm);
		
		System.out.println("=================2=================");
		Battleship.myTurnStart();
		Storm.myTurnStart();
		Storm.cast("EMP", Battleship);
		System.out.println(Battleship);
		System.out.println(Storm);
		
		System.out.println("=================3=================");
		Battleship.myTurnStart();
		Storm.myTurnStart();
		System.out.println(Battleship);
		System.out.println(Storm);
		
		
		
		
	}
	
	public static void main(String[] args) {
		attackTest0();

	}

}

