package com.example.mvvnewapi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import com.example.mvvnewapi.R
import com.example.mvvnewapi.ui.MainActivity
import com.example.mvvnewapi.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article_frament.*

class ArticleFrament() : Fragment(R.layout.fragment_article_frament) {

    lateinit var viewModel: NewsViewModel
    val args: ArticleFramentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity). viewModel
        val article = args.article
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

        fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "Artikel berhasil di save", Snackbar.LENGTH_SHORT).show()
        }
    }
}