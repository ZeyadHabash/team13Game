package model.world;

import java.util.ArrayList;

public class Villain extends Champion {

	public Villain(String name, int maxHP, int mana, int maxActions, int speed, int attackRange, int attackDamage) {
		super(name, maxHP, mana, maxActions, speed, attackRange, attackDamage);
	}

	@Override
	public void useLeaderAbility(ArrayList<Champion> targets) throws CloneNotSupportedException {
		for (int i = 0; i < targets.size(); i++) {
			Champion target = targets.get(i);
				target.setCurrentHP(0);
				target.setCondition(Condition.KNOCKEDOUT);
		}
	}


}
