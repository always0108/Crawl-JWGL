import java.io.Console;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        // 当使用Eclipse等IDE运行以上代码时Console中将会为null
//        Console console = System.console();
//        if(console!=null)
//        {
//            String stuNum = console.readLine("请输入学号:");
//            char[] password = console.readPassword("请输入密码:");
//            ConnectJWGL connectJWGL = new ConnectJWGL(stuNum,password.toString());
//            connectJWGL.init();
//        }else{
//            System.out.println("console == null");
//        }

        Scanner input = new Scanner(System.in);
//        System.out.println("请输入学号:");
//        String stuNum = input.next();
//        System.out.println("请输入密码:");
//        String password = input.next();
        String stuNum = "04163164";
        String password = "ldxz19980108!@";
                ConnectJWGL connectJWGL = new ConnectJWGL(stuNum,password);
        connectJWGL.init();
        connectJWGL.getStudentTimetable();
    }
}
