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
- 监听器绑定 
