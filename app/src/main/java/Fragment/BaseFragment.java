package Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import MyView.LoadingPage;
import Utils.UIUtils;

/**
 * Created by Administrator on 2016/10/14.
 */

public class BaseFragment extends Fragment {
    private LoadingPage mLoadingPage;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mLoadingPage = new LoadingPage(UIUtils.getContext());
        return mLoadingPage;
    }
}
