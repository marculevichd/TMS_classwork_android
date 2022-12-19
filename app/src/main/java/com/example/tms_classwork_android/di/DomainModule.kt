package com.example.tms_classwork_android.di

import com.example.tms_classwork_android.domain.auth.AuthInteractor
import com.example.tms_classwork_android.domain.auth.AuthRepository
import com.example.tms_classwork_android.domain.items.ItemsInteractor
import com.example.tms_classwork_android.domain.items.ItemsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideItemsInteractor(itemsRepository: ItemsRepository): ItemsInteractor {
        return ItemsInteractor(itemsRepository)
    }


    @Provides
    fun provideAuthInteractor(authRepository: AuthRepository): AuthInteractor {
        return AuthInteractor(authRepository)
    }

}