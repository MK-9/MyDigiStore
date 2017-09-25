package ir.msit87.mydigistore.view;

/**
 * Created by MSIT on 9/25/2017.
 */

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class AutoScrollViewPager extends ViewPager {
    public static final int DEFAULT_INTERVAL = 1500;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int SCROLL_WHAT = 0;
    public static final int SLIDE_BORDER_MODE_CYCLE = 1;
    public static final int SLIDE_BORDER_MODE_NONE = 0;
    public static final int SLIDE_BORDER_MODE_TO_PARENT = 2;
    private long f12904d = 1500;
    private int f12905e = 1;
    private boolean f12906f = true;
    private boolean f12907g = true;
    private int f12908h = 0;
    private boolean f12909i = true;
    private double f12910j = 1.0d;
    private double f12911k = 1.0d;
    private Handler f12912l;
    private boolean f12913m = false;
    private boolean f12914n = false;
    private float f12915o = 0.0f;
    private float f12916p = 0.0f;
    private CustomDurationScroller f12917q = null;

    static class C2294a extends Handler {
        private final WeakReference<AutoScrollViewPager> f12903a;

        public C2294a(AutoScrollViewPager autoScrollViewPager) {
            this.f12903a = new WeakReference(autoScrollViewPager);
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    AutoScrollViewPager pager = (AutoScrollViewPager) this.f12903a.get();
                    if (pager != null) {
                        pager.f12917q.setScrollDurationFactor(pager.f12910j);
                        pager.scrollOnce();
                        pager.f12917q.setScrollDurationFactor(pager.f12911k);
                        pager.m13402a(pager.f12904d + ((long) pager.f12917q.getDuration()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public AutoScrollViewPager(Context paramContext) {
        super(paramContext);
        m13407f();
    }

    public AutoScrollViewPager(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        m13407f();
    }

    private void m13407f() {
        this.f12912l = new C2294a(this);
        m13408g();
    }

    public void startAutoScroll() {
        this.f12913m = true;
        m13402a((long) (((double) this.f12904d) + ((((double) this.f12917q.getDuration()) / this.f12910j) * this.f12911k)));
    }

    public void startAutoScroll(int delayTimeInMills) {
        this.f12913m = true;
        m13402a((long) delayTimeInMills);
    }

    public void stopAutoScroll() {
        this.f12913m = false;
        this.f12912l.removeMessages(0);
    }

    public void setSwipeScrollDurationFactor(double scrollFactor) {
        this.f12911k = scrollFactor;
    }

    public void setAutoScrollDurationFactor(double scrollFactor) {
        this.f12910j = scrollFactor;
    }

    private void m13402a(long delayTimeInMills) {
        this.f12912l.removeMessages(0);
        this.f12912l.sendEmptyMessageDelayed(0, delayTimeInMills);
    }

    private void m13408g() {
        try {
            Field scrollerField = ViewPager.class.getDeclaredField("m");
            scrollerField.setAccessible(true);
            Field interpolatorField = ViewPager.class.getDeclaredField("f");
            interpolatorField.setAccessible(true);
            this.f12917q = new CustomDurationScroller(getContext(), (Interpolator) interpolatorField.get(null));
            scrollerField.set(this, this.f12917q);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrollOnce() {
        PagerAdapter adapter = getAdapter();
        int nextItem = getCurrentItem();
        if (adapter != null) {
            int totalCount = adapter.getCount();
            if (totalCount > 1) {
                int currentItem;
                if (this.f12905e == 0) {
                    nextItem--;
                    currentItem = nextItem;
                } else {
                    nextItem++;
                    currentItem = nextItem;
                }
                if (nextItem < 0) {
                    if (this.f12906f) {
                        setCurrentItem(totalCount - 1, this.f12909i);
                    }
                } else if (nextItem != totalCount) {
                    setCurrentItem(nextItem, true);
                } else if (this.f12906f) {
                    setCurrentItem(0, this.f12909i);
                }
                nextItem = currentItem;
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = MotionEventCompat.getActionMasked(ev);
        if (this.f12907g) {
            if (action == 0 && this.f12913m) {
                this.f12914n = true;
                stopAutoScroll();
            } else if (ev.getAction() == 1 && this.f12914n) {
                startAutoScroll();
            }
        }
        if (this.f12908h == 2 || this.f12908h == 1) {
            this.f12915o = ev.getX();
            if (ev.getAction() == 0) {
                this.f12916p = this.f12915o;
            }
            int currentItem = getCurrentItem();
            PagerAdapter adapter = getAdapter();
            int pageCount = adapter == null ? 0 : adapter.getCount();
            if ((currentItem == 0 && this.f12916p <= this.f12915o) || (currentItem == pageCount - 1 && this.f12916p >= this.f12915o)) {
                if (this.f12908h == 2) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    if (pageCount > 1) {
                        setCurrentItem((pageCount - currentItem) - 1, this.f12909i);
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                return super.dispatchTouchEvent(ev);
            }
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
    }

    public long getInterval() {
        return this.f12904d;
    }

    public void setInterval(long interval) {
        this.f12904d = interval;
    }

    public int getDirection() {
        return this.f12905e == 0 ? 0 : 1;
    }

    public void setDirection(int direction) {
        this.f12905e = direction;
    }

    public boolean isCycle() {
        return this.f12906f;
    }

    public void setCycle(boolean isCycle) {
        this.f12906f = isCycle;
    }

    public boolean isStopScrollWhenTouch() {
        return this.f12907g;
    }

    public void setStopScrollWhenTouch(boolean stopScrollWhenTouch) {
        this.f12907g = stopScrollWhenTouch;
    }

    public int getSlideBorderMode() {
        return this.f12908h;
    }

    public void setSlideBorderMode(int slideBorderMode) {
        this.f12908h = slideBorderMode;
    }

    public boolean isBorderAnimation() {
        return this.f12909i;
    }

    public void setBorderAnimation(boolean isBorderAnimation) {
        this.f12909i = isBorderAnimation;
    }
}