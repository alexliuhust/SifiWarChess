package com.sifi.model;

public class UnitSettingHelper {
	
	public static void cloneUnit(Unit unit, Unit target) {
		unit.alias    = target.alias   ;
		unit.name     = target.name    ;
		unit.cost     = target.cost    ;
		
		unit.scale    = target.scale   ;
		unit.c_scale  = target.scale   ;
		unit.shield   = target.shield  ;
		unit.c_shield = target.shield  ;
		
		unit.uhp      = target.uhp     ;
		unit.c_uhp    = target.uhp     ;
		unit.mana     = target.mana    ;
		unit.c_mana   = target.mana    ;
		unit.speed    = target.speed   ;
		unit.ga       = target.ga      ;
		
		unit.armor    = target.armor   ;
		unit.hl       = target.hl      ;
		unit.bm       = target.bm      ;
		
		unit.g_lb     = target.g_lb    ;
		unit.g_hb     = target.g_hb    ;
		unit.g_lm     = target.g_lm    ;
		unit.g_hm     = target.g_hm    ;
		unit.g_freq   = target.g_freq  ;
		unit.g_range  = target.g_range ;
		unit.g_aoe    = target.g_aoe   ;
		
		unit.a_lb     = target.a_lb    ;
		unit.a_hb     = target.a_hb    ;
		unit.a_lm     = target.a_lm    ;
		unit.a_hm     = target.a_hm    ;
		unit.a_freq   = target.a_freq  ;
		unit.a_range  = target.a_range ;
		unit.a_aoe    = target.a_aoe   ;
		
		unit.skills   = target.skills  ;
	}

	public static void setAttribute(Unit unit, String attr, Integer dgr) {
		if (attr.equals("scale")) {
			unit.c_scale += dgr;
			if (unit.c_scale > unit.scale)
				unit.c_scale = unit.scale;
			else if (unit.c_scale < 0) unit.c_scale = 0;
		}
		else if (attr.equals("shield")) {
			unit.c_shield += dgr;
			if (unit.c_shield > unit.shield)
				unit.c_shield = unit.shield;
			else if (unit.c_shield < 0) unit.c_shield = 0;
		}
		else if (attr.equals("mana")) {
			unit.c_mana += dgr;
			if (unit.c_mana < 0) unit.c_mana = 0;
			else if (unit.c_mana > unit.mana) unit.c_mana = unit.mana;
		}
		
		else if (attr.equals("uhp")) {
			// If it's a single unit
			if (unit.scale == 1) {
				unit.c_uhp += dgr;
				if (unit.c_uhp > unit.uhp) unit.c_uhp = unit.uhp;
				if (unit.c_uhp <= 0) unit.c_scale = 0;
			}
			else {
				unit.uhp += dgr;
				if (unit.uhp <= 0) unit.uhp = 1;
			}
		}
		
		else if (attr.equals("speed")) {
			unit.speed += dgr;
		}
		else if (attr.equals("armor")) {
			unit.armor += dgr;
		}
		else if (attr.equals("damage")) {
			if (unit.g_lb != 0) unit.g_lb += dgr;
			if (unit.g_hb != 0) unit.g_hb += dgr;
			if (unit.g_lm != 0) unit.g_lm += dgr;
			if (unit.g_hm != 0) unit.g_hm += dgr;
			if (unit.a_lb != 0) unit.a_lb += dgr;
			if (unit.a_hb != 0) unit.a_hb += dgr;
			if (unit.a_lm != 0) unit.a_lm += dgr;
			if (unit.a_hm != 0) unit.a_hm += dgr;
		}
		else if (attr.equals("l")) {
			if (unit.g_lb != 0) unit.g_lb += dgr;
			if (unit.g_lm != 0) unit.g_lm += dgr;
			if (unit.a_lb != 0) unit.a_lb += dgr;
			if (unit.a_lm != 0) unit.a_lm += dgr;
		}
		else if (attr.equals("h")) {
			if (unit.g_hb != 0) unit.g_hb += dgr;
			if (unit.g_hm != 0) unit.g_hm += dgr;
			if (unit.a_hb != 0) unit.a_hb += dgr;
			if (unit.a_hm != 0) unit.a_hm += dgr;
		}
		else if (attr.equals("g")) {
			if (unit.g_lb != 0) unit.g_lb += dgr;
			if (unit.g_hb != 0) unit.g_hb += dgr;
			if (unit.g_lm != 0) unit.g_lm += dgr;
			if (unit.g_hm != 0) unit.g_hm += dgr;
		}
		else if (attr.equals("a")) {
			if (unit.a_lb != 0) unit.a_lb += dgr;
			if (unit.a_hb != 0) unit.a_hb += dgr;
			if (unit.a_lm != 0) unit.a_lm += dgr;
			if (unit.a_hm != 0) unit.a_hm += dgr;
		}
		else if (attr.equals("g_lb")) {
			if (unit.g_lb != 0) unit.g_lb += dgr;
		}
		else if (attr.equals("g_hb")) {
			if (unit.g_hb != 0) unit.g_hb += dgr;
		}
		else if (attr.equals("g_lm")) {
			if (unit.g_lm != 0) unit.g_lm += dgr;
		}
		else if (attr.equals("g_hm")) {
			if (unit.g_hm != 0) unit.g_hm += dgr;
		}
		else if (attr.equals("a_lb")) {
			if (unit.a_lb != 0) unit.a_lb += dgr;
		}
		else if (attr.equals("a_hb")) {
			if (unit.a_hb != 0) unit.a_hb += dgr;
		}
		else if (attr.equals("a_lm")) {
			if (unit.a_lm != 0) unit.a_lm += dgr;
		}
		else if (attr.equals("a_hm")) {
			if (unit.a_hm != 0) unit.a_hm += dgr;
		}
		
		else if (attr.equals("freq")) {
			unit.g_freq += dgr;
			unit.a_freq += dgr;
		}
		else if (attr.equals("g_freq")) {
			unit.g_freq += dgr;
		}
		else if (attr.equals("a_freq")) {
			unit.a_freq += dgr;
		}
		
		else if (attr.equals("range")) {
			if (unit.g_range != 0) unit.g_range += dgr;
			if (unit.a_range != 0) unit.a_range += dgr;
		}
		
		else if (attr.equals("g_aoe")) {
			if (dgr == 1) unit.g_aoe = true;
			else unit.g_aoe = false;
		}
		else if (attr.equals("a_aoe")) {
			if (dgr == 1) unit.a_aoe = true;
			else unit.a_aoe = false;
		}
	}
}
