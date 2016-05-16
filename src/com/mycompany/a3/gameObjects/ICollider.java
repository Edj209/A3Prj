package com.mycompany.a3.gameObjects;

import com.mycompany.a3.GameObject;

public interface ICollider {
	public boolean collidesWith(GameObject otherObject);
	public void handleCollision(ICollider otherObject);

}
