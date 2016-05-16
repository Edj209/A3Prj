package com.mycompany.a3.gameObjects;

import com.codename1.ui.geom.Point2D;

/**
 * Created by Edgar on 2/23/2016.
 */
public interface IGuided {
    void left();
    void right();
    void up();
    void down();
    void jumpToRandomDog(Point2D dogObjLocation);
    void jumpToRandomCat(Point2D catObjLocation);
}
