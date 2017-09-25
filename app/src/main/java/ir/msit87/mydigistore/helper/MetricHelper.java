package ir.msit87.mydigistore.helper;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by MSIT on 9/25/2017.
 */


public class MetricHelper {
    public static int dpToPx(Context context, int dp) {
        return (int) TypedValue.applyDimension(1, (float) dp, context.getResources().getDisplayMetrics());
    }

    public static int pxToDp(Context context, int dp) {
        return (int) (((float) dp) * context.getResources().getDisplayMetrics().density);
    }
}