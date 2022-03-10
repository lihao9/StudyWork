# DataStore #

## Preferences DataStore ##
以键值对方式存储数据，不需要预定义架构，不确保类型安全

- 集成流程

1、	`implementation("androidx.datastore:datastore-preferences:1.0.0-alpha06")`


- 创建方法
    
		//（1.0.0版本）		
		val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
	
		//1.0.0-alpah版本
		val dataStore: DataStore<Preferences>
        get() = createDataStore(name = "appConfig")

1. 读取方式
		
		//读数据
		val EXAMPLE_COUNTER = intPreferencesKey("example_counter")
		val exampleCounterFlow: Flow<Int> = context.dataStore.data
  		.map { preferences ->
    	// No type safety.
    	preferences[EXAMPLE_COUNTER] ?: 0
		}

		
		//存数据
		context.dataStore.edit { settings ->
    	val currentCounterValue = settings[EXAMPLE_COUNTER] ?: 0
    	settings[EXAMPLE_COUNTER] = currentCounterValue + 1
  		}

## Proto DataStore ##
将数据作为自定义数据类型的实例来存储，要求使用协议缓冲区来定义架构，可以确保类型安全

- 集成过程

1、build.gradle添加 ` implementation("androidx.datastore:datastore-core:1.0.0-alpha04")`

2、预定义协议：build.gradle添加	`implementation  "com.google.protobuf:protobuf-javalite:3.10.0"`

    protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.10.0"
    }

    // Generates the java Protobuf-lite code for the Protobufs in this project. See
    // https://github.com/google/protobuf-gradle-plugin#customizing-protobuf-compilation
    // for more information.
    generateProtoTasks {
        all().each { task ->
            task.builtins {
                java {
                    option 'lite'
                }
            }
        }
    }
	}

在main下新建proto文件夹，新建协议文件[name].proto
    syntax = "proto3";

	option java_package = "com.maotom.data_store.datastore";
	option java_multiple_files = true;

	message AppConfig {
  	// filter for showing / hiding completed tasks
  	bool show_completed = 1;
  	string content = 2;
	}


创建方式：

	`val protoDataStore: DataStore<AppConfig> = createDataStore(fileName = "appProtoConfig",serializer = ConfigSerializer)`

获取数据：
	`protoDataStore.data.map {
            it.content
        }.collect {
            binding.tvShowProtoDataStore.text = it
        }`

存数据：
	
	`protoDataStore.updateData {
            it.toBuilder().setShowCompleted(false).setContent(binding.etInputContent.text.toString().trim()).build()
        }`