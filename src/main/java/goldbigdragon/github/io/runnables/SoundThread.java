/*
 * Copyright 2019 GoldBigDragon
 * 
 * GoldBigDragonRPG is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License.

 * This is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package goldbigdragon.github.io.runnables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import goldbigdragon.github.io.main.Main;
import goldbigdragon.github.io.main.objects.SoundObject;
import goldbigdragon.github.io.main.objects.WorldSoundObject;
import goldbigdragon.github.io.util.PlaySound;

public class SoundThread extends BukkitRunnable{

	public static Map<String, List<WorldSoundObject>> worldRepeatMap = new HashMap<>();
	
	@Override
	public void run() {
		List<SoundObject> soList;
		Player player;
		for(String uuid : Main.playerObjects.keySet()) {
			player = Bukkit.getPlayer(UUID.fromString(uuid));
			soList = Main.playerObjects.get(uuid).soundObjectList;
			for(SoundObject so : soList) {
				if(so.repeatUtc < Main.realUtc) {
					so.repeatUtc = Main.realUtc + (so.length * 1000);
					player.playSound(player.getLocation(), so.title, PlaySound.getCategory(so.category), Float.MAX_VALUE, so.pitch);
				}
			}
		}

		if(Main.activateLocationSoundPlayer) {
			List<WorldSoundObject> wsoList;
			World w;
			Location loc;
			for(String world : worldRepeatMap.keySet()) {
				wsoList = worldRepeatMap.get(world);
				for(WorldSoundObject wso : wsoList) {
					if(wso.so.repeatUtc < Main.realUtc) {
						System.out.println(wso.so.category+"."+wso.so.title+ "  " + world+" : " + wso.x+"/"+wso.y+"/"+wso.z + "[" + wso.so.repeatUtc + " / "+ Main.realUtc+"]");
						w = Bukkit.getWorld(world);
						loc = new Location(w, wso.x, wso.y, wso.z);
						wso.so.repeatUtc = Main.realUtc + (wso.so.length*1000);
						w.playSound(loc, wso.so.title, PlaySound.getCategory(wso.so.category), wso.range, wso.so.pitch);
					}
				}
			}
		}
	}
}