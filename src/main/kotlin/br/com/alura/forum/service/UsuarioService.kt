package br.com.alura.forum.service

import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(var usuarios: List<Usuario>) {
    init {
        val usuario = Usuario(
            id = 1,
            nome = "José",
            email = "jose@example.com"
        )
        usuarios = listOf(usuario)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream().filter ({
            u -> u.id == id
        }).findFirst().get()
    }

}
