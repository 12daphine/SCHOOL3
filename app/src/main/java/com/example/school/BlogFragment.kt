package com.example.school

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.school.databinding.FragmentBlogBinding
import com.example.school.databinding.FragmentGalleryBinding

class BlogFragment:Fragment() {
    private var _binding: FragmentBlogBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_blog,container,false)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val myWebView: WebView =view.findViewById(R.id.blog_webView)
        myWebView.webViewClient = object : WebViewClient(){

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                url:String
            ): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        myWebView.loadUrl("https://stjohnswakiso.com/blog")
        myWebView.settings.javaScriptEnabled=true
        myWebView.settings.allowContentAccess=true
        myWebView.settings.useWideViewPort=true
        myWebView.settings.domStorageEnabled=true
    }
}

