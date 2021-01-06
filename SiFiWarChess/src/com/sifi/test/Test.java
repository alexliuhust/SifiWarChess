package com.sifi.test;

import com.sifi.attCalculate.AttTrigger;
import com.sifi.dao.UnitGet;
import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Test {
	
	public static void attackTest0() {
		Unit Marine = UnitGet.getUnitByName("Marine");
		Unit Medican = UnitGet.getUnitByName("Medican");
		Unit Tank = UnitGet.getUnitByName("Siege Tank");
		
		Tank.cast("Siege mode",Tank);
		//Marine.cast("Shield Defense", Marine);
		System.out.println(Tank);
		System.out.println(Marine);
		
		System.out.println("=================1=================");
		AttTrigger.attackTigger(Marine, Tank);
		System.out.println(Tank);
		System.out.println(Marine);
		Medican.cast("Medical nanoworm", Marine);
		System.out.println(Tank);
		System.out.println(Marine);
		System.out.println(Medican);
		
		
		
		
	}
	
	public static void main(String[] args) {
		attackTest0();

	}

}

//singleDamageFromAttacker:40
//totalDamageFromAttacker:2000
//totalDamageFromDefender:0
//singleDamageFromAttacker:69
//totalDamageFromAttacker:3450
//totalDamageFromDefender:0

//singleDamageFromAttacker:350
//totalDamageFromAttacker:3500
//totalDamageFromDefender:0
//singleDamageFromAttacker:399
//totalDamageFromAttacker:3990
//totalDamageFromDefender:0
