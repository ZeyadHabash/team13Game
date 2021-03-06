package model.effects;

import model.world.Champion;

public abstract class Effect implements Cloneable {
    private String name;
    private int duration;
    private EffectType type;


    public Effect(String name, int duration, EffectType type) {
        this.name = name;
        this.duration = duration;
        this.type = type;
    }

	// TODO should we make a listener for effect applied/effect removed??
    public abstract void apply(Champion champion) throws CloneNotSupportedException;

    public abstract void remove(Champion champion) throws CloneNotSupportedException;


    @Override
    public Object clone() throws CloneNotSupportedException {
        Effect clone;
        try {
            clone = (Effect) super.clone();

            clone.duration = duration;
            clone.name = name;
            clone.type = type;
        } catch (CloneNotSupportedException cns) {
            throw new CloneNotSupportedException("Cannot clone this Object");
        }
        return clone;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public EffectType getType() {
        return type;
    }


}
