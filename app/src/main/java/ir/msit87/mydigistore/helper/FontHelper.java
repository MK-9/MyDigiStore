package ir.msit87.mydigistore.helper;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

public class FontHelper {

    public static String  IRANSansMOBILE_REGULAR = "iran_sans.ttf";
    public static String  IRANSansMOBILE_BOLD = "iran_sans_bold.ttf";
    public static String  IRANSansMOBILE_Light = "IRANSansMobile_Light.ttf";
    public static String  IRANSansMOBILE_Medium = "IRANSansMobile_Medium.ttf";
    public static String  IRANSansMOBILE_UltraLight = "IRANSansMobile_UltraLight.ttf";


    private static Hashtable<String, Typeface> fontCache = new Hashtable();


    public static String[] IMAGE = {"Base-service-building.png", "Base-service-home.png", "Base-service-office.png", "Bathroom.png"};

    private static Hashtable<String, Drawable> imgCache = new Hashtable();


    public static List<String> Text_List;
    public static List<Object> Object_List;


    private static Hashtable<String, Integer> prefCache = new Hashtable();

    private Editor editor;
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    public static Typeface get(String name, Context context) {
        Typeface tf = fontCache.get(name);
        if (tf == null) {
            try {
                tf = Typeface.createFromAsset(context.getAssets(), "fonts/" + name);
                fontCache.put(name, tf);
            } catch (Exception e) {
                return null;
            }
        }
        return tf;
    }

    public static Drawable getDrawable(String name, Context context) {
        Drawable drawable = imgCache.get(name);
        if (drawable == null) {
            try {
                drawable = Drawable.createFromStream(context.getAssets().open("static-images/" + name), null);
                imgCache.put(name, drawable);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return drawable;
    }

//    static {
//        Object_List = new ArrayList();
//
//        for (int i = 0; i < 4; i++) {
//            Object_List.add(i, Text[i]);
//        }
//    }

    public static void setPrefCache(String key, Integer value) {
        prefCache.put(key, value);
    }
}
//        Text_List = new ArrayList();
//        for (int i = 0; i < 4; i++) {
//            Text_List.add(i, Text[i]);
//        }