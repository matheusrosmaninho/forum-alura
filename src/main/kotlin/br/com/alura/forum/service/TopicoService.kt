package br.com.alura.forum.service

import br.com.alura.forum.dto.AtualizacaoTopicoForm
import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.exceptions.NotFoundException
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.Resposta
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Topico não encontrado"
) {
    fun listar(): List<TopicoView> {
        return topicos.stream().map {
            t -> topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        return topicoViewMapper.map(topico)
    }

    fun buscarRespostas(id: Long): List<Resposta> {
        return topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get().respostas
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = topicos.stream().filter{
            t -> t.id == form.id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        val novoTopico = Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            dataCriacao = topico.dataCriacao,
            autor = topico.autor,
            curso = topico.curso,
            status = topico.status,
            respostas = topico.respostas
        )
        topicos = topicos.minus(topico).plus(novoTopico)
        return topicoViewMapper.map(novoTopico)
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter{
                t -> t.id == id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        topicos = topicos.minus(topico)
    }
}