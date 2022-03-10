# Fragment #
页面中可重用的部分，可定义管理自己的布局，具备自己的生命周期，可处理自己的事件。必须依赖activity存在，其视图层次结构会成为宿主视图结构的一部分（或附加到宿主的视图层次结构中）

## fragment添加方式 ##
- xml直接附加fragment

		<androidx.fragment.app.FragmentContainerView
    	xmlns:android="http://schemas.android.com/apk/res/android"
    	android:id="@+id/fragment_container_view"
   		android:layout_width="match_parent"
    	android:layout_height="match_parent"
    	android:name="com.example.ExampleFragment" />
- 代码动态添加

    	supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<ExampleFragment>(R.id.fragment_container_view)
            }

## FragmentManager ##

FragmentManager负责对应用的fragment进行操作，增加、删除、替换，添加到返回栈

### 获取FragmentManager ###
1. Activity中 getSupportFragmentMagener:获取当前activity的FragmentManager，管理附加在activity上的Fragment
2. Fragment中:

	(1).getChildFragmentManager:获取托管在当前Fragment的fragment的管理器

	(2).getParentFragmentManager:获取当前Fragment所依附的FragmentManager

**一般来说，应用应有应用中少数的Activity组成，其中每个Activity表示一组相关的屏幕，应用中的各个目的地应由fragment表示（Jetpack Navigation）**

### Fragment事务处理 ###

事务具备原子性；事务可以反转；事务可包括任意数量的操作


1. addToBackStack:添加到返回堆栈
2. popBackStack:从堆栈移除

**如果在移除Fragment时没有添加到返回堆栈内会导致fragment被销毁，无法返回到上一个fragment**

**任何时候都只允许一个fragmentManager控制Fragment的返回堆栈**


### 多个返回堆栈 ###
某些情况下，需要支持多个fragment的返回堆栈处理

1. saveBackStack:工作方式类似于使用可选 name 参数的popBackStack方法，弹出指定事务以及堆栈上在此之后的所有事务（会保存弹出事务中所有Fragment的状态）。
**saveBackStack只能调用setReorderingAllowed(true)的事务**

1. restoreBackStack：恢复所有弹出的事务以及所有保存的 fragment 状态


### Fragment通信 ###

1. ViewModel共享数据

	（1）与Activity共享数据

	（2）与Fragment共享数据

**要求共用同一个ViewModel对象**

2. Fragment Result Api

	（1）同级别Fragment之间传递数据（应共用Activity的FragmentManager）
	（2）父子级别Fragment传递数据（应共用父Fragment管理的FragmentManager）
	（3）Fragment与Activity传递数据（应共用Activity管理的FragmentManager）
