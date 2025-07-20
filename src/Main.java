
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack undoStack = new Stack(100);
        Stack redoStack = new Stack(100);

        System.out.println("=== Program Undo/Redo ===");
        System.out.println("Ketik teks untuk menambah, 'undo' untuk membatalkan, 'redo' untuk mengulang, dan 'exit' untuk keluar.");
        System.out.println();

        while (true) {
            System.out.print("Masukkan perintah/teks: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Program selesai.");
                break;
            }

            // Perintah UNDO
            if (input.equalsIgnoreCase("undo")) {
                if (!undoStack.isEmpty()) {
                    Object last = undoStack.pop();
                    redoStack.push(last);
                    System.out.println("Undo berhasil: " + last);
                } else {
                    System.out.println("Tidak ada teks untuk di-undo.");
                }
            } // Perintah REDO
            else if (input.equalsIgnoreCase("redo")) {
                if (!redoStack.isEmpty()) {
                    Object redoWord = redoStack.pop();
                    undoStack.push(redoWord);
                    System.out.println("Redo berhasil: " + redoWord);
                } else {
                    System.out.println("Tidak ada teks untuk di-redo.");
                }
            } // Input teks baru
            else {
                undoStack.push(input);
                redoStack = new Stack(100); // kosongkan redo stack
                System.out.println("Teks '" + input + "' ditambahkan.");
            }

            // Tampilkan isi teks saat ini
            System.out.print("Teks saat ini: ");
            printStack(undoStack);
        }

        scanner.close();
    }

    // Fungsi cetak isi stack
    static void printStack(Stack stack) {
        Object[] content = stack.getContents();
        for (Object item : content) {
            if (item != null) {
                System.out.print(item + " ");
            }
        }
        System.out.println();
    }
}
