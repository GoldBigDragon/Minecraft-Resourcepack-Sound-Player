<a href="../README.md">ð English</a> <a href="README_KO.md">ð íêµ­ì´</a> <a href="README_JP.md">ð æ¥æ¬</a> <a href="README_CN.md">ð ä¸­æ</a> <a href="README_RU.md">ð PÑÑÑÐºÐ¸Ð¹</a>  
# Minecraft Resourcepack Sound Player

<p align="center"><img src="./icon.png" alt="Minecraft Resourcepack Sound Player ã­ã´" height="350"></p>

<a href="https://www.minecraft.net/">Minecraft</a> Resourcepack ã®ä¸­ã®é³æºãã¡ã¤ã«ãåçããã¦ããããã©ã°ã¤ã³ã§ãã

<img src="https://img.shields.io/badge/Java-Spigot%20v1.12.2-red" alt="Spigot 1.12.2ãã¼ã¸ã§ã³ã«åºã¥ãã¦æ§ç¯ããã¦ãã¾ãã">  

---
## å½ä»¤
| ãã¬ã¤ã¹ãã«ãã¼ | æå³ | ä¾ |
|:---:|:---:|:---|
| SoundCategory | ãªã½ã¼ã¹ããã¯ãã£ã¬ã¯ããªã¾ãã¯Minecraftèªä½ãsounds.jsonãã§å®ç¾©ãããcategoryå | blocks  |
| SoundName | ãªã½ã¼ã¹ããã¯ãã£ã¬ã¯ããªã¾ãã¯Minecraftèªä½ãsounds.jsonãã§å®ç¾©ãããkeyå¤ | block.anvil.fall |
| Pitch | åçéåº¦ | 1.2 |
| SoundLength | ç¹°ãè¿ãåçå¨æï¼ç§ï¼ | 120 |
| Repeat | ç¹°ãè¿ãåçãããã©ãã | true |
| KeepRepeatEvenLogout | ã­ã°ã¢ã¦ãå¾ãç¹°ãè¿ãåçãããã©ãã | false |
| RepeatInstantlyWhenLogin | åæ¥ç¶æã«å³åº§ã«ãµã¦ã³ããåçãããã©ãã | false |  

* /rsp list
	```
	èªåã«ç»é²ããããã¬ã¤ãªã¹ããç¢ºèªãã¾ãã
	```
* /rsp lista
	```
	ãã¹ã¦ã®ãã¬ã¼ã¤ã¼ã®ãã¬ã¤ãªã¹ããç¢ºèªãã¾ãã
	```
* /rsp p [PlayerName] [SoundCategory] [SoundName] [Pitch] [SoundLength] [Repeat] [KeepRepeatEvenLogout] [RepeatInstantlyWhenLogin]
	```
	ç¹å®ã®ãã¬ã¼ã¤ã¼ã«ãªã½ã¼ã¹ããã¯ã®ãµã¦ã³ããåçãã¾ãã
	```
* /rsp ps [PlayerName] [SoundCategory] [SoundName]
	```
	ç¹å®ã®ãã¬ã¼ã¤ã¼ã«åçããã¦ãããµã¦ã³ããåæ­¢ãã¾ãã
	```
* /rsp a [SoundCategory] [SoundName] [Pitch] [SoundLength] [Repeat] [KeepRepeatEvenLogout] [RepeatInstantlyWhenLogin]
	```
	ã¿ããªã«ãªã½ã¼ã¹ããã¯ã®ãµã¦ã³ããåçãã¾ãã
	```
* /rsp as [SoundCategory] [SoundName]
	```
	ãã¹ã¦ã«ç¹å®ã®ãµã¦ã³ããåæ­¢ããã¾ãã
	```

### ãã©ã°ã¤ã³ã®ãã¹ãã¨ä½¿ç¨æ¹æ³:
1. ãµã¦ã³ããªã½ã¼ã¹ããã¯ããªãå ´åã¯ã<a href="../bin/(Resourcepack) TestSoundResourcePack.zip">ãã¹ãç¨ãªã½ã¼ã¹ããã¯</a>ããã¦ã³ã­ã¼ããã¦ã```C:/Users/[ã¦ã¼ã¶ã¼å]/AppData /Roaming/.minecraft/resourcepacks``` ãã£ã¬ã¯ããªã«ç§»åãã¾ãã  
<p align="center"><img src="./01 download resourcepack in your directory.png" alt="ãã¹ãç¨ã®ãªã½ã¼ã¹ããã¯ããã¦ã³ã­ã¼ããã¦ãã ããã"></p>  
  
