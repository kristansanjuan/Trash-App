package com.example.imageclassifier;

public class ItemsClass {

    String itemTitle;
    String wasteType;
    String description;
    String intro;
    String disposal;
    int imageId;
    int backgroundId;
    int colorId;
    int sampleImageId;

    public ItemsClass(String itemTitle, String wasteType, String description, String intro, String disposal, int imageId, int colorId, int sampleImageId) {
        this.itemTitle = itemTitle;
        this.wasteType = wasteType;
        this.description = description;
        this.intro = intro;
        this.disposal = disposal;
        this.imageId = imageId;
        //this.backgroundId = backgroundId;
        this.colorId = colorId;
        this.sampleImageId = sampleImageId;
    }

    public String getItemTitle() { return itemTitle; }
    public String getWasteType() { return wasteType; }
    public String getDescription() { return description; }
    public String getIntro() { return intro; }
    public String getDisposal() { return disposal; }
    public int getImageId() { return imageId; }
    //public int getBackgroundId() { return backgroundId; }
    public int getColorId() { return colorId; }
    public int getSampleImageId() { return sampleImageId; }

}
