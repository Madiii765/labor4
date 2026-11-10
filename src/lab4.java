import java.util.Scanner;

public class lab4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Размеры матрицы - строки и столбцы
        int r = 3;
        int c = 3;
        int[][] a = new int[r][c];

        // Заполняем матрицу числами
        System.out.println("Введите матрицу 3x3:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print("[" + i + "][" + j + "]: ");
                a[i][j] = in.nextInt();
            }
        }

        boolean f = false; // нашли ли точку

        // Проверяем каждую строку
        for (int i = 0; i < r; i++) {
            // 1. Ищем минимум в i
            int min = a[i][0];
            int kj = 0; // Индекс столбца для минимума

            for (int j = 1; j < c; j++) {
                if (a[i][j] < min) {
                    min = a[i][j];
                    kj = j;
                }
            }

            // 2. максимален ли элемент в столбце kj
            boolean ok = true;
            for (int k = 0; k < r; k++) {
                if (a[k][kj] > min) {
                    ok = false; // Нашелся элемент больше,проверка не прошла
                    break;
                }
            }

            // 3. Если прошел обе проверки
            if (ok) {
                System.out.println("\nСедловая точка: " + min + " в позиции [" + i + "][" + kj + "]");
                f = true;
            }
        }

        // Если ничего нет
        if (!f) {
            System.out.println("\nСедловых точек нет.");
        }

        in.close();
    }
}
