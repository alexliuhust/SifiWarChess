package com.sifi.test;

import com.sifi.attCalculate.AttTrigger;
import com.sifi.model.Unit;

public class Test {
	
	public static void attackTest0() {
		Unit marine1 = new Unit();
		marine1.name            = "Mtarget";
		marine1.scale           = 50    ;
		marine1.c_scale         = 50    ;
		marine1.shield          = 50     ;
		marine1.c_shield        = 50     ;
		marine1.uhp             = 100   ;
		marine1.ga              = 'a'   ;
		marine1.armor           = 0     ;
		marine1.hl              = 'h'   ;
		marine1.bm              = 'm'   ;
		marine1.g_lb            = 6     ;
		marine1.g_hb            = 6     ;
		marine1.g_lm            = 6     ;
		marine1.g_hm            = 6     ;
		marine1.g_freq          = 8     ;
		marine1.a_lb            = 6     ;
		marine1.a_hb            = 6     ;
		marine1.a_lm            = 6     ;
		marine1.a_hm            = 6     ;
		marine1.a_freq          = 8     ;
		
		Unit marine2 = new Unit();
		marine2.name            = "Attacker";
		marine2.scale           = 50    ;
		marine2.c_scale         = 50    ;
		marine2.shield          = 0     ;
		marine2.c_shield        = 0     ;
		marine2.uhp             = 100   ;
		marine2.ga              = 'g'   ;
		marine2.armor           = 0     ;
		marine2.hl              = 'l'   ;
		marine2.bm              = 'b'   ;
		marine2.g_lb            = 6     ;
		marine2.g_hb            = 10     ;
		marine2.g_lm            = 1     ;
		marine2.g_hm            = 1     ;
		marine2.g_freq          = 8     ;
		marine2.a_lb            = 0     ;
		marine2.a_hb            = 0     ;
		marine2.a_lm            = 0     ;
		marine2.a_hm            = 0     ;
		marine2.a_freq          = 8     ;
		
		
		
		marine1.showInfo();
		System.out.println(marine1.getBeAttackedType());
		AttTrigger.attackTigger(marine2, marine1);
		marine1.showInfo();
		AttTrigger.attackTigger(marine2, marine1);
		marine1.showInfo();
		AttTrigger.attackTigger(marine2, marine1);
		marine1.showInfo();
		AttTrigger.attackTigger(marine2, marine1);
		marine1.showInfo();
	}
	
	
	

	public static void main(String[] args) {
		attackTest0();

	}

}
