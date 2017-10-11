package ir.msit87.mydigistore;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_navigation_zf);
    }
}













//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Handler;
//import android.support.design.widget.FloatingActionButton;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.Toolbar;
//import android.text.Html;
//import android.text.TextUtils;
//import android.util.Base64;
//import android.util.Log;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
//import com.google.android.gms.common.GooglePlayServicesRepairableException;
//import com.google.android.gms.common.api.Status;
//import com.google.android.gms.location.places.Place;
//import com.google.android.gms.location.places.ui.PlaceAutocomplete;
//import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
//import com.google.android.gms.location.places.ui.PlaceSelectionListener;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.LatLngBounds;
//
//import java.nio.charset.StandardCharsets;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;

//public class MainActivity extends AppCompatActivity implements PlaceSelectionListener {
//
//    private static final String LOG_TAG = "PlaceSelectionListener";
//    private static final LatLngBounds BOUNDS_MOUNTAIN_VIEW
//            = new LatLngBounds(new LatLng(37.398160, -122.180831), new LatLng(37.430610, -121.972090));
//    private TextView locationTextView;
//    private TextView attributionsTextView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_location);
//
//        //final String password = "mohammad";
//
//        //computeSHAHash(password);
//
//        //computeMD5Hash(password);
//
//        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)getFragmentManager().findFragmentById(R.id.place_fragment);
//        autocompleteFragment.setOnPlaceSelectedListener(this);
//        autocompleteFragment.setHint("Search a Location");
//        //autocompleteFragment.setBoundsBias(BOUNDS_MOUNTAIN_VIEW);
//    }
//
//    /**
//     * SHA-256 isn't an "encoding" - it's a one-way hash.
//     * You'd basically convert the string into bytes
//     * (e.g. using text.getBytes("UTF-8")) and then hash the bytes.
//     * Note that the result of the hash would also be arbitrary binary data,
//     * and if you want to represent that in a string, you should use base64 or hex...
//     * don't try to use the String(byte[], String) constructor.
//     *
//     * @param password
//     */
//    private void computeSHAHash(final String password) {
//
//        new Handler().postDelayed(new Runnable() {
//            @SuppressLint("NewApi")
//            @Override
//            public void run() {
//
//                byte[] data;
//                try {
//                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
//
//                    messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
//
//                    data = messageDigest.digest();
//
//                    showResult(data);
//
//                } catch (NoSuchAlgorithmException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, 3000);
//
//    }
//
//    private void computeMD5Hash(final String password) {
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                byte[] data;
//                try {
//                    MessageDigest md = MessageDigest.getInstance("SHA-256");
//
//                    md.update(password.getBytes());
//
//                    data = md.digest();
//
//                    StringBuffer Md5Hash = new StringBuffer();
//
//                    for (int i = 0; i < data.length; i++) {
//                        int l = 0xFF & data[i];
//                        String h = Integer.toHexString(l);
//                        while (h.length() < 2)
//                            h = "0" + h;
//                        Md5Hash.append(h);
//                    }
//
//                    showResultMD5(Md5Hash.toString());
//
//                } catch (NoSuchAlgorithmException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, 5000);
//    }
//
//    private void showResult(byte[] data) {
//        Toast.makeText(this, convertToHex(data), Toast.LENGTH_LONG).show();
//    }
//
//    private void showResultMD5(String data) {
//        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
//    }
//
//    private static String convertToHex(byte[] data) {
//
//        StringBuffer bf = new StringBuffer();
//        String hex = null;
//        /**
//         * Base64-encode the given data and return a newly allocated String with the result.
//         */
//        hex = Base64.encodeToString(data, 0, data.length, 0);
//        bf.append(hex);
//        return bf.toString();
//    }
//
//    @Override
//    public void onPlaceSelected(Place place) {
//
//    }
//
//    @Override
//    public void onError(Status status) {
//
//    }
//}

