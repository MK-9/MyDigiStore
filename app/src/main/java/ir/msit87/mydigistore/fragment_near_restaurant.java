package ir.msit87.mydigistore;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by MSIT on 9/26/2017.
 */

public class fragment_near_restaurant extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.from(getActivity()).inflate(R.layout.activity_near_restaurant_zf, container, false);
        return view;
    }


}
