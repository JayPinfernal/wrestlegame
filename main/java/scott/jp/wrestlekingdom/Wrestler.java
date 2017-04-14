package scott.jp.wrestlekingdom;

import java.io.Serializable;

/**
 * Created by Jay on 19-03-2017.
 */

public class Wrestler implements Serializable {
    private String name,nickName,homeState,mov1,mov2,mov3,mov4,finisher,signature;
    int picID,finisherVidID,signatureVidID;

    public Wrestler(String name, String nickName, String homeState, String mov1, String mov2, String mov3, String mov4, String finisher, String signature, int picID, int finisherVidID, int signatureVidID) {
        this.name = name;
        this.nickName = nickName;
        this.homeState = homeState;
        this.mov1 = mov1;
        this.mov2 = mov2;
        this.mov3 = mov3;
        this.mov4 = mov4;
        this.finisher = finisher;
        this.signature = signature;
        this.picID = picID;
        this.finisherVidID = finisherVidID;
        this.signatureVidID = signatureVidID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHomeState() {
        return homeState;
    }

    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }

    public String getMov1() {
        return mov1;
    }

    public void setMov1(String mov1) {
        this.mov1 = mov1;
    }

    public String getMov2() {
        return mov2;
    }

    public void setMov2(String mov2) {
        this.mov2 = mov2;
    }

    public String getMov3() {
        return mov3;
    }

    public void setMov3(String mov3) {
        this.mov3 = mov3;
    }

    public String getMov4() {
        return mov4;
    }

    public void setMov4(String mov4) {
        this.mov4 = mov4;
    }

    public String getFinisher() {
        return finisher;
    }

    public void setFinisher(String finisher) {
        this.finisher = finisher;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int getPicID() {
        return picID;
    }

    public void setPicID(int picID) {
        this.picID = picID;
    }

    public int getFinisherVidID() {
        return finisherVidID;
    }

    public void setFinisherVidID(int finisherVidID) {
        this.finisherVidID = finisherVidID;
    }

    public int getSignatureVidID() {
        return signatureVidID;
    }

    public void setSignatureVidID(int signatureVidID) {
        this.signatureVidID = signatureVidID;
    }
}
