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
		super.apply(c);
		if(c.isDisarmed())
			return;
		DamagingAbility punch = new DamagingAbility("Punch", 0, 1, 1, AreaOfEffect.SINGLETARGET, 1, 50);
		c.getAbilities().add(punch);
		c.setDisarmed(true);
	}

	@Override
	public void remove(Champion c) throws CloneNotSupportedException {
		super.remove(c);
		ArrayList<Ability> abilitiesList = c.getAbilities();

		for(int i=0;i<c.getAppliedEffects().size();i++)
			if(c.getAppliedEffects().get(i).getName().equals(this.getName()))
				return;

		c.setDisarmed(false);
		for(int i=0;i<abilitiesList.size();i++){
			if(abilitiesList.get(i).getName().equals("Punch")){
				abilitiesList.remove(i);
				return;
			}
		}
	}

	@Override
	public Disarm clone() throws CloneNotSupportedException{
		Disarm clone = null;
		try{
			clone = (Disarm) super.clone();
		}catch (CloneNotSupportedException cns){
			throw new CloneNotSupportedException("Cannot clone this Object");
		}
		return clone;
	}

}
