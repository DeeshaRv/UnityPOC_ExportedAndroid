package com.ct.littlesingham.unityhelper;

import android.os.Bundle;

import com.unity3d.player.UnityPlayerActivity;

public abstract class UnityIntegrationHelperActivity extends UnityPlayerActivity {

    /**Call this event when game play of a new level starts
     * VAR: levelNumber is the numeric value of the level started
     * CALL THIS FUNCTION AGAIN IF THE LEVEL HAS RE-STARTED */
    abstract public void levelStarted(int levelNumber);

    /**Call this event when game play of a level is completed successfully
     * VAR: levelNumber is the numeric value of the level completed*/
    abstract public void levelCompleted(int levelNumber);

    /**Call this event when game play of a level has failed
     * VAR: levelNumber is the numeric value of the level failed*/
    abstract public void levelFailed(int levelNumber);

    /**Call this event last game level is completed
     * call it after gameCompleted and submitScore functions being called.
     * VAR: lastLevelNumber is the numeric value of the level completed*/
    abstract public void gameEnded(int lastLevelNumber);

    /**Call this event when user changes sound setting
     * VAR: isSoundOn should be true if sound is switched ON
     * VAR: isSoundOn should be false if sound is switched OFF*/
    abstract public void soundSettingChanged(boolean isSoundOn);

    /**Call this event when the user exits the game by pressing back from the main screen*/
    abstract public void gameExit();

    /**Call this event when the game has loaded successfully and ready to interact with*/
    abstract public void gameLoaded();

    public static UnityIntegrationHelperActivity instance = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        instance = null;
    }

}

