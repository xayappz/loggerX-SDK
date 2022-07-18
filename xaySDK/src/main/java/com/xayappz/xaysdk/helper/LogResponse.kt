package com.xayappz.xaysdk.helper

data class LogResponse(
    val args: Args,
    val `data`: String,
    val files: Files,
    val form: Form,
    val headers: Headers,
    val json: Any,
    val origin: String,
    val url: String
)