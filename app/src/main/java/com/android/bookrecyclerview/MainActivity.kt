package com.android.bookrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // BookListFragment表示処理
        val bookListFragment = BookListFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_activity_main, bookListFragment)
            .addToBackStack(null)
            .commit()
    }
}
