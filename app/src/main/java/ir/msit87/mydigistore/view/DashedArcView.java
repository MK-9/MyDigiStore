package ir.msit87.mydigistore.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import ir.msit87.mydigistore.helper.MetricHelper;

/**
 * Created by MSIT on 9/25/2017.
 */


@SuppressLint("AppCompatCustomView")
public class DashedArcView extends ImageView {
    private Paint f12921a;

    public DashedArcView(Context context) {
        super(context);
        m13410a();
    }

    public DashedArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m13410a();
    }

    public DashedArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        m13410a();
    }

    @RequiresApi(api = 21)
    public DashedArcView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        m13410a();
    }

    private void m13410a() {
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int dashedWidth = MetricHelper.dpToPx(getContext(), 6);
        int dashedSpace = MetricHelper.dpToPx(getContext(), 3);
        int slide = MetricHelper.dpToPx(getContext(), 15);
        int topMargin = MetricHelper.dpToPx(getContext(), 33);
        this.f12921a = new Paint();
        this.f12921a.setAntiAlias(true);
        this.f12921a.setColor(Color.parseColor("#b3b3b3"));
        this.f12921a.setStrokeWidth((float) MetricHelper.dpToPx(getContext(), 2));
        this.f12921a.setStyle(Paint.Style.STROKE);
        this.f12921a.setPathEffect(new DashPathEffect(new float[]{(float) dashedWidth, (float) dashedSpace}, 0.0f));
        canvas.drawArc(new RectF((float) (-slide), (float) topMargin, (float) (getWidth() + slide), (float) getHeight()), BitmapDescriptorFactory.HUE_CYAN, BitmapDescriptorFactory.HUE_CYAN, false, this.f12921a);
    }
}
