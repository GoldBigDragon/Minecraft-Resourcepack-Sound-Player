package goldbigdragon.github.io.main;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import goldbigdragon.github.io.main.objects.PlayerObject;
import goldbigdragon.github.io.main.objects.SoundObject;
import goldbigdragon.github.io.util.NumericUtil;
import goldbigdragon.github.io.util.PlaySound;

public class API {
	public static boolean createSoundObject(String playerUuid) {
		PlayerObject playerObject = new PlayerObject(playerUuid);
		Main.playerObjects.put(playerUuid, playerObject);
		return true;
	}
	
	public static boolean removeSoundObject(String playerUuid) {
		PlayerObject playerObject = Main.playerObjects.get(playerUuid);
		playerObject.saveAll();
		Main.playerObjects.remove(playerUuid);
		return true;
	}

	public static void showSoundList(CommandSender talker) {
		if(talker instanceof Player) {
			List<SoundObject> soList = Main.playerObjects.get(((Player)talker).getUniqueId().toString()).soundObjectList;
			talker.sendMessage("§6§l===Play List===");
			for(int count = 0; count < soList.size(); count++) {
				talker.sendMessage("§7§l[" + count + "] " + soList.get(count).category+"."+soList.get(count).title);
			}
			talker.sendMessage("§6§l===Play List===");	
		} else {
			talker.sendMessage("§c§l[×]§f§l This command is for player use only!");
		}
	}
	
	public static void showAllPlayerSoundList(CommandSender talker) {
		talker.sendMessage("§6§l===Play List===");
		for(Player player : Main.players) {
			String uuid = player.getUniqueId().toString();
			if(Main.playerObjects.containsKey(uuid)) {
				List<SoundObject> soList = Main.playerObjects.get(uuid).soundObjectList;
				talker.sendMessage("§e§l" + player.getDisplayName());
				for(int count = 0; count < soList.size(); count++) {
					talker.sendMessage("§7§l  [" + count + "] " + soList.get(count).category+"."+soList.get(count).title);
				}	
			}
		}
		talker.sendMessage("§6§l===Play List===");
	}
	
	public static void playSound(CommandSender talker, String[] args) {
		if(args.length == 9) {
			if(pitchCheck(talker, args[4]) && lengthCheck(talker, args[5])) {
				PlaySound.play(args[1], args[2], args[3], Float.parseFloat(args[4]), Integer.parseInt(args[5]), Boolean.parseBoolean(args[6]), Boolean.parseBoolean(args[7]), Boolean.parseBoolean(args[8]));
			}
		} else {
			sendInformation(talker, false, true, false, false, false, false, false);
		}
	}
	
	public static void stopSound(CommandSender talker, String[] args) {
		if(args.length == 4) {
			PlaySound.stop(args[1], args[2], args[3]);
		} else {
			sendInformation(talker, false, false, true, false, false, false, false);
		}
	}

	public static void playSoundAll(CommandSender talker, String[] args) {
		if(args.length == 8) {
			if(pitchCheck(talker, args[3]) && lengthCheck(talker, args[4])) {
				for(Player player : Main.players) {
					PlaySound.play(player.getName(), args[1], args[2], Float.parseFloat(args[3]), Integer.parseInt(args[4]), Boolean.parseBoolean(args[5]), Boolean.parseBoolean(args[6]), Boolean.parseBoolean(args[7]));
				}
			}
		} else {
			sendInformation(talker, false, false, false, true, false, false, false);
		}
	}
	
	public static void stopSoundAll(CommandSender talker, String[] args) {
		if(args.length == 3) {
			for(Player player : Main.players) {
				PlaySound.stop(player.getName(), args[1], args[2]);
			}
		} else {
			sendInformation(talker, false, false, false, false, true, false, false);
		}
	}

