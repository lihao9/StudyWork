//package com.maotom.livedata_viewmodule.livedata
//
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//
///**
// *   @author:  Mao Tom
// *   @date:  2022/3/23 0023
// *   @description: todo
// *
// */
//class RecycleData(): PagingSource<Int, User>() {
//
//
//
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
//
//        val page = params.key ?: 1
//        var data = ArrayList<User>()
//        for(i in 0..9){
//            data.add(User().apply {
//                name = "tom"
//                location = "tom"
//                age = (page-1)*10+i
//            })
//        }
//
//
//        return LoadResult.Page(
//            data = data,
//            prevKey = null,
//            nextKey = page+1
//        )
//
//
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
//
//    }
//
//
//}