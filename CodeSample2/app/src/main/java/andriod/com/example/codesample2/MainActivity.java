package andriod.com.example.codesample2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import andriod.com.example.codesample2.R;

public class MainActivity extends AppCompatActivity {

    final int INTENT_PRACTICE_CODE = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeActivity(View view) {
        Intent it = new Intent(this,MainActivity2.class);
        startActivityForResult(it,INTENT_PRACTICE_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == INTENT_PRACTICE_CODE) {
            TextView tv = (TextView)findViewById(R.id.tv);
            tv.setText(data.getStringExtra("Usermessage"));
        }
    }



}