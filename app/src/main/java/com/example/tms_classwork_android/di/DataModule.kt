package com.example.tms_classwork_android.di

import com.example.tms_classwork_android.data.ItemsRepositoryImpl
import com.example.tms_classwork_android.domain.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds // только в абстрактых классах, используется с интерфейсами
    abstract fun bindItemsRepository(itemsRepositoryImpl: ItemsRepositoryImpl): ItemsRepository

}