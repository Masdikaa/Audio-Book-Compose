package com.masdika.audiobookcompose.data.model

import com.masdika.audiobookcompose.R

data class AudioBook(
    val title: String,
    val author: String,
    val synopsys: String,
    val rating: Double,
    val genre: List<Genre>,
    val imageID: Int
)

val audioBookList = listOf(
    AudioBook(
        title = "City of Girls",
        author = "Elizabeth Gilbert",
        synopsys = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus porttitor augue pretium enim consequat pulvinar. Proin pretium turpis condimentum tortor fringilla tempor. Quisque porttitor nibh sit amet ipsum accumsan molestie. Phasellus nibh leo, tristique eu cursus nec, commodo sit amet dolor. Integer metus lectus, gravida id dapibus convallis, vestibulum vel sapien. Vivamus luctus neque enim, ac varius massa pharetra eget. Curabitur suscipit nunc risus, sed aliquam neque tincidunt quis. Curabitur posuere in lacus at congue. Suspendisse dignissim imperdiet lectus nec tempor. Vivamus placerat metus enim, at vehicula sem viverra sed. In vitae urna vitae mauris dapibus dictum. Aliquam eget metus commodo, dapibus ex id, dapibus odio. Mauris in rutrum nisl. Nunc ac dolor sodales, ultrices felis non, tempor elit. Suspendisse pretium in quam quis varius.",
        rating = 4.8,
        genre = listOf(
            Genre(genreList[2].name),
            Genre(genreList[3].name)
        ),
        imageID = R.drawable.ic_launcher_background
    ),
    AudioBook(
        title = "The Diamond Chariot",
        author = "Boris Akunin",
        synopsys = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus porttitor augue pretium enim consequat pulvinar. Proin pretium turpis condimentum tortor fringilla tempor. Quisque porttitor nibh sit amet ipsum accumsan molestie. Phasellus nibh leo, tristique eu cursus nec, commodo sit amet dolor. Integer metus lectus, gravida id dapibus convallis, vestibulum vel sapien. Vivamus luctus neque enim, ac varius massa pharetra eget. Curabitur suscipit nunc risus, sed aliquam neque tincidunt quis. Curabitur posuere in lacus at congue. Suspendisse dignissim imperdiet lectus nec tempor. Vivamus placerat metus enim, at vehicula sem viverra sed. In vitae urna vitae mauris dapibus dictum. Aliquam eget metus commodo, dapibus ex id, dapibus odio. Mauris in rutrum nisl. Nunc ac dolor sodales, ultrices felis non, tempor elit. Suspendisse pretium in quam quis varius.",
        rating = 4.7,
        genre = listOf(
            Genre(genreList[0].name),
            Genre(genreList[2].name),
            Genre(genreList[5].name)
        ),
        imageID = R.drawable.ic_launcher_background
    ),
    AudioBook(
        title = "Sapiens: A Brief History of Humankind",
        author = "Yuval Noah Harari",
        synopsys = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus porttitor augue pretium enim consequat pulvinar. Proin pretium turpis condimentum tortor fringilla tempor. Quisque porttitor nibh sit amet ipsum accumsan molestie. Phasellus nibh leo, tristique eu cursus nec, commodo sit amet dolor. Integer metus lectus, gravida id dapibus convallis, vestibulum vel sapien. Vivamus luctus neque enim, ac varius massa pharetra eget. Curabitur suscipit nunc risus, sed aliquam neque tincidunt quis. Curabitur posuere in lacus at congue. Suspendisse dignissim imperdiet lectus nec tempor. Vivamus placerat metus enim, at vehicula sem viverra sed. In vitae urna vitae mauris dapibus dictum. Aliquam eget metus commodo, dapibus ex id, dapibus odio. Mauris in rutrum nisl. Nunc ac dolor sodales, ultrices felis non, tempor elit. Suspendisse pretium in quam quis varius.",
        rating = 4.3,
        genre = listOf(
            Genre(genreList[2].name),
            Genre(genreList[4].name)
        ),
        imageID = R.drawable.ic_launcher_background
    ),
    AudioBook(
        title = "There Are Rivers in the Sky",
        author = "Elif Shafak",
        synopsys = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus porttitor augue pretium enim consequat pulvinar. Proin pretium turpis condimentum tortor fringilla tempor. Quisque porttitor nibh sit amet ipsum accumsan molestie. Phasellus nibh leo, tristique eu cursus nec, commodo sit amet dolor. Integer metus lectus, gravida id dapibus convallis, vestibulum vel sapien. Vivamus luctus neque enim, ac varius massa pharetra eget. Curabitur suscipit nunc risus, sed aliquam neque tincidunt quis. Curabitur posuere in lacus at congue. Suspendisse dignissim imperdiet lectus nec tempor. Vivamus placerat metus enim, at vehicula sem viverra sed. In vitae urna vitae mauris dapibus dictum. Aliquam eget metus commodo, dapibus ex id, dapibus odio. Mauris in rutrum nisl. Nunc ac dolor sodales, ultrices felis non, tempor elit. Suspendisse pretium in quam quis varius.",
        rating = 4.4,
        genre = listOf(
            Genre(genreList[2].name)
        ),
        imageID = R.drawable.ic_launcher_background
    ),
    AudioBook(
        title = "Orbital",
        author = "Samantha Harvey",
        synopsys = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus porttitor augue pretium enim consequat pulvinar. Proin pretium turpis condimentum tortor fringilla tempor. Quisque porttitor nibh sit amet ipsum accumsan molestie. Phasellus nibh leo, tristique eu cursus nec, commodo sit amet dolor. Integer metus lectus, gravida id dapibus convallis, vestibulum vel sapien. Vivamus luctus neque enim, ac varius massa pharetra eget. Curabitur suscipit nunc risus, sed aliquam neque tincidunt quis. Curabitur posuere in lacus at congue. Suspendisse dignissim imperdiet lectus nec tempor. Vivamus placerat metus enim, at vehicula sem viverra sed. In vitae urna vitae mauris dapibus dictum. Aliquam eget metus commodo, dapibus ex id, dapibus odio. Mauris in rutrum nisl. Nunc ac dolor sodales, ultrices felis non, tempor elit. Suspendisse pretium in quam quis varius.",
        rating = 3.6,
        genre = listOf(
            Genre(genreList[1].name),
            Genre(genreList[4].name),
            Genre(genreList[5].name)
        ),
        imageID = R.drawable.ic_launcher_background
    )
)
