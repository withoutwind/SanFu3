package Fragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/14.
 */

public class FrgmentFactory {
    private static Map<Integer, BaseFragment> fragmentMap = new HashMap<Integer, BaseFragment>();

    public static BaseFragment createFragment(int pos) {
        BaseFragment fragment = fragmentMap.get(pos);
        if (fragment == null) {
            switch (pos){
                case 0:
                    fragment = new HomeFragment();
                    break;
                case 1:

                    fragment = new CategoryFragment();
                    break;
                case 2:
                    fragment = new ShoppingFragment();
                    break;
                case 3:
                    fragment = new UserFragment();
                    break;

            }
            fragmentMap.put(pos,fragment);

        }
        return fragment;

    }
}
