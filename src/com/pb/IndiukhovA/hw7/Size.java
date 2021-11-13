package com.pb.IndiukhovA.hw7;

public enum Size {
    XXS("XXS", 32),
    XS("XS", 34),
    S("S", 36),
    M("M", 38),
    L("L", 40);

    private String description;
    private int euroSize;

    Size(String description, int euroSize) {
        this.description = description;
        this.euroSize = euroSize;
    }

    public String getDescription(Size description){
        switch (description){
            case XXS:
                return "Детский размер";
            default:
                return "Взрослый размер";
        }
    }
    public int getEuroSize(Size euroSize){
        switch (euroSize){
            case XXS:
                return 32;
            case XS:
                return 34;
            case S:
                return 36;
            case M:
                return 38;
            case L:
                return 40;
        }
        return 0;
    }

    @Override
    public String toString() {
        return  description + "(EU " + euroSize + ")";
          }
}
