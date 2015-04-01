package com.pilotcraftmc.blockrunner;

/**
 * Handler Class
 * 
 * This class creates an object that holds all of the
 * enemies and the player in a LinkedList,
 * making it easier to render and tick all of the objects.
 * 
 */
 

import java.awt.Graphics;
import java.util.LinkedList;

import com.pilotcraftmc.blockrunner.entities.GameObject;

public class Handler {
	
	//MAIN LinkedList
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	//TICK Method
	public void tick(){
		
		//loops through every object and calls its Tick Method.
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
		
	}
	
	//RENDER Method
	public void render(Graphics g){
		//loops through every object and calls its Render Method.
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	//AddObject - Adds a GameObject to the LinkedList
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	//RemoveObject - Removes a GameObject from the LinkedList.
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
}