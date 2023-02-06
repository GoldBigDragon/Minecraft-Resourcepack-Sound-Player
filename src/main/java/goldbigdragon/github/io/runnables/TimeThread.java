/*
 * Copyright 2018 GoldBigDragon
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

import java.util.Calendar;

import org.bukkit.scheduler.BukkitRunnable;

import goldbigdragon.github.io.main.Main;

public class TimeThread extends BukkitRunnable {
	int refresh = 0;
	@Override
	public void run() {
		refresh++;
		if(refresh > 600) {
			Main.realUtc = Calendar.getInstance().getTimeInMillis();
			refresh = 0;
		} else {
			Main.realUtc+=100;
		}
	}
}
