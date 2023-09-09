package br.com.alura.forum.service

import br.com.alura.forum.dto.NovoTopicoDto
import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Resposta
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
) {
    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
    }

    fun buscarRespostas(id: Long): List<Resposta> {
        return topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get().respostas
    }

    fun cadastrar(dto: NovoTopicoDto) {

        val topico = Topico(
            id = topicos.size.toLong() + 1,
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            curso = cursoService.buscarPorId(1),
            autor = usuarioService.buscarPorId(1)
        )

        topicos = topicos.plus(topico)
    }
}