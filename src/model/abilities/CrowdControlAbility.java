package model.abilities;

import model.effects.Effect;
import model.world.Champion;
import model.world.Damageable;

import java.util.ArrayList;

public class CrowdControlAbility extends Ability{

    private Effect effect;

    public CrowdControlAbility(String name, int cost, int baseCoolDown, int castRange, AreaOfEffect area, int required, Effect effect) {
        super(name, cost, baseCoolDown, castRange, area, required);
        this.effect = effect;
    }

    public Effect getEffect() {
        return effect;
    }

    @Override
    public void execute(ArrayList<Damageable> targets) throws CloneNotSupportedException {
        this.setCurrentCooldown(this.getBaseCooldown());
        for(int i=0; i < targets.size(); i++){
            Champion champion = (Champion) targets.get(i);
            Effect effect = (Effect)this.effect.clone();
            this.effect.apply(champion);
            champion.getAppliedEffects().add(effect);
        }
    }
}
