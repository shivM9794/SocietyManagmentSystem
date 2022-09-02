package app.societymanagementsystem.View.HelperClass;

public class LSHelperClass {

    int imageView;
    String tv_name;

    public LSHelperClass(int imageView, String tv_name) {
        this.imageView = imageView;
        this.tv_name = tv_name;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }
}
