package com.android.bookrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class BookListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        // タイトルをセット
        activity?.title = "書籍情報一覧"



        return inflater.inflate(R.layout.fragment_book_list, container, false)
    }
}
