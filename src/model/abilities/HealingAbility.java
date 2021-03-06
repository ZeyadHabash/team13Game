package model.abilities;

import model.world.Damageable;

import java.util.ArrayList;

public class HealingAbility extends Ability{
    private int healAmount;

    public HealingAbility(String name, int cost, int baseCoolDown, int castRange, AreaOfEffect area, int required, int healAmount) {
        super(name, cost, baseCoolDown, castRange, area, required);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public void setHealAmount(int healAmount) {
        this.healAmount = healAmount;
        if(listener != null)
            listener.onAbilityDetailsUpdated(this);
    }

    @Override
    public void execute(ArrayList<Damageable> targets) {
        this.setCurrentCooldown(this.getBaseCooldown());
        for(int i=0; i < targets.size(); i++){
            Damageable a = targets.get(i);
            a.setCurrentHP(a.getCurrentHP() + this.healAmount);       //restores health points to the champion or cover
        }
    }
}
