
public class Product {
    private String MaSP;
    private String NameSp;
    private String TypeSp;
    private String ColorSP;
    private int Price;
    private String Thumbnail;   
    private String Screen;
    private String Card;
    private String Pin;
    private String CPU;
    private String OS;
    private String SizeWeight;
    private String RAM;
    private String HardDrive;
    
    public Product(){
        
    }
    public Product(String MaSP, String NameSp, String TypeSp, String ColorSP, int Price, String Thumbnail, String Screen, String Card, String Pin, String CPU, String OS, String SizeWeight, String RAM, String HardDrive){
        this.MaSP = MaSP;
        this.NameSp = NameSp;
        this.TypeSp = TypeSp;
        this.ColorSP = ColorSP;
        this.Price = Price;
        this.Thumbnail = Thumbnail;
        this.Screen = Screen;
        this.Card = Card;
        this.Pin = Pin;
        this.CPU = CPU;
        this.OS = OS;
        this.SizeWeight = SizeWeight;
        this.RAM = RAM;
        this.HardDrive = HardDrive;

    }
 

    public Product(String MaSP, String NameSp){
        this.MaSP = MaSP;
        this.NameSp = NameSp;        
        
    }
     public Product(String MaSP){
        this.MaSP = MaSP;
        
    }
    public Product(Product product){
        this.MaSP = product.MaSP;
        this.NameSp = product.NameSp;
        this.TypeSp = product.TypeSp;
        this.ColorSP = product.ColorSP;
        this.Price = product.Price;
        this.Thumbnail = product.Thumbnail;
        
        this.Screen = product.Screen;
        this.Card = product.Card;
        this.Pin = product.Pin;
        this.CPU = product.CPU;
        this.OS = product.OS;
        this.SizeWeight = product.SizeWeight;
        this.RAM = product.RAM;
        this.HardDrive = product.HardDrive;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getNameSp() {
        return NameSp;
    }

    public void setNameSp(String NameSp) {
        this.NameSp = NameSp;
    }

    public String getTypeSp() {
        return TypeSp;
    }

    public void setTypeSp(String TypeSp) {
        this.TypeSp = TypeSp;
    }

    public String getColorSP() {
        return ColorSP;
    }

    public void setColorSP(String ColorSP) {
        this.ColorSP = ColorSP;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(String Thumbnail) {
        this.Thumbnail = Thumbnail;
    }

 

    public String getScreen() {
        return Screen;
    }

    public void setScreen(String Screen) {
        this.Screen = Screen;
    }

    public String getCard() {
        return Card;
    }

    public void setCard(String Card) {
        this.Card = Card;
    }

    public String getPin() {
        return Pin;
    }

    public void setPin(String Pin) {
        this.Pin = Pin;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getSizeWeight() {
        return SizeWeight;
    }

    public void setSizeWeight(String SizeWeight) {
        this.SizeWeight = SizeWeight;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getHardDrive() {
        return HardDrive;
    }

    public void setHardDrive(String HardDrive) {
        this.HardDrive = HardDrive;
    }
    
}
