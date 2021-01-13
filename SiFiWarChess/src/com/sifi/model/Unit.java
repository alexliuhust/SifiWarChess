package com.sifi.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Unit {
	public String    alias   ;
	public String    name    ;
	public Integer   cost    ;
	public Integer   scale   ;
	public Integer   c_scale ;
	public Integer   shield  ;
	public Integer   c_shield;
	public Integer   uhp     ;
	public Integer   c_uhp   ;
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
	public Boolean   g_aoe   ;
	public Integer   a_lb    ;
	public Integer   a_hb    ;
	public Integer   a_lm    ;
	public Integer   a_hm    ;
	public Integer   a_freq  ;
	public Integer   a_range ;
	public Boolean   a_aoe   ;
	
	public Map<String, Skill> skills  = new HashMap<String, Skill>();
	public List<Buff> buffs = new ArrayList<>();
	
	public Unit() {}
	
	public Unit(Unit target) {
		UnitSettingHelper.cloneUnit(this, target);
	}
	
	public String getBeAttackedType() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.ga);
		sb.append('_');
		sb.append(this.hl);
		sb.append(this.bm);
		return sb.toString();
	}
	
	public String getSkillTargetType() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.ga);
		sb.append('_');
		sb.append(this.bm);
		return sb.toString();
	}
	
	public Integer getSingleDam(String targetBeAttackedType) {
		Map<String, Integer> attackMap = new HashMap<>();
		attackMap.put("g_lb", this.g_lb);
		attackMap.put("g_hb", this.g_hb);
		attackMap.put("g_lm", this.g_lm);
		attackMap.put("g_hm", this.g_hm);
		attackMap.put("a_lb", this.a_lb);
		attackMap.put("a_hb", this.a_hb);
		attackMap.put("a_lm", this.a_lm);
		attackMap.put("a_hm", this.a_hm);
		return attackMap.get(targetBeAttackedType);
	}
	
	public void setAttribute(String attr, Integer dgr) {
		UnitSettingHelper.setAttribute(this, attr, dgr);
	}
	
	public void myTurnStart() {
		checkBuffs();
		selfIncreaseShieldAndManaAndColdTime();
	}
	
	public void selfIncreaseShieldAndManaAndColdTime() {
		if (this.c_mana < this.mana) 
			this.c_mana += 10;
		if (this.c_mana > this.mana)
			this.c_mana = this.mana;
		
		if (this.c_shield < this.shield) 
			this.c_shield += 10;
		if (this.c_shield > this.shield)
			this.c_shield = this.shield;
		
		for (Skill skill : this.skills.values()) {
			if (skill.cur_cold_t < skill.cold_t) 
				skill.cur_cold_t++;
		}
	}
	
	public void checkBuffs() {
		if (this.buffs.size() > 0) {
			List<Integer> removeIndexes = new ArrayList<>();
			for (int i = this.buffs.size() - 1; i >= 0; i--) {
				Buff buff = buffs.get(i);
				int num = buff.triggerOrStop();
				if (num == 0) {
					removeIndexes.add(i);
				}
			}
			for (int i : removeIndexes) {
				this.buffs.remove(i);
			}
		}
	}
	
	public void cast(String skillname, Unit target) {
		this.skills.get(skillname).trigger(this, target);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Unit " + name + " " + showHealth() + ", speed=" + speed + "\n");
		if (this.scale == 1) {
			sb.append("     uhp=" + c_uhp + ", mana=" + c_mana + ", armor=" + armor + "\n");
		} else {
			sb.append("     uhp=" + uhp + ", mana=" + c_mana + ", armor=" + armor + "\n");
		}
		
		sb.append("     g_freq=" + g_freq + ", a_freq=" + a_freq + "\n");
		
//		for (Skill sk : this.skills.values()) {
//			sb.append(sk.toString() + "\n");
//		}
//		for (Buff bf : this.buffs) {
//			sb.append(bf.toString() + "\n");
//		}
		return sb.toString();
	}

	public String showHealth() {
		char[] bar = new char[20];
		Arrays.fill(bar, '.');
		String str = "";
		
		// Single Unit
		if (scale == 1) {
			if (shield == 0) {
				int num = this.c_uhp * 20 / this.uhp;
				if (this.c_uhp * 20 % this.uhp != 0) num++;
				
				for (int i = 0; i < num; i++) bar[i] = '|';
				str = "[" + String.valueOf(bar) + "]" + " (" + this.c_uhp + ")";
			} else {
				bar[9] = ']';
				bar[10] = '[';
				
				int num1 = this.c_shield * 9 / this.shield;
				if (this.c_shield * 9 % this.shield != 0) num1++;
				int num2 = this.c_uhp * 9 / this.uhp;
				if (this.c_uhp * 9 % this.uhp != 0) num2++;
				
				for (int i = 0; i < num2; i++) bar[i] = '|';
				for (int i = 11; i < num1 + 11; i++) bar[i] = '!';
				str = "[" + String.valueOf(bar) + "]" + " (" +this.c_uhp + "/" +  this.c_shield+ ")";
			}
			return str;
		}
		
		
		if (shield == 0) {
			int num = this.c_scale * 20 / this.scale;
			if (this.c_scale * 20 % this.scale != 0) num++;
			
			for (int i = 0; i < num; i++) bar[i] = '|';
			str = "[" + String.valueOf(bar) + "]" + " (" + this.c_scale + ")";
		} else {
			bar[9] = ']';
			bar[10] = '[';
			
			int num1 = this.c_shield * 9/ this.shield;
			if (this.c_shield * 9 % this.shield != 0) num1++;
			int num2 = this.c_scale * 9 / this.scale;
			if (this.c_scale * 9 % this.scale != 0) num2++;
			
			for (int i = 0; i < num2; i++) bar[i] = '|';
			for (int i = 11; i < num1 + 11; i++) bar[i] = '!';
			str = "[" + String.valueOf(bar) + "]" + " (" +this.c_scale + "/" +  this.c_shield+ ")";
		}
		
		return str;
	}
}

























