<a href="../README.md">π English</a> <a href="README_KO.md">π νκ΅­μ΄</a> <a href="README_JP.md">π ζ₯ζ¬</a> <a href="README_CN.md">π δΈ­ζ</a> <a href="README_RU.md">π PΡΡΡΠΊΠΈΠΉ</a>  
# λ§μΈν¬λννΈ λ¦¬μμ€ν© μ¬μ΄λ νλ μ΄μ΄

<p align="center"><img src="./icon.png" alt="λ§μΈν¬λννΈ λ¦¬μμ€ν© μ¬μ΄λ νλ μ΄μ΄ λ‘κ³ " height="350"></p>

<a href="https://www.minecraft.net/">λ§μΈν¬λννΈ</a> λ¦¬μμ€ν© μ μμ νμΌμ μ¬μμμΌ μ£Όλ νλ¬κ·ΈμΈμλλ€.

<img src="https://img.shields.io/badge/Java-Spigot%20v1.12.2-red" alt="Spigot 1.12.2 λ²μ  κΈ°λ°μΌλ‘ μ μ λ¨.">  

---
## λͺλ Ήμ΄
| νλ μ΄μ€νλ | μλ―Έ | μμκ° |
|:---:|:---:|:---|
| SoundCategory | λ¦¬μμ€ν© λλ ν°λ¦¬ νΉμ λ§μΈν¬λννΈ μμ²΄ sounds.jsonμ μ μλ categoryλͺ | blocks  |
| SoundName | λ¦¬μμ€ν© λλ ν°λ¦¬ νΉμ λ§μΈν¬λννΈ μμ²΄ sounds.jsonμ μ μλ keyκ° | block.anvil.fall |
| Pitch | μ¬μ μλ | 1.2 |
| SoundLength | λ°λ³΅μ¬μ μ£ΌκΈ°(μ΄) | 120 |
| Repeat | λ°λ³΅μ¬μ μ¬λΆ | true |
| KeepRepeatEvenLogout | λ‘κ·Έμμ μ΄νμλ λ°λ³΅μ¬μ μ¬λΆ | false |
| RepeatInstantlyWhenLogin | μ¬μ μ μ μ¦κ° μ¬μ΄λ μ¬μ μ¬λΆ | false |  

* /rsp list
	```
	μμ μκ² λ±λ‘λ νλ μ΄ λ¦¬μ€νΈλ₯Ό νμΈν©λλ€.
	```
* /rsp lista
	```
	λͺ¨λ  νλ μ΄μ΄μ νλ μ΄ λ¦¬μ€νΈλ₯Ό νμΈν©λλ€.
	```
* /rsp p [PlayerName] [SoundCategory] [SoundName] [Pitch] [SoundLength] [Repeat] [KeepRepeatEvenLogout] [RepeatInstantlyWhenLogin]
	```
	νΉμ  νλ μ΄μ΄μκ² λ¦¬μμ€ν© μ¬μ΄λλ₯Ό μ¬μν©λλ€.
	```
* /rsp ps [PlayerName] [SoundCategory] [SoundName]
	```
	νΉμ  νλ μ΄μ΄μκ² μ¬μλκ³  μλ μ¬μ΄λλ₯Ό μ€μ§ μν΅λλ€.
	```
* /rsp a [SoundCategory] [SoundName] [Pitch] [SoundLength] [Repeat] [KeepRepeatEvenLogout] [RepeatInstantlyWhenLogin]
	```
	λͺ¨λμκ² λ¦¬μμ€ν© μ¬μ΄λλ₯Ό μ¬μν©λλ€.
	```
* /rsp as [SoundCategory] [SoundName]
	```
	λͺ¨λμκ² νΉμ  μ¬μ΄λλ₯Ό μ€μ§ μν΅λλ€.
	```

### νλ¬κ·ΈμΈ νμ€νΈ λ° μ¬μ© λ°©λ²:
1. μ¬μ΄λ λ¦¬μμ€ν©μ΄ μμ κ²½μ°, <a href="../bin/(Resourcepack) TestSoundResourcePack.zip">νμ€νΈμ© λ¦¬μμ€ν©</a>μ λ€μ΄λ‘λνμ¬ ```C:/Users/[μ¬μ©μ λͺ]/AppData/Roaming/.minecraft/resourcepacks``` λλ ν°λ¦¬λ‘ μ΄λ μν΅λλ€.  
<p align="center"><img src="./01 download resourcepack in your directory.png" alt="νμ€νΈμ© λ¦¬μμ€ν©μ λ€μ΄λ‘λ λ°μΌμΈμ."></p>  
  
