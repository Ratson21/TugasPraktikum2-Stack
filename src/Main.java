import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack undoStack = new Stack(100);
        Stack redoStack = new Stack(100);

        System.out.print("Masukkan teks: ");
        String input = scanner.nextLine();
        String[] words = input.split("\\s+"); // Pisahkan per kata

        // Push semua kata ke undo stack satu per satu
        for (String word : words) {
            undoStack.push(word);
        }

        // Tampilkan hasil awal
        System.out.print("Teks saat ini: ");
        printStack(undoStack);

        // Undo (hapus kata terakhir, simpan ke redo)
        if (!undoStack.isEmpty()) {
            Object last = undoStack.pop();
            redoStack.push(last);
        }
        System.out.print("Undo: ");
        printStack(undoStack);

        // Redo (ambil dari redo, kembalikan ke undo)
        if (!redoStack.isEmpty()) {
            Object redoWord = redoStack.pop();
            undoStack.push(redoWord);
        }
        System.out.print("Redo: ");
        printStack(undoStack);
    }

    // Cetak isi stack sebagai kalimat
    static void printStack(Stack stack) {
        Object[] content = stack.getContents();
        for (int i = 0; i < content.length; i++) {
            if (content[i] != null) {
                System.out.print(content[i] + " ");
            }
        }
        System.out.println();
    }
}