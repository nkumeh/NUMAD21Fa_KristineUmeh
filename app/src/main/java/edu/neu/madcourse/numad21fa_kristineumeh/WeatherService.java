package edu.neu.madcourse.numad21fa_kristineumeh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.Objects;

public class WeatherService extends AppCompatActivity {
    EditText cityName;
    TextView weatherDisplay;
    Button getWeather;

    private final String rootUrl = "https://api.openweathermap.org/data/2.5/weather";
    private final String appID = "b837e58d247c58b4343c377d614e4930";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_service);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        cityName = findViewById(R.id.city_input);
        weatherDisplay = findViewById(R.id.weatherDisplay);
        getWeather = findViewById(R.id.searchButton);
    }

    public void getWeatherDetails(View view) {
        String tempUrl = "";
        String city = cityName.getText().toString().trim();
        if (city.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Empty value!", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            tempUrl = rootUrl + "?q=" + city + "&appID=" + appID;
        }

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, tempUrl,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject object = response.getJSONObject("main");
                    String temperature = object.getString("temp");
                    Double kelvin_convert = Double.parseDouble(temperature)-273.15;

                    weatherDisplay.setText(kelvin_convert.toString().substring(0,5) + "°C");
                } catch (JSONException exception) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                                exception.getMessage() , Toast.LENGTH_SHORT);
                        toast.show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Please Enter Valid City", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        queue.add(request);
    }
}
