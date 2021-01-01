package com.sifi.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Unit {
	public String    alias   ;
	public String    name    ;
	public Integer   cost    ;
	
	public Integer   scale   ;
	public Integer   c_scale;
	public Integer   shield  ;
	public Integer   c_shield;
	
	public Integer   uhp     ;
	public Integer   mana    ;
	public Integer   c_mana  ;
	public Integer   speed   ;
	public Character ga      ;
	
	public Integer   armor   ;
	public Character hl      ;
	public Character bm      ;
	
	public Integer   g_lb    ;
	public Integer   g_hb    ;
	public Integer   g_lm    ;
	public Integer   g_hm    ;
	public Integer   g_freq  ;
	public Integer   g_range ;
	
	public Integer   a_lb    ;
	public Integer   a_hb    ;
	public Integer   a_lm    ;
	public Integer   a_hm    ;
	public Integer   a_freq  ;
	public Integer   a_range ;
	
	public Set<Skill> skills  = new HashSet<Skill>();
	
	public Map<String, Integer> attackMap = new HashMap<>();
	
	public Unit() {
		this.attackMap.put("g_lb", this.g_lb);
		this.attackMap.put("g_hb", this.g_hb);
		this.attackMap.put("g_lm", this.g_lm);
		this.attackMap.put("g_hm", this.g_hm);
		this.attackMap.put("a_lb", this.a_lb);
		this.attackMap.put("a_hb", this.a_hb);
		this.attackMap.put("a_lm", this.a_lm);
		this.attackMap.put("a_hm", this.a_hm);
	}
	
	public Unit(Unit target) {
		this.alias    = target.alias   ;
		this.name     = target.name    ;
		this.cost     = target.cost    ;
		
		this.scale    = target.scale   ;
		this.c_scale  = target.scale   ;
		this.shield   = target.shield  ;
		this.c_shield = target.shield  ;
		
		this.uhp      = target.uhp     ;
		this.mana     = target.mana    ;
		this.c_mana   = target.mana    ;
		this.speed    = target.speed   ;
		this.ga       = target.ga      ;
		
		this.armor    = target.armor   ;
		this.hl       = target.hl      ;
		this.bm       = target.bm      ;
		
		this.g_lb     = target.g_lb    ;
		this.g_hb     = target.g_hb    ;
		this.g_lm     = target.g_lm    ;
		this.g_hm     = target.g_hm    ;
		this.g_freq   = target.g_freq  ;
		this.g_range  = target.g_range ;
		
		this.a_lb     = target.a_lb    ;
		this.a_hb     = target.a_hb    ;
		this.a_lm     = target.a_lm    ;
		this.a_hm     = target.a_hm    ;
		this.a_freq   = target.a_freq  ;
		this.a_range  = target.a_range ;
		
		this.skills   = target.skills  ;
		
		this.attackMap.put("g_lb", this.g_lb);
		this.attackMap.put("g_hb", this.g_hb);
		this.attackMap.put("g_lm", this.g_lm);
		this.attackMap.put("g_hm", this.g_hm);
		this.attackMap.put("a_lb", this.a_lb);
		this.attackMap.put("a_hb", this.a_hb);
		this.attackMap.put("a_lm", this.a_lm);
		this.attackMap.put("a_hm", this.a_hm);
	}
	
	public String getBeAttackedType() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.ga);
		sb.append('_');
		sb.append(this.hl);
		sb.append(this.bm);
		return sb.toString();
	}
	
	public Integer getSingleDam(String targetBeAttackedType) {
		return this.attackMap.get(targetBeAttackedType);
	}
	
	public void setAttribute(String attr, Integer dgr) {
		if (attr.equals("scale")) this.c_scale += dgr;
		if (attr.equals("shield")) this.shield += dgr;
		if (attr.equals("uhp")) this.uhp += dgr;
		if (attr.equals("mana")) this.mana += dgr;
		if (attr.equals("speed")) this.speed += dgr;
		if (attr.equals("armor")) this.armor += dgr;
		if (attr.equals("damage")) {
			this.g_lb += dgr;
			this.g_hb += dgr;
			this.g_lm += dgr;
			this.g_hm += dgr;
			this.a_lb += dgr;
			this.a_hb += dgr;
			this.a_lm += dgr;
			this.a_hm += dgr;
		}
		if (attr.equals("freq")) {
			this.g_freq += dgr;
			this.a_freq += dgr;
		}
		if (attr.equals("range")) {
			this.g_range += dgr;
			this.a_range += dgr;
		}
	}


}

























