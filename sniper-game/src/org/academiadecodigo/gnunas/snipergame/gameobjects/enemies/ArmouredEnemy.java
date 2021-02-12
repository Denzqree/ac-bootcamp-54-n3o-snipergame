package org.academiadecodigo.gnunas.snipergame.gameobjects.enemies;

/**
 * Created by codecadet on 07/10/2020.
 */
public class ArmouredEnemy extends Enemy {

    private int armour;

    public ArmouredEnemy(int health, int bulletDamage, int armour){
        super(health, bulletDamage);
        this.armour = armour;
    }

    @Override
    public void hit(int damage){
        if(armour > 0){
            armour -= damage;
            System.out.println("The enemy took "+damage+" damage to the armour");
        }else {
            System.out.println("No more armour !");
            super.hit(damage);
        }
    }
}
