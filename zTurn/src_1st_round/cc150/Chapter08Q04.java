package cc150;

/*
 * Design a parking lot using object-oriented principles.
 * 
 * 通常停车场规模不大,几百个车位了不得了,都是进去沿着固定路线转,直到找到第一个空
位,相当于linear search;

先进的停车场(我想的,没见过)进去的时候可以告诉你哪个位子是空的,适用于很大的停
车场(airport? stadium?),没有固定路线的搜索,这样子的话,最好是在一个array里面存
下来所有的空位,按照离进口的距离来排序一下, priority queue, 里面每个元素存储车
位,包括有key+卫星数据(比如direction from entrance to the spot)

每次爬车的时候,取第一个元素,得到空位; O(1) 查选, O(n) 删除

每次走人的时候,把该车位加回去 queue, 插入合适的位置, 有点慢,需要挪 O(n) 元素


这样的好处是最快速方便顾客查询, 删除和插入都是顾客不care 的,

这个 priority queue 也可以用 bst 来实现, 那就可以让 查询, 删除,插入都是 O(lo
gn) , 更均衡些
 */

public class Chapter08Q04 {

}