2. <a href="../bin/(Plugin) ResourcepackSoundPlayer.jar">νλ¬κ·ΈμΈ</a>μ λ€μ΄λ‘λνμ¬ ```C:/[λ³ΈμΈμ λ§μΈν¬λννΈ μλ² λλ ν°λ¦¬]/plugins``` λλ ν°λ¦¬λ‘ μ΄λ μν΅λλ€.  
<p align="center"><img src="./02 download plugin in your directory.png" alt="νλ¬κ·ΈμΈμ λ€μ΄λ‘λ λ°μΌμΈμ."></p>  
  
3. μλ²λ₯Ό μ€νμν΅λλ€.  
<p align="center"><img src="./03 start your server.png" alt="μλ²λ₯Ό μ€νμν€μΈμ."></p>  
  
4. μλ²μ μ μν©λλ€.  
<p align="center"><img src="./04 login.png" alt="μλ²μ μ μνμΈμ."></p>  
  
5. νκ²½μ€μ  λ©λ΄μμ λ¦¬μμ€ν©μ μ μ©μν΅λλ€.  
<p align="center"><img src="./05 apply resourcepack.png" alt="λ¦¬μμ€ν©μ μ μ©νμΈμ."></p>  
  
6. λͺλ Ήμ΄λ₯Ό μλ ₯νμ¬ λ¦¬μμ€ν© μ¬μ΄λλ₯Ό μ¬μμμΌλ΄λλ€.

| SoundCategory | SoundName | μΆμ² |
|:---:|:---:|:---|
| master | choir1 | http://peritune.com/j_choir_chant1-3/ |
| master | choir2 | http://peritune.com/j_choir_chant1-3/ |
| master | choir3 | http://peritune.com/j_choir_chant1-3/ |
| master | win | http://peritune.com/j_choir_chant1-3/ |
| master | blade | http://www.hmix.net/music_gallery/feeling/hard.htm |  

[![Watch the video](./06 plugin test.png)](./06 plugin test.mp4)

---

## μλ°μ΄νΈ
| λ μ§ | λ΄μ© | μλ°μ΄νΈ λ΄μ© |
|:---:|:---:|:---|
| 2019. 10. 15. | κΈ°λ₯ μΆκ° | νλ¬κ·ΈμΈμ΄ κ°λ°λ¨. |
| 2021. 08. 05. | κΈ°λ₯ μΆκ° | λͺ¨λ  νλ μ΄μ΄λ₯Ό λμμΌλ‘ μ¬μνλ κΈ°λ₯μ΄ μΆκ°λ¨. |
| 2021. 08. 05. | κΈ°λ₯ μΆκ° | μ¬μ μ μμλ λ°λ³΅ μ¬μμ μ μ§ On/Off μ΅μμ΄ μΆκ°λ¨. |
| 2021. 08. 05. | κΈ°λ₯ μΆκ° | μ¬μ μ μ μ¦μ λ°λ³΅ μ¬μ κΈ°λ₯μ΄ μΆκ°λ¨. |
| 2023. 01. 27. | λ²κ·Έ μμ  | λͺλ Ήμ΄ μλ ₯ μ λ°μνλ ArrayIndexOutOfBoundsExceptionμ ν΄κ²°ν¨. |  
| 2023. 01. 27. | κΈ°λ₯ μΆκ° | λͺ¨λ  νλ μ΄μ΄μ νλ μ΄ λ¦¬μ€νΈλ₯Ό νμΈνλ κΈ°λ₯μ΄ μΆκ°λ¨. |  
---

## κΈ°ν
μ΄ νλ¬κ·ΈμΈμ μ€ν¬λ¦½ν νλ¬κ·ΈμΈ μ¬μ©μκ° λ¦¬μμ€ν© μ¬μ΄λλ₯Ό λ©λ¦¬ κΉμ§ μ¬μ μν€λ λ°©λ²μ΄ λν΄νλ€λ κΈμ μ½κ³  GoldBigDragonμ΄ μ μνμμ΅λλ€.