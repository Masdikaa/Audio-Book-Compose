package com.masdika.audiobookcompose.data.model

import com.masdika.audiobookcompose.R

data class AudioBook(
    val id: String,
    val title: String,
    val author: String,
    val synopsys: String,
    val rating: Double,
    val genre: List<Genre>,
    val imageID: Int,
    val totalDuration: Long
)

val audioBookList = listOf(
    AudioBook(
        id = "1",
        title = "City of Girls",
        author = "Elizabeth Gilbert",
        synopsys = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus porttitor augue pretium enim consequat pulvinar. Proin pretium turpis condimentum tortor fringilla tempor. Quisque porttitor nibh sit amet ipsum accumsan molestie. Phasellus nibh leo, tristique eu cursus nec, commodo sit amet dolor. Integer metus lectus, gravida id dapibus convallis, vestibulum vel sapien. Vivamus luctus neque enim, ac varius massa pharetra eget. Curabitur suscipit nunc risus, sed aliquam neque tincidunt quis. Curabitur posuere in lacus at congue. Suspendisse dignissim imperdiet lectus nec tempor. Vivamus placerat metus enim, at vehicula sem viverra sed. In vitae urna vitae mauris dapibus dictum. Aliquam eget metus commodo, dapibus ex id, dapibus odio. Mauris in rutrum nisl. Nunc ac dolor sodales, ultrices felis non, tempor elit. Suspendisse pretium in quam quis varius.",
        rating = 4.8,
        genre = listOf(
            Genre(genreList[2].name),
            Genre(genreList[3].name)
        ),
        imageID = R.drawable.city_of_girls_elizabeth_gilbert,
        totalDuration = 28800L
    ),
    AudioBook(
        id = "2",
        title = "The Diamond Chariot",
        author = "Boris Akunin",
        synopsys = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus porttitor augue pretium enim consequat pulvinar. Proin pretium turpis condimentum tortor fringilla tempor. Quisque porttitor nibh sit amet ipsum accumsan molestie. Phasellus nibh leo, tristique eu cursus nec, commodo sit amet dolor. Integer metus lectus, gravida id dapibus convallis, vestibulum vel sapien. Vivamus luctus neque enim, ac varius massa pharetra eget. Curabitur suscipit nunc risus, sed aliquam neque tincidunt quis. Curabitur posuere in lacus at congue. Suspendisse dignissim imperdiet lectus nec tempor. Vivamus placerat metus enim, at vehicula sem viverra sed. In vitae urna vitae mauris dapibus dictum. Aliquam eget metus commodo, dapibus ex id, dapibus odio. Mauris in rutrum nisl. Nunc ac dolor sodales, ultrices felis non, tempor elit. Suspendisse pretium in quam quis varius.",
        rating = 4.7,
        genre = listOf(
            Genre(genreList[0].name),
            Genre(genreList[2].name),
            Genre(genreList[7].name)
        ),
        imageID = R.drawable.the_diamond_chariot_boris_akunin,
        totalDuration = 14400L
    ),
    AudioBook(
        id = "3",
        title = "Sapiens: A Brief History of Humankind",
        author = "Yuval Noah Harari",
        synopsys = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus porttitor augue pretium enim consequat pulvinar. Proin pretium turpis condimentum tortor fringilla tempor. Quisque porttitor nibh sit amet ipsum accumsan molestie. Phasellus nibh leo, tristique eu cursus nec, commodo sit amet dolor. Integer metus lectus, gravida id dapibus convallis, vestibulum vel sapien. Vivamus luctus neque enim, ac varius massa pharetra eget. Curabitur suscipit nunc risus, sed aliquam neque tincidunt quis. Curabitur posuere in lacus at congue. Suspendisse dignissim imperdiet lectus nec tempor. Vivamus placerat metus enim, at vehicula sem viverra sed. In vitae urna vitae mauris dapibus dictum. Aliquam eget metus commodo, dapibus ex id, dapibus odio. Mauris in rutrum nisl. Nunc ac dolor sodales, ultrices felis non, tempor elit. Suspendisse pretium in quam quis varius.",
        rating = 4.3,
        genre = listOf(
            Genre(genreList[2].name),
            Genre(genreList[4].name)
        ),
        imageID = R.drawable.sapiens_yuval_noah_harari,
        totalDuration = 18000L
    ),
    AudioBook(
        id = "4",
        title = "There Are Rivers in the Sky",
        author = "Elif Shafak",
        synopsys = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus porttitor augue pretium enim consequat pulvinar. Proin pretium turpis condimentum tortor fringilla tempor. Quisque porttitor nibh sit amet ipsum accumsan molestie. Phasellus nibh leo, tristique eu cursus nec, commodo sit amet dolor. Integer metus lectus, gravida id dapibus convallis, vestibulum vel sapien. Vivamus luctus neque enim, ac varius massa pharetra eget. Curabitur suscipit nunc risus, sed aliquam neque tincidunt quis. Curabitur posuere in lacus at congue. Suspendisse dignissim imperdiet lectus nec tempor. Vivamus placerat metus enim, at vehicula sem viverra sed. In vitae urna vitae mauris dapibus dictum. Aliquam eget metus commodo, dapibus ex id, dapibus odio. Mauris in rutrum nisl. Nunc ac dolor sodales, ultrices felis non, tempor elit. Suspendisse pretium in quam quis varius.",
        rating = 4.4,
        genre = listOf(
            Genre(genreList[2].name)
        ),
        imageID = R.drawable.there_are_river_in_the_sky_elif_shafak,
        totalDuration = 4320L
    ),
    AudioBook(
        id = "5",
        title = "Orbital",
        author = "Samantha Harvey",
        synopsys = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus porttitor augue pretium enim consequat pulvinar. Proin pretium turpis condimentum tortor fringilla tempor. Quisque porttitor nibh sit amet ipsum accumsan molestie. Phasellus nibh leo, tristique eu cursus nec, commodo sit amet dolor. Integer metus lectus, gravida id dapibus convallis, vestibulum vel sapien. Vivamus luctus neque enim, ac varius massa pharetra eget. Curabitur suscipit nunc risus, sed aliquam neque tincidunt quis. Curabitur posuere in lacus at congue. Suspendisse dignissim imperdiet lectus nec tempor. Vivamus placerat metus enim, at vehicula sem viverra sed. In vitae urna vitae mauris dapibus dictum. Aliquam eget metus commodo, dapibus ex id, dapibus odio. Mauris in rutrum nisl. Nunc ac dolor sodales, ultrices felis non, tempor elit. Suspendisse pretium in quam quis varius.",
        rating = 3.6,
        genre = listOf(
            Genre(genreList[1].name),
            Genre(genreList[4].name),
            Genre(genreList[5].name)
        ),
        imageID = R.drawable.orbital_samanta_harvey,
        totalDuration = 20880L
    ),
    AudioBook(
        id = "6",
        title = "Presumed Innocent",
        author = "Scott Turow",
        synopsys = "Hailed as the most suspenseful and compelling novel in decades. Presumed Innocent brings to life our worst nightmare: that of an ordinary citizen facing conviction for the most terrible of all crimes. It's the stunning portrayal of one man's all-too-human, all-consuming fatal attraction for a passionate woman who is not his wife, and the story of how his obsession puts everything he loves and values on trial—including his own life. It's a book that lays bare a shocking world of betrayal and murder, as well as the hidden depths of the human heart. And it will hold you and haunt you ... long after you have reached its shattering conclusion.",
        rating = 4.1,
        genre = listOf(
            Genre(genreList[6].name),
            Genre(genreList[7].name)
        ),
        imageID = R.drawable.presumed_innocent_scott_turow,
        totalDuration = 20880L
    ),
    AudioBook(
        id = "7",
        title = "Last Patient of the Night",
        author = "Gary Gerlacher",
        synopsys = "The death of a nameless young woman in his emergency room spurs physician AJ Docker to seek answers. Together with his policeman friend and a police dog, he sets out on a quest for justice for his lost patient, but he discovers more questions than answers as he delves into the criminal world.\nLast Patient of the Night is an action packed thriller interspersed with lighthearted stories from the emergency room, featuring a cast of interesting characters.\nGary Gerlacher’s experience as an emergency physician lends authenticity to the ER culture. His debut novel is the first in the AJ Docker series, and will leave you turning pages late into the night.",
        rating = 4.2,
        genre = listOf(
            Genre(genreList[6].name)
        ),
        imageID = R.drawable.last_patient_of_the_night_gary_gerlacher,
        totalDuration = 20880L
    ),
)
