package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService {
    fun listar(): List<Topico> {
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