package com.example.kotlinDgsExample.datafetcher

import com.example.kotlinDgsExample.service.ShowsService
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.InputArgument
import org.springframework.beans.factory.annotation.Autowired


@DgsComponent
class ShowsDataFetcher {
    @Autowired
    lateinit var showsService: ShowsService

    @DgsData(parentType = "Query", field = "shows")
    fun shows(@InputArgument("titleFilter") titleFilter : String?): List<Show> {
        return if(titleFilter != null) {
            showsService.shows().filter { it.title.contains(titleFilter) }
        } else {
            showsService.shows()
        }
    }

    data class Show(val title: String, val releaseYear: Int)
}