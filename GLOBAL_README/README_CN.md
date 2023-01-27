<a href="../README.md">📕 English</a> <a href="README_KO.md">📕 한국어</a> <a href="README_JP.md">📕 日本</a> <a href="README_CN.md">📕 中文</a> <a href="README_RU.md">📕 Pусский</a>  
# Minecraft Resourcepack Sound Player

<p align="center"><img src="./icon.png" alt="Minecraft Resourcepack Sound Player logo" height="350"></p>

此插件播放 <a href="https://www.minecraft.net/">Minecraft</a> 資源包中的聲音文件。  

<img src="https://img.shields.io/badge/Java-Spigot%20v1.12.2-red" alt="基於 Spigot 1.12.2 版本。">  

---
## 命令
| 佔位符 | 意思 | 例子 |
|:---:|:---:|:---|
| SoundCategory | 資源包目錄或 minecraft 本身 'sounds.json' 中定義的類別名稱 | blocks  |
| SoundName | 資源包目錄或 minecraft 本身 'sounds.json' 中定義的鍵值 | block.anvil.fall |
| Pitch | 播放速度 | 1.2 |
| SoundLength | 重複播放週期（秒） | 120 |
| Repeat | 重复与否 | true |
| KeepRepeatEvenLogout | 註銷後是否重複 | false |
| RepeatInstantlyWhenLogin | 登錄後立即播放聲音 | false |  

* /rsp list
	```
	檢查註冊到通話器的播放列表。
	```
* /rsp lista
	```
	檢查所有玩家的播放列表。
	```
* /rsp p [PlayerName] [SoundCategory] [SoundName] [Pitch] [SoundLength] [Repeat] [KeepRepeatEvenLogout] [RepeatInstantlyWhenLogin]
	```
	播放特定播放器的資源包聲音。
	```
* /rsp ps [PlayerName] [SoundCategory] [SoundName]
	```
	停止為特定播放器播放的聲音。
	```
* /rsp a [SoundCategory] [SoundName] [Pitch] [SoundLength] [Repeat] [KeepRepeatEvenLogout] [RepeatInstantlyWhenLogin]
	```
	為所有玩家播放資源包聲音。
	```
* /rsp as [SoundCategory] [SoundName]
	```
	停止為所有玩家播放的聲音。
	```

### 如何測試和使用這個插件：
1. 如果沒有聲音資源包，下載<a href="./bin/(Resourcepack) TestSoundResourcePack.zip">測試資源包</a>到```C:/Users/[user name]/AppData Move it to /Roaming/.minecraft/resourcepacks```目錄。  
<p align="center"><img src="./01 download resourcepack in your directory.png" alt="下載資源包進行測試。"></p>  
  
2. 下載 <a href="./bin/(Plugin) ResourcepackSoundPlayer.jar">插件</a> 並將其移動到```C:/[Your Minecraft server directory]/plugins```目錄。  
<p align="center"><img src="./02 download plugin in your directory.png" alt="下載插件。"></p>  
  
3. 運行您的 Minecraft 服務器。  
<p align="center"><img src="./03 start your server.png" alt="運行服務器。"></p>  
  
4. 登錄到服務器。  
<p align="center"><img src="./04 login.png" alt="登錄到服務器。"></p>  
  
5. 在配置菜單中應用資源包。  
<p align="center"><img src="./05 apply resourcepack.png" alt="應用資源包。"></p>  
  
6. 執行命令播放資源包聲音。

| SoundCategory | SoundName | 著作權 |
|:---:|:---:|:---|
| master | choir1 | http://peritune.com/j_choir_chant1-3/ |
| master | choir2 | http://peritune.com/j_choir_chant1-3/ |
| master | choir3 | http://peritune.com/j_choir_chant1-3/ |
| master | win | http://peritune.com/j_choir_chant1-3/ |
| master | blade | http://www.hmix.net/music_gallery/feeling/hard.htm |  

[![Watch the video](./06 plugin test.png)](./06 plugin test.mp4)

---

## 更新
| 日期 | 工作 | 描述 |
|:---:|:---:|:---|
| 2019. 10. 15. | 添加 | 此插件已創建。 |
| 2021. 08. 05. | 添加 | 向所有播放器播放聲音功能。 |
| 2021. 08. 05. | 添加 | 開/關選項即使在註銷後也能保持重複播放。 |
| 2021. 08. 05. | 添加 | 登錄時即時重播功能。 |
| 2023. 01. 27. | 固定 | 執行命令時發生的 ArrayIndexOutOfBoundsException。 |  
| 2023. 01. 27. | 添加 | 檢查所有播放器的播放列表功能。 |  

---
## 更多細節
這個插件是由 GoldBigDragon 在閱讀腳本插件用戶很難讓資源包聲音播放得更遠之後創建的。