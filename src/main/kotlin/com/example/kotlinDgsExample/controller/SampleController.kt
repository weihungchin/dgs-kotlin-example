package com.example.kotlinDgsExample.controller

import com.example.kotlinDgsExample.service.AccountService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController(private val accountService: AccountService) {

    @CrossOrigin()
    @RequestMapping("/api/greet")
    fun helloWorld(): String {
        return "hello cors enabled"
    }

    @RequestMapping("/api/account")
    fun getSampleAccount(): String {
        return this.accountService.getSampleAccount().name
    }
}