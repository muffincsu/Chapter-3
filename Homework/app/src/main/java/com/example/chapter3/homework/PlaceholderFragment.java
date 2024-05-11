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
        friends.add("西狮海壬");
        friends.add("喷火龙");
        friends.add("仙子伊布");
        friends.add("魔幻假面喵");
        friends.add("甲贺忍蛙");
        friends.add("炽焰咆哮虎");
        friends.add("卡璞鳍鳍");
        friends.add("苍响");
        friends.add("藏玛然特");
        friends.add("蕾冠王");
        friends.add("故勒顿");
        friends.add("密勒顿");
        friends.add("雷吉艾勒奇");
        friends.add("阿尔宙斯");
        friends.add("美纳斯");
        friends.add("沙奈朵");
        friends.add("闪焰王牌");
        friends.add("无极汰那");
        SimpleFriendListAdapter adapter = new SimpleFriendListAdapter(getActivity(), friends);
        listView.setAdapter(adapter);
    }
}
