package org.academiadecodigo.gnunas.snipergame.gameobjects.destroyables;

import org.academiadecodigo.gnunas.snipergame.gameobjects.GameObject;

/**
 * Created by codecadet on 07/10/2020.
 */
public class Barrel extends GameObject implements Destroyable {
    private BarrelType barrelType;
    private int currentDamage;
    private boolean destroyed;

    public Barrel(){
        BarrelType[] barrelTypes = BarrelType.values();
        BarrelType randomBarrelType = barrelTypes[(int) Math.random()*barrelTypes.length];
        switch(randomBarrelType){
            case PLASTIC:
                this.barrelType = BarrelType.PLASTIC;
            case WOOD:
                this.barrelType = BarrelType.WOOD;
            case METAL:
                this.barrelType = BarrelType.METAL;
        }
    }

    @Override
    public void hit(int damage){
        if(this.currentDamage >= barrelType.getMaxDamage()){
            this.destroyed = true;
            this.currentDamage = barrelType.getMaxDamage();
            System.out.println("Barrel has been destroyed !");
        }else{
            this.currentDamage += damage;
            System.out.println("Barrel has taken "+damage+" damage.");
        }
    }

    @Override
    public boolean isDestroyed(){
        return destroyed;
    }

    public String getMessage(){
        return "This is a "+barrelType+" type of barrel";
    }
}
