<a href="../README.md">📕 English</a> <a href="README_KO.md">📕 한국어</a> <a href="README_JP.md">📕 日本</a> <a href="README_CN.md">📕 中文</a> <a href="README_RU.md">📕 Pусский</a>  
# Minecraft Resourcepack Sound Player

<p align="center"><img src="./icon.png" alt="Minecraft Resourcepack Sound Player logo" height="350"></p>

Этот плагин воспроизводит звуковые файлы в пакетах ресурсов <a href="https://www.minecraft.net/">Minecraft</a>.

<img src="https://img.shields.io/badge/Java-Spigot%20v1.12.2-red" alt="Основано на версии Spigot 1.12.2.">  

---
## Команда
| Placeholder | Mean | Example |
|:---:|:---:|:---|
| SoundCategory | Название категории, определенное в каталоге пакета ресурсов или в самом minecraft 'sounds.json' | blocks  |
| SoundName | Значение ключа, определенное в каталоге пакета ресурсов или в самом minecraft 'sounds.json' | block.anvil.fall |
| Pitch | Скорость воспроизведения | 1.2 |
| SoundLength | Период повторного воспроизведения (секунды) | 120 |
| Repeat | Повторять или нет | true |
| KeepRepeatEvenLogout | Повторять или нет после выхода из системы | false |
| RepeatInstantlyWhenLogin | Воспроизведение звука сразу после входа в систему | false |  

* /rsp list
	```
	Проверьте списки воспроизведения, зарегистрированные для говорящего.
	```
* /rsp lista
	```
	Проверьте плейлисты всех игроков.
	```
* /rsp p [PlayerName] [SoundCategory] [SoundName] [Pitch] [SoundLength] [Repeat] [KeepRepeatEvenLogout] [RepeatInstantlyWhenLogin]
	```
	Воспроизвести звуки пакета ресурсов для определенного игрока.
	```
* /rsp ps [PlayerName] [SoundCategory] [SoundName]
	```
	Останавливает воспроизведение звука для определенного плеера.
	```
* /rsp a [SoundCategory] [SoundName] [Pitch] [SoundLength] [Repeat] [KeepRepeatEvenLogout] [RepeatInstantlyWhenLogin]
	```
	Воспроизвести звуки пакетов ресурсов для всех игроков.
	```
* /rsp as [SoundCategory] [SoundName]
	```
	Останавливает воспроизведение звука у всех игроков
	```

### Как протестировать и использовать этот плагин:
1. Если пакета звуковых ресурсов нет, загрузите <a href="./bin/(Resourcepack) TestSoundResourcePack.zip">тестовый пакет ресурсов</a> в каталог ```C:/Users/[имя пользователя]/AppData/Roaming/.minecraft/resourcepacks```.  
<p align="center"><img src="./01 download resourcepack in your directory.png" alt="Загрузите пакет ресурсов для тестирования."></p>  
  
2. Загрузите <a href="./bin/(Plugin) ResourcepackSoundPlayer.jar">плагин</a> и переместите его в каталог ```C:/[Your Minecraft server directory]/plugins```.  
<p align="center"><img src="./02 download plugin in your directory.png" alt="Загрузите плагин."></p>  
  
3. Запустите свой сервер Minecraft.  
<p align="center"><img src="./03 start your server.png" alt="Запустите сервер."></p>  
  
4. Войдите на сервер.  
<p align="center"><img src="./04 login.png" alt="Войдите на сервер."></p>  
  
5. Примените пакет ресурсов в меню конфигурации.  
<p align="center"><img src="./05 apply resourcepack.png" alt="Примените пакет ресурсов."></p>  
  
6. Выполните команду, чтобы воспроизвести звук пакета ресурсов.

| SoundCategory | SoundName | Авторство |
|:---:|:---:|:---|
| master | choir1 | http://peritune.com/j_choir_chant1-3/ |
| master | choir2 | http://peritune.com/j_choir_chant1-3/ |
| master | choir3 | http://peritune.com/j_choir_chant1-3/ |
| master | win | http://peritune.com/j_choir_chant1-3/ |
| master | blade | http://www.hmix.net/music_gallery/feeling/hard.htm |  

[![Watch the video](./06 plugin test.png)](./06 plugin test.mp4)

---

## Обновлять
| Дата | Работа | Описание |
|:---:|:---:|:---|
| 2019. 10. 15. | ADD | This plugin was created. |
| 2021. 08. 05. | ADD | Play sound to all players function. |
| 2021. 08. 05. | ADD | On/Off option to keep repeat playback even when after logout. |
| 2021. 08. 05. | ADD | Instant replay function when login. |
| 2023. 01. 27. | BUG FIXED | ArrayIndexOutOfBoundsException that occurred when execute a command. |  
| 2023. 01. 27. | ADD | Check all player's playlists function. |  

---
## Подробнее
Этот плагин был создан GoldBigDragon после прочтения того, что пользователям скриптовых плагинов было трудно заставить звуки пакета ресурсов играть далеко.