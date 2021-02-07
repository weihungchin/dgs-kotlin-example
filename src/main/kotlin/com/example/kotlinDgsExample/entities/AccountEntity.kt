package com.example.kotlinDgsExample.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "accounts")
data class AccountEntity(
        @Id
		@Column(name = "id")
		val id: Long,

		@Column(name = "name")
		val name: String
)