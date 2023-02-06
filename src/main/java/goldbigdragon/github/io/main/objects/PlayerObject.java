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
package goldbigdragon.github.io.main.objects;

import java.util.ArrayList;
import java.util.List;

import goldbigdragon.github.io.util.YamlLoader;

public class PlayerObject {
	
	public String uuid;
	public List<SoundObject> soundObjectList;
	
	public PlayerObject(String playerUuid) {
		this.uuid = playerUuid;
		this.soundObjectList = new ArrayList<>();
		init();
	}
	
	private void init() {
		YamlLoader userYaml = new YamlLoader();
		userYaml.getConfig("UserData/" + uuid + "/statistic.yml");
		List<String> sids = new ArrayList<>();
		if(userYaml.contains("ResourcepackSoundPlayer")) {
			sids.addAll(userYaml.getConfigurationSection("ResourcepackSoundPlayer").getKeys(false));
			SoundObject so;
			String category, title;
			float pitch;
			long repeatUtc;
			int length;
			boolean instantPlay;
			for(String sid : sids) {
				category = userYaml.getString("ResourcepackSoundPlayer." + sid + ".Category");
				title = userYaml.getString("ResourcepackSoundPlayer." + sid + ".Title");
				repeatUtc = userYaml.getLong("ResourcepackSoundPlayer." + sid + ".RepeatUtc");
				pitch = (float)userYaml.getDouble("ResourcepackSoundPlayer." + sid + ".Pitch");
				length = userYaml.getInt("ResourcepackSoundPlayer." + sid + ".length");
				instantPlay = userYaml.getBoolean("ResourcepackSoundPlayer." + sid + ".IntantPlay");
				so = new SoundObject(category, title, pitch, length, repeatUtc, true, instantPlay);
				soundObjectList.add(so);
			}
			userYaml.removeKey("ResourcepackSoundPlayer");
			userYaml.saveConfig();
		}
	}
	
	public void saveAll() {
		YamlLoader userYaml = new YamlLoader();
		userYaml.getConfig("UserData/" + uuid + "/statistic.yml");
		for(SoundObject so : soundObjectList) {
			so.saveAll(userYaml, "ResourcepackSoundPlayer");
		}
		userYaml.saveConfig();
	}
}