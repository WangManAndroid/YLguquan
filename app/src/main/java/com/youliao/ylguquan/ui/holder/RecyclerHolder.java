package com.youliao.ylguquan.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;


public class RecyclerHolder extends RecyclerView.ViewHolder {
        private final SparseArray<View> mViews;

        public RecyclerHolder(View itemView) {
            super(itemView);
            //一般不会超过8个吧
            this.mViews = new SparseArray<View>();
        }

        /**
         * 通过控件的Id获取对于的控件，如果没有则加入views
         */
        public <T extends View> T getView(int viewId) {
            View view = mViews.get(viewId);
            if (view == null) {
                view = itemView.findViewById(viewId);
                mViews.put(viewId, view);
            }
            return (T) view;
        }

        /**
         * 为TextView设置字符串
         */
        public RecyclerHolder setText(int viewId, String text) {
            TextView view = getView(viewId);
            view.setText(text);
            return this;
        }

        /**
         * 为ImageView设置图片
         */
        public RecyclerHolder setImageByUrl( int viewId, String url) {

            return this;
        }
    }