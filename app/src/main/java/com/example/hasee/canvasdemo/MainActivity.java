package com.example.hasee.canvasdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private myView myView;
    private myView2 myView2;
    private CustomView mcustomView;
    private PathDemo pathDemo;
    private RadarView radarView;
    private Bezier2 bezier2;
    private Bezier3 bezier3;
    private Bezier3Demo bezier3Demo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        PieView view = new PieView(this);
//        myView2 = new myView2(this);
//        pathDemo = new PathDemo(this);
//        radarView = new RadarView(this);
//        bezier2 = new Bezier2(this);
//        bezier3 = new Bezier3(this);
//        bezier3Demo = new Bezier3Demo(this);
        setContentView(R.layout.activity_main);

//
//        ArrayList<PieDate> datas = new ArrayList<>();
//        PieDate pieData = new PieDate("sloop", 60);
//        PieDate pieData2 = new PieDate("sloop", 30);
//        PieDate pieData3 = new PieDate("sloop", 40);
//        PieDate pieData4 = new PieDate("sloop", 20);
//        PieDate pieData5 = new PieDate("sloop", 20);
//        datas.add(pieData);
//        datas.add(pieData2);
//        datas.add(pieData3);
//        datas.add(pieData4);
//        datas.add(pieData5);
//        view.setData(datas);
//
//        //测试构造者模式
//
//        //先new接口
//        Builderinterface builderinterface = new ConcreteBuider();
//        //创建构建过程对象
//        Director director = new Director(builderinterface);
//        //创建学生对象
//        Student student = director.createCharacter("笑笑","正太脸","格子衬衣");
//        Log.d("233",student.showMsg());

    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                break;
