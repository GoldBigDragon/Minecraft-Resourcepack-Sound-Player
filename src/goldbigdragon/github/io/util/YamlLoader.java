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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import goldbigdragon.github.io.main.Main;

public class YamlLoader {
	private FileConfiguration config;
	private File file;
	private Charset defaultCharset = Charset.forName("UTF-8");

	public YamlLoader() {
	}
	
	public YamlLoader(String path) {
		getConfig(path);
	}
	
	public void copyData(YamlLoader source, YamlLoader destination, String sourceDataPath, String destinationPrefix) {
		List<String> sourceKeys = new ArrayList<>();
		sourceKeys.addAll(source.getConfigurationSection(sourceDataPath).getKeys(false));
		checkUnderKyes(source, destination, sourceDataPath, destinationPrefix, sourceKeys);
		destination.saveConfig();
	}
	
	private void checkUnderKyes(YamlLoader source, YamlLoader destination, String sourceDataPath, String destinationPrefix, List<String> keys) {
		List<String> underKeyList = new ArrayList<>();
		for(int count = 0; count < keys.size(); count++)
		{
			if(source.contains(sourceDataPath + "." + keys.get(count)))
			{
				if(source.getConfigurationSection(sourceDataPath + "." + keys.get(count)) == null)
					destination.set(destinationPrefix + "." + keys.get(count), source.get(sourceDataPath + "." + keys.get(count)));
				else
				{
					underKeyList.clear();
					underKeyList.addAll(source.getConfigurationSection(sourceDataPath + "." + keys.get(count)).getKeys(false));
					for(int count2 = 0; count2 < underKeyList.size(); count2++)
						underKeyList.set(count2, keys.get(count) + "." + underKeyList.get(count2));
					checkUnderKyes(source, destination, sourceDataPath, destinationPrefix, underKeyList);
				}
			}
		}
	}
	
	public void getConfig(String path) {
		file = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + path);
		try {
			if (!file.exists()) {
				file.getParentFile().mkdirs();
				file.createNewFile();
			}
		} catch (IOException e) {
			Bukkit.getConsoleSender().sendMessage("§c§l[ x ] main.util.YamlLoader.java 'getConfig()' error!");
		}
		config = YamlConfiguration.loadConfiguration(file);
	}

	public Object get(String path) {
		return this.config.get(path);
	}

	public String getString(String path) {
		return this.config.getString(path);
	}

	public int getInt(String path) {
		return this.config.getInt(path);
	}

	public long getLong(String path) {
		return this.config.getLong(path);
	}

	public boolean getBoolean(String path) {
		return this.config.getBoolean(path);
	}

	public void createSection(String path) {
		this.config.createSection(path);
	}

	public ConfigurationSection getConfigurationSection(String path) {
		return this.config.getConfigurationSection(path);
	}

	public double getDouble(String path) {
		return this.config.getDouble(path);
	}

	@SuppressWarnings("unchecked")
	public List<String> getStringList(String path) {
		return (List<String>) this.config.getList(path);
	}

	public ItemStack getItemStack(String path) {
		return this.config.getItemStack(path);
	}

	public boolean contains(String path) {
		return this.config.contains(path);
	}

	public void removeKey(String path) {
		this.config.set(path, null);
	}

	public void set(String path, Object value) {
		this.config.set(path, value);
	}
	
	public void setSafty(String path, Object value) {
		if(!this.config.contains(path))
			this.config.set(path, value);
	}

	public void saveConfig() {
		try {
			Writer fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), defaultCharset));
			fileWriter.write(config.saveToString());
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			Bukkit.getConsoleSender().sendMessage("§c§l[ x ] main.util.YamlLoader.java [:110] 'saveConfig()' error!");
		}
	}

	public Set<String> getKeys() {
		return this.config.getKeys(false);
	}

	public void delete() {
		if (!(file.exists() && file.delete()))
			Bukkit.getConsoleSender().sendMessage("§c§l[ x ] main.util.YamlLoader.java [:124] 'delete()' error!");
	}

	public void delete(String path) {
		File willDelete = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + path);
		if (willDelete.exists())
			willDelete.delete();
	}
	
	public boolean isExit(String path) {
		return new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + path).exists();
	}
}