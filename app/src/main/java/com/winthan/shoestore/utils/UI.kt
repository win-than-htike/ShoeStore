package com.winthan.shoestore.utils

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.card.MaterialCardView
import com.winthan.shoestore.R
import com.winthan.shoestore.models.ShoeModel

object UI {

   private fun dp(value: Float, context: Context): Int {
      return TypedValue.applyDimension(
         TypedValue.COMPLEX_UNIT_DIP,
         value,
         context.resources.displayMetrics
      ).toInt()
   }

   private fun createTextView(title: String, context: Context): TextView {
      val titleTv = TextView(context)
      titleTv.setTextColor(Color.BLACK)
      val titlePaddingHorizontal = dp(8f, context)
      val titlePaddingVertical = dp(4f, context)
      titleTv.setPadding(
         titlePaddingHorizontal,
         titlePaddingVertical,
         titlePaddingHorizontal,
         titlePaddingVertical
      )
      val typeface = ResourcesCompat.getFont(context, R.font.roboto)
      titleTv.typeface = typeface
      titleTv.text = title
      return titleTv
   }

   fun generateShoeCard(
      containerView: LinearLayout,
      shoe: ShoeModel,
      isLastIndex: Boolean,
      context: Context
   ) {
      val cardLayoutParams = LinearLayout.LayoutParams(
         LinearLayout.LayoutParams.MATCH_PARENT,
         dp(140f, context)
      )
      val px = dp(16f, context)
      if (isLastIndex) {
         cardLayoutParams.setMargins(px, px, px, px)
      } else {
         cardLayoutParams.setMargins(px, px, px, 0)
      }
      val shoeCard = MaterialCardView(context)
      shoeCard.layoutParams = cardLayoutParams
      val contentLinearLayout = LinearLayout(context)
      contentLinearLayout.orientation = LinearLayout.VERTICAL

      contentLinearLayout.addView(createTextView("Name : ${shoe.title}", context))
      contentLinearLayout.addView(createTextView("Company : ${shoe.company}", context))
      contentLinearLayout.addView(createTextView("Size : ${shoe.shoeSize}", context))
      contentLinearLayout.addView(createTextView("Description : ${shoe.description}", context))
      shoeCard.addView(contentLinearLayout)
      containerView.addView(shoeCard)
   }

}