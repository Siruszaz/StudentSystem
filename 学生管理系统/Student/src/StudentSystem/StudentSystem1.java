package StudentSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem1 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        ABS: while (true) {
            System.out.println("-----------------------欢迎来到学生管理系统---------------------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查询学生");
            System.out.println("5.退出");
            System.out.println("请输入您的选择");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case "1":
                    aStudent(list);
                    break;
                case "2":
                    bStudent(list);
                    break;
                case "3":
                    cStudent(list);
                    break;
                case "4":
                    dStudent(list);
                    break;
                case "5": {
                    System.out.println("退出");
                    break ABS;
                }
                default:
                    System.out.println("没有这种选择");
                    break;
            }
        }
    }

    public static void aStudent(ArrayList<Student> list) {
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        String id = null;
        while (true) {
            System.out.println("请输入学生的id");
            id = sc.next();
            boolean flag = contains(list, id);
            if (flag) {
                System.out.println("id存在,请重新输入");
            } else {
                s.setId(id);
                break;
            }
        }
        System.out.println("请输入学生的姓名");
        String name = sc.next();
        s.setName(name);

        System.out.println("请输入学生的年龄");
        int age = sc.nextInt();
        s.setAge(age);

        System.out.println("请输入学生的住址");
        String address = sc.next();
        s.setAddress(address);

        list.add(s);
        System.out.println("学生信息添加成功");
    }

    public static void bStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的id");
        String id = sc.next();
        int index = getIndex(list, id);
        if (index >= 0) {
            list.remove(index);
            System.out.println("id信息已被删除");
        } else {
            System.out.println("id不存在,删除失败");
        }
    }

    public static void cStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生的id");
        String id = sc.next();
        int index = getIndex(list, id);
        if (index == -1) {
            System.out.println("要修改的学生信息不存在");
            return;
        }

        Student stu = list.get(index);

        System.out.println("请输入要修改的学生姓名");
        String newName = sc.next();
        stu.setName(newName);

        System.out.println("请输入要修改的学生年龄");
        int newAge = sc.nextInt();
        stu.setAge(newAge);

        System.out.println("请输入要修改的学生住址");
        String newAddress = sc.next();
        stu.setAddress(newAddress);

        System.out.println("您已完成修改");
    }

    public static void dStudent(ArrayList<Student> list) {
        if (list.size() == 0) {
            System.out.println("没有查询到学生的信息");
            return;
        }
        System.out.println("id\t姓名\t年龄\t住址");
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getAddress());
        }
    }

    public static boolean contains(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            String sid = stu.getId();
            if (sid.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static int getIndex(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            String sid = stu.getId();
            if (sid.equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