	public static void playLocationSound(CommandSender talker, String[] args) {
		if(args.length == 11) {
			if(pitchCheck(talker, args[7]) && locationCheck(talker, args[2]) && locationCheck(talker, args[3]) && locationCheck(talker, args[4]) && lengthCheck(talker, args[8]) && rangeCheck(talker, args[9])) {
				PlaySound.play(args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), args[5], args[6], Float.parseFloat(args[7]), Integer.parseInt(args[8]), Integer.parseInt(args[9]), Boolean.parseBoolean(args[10]));
			}
		} else if(args.length == 10) {
			if(pitchCheck(talker, args[7]) && locationCheck(talker, args[2]) && locationCheck(talker, args[3]) && locationCheck(talker, args[4]) && lengthCheck(talker, args[8]) && rangeCheck(talker, args[9])) {
				PlaySound.play(args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), args[5], args[6], Float.parseFloat(args[7]), Integer.parseInt(args[8]), Integer.parseInt(args[9]), false);
			}
		} else {
			sendInformation(talker, false, false, false, false, false, true, false);
		}
	}
	
	public static void stopLocationSound(CommandSender talker, String[] args) {
		if(args.length == 4) {
			PlaySound.stopLocation(args[1], args[2], args[3]);
		} else {
			sendInformation(talker, false, false, false, false, false, false, true);
		}
	}
	
	public static void sendInformation(CommandSender talker, boolean list, boolean playerPlay, boolean playerStop, boolean allPlay, boolean allStop, boolean locationPlay, boolean locationStop) {
		talker.sendMessage("§6§l===Resourcepack Sound Player===");
		talker.sendMessage("§2§lSoundCategory : MASTER/AMBIENT/BLOCKS/...");
		if(playerPlay || allPlay || locationPlay) {
			talker.sendMessage("§2§lPitch : 0.5 ~ 2.0");
			talker.sendMessage("§2§lSoundLength : 0 ~ " + Integer.MAX_VALUE + " (Seconds)");
			if(Main.activateLocationSoundPlayer) {
				talker.sendMessage("§2§lRange : 0 ~ " + Integer.MAX_VALUE + " (Blocks)");
			}
			talker.sendMessage("§2§lRepeat : TRUE/FALSE");	
		}
		if(list) {
			talker.sendMessage("§e§l/rsp list");
			talker.sendMessage("§8자신에게 등록된 플레이 리스트를 확인합니다.");
			talker.sendMessage("§e§l/rsp lista");
			talker.sendMessage("§8모든 플레이어의 플레이 리스트를 확인합니다.");
		}
		if(playerPlay) {
			talker.sendMessage("§e§l/rsp p §7§l[PlayerName] [SoundCategory] [SoundName] [Pitch] [SoundLength] [Repeat] [KeepRepeatEvenLogout] [RepeatInstantlyWhenLogin]");
			talker.sendMessage("§8특정 플레이어에게 리소스팩 사운드를 재생합니다.");
		}
		if(playerStop) {
			talker.sendMessage("§e§l/rsp ps §7§l[PlayerName] [SoundCategory] [SoundName]");
			talker.sendMessage("§8특정 플레이어에게 리소스팩 사운드를 중지 시킵니다.");
		}
		if(allPlay) {
			talker.sendMessage("§e§l/rsp a §7§l[SoundCategory] [SoundName] [Pitch] [SoundLength] [Repeat] [KeepRepeatEvenLogout] [RepeatInstantlyWhenLogin]");
			talker.sendMessage("§8모두에게 리소스팩 사운드를 재생합니다.");	
		}
		if(allStop) {
			talker.sendMessage("§e§l/rsp as §7§l[SoundCategory] [SoundName]");
			talker.sendMessage("§8모두에게 리소스팩 사운드를 중지 시킵니다.");	
		}
		if(locationPlay) {
			talker.sendMessage("§e§l/rsp l §7§l[World] [X] [Y] [Z] [SoundCategory] [SoundName] [Pitch] [SoundLength] [Range] <Repeat>");
			talker.sendMessage("§8특정 장소에 리소스팩 사운드를 재생합니다.");
		}
		if(locationStop) {
			talker.sendMessage("§e§l/rsp ls §7§l[World] [SoundCategory] [SoundName]");
			talker.sendMessage("§8특정 월드에 울리는 리소스팩 사운드의 반복을 중단합니다. (현재 재생 중인 사운드는 중단되지 않습니다)");
		}
		talker.sendMessage("§6§l===Resourcepack Sound Player===");
	}
	
	private static boolean pitchCheck(CommandSender talker, String value) {
		if(NumericUtil.isFloat(value, 0.5F, 2.0F)) {
			return true;
		} else {
			talker.sendMessage("§c§l[×]§f§l [Pitch] value must 0.5 ~ 2.0!");
			return false;
		}
	}
	
	private static boolean lengthCheck(CommandSender talker, String value) {
		if(NumericUtil.isInteger(value, 0, Integer.MAX_VALUE)) {
			return true;
		} else {
			talker.sendMessage("§c§l[×]§f§l [SoundLength] value must 0 ~ " + Integer.MAX_VALUE + "!");
			return false;
		}
	}
	
	private static boolean rangeCheck(CommandSender talker, String value) {
		if(NumericUtil.isInteger(value, 0, Integer.MAX_VALUE)) {
			return true;
		} else {
			talker.sendMessage("§c§l[×]§f§l [Range] value must 0 ~ " + Integer.MAX_VALUE + "!");
			return false;
		}
	}

	private static boolean locationCheck(CommandSender talker, String value) {
		if(NumericUtil.isInteger(value, 0, Integer.MAX_VALUE)) {
			return true;
		} else {
			talker.sendMessage("§c§l[×]§f§l X/Y/Z location value must " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE + "!");
			return false;
		}
	}
}
