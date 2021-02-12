package org.academiadecodigo.gnunas.snipergame.gameobjects;

import org.academiadecodigo.gnunas.snipergame.gameobjects.destroyables.Destroyable;

/**
 * Created by codecadet on 07/10/2020.
 */
public class SniperRifle {

    private int health;
    private int bulletDamage;
    private boolean isDead;
    private final float HIT_PROB = 0.3f;

    public SniperRifle(int health, int bulletDamage){
        this.health = health;
        this.bulletDamage = bulletDamage;
        this.isDead = false;
    }

    public boolean isDead() {
        return isDead;
    }

    public void shoot(Destroyable target) {
        if (Math.random() < HIT_PROB) {
            target.hit(bulletDamage);
        } else{
            System.out.println("Shot failed !");
        }
    }

    public void hit(int damage){
        if(this.health <= damage) {
            this.health = 0;
            System.out.println("You took "+damage+" damage from the enemy !");
            System.out.println("Current health is "+health);
            this.isDead = true;
            System.out.println("GAME OVER ! You're DEAD !");
        }else{
            this.health -= damage;
            System.out.println("You took "+damage+" damage from the enemy !");
            System.out.println("Current health is "+health);
        }
    }

}
