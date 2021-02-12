package org.academiadecodigo.gnunas.snipergame.gameobjects.destroyables;

/**
 * Created by codecadet on 07/10/2020.
 */
public enum BarrelType {
    PLASTIC(20),
    WOOD(50),
    METAL(100);

    private int maxDamage;

    BarrelType(int maxDamage){
        this.maxDamage = maxDamage;
    }

    public int getMaxDamage(){
        return this.maxDamage;
    }
}
