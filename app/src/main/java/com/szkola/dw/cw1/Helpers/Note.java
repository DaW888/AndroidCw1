package com.szkola.dw.cw1.Helpers;

public class Note {
    private String title;
    private String context;
    private Integer color;
    private String path;

        public Note(String title, String context, Integer color, String path) {
                this.title = title;
                this.context = context;
                this.color = color;
                this.path = path;
        }

        public String getTitle() {
                return title;
        }

//        public void setTitle(String title) {
//                this.title = title;
//        }

        public String getContext() {
                return context;
        }

        public void setContext(String context) {
                this.context = context;
        }

        public Integer getColor() {
                return color;
        }

        public void setColor(Integer color) {
                this.color = color;
        }

        public String getPath() {
                return path;
        }

        public void setPath(String path) {
                this.path = path;
        }
}