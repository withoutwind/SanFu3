package MyView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.example.administrator.aishangsanfu.R;

import Utils.UIUtils;

/**
 * Created by Administrator on 2016/10/14.
 */

public class LoadingPage extends FrameLayout {
    private static final int STATE_LOAD_UNDO = 1;
    private static final int STATE_LOAD_LoADING = 2;
    private static final int STATE_LOAD_ERROR= 3;
    private static final int STATE_LOAD_EMPTY = 4;
    private static final int STATE_LOAD_SUCCESS = 5;

    private int mCurrentState = STATE_LOAD_UNDO;
    private View mLoading;


    public LoadingPage(Context context) {
        super(context);
        initview();
    }

    public LoadingPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        initview();
    }

    public LoadingPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initview();
    }

    private void initview() {
        //加载中
        if (mLoading == null) {
            mLoading = UIUtils.inflate(R.layout.page_loading);
            addView(mLoading);
        }
    }
}
