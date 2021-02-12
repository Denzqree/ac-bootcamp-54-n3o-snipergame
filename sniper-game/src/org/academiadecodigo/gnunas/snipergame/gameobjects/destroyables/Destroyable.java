package org.academiadecodigo.gnunas.snipergame.gameobjects.destroyables;

/**
 * Created by codecadet on 0i7/10/2020.
 */
public interface Destroyable {

        void hit(int damage);
        boolean isDestroyed();

}
