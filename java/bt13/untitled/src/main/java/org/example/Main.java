package org.example;

import org.example.exception.BirthDayException;
import org.example.exception.EmailException;
import org.example.exception.FullNameException;
import org.example.exception.PhoneException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            System.out.println("1. Thêm nhân viên mới");
            System.out.println("2. Sửa thông tin nhân viên");
            System.out.println("3. Xóa nhân viên");
            System.out.println("4. Tìm kiếm nhân viên thực tập");
            System.out.println("5. Tìm kiếm nhân viên có kinh nghiệm");
            System.out.println("6. Tìm kiếm nhân viên mới ra trường");
            System.out.println("7. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc bỏ dòng mới sau khi nhập số

            switch (choice) {
                case 1:
                    try {
                        addEmployee(scanner, dateFormat);
                    } catch (ParseException e) {
                        System.out.println("Ngày sinh không hợp lệ. Vui lòng thử lại.");
                    }
                    break;
                case 2:
                    editEmployee(scanner);
                    break;
                case 3:
                    deleteEmployee(scanner);
                    break;
                case 4:
                    findInterns();
                    break;
                case 5:
                    findExperiencedEmployees();
                    break;
                case 6:
                    findFreshers();
                    break;
                case 7:
                    System.out.println("Chương trình kết thúc.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void addEmployee(Scanner scanner, SimpleDateFormat dateFormat) throws ParseException {
        try {
            System.out.print("Nhập ID: ");
            String id = scanner.nextLine();

            System.out.print("Nhập tên đầy đủ: ");
            String fullName = scanner.nextLine();
            EmployeeValidator.validateFullName(fullName);

            System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
            String dateString = scanner.nextLine();
            Date birthDay = dateFormat.parse(dateString);
            EmployeeValidator.validateBirthDate(dateString);

            System.out.print("Nhập số điện thoại: ");
            String phone = scanner.nextLine();
            EmployeeValidator.validatePhone(phone);

            System.out.print("Nhập email: ");
            String email = scanner.nextLine();
            EmployeeValidator.validateEmail(email);

            System.out.println("Chọn loại nhân viên: 0 - Experience, 1 - Fresher, 2 - Intern");
            int employeeType = scanner.nextInt();
            scanner.nextLine();

            Employee employee;
            switch (employeeType) {
                case 0:
                    System.out.print("Nhập số năm kinh nghiệm: ");
                    int expInYear = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nhập kỹ năng chuyên môn: ");
                    String proSkill = scanner.nextLine();

                    employee = new Experience(id, fullName, birthDay, phone, email, employeeType, expInYear, proSkill);
                    break;
                case 1:
                    System.out.print("Nhập ngày tốt nghiệp (dd/MM/yyyy): ");
                    Date graduationDate = dateFormat.parse(scanner.nextLine());

                    System.out.print("Nhập xếp loại tốt nghiệp: ");
                    String graduationRank = scanner.nextLine();

                    System.out.print("Nhập trường tốt nghiệp: ");
                    String education = scanner.nextLine();

                    employee = new Fresher(id, fullName, birthDay, phone, email, employeeType, graduationDate, graduationRank, education);
                    break;
                case 2:
                    System.out.print("Nhập chuyên ngành đang học: ");
                    String majors = scanner.nextLine();

                    System.out.print("Nhập học kỳ đang học: ");
                    int semester = scanner.nextInt();
                    scanner.nextLine();  // Đọc bỏ dòng mới sau khi nhập số

                    System.out.print("Nhập tên trường đang học: ");
                    String universityName = scanner.nextLine();

                    employee = new Intern(id, fullName, birthDay, phone, email, employeeType, majors, semester, universityName);
                    break;
                default:
                    System.out.println("Loại nhân viên không hợp lệ. Vui lòng thử lại.");
                    return;
            }

            employees.add(employee);
            System.out.println("Nhân viên đã được thêm thành công.");
        } catch (FullNameException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (BirthDayException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (PhoneException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (EmailException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void editEmployee(Scanner scanner) {
        System.out.print("Nhập ID của nhân viên cần sửa: ");
        String id = scanner.nextLine();

        Employee employee = findEmployeeById(id);
        if (employee != null) {
            System.out.print("Nhập tên đầy đủ mới (bỏ qua nếu không muốn thay đổi): ");
            String fullName = scanner.nextLine();
            if (!fullName.isEmpty()) {
                employee.setFullName(fullName);
            }

            System.out.print("Nhập số điện thoại mới (bỏ qua nếu không muốn thay đổi): ");
            String phone = scanner.nextLine();
            if (!phone.isEmpty()) {
                employee.setPhone(phone);
            }

            System.out.print("Nhập email mới (bỏ qua nếu không muốn thay đổi): ");
            String email = scanner.nextLine();
            if (!email.isEmpty()) {
                employee.setEmail(email);
            }

            System.out.println("Thông tin nhân viên đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy nhân viên với ID đã nhập.");
        }
    }

    private static void deleteEmployee(Scanner scanner) {
        System.out.print("Nhập ID của nhân viên cần xóa: ");
        String id = scanner.nextLine();

        Employee employee = findEmployeeById(id);
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Nhân viên đã được xóa.");
        } else {
            System.out.println("Không tìm thấy nhân viên với ID đã nhập.");
        }
    }

    private static void findInterns() {
        System.out.println("Danh sách nhân viên thực tập:");
        for (Employee employee : employees) {
            if (employee instanceof Intern) {
                employee.showInfo();
            }
        }
    }

    private static void findExperiencedEmployees() {
        System.out.println("Danh sách nhân viên có kinh nghiệm:");
        for (Employee employee : employees) {
            if (employee instanceof Experience) {
                employee.showInfo();
            }
        }
    }

    private static void findFreshers() {
        System.out.println("Danh sách nhân viên mới ra trường:");
        for (Employee employee : employees) {
            if (employee instanceof Fresher) {
                employee.showInfo();
            }
        }
    }

    private static Employee findEmployeeById(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }
}
