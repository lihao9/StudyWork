# LiveData和ViewModel #

## LiveData ##

一种可观察的数据存储器类，具有生命周期感知能力，这种能力能确保LiveData仅更新处于活跃生命周期状态的组件观察者

### 优势 ###
- 确保界面符合数据状态

livedata准讯观察者模式，当底层数据发成变化时，livedata会通知Observer对象； 观察者从非活跃状态更改为活跃状态时也会收到更新；如果观察者第二次从非活跃状态更改为活跃状态，则只有在自上次变为活跃状态以来值发生了更改时，它才会收到更新。

- 不会发生内存泄露

观察者需要绑定到lifecycle对象，会在器关联的生命周期销毁后自我清理

- 不会因为Activity停止而导致奔溃
- 不需要手动处理生命周期
- 数据能保持最新状态
- 共享资源


### 使用 ###
	
1.创建

	// Create a LiveData with a String
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
	
	2
	// Create the observer which updates the UI.
        val nameObserver = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            nameTextView.text = newName
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.currentName.observe(this, nameObserver)

2.更新

	model.currentName.postValue("")

3.工作流程

- 添加观察者：在主线程添加观察者，LiveData维护一个SafeIterableMap，用于存放<Observer,ObserVerWrapper>;让ObserverOwner添加Observer
- 发送数据:子线程会切换到主线程来发送数据，遍历SafeIterableMap,逐个判断观察这是否处于活动状态；通知处于活动状态的Observer;修改LiveData、ObserverWrapper维护的版本号。