package com.sifi.test;

import com.sifi.attCalculate.AttTrigger;
import com.sifi.dao.UnitGet;
import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Test {
	
	public static void attackTest0() {
		Unit Marine = UnitGet.getUnitByName("Marine");
		Unit Battleship = UnitGet.getUnitByName("Battleship");
		
		Battleship.cast("Volley",Battleship);
		Battleship.cast("Space jump",Battleship);
		
		Marine.cast("Shield Defense", Marine);
		System.out.println(Battleship);
		System.out.println(Marine);
		
		System.out.println("=================1=================");
		AttTrigger.attackTigger(Marine, Battleship);
		System.out.println(Marine);
		
		Battleship.myTurnStart();
		Marine.myTurnStart();
		Battleship.myTurnStart();
		Marine.myTurnStart();
		Battleship.myTurnStart();
		Marine.myTurnStart();
		Battleship.myTurnStart();
		Marine.myTurnStart();
		System.out.println("=================5=================");
		System.out.println(Battleship);
		System.out.println(Marine);
		
		
		
		
	}
	
	public static void main(String[] args) {
		attackTest0();

	}

}

