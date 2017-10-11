package ir.msit87.mydigistore.AutoModel;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/**
 * The Predictions Model Class Created by MSIT on 10/2/2017.
 */

public class Predictions {

    @SerializedName("description")
    private String description;

    @SerializedName("id")
    private String id;

    @SerializedName("matched_substrings")
    private ArrayList<Matched_SubStrings> matched_substrings = new ArrayList<>();

    @SerializedName("place_id")
    private String place_id;

    @SerializedName("reference")
    private String reference;

    @SerializedName("terms")
    private ArrayList<Terms> terms = new ArrayList<>();

    @SerializedName("types")
    private ArrayList<String> types = new ArrayList<>();


}
