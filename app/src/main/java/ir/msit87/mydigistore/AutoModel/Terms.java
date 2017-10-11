package ir.msit87.mydigistore.AutoModel;

import com.google.gson.annotations.SerializedName;

/**
 * The Terms Model ClassCreated by MSIT on 10/2/2017.
 */

public class Terms {

    @SerializedName("offset")
    private String offset;

    @SerializedName("value")
    private Integer value;

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
