package com.gugawag.pdist.ejbs;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.gugawag.pdist.model.Mensagem;

import java.util.Arrays;
import java.util.List;

@Stateless(name = "mensagemService")
@Remote
public class MensagemService {
    
    @EJB
    private MensagemDAO mensagemDao;

    public List<Mensagem> listar() {
        return mensagemDao.listar();
    }

    public void inserir(long id, String mensagem) {
        Mensagem novaMensagem = new Mensagem(id, mensagem);
        mensagemDao.inserir(novaMensagem);
        String[] palavroes = {"boquete","caralho","foda","foda-se","foder","fodendo","pica","puta","merda","rapariga","cu","cacete","buceta"};  
        String[] palavras = mensagem.split(" ");
        if (Arrays.asList(palavras).stream().anyMatch(Arrays.asList(palavroes)::contains)) {
            throw new RuntimeException("Mensagem contém palavras de baixo calão");
        }
    }
}
