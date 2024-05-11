package com.example.chapter3.homework;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        return inflater.inflate(R.layout.fragment_placeholder, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final LottieAnimationView animationView = getView().findViewById(R.id.animation_view);
        final ListView listView = getView().findViewById(R.id.list_view);

        loadListViewData(listView);
        listView.setVisibility(View.INVISIBLE);
        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入

                AnimatorSet animatorSet = new AnimatorSet();
                // Lottie动画淡出
                ObjectAnimator fadeOut = ObjectAnimator.ofFloat(animationView, "alpha", 1f, 0f);
                fadeOut.setDuration(1000); // 淡出持续时间，这里是1秒
                // 列表视图淡入
                ObjectAnimator fadeIn = ObjectAnimator.ofFloat(listView, "alpha", 0f, 1f);
                // 将两个动画加入到动画集中
                animatorSet.playSequentially(fadeOut, fadeIn);

                fadeIn.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        listView.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }


                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });

                // 开始执行动画
                animatorSet.start();
            }
        }, 5000);
    }

    private void loadListViewData(ListView listView)
    {
        List<String> friends = new ArrayList<>();
        friends.add("郭荣桓");
        friends.add("李明轩");
        friends.add("孙甜甜");
        friends.add("章宗宇");
        friends.add("贺大江");
        friends.add("刘万昌");
        friends.add("蒙睿涵");
        friends.add("杨明璋");
        friends.add("段瑞阳");
        friends.add("廖梦成");
        friends.add("马浩文");
        friends.add("王成运");
        friends.add("颜慧婷");
        friends.add("左亦涛");
        friends.add("林家琛");
        friends.add("沈昕慧");
        friends.add("幸俊杰");
        friends.add("叶卓维");
        SimpleFriendListAdapter adapter = new SimpleFriendListAdapter(getActivity(), friends);
        listView.setAdapter(adapter);
    }
}
