package br.com.alura.forum.controller

import br.com.alura.forum.dto.NovoTopicoDto
import br.com.alura.forum.model.Resposta
import br.com.alura.forum.model.Topico
import br.com.alura.forum.service.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicoController(private val  service: TopicoService) {
    @GetMapping
    fun Listar(): List<Topico> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Topico {
        return service.buscarPorId(id)
    }

    @GetMapping("{id}/respostas")
    fun buscarRespostasPorTopico(@PathVariable id: Long): List<Resposta> {
        return service.buscarRespostas(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody dto: NovoTopicoDto) {
        service.cadastrar(dto)
    }
}