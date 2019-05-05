package me.nice.base.inter;

import java.util.List;

import me.nice.base.BaseFragment;

public interface IFragments<F> {

    void addFragment(F fragment);
    List<F> getFragments();

}
