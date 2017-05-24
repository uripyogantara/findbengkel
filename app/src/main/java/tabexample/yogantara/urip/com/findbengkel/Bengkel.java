package tabexample.yogantara.urip.com.findbengkel;

import java.io.Serializable;

/**
 * Created by Urip on 4/24/2017.
 */

public class Bengkel implements Serializable{
    private int image;
    private String nama,alamat,telepon;
    private double lat,lng;

    public Bengkel(int image, String nama, String alamat, String telepon, double lat, double lng) {
        this.image = image;
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
        this.lat = lat;
        this.lng = lng;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }
}
