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

public enum ThreadTypeEnum {
	ASYNC(0),
	ASYNC_REPEAT(1),
	ASYNC_DELAY(2),
	SYNC(3),
	SYNC_REPEAT(4),
	SYNC_DELAY(5);

	public final int threadType;
	
	ThreadTypeEnum(int threadType) {
		this.threadType = threadType;
	}
}