package org.academiadecodigo.gnunas.snipergame.gameobjects.enemies;

import org.academiadecodigo.gnunas.snipergame.gameobjects.SniperRifle;
import org.academiadecodigo.gnunas.snipergame.gameobjects.GameObject;
import org.academiadecodigo.gnunas.snipergame.gameobjects.destroyables.Destroyable;

/**
 * Created by codecadet on 07/10/2020.
 */
public abstract class Enemy extends GameObject implements Destroyable {
    private int health;
    private boolean isDead;
    private int bulletDamage;
    private final float HIT_PROB = 0.2f;

    public Enemy(int health, int bulletDamage) {
        this.health = health;
        this.isDead = false;
        this.bulletDamage = bulletDamage;
    }

    public boolean isDead() {
        return isDead;
    }

    @Override
    public void hit(int damage) {
        if (this.health <= damage) {
            this.isDead = true;
            System.out.println("The enemy took "+damage+" and is dead");
        } else {
            this.health -= damage;
            System.out.println("The enemy took "+damage+" damage");
        }
    }

    @Override
    public boolean isDestroyed() {
        return isDead;
    }

    public void shoot(SniperRifle sniper){
        if (Math.random() < HIT_PROB) {
            sniper.hit(bulletDamage);
        } else{
            System.out.println("The enemy failed his shot !");
        }
    }

    @Override
    public String getMessage() {
        return "This is an enemy";
    }
}
