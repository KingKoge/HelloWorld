package app.ssru.ping.helloworld;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HelloWorldActivity extends AppCompatActivity {

    private int res[] = {R.drawable.dice_six_faces_one,
            R.drawable.dice_six_faces_two,
            R.drawable.dice_six_faces_three,
            R.drawable.dice_six_faces_four,
            R.drawable.dice_six_faces_five,
            R.drawable.dice_six_faces_six
    };
    private Button btnRandom;
    private ImageView ivDice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);

        btnRandom = findViewById(R.id.btnRandom);
        ivDice = findViewById(R.id.ivDice);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomDice(5);
            }
        });
    }

    private void randomDice(final int count) {
        final int dice = (int) (Math.random() * 6 + 1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int condition = count - 1;
                if (0 == condition) {
                    ivDice.setImageResource(res[dice - 1]);
                } else {
                    ivDice.setImageResource(res[dice - 1]);
                    randomDice(condition);
                }
            }
        }, 150);
    }
}
