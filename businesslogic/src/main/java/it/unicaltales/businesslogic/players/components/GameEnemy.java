package it.unicaltales.businesslogic.players.components;

import it.unicaltales.businesslogic.gamecomponents.MyImage;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import it.unicaltales.businesslogic.core.Position;
import it.unicaltales.businesslogic.core.Size;
import it.unicaltales.businesslogic.eventhandlers.HardwareEvents;
import it.unicaltales.businesslogic.eventhandlers.MyKeys;
import it.unicaltales.businesslogic.gameinfo.GlobalValues;

public class GameEnemy extends MyImage{

	boolean move;
	float x;
	
	double v = Math.random();
	
	static float number = (float)(Math.random()*500);
	
	public GameEnemy(String enemyPath) {		
			super(700, number, GlobalValues.SIZE_WINDOW.getWidth() / 10, GlobalValues.SIZE_WINDOW.getHeight()/9, enemyPath);
	}
	
}
