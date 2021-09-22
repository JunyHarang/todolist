package com.junyharang.todolist.repository

import org.hibernate.annotations.ColumnDefault
import javax.persistence.*

// 해당 어노테이션을 보고, Spring Boot가 DB에 todo라는 Table을 만든다.
@Entity
class Todo (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // mariaDB AutoIncreament 사용을 위한 내용
    // 자료형 타입 뒤에 물음표는 NULL이 들어갈 수 있다는 의미(하지만, @Id로 이 컬럼이 PK가 되기 때문에 NULL이 들어갈 수 없다.)
    var id: Long? = null,

    @Column(nullable = false) // null이 들어갈 수 없다.
    @ColumnDefault("false")
    var completed: Boolean = false,

    @Column(nullable = false)
    var todoName: String
)