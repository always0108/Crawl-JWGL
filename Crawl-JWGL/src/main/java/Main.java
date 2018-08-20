import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入学号:");
        String stuNum = input.next();
        System.out.print("请输入密码:");
        String password = input.next();
        ConnectJWGL connectJWGL = new ConnectJWGL(stuNum,password);
        connectJWGL.init();
        if(connectJWGL.beginLogin()){
            connectJWGL.getStudentInformaction();
            System.out.println("---查询课表---");
            System.out.print("输入学年（2018-2019就输2018）:");
            int year = input.nextInt();
            System.out.print("输入学期（1或2）:");
            int term = input.nextInt();
            connectJWGL.getStudentTimetable(year,term);
            System.out.print("输入学年（2018-2019就输2018）:");
            year = input.nextInt();
            System.out.print("输入学期（1或2）:");
            term = input.nextInt();
            connectJWGL.getStudentGrade(year,term);
        }
        connectJWGL.logout();
        input.close();
    }
}
