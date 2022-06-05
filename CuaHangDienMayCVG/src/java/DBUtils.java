
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtils {

    public DBUtils() {

    }

    public static void insertUserAccount(Connection con, UserAccount user) throws SQLException {
        String sql = "insert into user_account values(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getGender());
        ps.setString(3, user.getPassWord());
        ps.setString(6, user.getEmail());
        ps.setString(5, user.getTel());
        ps.setString(4, user.getDateOfBirth());
        ps.setString(7, user.getAddress());
        ps.executeUpdate();
    }

    public static UserAccount findUserAccount(Connection con, UserAccount user) throws SQLException {
        String sql = "select * from user_account where username = ? and password = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getPassWord());

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            UserAccount usr = new UserAccount();
            usr.setUserName(rs.getString("username"));
            usr.setPassWord(rs.getString("password"));
            return usr;

        }
        return null;
    }

    public static boolean find(Connection con, UserAccount user) throws SQLException {
        String sql = "select * from user_account where username = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getUserName());

        ps.executeQuery();
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            UserAccount usr = new UserAccount();
            usr.setUserName(rs.getString("username"));
            usr.setPassWord(rs.getString("password"));
            return true;

        }
        return false;

    }

    //Product
    public static ArrayList<Product> AllProduct() throws SQLException {
        Connection con = null;
        ArrayList<Product> list = new ArrayList();
        try {
            con = MySQLConntUtils.getMySQLConnection();
            String sql = "select * from product ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String MaSP = rs.getString("MaSP");
                String NameSp = rs.getString("TenSP");
                String TypeSp = rs.getString("TYPE");
                String ColorSP = rs.getString("COLOR");
                int Price = rs.getInt("PRICE");
                String Thumbnail = rs.getString("THUMBNAIL");
                String Screen = rs.getString("Screen");
                String Card = rs.getString("Card");
                String Pin = rs.getString("Pin");
                String CPU = rs.getString("CPU");
                String OS = rs.getString("OS");
                String SizeWeight = rs.getString("SizeWeight");
                String RAM = rs.getString("RAM");
                String HardDrive = rs.getString("HARDDRIVE");
                Product product = new Product(MaSP, NameSp, TypeSp, ColorSP, Price, Thumbnail, Screen, Card, Pin, CPU, OS, SizeWeight, RAM, HardDrive);

                list.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AllProductServlet.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list;
    }
    
    public static Product AllProduct(String Masp) throws SQLException {
        Connection con = null;
        
        try {
            con = MySQLConntUtils.getMySQLConnection();
            String sql = "select * from product where MaSP =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, Masp);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String MaSP = rs.getString("MaSP");
                String NameSp = rs.getString("TenSP");
                String TypeSp = rs.getString("TYPE");
                String ColorSP = rs.getString("COLOR");
                int Price = rs.getInt("PRICE");
                String Thumbnail = rs.getString("THUMBNAIL");
                String Screen = rs.getString("Screen");
                String Card = rs.getString("Card");
                String Pin = rs.getString("Pin");
                String CPU = rs.getString("CPU");
                String OS = rs.getString("OS");
                String SizeWeight = rs.getString("SizeWeight");
                String RAM = rs.getString("RAM");
                String HardDrive = rs.getString("HARDDRIVE");
                Product product = new Product(MaSP, NameSp, TypeSp, ColorSP, Price, Thumbnail, Screen, Card, Pin, CPU, OS, SizeWeight, RAM, HardDrive);

                return product;
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(AllProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AllProductServlet.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
        
    }

    public static ArrayList<Product> AllProduct(Connection con) throws SQLException {
        String sql = "select * from product ";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList<Product> list = new ArrayList();
        while (rs.next()) {
            String MaSP = rs.getString("MaSP");
            String NameSp = rs.getString("TenSP");
            String TypeSp = rs.getString("TYPE");
            String ColorSP = rs.getString("COLOR");
            int Price = rs.getInt("PRICE");
            String Thumbnail = rs.getString("THUMBNAIL");
            String Screen = rs.getString("Screen");
            String Card = rs.getString("Card");
            String Pin = rs.getString("Pin");
            String CPU = rs.getString("CPU");
            String OS = rs.getString("OS");
            String SizeWeight = rs.getString("SizeWeight");
            String RAM = rs.getString("RAM");
            String HardDrive = rs.getString("HARDDRIVE");

            Product product = new Product(MaSP, NameSp, TypeSp, ColorSP, Price, Thumbnail, Screen, Card, Pin, CPU, OS, SizeWeight, RAM, HardDrive);

            list.add(product);

        }
        return list;
    }

    public static ArrayList<Product> AllProduct(Connection con, String findProdcut) throws SQLException {
        String sql = "select * from product where MaSP LIKE '%" + findProdcut + "%' OR TenSP LIKE '%" + findProdcut + "%' OR TYPE LIKE '%" + findProdcut + "%' OR COLOR LIKE '%" + findProdcut + "%' OR PRICE LIKE '%" + findProdcut + "%' OR OS LIKE '%" + findProdcut + "%' OR Pin LIKE '%" + findProdcut + "%' OR CPU LIKE '%" + findProdcut + "%' OR Card LIKE '%" + findProdcut + "%'";
        PreparedStatement ps = con.prepareStatement(sql);
        //ps.setString(1, findProdcut);
        ResultSet rs = ps.executeQuery();

        ArrayList<Product> list = new ArrayList();
        while (rs.next()) {
            String MaSP = rs.getString("MaSP");
            String NameSp = rs.getString("TenSP");
            String TypeSp = rs.getString("TYPE");
            String ColorSP = rs.getString("COLOR");
            int Price = rs.getInt("PRICE");
            String Thumbnail = rs.getString("THUMBNAIL");
            String Screen = rs.getString("Screen");
            String Card = rs.getString("Card");
            String Pin = rs.getString("Pin");
            String CPU = rs.getString("CPU");
            String OS = rs.getString("OS");
            String SizeWeight = rs.getString("SizeWeight");
            String RAM = rs.getString("RAM");
            String HardDrive = rs.getString("HARDDRIVE");
            Product product = new Product(MaSP, NameSp, TypeSp, ColorSP, Price, Thumbnail, Screen, Card, Pin, CPU, OS, SizeWeight, RAM, HardDrive);

            list.add(product);

        }
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    public static boolean findProductBoolean(Connection con, Product product) throws SQLException {
        String sql = "select * from product where MaSP = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, product.getMaSP());

        ps.executeQuery();
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String MaSP = rs.getString("MaSP");
            String TenSP = rs.getString("TenSP");
            Product prod = new Product(MaSP, TenSP);

            return true;
        }
        return false;

    }

    public static boolean findMaspProductBoolean(Connection con, Product product) throws SQLException {
        String sql = "select * from product where MaSP = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, product.getMaSP());

        ps.executeQuery();
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String MaSP = rs.getString("MaSP");
            //String TenSP = rs.getString("TenSP");
            //Product prod = new Product(MaSP, TenSP);

            return true;
        }
        return false;

    }

    //DBUtils
    public static void insertProduct(Connection con, Product product) throws SQLException {
        String sql = "insert into product values( ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, product.getMaSP());
        ps.setString(2, product.getNameSp());
        ps.setString(3, product.getTypeSp());
        ps.setInt(4, product.getPrice());
        ps.setString(5, product.getColorSP());
        ps.setString(6, product.getScreen());
        ps.setString(7, product.getThumbnail());
        ps.setString(8, product.getCard());
        ps.setString(9, product.getPin());
        ps.setString(10, product.getCPU());
        ps.setString(11, product.getOS());
        ps.setString(12, product.getSizeWeight());
        ps.setString(13, product.getRAM());
        ps.setString(14, product.getHardDrive());

        ps.executeUpdate();
    }

    public static void deleteProduct(Connection con, Product product) throws SQLException {
        String sql = "delete from product where MaSP = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, product.getMaSP());

        ps.executeUpdate();
    }

    public static void updateProduct(Connection con, Product product) throws SQLException {
        String sql = "update product set TenSP = ?, Type = ?, Color = ?, Price = ?, Thumbnail = ?, Screen = ?, Card = ?, Pin = ?, CPU = ?, OS = ?, SizeWeight = ?, RAM = ?, HardDrive = ? where MaSP = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(14, product.getMaSP());
        ps.setString(1, product.getNameSp());
        ps.setString(2, product.getTypeSp());
        ps.setString(3, product.getColorSP());
        ps.setInt(4, product.getPrice());
        ps.setString(5, product.getThumbnail());
        ps.setString(6, product.getScreen());
        ps.setString(7, product.getCard());
        ps.setString(8, product.getPin());
        ps.setString(9, product.getCPU());
        ps.setString(10, product.getOS());
        ps.setString(11, product.getSizeWeight());
        ps.setString(12, product.getRAM());
        ps.setString(13, product.getHardDrive());
        ps.executeUpdate();
    }

    //employee
    public static ArrayList<Employee> AllEmployee(Connection con) throws SQLException {
        String sql = "select * from employee ";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList<Employee> list = new ArrayList();
        while (rs.next()) {
            String EmployeeCode = rs.getString("EmployeeCode");
            String FullName = rs.getString("FullName");
            String Thumbnail = rs.getString("Thumbnail");
            String DateOfBirth = rs.getString("DateOfBirth");
            String Tel = rs.getString("Tel");
            String CCCD = rs.getString("CCCD");
            String Gender = rs.getString("Gender");
            String Email = rs.getString("Email");
            String Address = rs.getString("Address");
            String Nation = rs.getString("Nation");

            Employee employee = new Employee(EmployeeCode, FullName, Thumbnail, DateOfBirth, Gender, CCCD, Tel, Email, Address, Nation);

            list.add(employee);

        }
        return list;
    }
    
    public static Employee OneEmployee(Connection con, String MaNV) throws SQLException {
        String sql = "select * from employee WHERE EmployeeCode =? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, MaNV);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String EmployeeCode = rs.getString("EmployeeCode");
            String FullName = rs.getString("FullName");
            String Thumbnail = rs.getString("Thumbnail");
            String DateOfBirth = rs.getString("DateOfBirth");
            String Tel = rs.getString("Tel");
            String CCCD = rs.getString("CCCD");
            String Gender = rs.getString("Gender");
            String Email = rs.getString("Email");
            String Address = rs.getString("Address");
            String Nation = rs.getString("Nation");

            Employee employee = new Employee(EmployeeCode, FullName, Thumbnail, DateOfBirth, Gender, CCCD, Tel, Email, Address, Nation);

        return employee;

        }
        return null;
    }

    public static ArrayList<Employee> AllEmployee(Connection con, String FindEmployee) throws SQLException {
        String sql = "select * from EMPLOYEE where EmployeeCode LIKE '%" + FindEmployee + "%' OR FullName LIKE '%" + FindEmployee + "%' OR Gender LIKE '%" + FindEmployee + "%' OR CCCD LIKE '%" + FindEmployee + "%' OR Email LIKE '%" + FindEmployee + "%' OR Address LIKE '%" + FindEmployee + "%' OR DateOfBirth LIKE '%" + FindEmployee + "%' OR Nation LIKE '%" + FindEmployee + "%' OR Thumbnail LIKE '%" + FindEmployee + "%'";
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        ArrayList<Employee> list = new ArrayList();
        while (rs.next()) {
            String EmployeeCode = rs.getString("EmployeeCode");
            String FullName = rs.getString("FullName");
            String Thumbnail = rs.getString("Thumbnail");
            String DateOfBirth = rs.getString("DateOfBirth");
            String Tel = rs.getString("Tel");
            String CCCD = rs.getString("CCCD");
            String Gender = rs.getString("Gender");
            String Email = rs.getString("Email");
            String Address = rs.getString("Address");
            String Nation = rs.getString("Nation");

            Employee employee = new Employee(EmployeeCode, FullName, Thumbnail, DateOfBirth, Gender, CCCD, Tel, Email, Address, Nation);

            list.add(employee);
        }
        return list;
    }

    public static boolean findEmployeeBoolean(Connection con, Employee employee) throws SQLException {
        String sql = "select * from employee where EmployeeCode = ? AND Fullname = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, employee.getEmployeeCode());
        ps.setString(2, employee.getFullName());
        ps.executeQuery();
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String EmployeeCode = rs.getString("EmployeeCode");

            return true;
        }
        return false;

    }

    public static boolean findMaNVEmployeeBoolean(Connection con, Employee employee) throws SQLException {
        String sql = "select * from employee where EmployeeCode = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, employee.getEmployeeCode());

        ps.executeQuery();
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String EmployeeCode = rs.getString("EmployeeCode");

            return true;
        }
        return false;

    }

    public static void insertEmployee(Connection con, Employee employee) throws SQLException {
        String sql = "insert into employee values(?, ? ,?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, employee.getEmployeeCode());
        ps.setString(2, employee.getFullName());
        ps.setString(3, employee.getThumbnail());
        ps.setString(4, employee.getDateOfBirth());
        ps.setString(5, employee.getTel());
        ps.setString(6, employee.getEmail());
        ps.setString(7, employee.getCCCD());
        ps.setString(8, employee.getAddress());
        ps.setString(9, employee.getGender());
        ps.setString(10, employee.getNation());

        ps.executeUpdate();
    }

    public static void deleteEmployee(Connection con, Employee employee) throws SQLException {
        String sql = "delete from employee where EMPLOYEECODE = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, employee.getEmployeeCode());

        ps.executeUpdate();
    }

    public static void updateEmployee(Connection con, Employee employee) throws SQLException {
        String sql = "update employee set Nation = ?, FullName = ?, Thumbnail = ?, DateOfBirth = ?, Tel = ?, Email = ?, CCCD =?, Address = ?, Gender = ? where EmployeeCode = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, employee.getNation());
        ps.setString(2, employee.getFullName());
        ps.setString(3, employee.getThumbnail());
        ps.setString(4, employee.getDateOfBirth());
        ps.setString(5, employee.getTel());
        ps.setString(6, employee.getEmail());
        ps.setString(7, employee.getCCCD());
        ps.setString(8, employee.getAddress());
        ps.setString(9, employee.getGender());
        ps.setString(10, employee.getEmployeeCode());

        ps.executeUpdate();
    }

    //orders
    public static ArrayList<Order> AllOrder(Connection con) throws SQLException {
        String sql = "select * from Orders ";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList<Order> list = new ArrayList();
        while (rs.next()) {
            String EmployeeName = rs.getString("EmployeeName");
            String OrderCode = rs.getString("OrderCode");
            String CustomerName = rs.getString("CustomerName");
            String ProductName = rs.getString("ProductName");
            String OrderDate = rs.getString("OrderDate");
            int Amount = rs.getInt("Amount");
            int Quantity = rs.getInt("Quantity");
            String PaymentMethod = rs.getString("PaymentMethod");

            Order order = new Order(OrderCode, EmployeeName, CustomerName, ProductName, OrderDate, Amount, Quantity, PaymentMethod);

            list.add(order);

        }
        return list;
    }
    public static ArrayList<Product> AllMaSP(Connection con) throws SQLException {
        String sql = "select masp from product ";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList<Product> list = new ArrayList();
        while (rs.next()) {
            String masp = rs.getString("masp");
            Product product = new Product(masp);
            list.add(product);
        }
        return list;
    }
    public static Order OneOrder(Connection con, String orderCode) throws SQLException {
        String sql = "select * from Orders where OrderCode = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, orderCode);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String CustomerName = rs.getString("CustomerName");
            String OrderCode = rs.getString("OrderCode");
            String EmployeeName = rs.getString("EmployeeName");
            String ProductName = rs.getString("ProductName");
            String OrderDate = rs.getString("OrderDate");
            int Amount = rs.getInt("Amount");
            int Quantity = rs.getInt("Quantity");
            String PaymentMethod = rs.getString("PaymentMethod");

            Order order = new Order(OrderCode, EmployeeName, CustomerName, ProductName, OrderDate, Amount, Quantity, PaymentMethod);

            return order;

        }
        return null;
    }
    
    public static ArrayList<Order> AllFindOrder(Connection con, String FindOrder) throws SQLException {
        String sql = "select * from Orders where  EmployeeName LIKE '%" + FindOrder + "%' OR CustomerName LIKE '%" + FindOrder + "%' OR ProductName LIKE '%" + FindOrder + "%' OR OrderDate LIKE '%" + FindOrder + "%' OR Amount LIKE '%" + FindOrder + "%' OR Quantity LIKE '%" + FindOrder + "%'";
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        ArrayList<Order> list = new ArrayList();
        while (rs.next()) {
            String CustomerName = rs.getString("CustomerName");
            String OrderCode = rs.getString("OrderCode");
            String EmployeeName = rs.getString("EmployeeName");
            String ProductName = rs.getString("ProductName");
            String OrderDate = rs.getString("OrderDate");
            int Amount = rs.getInt("Amount");
            int Quantity = rs.getInt("Quantity");
            String PaymentMethod = rs.getString("PaymentMethod");

            Order order = new Order( OrderCode, EmployeeName, CustomerName, ProductName, OrderDate, Amount, Quantity, PaymentMethod);

            list.add(order);
        }
        return list;
    }

    public static boolean findOrderCodeBoolean(Connection con, Order order) throws SQLException {
        String sql = "select * from Orders where OrderCode = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, order.getOrderCode());

        ps.executeQuery();
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String OrderCode = rs.getString("OrderCode");
            return true;
        }
        return false;

    }

    public static void insertOrder(Connection con, Order order) throws SQLException {
        String sql = "insert into Orders(EmployeeName, CustomerName, ProductName, OrderDate, Quantity, Amount, PaymentMethod ) values( ? ,?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        //ps.setString(1, order.getOrderCode());
        ps.setString(1, order.getEmployeeName());
        ps.setString(2, order.getCustomerName());
        ps.setString(3, order.getProductName());
        ps.setString(4, order.getOrderDate());
        ps.setInt(5, order.getQuantity());
        ps.setInt(6, order.getAmount());
        ps.setString(7, order.getPaymentMethod());

        ps.executeUpdate();
    }

    public static void deleteOrder(Connection con, Order order) throws SQLException {
        String sql = "delete from Orders where OrderCode = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, order.getOrderCode());

        ps.executeUpdate();
    }

    public static void UpdateOrder(Connection con, Order order) throws SQLException {
        String sql = "update Orders set Quantity = ?, CustomerName = ?, EmployeeName = ?, ProductName = ?, OrderDate = ?, Amount = ?, PaymentMethod = ? where OrderCode = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(8, order.getOrderCode());
        ps.setString(2, order.getCustomerName());
        ps.setString(3, order.getEmployeeName());
        ps.setString(4, order.getProductName());
        ps.setString(5, order.getOrderDate());
        ps.setInt(1, order.getQuantity());
        ps.setFloat(6, order.getAmount());
        ps.setString(7, order.getPaymentMethod());

        ps.executeUpdate();
    }

    //Customer
    public static ArrayList<Customer> AllCustomer(Connection con) throws SQLException {
        String sql = "select * from Customer ";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList<Customer> list = new ArrayList();
        while (rs.next()) {
            String CustomerCode = rs.getString("CustomerCode");
            String Gender = rs.getString("Gender");
            String Fullname = rs.getString("Fullname");
            String DateOfBirth = rs.getString("DateOfBirth");
            String Tel = rs.getString("Tel");
            String Email = rs.getString("Email");
            String CCCD = rs.getString("CCCD");
            String Address = rs.getString("Address");

            Customer customer = new Customer(CustomerCode, Fullname, DateOfBirth, Gender, Email, Tel, CCCD, Address);

            list.add(customer);

        }
        return list;
    }
    
    public static Customer OneCustomer(Connection con, String Customercode) throws SQLException {
        String sql = "select * from Customer where Customercode = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, Customercode);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String CustomerCode = rs.getString("CustomerCode");
            String Gender = rs.getString("Gender");
            String Fullname = rs.getString("Fullname");
            String DateOfBirth = rs.getString("DateOfBirth");
            String Tel = rs.getString("Tel");
            String Email = rs.getString("Email");
            String CCCD = rs.getString("CCCD");
            String Address = rs.getString("Address");

            Customer customer = new Customer(CustomerCode, Fullname, DateOfBirth, Gender, Email, Tel, CCCD, Address);

            return customer;

        }
        return null;
    }

    public static ArrayList<Customer> AllFindCustomer(Connection con, String FindCustomer) throws SQLException {
        String sql = "select * from Customer where CustomerCode LIKE '%" + FindCustomer + "%' OR Gender LIKE '%" + FindCustomer + "%' OR Fullname LIKE '%" + FindCustomer + "%' OR DateOfBirth LIKE '%" + FindCustomer + "%' OR Email LIKE '%" + FindCustomer + "%' OR Tel LIKE '%" + FindCustomer + "%' OR CCCD LIKE '%" + FindCustomer + "%' OR Address LIKE '%" + FindCustomer + "%'";
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        ArrayList<Customer> list = new ArrayList();
        while (rs.next()) {
            String CustomerCode = rs.getString("CustomerCode");
            String Gender = rs.getString("Gender");
            String Fullname = rs.getString("Fullname");
            String DateOfBirth = rs.getString("DateOfBirth");
            String Tel = rs.getString("Tel");
            String Email = rs.getString("Email");
            String CCCD = rs.getString("CCCD");
            String Address = rs.getString("Address");

            Customer customer = new Customer(CustomerCode, Fullname, DateOfBirth, Gender, Email, Tel, CCCD, Address);

            list.add(customer);
        }
        return list;
    }

    public static boolean findCustomerCodeBoolean(Connection con, Customer customer) throws SQLException {
        String sql = "select * from Customer where CustomerCode = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, customer.getCustomerCode());

        ps.executeQuery();
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String CustomerCode = rs.getString("CustomerCode");
            return true;
        }
        return false;

    }

    public static void iinsertCustomer(Connection con, Customer customer) throws SQLException {
        String sql = "insert into Customer values(?, ? ,?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, customer.getCustomerCode());
        ps.setString(2, customer.getFullName());
        ps.setString(3, customer.getDateOfBirth());
        ps.setString(4, customer.getGender());
        ps.setString(5, customer.getEmail());
        ps.setString(6, customer.getTel());
        ps.setString(7, customer.getCCCD());
        ps.setString(8, customer.getAddress());

        ps.executeUpdate();
    }
    public static void insertCustomer(Connection con, Customer customer) throws SQLException {
        String sql = "insert into Customer(fullname, dateofbirth, gender, email, tel, cccd, address) values( ? ,?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        
        ps.setString(1, customer.getFullName());
        ps.setString(2, customer.getDateOfBirth());
        ps.setString(3, customer.getGender());
        ps.setString(4, customer.getEmail());
        ps.setString(5, customer.getTel());
        ps.setString(6, customer.getCCCD());
        ps.setString(7, customer.getAddress());

        ps.executeUpdate();
    }

    public static void deleteCustomer(Connection con, Customer customer) throws SQLException {
        String sql = "delete from Customer where CustomerCode = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, customer.getCustomerCode());

        ps.executeUpdate();
    }

    public static void UpdateCustomer(Connection con, Customer customer) throws SQLException {
        String sql = "update Customer set Address = ?, FullName = ?, DateOfBirth = ?, Gender = ?, Email = ?, Tel = ?, CCCD = ?  where CustomerCode = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(8, customer.getCustomerCode());
        ps.setString(2, customer.getFullName());
        ps.setString(3, customer.getDateOfBirth());
        ps.setString(4, customer.getGender());
        ps.setString(5, customer.getEmail());
        ps.setString(6, customer.getTel());
        ps.setString(7, customer.getCCCD());
        ps.setString(1, customer.getAddress());

        ps.executeUpdate();
    }

}
