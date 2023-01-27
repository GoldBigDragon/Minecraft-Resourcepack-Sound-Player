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
package goldbigdragon.github.io.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import goldbigdragon.github.io.main.event.PlayerJoin;
import goldbigdragon.github.io.main.event.PlayerQuit;
import goldbigdragon.github.io.main.objects.PlayerObject;
import goldbigdragon.github.io.main.objects.WorldSoundObject;
import goldbigdragon.github.io.runnables.SoundThread;
import goldbigdragon.github.io.runnables.ThreadTypeEnum;
import goldbigdragon.github.io.runnables.TimeThread;
import goldbigdragon.github.io.runnables._RunnableManager;
import goldbigdragon.github.io.util.YamlLoader;

public class Main extends JavaPlugin {

	public static JavaPlugin plugin;
	
	public static Long realUtc = 0L;
	public static List<Player> players = new ArrayList<>();
	public static Map<String, PlayerObject> playerObjects = new HashMap<>();
	public static Map<String, Integer> runnables = new HashMap<>();

	// You need customize "WorldSoundObject.java"
	public static boolean activateLocationSoundPlayer = false;
	
	@Override
	public void onLoad() {
		Main.plugin = this;
		Main.realUtc = Calendar.getInstance().getTimeInMillis();
	  	Bukkit.getConsoleSender().sendMessage("§e§l──────────────────────");
	  	Bukkit.getConsoleSender().sendMessage("§6§l");
	  	Bukkit.getConsoleSender().sendMessage("§e§l　　　　◆"); 
	  	Bukkit.getConsoleSender().sendMessage("§e§l　　　◆　◆");
	  	Bukkit.getConsoleSender().sendMessage("§e§l　　◆　　　◆");
	  	Bukkit.getConsoleSender().sendMessage("§e§l　　　　　◆");
	  	Bukkit.getConsoleSender().sendMessage("§e§l　　　　◆　　　◆");
	  	Bukkit.getConsoleSender().sendMessage("§e§l　　　◆　　　◆　◆");
	  	Bukkit.getConsoleSender().sendMessage("§e§l　　◆　　　◆　　　◆");
	  	Bukkit.getConsoleSender().sendMessage("§e§l　◆　　　◆　　　　　◆");
	  	Bukkit.getConsoleSender().sendMessage("§e§l　　◆　◆　　　　　　　◆");
	  	Bukkit.getConsoleSender().sendMessage("§e§l　　　◆　　　　　　　　　◆");
	  	Bukkit.getConsoleSender().sendMessage("§6§l ResourcepackSoundPlayer");
	  	Bukkit.getConsoleSender().sendMessage("§b§lhttp://goldbigdragon.github.io/");
	  	Bukkit.getConsoleSender().sendMessage("§6§l　　　　");
	  	Bukkit.getConsoleSender().sendMessage("§e§l──────────────────────");
	}
	

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
		getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
		
		List<Player> players = new ArrayList<>();
		players.addAll(Bukkit.getOnlinePlayers());
		String uuid;
		for(Player player : players) {
			uuid = player.getUniqueId().toString();
			players.add(player);
			API.createSoundObject(uuid);
		}
	  	_RunnableManager rm = new _RunnableManager();
		// UTC update (0.1 sec)
	  	rm.addThread(new TimeThread(), ThreadTypeEnum.ASYNC_REPEAT, null, 0, 2);
		// Sound thread (1 sec)
	  	rm.addThread(new SoundThread(), ThreadTypeEnum.ASYNC_REPEAT, null, 0, 20);
	  	
	  	if(activateLocationSoundPlayer) {
			YamlLoader worldYaml = new YamlLoader();
			worldYaml.getConfig("WorldData/worldSound.yml");
			List<String> sids = new ArrayList<>();
			List<String> worlds = new ArrayList<>();
			WorldSoundObject wso;
			String category, title;
			float pitch;
			long repeatUtc;
			int length,x,y,z,range;
			List<WorldSoundObject> wsoList;
			if(!worldYaml.getKeys().isEmpty()) {
				worlds.addAll(worldYaml.getKeys());
				for(String world : worlds) {
					wsoList = new ArrayList<>();
					sids.addAll(worldYaml.getConfigurationSection(world).getKeys(false));
					for(String sid : sids) {
						category = worldYaml.getString(world + "." + sid + ".Category");
						title = worldYaml.getString(world + "." + sid + ".Title");
						repeatUtc = worldYaml.getLong(world + "." + sid + ".RepeatUtc");
						pitch = (float)worldYaml.getDouble(world + "." + sid + ".Pitch");
						length = worldYaml.getInt(world + "." + sid + ".length");
						x = worldYaml.getInt(world + "." + sid + ".x");
						y = worldYaml.getInt(world + "." + sid + ".y");
						z = worldYaml.getInt(world + "." + sid + ".z");
						range = worldYaml.getInt(world + "." + sid + ".range");
						wso = new WorldSoundObject(world, x, y, z, range, category, title, pitch, length, repeatUtc);
						wsoList.add(wso);
					}
					SoundThread.worldRepeatMap.put(world, wsoList);
					worldYaml.removeKey(world);
				}
				worldYaml.saveConfig();
			}
	  	}
	}

	@Override
	public void onDisable() {
		for(PlayerObject po : playerObjects.values()) {
			po.saveAll();
		}
	  	if(activateLocationSoundPlayer) {
			YamlLoader worldYaml = new YamlLoader();
			worldYaml.getConfig("WorldData/worldSound.yml");
			for(String world : SoundThread.worldRepeatMap.keySet()) {
				for(WorldSoundObject wso : SoundThread.worldRepeatMap.get(world)) {
					worldYaml.set(world+"."+wso.so.sid+".x", wso.x);
					worldYaml.set(world+"."+wso.so.sid+".y", wso.y);
					worldYaml.set(world+"."+wso.so.sid+".z", wso.z);
					worldYaml.set(world+"."+wso.so.sid+".range", wso.range);
					wso.so.saveAll(worldYaml, world);
				}	
			}
			worldYaml.saveConfig();
	  	}
	}
	
	@Override
	public boolean onCommand(CommandSender talker, org.bukkit.command.Command command, String string, String[] args) {
		if(string.equals("rsp")) {
			if(talker.isOp()) {
				if(args == null || args.length <= 0 || args.length > 11) {
					API.sendInformation(talker, true, true, true, true, true, false, false);
				} else {
					if(args[0].equals("list")) {
						API.showSoundList(talker);
					} else if(args[0].equals("lista")) {
						API.showAllPlayerSoundList(talker);
					} else if(args[0].equals("p")) {
						API.playSound(talker, args);
					} else if(args[0].equals("ps")) {
						API.stopSound(talker, args);
					} else if(args[0].equals("a")) {
						API.playSoundAll(talker, args);
					} else if(args[0].equals("as")) {
						API.stopSoundAll(talker, args);
					} else if(activateLocationSoundPlayer) {
						if(args[0].equals("l")) {
							API.playLocationSound(talker, args);
						} else if(args[0].equals("ls")) {
							API.stopLocationSound(talker, args);
						}
					}
				}
			} else {
				talker.sendMessage("§c§l[×]§f§l You don't have permission!");
			}
		}
		return false;
	}
}
