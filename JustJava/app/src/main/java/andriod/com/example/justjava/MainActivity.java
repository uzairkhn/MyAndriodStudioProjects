package andriod.com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;
/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String priceMessage = "Total = "+ quantity*5 +"$";
        priceMessage = priceMessage + "\nThank you ";
        displayMessage(priceMessage);

        calculatePrice();
    }
    /**
     * Calculates the price of the order.
     *
     *  quantity is the number of cups of coffee ordered
     */
    private void calculatePrice() {
        int price = quantity *5 ;
    }

    public void increment(View view) {
        quantity = quantity+1;
        displayQuantity(quantity);

    }

    public void decrement(View view ){
    quantity = quantity-1;
    displayQuantity(quantity);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price);
        priceTextView.setText(message);
    }
}