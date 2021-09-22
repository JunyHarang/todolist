package com.junyharang.todolist.controller

// 앞에 DATA는 lombok과 같이 Setter, Getter, ToString 등의 기능을 갖고 있다.
data class TodoRequest (val todoName: String) {}