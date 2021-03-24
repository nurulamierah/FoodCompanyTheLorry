package com.example.foodcompanythelorry;

class Comments {

    int profileImage;
    String Name;
    String Comment;

    public Comments(int profileImage, String name, String comment) {
        this.profileImage = profileImage;
        Name = name;
        Comment = comment;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public String getName() {
        return Name;
    }

    public String getComment() {
        return Comment;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setComment(String comment) {
        Comment = comment;
    }
}

