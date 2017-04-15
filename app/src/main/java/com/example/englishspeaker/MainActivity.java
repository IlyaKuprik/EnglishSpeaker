package com.example.englishspeaker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import ru.yandex.speechkit.Error;
import ru.yandex.speechkit.SpeechKit;
import ru.yandex.speechkit.Synthesis;
import ru.yandex.speechkit.Vocalizer;
import ru.yandex.speechkit.VocalizerListener;

public class MainActivity extends AppCompatActivity implements VocalizerListener{
    Vocalizer vocalizer;
    String s1;
    EditText ed;
    static final String API_KEY_YANDEX = "5d94b1c6-bd69-4d19-82b8-909ae1888511";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SpeechKit.getInstance().configure(getApplicationContext(), API_KEY_YANDEX);
        ed=(EditText)findViewById(R.id.editText);

    }

    private void resetVocalizer() {
        if (vocalizer != null) {
            vocalizer.cancel();
            vocalizer = null;
        }
    }

        @Override
    public void onSynthesisBegin(Vocalizer vocalizer) {

    }

    @Override
    public void onSynthesisDone(Vocalizer vocalizer, Synthesis synthesis) {

    }

    @Override
    public void onPlayingBegin(Vocalizer vocalizer) {

    }

    @Override
    public void onPlayingDone(Vocalizer vocalizer) {

    }

    @Override
    public void onVocalizerError(Vocalizer vocalizer, Error error) {

    }
    public void onPlayBtnClick(View view){
        s1 = ed.getText().toString();
        resetVocalizer();
        vocalizer = Vocalizer.createVocalizer(Vocalizer.Language.RUSSIAN, s1, true, Vocalizer.Voice.ERMIL);
        vocalizer.setListener(this);
        vocalizer.start();
    }
}
