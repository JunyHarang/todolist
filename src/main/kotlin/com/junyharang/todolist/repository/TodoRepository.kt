package com.junyharang.todolist.repository

import org.springframework.data.repository.CrudRepository

// Spring이 가지고 있는 CRUD 레포지토리를 상속 받는데, Entity는 Todo로 하고, Todo의 PK 자료형 Type이 LONG이니 뒤에 LONG을 넣어준다.
interface TodoRepository : CrudRepository<Todo, Long> {}