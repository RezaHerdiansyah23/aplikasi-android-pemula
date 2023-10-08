package com.example.myfilosifisapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Filsuf(
    val name: String,
    val description: String,
    val photo: String
): Parcelable
