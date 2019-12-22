package dicoding.azima.chellangedicoding;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class Mountain implements Parcelable {
    private String title;
    private String desc;
    private String imgPhoto;

    protected Mountain(Parcel in) {
        title = in.readString();
        desc = in.readString();
        imgPhoto = in.readString();
    }

    public static final Creator<Mountain> CREATOR = new Creator<Mountain>() {
        @Override
        public Mountain createFromParcel(Parcel in) {
            return new Mountain(in);
        }

        @Override
        public Mountain[] newArray(int size) {
            return new Mountain[size];
        }
    };

    public Mountain() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgPhoto() {
        return imgPhoto;
    }

    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(desc);
        parcel.writeString(imgPhoto);
    }
}
