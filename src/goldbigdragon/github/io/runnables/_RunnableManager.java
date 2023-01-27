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

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import goldbigdragon.github.io.main.Main;

public class _RunnableManager {

	public void addThread(BukkitRunnable runnable, ThreadTypeEnum type, String customName, long delay, long repeatTick)
	{
		if(customName == null)
			customName = runnable.getClass().getName();
		if(!Main.runnables.containsKey(customName))
		{
			if(type == ThreadTypeEnum.ASYNC)
				runnable.runTaskAsynchronously(Main.plugin);
			else if(type == ThreadTypeEnum.ASYNC_REPEAT)
				runnable.runTaskTimerAsynchronously(Main.plugin, delay, repeatTick);
			else if(type == ThreadTypeEnum.ASYNC_DELAY)
				runnable.runTaskLaterAsynchronously(Main.plugin, delay);
			else if(type == ThreadTypeEnum.SYNC)
				runnable.runTask(Main.plugin);
			else if(type == ThreadTypeEnum.SYNC_REPEAT)
				runnable.runTaskTimer(Main.plugin, delay, repeatTick);
			else if(type == ThreadTypeEnum.SYNC_DELAY)
				runnable.runTaskLater(Main.plugin, delay);
			Main.runnables.put(customName, runnable.getTaskId());
		}
	}
	
	public void removeThread(String runnableName)
	{
		if(Main.runnables.containsKey(runnableName))
		{
			int taskId = Main.runnables.get(runnableName);
			Bukkit.getServer().getScheduler().cancelTask(taskId);
			Main.runnables.remove(runnableName);
		}
	}
}
