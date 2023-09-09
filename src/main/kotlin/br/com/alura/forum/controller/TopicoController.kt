package br.com.alura.forum.controller

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.util.Arrays

@RestController
@RequestMapping("/topicos")
class TopicoController {
    @GetMapping
    fun Listar(): List<Topico> {
        val topico = Topico(
            id = 1,
            titulo = "Example title",
            mensagem = "Test message",
            curso = Curso(
                id = 1,
                nome = "Course 001",
                categoria = "Example"
            ),
            autor = Usuario(
                id = 1,
                nome = "Ana",
                email = "ana@example.com"
            )
        )
        return Arrays.asList(topico, topico, topico)
    }
}