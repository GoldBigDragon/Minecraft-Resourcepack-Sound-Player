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

import java.util.Random;

import goldbigdragon.github.io.main.Main;
import goldbigdragon.github.io.util.YamlLoader;

public class SoundObject {
	
	public String sid;
	public String category;
	public String title;
	public float pitch;
	public int length;
	public long repeatUtc;
	public boolean keepRepeatEvenLogout;
	public boolean repeatInstantlyWhenLogin;

	public SoundObject() {
		this.sid = Long.toString(Main.realUtc - new Random().nextInt(1000));
		init(null);
	}
	
	public SoundObject(String category, String title, float pitch, int length, long repeatUtc, boolean keepRepeatEvenLogout, boolean repeatInstantlyWhenLogin) {
		this.sid = Long.toString(Main.realUtc - new Random().nextInt(1000));
		this.category = category;
		this.title = title;
		this.pitch = pitch;
		this.length = length;
		this.repeatUtc = repeatUtc;
		this.keepRepeatEvenLogout = keepRepeatEvenLogout;
		this.repeatInstantlyWhenLogin = repeatInstantlyWhenLogin;
	}

	private void init(String uuid) {
		category = null;
		title = null;
		repeatUtc = -1;
		pitch = 1.0F;
		length = 0;
	}
	
	public void saveAll(YamlLoader yaml, String optionalPath) {
		if (this.keepRepeatEvenLogout) {
			yaml.set(optionalPath + "." + sid + ".Category", this.category);
			yaml.set(optionalPath + "." + sid + ".Title", this.title);
			if (this.repeatInstantlyWhenLogin) {
				yaml.set(optionalPath + "." + sid + ".RepeatUtc", 0);
			} else {
				yaml.set(optionalPath + "." + sid + ".RepeatUtc", this.repeatUtc);	
			}
			yaml.set(optionalPath + "." + sid + ".Pitch", this.pitch);
			yaml.set(optionalPath + "." + sid + ".length", this.length);
			yaml.set(optionalPath + "." + sid + ".IntantPlay", this.repeatInstantlyWhenLogin);	
		}
	}
}