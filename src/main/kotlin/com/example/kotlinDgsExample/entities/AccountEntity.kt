package com.example.kotlinDgsExample.entities

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "accounts")
data class AccountEntity(
		@Id
		@Column(name = "id")
		val id: UUID,

		@Column(name = "name")
		val name: String
)