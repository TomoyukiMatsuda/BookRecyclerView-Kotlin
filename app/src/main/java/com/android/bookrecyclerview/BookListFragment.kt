package com.android.bookrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BookListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_book_list, container, false)

        // タイトルをセット
        activity?.title = "書籍情報一覧"

        // レイアウト要素RecyclerViewを取得
        val bookListRecyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        // LayoutManagerを取得
        val linearLayoutManager = LinearLayoutManager(view.context)
        // ダミーデータをセットしたアダプターを作成
        val adapter = BookListRecyclerViewAdapter(createDummyBookList())

        // linearLayoutManager と adapter をRecyclerViewにセット
        bookListRecyclerView.layoutManager = linearLayoutManager
        bookListRecyclerView.adapter = adapter

        // 一覧画面の各セルの区切り線を作成
        bookListRecyclerView.addItemDecoration(DividerItemDecoration(view.context, linearLayoutManager.orientation))

        // 書籍情報セルのクリック処理
        adapter.setOnBookCellClickListener(
            // インターフェースの再利用は想定しておらず、その場限りでしか使わないためobject式として宣言
            object : BookListRecyclerViewAdapter.OnBookCellClickListener {
                override fun onItemClick(book: Book) {
                    // 書籍データを渡す処理
                    setFragmentResult("bookData", bundleOf(
                        "bookName" to book.name,
                        "bookPrice" to book.price,
                        "bookPurchaseDate" to book.date
                    ))

                    // 画面遷移処理
                    parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.fl_activity_main, BookFragment())
                        .addToBackStack(null)
                        .commit()
                }
            }
        )

        return view
    }

    // サンプルデータ作成メソッド
    private fun createDummyBookList(): MutableList<Book> {
        var bookList: MutableList<Book> = ArrayList()
        var book = Book("Kotlinスタートブック", 2800, "2020/11/24")

        // 20件のダミーデータを登録
        var i = 0
        while (i < 20) {
            i++
            bookList.add(book)
        }
        return bookList
    }
}
