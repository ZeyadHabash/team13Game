package model.effects;

import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.DamagingAbility;
import model.world.Champion;

import java.util.ArrayList;

public class Disarm extends Effect {
	
	public Disarm (int duration) {
		super("Disarm", duration, EffectType.DEBUFF);
	}


	@Override
	public void apply(Champion c) throws CloneNotSupportedException {

		DamagingAbility punch = new DamagingAbility("Punch", 0, 1, 1, AreaOfEffect.SINGLETARGET, 1, 50);
		c.getAbilities().add(punch);
	}

	@Override
	public void remove(Champion c) throws CloneNotSupportedException {
		ArrayList<Ability> abilitiesList = c.getAbilities();

		for(int i=0;i<abilitiesList.size();i++){
			if(abilitiesList.get(i).getName().equals("Punch")){
				abilitiesList.remove(i);
				return;
			}
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException{
		Disarm clone;
		try{
			clone = (Disarm) super.clone();
		}catch (CloneNotSupportedException cns){
			throw new CloneNotSupportedException("Cannot clone this Object");
		}
		return clone;
	}

}
