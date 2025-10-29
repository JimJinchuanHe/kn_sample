#ifndef BIZB_H
#define BIZB_H

#ifdef __cplusplus
extern "C" {
#endif

// 声明 bizB.so 中导出的函数
// bizB_negate 有 @CName 注解，可以直接调用
int bizB_negate(int x);

// addNumbers 是 Kotlin 函数，需要使用完整的修饰名称
// 为了方便使用，我们创建一个别名
int addNumbers_kotlin(int a, int b) __asm__("kfun:#addNumbers(kotlin.Int;kotlin.Int){}kotlin.Int");

#ifdef __cplusplus
}
#endif

#endif // BIZB_H