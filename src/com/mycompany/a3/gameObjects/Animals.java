package com.mycompany.a3.gameObjects;

import com.mycompany.a3.GameObject;

/**
 * Created by Edgar on 2/23/2016.
 */
public abstract class Animals extends GameObject implements IMoving {
    double speed;
    int direction;
    int unchangableSize;
}
