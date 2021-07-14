package com.winthan.shoestore.utils

import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import com.winthan.shoestore.models.ShoeModel

@BindingAdapter("shoes")
fun bindShoe(linearLayout: LinearLayout, shoes: LiveData<MutableList<ShoeModel>>?) {
   val shoeList = shoes?.value ?: emptyList()
   linearLayout.removeAllViews()
   shoeList.mapIndexed { index, shoeModel ->
      UI.generateShoeCard(
         linearLayout,
         shoeModel,
         index == shoeList.size - 1,
         linearLayout.context
      )
   }
}