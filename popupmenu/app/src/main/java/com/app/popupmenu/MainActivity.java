package com.app.popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.app.popupmenu.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void Popup(View view) {
        PopupMenu popup = new PopupMenu(MainActivity.this,view);
        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
        popup.show();

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if (item.getItemId()==R.id.name)
                {
                    Toast.makeText(MainActivity.this, "Usman Ghani", Toast.LENGTH_SHORT).show();
                }
                else if (item.getItemId()==R.id.fb)
                {
                    Uri uri = Uri.parse("https://www.facebook.com/usmangha");
                    Intent it = new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(it);
                }
                else if (item.getItemId()==R.id.fb1) {
                    Uri uri = Uri.parse("https://www.facebook.com/usmangha");
                    Intent it = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(it);
                }


                return false;
            }
        });
    }

}
