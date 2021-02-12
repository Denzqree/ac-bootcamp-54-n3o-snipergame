package org.academiadecodigo.gnunas.snipergame;


import org.academiadecodigo.gnunas.snipergame.gameobjects.GameObject;
import org.academiadecodigo.gnunas.snipergame.gameobjects.SniperRifle;
import org.academiadecodigo.gnunas.snipergame.gameobjects.Tree;
import org.academiadecodigo.gnunas.snipergame.gameobjects.destroyables.Barrel;
import org.academiadecodigo.gnunas.snipergame.gameobjects.destroyables.Destroyable;
import org.academiadecodigo.gnunas.snipergame.gameobjects.enemies.ArmouredEnemy;
import org.academiadecodigo.gnunas.snipergame.gameobjects.enemies.Enemy;
import org.academiadecodigo.gnunas.snipergame.gameobjects.enemies.SoldierEnemy;

import java.util.Arrays;

/**
 * Created by codecadet on 07/10/2020.
 */
public class Game {

    private GameObject[] gameObjects;
    private SniperRifle sniperRifle = new SniperRifle(100, 50);
    private int shotsFired;

    public Game(int numberOfObjects) {
        gameObjects = createObjects(numberOfObjects);
    }

    public void start() {


        //System.out.println(Arrays.toString(gameObjects));


        System.out.println("============================");
        for (GameObject gameObject : gameObjects) {

            System.out.println("----------------------------");
            System.out.println(gameObject.getMessage());
            System.out.println("----------------------------");

            if (gameObject instanceof Destroyable) {

                Destroyable target = (Destroyable) gameObject;

                while (!target.isDestroyed()) {

                    if (!sniperRifle.isDead()) {
                        System.out.println("Sniper is going to shoot at the : " + gameObject.getClass().getSimpleName() + "...");
                        sniperRifle.shoot(target);
                        shotsFired++;
                    } else {
                        return;
                    }
                    if (!target.isDestroyed() && target instanceof Enemy) {
                        Enemy enemy = (Enemy) target;
                        System.out.println("The enemy is shooting back !");
                        enemy.shoot(sniperRifle);
                    }
                }
            }

            System.out.println("============================");
        }
        System.out.println("============================");
        System.out.println(shotsFired + " shots fired during the game !");
        System.out.println("============================");
    }

    public GameObject[] createObjects(int numberOfObjects) {

        GameObject[] objectsCreated = new GameObject[numberOfObjects];

        for (int index = 0; index < objectsCreated.length; index++) {

            int randomObject = (int) Math.floor(Math.random() * 3);

            if (randomObject == 2) {

                int randomEnemy = (int) Math.floor(Math.random() * 2);

                if (randomEnemy < 1) {
                    objectsCreated[index] = new SoldierEnemy(100, 30);
                } else {
                    objectsCreated[index] = new ArmouredEnemy(100, 25, 100);
                }
            } else if (randomObject == 1) {
                objectsCreated[index] = new Tree();
            } else {
                objectsCreated[index] = new Barrel();
            }

            System.out.println("Created object : " + objectsCreated[index].getClass().getSimpleName());
        }

        System.out.println(Arrays.toString(objectsCreated));
        return objectsCreated;

    }
}
