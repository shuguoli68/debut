__Markdown基础语法__
=


一.【标题】
=

说明：=是一级标题，-是二级标题，1-6级标题，对应1-6个#号

一级标题
=

二级标题
-

# 一级
## 二级
### 三级
#### 四级
##### 五级
###### 六级

二.【段落】
=

1、字体说明：一个*或_表示斜体，两个粗体，三个斜粗体

*斜体*
_斜体_  
**粗体**
__粗体__  
***斜粗体***
___斜粗体___  

2、分割线说明：一行中用三个以上的星号、减号、底线来建立一个分隔线，行内不能有其他东西  

***
___
---

3、删除线说明：只需要在文字的两端加上两个波浪线~~

~~删除线~~

4、下划线说明：通过 HTML 的 <u> 标签来实现

<u>下划线</u>  
$\underline{\text{下划线}}$

5、脚注说明：脚注是对文本的补充说明

鼠标放上[^可见]  
[^可见]：我是脚注

三.【列表】
=

无序列表说明：无序列表使用星号(*)、加号(+)或是减号(-)作为列表标记，这些标记后面要添加一个空格，然后再填写内容
* 第一项
* 第二项
* 第三项

+ 第一项
+ 第二项
+ 第三项

- 第一项
- 第二项
- 第三项

有序列表说明：有序列表使用数字并加上 . 号来表示  
1.第一项  
2.第二项  
3.第三项

列表嵌套说明：列表嵌套只需在子列表中的选项前面添加四个空格即可  
1.第一项  
    +a  
	+b  
	+c  
2.第二项  
3.第三项

四.【区块】
=

说明：开头使用 > 符号 ，然后后面紧跟一个空格符号

> 最外层
> > 第一层嵌套
> > > 第二层嵌套

五.【代码】
=

说明：如果是段落上的一个函数或片段的代码可以用反引号把它包起来（`）

`print("abc")`  

代码区块使用 4 个空格或者一个制表符（Tab 键）

	private void test(){
		print("abc")
	}

也可以用 ``` 包裹一段代码，并指定一种语言（也可以不指定）
```
private void test(){
	print("abc")
}
```

六.【链接】
=

说明：[链接名称](链接地址)或者<链接地址>

[百度链接](https://www.baidu.com/)  
<https://www.baidu.com/>  
链接地址为：[Google][url]   
其他内容  
[url]:https://www.baidu.com/

七.【图片】
=

说明：开头一个感叹号，接着一个方括号，里面放上图片的替代文字，接着一个方括号，里面放上图片的替代文字

![一张图片](http://static.runoob.com/images/runoob-logo.png)

指定宽高：  
<img src="http://static.runoob.com/images/runoob-logo.png" width="50" height="60">

八.【表格】
=

说明:用 | 来分隔不同的单元格，使用 - 来分隔表头和其他行  
对齐方式：-: 设置内容和标题栏居右对齐，:- 设置内容和标题栏居左对齐，:-: 设置内容和标题栏居中对齐

|表头1  |表头2   |表头3 |
|:------|:-----:|-----:|
|行1    |行2    |行3    |




__Markdown基础语法__
=


一.【标题】
=

说明：=是一级标题，-是二级标题，1-6级标题，对应1-6个#号

一级标题
=

二级标题
-

# 一级
## 二级
### 三级
#### 四级
##### 五级
###### 六级

二.【段落】
=

1、字体说明：一个*或_表示斜体，两个粗体，三个斜粗体

*斜体*
_斜体_  
**粗体**
__粗体__  
***斜粗体***
___斜粗体___  

2、分割线说明：一行中用三个以上的星号、减号、底线来建立一个分隔线，行内不能有其他东西  

***
___
---

3、删除线说明：只需要在文字的两端加上两个波浪线~~

~~删除线~~

4、下划线说明：通过 HTML 的 <u> 标签来实现

<u>下划线</u>  
$\underline{\text{下划线}}$

5、脚注说明：脚注是对文本的补充说明

鼠标放上[^可见]  
[^可见]：我是脚注

三.【列表】
=

无序列表说明：无序列表使用星号(*)、加号(+)或是减号(-)作为列表标记，这些标记后面要添加一个空格，然后再填写内容
* 第一项
* 第二项
* 第三项

+ 第一项
+ 第二项
+ 第三项

- 第一项
- 第二项
- 第三项

有序列表说明：有序列表使用数字并加上 . 号来表示  
1.第一项  
2.第二项  
3.第三项

列表嵌套说明：列表嵌套只需在子列表中的选项前面添加四个空格即可  
1.第一项  
    +a  
	+b  
	+c  
2.第二项  
3.第三项

四.【区块】
=

说明：开头使用 > 符号 ，然后后面紧跟一个空格符号

> 最外层
> > 第一层嵌套
> > > 第二层嵌套

五.【代码】
=

说明：如果是段落上的一个函数或片段的代码可以用反引号把它包起来（`）

`print("abc")`  

代码区块使用 4 个空格或者一个制表符（Tab 键）

	private void test(){
		print("abc")
	}

也可以用 ``` 包裹一段代码，并指定一种语言（也可以不指定）
```
private void test(){
	print("abc")
}
```

六.【链接】
=

说明：[链接名称](链接地址)或者<链接地址>

[百度链接](https://www.baidu.com/)  
<https://www.baidu.com/>  
链接地址为：[Google][url]   
其他内容  
[url]:https://www.baidu.com/

七.【图片】
=

说明：开头一个感叹号，接着一个方括号，里面放上图片的替代文字，接着一个方括号，里面放上图片的替代文字

![一张图片](http://static.runoob.com/images/runoob-logo.png)

指定宽高：  
<img src="http://static.runoob.com/images/runoob-logo.png" width="50" height="60">

八.【表格】
=

说明:用 | 来分隔不同的单元格，使用 - 来分隔表头和其他行  
对齐方式：-: 设置内容和标题栏居右对齐，:- 设置内容和标题栏居左对齐，:-: 设置内容和标题栏居中对齐

|表头1  |表头2   |表头3 |
|:------|:-----:|-----:|
|行1    |行2    |行3    |




