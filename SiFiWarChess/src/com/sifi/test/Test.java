package com.sifi.test;

import com.sifi.model.Skill;
import com.sifi.model.Unit;

public class Test {
	
	public static void MarineSwitchTest() {
		
		Skill Shield = new Skill();
		Shield.skill      =  "Shield Defense";
		Shield.type       =  "switch";
		Shield.period     =  -1;
		Shield.tar_type   =  "n";
		Shield.manacost   =  0;
		Shield.cold_t     =  2;
		Shield.cur_cold_t =  2;
		Shield.setAttributes("armor/speed");
		Shield.setDegree("5/-1");
		
		Unit marine = new Unit();
		marine.name            = "Marine";
		marine.cost            = 100   ;
		marine.scale           = 50    ;
		marine.c_scale         = 50    ;
		marine.shield          = 0     ;
		marine.c_shield        = 0     ;
		marine.uhp             = 100   ;
		marine.mana            = 0     ;
		marine.c_mana          = 0     ;
		marine.speed           = 4     ;
		marine.ga              = 'g'   ;
		marine.armor           = 0     ;
		marine.hl              = 'l'   ;
		marine.bm              = 'b'   ;
		marine.g_lb            = 6     ;
		marine.g_hb            = 6     ;
		marine.g_lm            = 6     ;
		marine.g_hm            = 6     ;
		marine.g_freq          = 8     ;
		marine.g_range         = 4     ;
		marine.a_lb            = 6     ;
		marine.a_hb            = 6     ;
		marine.a_lm            = 6     ;
		marine.a_lm            = 6     ;
		marine.a_freq          = 8     ;
		marine.a_range         = 4     ;
		
		marine.skills.add(Shield);
		
		int turn = 6;
		System.out.println(marine);
		Shield.showinfo();
		
		for (int i = 1; i <= turn; i++) {
			System.out.println("\n\n==================TURN : " + i + " ==================");
			marine.myTurnStart();
			Shield.trigger(marine, marine);
			System.out.println(marine);
			Shield.showinfo();
		}
	}
	
	public static void MarineContinuousTest() {
		Skill Adrenaline = new Skill();
		Adrenaline.skill      =  "Adrenaline";
		Adrenaline.type       =  "continuous";
		Adrenaline.period     =  2;
		Adrenaline.tar_type   =  "self";
		Adrenaline.manacost   =  0;
		Adrenaline.cold_t     =  4;
		Adrenaline.cur_cold_t =  4;
		Adrenaline.setAttributes("uhp/speed/freq");
		Adrenaline.setDegree("-20/1/2");
		
		Unit marine = new Unit();
		marine.name            = "Marine";
		marine.cost            = 100   ;
		marine.scale           = 50    ;
		marine.c_scale         = 50    ;
		marine.shield          = 0     ;
		marine.c_shield        = 0     ;
		marine.uhp             = 100   ;
		marine.mana            = 0     ;
		marine.c_mana          = 0     ;
		marine.speed           = 4     ;
		marine.ga              = 'g'   ;
		marine.armor           = 0     ;
		marine.hl              = 'l'   ;
		marine.bm              = 'b'   ;
		marine.g_lb            = 6     ;
		marine.g_hb            = 6     ;
		marine.g_lm            = 6     ;
		marine.g_hm            = 6     ;
		marine.g_freq          = 8     ;
		marine.g_range         = 4     ;
		marine.a_lb            = 6     ;
		marine.a_hb            = 6     ;
		marine.a_lm            = 6     ;
		marine.a_lm            = 6     ;
		marine.a_freq          = 8     ;
		marine.a_range         = 4     ;
		
		marine.skills.add(Adrenaline);
		
		int turn = 8;
		System.out.println(marine);
		
		for (int i = 1; i <= turn; i++) {
			System.out.println("\n\n==================TURN : " + i + " ==================");
			
			Adrenaline.showinfo();
			Adrenaline.trigger(marine, marine);
			
			marine.myTurnStart();
			
			System.out.println(marine);
		}
	}
	

	public static void main(String[] args) {
		MarineContinuousTest();

	}

}
