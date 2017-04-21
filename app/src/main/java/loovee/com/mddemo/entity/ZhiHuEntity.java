package loovee.com.mddemo.entity;

import java.util.List;

/**
 * Created by loovee on 2017/4/20.
 */

public class ZhiHuEntity {

    /**
     * date : 20170419
     * stories : [
     * {"images":["https://pic1.zhimg.com/v2-2c3c14322fbd5889446776d3b7cfff10.jpg"],"type":0,"id":9369465,"ga_prefix":"041922","title":"小事 · 不过她有男朋友"},{"title":"哭着吃过饭的人，是可以一起走下去的","ga_prefix":"041921","images":["https://pic2.zhimg.com/v2-92d45bbb970f332a682edd43edfb8935.jpg"],"multipic":true,"type":0,"id":9366416},{"images":["https://pic1.zhimg.com/v2-fc3c6efcf42c191d1ee1fe6cd37f5bcc.jpg"],"type":0,"id":9369301,"ga_prefix":"041920","title":"海盗当然要挂海盗旗，这样干起活来才「经济实惠」"},
     * {"images":["https://pic4.zhimg.com/v2-ccbacc5c995e1dc4b3a756d301af7bdb.jpg"],"type":0,"id":9369163,"ga_prefix":"041920","title":"刚出生就被认定存活率极低的婴儿要倾家荡产去救吗？"},]
     */

    private String date;
    private List<StoriesBean> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic1.zhimg.com/v2-2c3c14322fbd5889446776d3b7cfff10.jpg"]
         * type : 0
         * id : 9369465
         * ga_prefix : 041922
         * title : 小事 · 不过她有男朋友
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
