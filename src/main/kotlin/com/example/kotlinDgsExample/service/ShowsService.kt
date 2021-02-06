package com.example.kotlinDgsExample.service

import com.example.kotlinDgsExample.datafetcher.ShowsDataFetcher
import org.springframework.stereotype.Service

interface ShowsService {
    fun shows(): List<ShowsDataFetcher.Show>
}

@Service
class BasicShowsService : ShowsService {
    override fun shows(): List<ShowsDataFetcher.Show> {
        return listOf(
                ShowsDataFetcher.Show("Stranger Things", 2016),
                ShowsDataFetcher.Show("Ozark", 2017),
                ShowsDataFetcher.Show("The Crown", 2016),
                ShowsDataFetcher.Show("Dead to Me", 2019),
                ShowsDataFetcher.Show("Orange is the New Black", 2013)
        )
    }
}