package com.example.algorithm.base.easy

/**
 * @description:给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。

整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/power-of-three
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: tingyuan
 * @date: 2022/4/19
 */
object num_326 {

    @JvmStatic
    fun main(args: Array<String>){
       println(isPowerOfThree(45))
    }

    fun isPowerOfThree(n: Int): Boolean {
        var temp = n
        if (temp == 1) {
            return true
        }
        if (temp == 0) {
            return false
        }
        while (temp != 1) {
           if (temp % 3 == 0) {
               temp /= 3
           } else {
               return false
           }
        }
        return true
    }
}