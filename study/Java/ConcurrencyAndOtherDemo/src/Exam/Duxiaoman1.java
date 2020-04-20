package Exam;

import java.util.Scanner;

/**
 * 滑动窗口
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 在机器学习中有一种流行的池化操作，而在池化操作中，3*3极大值池化应用十分广泛。什么是3*3极大值池化呢？设原矩阵是n*m的，则3*3极大值池化就是枚举矩阵中的所有3*3的子矩阵,分别求最大值并顺次拼接而成，处理过后的矩阵是(n-2)*(m-2)。
 * <p>
 * 例如，原矩阵是[[1,2,3,4],[5,6,7,8],[9,10,11,12]],经过池化之后就变成[[11,12]]。
 * <p>
 * 为了提高难度，选择的滑动窗口并不是3*3的，而是a*b的，由于输入可能是非常大的，原n*m的矩阵权值由以下公式计算得到，h(i,j)=i*j mod 10。(1<=i<=n,1<=j<=m)
 * <p>
 * 由于输出矩阵也是一个很麻烦的事情，因此你只需输出经过a*b池化处理后的矩阵的元素之和即可。
 * <p>
 * 输入
 * 输入第一行包含四个正整数，n,m,a,b，分别表示原矩阵的行列数量和滑动窗口的行列数量。(1<=n,m,a,b<=1000)
 * <p>
 * 输出
 * 输出仅包含一个整数，即新矩阵的元素之和。
 * <p>
 * 样例输入
 * 4 5 3 3
 * 样例输出
 * 54
 */
public class Duxiaoman1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        long ans = 0;

        int hang[][] = new int[n + 1][m + 1];
        int que[] = new int[1000 + 10];
        int front = 0;
        int tail = 0;
        for (int i = 1; i <= n; i++) {
            front = 0;
            tail = 0;
            for (int j = 1; j <= m; j++) {
                while (front < tail && (i * que[tail - 1]) % 10 <= (i * j) % 10) tail--;
                que[tail++] = j;
                while (front < tail && (j - que[front] + 1 > b)) front++;
                hang[i][j] = (i * que[front]) % 10;
            }
        }

        for (int i = b; i <= m; i++) {
            front = 0;
            tail = 0;
            for (int j = 1; j <= n; j++) {
                while (front < tail && hang[que[tail - 1]][i] <= hang[j][i]) tail--;
                que[tail++] = j;
                while (front < tail && (j - que[front] + 1 > a)) front++;
                if (j >= a) {
                    // System.out.println(i+" "+j+" "+hang[que[front]][i]);
                    ans += 1L * hang[que[front]][i];
                }
            }
        }
        System.out.println(ans);
    }
}
