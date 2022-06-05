

public class UserAccount {
    private String userName;
    private String passWord;
    private String gender;
    private String dateOfBirth;
    private String tel;
    private String email;
    private String address;
    
    public UserAccount(){
     
    }
    public UserAccount(String username){
        this.userName = username;
    }
    
    public UserAccount(String username, String password, String gender, String email, String tel, String dateOfBirth, String address){
        this.userName = username;
        this.passWord = password;
        this.gender = gender;
        this.email = email;
        this.tel = tel;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;

                
    }
    
    public UserAccount(String username, String password, String gender){
        this.userName = username;
        this.passWord = password;
        this.gender = gender;
    }
    public UserAccount(String username, String password){
        this.userName = username;
        this.passWord = password;
    }
    public UserAccount(UserAccount userAccount){
        this.userName = userAccount.userName;
        this.passWord = userAccount.passWord;
        this.gender = userAccount.gender;
    }

    UserAccount(String username, String password1, String gender, String email, String tel, java.util.Date dateOfBirth, String address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}

