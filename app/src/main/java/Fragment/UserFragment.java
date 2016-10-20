package Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.aishangsanfu.R;
import com.example.administrator.aishangsanfu.SortjumpActivity;

/**
 * Created by Administrator on 2016/10/14.
 */

public class UserFragment extends BaseFragment {
    private View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.userfragment,null);
        init();
        return v;
    }

    private void init() {
        Button button = (Button) v.findViewById(R.id.userfragment_button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getContext(), SortjumpActivity.class);
                startActivity(it);
            }
        });

    }

}
