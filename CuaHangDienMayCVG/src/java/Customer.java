
public class Customer {
    private String CustomerCode;
    private String FullName;
    private String DateOfBirth;
    private String Tel;
    private String Email;
    private String CCCD;
    private String Address;
    private String Gender;

    public Customer(){
        
    }
    public Customer(String CustomerCode, String FullName, String DateOfBirth, String Gender, String Email, String Tel, String CCCD, String Address){
        this.CustomerCode = CustomerCode;
        this.FullName = FullName;
        this.DateOfBirth = DateOfBirth;
        this.Tel = Tel;
        this.Email = Email;
        this.CCCD = CCCD;
        this.Address = Address;
        this.Gender = Gender;
    }
    public Customer( String FullName, String DateOfBirth, String Gender, String Email, String Tel, String CCCD, String Address){
        
        this.FullName = FullName;
        this.DateOfBirth = DateOfBirth;
        this.Tel = Tel;
        this.Email = Email;
        this.CCCD = CCCD;
        this.Address = Address;
        this.Gender = Gender;
    }
    
    public Customer(String CustomerCode){
        this.CustomerCode = CustomerCode;
    }
    
    public Customer(String CustomerCode, String FullName){
        this.CustomerCode = CustomerCode;
        this.FullName = FullName;
    }
    
    public Customer(Customer customer){
        this.CustomerCode = customer.CustomerCode;
        this.FullName = customer.FullName;
        this.DateOfBirth = customer.DateOfBirth;
        this.Tel = customer.Tel;
        this.Email = customer.Email;
        this.CCCD = customer.CCCD;
        this.Address = customer.Address;
        this.Gender = customer.Gender;
    }

    public String getCustomerCode() {
        return CustomerCode;
    }

    public void setCustomerCode(String CustomerCode) {
        this.CustomerCode = CustomerCode;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }
    
}
