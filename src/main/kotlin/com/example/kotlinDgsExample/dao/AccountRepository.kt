package com.example.kotlinDgsExample.dao

import com.example.kotlinDgsExample.entities.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository: JpaRepository<AccountEntity, Long> {
}