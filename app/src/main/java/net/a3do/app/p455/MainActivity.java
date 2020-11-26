package net.a3do.app.p455;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")"};

    private int rows = 4;
    private int columns = 4;

    private int letterSize;
    private LinearLayout resultContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int windowWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        letterSize = (windowWidth / rows) - (int) (windowWidth * 0.1);

        resultContainer = findViewById(R.id.result_container);

        Button calculateButton = findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showResult();
            }
        });

        showResult();
    }

    public void showResult() {
        resultContainer.removeAllViews();

        for (int row = 0; row < rows; row++) {
            LinearLayout linearLayoutRow = new LinearLayout(this);
            linearLayoutRow.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            linearLayoutRow.setOrientation(LinearLayout.HORIZONTAL);
            for (int column = 0; column < columns; column++) {
                TextView letter = new TextView(this);
                letter.setLayoutParams(new LinearLayout.LayoutParams(letterSize, letterSize));
                letter.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                letter.setTypeface(Typeface.MONOSPACE);
                letter.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                letter.setText(alphabet[getRandomIntBetween(0, alphabet.length - 1)]);
                linearLayoutRow.addView(letter);
            }
            resultContainer.addView(linearLayoutRow);
        }
    }

    public int getRandomIntBetween(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}