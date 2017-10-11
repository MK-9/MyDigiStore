package ir.msit87.mydigistore.AutoModel;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * PlaceAutoCompleteResult Class Created by MSIT on 10/2/2017.
 */

public class PlaceAutoCompleteResult {

    @SerializedName("predictions")
    private ArrayList<Predictions> predictions = new ArrayList<>();
}
