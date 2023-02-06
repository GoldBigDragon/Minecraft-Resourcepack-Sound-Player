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
package goldbigdragon.github.io.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.SoundCategory;
import org.bukkit.World;
import org.bukkit.entity.Player;

import goldbigdragon.github.io.main.Main;
import goldbigdragon.github.io.main.objects.SoundObject;
import goldbigdragon.github.io.main.objects.WorldSoundObject;
import goldbigdragon.github.io.runnables.SoundThread;

public class PlaySound {

	public static void play(UUID uuid, String category, String title, float pitch, int soundLength, boolean repeat, boolean keepRepeatEvenLogout, boolean repeatInstantlyWhenLogin) {
		Player player = Bukkit.getPlayer(uuid);
		if(player != null && player.isOnline()) {
			play(player, category, title, pitch, soundLength, repeat, keepRepeatEvenLogout, repeatInstantlyWhenLogin);
		}
	}
	
	public static void play(String playerName, String category, String title, float pitch, int soundLength, boolean repeat, boolean keepRepeatEvenLogout, boolean repeatInstantlyWhenLogin) {
		Player player = Bukkit.getPlayer(playerName);
		if(player != null && player.isOnline()) {
			play(player, category, title, pitch, soundLength, repeat, keepRepeatEvenLogout, repeatInstantlyWhenLogin);
		}
	}
	
	private static void play(Player player, String category, String title, float pitch, int soundLength, boolean repeat, boolean keepRepeatEvenLogout, boolean repeatInstantlyWhenLogin) {
		List<SoundObject> soList = Main.playerObjects.get(player.getUniqueId().toString()).soundObjectList;
		boolean isExist = false;
		if(!soList.isEmpty()) {
			for(SoundObject so : soList) {
				if(so.category.equals(category) && so.title.equals(title)) {
					isExist = true;
					break;
				}
			}	
		}
		if(!isExist) {
			player.playSound(player.getLocation(), title, getCategory(category), Float.MAX_VALUE, pitch);
			if(repeat) {
				soList.add(new SoundObject(category, title, pitch, soundLength, Main.realUtc + (soundLength * 1000), keepRepeatEvenLogout, repeatInstantlyWhenLogin));
			}
		}
	}

	public static void play(String worldName, int x, int y, int z, String category, String title, float pitch, int soundLength, int range, boolean repeat) {
		World world = Bukkit.getWorld(worldName);
		Location loc = new Location(world, x, y, z);
		List<WorldSoundObject> wsoList;
		if(SoundThread.worldRepeatMap.containsKey(worldName))
			wsoList = SoundThread.worldRepeatMap.get(worldName);
		else
			wsoList = new ArrayList<>();
		boolean isExist = false;
		if(!wsoList.isEmpty()) {
			for(WorldSoundObject wso : wsoList) {
				if(wso.so.category.equals(category) && wso.so.title.equals(title)) {
					isExist = true;
					break;
				}
			}
		}
		if(!isExist) {
			world.playSound(loc, title, getCategory(category), range, pitch);
			if(repeat) {
				wsoList.add(new WorldSoundObject(worldName, x, y, z, range, category, title, pitch, soundLength, Main.realUtc + (soundLength * 1000)));
				SoundThread.worldRepeatMap.remove(worldName);
				SoundThread.worldRepeatMap.put(worldName, wsoList);
			}
		}
	}

	public static void stop(String playerName, String category, String title) {
		Player player = Bukkit.getPlayer(playerName);
		if(player != null && player.isOnline()) {
			stop(player, category, title);
		}
	}
	
	public static void stop(UUID uuid, String category, String title) {
		Player player = Bukkit.getPlayer(uuid);
		if(player != null && player.isOnline()) {
			stop(player, category, title);
		}
	}

	private static void stop(Player player, String category, String title) {
		List<SoundObject> soList = Main.playerObjects.get(player.getUniqueId().toString()).soundObjectList;
		SoundObject so;
		for(int count = 0; count < soList.size(); count++) {
			so = soList.get(count);
			if(so.category.equals(category) && so.title.equals(title)) {
				soList.remove(count);
				break;
			}
		}
		player.stopSound(title, getCategory(category));
	}

	public static void stopLocation(String worldName, String category, String title) {
		List<WorldSoundObject> wsoList = SoundThread.worldRepeatMap.get(worldName);
		for(int count = 0; count < wsoList.size(); count++) {
			if(wsoList.get(count).so.category.equals(category) && wsoList.get(count).so.title.equals(title)) {
				wsoList.remove(count);
				break;
			}
		}
		SoundThread.worldRepeatMap.remove(worldName);
		SoundThread.worldRepeatMap.put(worldName, wsoList);
	}

	public static SoundCategory getCategory(String category) {
		category = category.toUpperCase();
		for(SoundCategory soundCategory : SoundCategory.values()) {
			if(soundCategory.name().equals(category)) {
				return soundCategory;
			}
		}
		return SoundCategory.MASTER;
	}
}