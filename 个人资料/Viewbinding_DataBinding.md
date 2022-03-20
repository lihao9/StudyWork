# ViewBinding、DataBinding #

## ViewBinding ##

集成流程：

    android {
        ...
        viewBinding {
            enabled = true
        }
    }

- activity中使用：

		private lateinit var binding: ResultProfileBinding

    	override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        binding = ResultProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    	}

- Fragment中使用

		private var _binding: ResultProfileBinding? = null
    	// This property is only valid between onCreateView and
    	// onDestroyView.
    	private val binding get() = _binding!!

    	override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    	): View? {
        _binding = ResultProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    	}

    	override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    	}

- adapter、dialog中使用类似

		override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    	}


		class MainViewHolder(binding: ItemMainBinding): RecyclerView.ViewHolder(binding.root) {

    	val tv = binding.tvItemMain

		}


## DataBinding ##

集成流程：

	android {
        ...
        dataBinding {
            enabled = true
        }
    }

使用例子：
	
	<?xml version="1.0" encoding="utf-8"?>
    <layout xmlns:android="http://schemas.android.com/apk/res/android">
       <data>
           **<variable name="user" type="com.example.User"/>**
       </data>
       <LinearLayout
           android:orientation="vertical"
           android:layout_width="match_parent"
           android:layout_height="match_parent">
           <TextView android:layout_width="wrap_content"
               android:layout_height="wrap_content"
               **android:text="@{user.firstName}"/>**
           <TextView android:layout_width="wrap_content"
               android:layout_height="wrap_content"
               **android:text="@{user.lastName}"/>**
       </LinearLayout>
    </layout>


activity中使用

		override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_main)

        binding.user = User("Test", "User")
   	 }

fragment、listView、RecyclerView中使用

	val listItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, viewGroup, false)

### DataBinding表达式语言 ###

1. 算术运算符 + - / * %
2. 字符串连接云算符 +
3. 逻辑运算符 && ||
4. 二元运算符 & | ^
5. 一元运算符 + - ！ ~
6. 移位运算符 >> >>> <<
7. 比较运算符 == > < >= <=(注意，<需要转义为 &lt;)
8. instanceof
9. 分组运算符（）
10. 字面量运算符  字符、字符串、数字、null
11. 类型转换
12. 方法调用
13. 字段访问
14. 数组访问[]
15. 三元运算符 ?:
16. null合并运算符 A ?? B (A不为null取A否者取B)

### 事件绑定 ###

- 方法引用

引用方法签名（方法参数和返回值）需与监听器方法一致，方法引用编译时处理，在绑定数据时创建

	class MyHandlers {
        fun onClickFriend(view: View) { ... }
    }

	<?xml version="1.0" encoding="utf-8"?>
    <layout xmlns:android="http://schemas.android.com/apk/res/android">
       <data>
           <variable name="handlers" type="com.example.MyHandlers"/>
           <variable name="user" type="com.example.User"/>
       </data>
       <LinearLayout
           android:orientation="vertical"
           android:layout_width="match_parent"
           android:layout_height="match_parent">
           <TextView android:layout_width="wrap_content"
               android:layout_height="wrap_content"
               android:text="@{user.firstName}"
               android:onClick="@{handlers::onClickFriend}"/>
       </LinearLayout>
    </layout>

- 监听器绑定 

在事件发生时绑定表达式，方法返回值需要与监听器返回值相匹配  

	class Presenter {
        fun onSaveClick(task: Task){}
    }

	<?xml version="1.0" encoding="utf-8"?>
    <layout xmlns:android="http://schemas.android.com/apk/res/android">
        <data>
            <variable name="task" type="com.android.example.Task" />
            <variable name="presenter" type="com.android.example.Presenter" />
        </data>
        <LinearLayout android:layout_width="match_parent" android:layout_height="match_parent">
            <Button android:layout_width="wrap_content" android:layout_height="wrap_content"
            android:onClick="@{() -> presenter.onSaveClick(task)}" />
        </LinearLayout>
    </layout>
    
可以传递原始监听器的多个参数 

	class Presenter {
        fun onCompletedChanged(task: Task, completed: Boolean){}
    }

	<CheckBox android:layout_width="wrap_content" android:layout_height="wrap_content"
          android:onCheckedChanged="@{(cb, isChecked) -> presenter.completeChanged(task, isChecked)}" />

指定自定义方法名称

	@BindingMethods(value = [
        BindingMethod(
            type = android.widget.ImageView::class,
            attribute = "android:tint",
            method = "setImageTintList")])

此注解与任意类一同使用，tint属性将引用setImageTintList逻辑处理

### databind自定义绑定器 ###

	@BindingAdapter("android:paddingLeft")
    fun setPaddingLeft(view: View, padding: Int) {
        view.setPadding(padding,
                    view.getPaddingTop(),
                    view.getPaddingRight(),
                    view.getPaddingBottom())
    }

参数非常重要。第一个参数用于确定与特性相关的视图类型，第二个参数用于确定在给定特性的绑定表达式中接受的类型；可以
接受多个绑定表达式；当出现绑定表达式冲突时，自定义绑定表达式将会替换库默认的绑定表达式。

	@BindingAdapter(value = ["imageUrl", "placeholder"], requireAll = false)
    fun setImageUrl(imageView: ImageView, url: String?, placeHolder: Drawable?) {
        if (url == null) {
            imageView.setImageDrawable(placeholder);
        } else {
            MyImageLoader.loadInto(imageView, url, placeholder);
        }
    }

requireAll = false:当有任意特性被设置时，将会调用绑定器，不用全部特性设置值



