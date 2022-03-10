# 集合 #

## Collection  ##

### List ###
**有序集合（列表），可以有重复的元素，访问集合中元素可通过下表访问**

1. ArrayList:动态数组（单链表），允许任何符合规则的元素（null）添加,默认初始长度10，随机访问快，非同步
2. LinkList：双向链表，查找慢，提供更快的添加和删除操作
3. Vector：线程安全，和ArrayList类似
4. Stack:继承Vector,提供栈的基本操作


### Set ###
无序集合（插入顺序与输出顺序不同），不可存放重复元素（通过对象的hashCode和eques方法判断两个对象是否相等），通过元素本身来访问

2. HashSet：没有重复元素的集合。按照hash算法存储集合，具有很好的存取和查找性能。元素位置固定
3. LinkHashSet：继承LinkedHashMap，存放顺序还依赖链表维护元素顺序，可以按顺序存取元素
4. TreeSet


### Queue ###

## Map ##
保存key-value键值对的元素，访问时只能通过key来访问value

1. HashMap
2. LinkedHashMap
3. TreeMap