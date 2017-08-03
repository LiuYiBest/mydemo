package com.liu.coder.pojo;

/**
 * Created by Neal on 17.7.5.
 */
public class Photo {
    private Integer photoId;
    private String photoPath;
    private Integer empId;

    public Photo() {
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
}
