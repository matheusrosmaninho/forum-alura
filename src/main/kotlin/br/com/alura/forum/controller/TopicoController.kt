package br.com.alura.forum.controller

import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import br.com.alura.forum.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topicos")
class TopicoController(private val  service: TopicoService) {
    @GetMapping
    fun Listar(): List<Topico> {
        return service.listar()
    }
}