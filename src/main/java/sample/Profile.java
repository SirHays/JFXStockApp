package sample;

public final class Profile {
    private String company;
    private String sharePrice;
    private String marketOpen;
    private String previousClose;
    private String volume;
    private String marketCap;
    private String marketChange;



    public Profile (String company,String sharePrice,String marketOpen,String previousClose,String volume,String marketCap,String marketChange){
        this.company =company;
        this.sharePrice = sharePrice;
        this.marketOpen = marketOpen;
        this.previousClose = previousClose;
        this.volume = volume;
        this.marketCap = marketCap;
        this.marketChange = marketChange;

    }
    public String getCompanyName(){
        return company;
    }
    public String getSharePrice() {
        return sharePrice;
    }
    public String getMarketOpen(){
        return marketOpen;
    }
    public String getPreviousClose(){
        return previousClose;
    }
    public String getVolume(){
        return volume;
    }
    public String getMarketCap(){
        return marketCap;
    }
    public String getMarketChange(){
        return marketChange;
    }

}
