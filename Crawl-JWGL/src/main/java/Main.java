import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入学号:");
        String stuNum = input.next();
        ConnectJWGL connectJWGL = new ConnectJWGL();
        connectJWGL.init();
        System.out.println("请输入加密后的密码:");
        String password = input.next();
        connectJWGL.beginLogin(stuNum,password);
    }

}
