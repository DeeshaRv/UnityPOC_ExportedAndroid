package com.dirtcube.cgtestintegration_native;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;

import com.ct.littlesingham.unityhelper.UnityIntegrationHelperActivity;

import java.io.*;

public class OverrideUnityIntegrationHelperActivity extends UnityIntegrationHelperActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String finalLocation = copyFileFromAssetToCache("ispyscene");
        Log.d("UnityHelper", finalLocation);

        mUnityPlayer.UnitySendMessage("MainGameManager", "SetDefaultSound", "false");
        //mUnityPlayer.UnitySendMessage("MainGameManager", "SetScreenOrientation", "landscape");
        mUnityPlayer.UnitySendMessage("MainGameManager", "LoadGameFromLocalCache", finalLocation);
    }

    private String copyFileFromAssetToCache(String filename) {
        AssetManager assetManager = this.getAssets();

        InputStream in = null;
        OutputStream out = null;
        try {
            in = assetManager.open(filename);
            String newFileName = new File(getFilesDir(),File.separator+"ispyscene").getAbsolutePath();
            out = new FileOutputStream(newFileName);

            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;

            return newFileName;
        } catch (Exception e) {
            Log.e("CopyException", e.getMessage());
        }

        return null;
    }


    /**Call this event when the game has loaded successfully and ready to interact with*/
    @Override
    public void gameLoaded() {
        Log.d("GameConsoleLog: ","gameLoaded");
    }


    /**Call this event when game play of a new level starts
     * VAR: levelNumber is the numeric value of the level started
     * CALL THIS FUNCTION AGAIN IF THE LEVEL HAS RE-STARTED */
    @Override
    public void levelStarted(int levelNumber) {
        Log.d("GameConsoleLog: ","levelStarted: "+levelNumber);

    }


    /**Call this event when game play of a level is completed successfully
     * VAR: levelNumber is the numeric value of the level completed*/
    @Override
    public void levelCompleted(int levelNumber) {
        Log.d("GameConsoleLog: ","levelComplete: "+levelNumber);

    }

    /**Call this event when game play of a level has failed
     * VAR: levelNumber is the numeric value of the level failed*/
    @Override
    public void levelFailed(int levelNumber) {
        Log.d("GameConsoleLog: ","levelFailed: "+levelNumber);

    }

    /**Call this event last game level is completed
     * call it after gameCompleted and submitScore functions being called.
     * VAR: lastLevelNumber is the numeric value of the level completed*/
    @Override
    public void gameEnded(int lastLevelNumber) {
        Log.d("GameConsoleLog: ","gameEnded ");

    }

    /**Call this event when user changes sound setting
     * VAR: isSoundOn should be true if sound is switched ON
     * VAR: isSoundOn should be false if sound is switched OFF*/
    @Override
    public void soundSettingChanged(boolean isSoundOn) {
        Log.d("GameConsoleLog: ","soundSetting: "+isSoundOn);

    }

    /**Call this event when the user exits the game by pressing back from the main screen*/
    @Override
    public void gameExit() {
        Log.d("GameConsoleLog: ","gameExit");
    }

}