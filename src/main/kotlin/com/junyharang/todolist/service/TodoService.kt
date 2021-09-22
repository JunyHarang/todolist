package com.junyharang.todolist.service

import com.junyharang.todolist.repository.Todo
import com.junyharang.todolist.repository.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
// private으로 상수(val) todo Repository의 자료형 타입 TodoRepository의 기본 생성자를 사용하여 연결
class TodoService (private val todoRepository: TodoRepository) {
    // todoRepository에 findAll(), save()를 사용할 수 있는 이유는 CrudRepository를 상속 받았기 때문

    // 할일 목록 전부 가져오기 기능
    // fun은 function의 약자이고, totoRepository의 findAll Method를 호출하여 할일 목록을 전부 가져와서 getTodos()에 담는다.
    fun getTodos() = todoRepository.findAll()

    // 새로운 할일 추가 기능
    fun insertTodo(todoName: String): Todo = todoRepository.save(Todo(todoName = todoName))

    // 할일을 완성 하는 기능
    fun updateTodo(todoId : Long): Todo { // DB에서 todoID를 가지고 찾아보는데, 있으면 반환하고, 없으면 Null을 반환
        // ID를 찾아서 있으면 해당 ID를 todo에 넣어주고, 없으면 Exception동작
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw Exception()

        // 만약 해당 Method가 호출 되었을 때, 할일이 완료되지 않았다면 완료된 것으로 변경하고, 완료가 되어있다면 완료가 되지 않은 것으로 변경한다.
        todo.completed = !todo.completed

        return todoRepository.save(todo)
    } // updateTodo 끝

    // 할일 삭제 기능
    fun deleteTodo(todoId: Long) = todoRepository.deleteById(todoId)
} // Class 끝