package com.metehanbolat.lazycolumndetailcompose

data class Movies(
    val name: String,
    val year: String,
    val subject: String? = null
) {
    companion object {
        val movies = listOf(
            Movies("Batman", "2004", "Action"),
            Movies("Superman", "1623"),
            Movies("Arog", "1999", "Komedi"),
            Movies("Gora", "3221"),
            Movies("Yıldızlararası", "2006"),
            Movies("Eternal Sunshine", "2012", "Drama"),
            Movies("Düğün Dernek", "2021"),
            Movies("Düğün Dernek", "2021"),
            Movies("Düğün Dernek", "2021"),
            Movies("Düğün Dernek", "2021"),
            Movies("Düğün Dernek", "2021"),
            Movies("Düğün Dernek", "2021", "Korku"),
            Movies("Düğün Dernek", "2021"),
            Movies("Düğün Dernek", "2021"),
            Movies("Düğün Dernek", "2021"),
            Movies("Düğün Dernek", "2021", "Biyografi"),
            Movies("Düğün Dernek", "2021"),
        )
    }
}


