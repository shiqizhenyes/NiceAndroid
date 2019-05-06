package me.nice.base;

import java.util.ArrayList;
import java.util.List;

import me.nice.base.inter.IFragments;

public class IFragmentsImpl<F extends BaseFragment> implements IFragments<BaseFragment> {

    private static IFragmentsImpl iFragments;

    private F f;

    public List<F> fragments = new ArrayList<>();

    public static IFragments getInstance() {
        if (iFragments == null) {
            synchronized (IFragmentsImpl.class) {
                if (iFragments == null) {
                    iFragments = new IFragmentsImpl();
                }
            }
        }
        return iFragments;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addFragment(BaseFragment fragment) {
        if (!fragments.contains(fragment)) {
            fragments.add((F) fragment);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<BaseFragment> getFragments() {
        return iFragments.fragments;
    }

}
