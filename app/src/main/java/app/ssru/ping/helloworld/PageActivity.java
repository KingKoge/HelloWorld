package app.ssru.ping.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PageActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnHelloWorld;
    private Button btnMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        btnHelloWorld = findViewById(R.id.btnHelloWorld);
        btnMain = findViewById(R.id.btnMain);

        btnHelloWorld.setOnClickListener(this);
        btnMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnHelloWorld){
            Intent intent = new Intent(PageActivity.this, HelloWorldActivity.class);
            startActivity(intent);
        }else if (v == btnMain){
            
        }
    }
}
