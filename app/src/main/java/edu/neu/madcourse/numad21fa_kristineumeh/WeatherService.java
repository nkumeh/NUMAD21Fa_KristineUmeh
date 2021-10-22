package edu.neu.madcourse.numad21fa_kristineumeh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.DecimalFormat;

public class WeatherService extends AppCompatActivity {
    EditText cityName;
    TextView getForecast;
    private final String url = "http://api.openweathermap.org/data/2.5/weather";
    private final String appID = "b837e58d247c58b4343c377d614e4930";
    DecimalFormat decimalFormat = new DecimalFormat("$.$");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_service);
        cityName = findViewById(R.id.city_input);
        getForecast = findViewById(R.id.get_forcast);
    }

    public void getWeatherDetails(View view) {
        String tempUrl = "";
        String city = cityName.getText().toString().trim();
        if (city.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Please input value!", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            tempUrl = url + "?q" + city + "&appID" + appID;
        }
        StringRequest stringRequest =
                new StringRequest(Request.Method.POST, tempUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("response", response);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                error.toString().trim(), Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }            }
}
