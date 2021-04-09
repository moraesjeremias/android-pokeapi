package com.moraesjeremias.androidPokeapi.core.utils.assets

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.moraesjeremias.androidPokeapi.R
import kotlinx.coroutines.ExperimentalCoroutinesApi

const val DEFAULT_IMAGE = R.drawable.pokeapi



@ExperimentalCoroutinesApi
@Composable
fun LoadPokemonAsset(url: String, @DrawableRes defaultImage: Int): MutableState<Bitmap?> {
    val currentLocalContext = LocalContext.current
    val bitmapState: MutableState<Bitmap?> = mutableStateOf(null)

    Glide.with(currentLocalContext)
        .asBitmap()
        .load(defaultImage)
        .into(object : CustomTarget<Bitmap>() {
            override fun onLoadCleared(placeholder: Drawable?) { }
            override fun onResourceReady(
                resource: Bitmap,
                transition: Transition<in Bitmap>?
            ) {
                bitmapState.value = resource
            }
        })

    Glide.with(currentLocalContext)
        .asBitmap()
        .load(url)
        .into(object : CustomTarget<Bitmap>() {
            override fun onLoadCleared(placeholder: Drawable?) { }
            override fun onResourceReady(
                resource: Bitmap,
                transition: Transition<in Bitmap>?
            ) {
                bitmapState.value = resource
            }
        })

    return bitmapState
}