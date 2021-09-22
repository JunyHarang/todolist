package com.junyharang.todolist.controller

import com.junyharang.todolist.service.TodoService
import org.springframework.web.bind.annotation.*

@RestController @RequestMapping("/todo")
class TodoController(private val todoService: TodoService) {

    @GetMapping fun getTodos() = todoService.getTodos()

    @PostMapping fun insertTodo(@RequestBody todoRequest: TodoRequest) = todoService.insertTodo(todoRequest.todoName)

    // /todo/번호(todo의 ID)를 입력 받으면 해당 Id를 변수로 처리하고, 스프링에서는 todoId(Long Type)을 사용하는데, 서비스에 updateTodo()에 ID값을 전달하여 수정한 뒤 처리
    @PutMapping(path = ["/{todoId}"]) fun updateTodo(@PathVariable("todoId") todoId: Long) = todoService.updateTodo(todoId)

    @DeleteMapping(path = ["/{todoId}"]) fun deleteTodo(@PathVariable("todoId") todoId: Long) = todoService.deleteTodo(todoId)
} // Class 끝