package com.example.kotlinDgsExample.service

import com.example.kotlinDgsExample.dao.AccountRepository
import com.example.kotlinDgsExample.entities.AccountEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountService(private val accountRepository: AccountRepository){

    fun getSampleAccount(): AccountEntity {
        val accountList = this.accountRepository.findAll()
        return accountList[0]
    }
}