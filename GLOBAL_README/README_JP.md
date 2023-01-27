<a href="../README.md">📕 English</a> <a href="README_KO.md">📕 한국어</a> <a href="README_JP.md">📕 日本</a> <a href="README_CN.md">📕 中文</a> <a href="README_RU.md">📕 Pусский</a>  
# Minecraft Resourcepack Sound Player

<p align="center"><img src="./icon.png" alt="Minecraft Resourcepack Sound Player ロゴ" height="350"></p>

<a href="https://www.minecraft.net/">Minecraft</a> Resourcepack の中の音源ファイルを再生させてくれるプラグインです。

<img src="https://img.shields.io/badge/Java-Spigot%20v1.12.2-red" alt="Spigot 1.12.2バージョンに基づいて構築されています。">  

---
## 命令
| プレイスホルダー | 意味 | 例 |
|:---:|:---:|:---|
| SoundCategory | リソースパックディレクトリまたはMinecraft自体「sounds.json」で定義されたcategory名 | blocks  |
| SoundName | リソースパックディレクトリまたはMinecraft自体「sounds.json」で定義されたkey値 | block.anvil.fall |
| Pitch | 再生速度 | 1.2 |
| SoundLength | 繰り返し再生周期（秒） | 120 |
| Repeat | 繰り返し再生するかどうか | true |
| KeepRepeatEvenLogout | ログアウト後も繰り返し再生するかどうか | false |
| RepeatInstantlyWhenLogin | 再接続時に即座にサウンドを再生するかどうか | false |  

* /rsp list
	```
	自分に登録されたプレイリストを確認します。
	```
* /rsp lista
	```
	すべてのプレーヤーのプレイリストを確認します。
	```
* /rsp p [PlayerName] [SoundCategory] [SoundName] [Pitch] [SoundLength] [Repeat] [KeepRepeatEvenLogout] [RepeatInstantlyWhenLogin]
	```
	特定のプレーヤーにリソースパックのサウンドを再生します。
	```
* /rsp ps [PlayerName] [SoundCategory] [SoundName]
	```
	特定のプレーヤーに再生されているサウンドを停止します。
	```
* /rsp a [SoundCategory] [SoundName] [Pitch] [SoundLength] [Repeat] [KeepRepeatEvenLogout] [RepeatInstantlyWhenLogin]
	```
	みんなにリソースパックのサウンドを再生します。
	```
* /rsp as [SoundCategory] [SoundName]
	```
	すべてに特定のサウンドを停止させます。
	```

### プラグインのテストと使用方法:
1. サウンドリソースパックがない場合は、<a href="../bin/(Resourcepack) TestSoundResourcePack.zip">テスト用リソースパック</a>をダウンロードして、```C:/Users/[ユーザー名]/AppData /Roaming/.minecraft/resourcepacks``` ディレクトリに移動します。  
<p align="center"><img src="./01 download resourcepack in your directory.png" alt="テスト用のリソースパックをダウンロードしてください。"></p>  
  
2. <a href="../bin/(Plugin) ResourcepackSoundPlayer.jar">プラグイン</a>をダウンロードして、```C：/ [自分のMinecraft Serverディレクトリ]/plugins```ディレクトリに移動します。  
<p align="center"><img src="./02 download plugin in your directory.png" alt="プラグインをダウンロードしてください。"></p>  
  
3. サーバーを実行します。  
<p align="center"><img src="./03 start your server.png" alt="サーバーを実行します。"></p>  
  
4. サーバーに接続します。  
<p align="center"><img src="./04 login.png" alt="サーバーに接続してください。"></p>  
  
5. 環境設定メニューからリソースパックを適用します。  
<p align="center"><img src="./05 apply resourcepack.png" alt="リソースパックを適用してください。"></p>  
  
6. コマンドを入力してリソースパックのサウンドを再生します。

| SoundCategory | SoundName | 出典 |
|:---:|:---:|:---|
| master | choir1 | http://peritune.com/j_choir_chant1-3/ |
| master | choir2 | http://peritune.com/j_choir_chant1-3/ |
| master | choir3 | http://peritune.com/j_choir_chant1-3/ |
| master | win | http://peritune.com/j_choir_chant1-3/ |
| master | blade | http://www.hmix.net/music_gallery/feeling/hard.htm |  

[![Watch the video](./06 plugin test.png)](./06 plugin test.mp4)

---

## 更新
| 日付 | 内容 | 更新内容 |
|:---:|:---:|:---|
| 2019. 10. 15. | 追加 | プラグインが開発されました。 |
| 2021. 08. 05. | 追加 | 全プレイヤーを対象に再生する機能が追加されました。 |
| 2021. 08. 05. | 追加 | 再接続時にも繰り返し再生を維持On/Offオプションが追加される。 |
| 2021. 08. 05. | 追加 | 再接続時にすぐに繰り返し再生機能が追加されました。 |
| 2023. 01. 27. | 修正 | 命令入力時に発生するArrayIndexOutOfBoundsExceptionを解決しました。 |  
| 2023. 01. 27. | 追加 | 全プレイヤーのプレイリストを確認する機能が追加されました。 |  
---

## 等等
このプラグインは、スクリプトプラグインのユーザーがリソースパックのサウンドを遠くまで再生させる方法が難しいという記事を読んで、GoldBigDragonが作成しました。