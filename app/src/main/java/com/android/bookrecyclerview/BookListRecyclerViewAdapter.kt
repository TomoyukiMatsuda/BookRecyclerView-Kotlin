package com.android.bookrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class BookListRecyclerViewAdapter (
    private val bookListData: MutableList<Book>)
    : RecyclerView.Adapter<BookListRecyclerViewAdapter.BookListRecyclerViewHolder>() {

    // 画面部品要素を構成するクラスを定義
    // innerを付けないことでstaticなclassとして定義できる（非staticな内部クラスは非推奨）
    class BookListRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // ここではcell_book_list.xmlより各レイアウト要素を取得して変数に格納している
        var bookName: TextView = itemView.findViewById(R.id.tv_book_name)
        var bookPrice: TextView = itemView.findViewById(R.id.tv_book_price)
        var bookPurchaseDate: TextView = itemView.findViewById(R.id.tv_book_purchase_date)
    }

    // 画面部品を保持する自作クラスであるBookListRecyclerViewHolderのオブジェクトを生成するメソッド
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : BookListRecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.cell_book_list, parent, false)
        return BookListRecyclerViewHolder(view)
    }

    // BookListRecyclerViewHolder内の各画面部品に表示したいデータを割り当てるメソッド
    override fun onBindViewHolder(holder: BookListRecyclerViewHolder, position: Int) {
        // positionは表示するリストbookListDataのインデックス番号のようなもの
        val book = bookListData[position]

        // BookListRecyclerViewHolderより取得したレイアウト要素に書籍情報を格納
        holder.bookName.text = book.name
        holder.bookPrice.text = book.price.toString()
        holder.bookPurchaseDate.text = book.date
    }

    // データ件数を返すメソッド
    override fun getItemCount() : Int = bookListData.size
}
