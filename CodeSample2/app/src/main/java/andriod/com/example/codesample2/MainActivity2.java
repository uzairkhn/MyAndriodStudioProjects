package andriod.com.example.codesample2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
        }

        public void goToMain(View view) {
            EditText et = (EditText)findViewById(R.id.editText);
            String message = et.getText().toString();
            Intent in = new Intent();
            in.putExtra("Usermessage",message);
            setResult(RESULT_OK,in);
            finish();
        }
    }