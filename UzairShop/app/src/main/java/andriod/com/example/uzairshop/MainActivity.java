package andriod.com.example.uzairshop;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String getSize() {
        RadioGroup sizeGroup = findViewById(R.id.sizeGroup);
        RadioButton checkedSize = findViewById(sizeGroup.getCheckedRadioButtonId());
        if (sizeGroup.getCheckedRadioButtonId() == -1) {
            return "notSelected";
        }
        return checkedSize.getText().toString();
    }

    private String getColor() {
        RadioGroup colorGroup = findViewById(R.id.colorGroup);
        RadioButton checkedColor = findViewById(colorGroup.getCheckedRadioButtonId());
        if (colorGroup.getCheckedRadioButtonId() == -1) {
            return "notSelected";
        }
        return checkedColor.getText().toString();
    }

    private Boolean checkTermsAndConditions() {
        CheckBox tos = findViewById(R.id.Tos);
        return tos.isChecked();
    }

    private Boolean checkIfAllOk() {
        if (getSize().equals("notSelected")) {
            Toast.makeText(this, "Select Size", Toast.LENGTH_SHORT).show();
            return false;
        } else if (getColor().equals("notSelected")) {
            Toast.makeText(this, "Select Color", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!checkTermsAndConditions()) {
            Toast.makeText(this, "Agree to Terms and conditions", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void clicked(View view) {
        if (checkIfAllOk()) {
            printSummary();
        }
    }

    private String createSummary() {
        return "Size: " + getSize() +
                "\nColor: " + getColor() +
                "\nTerms and conditions: Agreed";
    }

    private void printSummary() {
        Toast.makeText(this, createSummary(), Toast.LENGTH_SHORT).show();
    }
}
