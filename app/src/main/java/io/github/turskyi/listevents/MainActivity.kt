package io.github.turskyi.listevents

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    companion object {
        const val LOG_TAG = "myLogs"
    }

    var lvMain: ListView? = null

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lvMain = findViewById<View>(R.id.lv_main) as ListView
        val adapter = ArrayAdapter.createFromResource(
                this, R.array.names, android.R.layout.simple_list_item_1)
        lvMain?.adapter = adapter
        lvMain?.onItemClickListener = OnItemClickListener { _, _, position, id ->
            Log.d(LOG_TAG, "itemClick: position = $position, id = $id")
            Toast.makeText(this, "itemClick: position = $position, id = $id", Toast.LENGTH_LONG).show()
        }
        lvMain?.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                    /* The parent view for the clicked item, in our case a ListView */
                    parent: AdapterView<*>?,
                    /* this is the clicked item, in our case the TextView from android.R.layout.simple_list_item_1 */
                    view: View?,
                    /* number of the item in the list (starting from 0) */
                    position: Int, id: Long) {
//                Log.d(LOG_TAG, "itemSelect: position = $position, id = $id")
//                Toast.makeText(this@MainActivity, "itemSelect: position = $position, id = $id", Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d(LOG_TAG, "itemSelect: nothing")
                Toast.makeText(this@MainActivity, "itemSelect: nothing", Toast.LENGTH_LONG).show()
            }
        }

        lvMain?.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScrollStateChanged(view: AbsListView?, scrollState: Int) {
                Log.d(LOG_TAG, "scrollState = $scrollState")
                Toast.makeText(this@MainActivity, "scrollState = $scrollState", Toast.LENGTH_SHORT).show()
            }

            override fun onScroll(view: AbsListView?, firstVisibleItem: Int,
                                  visibleItemCount: Int, totalItemCount: Int) {
//                Log.d(LOG_TAG, "scroll: firstVisibleItem = " + firstVisibleItem
//                        + ", visibleItemCount" + visibleItemCount
//                        + ", totalItemCount" + totalItemCount)
//
//                Toast.makeText(this@MainActivity, "scroll: firstVisibleItem = " + firstVisibleItem
//                        + ", visibleItemCount" + visibleItemCount
//                        + ", totalItemCount" + totalItemCount, Toast.LENGTH_SHORT).show()
            }
        })
    }
}