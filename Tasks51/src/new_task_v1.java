import java.util.*;


public class new_task_v1 {
    public static void main(String arg[]) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Введите номер задачи, которую хотите протестировать");
        int test_num=sc.nextInt();
        switch (test_num){
            case 1:
                sc.nextLine();
                System.out.println("Введите первую строку");
                String s1 = sc.nextLine();
                System.out.println("Введите вторую строку");
                String s2 = sc.nextLine();
                System.out.println(hiddenAnagram(s1, s2));
                break;
            case 2:
                sc.nextLine();
                System.out.println("Введите первую строку");
                String s = sc.nextLine();
                System.out.println("Введите вторую строку");
                int n = sc.nextInt();
                System.out.println(collect(s, n));
                break;
            case 3:
                sc.nextLine();
                System.out.println("Введите первую строку");
                String x = sc.nextLine();
                System.out.println("Введите вторую строку");
                String  y = sc.nextLine();
                System.out.println(nicoCipher(x, y));
                break;

            case 4:
                sc.nextLine();
                Scanner inp = new Scanner(System.in); // Объявляем Scanner
                System.out.println("Введите размер массива.");
                int size = inp.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
                int[] x2 = new int[size]; // Создаём массив int размером в size
                System.out.println("Введите значения массива.");
                for (int i = 0; i < size; i++) {
                    x2[i] = inp.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
                }
                System.out.println("Введите второе значение.");
                int y2 = sc.nextInt();
                System.out.println(Arrays.toString(twoProduct(x2, y2)));
                break;

            case 5:
                sc.nextLine();
                System.out.println("Введите значение.");
                int x1 = sc.nextInt();
                System.out.println(Arrays.toString(isExact(x1)));
                break;
        }
    }

    public static String hiddenAnagram(String t, String p) {
        t = t.toLowerCase().replaceAll("[^a-z]", "");
        p = p.toLowerCase().replaceAll(" ", "");

        for(int i = 0; i < t.length() - p.length() +1; i++){
            if(p.indexOf(t.charAt(i)) > -1){
                String subT = t.substring(i, i + p.length());
                if(isAnagram(subT, p)){ return subT;}
            }
        }
        return "noutfond";
    }

    private static boolean isAnagram(String str1, String str2){
        StringBuilder s = new StringBuilder(str2);
        for(int i=0; i<str1.length(); i++){
            int in = s.indexOf(String.valueOf(str1.charAt(i)));
            if(in == -1){
                return false;
            }

            s.setCharAt(in, '-');
        }

        return true;
    }


    public static String[] collect(String s, int n) {
        String[] result = new String[s.length()/n];
        for (int i = 0, j=0, k=n; i < result.length; i++, j+=n, k+=n) {
            result[i] = s.substring(j, k);
        }
        Arrays.sort(result);
        return result;
    }

    public static String nicoCipher(String x, String y){
        int len = x.length();
        int ylen = y.length();
        int r = (len-len%ylen)/ylen;
        if (len%ylen != 0) {
            r++;
        }
        for (int i = len; i < r*ylen; i++) {
            x += " ";
        }
        char[][][] v = new char[r][ylen][2];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < ylen; j++) {
                v[i][j][0] = x.charAt(i*ylen+j);
                v[i][j][1] = y.charAt(j);
            }
            Arrays.sort(v[i], (a,b) ->(int) a[1] - (int) b[1]);
        }
        String s = "";
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < ylen; j++) {
                s += v[i][j];
            }
        }
        return s;
    }

    public static int[] twoProduct(int[] arr, int n) {
        for(int i=0;i<arr.length;i++){
            for(int j=i;j>=0;j--){
                if(arr[i]*arr[j]==n){
                    return new int[]{arr[j],arr[i]};
                }
            }
        }
        return new int[]{};

    }
    public static int[] isExact(int x1){
        int i = 0;
        int res = calculateFactorial (i);
        int[] resses = new int[2];
        while (x1 > res) {
            i++;
            res = calculateFactorial(i);
            if(x1 == res){
                resses [0] = res;
                resses[1] = i;
                return resses;
            }
        }
        return resses;
    }
    static int calculateFactorial(int i){
        int result = 1;
        for (int n = 1; n <=i; n ++){
            result = result*n;
        }
        return result;
    }

}
