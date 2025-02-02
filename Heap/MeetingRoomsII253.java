package Heap;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII253 {
    public static int MAXN = 10001;

    public static int[][] line = new int[MAXN][2];

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                line[i][0] = (int) in.nval;
                in.nextToken();
                line[i][1] = (int) in.nval;
            }
            out.println(compute());
        }
        out.flush();
        out.close();
        br.close();
    }

    public static int compute() {
        // 堆的清空
        size = 0;

        // 线段一共有n条，line[0...n-1][2] : line[i][0] line[i][1], 左闭右闭
        // 所有线段，根据开始位置排序，结束位置无所谓
        // 比较器的用法
        // line [0...n) 排序 : 所有小数组，开始位置谁小谁在前
        Arrays.sort(line, 0, n, (a, b) -> a[0] - b[0]);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // i : line[i][0] line[i][1]
            while (size > 0 && heap[0] <= line[i][0]) {
                pop();
            }
            add(line[i][1]);
            ans = Math.max(ans, size);
        }
        return ans;
    }

    // 小根堆，堆顶0位置
    public static int[] heap = new int[MAXN];

    // 堆的大小
    public static int size;

    public static void add(int x) {
        heap[size] = x;
        int i = size++;
        while (heap[i] < heap[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void pop() {
        swap(0, --size);
        int i = 0, l = 1;
        while (l < size) {
            int best = l + 1 < size && heap[l + 1] < heap[l] ? l + 1 : l;
            best = heap[best] < heap[i] ? best : i;
            if (best == i) {
                break;
            }
            swap(i, best);
            i = best;
            l = i * 2 + 1;
        }
    }

    public static void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    // 也找到了leetcode测试链接
    // 测试链接 : https://leetcode.cn/problems/meeting-rooms-ii/
    // 提交如下代码可以直接通过
    public static int minMeetingRooms(int[][] meeting) {
        int n = meeting.length;
        Arrays.sort(meeting, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!heap.isEmpty() && heap.peek() <= meeting[i][0]) {
                heap.poll();
            }
            heap.add(meeting[i][1]);
            ans = Math.max(ans, heap.size());
        }
        return ans;
    }

}
