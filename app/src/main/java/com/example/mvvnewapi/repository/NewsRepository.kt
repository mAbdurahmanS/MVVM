package com.example.mvvnewapi.repository

import com.example.mvvnewapi.databse.ArtideDatabase
import com.example.mvvnewapi.model.Article
import com.example.mvvnewapi.network.RetrofitInstance

class NewsRepository( val db: ArtideDatabase) {

    // get semua data untuk di tampilakan breaking news
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchNews(searchQuery, pageNumber)

    // membuat database baru di local Database
    suspend fun upsert (article: Article) = db.getArticleDao().upsert(article)

    //untuk get semua data yang sudah di bookmark
    fun getSavedNews() = db.getArticleDao().getAllArticles()

    // delete database local
    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}