2. <a href="../bin/(Plugin) ResourcepackSoundPlayer.jar">ãã©ã°ã¤ã³</a>ããã¦ã³ã­ã¼ããã¦ã```Cï¼/ [èªåã®Minecraft Serverãã£ã¬ã¯ããª]/plugins```ãã£ã¬ã¯ããªã«ç§»åãã¾ãã  
<p align="center"><img src="./02 download plugin in your directory.png" alt="ãã©ã°ã¤ã³ããã¦ã³ã­ã¼ããã¦ãã ããã"></p>  
  
3. ãµã¼ãã¼ãå®è¡ãã¾ãã  
<p align="center"><img src="./03 start your server.png" alt="ãµã¼ãã¼ãå®è¡ãã¾ãã"></p>  
  
4. ãµã¼ãã¼ã«æ¥ç¶ãã¾ãã  
<p align="center"><img src="./04 login.png" alt="ãµã¼ãã¼ã«æ¥ç¶ãã¦ãã ããã"></p>  
  
5. ç°å¢è¨­å®ã¡ãã¥ã¼ãããªã½ã¼ã¹ããã¯ãé©ç¨ãã¾ãã  
<p align="center"><img src="./05 apply resourcepack.png" alt="ãªã½ã¼ã¹ããã¯ãé©ç¨ãã¦ãã ããã"></p>  
  
6. ã³ãã³ããå¥åãã¦ãªã½ã¼ã¹ããã¯ã®ãµã¦ã³ããåçãã¾ãã

| SoundCategory | SoundName | åºå¸ |
|:---:|:---:|:---|
| master | choir1 | http://peritune.com/j_choir_chant1-3/ |
| master | choir2 | http://peritune.com/j_choir_chant1-3/ |
| master | choir3 | http://peritune.com/j_choir_chant1-3/ |
| master | win | http://peritune.com/j_choir_chant1-3/ |
| master | blade | http://www.hmix.net/music_gallery/feeling/hard.htm |  

[![Watch the video](./06 plugin test.png)](./06 plugin test.mp4)

---

## æ´æ°
| æ¥ä» | åå®¹ | æ´æ°åå®¹ |
|:---:|:---:|:---|
| 2019. 10. 15. | è¿½å  | ãã©ã°ã¤ã³ãéçºããã¾ããã |
| 2021. 08. 05. | è¿½å  | å¨ãã¬ã¤ã¤ã¼ãå¯¾è±¡ã«åçããæ©è½ãè¿½å ããã¾ããã |
| 2021. 08. 05. | è¿½å  | åæ¥ç¶æã«ãç¹°ãè¿ãåçãç¶­æOn/Offãªãã·ã§ã³ãè¿½å ãããã |
| 2021. 08. 05. | è¿½å  | åæ¥ç¶æã«ããã«ç¹°ãè¿ãåçæ©è½ãè¿½å ããã¾ããã |
| 2023. 01. 27. | ä¿®æ­£ | å½ä»¤å¥åæã«çºçããArrayIndexOutOfBoundsExceptionãè§£æ±ºãã¾ããã |  
| 2023. 01. 27. | è¿½å  | å¨ãã¬ã¤ã¤ã¼ã®ãã¬ã¤ãªã¹ããç¢ºèªããæ©è½ãè¿½å ããã¾ããã |  
---

## ç­ç­
ãã®ãã©ã°ã¤ã³ã¯ãã¹ã¯ãªãããã©ã°ã¤ã³ã®ã¦ã¼ã¶ã¼ããªã½ã¼ã¹ããã¯ã®ãµã¦ã³ããé ãã¾ã§åçãããæ¹æ³ãé£ããã¨ããè¨äºãèª­ãã§ãGoldBigDragonãä½æãã¾ããã