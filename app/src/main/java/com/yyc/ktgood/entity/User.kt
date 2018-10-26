package com.yyc.ktgood.entity

import org.greenrobot.greendao.annotation.*

//https://blog.csdn.net/qq_36699930/article/details/81540781
@Entity
class User {
    @Id(autoincrement = true)
    var id: Long? = null
    @NotNull
    @Unique
    var name: String? = null

    @Property(nameInDb = "userage")
    var age: Int = 0

    @Generated(hash = 955858333)
    constructor(id: Long?, @NotNull name: String, age: Int) {
        this.id = id
        this.name = name
        this.age = age
    }

    @Generated(hash = 586692638)
    constructor() {
    }
}
