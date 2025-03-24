package B;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Editor {
    private String id;
    private String importedDate;

    public Editor() {}

    public Editor(String id, String importedDate) {
        this.id = id;
        this.importedDate = importedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws Exception {
        if (!id.matches("^[EB]\\d+$")) { // Sửa lỗi regex
            throw new Exception("Invalid ID. Must start with 'E' or 'B' followed by digits.");
        }
        this.id = id;
    }

    public String getImportedDate() {
        return importedDate;
    }

    public void setImportedDate(String importedDate) throws Exception {
        if (!importedDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new Exception("Invalid Date Format. Use dd/mm/yyyy.");
        }
        // Kiểm tra ngày hợp lệ
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(importedDate);
        } catch (Exception e) {
            throw new Exception("Invalid Date: This date does not exist.");
        }
        this.importedDate = importedDate;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter ID: ");
            setId(sc.nextLine());
            System.out.print("Enter Imported Date (dd/mm/yyyy): ");
            setImportedDate(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void output() {
        System.out.println("Editor[ID=" + id + ", Imported Date=" + importedDate + "]");
    }
}
