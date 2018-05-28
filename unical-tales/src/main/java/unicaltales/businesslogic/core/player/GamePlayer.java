/**
 * 
 */
package unicaltales.businesslogic.core.player;

import unicaltales.businesslogic.core.Sprite;
import unicaltales.businesslogic.draw.SpriteDraw;
import unicaltales.businesslogic.events.HardwareEvents;
import unicaltales.businesslogic.gamecomponents.MyImage;
import unicaltales.businesslogic.gameinfo.GlobalValues;

/**
 * @author rodolfo
 * This class rapresent a GamePlayer. (When you click play game)
 *
 */
public class GamePlayer extends Player{

	public GamePlayer(SpriteDraw spriteDraw, HardwareEvents hardwareEvents) {
		super(spriteDraw, hardwareEvents);
		
	}

	@Override
	public void manageEvents() {
		
	}

	@Override
	public void onWindowsSizeChange() {
		
	}

	
	
}
