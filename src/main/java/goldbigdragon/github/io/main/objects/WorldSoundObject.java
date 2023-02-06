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

public class WorldSoundObject {
	
	public int x,y,z, range;
	public SoundObject so;

	public WorldSoundObject(String world, int x, int y, int z, int range, String category, String title, float pitch, int length, long repeatUtc) {
		this.x = x;
		this.y = y;
		this.z = z;
		so = new SoundObject();
		this.so.sid = Long.toString(Main.realUtc - new Random().nextInt(1000));
		this.so.category = category;
		this.so.title = title;
		this.so.pitch = pitch;
		this.so.length = length;
		this.so.repeatUtc = repeatUtc;
	}
}