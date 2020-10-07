package com.example.ycx36.newems.util;

public class requestGetCarAllListBean {

    /**
     * request : {"common":{"action":"GetCarAllListBean","reqtime":"20190325180230"},"content":{"content":{"page":3,"pagesize":100}}
     */

    private RequestBean request;

    public RequestBean getRequest() {
        return request;
    }

    public void setRequest(RequestBean request) {
        this.request = request;
    }

    public static class RequestBean {
        /**
         * "common":{"action":"getCarAllList","reqtime":"20200709232120"
         * content":{"page":3,"pagesize":100}
         */

        private CommonBean common;
        private ContentBean content;

        public CommonBean getCommon() {
            return common;
        }

        public void setCommon(CommonBean common) {
            this.common = common;
        }

        public ContentBean getContent() {
            return content;
        }

        public void setContent(ContentBean content) {
            this.content = content;
        }

        public static class CommonBean {
            /**
             * action : getCarAllList
             * reqtime : 20190325180230
             */

            private String action;
            private String reqtime;

            public String getAction() {
                return action;
            }

            public void setAction(String action) {
                this.action = action;
            }

            public String getReqtime() {
                return reqtime;
            }

            public void setReqtime(String reqtime) {
                this.reqtime = reqtime;
            }
        }

        public static class ContentBean {
            /**
             * id : null
             * page : 3
             * pagesize : 100
             */

            private Object id;
            private int page;
            private int pagesize;


            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public int getPage() {
                return page;
            }

            public void setPage(int page) {
                this.page = page;
            }

            public int getPagesize(int pagesize) {
                return pagesize;
            }

            public void setPagesize(int pagesize) {
                this.pagesize = pagesize;
            }


        }
    }
}
