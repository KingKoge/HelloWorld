package app.ssru.ping.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtY;
    private EditText edtX;

    private RadioGroup rgCalculator;
    private RadioButton rbPlus;
    private RadioButton rbMinus;
    private RadioButton rbMultiply;
    private RadioButton rbDivide;

    private TextView tvDisplay;

    private Button btnReset;
    private Button btnCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();
        initView();
    }

    private void initView() {
        rgCalculator.check(rbPlus.getId());

        tvDisplay.setText("0");

        btnReset.setOnClickListener(this);
        btnCalculator.setOnClickListener(this);

        edtX.setText("");
        edtY.setText("");
    }

    private void bindView() {
        edtX = findViewById(R.id.edtX);
        edtY = findViewById(R.id.edtY);

        rgCalculator = findViewById(R.id.rgCalculator);
        rbPlus = findViewById(R.id.rbPlus);
        rbMinus = findViewById(R.id.rbMinus);
        rbMultiply = findViewById(R.id.rbMultiply);
        rbDivide = findViewById(R.id.rbDivide);

        tvDisplay = findViewById(R.id.tvDisplay);

        btnReset = findViewById(R.id.btnReset);
        btnCalculator = findViewById(R.id.btnCalculator);
    }

    @Override
    public void onClick(View v) {
        if (v == btnReset)
            initView();
        else if (v == btnCalculator)
            calculator();
    }

    private void calculator() {
        int id = rgCalculator.getCheckedRadioButtonId();

        if (id == rbPlus.getId()) {
            plus();
        } else if (id == rbMinus.getId()) {
            minus();
        } else if (id == rbMultiply.getId()) {
            multiply();
        } else if (id == rbDivide.getId()) {
            divide();
        }
    }

    private void plus() {
        int x = getValueX();
        int y = getValueY();

        String display = String.valueOf(x + y);
        tvDisplay.setText(display);
    }

    private int getValueX() {
        if (edtX.getText() != null
                && !edtX.getText().toString().isEmpty())
            return Integer.parseInt(edtX.getText().toString());

        return 0;
    }

    private int getValueY() {
        if (edtY.getText() != null
                && !edtY.getText().toString().isEmpty())
            return Integer.parseInt(edtY.getText().toString());

        return 0;
    }

    private void minus() {
        int x = getValueX();
        int y = getValueY();

        String display = String.valueOf(x - y);
        tvDisplay.setText(display);
    }

    private void multiply() {
        int x = getValueX();
        int y = getValueY();

        String display = String.valueOf(x * y);
        tvDisplay.setText(display);
    }

    private void divide() {
        int x = getValueX();
        int y = getValueY();

        if (y != 0) {
            String display = String.valueOf(x / y);
            tvDisplay.setText(display);
        } else {
            tvDisplay.setText("Infinity");
        }
    }
}
