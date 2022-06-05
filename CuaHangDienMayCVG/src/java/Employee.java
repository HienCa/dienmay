
import java.sql.Date;


public class Employee {
    private String EmployeeCode;
    private String Thumbnail;
    private String FullName;
    private String DateOfBirth;
    private String Tel;
    private String Email;
    private String Address;
    private String Gender;
    private String CCCD;
    private String Nation;
    public Employee(){
        
    }
    
    public Employee(String EmployeeCode){
        this.EmployeeCode = EmployeeCode;
    }
    public Employee(String EmployeeCode, String FullName, String Thumbnail, String DateOfBirth , String Gender, String CCCD, String Tel, String Email, String Address, String Nation ){
        this.EmployeeCode = EmployeeCode;
        this.FullName = FullName;
        this.DateOfBirth = DateOfBirth;
        this.Gender = Gender;
        this.CCCD = CCCD;
        this.Tel = Tel;
        this.Email = Email;
        this.Address = Address;
        this.Nation = Nation;
        this.Thumbnail = Thumbnail;
        
    }
    public Employee(String EmployeeCode, String FullName, String DateOfBirth , String Gender, String CCCD, String Tel, String Email, String Address, String Nation ){
        this.EmployeeCode = EmployeeCode;
          this.FullName = FullName;
        this.DateOfBirth = DateOfBirth;
        this.Gender = Gender;
        this.CCCD = CCCD;
        this.Tel = Tel;
        this.Email = Email;
        this.Address = Address;
        this.Nation = Nation;
        
    }
    public Employee(String EmployeeCode, String FullName ){
        this.EmployeeCode = EmployeeCode;
        this.FullName = FullName;    
    }

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String EmployeeCode) {
        this.EmployeeCode = EmployeeCode;
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

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getNation() {
        return Nation;
    }

    public void setNation(String Nation) {
        this.Nation = Nation;
    }

    public String getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(String Thumbnail) {
        this.Thumbnail = Thumbnail;
    }
    
    
}
