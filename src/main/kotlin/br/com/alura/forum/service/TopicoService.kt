package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(private var topicos: List<Topico>) {
    init {
        val topico1 = Topico(
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
        val topico2 = Topico(
            id = 2,
            titulo = "Example title2",
            mensagem = "Test message2",
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
        val topico3 = Topico(
            id = 3,
            titulo = "Example title3",
            mensagem = "Test message3",
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
        topicos = listOf(topico1, topico2, topico3)
    }

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter({
            t -> t.id == id
        }).findFirst().get()
    }
}