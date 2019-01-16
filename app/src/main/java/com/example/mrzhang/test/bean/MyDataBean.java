package com.example.mrzhang.test.bean;

import java.util.List;

/**
 *
 */
public class MyDataBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 1
         * subdata : ["A","B","C","D","E"]
         */

        private String title;
        private List<String> subdata;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getSubdata() {
            return subdata;
        }

        public void setSubdata(List<String> subdata) {
            this.subdata = subdata;
        }
    }
}