//            case MotionEvent.ACTION_MOVE:
//                break;
//            case MotionEvent.ACTION_UP:
//                break;
//        }
//        return true;
//    }

    public void text(){
        List array = new ArrayList();
        ListIterator listIterator = array.listIterator();
        AbstractList abstractList = new AbstractList() {
            @Override
            public Object get(int index) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };
    }
    /**
     * 算法题 1
     *给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length;//数组的长度
        int j = 0;//表示数组现在有多少个不一样的数字
        //错误处理
        if (len <= 0){
            return 0;
        }
        if (len == 1){
            return 1;
        }

        for (int i = 0;i < len;i++){
            if (nums[i] != nums[j]){ //当遇到数字不一样的情况时候
                j++;                 //现在数组里面不一样的数子的类型加一
                nums[j] = nums[i];   //然后覆盖
            }
        }
        return j++;//最后因为第一个元素没算，所以要加一

    }
    /**
     * 算法题2 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0||prices.length == 1){
            return 0;
        }
        int maxprofit = 0;
        for(int i = 1;i < prices.length;i++) {
            if (prices[i] - prices[i-1] > 0){
                maxprofit += (prices[i] - prices[i-1]);
            }
        }
        return maxprofit;
    }
    /**
     * 算法题3 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     */
    public int[] rotate(int[] nums, int k) {

        int[] result = new int[nums.length];

        for (int i = 0;i < nums.length;i++){
            result[(i+k) % nums.length] = nums[i];
        }
       return result;

    }
    public void rotate1(int nums[],int k){
        if (k % nums.length == 0 || nums.length == 1){
            return;
        }
        int count = 0;
        k = k % nums.length;
        for(int start = 0;count < nums.length;start++){
            int current = start;
            int p = nums[start];
            do {
                int next = (current + k)%nums.length;
                int temp = nums[next];
                nums[next] = p;
                p = temp;
                count++;
                current = next;
            }while (current != start);
        }
    }
    /**
     * 算法题4 给定一个整数数组，判断是否存在重复元素。
     如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 1){
            return true;
        }
        if (nums.length == 0){
            return false;
        }
        Arrays.sort(nums);
        int flag = 0;
        for (int i = 1;i < nums.length;i++){
            if ((nums[i] - nums[i-1])== 0){
                flag = 1;
                break;
            }
        }
       if (flag == 1){
            return true;
       }else {
            return false;
       }

    }
    /**
     * 题目5 只出现一次的数字
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     说明：
     你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */
    public int singleNumber(int[] nums) {
        int n = 0;
        int k = nums.length;
        if (k == 1){
            return nums[0];
        }
        Arrays.sort(nums);
        if (nums[0] != nums[1]){
            n = nums[0];
        }
        if (nums[k-1] != nums[k-2]){
            n = nums[k-1];
        }
       if (k > 3){
           for (int i = 2;i < k-2;i++){
               if ((nums[i] != nums[i+1])&&(nums[i] != nums[i-1])){
                   n = nums[i];
                   break;
               }
           }
       }
        return n;
    }
    /**
     * 算法题6 两个数组的交集 II
     * 给定两个数组，编写一个函数来计算它们的交集
     */
    public int[] intersect(int[] nums1, int[] nums2) {
      int[] a = new int[99999];
      int[] b = new int[99999];
      Arrays.fill(a,0);
      Arrays.fill(b,0);
      int k = (nums1.length > nums2.length)?nums2.length:nums1.length;
      int[] t = new int[k];
      Arrays.fill(t,0);
      for (int i = 0;i < nums1.length;i++){
          a[nums1[i]] += 1;
      }
      for (int i = 0;i < nums2.length;i++){
          b[nums2[i]] += 1;
      }
      int temp = 0;
      for (int i = 0;i < a.length;i++){
          if (a[i] == b[i] && a[i] != 0 &&b[i] != 0){
              for (int j = 0;i < a[i];i++){
                  t[temp] = i;
                  temp += 1;
              }
          }
          if (a[i] < b[i] && a[i] != 0 &&b[i] != 0){
              for (int j = 0;i < a[i];i++){
                  t[temp] = i;
                  temp += 1;
              }
          }

          if (a[i] > b[i] && a[i] != 0 &&b[i] != 0){
              for (int j = 0;i < b[i];i++){
                  t[temp] = i;
                  temp += 1;
              }
          }
      }
      return t;

    }
    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length){
            if (nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if (nums1[i] < nums2[j]){
                i++;
            }else {
                j++;
            }
        }
        int []temp = new int[list.size()];
        for (int t = 0; t < list.size();t++){
            temp[t] = list.get(t);
        }
        return temp;

    }
    /**
     * 题5 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     你可以假设除了整数 0 之外，这个整数不会以零开头。
     */
    public int[] plusOne(int[] digits) {
        if (digits.length == 1){
            digits[0] += 1;
            return digits;
        }
        int k = digits.length;
        int t = k - 1;
        int num = 0;
        for (int i = 0;i < digits.length;i++){
            num += (digits[i] * (Math.pow(10.0,t)));
            t--;
        }
        num += 1;
        String s = num+"";
        int len = (num+"").length();
        int [] result = new int[len];

        for (int i = 0;i < len;i++){
            int j = (int)s.charAt(i);
            result[i] = j;
        }

        return result;


    }
    public int[] plusOne1(int[] digits){
        if (digits.length == 0 || digits == null){
            return digits;
        }
        if (digits.length == 1){
            digits[0] += 1;
            return digits;
        }
        int c = 1;
        for (int i = digits.length -1;i > 0;i--){
            int temp = digits[i] + c;
            c = temp / 10;
            digits[i] = temp % 10;

            if (c == 0){
                return digits;
            }
        }
        int [] result = new int[digits.length + 1];
        if (c == 1){
            result[0] = c;
        }
        for (int i = 0;i < digits.length;i++){
            result[i+1] = digits[i];
        }
        return result;

    }
    /**
     * 题目6 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     */
    public void moveZeroes(int[] nums) {
        if (nums.length == 0){
            return;
        }

        int num = 0;
        for (int i = 0;i < nums.length;i++){
            if (nums[i] == 0){
                num += 1;
            }
        }
        if (num == 0){
            return;
        }

        for (int i = 0; i < num;i++){
            for (int j = 0;j < nums.length-1-i;j++){
                if (nums[j] == 0){
                    int t = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = t;
                }
            }
        }
    }

    public void moveZeroes1(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                counter++;
            } else {
                nums[i-counter] = nums[i];
                if (counter > 0)
                    nums[i] = 0;
            }
        }
    }
    /***
     * 题目7 两数之和
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2){
            return null;
        }
        int [] result = new int[2];
        for (int i = 0;i < nums.length;i++){
            for (int j = i+1;j < nums.length;j++){
                if ((nums[i] + nums[j]) == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;

    }
    public int[] twoSum1(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length;i++){
            if (map.containsKey(target - nums[i])){
                return new int []{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{0,0};
    }
    /**
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     *数字 1-9 在每一行只能出现一次。
     *数字 1-9 在每一列只能出现一次。
     *数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0;i < 9;i++){
            int[] row = new int[9];
            int[] col = new int[9];
            int[] cuba = new int[9];

            for (int j = 0;j < 9;j++){
                if (board[i][j] != '.'){
                    if (row[board[i][j] - '1'] == 1){
                        return false;
                    }else {
                        row[board[i][j] - '1'] = 1;
                    }
                }

                if (board[j][i]!='.'){
                    if (col[board[j][i] - '1'] == 1){
                        return false;
                    }else {
                        col[board[j][i] - '1'] = 1;
                    }
                }

                int cubeX = 3 * (i / 3) + j / 3;
                int cubeY = 3 * (i % 3) + j % 3;
                if(board[cubeX][cubeY] != '.') {
                    if(cuba[board[cubeX][cubeY] - '1'] == '1') {
                        return false;
                    } else {
                        cuba[board[cubeX][cubeY] - '1'] = 1;
                    }
                }
            }
        }
        return true;

    }

    public boolean isValidSudoku1(char[][] board) {
        //位图法
        //维护三个数组：行，列、宫
        for(int i=0; i<9; i++){
            int[] row = new int[9];
            int[] col = new int[9];
            int[] cube = new int[9];

            for (int j=0; j<9; j++){
                if(board[i][j]!='.'){
                    if(row[board[i][j] - '1'] ==1){
                        return false;
                    }else {
                        row[board[i][j] - '1'] =1;
                    }
                }
                if(board[j][i] != '.'){
                    if(col[board[j][i] - '1'] == 1){
                        return false;
                    }else{
                        col[board[j][i] - '1'] = 1;
                    }
                }
                //每一宫内行列的变换
                int cubeX = 3 * (i/3) + j/3;
                int cubeY = 3 * (i%3) + j%3;
                if(board[cubeX][cubeY]!='.'){
                    if  (cube[board[cubeX][cubeY] - '1'] == 1){
                        return false;
                    }else{
                        cube[board[cubeX][cubeY] - '1'] = 1;
                    }
                }
            }
        }
        return true;
    }
    /**
     * 旋转图像
     *给定一个 n × n 的二维矩阵表示一个图像。
     *将图像顺时针旋转 90 度。
     *说明：
     *你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     */
    //a[i][j]---a[j][n-1-i]--a[n-1-i][n-1-j]---a[n-1-j][i]--a[i][j]
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0;layer < n/2;layer++){
            int start = layer;
            int end = n-1-start;
            for (int i = start;i < end;i++){
                int offset = i - start;
                int t = matrix[start][i];

                matrix[start][i] = matrix[end-offset][start];

                matrix[end-offset][start] = matrix[end][end-offset];

                matrix[end][end-offset] = matrix[i][end];

                matrix[i][end] = t;
            }
        }


    }






}


