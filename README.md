# Unity-CGAndroid
POC project to communicate effectively with unity games from native code

1. Guide for the communication is here -> https://docs.google.com/document/d/1SrmRq-SbG4rlkG7L_zQ9PkRZnlqr9LSt6HaPiQw18as/edit#
2. Unity Export guide is here -> https://docs.google.com/document/d/14ghT4mVG3rfyrJ9NVKgwEleHWjwXO5wcJpdhJnakBf8/edit#heading=h.2lqmn4ufzg6y

Steps to integrate Android Native code after exporting Unity Project for Android Platform
Note: Keep copy of "UnityHelperActivity" handy.

1. Under launcher -> main -> Right Click -> New -> Folder -> Java folder (This will create java resource folder)
2. Under launcher -> main -> Right Click -> New -> Folder -> Assets folder (This will create asset folder under main)
3. Java -> Right click -> New -> Activity -> Empty Activity -> 
   Name it "UnityHelperActivity" (Enable Launcher Activity option, This will take care of AndroidManifest.xml code) -> Finish
4. Remove line "setContentView" from onCreate function
5. Add all other functions of current "UnityHelperActivity" and call "UnitySendMessage" based on reference file.
6. Add "house.hub" file under asset folder. (Note: this folder is copied to cache location via copyFile... function)