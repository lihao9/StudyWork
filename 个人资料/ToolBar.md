# Toolbar应用栏 #

应用栏在界面顶部提供一个固定的位置，用于显示当前屏幕的信息和操作

**应用栏的所有权因应用的需求而异，既可以属于Activity也可以属于Fragment**

1. Activity拥有的应用栏：
如果您的应用所有屏幕使用同一应用栏，它始终位于顶部且横跨屏幕宽度，则您Fragment可通过Activity托管。 

*fragment使用Activity的Toolbar*

setHasOptionsMenu告知Activity，自己需要接收应用栏的相关回调，回调顺序由Activity传递到Fragment（当存在多个Fragment时，各个Fragment按添加顺序接收回调，如果某个回调消化了该事件，后面的将不再接收到回调）。

*向Toolbar添加自己的菜单*

重写onCreateOptionsMenu(menu: Menu, inflater: MenuInflater)


1. Fragment拥有的状态栏：直接在布局文件中添