
public class Order {
    private String OrderCode;
    private String EmployeeName;
    private String CustomerName;
    private String ProductName;
    private String OrderDate;
    private int  Amount;
    private int Quantity;
    private String PaymentMethod;

    
    public Order(){
        
    }
    public Order(String OrderCode, String EmployeeName, String CustomerName, String ProductName, String OrderDate, int Amount, int Quantity, String PaymentMethod){
        this.OrderCode = OrderCode;
        this.EmployeeName = EmployeeName;
        this.CustomerName = CustomerName;
        this.ProductName = ProductName;
        this.OrderDate = OrderDate;
        this.Amount = Amount;
        this.Quantity = Quantity;
        this.PaymentMethod = PaymentMethod;
    }
    public Order( String EmployeeName, String CustomerName, String ProductName, String OrderDate, int Amount, int Quantity, String PaymentMethod){
       
        this.EmployeeName = EmployeeName;
        this.CustomerName = CustomerName;
        this.ProductName = ProductName;
        this.OrderDate = OrderDate;
        this.Amount = Amount;
        this.Quantity = Quantity;
        this.PaymentMethod = PaymentMethod;
    }
      public Order(String OrderCode){
        this.OrderCode = OrderCode;
        
    }

    public Order(Order order){
        this.OrderCode = order.OrderCode;
        this.EmployeeName = order.EmployeeName;
        this.CustomerName = order.CustomerName;
        this.ProductName = order.ProductName;
        this.OrderDate = order.OrderDate;
        this.Amount = order.Amount;
        this.Quantity = order.Quantity;
        this.PaymentMethod = order.PaymentMethod;
    }

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String OrderCode) {
        this.OrderCode = OrderCode;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String EmployeeName) {
        this.EmployeeName = EmployeeName;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductCode(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }
    
    
}
