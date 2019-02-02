package com.cabalabs.iucaa;

public class Summary {

    private String id ;
    private String folder;
    private String OBSID;
    private String Observer;
    private String Object;
    private String RA ;
    private String Decr;
    private String Exposure_time;

    public Summary() {

    }

    public Summary(String id, String folder, String OBSID, String Observer, String Object, String RA, String Decr, String Exposure_time) {
        this.id = id;
        this.folder = folder;
        this.OBSID = OBSID;
        this.Observer = Observer;
        this.Object = Object;
        this.RA = RA;
        this.Decr = Decr;
        this.Exposure_time = Exposure_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getOBSID() {
        return OBSID;
    }

    public void setOBSID(String OBSID) {
        this.OBSID = OBSID;
    }

    public String getObserver() {
        return Observer;
    }

    public void setObserver(String observer) {
        Observer = observer;
    }

    public String getObject() {
        return Object;
    }

    public void setObject(String object) {
        Object = object;
    }

    public String getRA() {
        return RA;
    }

    public void setRA(String RA) {
        this.RA = RA;
    }

    public String getDecr() {
        return Decr;
    }

    public void setDecr(String decr) {
        Decr = decr;
    }

    public String getExposure_time() {
        return Exposure_time;
    }

    public void setExposure_time(String exposure_time) {
        Exposure_time = exposure_time;
    }
}