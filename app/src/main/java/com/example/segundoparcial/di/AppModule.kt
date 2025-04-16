package com.example.segundoparcial.di

import android.content.Context
import com.example.data.LibroRepository
import com.example.data.libro.ILibroLocalDataSource
import com.example.framework.service.RetrofitBuilder
import com.example.data.libro.ILibroRemoteDataSource
import com.example.framework.libros.LibroLocalDataSource
import com.example.framework.libros.LibroRemoteDataSource
import com.example.usecases.GetLibros
import com.example.usecases.GetLibrosBD
import com.example.usecases.SaveLibro
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofitBuilder(@ApplicationContext context: Context): RetrofitBuilder {
        return RetrofitBuilder(context = context)
    }

    @Provides
    @Singleton
    fun provideBookRemoteDataSource(retrofit: RetrofitBuilder): ILibroRemoteDataSource {
        return LibroRemoteDataSource(retrofit)
    }

    @Provides
    @Singleton
    fun provideBookLocalDatasource(@ApplicationContext context: Context): ILibroLocalDataSource {
        return LibroLocalDataSource(context)
    }

    @Provides
    @Singleton
    fun bookRepository(remote: ILibroRemoteDataSource, local: ILibroLocalDataSource): LibroRepository {
        return LibroRepository(remoteDataSource = remote, localDataSource = local)
    }

    @Provides
    @Singleton
    fun provideGetLibros(repo: LibroRepository): GetLibros {
        return GetLibros(repo)
    }

    @Provides
    @Singleton
    fun provideGetLibrosBD(repo: LibroRepository): GetLibrosBD {
        return GetLibrosBD(repo)
    }

    @Provides
    @Singleton
    fun provideSaveLibro(repo: LibroRepository): SaveLibro {
        return SaveLibro(repo)
    }


}