package com.maotom.data_store.proto_data

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException
import com.maotom.data_store.datastore.AppConfig
import com.maotom.data_store.datastore.AppConfig.parseFrom
import java.io.InputStream
import java.io.OutputStream

/**
 *   @author:  Mao Tom
 *   @date:  2022/3/10 0010
 *   @description: todo
 *
 */
object ConfigSerializer : Serializer<AppConfig> {



    override val defaultValue: AppConfig
        get() = AppConfig.getDefaultInstance()

    override fun readFrom(input: InputStream): AppConfig {
        try {
            return parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override fun writeTo(t: AppConfig, output: OutputStream) {
        t.writeTo(output)
    }


}