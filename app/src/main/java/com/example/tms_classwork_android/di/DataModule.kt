package com.example.tms_classwork_android.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.example.tms_classwork_android.data.auth.AuthRepositoryImpl
import com.example.tms_classwork_android.data.items.ItemsRepositoryImpl
import com.example.tms_classwork_android.data.shedpref.SharedPreferencesHelper
import com.example.tms_classwork_android.domain.auth.AuthRepository
import com.example.tms_classwork_android.domain.items.ItemsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds // только в абстрактых классах, используется с интерфейсами
    abstract fun bindItemsRepository(itemsRepositoryImpl: ItemsRepositoryImpl): ItemsRepository

    @Binds
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository


    companion object{
        private const val SP_KEY = "SP_KEY"

        @Provides
        fun provideSharedPreferences(@ApplicationContext context: Context):SharedPreferencesHelper{
            return SharedPreferencesHelper(
                context.getSharedPreferences(SP_KEY, MODE_PRIVATE)
            )
        }
    }
}


